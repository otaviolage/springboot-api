package com.cursos.api_cursos.repositories;

import java.util.List;

import com.cursos.api_cursos.entities.Fornecedor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, String> {
  List<Fornecedor> findById(Integer id);
}
