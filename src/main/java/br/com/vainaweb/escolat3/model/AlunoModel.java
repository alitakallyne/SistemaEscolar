  package br.com.vainaweb.escolat3.model;


import org.hibernate.validator.constraints.br.CPF;

import br.com.vainaweb.escolat3.dto.DadosAluno;
import br.com.vainaweb.escolat3.dto.DadosAtualizadoAluno;
import br.com.vainaweb.escolat3.dto.DadosAtualizados;
import br.com.vainaweb.escolat3.dto.EnderecoDTO;
import br.com.vainaweb.escolat3.enums.Curso;
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
@Table(name = "tb_alunos")
public class AlunoModel {
	
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
    
    private String telefone;
    
    private Curso curso;
        
    @Embedded
    private Endereco endereco;
	    
	    
    public AlunoModel(DadosAluno dados) {
    	this.nome = dados.nome();
    	this.email = dados.email();
    	this.cpf = dados.cpf();
    	this.telefone = dados.telefone();
    	this.endereco = new Endereco(
    			dados.endereco().cep(),
				dados.endereco().lougradourado(),
				dados.endereco().bairro(), 
				dados.endereco().ciadade(), 
				dados.endereco().uf(),
				dados.endereco().complemento(),
				dados.endereco().numero());
    }
	    
    
	public void atualizarInfo(@Valid DadosAtualizadoAluno dados) {
		this.nome = dados.nome() != null ? dados.nome() : this.nome;  
		this.email = dados.email()  != null ? dados.nome() : this.email;
		this.telefone = dados.telefone() != null ? dados.telefone() : this.telefone;
		
		if (dados.endereco() != null) {
	        EnderecoDTO endereco = dados.endereco();
	        
	        this.endereco.setBairro( endereco.bairro() != null ? endereco.bairro() : this.endereco.getBairro());
	        this.endereco.setCep(endereco.cep() != null ? endereco.cep() : this.endereco.getCep());
	        this.endereco.setCiadade( endereco.ciadade() != null ? endereco.ciadade() : this.endereco.getCiadade());
	        this.endereco.setLougradourado(endereco.lougradourado() != null ? endereco.lougradourado() : this.endereco.getLougradourado());
	        this.endereco.setUf( endereco.uf() != null ? endereco.uf() : this.endereco.getUf());
	        this.endereco.setComplemento(endereco.complemento() != null ? endereco.complemento() : this.endereco.getComplemento());
	        this.endereco.setNumero(endereco.numero() != 0 ? endereco.numero() : this.endereco.getNumero());
	    }
	}

}
