package com.example.demo.controller;

import com.example.demo.model.Livro;
import com.example.demo.model.LivroBiografia;
import com.example.demo.model.LivroDidatico;
import com.example.demo.service.LivroDidaticoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro-didatico")
public class LivroDidaticoController{
    private final LivroDidaticoService livroDidaticoService;

    @Autowired
    public LivroDidaticoController(LivroDidaticoService livroDidaticoService){
        this.livroDidaticoService = livroDidaticoService;
    }

    @GetMapping
    public ResponseEntity<List<LivroDidatico>> listarLivros(){
        List<LivroDidatico> livros = livroDidaticoService.listar();
        return ResponseEntity.ok(livros);

    }

    @PostMapping
    public ResponseEntity<LivroDidatico> criarLivro(@RequestBody LivroDidatico livro){
        LivroDidatico livroCriado = livroDidaticoService.criar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDidatico> atualizarLivro(@PathVariable Long id, @RequestBody LivroDidatico livro) {
        LivroDidatico livroAtualizado = livroDidaticoService.atualizar(livro, id);
        if (livroAtualizado != null) {
            return ResponseEntity.ok(livroAtualizado);


        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        if (livroDidaticoService.deletar(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<LivroDidatico> getLivroPeloId(@PathVariable Long id) {
        LivroDidatico livroDidatico = livroDidaticoService.getLivroPeloId(id);
        return ResponseEntity.ok(livroDidatico);
    }

}    