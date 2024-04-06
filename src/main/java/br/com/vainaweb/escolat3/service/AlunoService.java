package br.com.vainaweb.escolat3.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat3.dto.DadosAluno;
import br.com.vainaweb.escolat3.model.AlunoModel;
import br.com.vainaweb.escolat3.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	 
	//SALVA E RETORNA 
    public Optional<AlunoModel> cadastrar (DadosAluno dados) {
    	
    	var aluno = alunoRepository.findByCpf(dados.cpf());
    	
    	if(aluno.isPresent()) {//VERIFICA SE ESTA PRESENTE 
    		if(aluno.get().getCpf() != null || aluno.get().getEmail() != null) {
    			return Optional.empty();
    		}
    	}
    	
	
    	return Optional.of(alunoRepository.save(new AlunoModel(dados)));
    		
    }

}
