package br.com.hcm.ApiRestControleDeContatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hcm.ApiRestControleDeContatos.model.Contatos;

public interface ContatoRepository extends JpaRepository<Contatos, Long> {
	List<Contatos> findByPessoaId(Long pessoa_id); // retorna todos os contatos com o id específicado
}
