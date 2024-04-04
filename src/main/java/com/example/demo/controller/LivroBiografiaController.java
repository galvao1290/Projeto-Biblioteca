package com.example.demo.controller;

import com.example.demo.model.LivroBiografia;
import com.example.demo.model.LivroDidatico;
import com.example.demo.service.LivroBiografiaService;
import com.example.demo.service.LivroDidaticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros-biografia")
public class LivroBiografiaController {

    private final LivroBiografiaService livroBiografiaService;

    @Autowired
    public LivroBiografiaController(LivroBiografiaService livroBiografiaService) {
        this.livroBiografiaService = livroBiografiaService;
    }

    @GetMapping
    public ResponseEntity<List<LivroBiografia>> listarLivros() {
        List<LivroBiografia> livros = livroBiografiaService.listar();
        return ResponseEntity.ok(livros);
    }

    @PostMapping
    public ResponseEntity<LivroBiografia> criarLivro(@RequestBody LivroBiografia livro) {
        LivroBiografia livroCriado = livroBiografiaService.criar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroBiografia> atualizarLivro(@PathVariable Long id, @RequestBody LivroBiografia livro) {
        LivroBiografia livroAtualizado = livroBiografiaService.atualizar(livro, id);
        if (livroAtualizado != null) {
            return ResponseEntity.ok(livroAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        if (livroBiografiaService.deletar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroBiografia> getLivroPeloId(@PathVariable Long id) {
        LivroBiografia livroBiografia = livroBiografiaService.getLivroPeloId(id);
        return ResponseEntity.ok(livroBiografia);
    }






}
