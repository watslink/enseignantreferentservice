INSERT INTO enseignant_referent (nom, prenom, mail, mot_de_passe, enabled)
VALUES
('Jean', 'Dupont', 'jean.dupont@mail.com', '$2a$10$Z4F50wfLr4Iuc1HckouM9OoJIkr4O/Gi9TvC0PAkJp3vBb23o.MvC', true);

INSERT INTO PIAL (nom, enseignant_referent_id)
VALUES
('Somain', 1),
('Orchies', 1);

INSERT INTO adresse (numero, voie, code_postal, ville)
VALUES
(182, 'Rue de Belloy', 24550, 'Villefranche-du-Périgord'),
(162, 'Rue Georges-Berger', 95220, 'Herblay'),
(159, 'Rue Rouvet', 67660, 'Schwabwiller'),
(198, 'Rue Henri-Ribière', 29000, 'Quimper'),
(11, 'Cité de la Chapelle', 54370, 'Xures'),
(3, 'Rue Fontaine', 51500, 'Villers-aux-Noeuds'),
(94, 'Rue Durouchoux', 21350, 'Vitteaux'),
(179, 'Esplanade Henri-de-France', 88490, 'Provenchères-sur-Fave'),
(10, 'Rue Ernest-Lefèvre', 16730, 'Trois-Palis'),
(78, 'Boulevard Beaumarchais', 68380, 'Sondernach'),
(137, 'Rue du Général-de-Castelnau', 65150, 'Tuzaguet'),
(153, 'Place du Huit-Novembre-1942', 58300, 'Verneuil'),
(61, 'Avenue du Général-Laperrine', 02800, 'Versigny'),
(105, 'Place du Général-Brocard', 12190, 'Sébrazac'),
(191, 'Villa Jamot', 80740, 'Ronssoy'),
(90, 'Avenue Ernest-Reyer', 68118, 'Hirtzbach'),
(49, 'Rue Bardinet', 64310, 'Sare'),
(157, 'Rue Gustave-Geffroy', 72310, 'Pont-de-Braye'),
(82, 'Rue de Dunkerque', 43330, 'Saint-Ferréol-d''Auroure'),
(53, 'Avenue Émile-Pouvillon', 73700, 'Hauteville-Gondon'),
(97, 'Rue de Bellechasse', 32500, 'Urdens'),
(28, 'Rue Baron-Le-Roy', 94190, 'Villeneuve-Saint-Georges'),
(7, 'Rue Georges-Auric', 51100, 'Reims'),
(140, 'Passage souterrain Henri-Gaillard', 45730, 'Saint-Benoît-sur-Loire'),
(122, 'Rue Félix-Voisin', 06710, 'Villars-sur-Var'),
(72, 'Rue de l''Inspecteur-Allès', 74410, 'Saint-Jorioz'),
(172, 'Rue Florian', 58200, 'Cosne-Cours-sur-Loire'),
(108, 'Rue de Gergovie', 74380, 'Nangy'),
(105, 'Rue Alexandre-de-Humboldt', 32130, 'Seysses-Savès'),
(91, 'Avenue Ernest-Reyer', 68118, 'Hirtzbach'),
(492, 'Rue Bardinet', 64310, 'Sare'),
(15, 'Rue Gustave-Geffroy', 72310, 'Pont-de-Braye'),
(8, 'Rue de Dunkerque', 43330, 'Saint-Ferréol-d''Auroure'),
(5, 'Avenue Émile-Pouvillon', 73700, 'Hauteville-Gondon'),
(9, 'Rue de Bellechasse', 32500, 'Urdens'),
(2, 'Rue Baron-Le-Roy', 94190, 'Villeneuve-Saint-Georges'),
(72, 'Rue Georges-Auric', 51100, 'Reims'),
(14, 'Passage souterrain Henri-Gaillard', 45730, 'Saint-Benoît-sur-Loire'),
(12, 'Rue Félix-Voisin', 06710, 'Villars-sur-Var'),
(7, 'Rue de l''Inspecteur-Allès', 74410, 'Saint-Jorioz'),
(17, 'Rue Florian', 58200, 'Cosne-Cours-sur-Loire'),
(10, 'Rue de Gergovie', 74380, 'Nangy'),
(10, 'Rue Alexandre-de-Humboldt', 32130, 'Seysses-Savès');

INSERT INTO etablissement (nom, rne, mail, telephone, adresse_id, PIAL_id, enseignant_referent_id)
VALUES
('Boyer Malo', '3700566G', 'maloboyer@fakeemail.com', '01.75.98.62.65', 39, 1, 1),
('Faure Pauline', '9343187H', 'paulinefaure@fakeemail.com', '03.36.28.30.91', 38, 1, 1),
('Chretien Julien', '9954117N', 'julienchretien@fakeemail.com', '04.99.35.72.15', 37, 1, 1),
('Fischer Malo', '0210115F', 'malofischer@fakeemail.com', '03.01.48.15.63', 36, 2, 1),
('Baron Tatiana', '0372327J', 'tatianabaron@fakeemail.com', '02.92.79.36.36', 35, 2, 1),
('Sanchez Bienvenue', '7769718P', 'bienvenuesanchez@fakeemail.com', '03.37.69.45.01', 34, 2, 1),
('Maurel Lilou', '7302066O', 'liloumaurel@fakeemail.com', '06.12.52.90.04', 33, 2, 1),
('Vincent Katell', '1037213E', 'katellvincent@fakeemail.com', '01.72.82.96.56', 32, 2, 1),
('Evrard Anna', '9814018D', 'annaevrard@fakeemail.com', '06.56.48.21.89', 31, 2, 1),
('Tanguy Martin', '3405255U', 'martintanguy@fakeemail.com', '02.19.43.38.37', 30, 2, 1),
('Raynaud Manon', '6758888A', 'manonraynaud@fakeemail.com', '02.27.39.39.04', 29, 2, 1),
('Vasseur Margaux', '3807615K', 'margauxvasseur@fakeemail.com', '05.59.57.60.04', 28, 2, 1),
('Pages Adam', '0414382I', 'adampages@fakeemail.com', '01.65.90.94.10', 27, 2, 1),
('Tournier Nina', '3327684M', 'ninatournier@fakeemail.com', '04.14.00.67.62', 26, 2, 1),
('Andre Ambre', '7742676Q', 'ambreandre@fakeemail.com', '01.80.61.11.23', 25, 1, 1);


INSERT INTO niveau (libelle, degre, specialise, enseignant_referent_id)
VALUES
('TPS', 1, false, 1),
('PS', 1, false, 1),
('MS', 1, false, 1),
('GS', 1, false, 1),
('CP', 1, false, 1),
('CE1', 1, false, 1),
('CE2', 1, false, 1),
('CM1', 1, false, 1),
('CM2', 1, false, 1),
('6e', 2, false, 1),
('5e', 2, false, 1),
('4e', 2, false, 1),
('3e', 2, false, 1),
('2nd', 2, false, 1),
('1ere', 2, false, 1),
('Terminale', 2, false, 1),
('IME', null, true, 1),
('ULIS-école', 1, true, 1),
('ULIS-collège', 2, true, 1),
('6 SEGPA', 2, true, 1),
('5 SEGPA', 2, true, 1),
('4 SEGPA', 2, true, 1),
('3 SEGPA', 2, true, 1);

INSERT INTO AESH (nom, prenom, mail, telephone, PIAL_id, enseignant_referent_id)
VALUES
('Tessier','Martin', 'martintessier@fakeemail.com', '00.63.82.22.28', 2, 1),
('Lafon','Nina', 'ninalafon@fakeemail.com', '03.51.78.03.88', 1, 1),
('Bernier','Mehdi', 'mehdibernier@fakeemail.com', '06.51.15.72.85', 2, 1),
('Richard','Maelys', 'maelysrichard@fakeemail.com', '06.01.22.24.63', 2, 1),
('Pottier','Loane', 'loanepottier@fakeemail.com', '04.74.99.02.79', 2, 1),
('Vallee','Rémi', 'remivallee@fakeemail.com', '04.42.97.15.44', 1, 1),
('Coulon','Maëlle', 'maellecoulon@fakeemail.com', '02.39.21.78.35', 1, 1),
('Lelong','Katell', 'katelllelong@fakeemail.com', '00.90.04.61.44', 1, 1),
('Perrin','Guillemette', 'guillemetteperrin@fakeemail.com', '06.27.82.72.36', 2, 1),
('Nicolas','Mathéo', 'matheonicolas@fakeemail.com', '01.73.80.05.28', 1, 1),
('Doucet','Sarah', 'sarahdoucet@fakeemail.com', '04.52.23.99.86', 2, 1),
('Humbert','Rose', 'rosehumbert@fakeemail.com', '02.12.85.63.32', 2, 1),
('Guibert','Sara', 'saraguibert@fakeemail.com', '04.26.28.29.99', 1, 1),
('Chevallier','Paul', 'paulchevallier@fakeemail.com', '05.25.85.67.34', 1, 1),
('Morel','Jules', 'julesmorel@fakeemail.com', '00.41.00.45.27', 2, 1);


INSERT INTO eleve (dossier_accepte, nom, prenom, date_naissance, date_reunion, vu, niveau_id, etablissement_id, commentaire,
                   date_notification_AESH, AESH_id, enseignant_referent_id)
VALUES
(true, 'Petit', 'Gaspard','2009-11-05', '2020-03-03 09:30:00', false, 1, 1, 'RAS', null, null, 1),
(true, 'Arnould', 'Nicolas', '2003-11-11', '2020-03-03 10:30:00', false, 2, 1, 'Prendre rendez-vous avec un specialiste','2020-06-30', 1, 1),
(true, 'Gillet', 'Valentine', '2013-08-26', '2019-09-10 13:30:00', true, 3, 1, null, '2021-06-30', 2, 1),
(true, 'Lacroix', 'Renaud', '2004-09-06', '2019-09-10 15:00:00', true, 4, 1, 'Amelioration du comportement', '2020-06-30', 3, 1),
(true, 'Gras', 'Romain', '2006-04-18', null, false, 5, 1, null,'2020-06-30', 4, 1),
(true, 'Royer', 'Éloïse', '2007-08-12', null, false, 6, 1, null, null, null, 1),
(true, 'Allard', 'Edwige', '2003-08-24', null, false, 7, 2, null, null, null, 1),
(true, 'Martins', 'Émile', '2002-02-12', null, false, 8, 3, null, null, null, 1),
(true, 'Lemonnier', 'Luna', '2001-09-11', null, false, 9, 3, null, null, null, 1),
(true, 'Jacquot', 'Mathieu', '2012-01-22', null, false, 10, 4, null, null, null, 1),
(true, 'Gosselin', 'Émilie', '2007-05-29', null, false, 11, 5, null, null, null, 1),
(true, 'Chevalier', 'Maxime', '2002-09-25', null, false, 12, 6, null, null, null, 1),
(true, 'Costa', 'Davy', '2011-12-12', null, false, 13, 6, null, null, null, 1),
(true, 'Schmitt', 'Bienvenue', '2007-10-28', null, false, 14, 7, null, null, null, 1),
(true, 'Bertrand', 'Solene', '2004-03-14', null, false, 15, 8, null, null, null, 1),
(true, 'Riou', 'Edwige', '2014-06-20', null, false, 16, 8, null, null, null, 1),
(true, 'Petitjean', 'Noë', '2010-11-05', null, false, 17, 9, null, null, null, 1),
(false, 'Rossi', 'Kyllian', '2008-07-25', null, false, 18, 10, null, null, null, 1),
(false, 'Delannoy', 'Victor', '2014-04-04', null, false, 19, 11, null, null, null, 1),
(false, 'Martinez', 'Maelys', '2012-12-12', null, false, 20, 1, null, null, null, 1);

INSERT INTO representant_legal (identite, mail, telephone, adresse_id, enseignant_referent_id, eleve_id)
VALUES
('Duval Agathe', 'agatheduval@fakeemail.com', '06.94.15.58.70', 24, 1, 1),
('Rousseau Alexia', 'alexiarousseau@fakeemail.com', '06.62.05.82.39', 23, 1, 1),
('Andre Lamia', 'lamiaandre@fakeemail.com', '02.97.75.48.14', 22, 1, 2),
('Besson Bastien', 'bastienbesson@fakeemail.com', '01.62.60.52.01', 21, 1, 2),
('Guillon Jade', 'jadeguillon@fakeemail.com', '02.95.43.23.86', 20, 1, 3),
('Bouquet Grégory', 'gregorybouquet@fakeemail.com', '04.95.99.20.28', 19, 1, 4),
('Becker Lucie', 'luciebecker@fakeemail.com', '01.83.42.68.55', 18, 1, 5),
('Mary Solene', 'solenemary@fakeemail.com', '00.16.74.81.71', 17, 1, 6),
('Salaun Océane', 'oceanesalaun@fakeemail.com', '01.06.87.08.77', 16, 1, 7),
(' Centre Mael Bouvier', 'centremaelbouvier@fakeemail.com', '01.53.66.64.51', 15, 1, 8),
(' Centre Clément Giraud', 'centreclementgiraud@fakeemail.com', '06.84.88.54.18', 14, 1, 9),
(' Centre Mael Durand', 'centremaeldurand@fakeemail.com', '02.19.49.60.48', 13, 1, 10),
(' Centre Titouan Pineau', 'centretitouanpineau@fakeemail.com', '01.09.45.95.82', 12, 1, 11),
(' Centre Lutécia Sauvage', 'centreluteciasauvage@fakeemail.com', '04.71.49.84.37', 11, 1, 12),
(' Centre Cloé Olivier', 'centrecloeolivier@fakeemail.com', '04.04.84.67.84', 10, 1, 20),
(' Centre Noah Jean', 'centrenoahjean@fakeemail.com', '04.52.13.36.59', 9, 1, 13),
(' Centre Nolan Leveque', 'centrenolanleveque@fakeemail.com', '04.53.32.51.61', 8, 1, 20),
(' Centre Dorian Renault', 'centredorianrenault@fakeemail.com', '00.13.30.52.03', 7, 1, 1),
(' Centre Anaïs Lafon', 'centreanaislafon@fakeemail.com', '06.46.79.71.69', 6, 1, 2);

INSERT INTO structure_pro (nom, specialite, mail, telephone, adresse_id, enseignant_referent_id)
VALUES
('Chatelain','kine', 'chatelain@fakeemail.com', '06.18.67.51.16', 5, 1),
('Chambon','psychologue', 'chambon@fakeemail.com', '06.88.09.05.37', 4, 1),
('Marques','psychomotricien', 'marques@fakeemail.com', '06.75.07.49.05', 3, 1),
('Julien','orthoptiste', 'julien@fakeemail.com', '06.30.92.87.80', 2, 1),
('Cornu','orthophoniste', 'cornu@fakeemail.com', '06.43.96.57.42', 1, 1);


INSERT INTO eleve_structure_pro (eleve_id, structure_pro_id)
VALUES
(1, 1),
(1, 3),
(1, 4),
(2, 2),
(3, 5),
(20, 4),
(20, 5);

INSERT INTO materiel_pedago_adapte (nom, enseignant_referent_id)
VALUES
('ordinateur', 1),
('siège adapté', 1),
('imprimante', 1),
('table adaptée', 1);

INSERT INTO eleve_materiel_pedago_adapte (eleve_id, materiel_pedago_adapte_id)
VALUES
(1, 2),
(1, 4),
(2, 1),
(2, 3),
(3, 1),
(20, 1);

INSERT INTO categorie (nom, enseignant_referent_id)
VALUES
('Administratif', 1),
('Compte rendu ESS', 1),
('Feuillet annuel d''adaptation scolaire', 1),
('Autres', 1);

INSERT INTO document (nom, categorie_id, extension, eleve_id)
VALUES
('Dossier d''inscription', 1, 'pdf', 1),
('Etat civil', 1, 'pdf', 1),
('CR ESS 2018', 2, 'pdf', 1),
('CR ESS 2019', 2, 'pdf', 1),
('FAAS 2018', 3, 'pdf', 1),
('FAAS 2019', 3, 'pdf', 1),
('Courrier du directeur', 4, 'pdf', 1),
('Dossier d''inscription', 1, 'pdf', 2),
('Etat civil', 1, 'pdf', 2);

INSERT INTO document_inscription_requis (nom, enseignant_referent_id)
VALUES
('Dossier d''inscription', 1),
('Etat civil', 1);

INSERT INTO eleve_document_inscription_requis (document_inscription_requis_id, eleve_id, ok, extension)
VALUES
(1, 19, true, 'pdf'),
(2, 19, true, 'pdf'),
(1, 20, true, 'pdf'),
(2, 20, true, 'doc'),
(1, 18, false, null),
(2, 18, false, null);


