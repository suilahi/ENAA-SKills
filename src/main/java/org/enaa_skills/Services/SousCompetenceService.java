package org.enaa_skills.Services;

import org.enaa_skills.Dto.SousCompetenceRequest;
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

    @Autowired
    private CompetenceService competenceService;

    public List<SousCompetence> getAll() {
        return sousCompetenceRepository.findAll();
    }

    public Optional<SousCompetence> getById(Long id) {
        return sousCompetenceRepository.findById(id);
    }

    public List<SousCompetence> getByCompetenceId(Long competenceId) {
        return sousCompetenceRepository.findByCompetenceId(competenceId);
    }

    public SousCompetence create(SousCompetenceRequest request) {
        Competence competence = competenceRepository.findById(request.getCompetenceId())
                .orElseThrow(() -> new IllegalArgumentException("Compétence non trouvée"));

        SousCompetence sc = new SousCompetence();
        sc.setNom(request.getNom());
        sc.setStatut(request.getStatut());
        sc.setCompetence(competence);

        SousCompetence saved = sousCompetenceRepository.save(sc);
        competenceService.updateStatutIfNeeded(competence.getId());
        return saved;
    }

    public SousCompetence update(Long id, SousCompetenceRequest request) {
        SousCompetence existing = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sous-compétence non trouvée"));

        existing.setNom(request.getNom());
        existing.setStatut(request.getStatut());

        if (request.getCompetenceId() != null) {
            Competence competence = competenceRepository.findById(request.getCompetenceId())
                    .orElseThrow(() -> new IllegalArgumentException("Compétence non trouvée"));
            existing.setCompetence(competence);
        }

        SousCompetence saved = sousCompetenceRepository.save(existing);
        competenceService.updateStatutIfNeeded(saved.getCompetence().getId());
        return saved;
    }

    public void delete(Long id) {
        SousCompetence existing = sousCompetenceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sous-compétence non trouvée"));
        sousCompetenceRepository.delete(existing);
        competenceService.updateStatutIfNeeded(existing.getCompetence().getId());
    }
}
