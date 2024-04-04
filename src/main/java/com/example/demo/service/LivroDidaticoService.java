package com.example.demo.service;
import com.example.demo.model.LivroBiografia;
import com.example.demo.repository.LivroDidaticoRepository;
import com.example.demo.model.LivroDidatico;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class LivroDidaticoService implements LivroService<LivroDidatico> {
    private final LivroDidaticoRepository livroDidaticoRepository;

    @Autowired
    public LivroDidaticoService(LivroDidaticoRepository livroDidaticoRepository) {
        this.livroDidaticoRepository = livroDidaticoRepository;

    }

    @Override
    public List<LivroDidatico> listar() {
        return livroDidaticoRepository.findAll();
    }

    @Override
    public LivroDidatico criar(LivroDidatico livro) {
        return livroDidaticoRepository.save(livro);
    }

    @Override
    public LivroDidatico atualizar(LivroDidatico livro, Long id) {
        if (livroDidaticoRepository.existsById(id)) {
            livro.setId(id);
            return livroDidaticoRepository.save(livro);
        } else {
            System.out.println("livro não encontrado");
            return null;
        }
    }
    @Override
    public boolean deletar(Long id) {
        if (livroDidaticoRepository.existsById(id)) {
            livroDidaticoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public LivroDidatico getLivroPeloId(Long id) {
        return livroDidaticoRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

}
