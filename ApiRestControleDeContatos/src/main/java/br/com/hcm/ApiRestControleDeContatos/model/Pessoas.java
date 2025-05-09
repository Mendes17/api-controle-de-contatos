package br.com.hcm.ApiRestControleDeContatos.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // falando ao Spring que esta classe é uma entidade
@Table(name = "tb_pessoas") // criando uma tabela chamada "tb_pessoas" no banco de dados
public class Pessoas {

	@Id // definindo o id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremento
	private Long id; // Long para ter problema de quantidade no banco de dados

	@Column(nullable = false) // criando uma coluna na tabela "tb_pessoas" e dizendo que ela não pode voltar
								// "null
	private String nome;

	@Column // criando colunas na tabela, pode ser "null"
	private String endereco;

	@Column
	private String cep;

	@Column
	private String cidade;

	@Column
	private String uf;

	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true) // uma pessoa para varios contatos e (mappedBy) para não gerar outra tabela
								// automaticamente no H2
	@JsonIgnore
	private List<Contatos> contato;

	// Construtores
	public Pessoas() {
	}

	public Pessoas(Long id, String nome, String endereco, String cep, String cidade, String uf,
			List<Contatos> contato) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}

	// Getters e Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Contatos> getContato() {
		return contato;
	}

	public void setContato(List<Contatos> contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "[" + "nome: " + nome + ", " + "endereco: " + endereco + ", " + "cep:" + cep + ", " + "cidade:" + cidade
				+ ", " + "uf: " + uf + "]";

	}

}
