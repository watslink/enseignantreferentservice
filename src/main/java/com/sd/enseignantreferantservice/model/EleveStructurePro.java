package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class EleveStructurePro implements Serializable {


    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PK implements Serializable {
        private Integer structurePro;

        private Integer eleve;

    }

    @EmbeddedId
    private PK pk;


    @ManyToOne
    @MapsId("structurePro")
    @JoinColumn(name = "structure_pro_id")
    private StructurePro structurePro;

    @ManyToOne
    @MapsId("eleve")
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;

    @Temporal(TemporalType.DATE)
    private Date dateNotification;

    @Override
    @Generated
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EleveStructurePro that = (EleveStructurePro) o;
        return structurePro.equals(that.structurePro) &&
                eleve.equals(that.eleve);
    }

    @Override
    @Generated
    public int hashCode() {
        return Objects.hash(structurePro, eleve);
    }
}
