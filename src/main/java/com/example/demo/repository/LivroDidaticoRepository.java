package com.example.demo.repository;

import com.example.demo.model.LivroDidatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LivroDidaticoRepository extends JpaRepository<LivroDidatico,Long> {

}
