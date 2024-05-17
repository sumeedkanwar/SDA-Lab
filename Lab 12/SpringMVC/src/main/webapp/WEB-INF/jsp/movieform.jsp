<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Movie</title>
</head>
<body>
		
<h1>Add New Movie</h1>  
<form:form method="post" action="savemovie">    
    <table >    
        <tr>    
            <td>Title:</td>   
            <td><form:input path="title"  /></td>  
        </tr>    
        <tr>    
            <td>Rating:</td>    
            <td><form:input path="rating" /></td>  
        </tr>   
        <tr>    
            <td>Director:</td>    
            <td><form:input path="director" /></td>  
        </tr>   
        <tr>    
            <td> </td>    
            <td><input type="submit" value="Save" /></td>    
        </tr>    
    </table>    
</form:form>    	
			
</body>
</html>
