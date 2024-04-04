package com.example.demo.service;
import com.example.demo.model.LivroBiografia;
import com.example.demo.repository.LivroFiccaoRepository;
import com.example.demo.model.LivroFiccao;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class LivroFiccaoService implements LivroService<LivroFiccao> {
    private final LivroFiccaoRepository livroFiccaoRepository;

    @Autowired
    public LivroFiccaoService(LivroFiccaoRepository livroFiccaoRepository) {
        this.livroFiccaoRepository = livroFiccaoRepository;

    }

    @Override
    public List<LivroFiccao> listar() {
        return livroFiccaoRepository.findAll();
    }

    @Override
    public LivroFiccao criar(LivroFiccao livro) {
        return livroFiccaoRepository.save(livro);
    }

    @Override
    public LivroFiccao atualizar(LivroFiccao livro, Long id) {
        if (livroFiccaoRepository.existsById(id)) {
            livro.setId(id);
            return livroFiccaoRepository.save(livro);
        } else {
            System.out.println("livro não encontrado");
            return null;
        }
    }
    @Override
    public boolean deletar(Long id) {
        if (livroFiccaoRepository.existsById(id)) {
            livroFiccaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public LivroFiccao getLivroPeloId(Long id) {
        return livroFiccaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }



}
