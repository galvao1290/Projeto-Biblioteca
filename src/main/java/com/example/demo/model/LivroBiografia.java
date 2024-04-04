package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table (name = "LivroBiografia")
public class LivroBiografia extends Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String biografado;

    public LivroBiografia(){

    }
    public LivroBiografia(String titulo, String autor, String editora,
                          int ano, int qtdEstoque, boolean alugado, String biografado){
        super(titulo, autor, editora, ano, qtdEstoque, alugado);
        this.biografado = biografado;
    }

    public String getBiografado() {
        return biografado;
    }

    public void setBiografado(String biografado) {
        this.biografado = biografado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
