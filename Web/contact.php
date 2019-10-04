<?php
require_once 'INC/libfunctions.php';

if (isset($_POST['submit'])) {
$name = $_POST['name'];
$subject = $_POST['subject'];
$mailFrom = $_POST['mail'];
$message = $_POST['message'];

$mailTo = "c.miesse@students.ephec.be";
$headers = "From: ".$mailFrom;
$txt = "You have received an e-mail from ".$name.".\n\n".$message;

mail($mailTo, $subject, $txt, $headers);
header("Location: contact.php?mailsend");
}
?>
<!DOCTYPE html>
<html lang=fr dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Happy Dawn</title>
    <link rel="stylesheet" href="CSS/style.css">
  </head>
  <body>
    <?php
     echo getTop();
    ?>

    <h2>Contact</h2>
    <form class="contact-form" action="contact.php" method="post">
      <input type="text" name="name" placeholder="Nom complet"><br>
      <input type="text" name="sujet" placeholder="Sujet"><br>
      <input type="email" name="mail" placeholder="Votre adresse e-mail"><br>
      <textarea name="message" placeholder="Message"></textarea><br>
      <input type="submit" name="submit" value="Envoyer un mail"></input>
    </form>
    <?= getFooter() ?>
  </body>
</html>
