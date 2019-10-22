package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(EleveStructurePro.class)
public class EleveStructurePro implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="structure_pro_id")
    private StructurePro structurePro;

    @JsonIgnore
    @Id
    @ManyToOne
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;

    @Temporal(TemporalType.DATE)
    private Date dateNotification;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EleveStructurePro that = (EleveStructurePro) o;
        return structurePro.equals(that.structurePro) &&
                eleve.equals(that.eleve);
    }

    @Override
    public int hashCode() {
        return Objects.hash(structurePro, eleve);
    }
}
