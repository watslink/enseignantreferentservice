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
public class AESH implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aeshId;

    private String nom;

    private String prenom;

    private String mail;

    private String telephone;

    @ManyToOne
    @JoinColumn(name="PIAL_id")
    private PIAL pial;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AESH aesh = (AESH) o;
        return aeshId == aesh.aeshId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(aeshId);
    }
}
