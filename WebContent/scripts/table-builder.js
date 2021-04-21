var firstHtml = '<table class="table"><thead class="thead-dark"><th>ID</th><th>Title</th><th>Year</th><th>Director</th><th>Cast</th><th>Review</th><th>Options</th></thead><tbody>';
var endHtml = "</tbody></table>";

function buildJsonTable(films) {
	var tableData='';
	
	for (i = 0; i < films.length; i++){
		tableData += buildJsonRow(films[i]);
	}

	return firstHtml + tableData + endHtml;
}

function buildJsonRow(film) {

	
	var html = buildRowHTML(film.id,
							film.title,
							film.year,
							film.director,
							film.cast,
							film.review)
	return html;
}

function buildXmlTable(films) {
	var tableData = '';
	var films = films.getElementsByTagName("film");
	
	for (i = 0; i < films.length; i++){
		tableData += buildXmlRow(films[i]);
	}

	return firstHtml + tableData + endHtml;
}

function buildXmlRow(film) {

	var html = buildRowHTML(film.getElementsByTagName("id")[0].childNodes[0].nodeValue,
							film.getElementsByTagName("title")[0].childNodes[0].nodeValue,
							film.getElementsByTagName("year")[0].childNodes[0].nodeValue,
							film.getElementsByTagName("director")[0].childNodes[0].nodeValue,
							film.getElementsByTagName("cast")[0].childNodes[0].nodeValue,
							film.getElementsByTagName("review")[0].childNodes[0].nodeValue);
	return html;
}

function buildTextTable(films) {
	var tableData='';
	var filmsSplit = films.split("\n");
	var filmsArray = new Array(filmsSplit.length-1);
	for (i = 0; i < filmsArray.length; i++){
		filmsArray[i] = filmsSplit[i].split('#');
		tableData += buildTextRow(filmsArray[i]);
	}

	return firstHtml + tableData + endHtml;
}

function buildTextRow(film) {

	var html = buildRowHTML(film[0],
							film[1],
							film[2],
							film[3],
							film[4],
							film[5]);
	return html;
}

function buildRowHTML(id, title, year, director, cast, review) {
	
	var html = "<tr><td>" + id 
		+ "</td><td>" + title
		+ "</td><td>" + year
		+ "</td><td>" + director
		+ "</td><td>" + cast
		+ "</td><td>" + review
		+ "</td><td><a href='amend-form.jsp?id="+ id + "&title="
		+ removeSpacesForURL(title) + "&year="+ year 
		+ "&director="+ removeSpacesForURL(director) +"&cast="
		+ removeSpacesForURL(cast) +"&review="+ removeSpacesForURL(review)
		+ "''><button type='button' class='btn btn-warning'>"
		+ "Amend</button></a></td></tr>";
	return html;
}

function removeSpacesForURL(string){
	var urlString = string.replaceAll(" ", "+");
	console.log(urlString);
	return urlString;
}

