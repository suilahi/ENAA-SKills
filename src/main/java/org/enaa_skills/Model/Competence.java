package org.enaa_skills.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "competences")
public class Competence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;

    @Enumerated(EnumType.STRING)
    private StatutValidation statut;

    @OneToMany(mappedBy = "competence", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<SousCompetence> sousCompetences;

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatutValidation getStatut() {
        return statut;
    }

    public void setStatut(StatutValidation statut) {
        this.statut = statut;
    }

    public List<SousCompetence> getSousCompetences() {
        return sousCompetences;
    }

    public void setSousCompetences(List<SousCompetence> sousCompetences) {
        this.sousCompetences = sousCompetences;
    }
}
