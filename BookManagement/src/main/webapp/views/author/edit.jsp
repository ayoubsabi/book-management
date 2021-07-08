<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Modifier un auteur</h1>
	
	<form action="/BookManagement/update?id=<c:out value='${ author.getId() }'/>" method="post">
	
		<div>
			<label>Nom:</label>
			<input type="text" name="lastname" value="<c:out value='${ author.getLastname() }'/>">
		</div>
		
		<div>
			<label>Prénom:</label>
			<input type="text" name="firstname" value="<c:out value='${ author.getFirstname() }'/>">
		</div>
		
		<div>
			<label>Date de naissance:</label>
			<input type="date" name="birthDate" value="<c:out value='${ author.getBirthDate() }'/>">
		</div>
		
		<div>
			<label>Adresse:</label>
			<input type="text" name="address" value="<c:out value='${ author.getAddress() }'/>">
		</div>
		
		<div>
			<input type="submit" value="Modifier">
		</div>
	
	</form>
	
</body>
</html>