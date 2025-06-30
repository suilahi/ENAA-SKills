package org.enaa_skills.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ValidationSousCompetence {
    @Id
    @GeneratedValue
    private Long id;

    private boolean valide;

    @ManyToOne
    private SousCompetence sousCompetence;

    @ManyToOne
    private Apprenant apprenant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public SousCompetence getSousCompetence() {
        return sousCompetence;
    }

    public void setSousCompetence(SousCompetence sousCompetence) {
        this.sousCompetence = sousCompetence;
    }

    public Apprenant getApprenant() {
        return apprenant;
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }
}
