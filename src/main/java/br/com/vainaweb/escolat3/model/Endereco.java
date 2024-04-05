package br.com.vainaweb.escolat3.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Embeddable //Permite que a classe seja incorparada em outra tabela
public class Endereco {
	
	private String cep;
	private String lougradourado;
	private String ciadade;
	private String bairro;
	private String uf;
	private String complemento;
	private int numero;
	
	
	
	
	

	

}
