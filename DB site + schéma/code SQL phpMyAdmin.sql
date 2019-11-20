Création de la Table Personne :

CREATE TABLE `projetIntegration`.`personne` 
( `id` INT NOT NULL AUTO_INCREMENT , `nom` VARCHAR NOT NULL , `prenom` VARCHAR NOT NULL , `mail` VARCHAR NOT NULL , `sexe` BOOLEAN NOT NULL , `dateNaissance` DATE NOT NULL , `adresse` VARCHAR NOT NULL , `ville` VARCHAR NOT NULL ) 
ENGINE = MyISAM;


Insertion de valeurs dans la table personne :


				1) INSERT INTO `personne` (`nom`, `prenom`, `mail`, `sexe`, `dateNaissance`, `adresse`, `ville`) 
				VALUES ('bon', 'jean', 'coucou@mail', '1', '2019-11-13', 'rue bonjour', 'bruxelles');

				2) INSERT INTO `personne` (`nom`, `prenom`, `mail`, `sexe`, `dateNaissance`, `adresse`, `ville`) 
				VALUES ('test', 'test', 'test@mail', '1', '2019-11-13', 'rue test', 'test')
		

		
Création de la Table Produits : 


			CREATE TABLE `projetintegration`.`produits` 
			( `idProduits` INT NOT NULL AUTO_INCREMENT ,  `prix` FLOAT NOT NULL ,  `nom` VARCHAR(25) NOT NULL ,  `disponibilite` BOOLEAN NOT NULL ,    PRIMARY KEY  (`idProduits`)) ENGINE = MyISAM;



			
Création de la Table Commandes :

			CREATE TABLE `projetintegration`.`commandes` 
			( `idCommandes` INT NOT NULL AUTO_INCREMENT , `numeroCommandes` VARCHAR(25) NOT NULL , `disponibilite` BOOLEAN NOT NULL , `quantiteStock` INT NOT NULL , `dateAchat` DATE NOT NULL , PRIMARY KEY (`idCommandes`)) ENGINE = MyISAM;



			
Création de la table Client :

			CREATE TABLE `projetintegration`.`client` 
			( `idClient` INT NOT NULL AUTO_INCREMENT , `username` VARCHAR(20) NOT NULL , `password` VARCHAR(20) NOT NULL , PRIMARY KEY (`idClient`)) ENGINE = MyISAM;
			
			
Insertion de données dans la Table Client			
			
			INSERT INTO `client` (`idClient`, `username`, `password`) VALUES (NULL, 'toto', 'test');
			
			
			
			
			
			
		