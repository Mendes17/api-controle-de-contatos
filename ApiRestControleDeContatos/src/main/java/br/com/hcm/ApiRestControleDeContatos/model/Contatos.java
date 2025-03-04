package br.com.hcm.ApiRestControleDeContatos.model;

import java.util.Objects;

import br.com.hcm.ApiRestControleDeContatos.enums.TipoContato;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contatos")

public class Contatos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.ORDINAL) // o valor que vai retornar no BD vai ser a posição ordinal do enum
	private TipoContato tipoContato;
	
	@Column(nullable = false)
	private String contato;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id", nullable = false)
	private Pessoas pessoa;
	
	public Contatos() {}

	public Contatos(Long id, TipoContato tipoContato, String contato, Pessoas pessoa) {
		this.id = id;
		this.tipoContato = tipoContato;
		this.contato = contato;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Pessoas getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoas pessoa) {
		this.pessoa = pessoa;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(contato, tipoContato);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contatos other = (Contatos) obj;
		return Objects.equals(contato, other.contato) && tipoContato == other.tipoContato;
	}

	@Override
	public String toString() {
		return "Contatos: ["
				+ "id: " + id + ", "
						+ "tipoContato: " + tipoContato + ", "
								+ "contato: " + contato + ", "
										+ "pessoa: " + pessoa + "]";
	}
	
	
	
}
