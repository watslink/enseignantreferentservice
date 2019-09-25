package com.sd.enseignantreferantservice.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Eleve implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eleveId;

    private String nom;
    private String prenom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;

    private boolean dossierAccepte;
    private boolean vu;

    @Temporal(TemporalType.DATE)
    private Date dateReunion;

    private String commentaire;

    @ManyToOne
    @JoinColumn(name="niveau_id")
    private Niveau niveau;

    @ManyToOne
    @JoinColumn(name="etablissement_id")
    private Etablissement etablissement;

    @ManyToOne
    @JoinColumn(name="AESH_id")
    private AESH aesh;

    @Temporal(TemporalType.DATE)
    private Date dateNotificationAesh;

    @ManyToOne
    @JoinColumn(name="enseignant_referent_id")
    private EnseignantReferent enseignantReferent;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "eleve_representant_legal",
            joinColumns = {@JoinColumn(name = "eleve_id")},
            inverseJoinColumns = {@JoinColumn(name = "representant_legal_id")})
    private Set<RepresentantLegal> listRepresentantsLegaux;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "eleve_structure_pro",
            joinColumns = {@JoinColumn(name = "eleve_id")},
            inverseJoinColumns = {@JoinColumn(name = "structure_pro_id")})
    private Set<StructurePro> listStructurePros;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "eleve_materiel_pedago_adapte",
            joinColumns = {@JoinColumn(name = "eleve_id")},
            inverseJoinColumns = {@JoinColumn(name = "materiel_pedago_adapte_id")})
    private Set<MaterielPedagoAdapte> listMaterielsPedagoAdaptes;

    @OneToMany(mappedBy = "eleve", orphanRemoval = true)
    private Set<Document> listDocuments;

    @OneToMany(mappedBy = "eleve", orphanRemoval = true)
    private Set<EleveDocumentInscriptionRequis> listEleveDocumentsInscriptionRequis;
}
