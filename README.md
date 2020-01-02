[![Build Status](https://travis-ci.com/watslink/enseignantreferentservice.svg?branch=master)](https://travis-ci.com/watslink/enseignantreferentservice)
[![codecov](https://codecov.io/gh/watslink/enseignantreferentservice/branch/master/graph/badge.svg)](https://codecov.io/gh/watslink/enseignantreferentservice)

**********************************************************************************************
                              #EnseignantReferentService
**********************************************************************************************

Service à destination des enseignants référents.
Son but est de faciliter le suivi des élèves.
Il permet entre autre:
 - la gestion des établissements, PIALs, AESHs, Structures Professionnelles, Représentants legaux, Materiels
   pédagogiques adaptés, niveaux.
 - la gestion de documents selon différentes catégories paramétrables.
 - la gestion des nouvelles inscriptions avec liste de documents requis obligatoire paramétrable.
 - la gestion des rendez-vous.


-----
BDD
-----

Pour le developpement et les test, utilisez la base de données PostGreSQL sur Docker:
 - dans le dossier docker/dev/ :
        - Démarrer la BDD:
            - docker-compose up
        - Réinitialisez la BDD:
            - docker-compose stop
            - docker-compose rm
            - docker-compose up
 - Les informations de connection sont dans le fichier docker-compose.yml

--------------
Configuration
--------------

La base de données de production se configure dans application.properties:
spring.datasource.driverClassName=
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=

--------
Package
--------

Packager l'application avec la commande "package mvn"

------------
Déploiement
------------

Deployer l'artefact "enseignantrefererantservice-1.0-SNAPSHOT.war"  dans un serveur d'application Tomcat 9.




