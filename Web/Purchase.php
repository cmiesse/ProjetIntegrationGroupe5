<?php
    require_once 'INC/FormHandler.php';
    $myForm = new FormHandler;
    $info = null;
    if(isset($_POST['submit'])){
        if($myForm->validatePurchaseForm($_POST['name'], $_POST['mail'], $_POST['quantity'], $_POST['address'], $_POST['city'], $_POST['country'])){
          $to = "contact@happydawn.be"; // this is your Email address
          $from = $_POST['mail']; // this is the sender's Email address
          $nameFrom = utf8_decode($_POST['name']);
          $subject = "Formulaire d'achat";
          $message = $nameFrom . ' souhaiterait achater ' . $_POST['quantity'] . ' réveil(s) \n
           Son adresse est : ' . utf8_decode($_POST['address']) . ' à ' . utf8_decode($_POST['city']). ' en ' . utf8_decode($_POST['country']) . '.\n
           Son adresse mail est ' . $_POST['mail'];
          $headers = "From: " . $from."\n";
          $headers .="Content-type: text/html; charset=utf8\n";
          mail($to,$subject,$message,$headers);
          $info = '<span style="background-color:green;color:black">Formulaire valide <i class="fa fa-check"></i> Mail envoyé</span>';
        }
        else{
            $info ='<span style="background-color:red;color:black">Formulaire non valide</span>';
        }
    }
?>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" href="soleil.ico" />
    <title>HappyDawn - Achat</title>
  </head>
  <body style="background-color:gray">
    <a class="w3-button w3-teal w3-padding-large" href="www.happydawn.be">Retour à l'accueil</a><br>
    <h1 style="margin-left:20px;">Acheter notre réveil</h1>
    <div class="w3-col m7">
      <form class="w3-container w3-card-4 w3-padding-16 w3-white" action="" method="post" style="margin-left:20px;">
        <div class="w3-section">
          <label for="name">Nom</label>
          <input class="w3-input" type="text" name="name" id="name" required>
        </div>
        <div class="w3-section">
          <label for="mail">Email</label>
          <input class="w3-input" type="text" name="mail" id="mail">
        </div>
        <div class="w3-section">
          <label for="quantity">Nombre de réveils (1-10)</label>
          <input class="w3-input" type="number" name="quantity" id="quantity">
        </div>
        <div class="w3-section">
          <label for="address">Adresse (Rue, n°)</label>
          <input class="w3-input" type="text" name="address" id="address" required>
        </div>
        <div class="w3-section">
          <label for="city">Ville</label>
          <input class="w3-input" type="text" name="city" id="city" required>
        </div>
        <div class="w3-section">
          <label for="country">Pays</label>
          <input class="w3-input" type="text" name="country" id="country" required>
        </div>
        <button type="submit" class="w3-button w3-right w3-theme" name="submit">Envoyer</button>
        <?= $info ?>
      </form>
    </div>
  </body>
</html>
