package org.enaa_skills.Dto;

import org.enaa_skills.Model.StatutValidation;

public class SousCompetenceRequest {
    private String nom;
    private StatutValidation statut;
    private Long competenceId;

    // Getters & Setters
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public StatutValidation getStatut() {
        return statut;
    }
    public void setStatut(StatutValidation statut) {
        this.statut = statut;
    }
    public Long getCompetenceId() {
        return competenceId;
    }
    public void setCompetenceId(Long competenceId) {
        this.competenceId = competenceId;
    }
}
