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
public class RepresentantLegal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int representantLegalId;

    private String identite;

    private String mail;

    private String telephone;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepresentantLegal that = (RepresentantLegal) o;
        return representantLegalId == that.representantLegalId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(representantLegalId);
    }
}

