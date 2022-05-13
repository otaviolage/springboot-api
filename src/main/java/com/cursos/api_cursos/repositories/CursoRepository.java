package com.cursos.api_cursos.repositories;

// import java.sql.ResultSet;
// import java.sql.SQLException;
import java.util.List;

// import javax.persistence.EntityManager;
// import javax.persistence.TypedQuery;

import com.cursos.api_cursos.entities.Curso;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.core.RowMapper;
// import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
  List<Curso> findByNomeLike(String nome);

  // @Query("select p from Curso p left join fetch p.usuarios where p.id = :id")
  // List<Curso> findCursoByIdFetchUsuarios(@Param("id") int id);

  // // @Query(value = "select count(*) from tb_usuario where perfil_id = :id",
  // // nativeQuery = true)
  // // Integer countUsuario(@Param("id") int id);

  // @Query(value = "select count(u) from Usuario u where u.perfil = :p")
  // Integer countUsuario(@Param("p") Curso p);

  // Integer countById(@Param("id") int id);
}
