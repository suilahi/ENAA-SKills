package org.enaa_skills;

import org.enaa_skills.Model.Competence;
import org.enaa_skills.Repository.CompetenceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class Service {

    @Autowired
    private CompetenceRepository competenceRepository;

    @Test
    void CreateCompetence() {
        Competence competence = new Competence();
        competence.setNom("Communication");
        competence.setDescription("Capacité à transmettre efficacement des informations.");

        Competence saved = competenceRepository.save(competence);

        assertThat(saved.getId()).isNotNull();
    }
}
