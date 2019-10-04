<?php
function getTop(){
  /**
   *
   * @return string le haut de la page
   *
   */
  return
  "  <header>
    <h1>Happy Dawn</h1>
  </header>

  <nav>
    <ul>
      <li><a href='index.php'>Notre projet</a></li>
      <li><a href='us.php'>Nos membres</a></li>
      <li><a href='app.php'>Télécharger</a></li>
      <li><a href='buy.php'>Commander</a></li>
      <li style='float:right'><a class='active' href='contact.php'>Contact</a></li>
    </ul>
  </nav>";
}

function getFooter(){
  return "<footer><span>EPHEC - 2019-2020 - Groupe 5 - Projet d'intégration</span></footer>";
}
