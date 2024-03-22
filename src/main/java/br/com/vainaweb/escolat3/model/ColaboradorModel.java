package br.com.vainaweb.escolat3.model;

import br.com.vainaweb.escolat3.enums.Cargo;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ColaboradorModel {

    @Id
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private Cargo cargo;
	
	@Embedded //Os atributos de endereco farão parte da tabela colaborador em uma unica tabela so
	private Endereco endereco;
	
	

}
