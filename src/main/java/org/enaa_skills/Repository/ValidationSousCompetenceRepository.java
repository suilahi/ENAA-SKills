package org.enaa_skills.Repository;

import org.enaa_skills.Model.ValidationSousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValidationSousCompetenceRepository extends JpaRepository<ValidationSousCompetence, Long> {
    List<ValidationSousCompetence> findBySousCompetenceId(Long sousCompetenceId);
}
