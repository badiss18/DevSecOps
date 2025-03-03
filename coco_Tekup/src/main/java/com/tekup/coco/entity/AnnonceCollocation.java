package com.tekup.coco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tekup.coco.entity.enummeration.Type_Anno_Collo;
import com.tekup.coco.entity.enummeration.Type_Logement;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "AnnonceCollocation")
public class AnnonceCollocation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date_dispo;
    private Long nbre_chmbre;
    private String descrption;
    private Long Montant;
    private Long nbre_person;

    public void setImageModels(Set<ImageModel> imageModels) {
        this.imageModels = imageModels;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "collocation_image",
            joinColumns = @JoinColumn(name = "collocation_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id"))
    private Set<ImageModel> imageModels;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Type_Logement typeLogement;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Type_Anno_Collo  typeAnnoColloc;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    User user;
    @OneToMany
    List<Avis> avisList = new ArrayList<>();
    @OneToMany
    //@JsonIgnore
    List<Demande_visite> demandeVisite;
}
