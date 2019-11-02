<?php
  class FormHandler
  {
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

