package br.com.vainaweb.escolat3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat3.dto.DadosAluno;
import br.com.vainaweb.escolat3.dto.DadosAtualizadoAluno;
import br.com.vainaweb.escolat3.model.AlunoModel;
import br.com.vainaweb.escolat3.repository.AlunoRepository;
import br.com.vainaweb.escolat3.service.AlunoService;

@RestController
@RequestMapping("/Aluno")

public class AlunoController {
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<AlunoModel>>  listarTodosALunos(){
		
		return ResponseEntity.ok().body(alunoRepository.findAll()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoModel> listarPorId(@PathVariable Long id) {
		return alunoRepository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	
	@PostMapping
	public ResponseEntity<AlunoModel> cadastrar(@RequestBody DadosAluno dados) {
		return alunoService.cadastrar(dados)
	            .map(aluno -> ResponseEntity.status(HttpStatus.CREATED).body(aluno))
	            .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
	
	
	@PutMapping
	public ResponseEntity<Object> atualizar(@PathVariable Long id, @RequestBody DadosAtualizadoAluno dados) {
		
		var aluno = alunoRepository.getReferenceById(id);
		aluno.atualizarInfo(dados);
		
		var alunoAtualizado = alunoRepository.save(aluno);
		if(alunoAtualizado != null) {
			return  ResponseEntity.ok(alunoAtualizado);
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Dados não foram atualizados!");
		
	}
	
	@DeleteMapping("/{id}")
	public String deletar(@PathVariable Long id) {
		
		alunoRepository.deleteById(id);
		return "Deletado com sucesso!";
	}
	
	

}
