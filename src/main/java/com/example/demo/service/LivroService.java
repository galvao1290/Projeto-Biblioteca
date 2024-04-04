package com.example.demo.service;

import com.example.demo.model.Livro;

import java.util.List;

public interface LivroService<T extends Livro> {
    List<T> listar();
    T criar(T t);
    T atualizar(T t, Long id);
    boolean deletar(Long id);

    Livro getLivroPeloId(Long id);


}