package com.cursos.api_cursos.repositories;

import java.util.List;

import com.cursos.api_cursos.entities.Curso;
import com.cursos.api_cursos.models.FindCursoDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
  List<Curso> findByNomeLike(String nome);
}
