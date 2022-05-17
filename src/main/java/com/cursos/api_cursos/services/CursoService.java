package com.cursos.api_cursos.services;

import java.util.ArrayList;
import java.util.List;

import com.cursos.api_cursos.entities.Curso;
import com.cursos.api_cursos.entities.Disciplina;
import com.cursos.api_cursos.entities.Fornecedor;
import com.cursos.api_cursos.models.CursoDto;
import com.cursos.api_cursos.models.DisciplinaDto;
import com.cursos.api_cursos.models.EditCursoDto;
import com.cursos.api_cursos.models.FindCursoDto;
import com.cursos.api_cursos.models.FornecedorDto;
import com.cursos.api_cursos.repositories.CursoRepository;
import com.cursos.api_cursos.repositories.DisciplinaRepository;
import com.cursos.api_cursos.repositories.FornecedorRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoService implements ICursoService {
    private final CursoRepository cursoRepository;
    private final FornecedorRepository fornecedorRepository;
    private final DisciplinaRepository disciplinaRepository;

    @Override
    @Transactional
    public Curso criar(CursoDto dto) {
        Fornecedor fornecedor = new Fornecedor(dto.getFornecedor());    
        Disciplina disciplina = new Disciplina(dto.getDisciplina(), dto.getNivel());
        
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setPreco(dto.getPreco());
        curso.setFornecedor(fornecedor);
        curso.setDisciplina(disciplina);

        fornecedorRepository.save(fornecedor);
        disciplinaRepository.save(disciplina);
        return cursoRepository.save(curso);
    }

    @Override
    public FindCursoDto findCurso(Integer id) {
        return cursoRepository.findById(id).map(c -> {
            return FindCursoDto
            .builder()
                .id(c.getId())
                .nome(c.getNome())
                .preco(c.getPreco())
                .disciplina(DisciplinaDto.builder()
                        .id(c.getDisciplina().getId())
                        .nome(c.getDisciplina().getNome())
                        .nivel(c.getDisciplina().getNivel())
                        .build())
                .fornecedor(FornecedorDto.builder()
                    .id(c.getFornecedor().getId())
                    .nome(c.getFornecedor().getNome())
                    .build())
                .build();
            })
                .orElseThrow(() -> new Error("Curso não encontrado"));
    }

    @Override
    public ArrayList<FindCursoDto> obterCursos() {
        ArrayList<FindCursoDto> dados = new ArrayList<>();

        List<Curso> cursos = cursoRepository.findAll();
        cursos.forEach(c -> {
            dados.add(
                    FindCursoDto
                    .builder()
                        .id(c.getId())
                        .nome(c.getNome())
                        .preco(c.getPreco())
                        .disciplina(DisciplinaDto.builder()
                                .id(c.getDisciplina().getId())
                                .nome(c.getDisciplina().getNome())
                                .nivel(c.getDisciplina().getNivel())
                                .build())
                        .fornecedor(FornecedorDto.builder()
                            .id(c.getFornecedor().getId())
                            .nome(c.getFornecedor().getNome())
                            .build())
                        .build());
        });
        return dados;
    }

    @Override
    @Transactional
    public Curso editar(Integer id, EditCursoDto dto) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new Error("Curso não encontrado"));

        Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplina());
        Fornecedor fornecedor = fornecedorRepository.findById(dto.getFornecedor());
    
        curso.setNome(dto.getNome());
        curso.setPreco(dto.getPreco());
        curso.setDisciplina(disciplina);
        curso.setFornecedor(fornecedor);
    
        cursoRepository.save(curso);
        return curso;
    }

    @Override
    @Transactional
    public void remover(Integer id) {
        cursoRepository.deleteById(id);
    }
}
