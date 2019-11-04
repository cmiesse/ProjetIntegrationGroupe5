<?php

/**
 * Cette classe s'occupe de la manipulation de formulaires
 */
  class FormHandler
  {
      /**
       * Vérifie que les 3 parametres sont remplis et que l'email a le bon format
       * Retourne true si conditions remplies et false sinon
       * @param string $nom le nom du contact
       * @param string $mail l'adresse email du contact
       * @param string $message le message de l'email
       * @return boolean
       */
      public function validateForm($nom, $mail, $message)
      {
          if (isset($nom) && isset($mail) && isset($message)) {
              if (filter_var($mail, FILTER_VALIDATE_EMAIL)) {
                  return true;
              } else {
                  return false;
              }
          } else {
              return false;
          }
      }
  }

