package com.sd.enseignantreferantservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class PIAL implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pialId;

    private String nom;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PIAL pial = (PIAL) o;
        return pialId == pial.pialId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pialId);
    }
}
