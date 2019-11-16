<?php
  class TestInterface extends PHPUnit_Extensions_SeleniumTestCase
  {
    protected function setUp()
    {
      $this->setBrowser("*chrome");
      $this->setBrowserUrl("http://localhost/");
    }

    public function testMyCase()
    {
      $this->open("/Web/index.php");
      $this->click("id=name");
      $this->type("name=name", "test");
      $this->click("id=mail");
      $this->type("id=mail", "c.miesse@students.ephec.be");
      $this->click("id=name");
      $this->type("id=message", "Ceci est un test");
      $this->click("name=submit");
      $this->assertText("id=conf", "Mail envoyé");
    }
  }
?>
