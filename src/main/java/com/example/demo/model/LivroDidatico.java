package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table (name = "LivroDidatico")
public class LivroDidatico extends Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String disciplina;
    private String nivelDeEnsino;

    public LivroDidatico(){
    }
    public LivroDidatico(String titulo, String autor, String editora,
                         int ano, int qtdEstoque, boolean alugado,
                         String disciplina, String nivelDeEnsino){
        super(titulo, autor, editora, ano, qtdEstoque, alugado);
        this.disciplina = disciplina;
        this.nivelDeEnsino = nivelDeEnsino;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getNivelDeEnsino() {
        return nivelDeEnsino;
    }

    public void setNivelDeEnsino(String nivelDeEnsino) {
        this.nivelDeEnsino = nivelDeEnsino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
