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
      public function validateContactForm($nom, $mail, $message)
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

      /**
      * Verifie que les 6 parametres sont remplis et dans le bon format
      * Retourne true si conditions remplies et false sinon
      * @param string $nom le nom du client
      * @param string $mail l'adresse email du client
      * @param int $quantite la quantite de réveil acheté par le client
      * @param string $adresse l'adresse du client (rue et n°)
      * @param string $ville la ville du client
      * @param string $pays le pays du client
      * @return boolean
      */
      public function validatePurchaseForm($nom, $mail, $quantite, $adresse, $ville, $pays)
      {
        if (isset($nom) && isset($mail) && isset($quantite) && isset($adresse) && isset($ville) && isset($pays)) {
          if (filter_var($mail, FILTER_VALIDATE_EMAIL)) {
            if (filter_var($quantite, FILTER_VALIDATE_INT) && ($quantite >=1) && ($quantite <= 10)) {  // Tout est correct
              return true;
            } else { // Erreur dans la quantite
              return false;
            }
          } else { // Erreur dans le mail
            return false;
          }
        } else { // Au moins 1 variable n'est pas instanciée
          return false;
        }
      }
  }
