package com.example.demo.service;

import com.example.demo.model.LivroBiografia;
import com.example.demo.repository.LivroBiografiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroBiografiaService implements LivroService<LivroBiografia> {
    private final LivroBiografiaRepository livroBiografiaRepository;

    @Autowired
    public LivroBiografiaService(LivroBiografiaRepository livroBiografiaRepository) {
        this.livroBiografiaRepository = livroBiografiaRepository;
    }

    @Override
    public List<LivroBiografia> listar() {
        return livroBiografiaRepository.findAll();
    }

    @Override
    public LivroBiografia criar(LivroBiografia livro) {
        return livroBiografiaRepository.save(livro);
    }

    @Override
    public LivroBiografia atualizar(LivroBiografia livro, Long id) {
        if (livroBiografiaRepository.existsById(id)) {
            livro.setId(id);
            return livroBiografiaRepository.save(livro);
        } else {
            System.out.println("livro não encontrado");
            return null;
        }

    }

    @Override
    public boolean deletar(Long id) {
        if (livroBiografiaRepository.existsById(id)) {
            livroBiografiaRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public LivroBiografia getLivroPeloId(Long id) {
        return livroBiografiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }



}
