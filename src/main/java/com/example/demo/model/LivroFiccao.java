package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table (name = "LivroFiccao")
public class LivroFiccao extends Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estiloLiterario;

    public LivroFiccao(){

    }
    public LivroFiccao(String titulo, String autor, String editora,
                       int ano, int qtdEstoque, boolean alugado, String estiloLiterario){
        super(titulo, autor, editora, ano, qtdEstoque, alugado);
        this.estiloLiterario = estiloLiterario;
    }

    public String getEstiloLiterario() {
        return estiloLiterario;
    }

    public void setEstiloLiterario(String estiloLiterario) {
        this.estiloLiterario = estiloLiterario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
