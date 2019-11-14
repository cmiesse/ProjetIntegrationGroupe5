Création de la Table Personne

CREATE TABLE `projetIntegration`.`personne` 
( `id` INT NOT NULL AUTO_INCREMENT , `nom` VARCHAR NOT NULL , `prenom` VARCHAR NOT NULL , `mail` VARCHAR NOT NULL , `sexe` BOOLEAN NOT NULL , `dateNaissance` DATE NOT NULL , `adresse` VARCHAR NOT NULL , `ville` VARCHAR NOT NULL ) 
ENGINE = MyISAM;



Insertion de valeurs dans la table personne


INSERT INTO `personne` (`nom`, `prenom`, `mail`, `sexe`, `dateNaissance`, `adresse`, `ville`) 
VALUES ('bon', 'jean', 'coucou@mail', '1', '2019-11-13', 'rue bonjour', 'bruxelles');