package org.enaa_skills.Controllers;

import org.enaa_skills.Model.Competence;
import org.enaa_skills.Services.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/competences")
public class CompetenceController {

    @Autowired
    private CompetenceService service;

    @GetMapping
    public List<Competence> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competence> getById(@PathVariable Long id) {
        Optional<Competence> competence = service.getById(id);
        return competence.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Competence create(@RequestBody Competence competence) {
        return service.save(competence);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competence> update(@PathVariable Long id, @RequestBody Competence updated) {
        Optional<Competence> existing = service.getById(id);
        if (!existing.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        updated.setId(id);
        Competence saved = service.save(updated);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Competence> existing = service.getById(id);
        if (!existing.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
