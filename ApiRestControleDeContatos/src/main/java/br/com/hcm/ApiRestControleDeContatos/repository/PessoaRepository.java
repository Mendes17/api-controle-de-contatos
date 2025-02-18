package br.com.hcm.ApiRestControleDeContatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hcm.ApiRestControleDeContatos.model.Pessoas;

public interface PessoaRepository extends JpaRepository<Pessoas, Long>{
}
