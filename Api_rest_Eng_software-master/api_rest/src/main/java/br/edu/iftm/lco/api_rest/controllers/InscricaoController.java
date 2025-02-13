package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Inscricao;
import services.InscricaoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/inscricao")
@CrossOrigin(origins = "*")
public class InscricaoController {

    @Autowired
    private InscricaoService inscricaoService;

    @GetMapping
    public ResponseEntity <List<Inscricao>> findAll() {
        List<Inscricao> inscricao = inscricaoService.findAll();
        return ResponseEntity.ok(inscricao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> findById(@PathVariable Long id) {
        return inscricaoService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Inscricao> create(@RequestBody Inscricao inscricao) throws Throwable {
        Inscricao createdInscricao = inscricaoService.insert(inscricao);
        return ResponseEntity.ok(createdInscricao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscricao> update(@PathVariable Long id, @RequestBody
    Inscricao inscricao) {
        Inscricao updatedInscricao = inscricaoService.update(id, inscricao);
        return ResponseEntity.ok(updatedInscricao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    inscricaoService.deleteById(id);
    return ResponseEntity.noContent().build();
    }
    
}
