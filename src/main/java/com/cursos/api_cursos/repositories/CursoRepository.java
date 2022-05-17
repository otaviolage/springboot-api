package com.cursos.api_cursos.repositories;

import java.util.List;

import com.cursos.api_cursos.entities.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
  List<Curso> findByNomeLike(String nome);
}
