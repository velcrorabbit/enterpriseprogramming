<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Amend a Film</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="./scripts/table-builder.js"></script>
<script src="./scripts/ajax-utils.js"></script>
</head>
<body>
<div class="container">
	<form action="#" id="add-new-film">
		<div class="input-group mb-3 input-group-sm">
			<div class="input-group-prepend">
				<span class="input-group-text">ID:</span>
			</div>
			<input type="number" class="form-control" id="ID" name="ID"
				pattern="[0-9]" value=<%= request.getParameter("id")%>>
		</div>
		<div class="input-group mb-3 input-group-sm">
			<div class="input-group-prepend">
				<span class="input-group-text">Title:</span>
			</div>
			<input type="text" class="form-control" id="Title" name="Title" value="<%= request.getParameter("title")%>">
		</div>
		<div class="input-group mb-3 input-group-sm">
			<div class="input-group-prepend">
				<span class="input-group-text">Year:</span>
			</div>
			<input type="number" class="form-control" id="Year" name="Year"
				pattern="[0-9]" maxlength=4 value=<%= request.getParameter("year")%>>
		</div>
		<div class="input-group mb-3 input-group-sm">
			<div class="input-group-prepend">
				<span class="input-group-text">Director:</span>
			</div>
			<input type="text" class="form-control" id="Director" name="Director" value="<%= request.getParameter("director")%>">
		</div>
		<div class="input-group mb-3 input-group-sm">
			<div class="input-group-prepend">
				<span class="input-group-text">Cast:</span>
			</div>
			<input type="text" class="form-control" id="Cast" name="Cast" value="<%= request.getParameter("cast")%>">
		</div>
		<div class="input-group mb-3 input-group-sm">
			<div class="input-group-prepend">
				<span class="input-group-text">Review:</span>
			</div>
			<textarea class="form-control" rows="5" id="Review" name="Review"><%= request.getParameter("review")%></textarea>
		</div>
		<button type="button" class="btn btn-primary"
			onclick='amendFilm("result-message", "ID", "Title", "Year", "Director", "Cast", "Review")'>Update
			Film</button>
	</form>
	<div id="result-message"></div>
	<a href="Index.html"><button type='button' class='btn btn-warning'>Return to Home Page</button></a>
	</div>
</body>
</html>