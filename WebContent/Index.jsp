<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.*"%>
<%@ page import="controller.*"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Film Database</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="./scripts/ajax-utils.js" type="text/javascript"></script>
<script src="./scripts/showData.js" type="text/javascript"></script>
</head>
<body>
	<h1>Film Database</h1>
	<h2>Find all films</h2>
	<form>
		<label for="dataType">Data Type:</label>
		<select id="dataType" name="dataType">
			<option value="xml" selected="selected">XML</option>
			<option value="json">JSON</option>
			<option value="text">Text</option>
		</select>
		<input type="submit" onClick='showAllFilmsByDataType("dataType", "all-film-list")'>
	</form>
	<div id="all-film-list"></div>
	<h2>Search by name</h2>
	<form action="./getFilm">
		<label for="filmName">Name:</label>
		<input type="text" id="filmName" name="filmName">
		<label for="dataType">Data Type:</label>
		<select id="dataType" name="dataType">
			<option value="xml" selected="selected">XML</option>
			<option value="json">JSON</option>
			<option value="text">Text</option>
		</select>
		<input type="submit">
	</form>
	<h2>Add a new film</h2>
	<form action="./insertFilm">
		<label for="ID">ID:</label>
		<input type="text" id="ID" name="ID"><br />
		<label for="Title">Title:</label>
		<input type="text" id="Title" name="Title"><br />
		<label for="Year">Year:</label>
		<input type="text" id="Year" name="Year"><br />
		<label for="Director">Director:</label>
		<input type="text" id="Director" name="Director"><br />
		<label for="Cast">Cast:</label>
		<input type="text" id="Cast" name="Cast"><br />
		<label for="Review">Review:</label>
		<input type="text" id="Review" name="Review"><br />
		<input type="submit">
	</form>
	<h2>Delete a film</h2>
	<form action="./deleteFilm">
		<label for="ID">ID:</label>
		<input type="text" id="ID" name="ID"><br />
		<input type="submit">
	</form>
</body>
</html>