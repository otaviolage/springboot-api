package com.cursos.api_cursos.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDto {
    @NotEmpty(message = "Nome é obrigatório")
    private String nome;
    @NotEmpty(message = "Preço é obrigatório")
    private Integer preco;
    @NotNull(message = "Fornecedor é obrigatório")
    private String fornecedor;
    @NotNull(message = "Disciplina é obrigatório")
    private String disciplina;
    private String nivel;
}