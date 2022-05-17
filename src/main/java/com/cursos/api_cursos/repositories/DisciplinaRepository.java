package com.cursos.api_cursos.repositories;

import java.util.List;

import com.cursos.api_cursos.entities.Disciplina;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, String> {
  Disciplina findById(Integer id);
}
