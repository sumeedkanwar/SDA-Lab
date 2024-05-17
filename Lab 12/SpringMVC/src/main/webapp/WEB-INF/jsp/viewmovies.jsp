<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movies List</title>
</head>
<body>

<h1>Movies List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Title</th><th>Rating</th><th>Director</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="movie" items="${list}">   
   <tr>  
   <td>${movie.id}</td>  
   <td>${movie.title}</td>  
   <td>${movie.rating}</td>  
   <td>${movie.director}</td>  
   <td><a href="editmovie/${movie.id}">Edit</a></td>  
   <td><a href="deletemovie/${movie.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="movieform">Add New Movie</a>  

</body>
</html>
