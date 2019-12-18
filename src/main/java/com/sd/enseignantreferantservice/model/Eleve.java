package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
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

    @Temporal(TemporalType.TIMESTAMP)
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

    @OneToMany(mappedBy = "eleve",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY )
    private Set<RepresentantLegal> listRepresentantsLegaux;

    @OneToMany(mappedBy = "eleve",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY )
    @JsonIgnoreProperties("eleve")
    private Set<EleveStructurePro> listEleveStructurePros;

    @ManyToMany
    @JsonIgnoreProperties("listEleve")
    @JoinTable(name = "eleve_materiel_pedago_adapte",
            joinColumns = {@JoinColumn(name = "eleve_id")},
            inverseJoinColumns = {@JoinColumn(name = "materiel_pedago_adapte_id")})
    private Set<MaterielPedagoAdapte> listMaterielsPedagoAdaptes;

    @OneToMany(mappedBy = "eleve",cascade = CascadeType.ALL, orphanRemoval = true )
    private Set<Document> listDocuments;

    @OneToMany(mappedBy = "eleve",cascade = CascadeType.ALL,  orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<EleveDocumentInscriptionRequis> listEleveDocumentsInscriptionRequis;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eleve eleve = (Eleve) o;
        return eleveId == eleve.eleveId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eleveId);
    }
}
