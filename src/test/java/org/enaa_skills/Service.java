package org.enaa_skills;

import org.enaa_skills.Model.Competence;
import org.enaa_skills.Repository.CompetenceRepository;
import org.enaa_skills.Services.CompetenceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Service {
    @Mock
    private CompetenceRepository competenceRepository;

    @InjectMocks
    private CompetenceService competenceService;

    private Competence competence;

    @BeforeEach
    void setUp() {
        competence = new Competence();
        competence.setId(1L);
    }


    @Test
    void createCompetence() {
        when(competenceRepository.save(any(Competence.class))).thenReturn(competence);
        Competence createdcompetence = competenceService.save(new Competence());
        assertThat(createdcompetence).isNotNull();
        verify(competenceRepository).save(any(Competence.class));
    }
}
