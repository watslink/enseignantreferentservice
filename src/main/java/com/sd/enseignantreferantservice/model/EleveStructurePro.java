package com.sd.enseignantreferantservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(EleveStructurePro.class)
public class EleveStructurePro {

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
}
