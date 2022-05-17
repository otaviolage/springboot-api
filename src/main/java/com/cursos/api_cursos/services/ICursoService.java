package com.cursos.api_cursos.services;

import java.util.ArrayList;

import com.cursos.api_cursos.entities.Curso;
import com.cursos.api_cursos.models.CursoDto;
import com.cursos.api_cursos.models.EditCursoDto;
import com.cursos.api_cursos.models.FindCursoDto;

public interface ICursoService {
    Curso criar(CursoDto cursoDto);
    FindCursoDto findCurso(Integer id);
    ArrayList<FindCursoDto> obterCursos();
    Curso editar(Integer id, EditCursoDto dto);
    void remover(Integer id);
}
