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
    <div id="page-container">
      <div id="content-wrap">
        <?php
         echo getTop();
        ?>

        <h2>Notre projet</h2>
        <p>Nous produisons un réveil grâce auquel vous pourrez être réveillé par une aube artificielle</p>
        <p>Nous produisons un réveil grâce auquel vous pourrez être réveillé par une aube artificielle</p>
        <p>Vous pouvez également être réveillé par une musique choisie.</p>
        <p>Le réveil se connectera également à votre calendrier pour un réveil automatisé en fonction de vos activités</p>
        <p><img src="IMG/reveil.png" id="reveil"alt="réveil"></p>
      </div>
      <?= getFooter() ?>
    </div>


  </body>
</html>
