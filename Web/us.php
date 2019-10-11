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

            <h2>Nos membres</h2>
            <div class='nos_membres'>
                <div class="membre">
                  <a href="#"><img class="photo_membre" src="IMG/nicky.jpg" alt="Nicky Riat"></a>
                  <p>Nicky Riat</p>
                  <p>Product Owner</p>
                </div>
                <div class="membre">
                  <a href="#"><img class="photo_membre" src="IMG/clement.jpg" alt="Clément Miesse"></a>
                  <p>Clément Miesse</p>
                  <p>Scrum Master</p>
                </div>
                <div class="membre">
                  <a href="#"><img class="photo_membre" src="IMG/arno.jpg" alt="Arno Godart"></a>
                  <p>Arno Godart</p>
                  <p>Development Team</p>
                </div>
                <div class="membre">
                  <a href="#"><img class="photo_membre" src="IMG/alexandre.jpg" alt="Alexandre Lefèvre"></a>
                  <p>Alexandre Lefèvre</p>
                  <p>Development Team</p>
                </div>
                <div class="membre">
                  <a href="#"><img class="photo_membre" src="IMG/timothy.jpg" alt="Timothy Gilles"></a>
                  <p>Timothy Gilles</p>
                  <p>Development Team</p>
                </div>
                <div class="membre">
                  <a href="#"><img class="photo_membre" src="IMG/mathias.jpg" alt="Mathias Gassmann"></a>
                  <p>Mathias Gassmann</p>
                  <p>Development Team</p>
                </div>
                <div class="membre">
                  <a href="#"><img class="photo_membre" src="IMG/gilles.jpg" alt="Gilles Quirynen"></a>
                  <p>Gilles Quirynen</p>
                  <p>Development Team</p>
                </div>

          </div>

        </div>
        <?= getFooter() ?>
    </div>



  </body>
</html>
