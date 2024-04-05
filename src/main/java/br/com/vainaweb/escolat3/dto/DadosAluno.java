package br.com.vainaweb.escolat3.dto;

import br.com.vainaweb.escolat3.enums.Curso;

public record DadosAluno(String nome, String cpf,String email,Curso curso) {

}
