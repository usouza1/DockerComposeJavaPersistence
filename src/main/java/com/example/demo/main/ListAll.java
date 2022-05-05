package com.example.demo.main;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;


@RestController
@RequestMapping(value ="/list")
public class ListAll {
    @GetMapping
	public List<Produto> list() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ProdutoService produtoService = ctx.getBean(ProdutoService.class);

        System.out.println(produtoService.findAll());

        List<Produto> list = produtoService.findAll();

        ctx.close();
    	
        return list;
	}
}