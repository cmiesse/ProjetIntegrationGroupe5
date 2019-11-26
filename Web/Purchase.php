<?php
    require_once 'INC/FormHandler.php';
    require_once 'Lang/' . $_COOKIE['lang'] . '-lang.php';
    $myForm = new FormHandler;
    $info = null;
    if(isset($_POST['submit'])){
        if($myForm->validatePurchaseForm($_POST['name'], $_POST['mail'], $_POST['quantity'], $_POST['address'], $_POST['city'], $_POST['country'])){
          $to = "contact@happydawn.be"; // this is your Email address
          $from = $_POST['mail']; // this is the sender's Email address
          $nameFrom = $_POST['name'];
          $subject = "Formulaire d'achat";
          $message = $nameFrom . " souhaiterait acheter " . $_POST['quantity'] . " réveil(s).\n
           Son adresse est : " . $_POST['address'] . " à " . $_POST['city']. " en " . $_POST['country'] . ".\n
           Son adresse mail est " . $_POST['mail'];
          $headers = "From: " . $from."\n";
          $headers .="Content-type: text/html; charset=utf8\n";
          mail($to,$subject,$message,$headers);
          $info = '<span style="background-color:green;color:black">Formulaire valide <i class="fa fa-check"></i> ' . TXT_MAIL_SENT .'</span>';
        }
        else{
            $info ='<span style="background-color:red;color:black">' . TXT_FORM_INVALID .'</span>';
        }
    }
?>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="CSS/w3.css">
    <link rel="icon" href="soleil.ico" />
    <title><?php echo TXT_TITLE_BUY ?></title>
  </head>
  <body style="background-color:gray">
    <a class="w3-button w3-teal w3-padding-large" href="index.php"><?php echo TXT_HOME_BUTTON ?></a><br>
    <h1 style="margin-left:20px;"><?php echo TXT_BUY_CLOCK ?></h1>
    <div class="w3-col m7">
      <form class="w3-container w3-card-4 w3-padding-16 w3-white" action="" method="post" style="margin-left:20px;">
        <div class="w3-section">
          <label for="name"><?php echo TXT_NAME ?></label>
          <input class="w3-input" type="text" name="name" id="name" required>
        </div>
        <div class="w3-section">
          <label for="mail">Email</label>
          <input class="w3-input" type="text" name="mail" id="mail">
        </div>
        <div class="w3-section">
          <label for="quantity"><?php echo TXT_NUMBER_CLOCK ?></label>
          <input class="w3-input" type="number" name="quantity" id="quantity">
        </div>
        <div class="w3-section">
          <label for="address"><?php echo TXT_ADDRESS ?></label>
          <input class="w3-input" type="text" name="address" id="address" required>
        </div>
        <div class="w3-section">
          <label for="city"><?php echo TXT_CITY ?></label>
          <input class="w3-input" type="text" name="city" id="city" required>
        </div>
        <div class="w3-section">
          <label for="country"><?php echo TXT_COUNTRY ?></label>
          <input class="w3-input" type="text" name="country" id="country" required>
        </div>
        <button type="submit" class="w3-button w3-right w3-theme" name="submit"><?php echo TXT_SEND ?></button>
        <?= $info ?>
      </form>
    </div>
  </body>
</html>
