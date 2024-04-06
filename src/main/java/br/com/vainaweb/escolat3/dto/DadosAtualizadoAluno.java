package br.com.vainaweb.escolat3.dto;

import jakarta.validation.Valid;

public record DadosAtualizadoAluno(String nome,String email,String telefone,@Valid EnderecoDTO endereco) {

}
