package org.enaa_skills.Repository;

import org.enaa_skills.Model.SousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SousCompetenceRepository  extends JpaRepository<SousCompetence, Long> {
    List<SousCompetence> findByCompetenceId(Long competenceId);
    @Query(value = "SELECT COUNT(*) FROM sous_competences WHERE statut = 'valide'", nativeQuery = true)
    Long countSousCompetencesValide();
}

