package br.com.vainaweb.escolat3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.vainaweb.escolat3.model.ColaboradorModel;
import br.com.vainaweb.escolat3.service.ColaboradorService;

@RestController
@RequestMapping("/Colaborador-hello")
public class ColaboradorController {
	
	@Autowired //Retorna o controle para o spring container
	private ColaboradorService colaboradorService;
	

	@GetMapping
	public List<ColaboradorModel> encontrarColaboradores() {
		return colaboradorService.encontrarColaboradores();
	}
	
	
	@GetMapping("/{id}")
	public Optional<ColaboradorModel> encontrarUmColaboradorPorId(@PathVariable Long id) {
		 var c = colaboradorService.encontrarUmColaborador(id);
		return c;
	}
	
//	@PostMapping
//	public String cadastrarColaborador(@RequestBody DadosColaborador dados) {
//		colaborador.cadastrar(dados);
//	
//			
//    }
	
}
