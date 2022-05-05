package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    /** Query via JPA **/
    @Query("select p from Produto p where p.nome = :nome")
    public List<Produto> findByName(@Param("nome") String nome);
}