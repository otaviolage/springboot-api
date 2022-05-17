package com.cursos.api_cursos.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindCursoDto {
    private Integer id;
    private String nome;
    private Integer preco;
    private DisciplinaDto disciplina;
    private FornecedorDto fornecedor;
}