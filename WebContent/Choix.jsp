<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
    <link href="style/choix.css" rel="stylesheet">
    <link rel="shortcut icon" type="image" href="flav.jpg">
<title>AFPA chat</title>
</head>
<body>
<div id ="choix">
    <div class ="header">
<form  action="choix" method="post">
<input class="bouton"  type='submit' value='Déconnexion' name='Dec'></input>
</form>
<h1>Bonjour <%= session.getAttribute("pseudo") %></h1><br>
<legend>Choisissez un salon de discussion</legend><br></div>
<!-- on récupère le choix du salon par la session  -->
<form  action="choix" method="post">
<div class ="part1">
<input class="bouton" type='submit' value='Game' name='game'></input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input class="bouton"  type='submit' value='Programmation' name='prog'></input><br><br>
<input class="bouton"  type='submit' value='Sport' name='sport'></input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input class="bouton"  type='submit' value='Santé' name='sante'></input><br><br>
<input class="bouton"  type='submit' value='Pêche' name='peche'></input>
</div>
</form>
</div>

</body>
</html>