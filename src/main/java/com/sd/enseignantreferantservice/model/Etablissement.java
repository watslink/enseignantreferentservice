package com.sd.enseignantreferantservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Etablissement implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int etablissementId;

    private String nom;

    private String rne;

    private String telephone;

    private String mail;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name="PIAL_id")
    private PIAL pial;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etablissement that = (Etablissement) o;
        return etablissementId == that.etablissementId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(etablissementId);
    }
}
