package com.cursos.api_cursos.repositories;

import com.cursos.api_cursos.entities.Disciplina;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, String> {
  Disciplina findById(Integer id);
}
