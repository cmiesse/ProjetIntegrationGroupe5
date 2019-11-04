<?php
use PHPUnit\Framework\TestCase;
require_once '../INC/formHandler.php';

/**
 * Cette classe est la classe de tests de la classe FormHandler
 */
class TestFormHandler extends TestCase
{
    /**
     * Verifie que la méthode validateForm() retourne true dans le cas où
     * nom = 'test'
     * mail = 'test@test.be'
     * message = 'Ceci est un test'
     * @return void
     */
    public function testValidateForm(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateForm('test', 'test@test.be', 'Ceci est un test');  // Exercice

        $this->assertSame(true, $functionResult );   // Assert
    }
}