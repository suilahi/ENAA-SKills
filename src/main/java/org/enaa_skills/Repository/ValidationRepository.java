package org.enaa_skills.Repository;

import org.enaa_skills.Model.ValidationSousCompetence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepository extends JpaRepository<ValidationSousCompetence, Long> {

}
