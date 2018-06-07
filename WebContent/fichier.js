/*fonction qui rafraichi les messages tous les 10 millisecondes*/
$(document).ready(function() {
    $.ajaxSetup({ cache: false }); // adresse une erreur pour Internet explorer et ne rafraichira pas la page 
    setInterval(function() {
      $('#message').load('src\servlets\refresh_message.java');//appel la page refresh_messge
    }, 10); // tous les 10 millisecondes 
  });
  /*fonction qui rafraichi les utilisateurs toutes les 3 secondes*/
  $(document).ready(function() {
    $.ajaxSetup({ cache: false }); // adresse une erreur pour Internet explorer et ne rafraichira pas la page 
    setInterval(function() {
      $('#users').load('refresh_users');//appel la page refresh_user.php pour afficher les utilisateurs
    }, 3000); // toutes 3 les secondes 
  });
  /*fonction qui envoie vers la page de déconnexion après 1 heure pour éviter de laisser une session ouverte indéfiniment*/
  function session(){
          window.location="deconnect.php"; //page de déconnexion
      }
      setTimeout("session()",3600000); //envoyer après 1 heure
  
      /*fonction qui permet de transformer une zone de texte en submit pour envoyer le message en appuyant sur entrée*/
      function validerZoneSaisie(){
      document.getElementById("zonesaisie").submit();
  }