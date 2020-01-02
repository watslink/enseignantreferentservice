
CREATE SEQUENCE public.enseignant_referent_enseignant_referent_id_seq;

CREATE TABLE public.enseignant_referent (
                                            enseignant_referent_id INTEGER NOT NULL DEFAULT nextval('public.enseignant_referent_enseignant_referent_id_seq'),
                                            nom VARCHAR NOT NULL,
                                            mail VARCHAR NOT NULL,
                                            enabled BOOLEAN NOT NULL,
                                            prenom VARCHAR NOT NULL,
                                            mot_de_passe VARCHAR NOT NULL,
                                            CONSTRAINT enseignant_referent_pk PRIMARY KEY (enseignant_referent_id)
);


ALTER SEQUENCE public.enseignant_referent_enseignant_referent_id_seq OWNED BY public.enseignant_referent.enseignant_referent_id;

CREATE SEQUENCE public.categorie_new_column_seq;

CREATE TABLE public.categorie (
                                  categorie_id INTEGER NOT NULL DEFAULT nextval('public.categorie_new_column_seq'),
                                  nom VARCHAR NOT NULL,
                                  enseignant_referent_id INTEGER NOT NULL,
                                  CONSTRAINT categorie_pk PRIMARY KEY (categorie_id)
);


ALTER SEQUENCE public.categorie_new_column_seq OWNED BY public.categorie.categorie_id;

CREATE SEQUENCE public.document_inscription_requis_document_inscription_requis_id_seq;

CREATE TABLE public.document_inscription_requis (
                                                    document_inscription_requis_id INTEGER NOT NULL DEFAULT nextval('public.document_inscription_requis_document_inscription_requis_id_seq'),
                                                    enseignant_referent_id INTEGER NOT NULL,
                                                    nom VARCHAR NOT NULL,
                                                    CONSTRAINT document_inscription_requis_pk PRIMARY KEY (document_inscription_requis_id)
);


ALTER SEQUENCE public.document_inscription_requis_document_inscription_requis_id_seq OWNED BY public.document_inscription_requis.document_inscription_requis_id;

CREATE SEQUENCE public.materiel_pedago_adapte_materiel_pedago_adapte_id_seq;

CREATE TABLE public.materiel_pedago_adapte (
                                               materiel_pedago_adapte_id INTEGER NOT NULL DEFAULT nextval('public.materiel_pedago_adapte_materiel_pedago_adapte_id_seq'),
                                               nom VARCHAR NOT NULL,
                                               enseignant_referent_id INTEGER NOT NULL,
                                               CONSTRAINT materiel_pedago_adapte_pk PRIMARY KEY (materiel_pedago_adapte_id)
);


ALTER SEQUENCE public.materiel_pedago_adapte_materiel_pedago_adapte_id_seq OWNED BY public.materiel_pedago_adapte.materiel_pedago_adapte_id;

CREATE SEQUENCE public.pial_pial_id_seq;

CREATE TABLE public.PIAL (
                             PIAL_id INTEGER NOT NULL DEFAULT nextval('public.pial_pial_id_seq'),
                             nom VARCHAR NOT NULL,
                             enseignant_referent_id INTEGER NOT NULL,
                             CONSTRAINT pial_pk PRIMARY KEY (PIAL_id)
);


ALTER SEQUENCE public.pial_pial_id_seq OWNED BY public.PIAL.PIAL_id;

CREATE SEQUENCE public.aesh_aesh_id_seq;

CREATE TABLE public.AESH (
                             AESH_id INTEGER NOT NULL DEFAULT nextval('public.aesh_aesh_id_seq'),
                             nom VARCHAR NOT NULL,
                             prenom VARCHAR NOT NULL,
                             mail VARCHAR,
                             telephone VARCHAR,
                             PIAL_id INTEGER,
                             enseignant_referent_id INTEGER NOT NULL,
                             CONSTRAINT aesh_pk PRIMARY KEY (AESH_id)
);


ALTER SEQUENCE public.aesh_aesh_id_seq OWNED BY public.AESH.AESH_id;

CREATE SEQUENCE public.adresse_adresse_id_seq;

CREATE TABLE public.adresse (
                                adresse_id INTEGER NOT NULL DEFAULT nextval('public.adresse_adresse_id_seq'),
                                numero INTEGER NOT NULL,
                                code_postal INTEGER NOT NULL,
                                voie VARCHAR NOT NULL,
                                ville VARCHAR NOT NULL,
                                CONSTRAINT adresse_pk PRIMARY KEY (adresse_id)
);


ALTER SEQUENCE public.adresse_adresse_id_seq OWNED BY public.adresse.adresse_id;

CREATE SEQUENCE public.structure_pro_structure_pro_id_seq;

CREATE TABLE public.structure_pro (
                                      structure_pro_id INTEGER NOT NULL DEFAULT nextval('public.structure_pro_structure_pro_id_seq'),
                                      enseignant_referent_id INTEGER NOT NULL,
                                      nom VARCHAR NOT NULL,
                                      specialite VARCHAR,
                                      mail VARCHAR,
                                      telephone VARCHAR,
                                      adresse_id INTEGER NOT NULL,
                                      CONSTRAINT structure_pro_pk PRIMARY KEY (structure_pro_id)
);


ALTER SEQUENCE public.structure_pro_structure_pro_id_seq OWNED BY public.structure_pro.structure_pro_id;

CREATE SEQUENCE public.etablissement_etablissement_id_seq;

CREATE TABLE public.etablissement (
                                      etablissement_id INTEGER NOT NULL DEFAULT nextval('public.etablissement_etablissement_id_seq'),
                                      nom VARCHAR NOT NULL,
                                      rne VARCHAR NOT NULL,
                                      mail VARCHAR,
                                      telephone VARCHAR,
                                      adresse_id INTEGER NOT NULL,
                                      PIAL_id INTEGER,
                                      enseignant_referent_id INTEGER NOT NULL,
                                      CONSTRAINT etablissement_pk PRIMARY KEY (etablissement_id)
);


ALTER SEQUENCE public.etablissement_etablissement_id_seq OWNED BY public.etablissement.etablissement_id;

CREATE SEQUENCE public.niveau_niveau_id_seq;

CREATE TABLE public.niveau (
                               niveau_id INTEGER NOT NULL DEFAULT nextval('public.niveau_niveau_id_seq'),
                               libelle VARCHAR NOT NULL,
                               degre INTEGER,
                               specialise BOOLEAN NOT NULL,
                               enseignant_referent_id INTEGER NOT NULL,
                               CONSTRAINT niveau_pk PRIMARY KEY (niveau_id)
);


ALTER SEQUENCE public.niveau_niveau_id_seq OWNED BY public.niveau.niveau_id;

CREATE SEQUENCE public.eleve_eleve_id_seq;

CREATE TABLE public.eleve (
                              eleve_id INTEGER NOT NULL DEFAULT nextval('public.eleve_eleve_id_seq'),
                              dossier_accepte BOOLEAN NOT NULL,
                              nom VARCHAR NOT NULL,
                              prenom VARCHAR NOT NULL,
                              date_naissance DATE NOT NULL,
                              date_reunion TIMESTAMP,
                              vu BOOLEAN NOT NULL,
                              niveau_id INTEGER,
                              etablissement_id INTEGER,
                              commentaire TEXT,
                              date_notification_AESH DATE,
                              enseignant_referent_id INTEGER NOT NULL,
                              AESH_id INTEGER,
                              CONSTRAINT eleve_pk PRIMARY KEY (eleve_id)
);


ALTER SEQUENCE public.eleve_eleve_id_seq OWNED BY public.eleve.eleve_id;

CREATE SEQUENCE public.representant_legal_representant_legal_id_seq;

CREATE TABLE public.representant_legal (
                                           representant_legal_id INTEGER NOT NULL DEFAULT nextval('public.representant_legal_representant_legal_id_seq'),
                                           identite VARCHAR NOT NULL,
                                           mail VARCHAR,
                                           telephone VARCHAR,
                                           adresse_id INTEGER NOT NULL,
                                           eleve_id INTEGER NOT NULL,
                                           enseignant_referent_id INTEGER NOT NULL,
                                           CONSTRAINT representant_legal_pk PRIMARY KEY (representant_legal_id)
);


ALTER SEQUENCE public.representant_legal_representant_legal_id_seq OWNED BY public.representant_legal.representant_legal_id;

CREATE TABLE public.eleve_document_inscription_requis (
                                                          document_inscription_requis_id INTEGER NOT NULL,
                                                          eleve_id INTEGER NOT NULL,
                                                          ok BOOLEAN NOT NULL,
                                                          extension VARCHAR,
                                                          CONSTRAINT eleve_document_inscription_requis_pk PRIMARY KEY (document_inscription_requis_id, eleve_id)
);


CREATE SEQUENCE public.document_document_id_seq;

CREATE TABLE public.document (
                                 document_id INTEGER NOT NULL DEFAULT nextval('public.document_document_id_seq'),
                                 nom VARCHAR NOT NULL,
                                 extension VARCHAR NOT NULL,
                                 eleve_id INTEGER NOT NULL,
                                 categorie_id INTEGER,
                                 CONSTRAINT document_pk PRIMARY KEY (document_id)
);


ALTER SEQUENCE public.document_document_id_seq OWNED BY public.document.document_id;

CREATE TABLE public.eleve_materiel_pedago_adapte (
                                                     eleve_id INTEGER NOT NULL,
                                                     materiel_pedago_adapte_id INTEGER NOT NULL,
                                                     CONSTRAINT eleve_materiel_pedago_adapte_pk PRIMARY KEY (eleve_id, materiel_pedago_adapte_id)
);


CREATE TABLE public.eleve_structure_pro (
                                            eleve_id INTEGER NOT NULL,
                                            structure_pro_id INTEGER NOT NULL,
                                            date_notification DATE,
                                            CONSTRAINT eleve_structure_pro_pk PRIMARY KEY (eleve_id, structure_pro_id)
);


ALTER TABLE public.eleve ADD CONSTRAINT enseignant_referent_eleve_fk
    FOREIGN KEY (enseignant_referent_id)
        REFERENCES public.enseignant_referent (enseignant_referent_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.structure_pro ADD CONSTRAINT enseignant_referent_structure_pro_fk
    FOREIGN KEY (enseignant_referent_id)
        REFERENCES public.enseignant_referent (enseignant_referent_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.materiel_pedago_adapte ADD CONSTRAINT enseignant_referent_materiel_pedago_adapte_fk
    FOREIGN KEY (enseignant_referent_id)
        REFERENCES public.enseignant_referent (enseignant_referent_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.document_inscription_requis ADD CONSTRAINT enseignant_referent_document_inscription_requis_fk
    FOREIGN KEY (enseignant_referent_id)
        REFERENCES public.enseignant_referent (enseignant_referent_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.categorie ADD CONSTRAINT enseignant_referent_categorie_fk
    FOREIGN KEY (enseignant_referent_id)
        REFERENCES public.enseignant_referent (enseignant_referent_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.AESH ADD CONSTRAINT enseignant_referent_aesh_fk
    FOREIGN KEY (enseignant_referent_id)
        REFERENCES public.enseignant_referent (enseignant_referent_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.niveau ADD CONSTRAINT enseignant_referent_niveau_fk
    FOREIGN KEY (enseignant_referent_id)
        REFERENCES public.enseignant_referent (enseignant_referent_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.PIAL ADD CONSTRAINT enseignant_referent_pial_fk
    FOREIGN KEY (enseignant_referent_id)
        REFERENCES public.enseignant_referent (enseignant_referent_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.etablissement ADD CONSTRAINT enseignant_referent_etablissement_fk
    FOREIGN KEY (enseignant_referent_id)
        REFERENCES public.enseignant_referent (enseignant_referent_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.representant_legal ADD CONSTRAINT enseignant_referent_representant_legal_fk
    FOREIGN KEY (enseignant_referent_id)
        REFERENCES public.enseignant_referent (enseignant_referent_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.document ADD CONSTRAINT categorie_document_fk
    FOREIGN KEY (categorie_id)
        REFERENCES public.categorie (categorie_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.eleve_document_inscription_requis ADD CONSTRAINT document_inscription_requis_eleve_document_inscription_requi141
    FOREIGN KEY (document_inscription_requis_id)
        REFERENCES public.document_inscription_requis (document_inscription_requis_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.eleve_materiel_pedago_adapte ADD CONSTRAINT materiel_pedago_adapte_eleve_materiel_pedago_adapte_fk
    FOREIGN KEY (materiel_pedago_adapte_id)
        REFERENCES public.materiel_pedago_adapte (materiel_pedago_adapte_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.etablissement ADD CONSTRAINT pial_etablissement_fk
    FOREIGN KEY (PIAL_id)
        REFERENCES public.PIAL (PIAL_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.AESH ADD CONSTRAINT pial_aesh_fk
    FOREIGN KEY (PIAL_id)
        REFERENCES public.PIAL (PIAL_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.eleve ADD CONSTRAINT aesh_eleve_fk
    FOREIGN KEY (AESH_id)
        REFERENCES public.AESH (AESH_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.etablissement ADD CONSTRAINT adresse_etablissement_fk
    FOREIGN KEY (adresse_id)
        REFERENCES public.adresse (adresse_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.representant_legal ADD CONSTRAINT adresse_representant_legal_fk
    FOREIGN KEY (adresse_id)
        REFERENCES public.adresse (adresse_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.structure_pro ADD CONSTRAINT adresse_structure_pro_fk
    FOREIGN KEY (adresse_id)
        REFERENCES public.adresse (adresse_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.eleve_structure_pro ADD CONSTRAINT structure_pro_eleve_structure_pro_fk
    FOREIGN KEY (structure_pro_id)
        REFERENCES public.structure_pro (structure_pro_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.eleve ADD CONSTRAINT etablissement_eleve_fk
    FOREIGN KEY (etablissement_id)
        REFERENCES public.etablissement (etablissement_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.eleve ADD CONSTRAINT niveau_eleve_fk
    FOREIGN KEY (niveau_id)
        REFERENCES public.niveau (niveau_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.eleve_structure_pro ADD CONSTRAINT eleve_eleve_structure_pro_fk
    FOREIGN KEY (eleve_id)
        REFERENCES public.eleve (eleve_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.eleve_materiel_pedago_adapte ADD CONSTRAINT eleve_eleve_materiel_pedago_adapte_fk
    FOREIGN KEY (eleve_id)
        REFERENCES public.eleve (eleve_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.document ADD CONSTRAINT eleve_document_fk
    FOREIGN KEY (eleve_id)
        REFERENCES public.eleve (eleve_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.eleve_document_inscription_requis ADD CONSTRAINT eleve_eleve_document_inscription_requis_fk
    FOREIGN KEY (eleve_id)
        REFERENCES public.eleve (eleve_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;

ALTER TABLE public.representant_legal ADD CONSTRAINT eleve_representant_legal_fk
    FOREIGN KEY (eleve_id)
        REFERENCES public.eleve (eleve_id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
        NOT DEFERRABLE;
