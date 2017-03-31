package com.example.api.v1.controller;

import com.example.model.Pessoa;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class Controller {
    @Value("${com.exemplo.value:valor-padrão}")
    private String value;

    @RequestMapping("/get")
    public String get() {
        return value;
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Object post(@RequestParam("nome") String nome, @RequestParam("idade") int idade, @RequestHeader("idade") int idade2) {
        System.out.println("idade = " + idade);
        System.out.println("nome = " + nome);
        return idade2;
    }
}

