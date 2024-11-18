package com.example.Trabalho.controlador;

import com.example.Trabalho.modelo.Tarefa;
import com.example.Trabalho.servico.ServicoTarefa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class ControladorTarefa {
    private final ServicoTarefa service;

    public ControladorTarefa(ServicoTarefa service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        return ResponseEntity.ok(service.criarTarefa(tarefa));
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        return ResponseEntity.ok(service.listarTarefas());
    }

    @PutMapping("/{id}/move")
    public ResponseEntity<Void> moverTarefa(@PathVariable Long id) {
        service.moverTarefa(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return ResponseEntity.ok(service.atualizarTarefa(id, tarefa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
        service.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }


}
