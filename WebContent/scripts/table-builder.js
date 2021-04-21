var firstHtml = '<table class="table"><thead class="thead-dark"><th>ID</th><th>Title</th><th>Year</th><th>Director</th><th>Cast</th><th>Review</th><th>Options</th></thead><tbody>';
var endHtml = "</tbody></table>";

function buildJsonTable(films) {
	var tableData='';
	
	for (i = 0; i < films.length; i++){
		tableData += buildJsonRowHTML(films[i]);
	}

	return firstHtml + tableData + endHtml;
}

function buildJsonRowHTML(film) {

	var html = "<tr><td>" + film.id + "</td><td>" + film.title
		+ "</td><td>" + film.year + "</td><td>" + film.director
		+ "</td><td>" + film.cast + "</td><td>" + film.review 
		+ "</td><td><a href='amend-form.jsp?id="+ film.id + "&title="
		+ removeSpacesForURL(film.title) + "&year="+ film.year 
		+ "&director="+ removeSpacesForURL(film.director) +"&cast="
		+ removeSpacesForURL(film.cast) +"&review="+ removeSpacesForURL(film.review) +"'><button type='button' class='btn btn-warning'>"
		+ "Amend</button></a></td></tr>";
	return html;
}

function buildXmlTable(films) {
	var tableData = '';
	var films = films.getElementsByTagName("film");
	
	for (i = 0; i < films.length; i++){
		tableData += buildXmlRowHTML(films[i]);
	}

	return firstHtml + tableData + endHtml;
}

function buildXmlRowHTML(film) {

	var html = "<tr><td>" + film.getElementsByTagName("id")[0].childNodes[0].nodeValue 
		+ "</td><td>" + film.getElementsByTagName("title")[0].childNodes[0].nodeValue
		+ "</td><td>" + film.getElementsByTagName("year")[0].childNodes[0].nodeValue 
		+ "</td><td>" + film.getElementsByTagName("director")[0].childNodes[0].nodeValue
		+ "</td><td>" + film.getElementsByTagName("cast")[0].childNodes[0].nodeValue 
		+ "</td><td>" + film.getElementsByTagName("review")[0].childNodes[0].nodeValue + "</td></tr>";
	return html;
}

function buildTextTable(films) {
	var tableData='';
	var filmsSplit = films.split("\n");
	var filmsArray = new Array(filmsSplit.length-1);
	for (i = 0; i < filmsArray.length; i++){
		filmsArray[i] = filmsSplit[i].split('#');
		tableData += buildTextRowHTML(filmsArray[i]);
	}

	return firstHtml + tableData + endHtml;
}

function buildTextRowHTML(film) {

	var html = "<tr><td>" + film[0]
		+ "</td><td>" + film[1]
		+ "</td><td>" + film[2]
		+ "</td><td>" + film[3]
		+ "</td><td>" + film[4]
		+ "</td><td>" + film[5]
		+ "</td></tr>";
	return html;
}

function removeSpacesForURL(string){
	var urlString = string.replaceAll(" ", "+");
	console.log(urlString);
	return urlString;
}

