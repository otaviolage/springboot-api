package com.cursos.api_cursos.services;

import com.cursos.api_cursos.entities.Curso;
import com.cursos.api_cursos.models.CursoDto;

public interface ICursoService {
    Curso criar(CursoDto cursoDto);
    // DadosUsuarioDTO obterUsuarioPorId(Integer id);
    // void remover(Integer id);
    // void editar(Integer id, UsuarioDTO dto);
    // ArrayList<DadosUsuarioDTO> obterUsuarios();
}
