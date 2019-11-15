<?php
use PHPUnit\Framework\TestCase;
require_once '../INC/FormHandler.php';

/**
 * Cette classe est la classe de tests de la classe FormHandler
 */
class TestFormHandler extends TestCase
{
    /**
     * Verifie que la méthode validateContactForm() retourne true dans le cas où
     * nom = 'test'
     * mail = 'test@test.be'
     * message = 'Ceci est un test'
     * @return void
     */
    public function testvalidateContactFormAllParametersAndValidEmail(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateContactForm('test', 'test@test.be', 'Ceci est un test');  // Exercice

        $this->assertSame(true, $functionResult );   // Assert
    }

    /**
     * Verifie que la méthode validateContactForm() retourne false dans le cas où
     * nom = null
     * mail = null
     * message = null
     * @return void
     */
    public function testvalidateContactFormNoParameters(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateContactForm(null,null,null);  // Exercice

        $this->assertSame(false, $functionResult );   // Assert
    }

    /**
     * Verifie que la méthode validateContactForm() retourne false dans le cas où
     * nom = null
     * mail = 'test@test.be'
     * message = 'Ceci est un test'
     * @return void
     */
    public function testvalidateContactFormAllParametersButNameMissing(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateContactForm(null, 'test@test.be', 'Ceci est un test');  // Exercice

        $this->assertSame(false, $functionResult );   // Assert
    }

    /**
     * Verifie que la méthode validateContactForm() retourne false dans le cas où
     * nom = 'test'
     * mail = null
     * message = 'Ceci est un test'
     * @return void
     */
    public function testvalidateContactFormAllParametersButEmailMissing(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateContactForm('test', null, 'Ceci est un test');  // Exercice

        $this->assertSame(false, $functionResult );   // Assert
    }

    /**
     * Verifie que la méthode validateContactForm() retourne false dans le cas où
     * nom = 'test'
     * mail = 'test@test.be'
     * message = null
     * @return void
     */
    public function testvalidateContactFormAllParametersButMessageMissing(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateContactForm('test', 'test@test.be', null);  // Exercice

        $this->assertSame(false, $functionResult );   // Assert
    }

    /**
     * Verifie que la méthode validateContactForm() retourne false dans le cas où
     * nom = 'test'
     * mail = 'test+test.be'
     * message = 'Ceci est un test'
     * @return void
     */
    public function testvalidateContactFormAllParametersAndWrongEmailFormat(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateContactForm('test', 'test+test.be','Ceci est un test');  // Exercice

        $this->assertSame(false, $functionResult );   // Assert
    }

}
