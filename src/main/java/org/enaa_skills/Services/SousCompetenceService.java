package org.enaa_skills.Services;

import org.enaa_skills.Model.Competence;
import org.enaa_skills.Model.SousCompetence;
import org.enaa_skills.Repository.CompetenceRepository;
import org.enaa_skills.Repository.SousCompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SousCompetenceService {

    @Autowired
    private SousCompetenceRepository sousCompetenceRepository;

    @Autowired
    private CompetenceRepository competenceRepository;

    public List<SousCompetence> getAll() {
        return sousCompetenceRepository.findAll();
    }

    public Optional<SousCompetence> getById(Long id) {
        return sousCompetenceRepository.findById(id);
    }

    public List<SousCompetence> getByCompetenceId(Long competenceId) {
        return sousCompetenceRepository.findByCompetenceId(competenceId);
    }

    public SousCompetence create(SousCompetence sousCompetence) {
        if (sousCompetence.getCompetence() == null || sousCompetence.getCompetence().getId() == null) {
            throw new IllegalArgumentException("La compétence associée est obligatoire");
        }
        Long competenceId = sousCompetence.getCompetence().getId();
        Competence competence = competenceRepository.findById(competenceId)
                .orElseThrow(() -> new IllegalArgumentException("Compétence non trouvée"));

        sousCompetence.setCompetence(competence);
        return sousCompetenceRepository.save(sousCompetence);
    }

    public SousCompetence update(Long id, SousCompetence updated) {
        SousCompetence existing = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sous-compétence non trouvée"));

        existing.setNom(updated.getNom());

        if (updated.getCompetence() != null && updated.getCompetence().getId() != null) {
            Competence competence = competenceRepository.findById(updated.getCompetence().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Compétence non trouvée"));
            existing.setCompetence(competence);
        }

        return sousCompetenceRepository.save(existing);
    }

    public void delete(Long id) {
        SousCompetence existing = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sous-compétence non trouvée"));
        sousCompetenceRepository.delete(existing);
    }
}
