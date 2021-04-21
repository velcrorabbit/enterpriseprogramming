function getRequestObject() {
	if (window.XMLHttpRequest) {
		return (new XMLHttpRequest());
	} else if (window.ActiveXObject) {
		return (new ActiveXObject("Microsoft.XMLHTTP"));
	} else {
		return (null);
	}
}

function getData(resultRegion, filmName, dataType) {
	
	var address = 'http://localhost:8080/AssignmentOne/getFilm?filmName=' 
				+ getValue(filmName) + '&dataType=' + getValue(dataType);
	ajaxFilmResult(address, resultRegion, getValue(dataType));
}

function getAllData(resultRegion, dataType) {
	var address = 'http://localhost:8080/AssignmentOne/getAllFilms?dataType=' + getValue(dataType);
	ajaxFilmResult(address, resultRegion, getValue(dataType));
}

function insertFilm(resultRegion,ID, Title, Year, Director, Cast, Review){
	var address = 'http://localhost:8080/AssignmentOne/insertFilm?ID=' + getValue(ID) 
				+ '&Title=' + getValue(Title)
				+ '&Year=' + getValue(Year) 
				+ '&Director=' + getValue(Director) 
				+ '&Cast=' + getValue(Cast) 
				+ '&Review=' + getValue(Review);
	ajaxQueryResult(address, resultRegion);
}

function deleteFilm(resultRegion, ID){
	var address = "http://localhost:8080/AssignmentOne/deleteFilm?ID=" + getValue(ID);
	ajaxQueryResult(address, resultRegion);
}

function amendFilm(resultRegion, ID, Title, Year, Director, Cast, Review){
	var address = 'http://localhost:8080/AssignmentOne/amendFilm?ID=' + getValue(ID) 
			+ '&Title=' + getValue(Title)
			+ '&Year=' + getValue(Year) 
			+ '&Director=' + getValue(Director) 
			+ '&Cast=' + getValue(Cast) 
			+ '&Review=' + getValue(Review);
	ajaxQueryResult(address, resultRegion);
}

function ajaxQueryResult(address, resultRegion){
	var request = getRequestObject();
	request.onreadystatechange =
		function() {
			showQueryResponse(request,
				resultRegion);
		};
	request.open("GET", address, true);
	request.send(null);
}

function showQueryResponse(request, resultRegion) {
	if ((request.readyState == 4) && (request.status == 200)) {
		var resultHTML = request.responseText;
		htmlInsert(resultRegion, resultHTML);
	}
}

function ajaxFilmResult(address, resultRegion, dataType) {
	var request = getRequestObject();
	request.onreadystatechange =
		function() {
			showResponseFilm(request,
				resultRegion, dataType);
		};
	request.open("GET", address, true);
	request.send(null);
}

function showResponseFilm(request, resultRegion, dataType) {
	if ((request.readyState == 4) && (request.status == 200)) {
		
		var filmHTML;
		if (request.responseText === '<div class="alert alert-warning"><p>No films found using those search terms</p></div>'){
			filmHTML = request.responseText;
		} else {
			filmHTML = getDataByType(request, dataType);
		}
		htmlInsert(resultRegion, filmHTML);
	}
}

function getDataByType(request, dataType){
	
	var filmData;
	var filmHTML;
	if(dataType == "json"){
		filmData = JSON.parse(request.responseText);
		filmHTML = buildJsonTable(filmData);
	} else if (dataType == "xml"){
		filmData = request.responseXML;
		filmHTML = buildXmlTable(filmData);
	} else if (dataType == "text"){
		filmData = request.responseText;
		filmHTML = buildTextTable(filmData);
	}
	
	return filmHTML;
}

// Make an HTTP request to the given address. 
// Display result in the HTML element that has given ID.
// Use POST. 

function ajaxResultPost(address, data, resultRegion) {
	var request = getRequestObject();
	request.onreadystatechange =
		function() {
			showResponseText(request,
				resultRegion);
		};
	request.open("POST", address, true);
	request.setRequestHeader("Content-Type",
		"application/x-www-form-urlencoded");
	request.send(data);
}

// Insert the html data into the element that has the specified id.

function htmlInsert(id, htmlData) {
	document.getElementById(id).innerHTML = htmlData;
}

// Return escaped value of textfield that has given id.
// The builtin "escape" function converts < to &lt;, etc.

function getValue(id) {
	return (escape(document.getElementById(id).value));
}