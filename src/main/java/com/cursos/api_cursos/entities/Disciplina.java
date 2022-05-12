package com.cursos.api_cursos.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_disciplina")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;
    
    @Column(length = 100, name="nome")
    private String nome;

    @Column(length = 100, name="nivel")
    private String nivel;

    @OneToMany(targetEntity=Disciplina.class)
    private List<Curso> curso;

    public Disciplina() {
    }

    public Disciplina(Integer id, String nome, String nivel) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
