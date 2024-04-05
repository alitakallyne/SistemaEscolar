package br.com.vainaweb.escolat3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat3.model.AlunoModel;
import br.com.vainaweb.escolat3.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<AlunoModel> encontrarAlunos(){
		
		return alunoRepository.findAll();
	}

}
