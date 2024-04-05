package br.com.vainaweb.escolat3.model;



import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat3.dto.DadosAtualizados;
import br.com.vainaweb.escolat3.dto.DadosColaborador;
import br.com.vainaweb.escolat3.dto.EnderecoDTO;
import br.com.vainaweb.escolat3.enums.Cargo;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_colaboradores")
public class ColaboradorModel {
	
	

    public ColaboradorModel( String nome, String email, String cpf, Cargo cargo,EnderecoDTO endereco) {

		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cargo = cargo;
		this.endereco = new Endereco(endereco.cep(),endereco.lougradourado(),endereco.ciadade(),endereco.bairro(),endereco.uf()
				,endereco.complemento(),endereco.numero());
	}


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
   
	private String nome;
	
	@Email
	 @Column(unique = true)
	private String email;
	 
	@CPF
	 @Column(unique = true)
	private String cpf;
	 
	private Cargo cargo;
	
	@Embedded //Os atributos de endereco farão parte da tabela colaborador em uma unica tabela so
	private Endereco endereco;
	
	
	public ColaboradorModel(DadosColaborador dados) {
		
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.email = dados.email();
		this.cargo = dados.cargo();
	}


	public void atualizarInfo(@Valid DadosAtualizados dados) {
		this.nome = dados.nome() != null ? dados.nome() : this.nome;  
		this.email = dados.email()  != null ? dados.nome() : this.email;
	}

}
