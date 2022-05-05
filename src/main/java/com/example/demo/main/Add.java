package com.example.demo.main;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;


@RestController
@RequestMapping(value ="/add")
public class Add {
    @GetMapping
	public String add() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        ProdutoService produtoService = ctx.getBean(ProdutoService.class);
      
        produtoService.addAll(Arrays.asList(
                new Produto(1, "Laranja"),
                new Produto(2, "Limao"),
                new Produto(3, "Pera"),
                new Produto(4, "Morango"),
                new Produto(5, "Maracuja")
                ));
        
        System.out.println(produtoService.findAll());

        ctx.close();
    	
        return "Add success!";
	}
}
