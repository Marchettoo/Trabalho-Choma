package com.example.Trabalho.repositorio;

import com.example.Trabalho.modelo.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTarefa extends JpaRepository<Tarefa, Long> {
}
