package senai.aluno.Barbearia_API.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.aluno.Barbearia_API.entity.Corte;
import senai.aluno.Barbearia_API.service.CorteService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cortes")
public class CorteController {

    private final CorteService service;

    public CorteController(CorteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Corte corte) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(corte));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Corte> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable UUID id) {
        try {
            return ResponseEntity.ok(service.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable UUID id, @RequestBody Corte corte) {
        try {
            return ResponseEntity.ok(service.atualizar(id, corte));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable UUID id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}