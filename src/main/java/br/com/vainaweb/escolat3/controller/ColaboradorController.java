package br.com.vainaweb.escolat3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat3.dto.DadosColaborador;
import br.com.vainaweb.escolat3.model.ColaboradorModel;
import br.com.vainaweb.escolat3.repository.ColaboradorRepository;
import br.com.vainaweb.escolat3.service.ColaboradorService;

@RestController
@RequestMapping("/Colaborador-hello")
public class ColaboradorController {
	

	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	

	@GetMapping
	public List<ColaboradorModel> encontrarColaboradores() {
		return colaboradorRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Optional<ColaboradorModel> encontrarUmColaboradorPorId(@PathVariable Long id) {
		
		return colaboradorRepository.findById(id);
	}
	
	@PostMapping
	public void cadastrarColaborador(@RequestBody DadosColaborador dados) {
		var colaborador = new ColaboradorModel(dados);
		
		colaboradorRepository.save(colaborador);
			
    }
	
}
