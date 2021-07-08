<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Créér un auteur</h1>
	
	<form action="/BookManagement/store" method="post">
	
		<div>
			<label>Nom:</label>
			<input type="text" name="lastname">
		</div>
		
		<div>
			<label>Prénom:</label>
			<input type="text" name="firstname">
		</div>
		
		<div>
			<label>Date de naissance:</label>
			<input type="date" name="birthDate">
		</div>
		
		<div>
			<label>Adresse:</label>
			<input type="text" name="address">
		</div>
		
		<div>
			<input type="submit" value="Créér">
		</div>
	
	</form>
	
</body>
</html>