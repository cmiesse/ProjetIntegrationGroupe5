<?php
use PHPUnit\Framework\TestCase;
require_once '../INC/formHandler.php';

class TestFormHandler extends TestCase
{
    public function testValidateForm(){
        $object = new formHandler; //  setUp

        $functionResult = $object->validateForm('test', 'test@test.be', 'Ceci est un test');  // Exercice

        $this->assertSame(true, $functionResult );   // Assert
    }
}