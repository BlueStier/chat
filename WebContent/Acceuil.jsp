<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <link href="style/index.css" rel="stylesheet">
    <link rel="shortcut icon" type="image" href="style/flav.jpg">
    <title>AFPA chat</title>
</head>
<body>
<div id="index">

<div class="header">
<h1>Page d'Acceuil</h1></div>
<div class="conect">
<legend class="creer">Connexion</legend>
<form  action="index" method="post">
<label>Pseudo :</label>
<input type="text" name="pseudo" /><br>
<label>Mot de passe :</label>
<input type="password" name="mdp1" /><br><br><br>
<input class="bouton" type='submit' value='connexion' name='connexion'>
</form>
</div>
<div class="enreg">
<legend class="creer">Creer un compte</legend>
<form  action="index" method="post">
<label>Pseudo :</label>
<input type="text" name="pseudo2" /><br>
<label>Mot de passe :</label>
<input type="password" name="mdp2" /><br>
<label>Confirmation :</label>
<input type="password" name="Cmdp" /><br><br>
<input class="bouton" type='submit' value='créer le compte' name='creer'>
</form>
<br>
<%
if(request.getAttribute("con")!=null){
	out.println(request.getAttribute("con"));
}
if(request.getAttribute("creer")!=null){
	out.println(request.getAttribute("creer"));
}
if(request.getAttribute("mdp")!=null){
	out.println(request.getAttribute("mdp"));
}
if(request.getAttribute("existe")!=null){
	out.println(request.getAttribute("existe"));
}
if(request.getAttribute("erreur")!=null){
	out.println(request.getAttribute("erreur"));
}
%>
<div class="footer">
</div>
</div>
</div>
</body>
</html>