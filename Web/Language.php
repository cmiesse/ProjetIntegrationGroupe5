<?php
if(isset($_GET['l'])) {

   $lang = $_GET['l'];

   //même système que tout à l'heure :
   //On définit la durée du cookie (avant son expiration)
   $expire = 365*24*3600;

   //Puis on créé le cookie
   setcookie("lang", $lang, time() + $expire);
   //Puis on redirige vers l'accueil
   header('Location: index.php');

}
?>
<!DOCTYPE html>
<html lang="fr">
<body>
  <br>
  <br>
  Choississez votre langue :<br />
  Choose your langage :<br />
  <form method="get" action="Language.php">
    <select name="l">
      <option value="fr" selected="selected">Français</option>
      <option value="en">English</option>
    </select>
    <input value="Go" type="submit">
  </form>
</body>
</html>
