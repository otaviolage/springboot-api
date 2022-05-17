package com.cursos.api_cursos.repositories;

import java.util.List;

import com.cursos.api_cursos.entities.Curso;
import com.cursos.api_cursos.models.FindCursoDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
  List<Curso> findByNomeLike(String nome);

  @Query(value = "SELECT * FROM TB_DISCIPLINA D right join (TB_CURSO C left join TB_FORNECEDOR F ON C.FORNECEDOR_ID = F.ID) ON D.ID = C.DISCIPLINA_ID WHERE C.ID = :id;",
    nativeQuery = true)
  FindCursoDto findCursoById(@Param("id") int id);

  // @Query("SELECT C.ID, C.NOME, C.PRECO, D.NOME, D.NIVEL, F.NOME  FROM TB_DISCIPLINA D right join (TB_CURSO C left join TB_FORNECEDOR F ON C.FORNECEDOR_ID = F.ID) ON D.ID = C.DISCIPLINA_ID;")
  // List<FindCursoDto> findAllCursos();

  // // @Query(value = "select count(*) from tb_usuario where perfil_id = :id",
  // // nativeQuery = true)
  // // Integer countUsuario(@Param("id") int id);

  // @Query(value = "select count(u) from Usuario u where u.perfil = :p")
  // Integer countUsuario(@Param("p") Curso p);

  // Integer countById(@Param("id") int id);
}
