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
        $newForm = new FormHandler; //  setUp

        $functionResult = $newForm->validateContactForm('test', 'test@test.be', 'Ceci est un test');  // Exercice

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
        $newForm = new FormHandler; //  setUp

        $functionResult = $newForm->validateContactForm(null,null,null);  // Exercice

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
        $newForm = new FormHandler; //  setUp

        $functionResult = $newForm->validateContactForm(null, 'test@test.be', 'Ceci est un test');  // Exercice

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
        $newForm = new FormHandler; //  setUp

        $functionResult = $newForm->validateContactForm('test', null, 'Ceci est un test');  // Exercice

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
        $newForm = new FormHandler; //  setUp

        $functionResult = $newForm->validateContactForm('test', 'test@test.be', null);  // Exercice

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
        $newForm = new FormHandler; //  setUp

        $functionResult = $newForm->validateContactForm('test', 'test+test.be','Ceci est un test');  // Exercice

        $this->assertSame(false, $functionResult );   // Assert
    }

    public function testValidatePurchaseFormAllParametersAndAllValid(){
      $newForm = new FormHandler;
      $functionResult = $newForm->validatePurchaseForm('test', 'test@test.be', 1, 'test', 'test', 'test');
      $this->assertSame(true, $functionResult);
    }

    public function testValidatePurchaseFormNoParameters(){
        $newForm = new FormHandler;
        $functionResult = $newForm->validatePurchaseForm(null, null, null, null, null, null);
        $this->assertSame(false, $functionResult);
    }

    public function testValidatePurchaseFormAllParametersButNameMissing(){
        $newForm = new FormHandler;
        $functionResult = $newForm->validatePurchaseForm(null, 'test@test.be', 1, 'test', 'test', 'test');
        $this->assertSame(false, $functionResult);
    }

    public function testValidatePurchaseFormAllParametersButEmailMissing()
    {
        $newForm = new FormHandler;
        $functionResult = $newForm->validatePurchaseForm('test', null, 1, 'test', 'test', 'test');
        $this->assertSame(false, $functionResult);
    }

    public function testValidatePurchaseFormAllParametersButQuantityMissing()
    {
        $newForm = new FormHandler;
        $functionResult = $newForm->validatePurchaseForm('test', 'test@test.be', null, 'test', 'test', 'test');
        $this->assertSame(false, $functionResult);
    }

    public function testValidatePurchaseFormAllParametersButAddressMissing()
    {
        $newForm = new FormHandler;
        $functionResult = $newForm->validatePurchaseForm('test', 'test@test.be', 1, null, 'test', 'test');
        $this->assertSame(false, $functionResult);
    }

    public function testValidatePurchaseFormAllParametersButCityMissing()
    {
        $newForm = new FormHandler;
        $functionResult = $newForm->validatePurchaseForm('test', 'test@test.be', 1, 'test', null, 'test');
        $this->assertSame(false, $functionResult);
    }

    public function testValidatePurchaseFormAllParametersButCountryMissing()
    {
        $newForm = new FormHandler;
        $functionResult = $newForm->validatePurchaseForm('test', 'test@test.be', 1, 'test', 'test', null);
        $this->assertSame(false, $functionResult);
    }

    public function testValidatePurchaseFormAllParametersButInvalidQuantityLow()
    {
        $newForm = new FormHandler;
        $functionResult = $newForm->validatePurchaseForm('test', 'test@test.be', 0, 'test', 'test', 'test');
        $this->assertSame(false, $functionResult);
    }

    public function testValidatePurchaseFormAllParametersButInvalidQuantityHigh()
    {
        $newForm = new FormHandler;
        $functionResult = $newForm->validatePurchaseForm('test', 'test@test.be', 15, 'test', 'test', 'test');
        $this->assertSame(false, $functionResult);
    }

    public function testValidatePurchaseFormAllParametersButInvalidEmail()
    {
        $newForm = new FormHandler;
        $functionResult = $newForm->validatePurchaseForm('test', 'test+test.be', 1, 'test', 'test', 'test');
        $this->assertSame(false, $functionResult);
    }
}
