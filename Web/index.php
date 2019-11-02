<?php
    require_once 'INC/formHandler.php';
?>
<!DOCTYPE html>
<html>
<title>Happy Dawn</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" href="soleil.ico" />
<body id="myPage">

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
  <a href="#team" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Notre équipe</a>
  <a href="#work" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Notre projet</a>
  <a href="#pricing" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Nos produits</a>
  <a href="#contact" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Contact</a>
 </div>

  <!-- Navbar on small screens -->
  <div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium">
    <a href="#team" class="w3-bar-item w3-button">Notre équipe</a>
    <a href="#work" class="w3-bar-item w3-button">Notre projet</a>
    <a href="#pricing" class="w3-bar-item w3-button">Nos produits</a>
    <a href="#contact" class="w3-bar-item w3-button">Contact</a>
  </div>
</div>

<!-- Image Header -->
<div class="w3-display-container w3-animate-opacity">
  <img src="IMG/dawn.jpg" alt="Aube" style="width:100%;min-height:350px;max-height:600px;">
</div>

<!-- Team Container -->
<div class="w3-container w3-padding-64 w3-center" id="team">
<h2>Notre équipe</h2>
<p>Voici les membres de notre équipe</p>

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

<!-- Work Row -->
<div class="w3-row-padding w3-padding-64 w3-theme-l1 w3-center" id="work">
  <div class="w3">
    <h2>Notre projet</h2>
    <p>Nous produisons un réveil grâce auquel vous pourrez être réveillé par une aube artificielle ainsi que des sons/musiques comme alarme.</p>
    <p>En plus du réveil, notre équipe produit une application mobile pour se connecter et paramétrer l'appareil.</p>
    <p>Les utilisateurs de l'application pourront notamment choisir l'intensité de la lumière de réveil, la musique utilisée, leurs intensités, etc.</p>
    <p>Le réveil se connectera également à votre calendrier pour un réveil automatisé en fonction de vos activités.</p>
    <p>Vous pourrez choisir de combien de temps avant votre premier événement vous voulez être réveillé ou mettre des heures prédéfinies.</p>
  </div>
</div>


<!-- Pricing Row -->
<div class="w3-row-padding w3-center w3-padding-64" id="pricing">
    <h2>Nos produits</h2>
    <p>Acheter et télécharger nos produits</p><br>
    <div class="w3-half w3-margin-bottom">
      <ul class="w3-ul w3-border w3-hover-shadow">
        <li class="w3-theme">
          <p class="w3-xlarge">Le réveil</p>
        </li>
          <li class="w3-padding-16"><img src="IMG/reveil.png" alt="Réveil" style="width:28%"> </li>
        <li class="w3-theme-l5 w3-padding-24">
          <button class="w3-button w3-teal w3-padding-large"><i class="fa fa-check"></i> Acheter</button>
        </li>
      </ul>
    </div>

    <div class="w3-half w3-margin-bottom">
      <ul class="w3-ul w3-border w3-hover-shadow">
        <li class="w3-theme">
          <p class="w3-xlarge">L'application</p>
        </li>
        <li class="w3-padding-16"><img src="IMG/download.png" alt="Android" style="width:72%"> </li>

        <li class="w3-theme-l5 w3-padding-24">
          <button class="w3-button w3-teal w3-padding-large"><i class="fa fa-check"></i> Télécharger</button>
        </li>
      </ul>
    </div>
</div>

<!-- Contact Container -->
<div class="w3-container w3-padding-64 w3-theme-l5" id="contact">
  <div class="w3-row">
    <div class="w3-col m5">
    <div class="w3-padding-16"><span class="w3-xlarge w3-border-teal w3-bottombar">Contactez nous</span></div>
      <h3>Adresse</h3>
      <p><i class="fa fa-map-marker w3-text-teal w3-xlarge"></i>&nbsp;&nbsp;Louvain-la-Neuve, BE</p>
      <p><i class="fa fa-envelope-o w3-text-teal w3-xlarge"></i>&nbsp;&nbsp;contact@happydawn.be</p>
    </div>
    <div class="w3-col m7">
      <form class="w3-container w3-card-4 w3-padding-16 w3-white" action="" method="post">
      <div class="w3-section">
        <label for="name">Nom</label>
        <input class="w3-input" type="text" name="name" id="name" required>
      </div>
      <div class="w3-section">
        <label for="mail">Email</label>
        <input class="w3-input" type="text" name="mail" id="mail" required>
      </div>
      <div class="w3-section">
        <label for="message">Message</label>
        <input class="w3-input" type="text" name="message" id="message" required>
      </div>
      <button type="submit" class="w3-button w3-right w3-theme" name="submit">Envoyer</button>
      <?php
        $myForm = new FormHandler;
        if(isset($_POST['submit'])){
            if($myForm->validateForm($_POST['name'], $_POST['mail'], $_POST['message'])){
                echo 'formulaire valide';
            }
            else{
                echo 'formulaire non valide';
            }
        }
      ?>
      </form>
    </div>
  </div>
</div>

<!-- Image of location/map -->
<div class="w3-display-container w3-animate-opacity">
  <img src="IMG/lln.JPG" alt="Ephec" style="width:100%;min-height:350px;max-height:600px;">
</div>

<!-- Footer -->
<footer class="w3-container w3-padding-32 w3-theme-d1 w3-center">
  <div style="position:relative;bottom:25px;z-index:1;" class="w3-tooltip w3-right">
    <span class="w3-text w3-padding w3-teal w3-hide-small">Revenir en haut</span>
    <a class="w3-button w3-theme" href="#myPage"><span class="w3-xlarge">
    <i class="fa fa-chevron-circle-up"></i></span></a>
  </div>

  <span>EPHEC - 2019-2020 - Groupe 5 - Projet d'intégration</span>


</footer>

<script>
// Script for side navigation
function w3_open() {
  var x = document.getElementById("mySidebar");
  x.style.width = "300px";
  x.style.paddingTop = "10%";
  x.style.display = "block";
}

// Close side navigation
function w3_close() {
  document.getElementById("mySidebar").style.display = "none";
}

// Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else {
    x.className = x.className.replace(" w3-show", "");
  }
}
</script>

</body>
</html>
