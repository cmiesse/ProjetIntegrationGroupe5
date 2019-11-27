<?php
    require_once 'INC/FormHandler.php';
    if(isset($_COOKIE['lang'])){
      require_once 'Lang/' . $_COOKIE['lang'] . '-lang.php';
    }
    else {
      require_once 'Lang/fr-lang.php';
      $expire = 365*24*3600;
      setcookie("lang", 'fr', time() + $expire);
    }
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
    $myForm = new FormHandler;
    $info = null;
    if(isset($_POST['submit'])){
        if($myForm->validateContactForm($_POST['name'], $_POST['mail'], $_POST['message'])){
          $to = "contact@happydawn.be"; // this is your Email address
          $from = $_POST['mail']; // this is the sender's Email address
          $nameFrom = utf8_decode($_POST['name']);
          $subject = "Formulaire de contact";
          $message = $nameFrom . " a écrit le message suivant:" . "\n\n" . utf8_decode($_POST['message']);
          $headers = "From: " . $from."\n";
          $headers .="Content-type: text/html; charset=utf8\n";
          mail($to,$subject,$message,$headers);
          $info='<span style="background-color:green;color:black" id="conf">' . TXT_MAIL_SENT .'</span>';
        }
        else{
            $info='<span style="background-color:red;color:black" id="conf">' . TXT_FORM_INVALID .'</span>';
        }
    }
?>
<!DOCTYPE html>
<html>
<title>HappyDawn</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="CSS/w3-min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="JS/w3-min.js">

</script>
<link rel="icon" href="soleil.ico" />
<body id="myPage">
<h1>Page principale - HappyDawn</h1>
<!-- Sidebar on click -->
<nav class="w3-sidebar w3-bar-block w3-white w3-card w3-animate-left w3-xxlarge" style="display:none;z-index:2" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-bar-item w3-button w3-display-topright w3-text-teal">Close
    <i class="fa fa-remove"></i>
  </a>
  <a href="#" class="w3-bar-item w3-button">Link 1</a>
  <a href="#" class="w3-bar-item w3-button">Link 2</a>
  <a href="#" class="w3-bar-item w3-button">Link 3</a>
  <a href="#" class="w3-bar-item w3-button">Link 4</a>
  <a href="#" class="w3-bar-item w3-button">Link 5</a>
</nav>

<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align">

    <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-hover-white w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
    <a href="index.php" class="w3-bar-item w3-button w3-teal"><i class="fa fa-home w3-margin-right"></i>Happy Dawn</a>
    <a href="#team" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><?php echo TXT_TEAM ?></a>
    <a href="#work" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><?php echo TXT_PROJECT ?></a>
    <a href="#pricing" class="w3-bar-item w3-button w3-hide-small w3-hover-white"><?php echo TXT_PRODUCTS ?></a>
    <a href="#contact" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Contact</a>
    <form style="text-align:right;margin-right:20px"action="index.php" method="get">
      <select name="l">
        <option value="fr" <?php if($_COOKIE['lang'] == 'fr'){ echo "selected";}?>>Français</option>
        <option value="en" <?php if($_COOKIE['lang'] == 'en'){ echo "selected";}?>>English</option>
      </select>
      <input value="Go" type="submit">
    </form>
 </div>

  <!-- Navbar on small screens -->
  <div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium">
    <a href="#team" class="w3-bar-item w3-button"><?php echo TXT_TEAM ?></a>
    <a href="#work" class="w3-bar-item w3-button"><?php echo TXT_PROJECT ?></a>
    <a href="#pricing" class="w3-bar-item w3-button"><?php echo TXT_PRODUCTS ?></a>
    <a href="#contact" class="w3-bar-item w3-button">Contact</a>
  </div>
</div>

<!-- Image Header -->
<div class="w3-display-container w3-animate-opacity" id="imageLogo">
  <img src="IMG/dawn.jpg" alt="Aube" style="width:100%;min-height:350px;max-height:600px;">
</div>

<!-- Partie Equipe -->
<div class="w3-container w3-padding-64 w3-center" id="team">
<h2><?php echo TXT_TEAM ?></h2>
<p><?php echo TXT_PRESENTATION_TEAM ?></p>

<div class="w3-row"><br>

<div class="w3-quarter">
  <img src="IMG/nicky.jpg" alt="Nicky Riat" style="width:45%" class="w3-circle w3-hover-opacity">
  <h3>Nicky Riat</h3>
  <p>Product Owner</p>
</div>

<div class="w3-quarter">
  <img src="IMG/clement.jpg" alt="Clément Miesse" style="width:45%" class="w3-circle w3-hover-opacity">
  <h3>Clément Miesse</h3>
  <p>Scrum Master</p>
</div>

<div class="w3-quarter">
  <img src="IMG/arno.jpg" alt="Arno Godart" style="width:45%" class="w3-circle w3-hover-opacity">
  <h3>Arno Godart</h3>
  <p>Development Team</p>
</div>

<div class="w3-quarter">
  <img src="IMG/alexandre.jpg" alt="Alexandre Lefèvre" style="width:45%" class="w3-circle w3-hover-opacity">
  <h3>Alexandre Lefèvre</h3>
  <p>Development Team</p>
</div>

</div>

<div class="w3-row"><br>
  <div class="w3-quarter">
    <img src="IMG/timothy.jpg" alt="Timothy Gilles" style="width:45%" class="w3-circle w3-hover-opacity">
    <h3>Timothy Gilles</h3>
    <p>Development Team</p>
  </div>

  <div class="w3-quarter">
    <img src="IMG/mathias.jpg" alt="Mathias Gassmann" style="width:45%" class="w3-circle w3-hover-opacity">
    <h3>Mathias Gassmann</h3>
    <p>Development Team</p>
  </div>

  <div class="w3-quarter">
    <img src="IMG/gilles.jpg" alt="Gilles Quirynen" style="width:45%" class="w3-circle w3-hover-opacity">
    <h3>Gilles Quirynen</h3>
    <p>Development Team</p>
  </div>
</div>

</div>

<!-- Partie Projet -->
<div class="w3-row-padding w3-padding-64 w3-theme-l1 w3-center" id="work">
  <div class="w3">
    <h2><?php echo TXT_PROJECT ?></h2>
    <p><?php echo TXT_PROJECT_FIRST ?></p>
    <p><?php echo TXT_PROJECT_SECOND ?></p>
    <p><?php echo TXT_PROJECT_THIRD ?></p>
    <p><?php echo TXT_PROJECT_FOURTH ?></p>
    <p><?php echo TXT_PROJECT_FIFTH ?></p>
  </div>
</div>


<!-- Partie Produits -->
<div class="w3-row-padding w3-center w3-padding-64" id="pricing">
    <h2><?php echo TXT_PRODUCTS ?></h2>
    <p><?php echo TXT_BUY_DOWNLOAD ?></p><br>
    <div class="w3-half w3-margin-bottom">
      <ul class="w3-ul w3-border w3-hover-shadow">
        <li class="w3-theme">
          <p class="w3-xlarge"><?php echo TXT_ALARM ?></p>
        </li>
          <li class="w3-padding-16"><img src="IMG/reveil.png" alt="Réveil" style="width:28%"> </li>
        <li class="w3-theme-l5 w3-padding-24">
          <a class="w3-button w3-teal w3-padding-large" href="Purchase.php"><i class="fa fa-check"></i> <?php echo TXT_BUY ?></a>
        </li>
      </ul>
    </div>

    <div class="w3-half w3-margin-bottom">
      <ul class="w3-ul w3-border w3-hover-shadow">
        <li class="w3-theme">
          <p class="w3-xlarge"><?php echo TXT_APP ?></p>
        </li>
        <li class="w3-padding-16"><img src="IMG/download.png" alt="Android" style="width:72%"> </li>

        <li class="w3-theme-l5 w3-padding-24">
          <a class="w3-button w3-teal w3-padding-large" href="https://github.com/cmiesse/ProjetIntegrationGroupe5/tree/master/ApplicationV2"><i class="fa fa-check"></i> <?php echo TXT_DOWNLOAD ?></a>
        </li>
      </ul>
    </div>
</div>

<!-- Partie Contact -->
<div class="w3-container w3-padding-64 w3-theme-l5" id="contact">
  <div class="w3-row">
    <div class="w3-col m5">
    <div class="w3-padding-16"><span class="w3-xlarge w3-border-teal w3-bottombar"><?php echo TXT_CONTACT ?></span></div>
      <h3><?php echo TXT_ADDRESS_SHORT ?></h3>
      <p><i class="fa fa-map-marker w3-text-teal w3-xlarge"></i>&nbsp;&nbsp;Louvain-la-Neuve, BE</p>
      <p><i class="fa fa-envelope-o w3-text-teal w3-xlarge"></i>&nbsp;&nbsp;contact@happydawn.be</p>
    </div>
    <div class="w3-col m7">
      <form class="w3-container w3-card-4 w3-padding-16 w3-white" action="" method="post">
      <div class="w3-section">
        <label for="name"><?php echo TXT_NAME ?></label>
        <input class="w3-input" type="text" name="name" id="name" required>
      </div>
      <div class="w3-section">
        <label for="mail">Email</label>
        <input class="w3-input" type="text" name="mail" id="mail">
      </div>
      <div class="w3-section">
        <label for="message">Message</label>
        <input class="w3-input" type="text" name="message" id="message" required>
      </div>
      <button type="submit" class="w3-button w3-right w3-theme" name="submit" id="envoyer"><?php echo TXT_SEND ?></button>
      <p style="font-size:10px;"><?php echo TXT_DATA_USE ?></p>
      <?= $info ?>
      </form>
    </div>
  </div>
</div>

<!-- Partie Carte/Localisation -->
<div class="w3-display-container w3-animate-opacity" id="carte">
  <img src="IMG/lln.JPG" alt="Ephec" style="width:100%;min-height:350px;max-height:600px;">
</div>

<!-- Pied de page -->
<footer class="w3-container w3-padding-32 w3-theme-d1 w3-center">
  <div style="position:relative;bottom:25px;z-index:1;" class="w3-tooltip w3-right">
   <span class="w3-text w3-padding w3-teal w3-hide-small">Revenir en haut</span>
   <a class="w3-button w3-theme" href="#myPage"><span class="w3-xlarge">
   <i class="fa fa-chevron-circle-up"></i></span></a>
 </div>
  <span class="w3"><?php echo TXT_FOOTER ?></span>

</footer>

</body>
</html>
