package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class MaterielPedagoAdapte implements Serializable {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int materielPedagoAdapteId;

    private String nom;


    @ManyToMany
    @JsonIgnoreProperties("listMaterielsPedagoAdaptes")
    @JoinTable(name = "eleve_materiel_pedago_adapte",
            joinColumns = {@JoinColumn(name = "materiel_pedago_adapte_id")},
            inverseJoinColumns = {@JoinColumn(name = "eleve_id")})
    private List<Eleve> listEleve;

    @ManyToOne
    @JoinColumn(name="enseignant_referent_id")
    private EnseignantReferent enseignantReferent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterielPedagoAdapte that = (MaterielPedagoAdapte) o;
        return materielPedagoAdapteId == that.materielPedagoAdapteId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(materielPedagoAdapteId);
    }
}
