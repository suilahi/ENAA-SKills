package org.enaa_skills.Repository;

import org.enaa_skills.Model.ValidationCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValidationCompetenceRepository extends JpaRepository<ValidationCompetence, Long> {
    List<ValidationCompetence> findByCompetenceId(Long competenceId);
}

