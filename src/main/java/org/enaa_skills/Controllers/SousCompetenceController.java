package org.enaa_skills.Controllers;

import org.enaa_skills.Dto.SousCompetenceRequest;
import org.enaa_skills.Model.SousCompetence;
import org.enaa_skills.Services.SousCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sous-competences")
public class SousCompetenceController {

    @Autowired
    private SousCompetenceService sousCompetenceService;

    @GetMapping
    public List<SousCompetence> getAll() {
        return sousCompetenceService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SousCompetence> getById(@PathVariable Long id) {
        return sousCompetenceService.getById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SousCompetence> create(@RequestBody SousCompetenceRequest request) {
        try {
            SousCompetence saved = sousCompetenceService.create(request);
            return ResponseEntity.ok(saved);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<SousCompetence> update(@PathVariable Long id, @RequestBody SousCompetenceRequest request) {
        try {
            SousCompetence saved = sousCompetenceService.update(id, request);
            return ResponseEntity.ok(saved);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            sousCompetenceService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/competence/{competenceId}")
    public ResponseEntity<List<SousCompetence>> getByCompetenceId(@PathVariable Long competenceId) {
        List<SousCompetence> list = sousCompetenceService.getByCompetenceId(competenceId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("valide")
    public ResponseEntity<List<SousCompetence>> valide() {
        List<SousCompetence> list = sousCompetenceService.getAll();
        return ResponseEntity.ok(list);
    }
}
