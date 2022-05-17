package com.cursos.api_cursos.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import com.cursos.api_cursos.entities.Curso;
import com.cursos.api_cursos.models.CursoDto;
import com.cursos.api_cursos.models.EditCursoDto;
import com.cursos.api_cursos.models.FindCursoDto;
import com.cursos.api_cursos.services.CursoService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("{id}")
    public FindCursoDto getById(@PathVariable Integer id){
        return cursoService.findCurso(id);
    }

    @GetMapping
    public ArrayList<FindCursoDto> getAll(){
        return cursoService.obterCursos();
    }
    
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Curso edit(@PathVariable Integer id, @RequestBody EditCursoDto dto){
        Curso curso = cursoService.editar(id,dto);
        return curso;
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Integer id){
        cursoService.remover(id);
    }
}
