package com.example.demo.controller;
import com.example.demo.model.Livro;
import com.example.demo.model.LivroBiografia;
import com.example.demo.model.LivroDidatico;
import com.example.demo.model.LivroFiccao;
import com.example.demo.service.LivroDidaticoService;
import com.example.demo.service.LivroFiccaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro-ficcao")
public class LivroFiccaoController {
    private final LivroFiccaoService livroFiccaoService;

    @Autowired
    public LivroFiccaoController(LivroFiccaoService livroFiccaoService){
        this.livroFiccaoService = livroFiccaoService;
    }

    @GetMapping
    public ResponseEntity<List<LivroFiccao>> listarLivros(){
        List<LivroFiccao> livros = livroFiccaoService.listar();
        return ResponseEntity.ok(livros);
    }

    @PostMapping
    public ResponseEntity<LivroFiccao> criarLivro(@RequestBody LivroFiccao livro){
        LivroFiccao livroCriado = livroFiccaoService.criar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroFiccao> atulizarLivro(@PathVariable Long id, @RequestBody LivroFiccao livro){
        LivroFiccao livroAtualizado = livroFiccaoService.atualizar(livro, id);
        if (livroAtualizado != null) {
            return ResponseEntity.ok(livroAtualizado);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id){
        if (livroFiccaoService.deletar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<LivroFiccao> getLivroPeloId(@PathVariable Long id) {
        LivroFiccao livroFiccao = livroFiccaoService.getLivroPeloId(id);
        return ResponseEntity.ok(livroFiccao);
    }








}
