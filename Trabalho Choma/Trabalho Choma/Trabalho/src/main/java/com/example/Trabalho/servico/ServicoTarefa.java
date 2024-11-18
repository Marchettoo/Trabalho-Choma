package com.example.Trabalho.servico;

import com.example.Trabalho.modelo.Tarefa;
import com.example.Trabalho.repositorio.RepositorioTarefa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoTarefa {
    private final RepositorioTarefa repository;

    public ServicoTarefa(RepositorioTarefa repository) {
        this.repository = repository;
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }

    public Tarefa atualizarTarefa(Long id, Tarefa novaTarefa) {
        Tarefa tarefa = repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada."));
        tarefa.setTitulo(novaTarefa.getTitulo());
        tarefa.setDescricao(novaTarefa.getDescricao());
        tarefa.setPrioridade(novaTarefa.getPrioridade());
        tarefa.setDataLimite(novaTarefa.getDataLimite());
        return repository.save(tarefa);
    }

    public void moverTarefa(Long id) {
        Tarefa tarefa = repository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada."));
        switch (tarefa.getStatus()) {
            case A_FAZER -> tarefa.setStatus(Tarefa.Status.EM_PROGRESSO);
            case EM_PROGRESSO -> tarefa.setStatus(Tarefa.Status.CONCLUIDO);
            case CONCLUIDO -> throw new RuntimeException("A tarefa já está concluída.");
        }
        repository.save(tarefa);
    }

    public void deletarTarefa(Long id) {
        repository.deleteById(id);
    }
}
