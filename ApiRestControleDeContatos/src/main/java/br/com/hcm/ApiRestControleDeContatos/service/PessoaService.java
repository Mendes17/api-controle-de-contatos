package br.com.hcm.ApiRestControleDeContatos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hcm.ApiRestControleDeContatos.dto.PessoaDto;
import br.com.hcm.ApiRestControleDeContatos.exception.EntityException;
import br.com.hcm.ApiRestControleDeContatos.exception.NullException;
import br.com.hcm.ApiRestControleDeContatos.model.Pessoas;
import br.com.hcm.ApiRestControleDeContatos.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	// CREATE
	public Pessoas save(Pessoas pessoa) {
		if (pessoa.getNome() == null)
			throw new NullException("Nome não pode ser nulo!");
		return pessoaRepository.save(pessoa);
	}

	// READ
	public List<Pessoas> findAll() { // Mostra todas as pessoas
		if (pessoaRepository.findAll().size() == 0)
			return new ArrayList<Pessoas>(); // retona um array vazio
		return pessoaRepository.findAll();
	}

	// READ
	public Optional<Pessoas> findById(Long id) { // Mostra uma pessoa específica
		if (pessoaRepository.findById(id).isEmpty())
			throw new EntityException();
		return pessoaRepository.findById(id);
	}

	// READ - MALA DIRETA
	public Optional<PessoaDto> findByIdMalaDireta(Long id) {
		if (pessoaRepository.findById(id).isEmpty())
			throw new EntityException();
		return pessoaRepository.findById(id).map(this::converterPessoaDto);
	}

	private PessoaDto converterPessoaDto(Pessoas pessoa) {
		String endereco = getAddressString(pessoa.getEndereco());
		String cep = getAddressString(pessoa.getCep());
		String cidade = getAddressString(pessoa.getCidade());
		String uf = getAddressString(pessoa.getUf());

		String malaDireta = String.format("%s - CEP: %s - %s/%s", endereco, cep, cidade, uf);

		return new PessoaDto(pessoa.getId(), pessoa.getNome(), malaDireta);
	}

	private String getAddressString(String address) { // helper para retornos de string nula no pessoa mala direta
		return address != null ? address : "";
	}

	// UPDATE
	public Pessoas update(Pessoas pessoa) {
		Optional<Pessoas> findPessoa = pessoaRepository.findById(pessoa.getId());

		if (findPessoa.isEmpty()) // verifica se a pessoa
			throw new EntityException();
		if (pessoa.getNome() == null)
			throw new NullException("Nome não pode ser nulo!");

		Pessoas updPessoa = findPessoa.get();
		updPessoa.setNome(pessoa.getNome());
		updPessoa.setEndereco(pessoa.getEndereco());
		updPessoa.setCep(pessoa.getCep());
		updPessoa.setCidade(pessoa.getCidade());
		updPessoa.setUf(pessoa.getUf());
		updPessoa.setContato(pessoa.getContato());
		return pessoaRepository.save(updPessoa); // se existir, atualiza
	}

	// DELETE
	public void delete(Long id) { // deleta os dados da pessoa pelo o id fornecido
		if (pessoaRepository.findById(id).isEmpty())
			throw new EntityException();
		pessoaRepository.deleteById(id);
	}

}
