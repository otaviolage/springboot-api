package com.cursos.api_cursos.repositories;

import com.cursos.api_cursos.entities.Fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {
  Fornecedor findById(Integer id);
}
