<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style/salon.css" rel="stylesheet"> 
    <link rel="shortcut icon" type="image" href="style/flav.jpg"> 
<title>Archives</title>
</head>
<body>
<div>
<%=session.getAttribute("arch") %>
</div>
<div class="footer">
<form  action="choix" method="post">
<input class="bouton" type='submit' value='Retour au salon' name='back'></input>
</form>
</div>
</body>
</html>