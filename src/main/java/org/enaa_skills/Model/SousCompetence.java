package org.enaa_skills.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sous_competences")
public class SousCompetence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competence_id")
    private Competence competence;

    @OneToMany(mappedBy = "sousCompetence", cascade = CascadeType.ALL)
    private List<ValidationSousCompetence> validations;

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

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

    public List<ValidationSousCompetence> getValidations() {
        return validations;
    }

    public void setValidations(List<ValidationSousCompetence> validations) {
        this.validations = validations;
    }
}