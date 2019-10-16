package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class StructurePro implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int structureProId;

    private String nom;
    private String specialite;
    private String telephone;
    private String mail;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @JsonIgnore
    @OneToMany(mappedBy = "structurePro",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY )
    private Set<EleveStructurePro> listEleveStructurePro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StructurePro that = (StructurePro) o;
        return structureProId == that.structureProId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(structureProId);
    }
}
