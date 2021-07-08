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
	<h1>Author</h1>

    <table class="table">
        <tbody>
            <tr>
                <th>Id</th>
                <td><c:out value='${ author.getId() }' /></td>
            </tr>
            <tr>
                <th>Nom</th>
                <td><c:out value='${ author.getLastname() }' /></td>
            </tr>
            <tr>
                <th>Prénom</th>
                <td><c:out value='${ author.getFirstname() }' /></td>
            </tr>
            <tr>
                <th>Adresse</th>
                <td><c:out value='${ author.getAddress() }' /></td>
            </tr>
            <tr>
                <th>Date de naissance</th>
                <td><c:out value='${ author.getBirthDate() }' /></td>
            </tr>
        </tbody>
    </table>

    <h1>Liste de ces livres</h1>

    <table class="table">
        <thead>
            <tr>
                <th>Nom</th>
                <th>Date de publication</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${ author.getBooks() }" var="book">
        		<tr>
	                <td><c:out value='${ book.getName() }' /></td>
	                <td><c:out value='${ book.getPublishedDate() }' /></td>
	            </tr>
        	</c:forEach>
        </tbody>
    </table>
</body>
</html>