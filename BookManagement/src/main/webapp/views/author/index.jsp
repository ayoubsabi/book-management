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
	<h1>Liste des auteurs</h1>

	<a href="/BookManagement/create">Créér un nouvel auteur</a>

    <table class="table">
        <thead>
            <tr>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Nombre de ces livres</th>
                <th>actions</th>
            </tr>
        </thead>
        <tbody>
        	<c:forEach items="${ authors }" var="author">
        		<tr>
	                <td><c:out value='${ author.getLastname() }' /></td>
	                <td><c:out value='${ author.getFirstname() }' /></td>
	                <td><c:out value='${ author.numberOfBooks() }' /></td>
	                <td>
	                    <a href="/BookManagement/show?id=<c:out value='${ author.getId() }'/>">Détails</a>
	                    <a href="/BookManagement/edit?id=<c:out value='${ author.getId() }'/>">Modifier</a>
	                    <form 
	                    	method="post"
	                    	action="/BookManagement/delete"
	                    	onsubmit="return confirm('Are you sure you want to delete this item?');"
	                    	style="display: inline"
	                    >
	                    	<input type="hidden" name="id" value="<c:out value='${ author.getId() }'/>">
						    <button class="btn">Supprimer</button>
						</form>
	                </td>
	            </tr>
        	</c:forEach>
        </tbody>
    </table>
</body>
</html>