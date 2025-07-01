package org.enaa_skills.Services;

import org.enaa_skills.Model.Competence;
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
}
