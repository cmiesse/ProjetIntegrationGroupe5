<?php
require_once 'INC/libfunctions.php';
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

    <h2>Télécharger</h2>
    <p><a href="#"><img src="IMG/download.png"  id="download" alt="Télécharger l'application"></a></p>
    <?= getFooter() ?>
  </body>
</html>
