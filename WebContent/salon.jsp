<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link href="style/salon.css" rel="stylesheet"> 
    <link rel="shortcut icon" type="image" href="style/flav.jpg"> 
    <script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.0/jquery.min.js"></script>
<script type="text/javascript">	
	$(document).ready(function() {
	    $.ajaxSetup({ cache: false }); // adresse une erreur pour Internet explorer et ne rafraichira pas la page 
	    setInterval(function() {
	      $('#message').load('refresh_message');//appel la page refresh_message
	    }, 10); // tous les 10 millisecondes 
	  });
	$(document).ready(function() {
	    $.ajaxSetup({ cache: false }); // adresse une erreur pour Internet explorer et ne rafraichira pas la page 
	    setInterval(function() {
	      $('#users').load('refresh_user');//appel la page refresh_user
	    }, 1000); // tous les 10 millisecondes 
	  });
</script>   

    <title>AFPA chat</title>
</head>
<body>
    <div id="salon">
        <div class="header">
<form  action="choix" method="post">
<input class="bouton" type='submit' value='Déconnexion' name='Dec'></input>
Bonjour <%= session.getAttribute("pseudo") %> Salon : <%= session.getAttribute("salon") %>;
<input class="bouton" type='submit' value='Archives' name='arc'></input><br><br><br>
</form>
</div>
<div class ="mess">
<fieldset>
<legend>Messages :</legend>
<div id="message">
</div>
</fieldset>
</div>

<div class="user">
<fieldset>
<legend>Utilisateurs connectés :</legend>
<div id="users">
</div>
</fieldset>
</div>
<div>
</div>
<div class="quit">
<form  action="choix" method="post">
<input class="bouton" type='submit' value='Quitter ce salon' name='quit'></input></form>
</div>
</div>
</body>
</html>