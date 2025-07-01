package org.enaa_skills.Services;

import org.enaa_skills.Model.Competence;
import org.enaa_skills.Model.SousCompetence;
import org.enaa_skills.Model.StatutValidation;
import org.enaa_skills.Repository.CompetenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetenceService {

    @Autowired
    private CompetenceRepository repository;

    public List<Competence> getAll() {
        return repository.findAll();
    }

    public Optional<Competence> getById(Long id) {
        return repository.findById(id);
    }

    public Competence save(Competence competence) {
        return repository.save(competence);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void updateStatutIfNeeded(Long competenceId) {
        Competence competence = repository.findById(competenceId)
                .orElseThrow(() -> new IllegalArgumentException("Compétence non trouvée"));

        List<SousCompetence> sousCompetences = competence.getSousCompetences();
        long total = sousCompetences.size();
        long valides = sousCompetences.stream()
                .filter(sc -> sc.getStatut() == StatutValidation.VALIDE)
                .count();

        if (total > 0 && valides >= Math.ceil(total / 2.0)) {
            competence.setStatut(StatutValidation.VALIDE);
        } else {
            competence.setStatut(StatutValidation.NON_VALIDE);
        }

        repository.save(competence);
    }
}
