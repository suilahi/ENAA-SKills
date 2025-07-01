package org.enaa_skills.Repository;

import org.enaa_skills.Model.SousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SousCompetenceRepository  extends JpaRepository<SousCompetence, Long> {
    List<SousCompetence> findByCompetenceId(Long competenceId);

}

