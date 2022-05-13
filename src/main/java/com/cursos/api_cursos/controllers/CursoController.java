package com.cursos.api_cursos.controllers;

import javax.validation.Valid;

import com.cursos.api_cursos.entities.Curso;
import com.cursos.api_cursos.models.CursoDto;
import com.cursos.api_cursos.services.CursoService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/curso")
public class CursoController {
    private CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save (@Valid @RequestBody CursoDto dto){
        Curso curso = cursoService.criar(dto);
        return curso.getId();
    }

    // @GetMapping("{id}")
    // public DadosUsuarioDTO getById(@PathVariable Integer id){
    //     return usuarioService.obterUsuarioPorId(id);
    // }

    // @GetMapping
    // public ArrayList<DadosUsuarioDTO>  getAll(){
    //     return usuarioService.obterUsuarios();
    // }

    // @DeleteMapping("{id}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public void delete (@PathVariable Integer id){
    //     usuarioService.remover(id);
    // }

    // @PutMapping("{id}")
    // @ResponseStatus(HttpStatus.NO_CONTENT)
    // public void edit(@PathVariable Integer id, @RequestBody UsuarioDTO dto){
    //     usuarioService.editar(id,dto);
    // }
}
