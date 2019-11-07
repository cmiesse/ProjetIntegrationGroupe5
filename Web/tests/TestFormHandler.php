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
    public function testValidateFormAllParametersAndValidEmail(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateForm('test', 'test@test.be', 'Ceci est un test');  // Exercice

        $this->assertSame(true, $functionResult );   // Assert
    }

    /**
     * Verifie que la méthode validateForm() retourne false dans le cas où
     * nom = null
     * mail = null
     * message = null
     * @return void
     */
    public function testValidateFormNoParameters(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateForm(null,null,null);  // Exercice

        $this->assertSame(false, $functionResult );   // Assert
    }

    /**
     * Verifie que la méthode validateForm() retourne false dans le cas où
     * nom = null
     * mail = 'test@test.be'
     * message = 'Ceci est un test'
     * @return void
     */
    public function testValidateFormAllParametersButNameMissing(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateForm(null, 'test@test.be', 'Ceci est un test');  // Exercice

        $this->assertSame(false, $functionResult );   // Assert
    }

    /**
     * Verifie que la méthode validateForm() retourne false dans le cas où
     * nom = 'test'
     * mail = null
     * message = 'Ceci est un test'
     * @return void
     */
    public function testValidateFormAllParametersButEmailMissing(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateForm('test', null, 'Ceci est un test');  // Exercice

        $this->assertSame(false, $functionResult );   // Assert
    }

    /**
     * Verifie que la méthode validateForm() retourne false dans le cas où
     * nom = 'test'
     * mail = 'test@test.be'
     * message = null
     * @return void
     */
    public function testValidateFormAllParametersButMessageMissing(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateForm('test', 'test@test.be', null);  // Exercice

        $this->assertSame(false, $functionResult );   // Assert
    }

    /**
     * Verifie que la méthode validateForm() retourne false dans le cas où
     * nom = 'test'
     * mail = 'test+test.be'
     * message = 'Ceci est un test'
     * @return void
     */
    public function testValidateFormAllParametersAndWrongEmailFormat(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateForm('test', 'test+test.be','Ceci est un test');  // Exercice

        $this->assertSame(false, $functionResult );   // Assert
    }

}