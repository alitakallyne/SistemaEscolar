package br.com.vainaweb.escolat3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //marca uma classe como um controlador, recebe requisições HTTP
@RequestMapping("/hello-word") // mapear uma URL específica para um método dentro desse controlador.

public class HelloController {
	
	@GetMapping
	public String saudacao(@RequestParam(defaultValue = "Alita",value = "nome")String nome ) {
		return "Hello World "+ nome;
	}

}
