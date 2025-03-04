package br.com.hcm.ApiRestControleDeContatos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.hcm.ApiRestControleDeContatos.exception.EntityException;
import br.com.hcm.ApiRestControleDeContatos.exception.IndexArrayException;
import br.com.hcm.ApiRestControleDeContatos.exception.NullException;
import br.com.hcm.ApiRestControleDeContatos.model.Contatos;
import br.com.hcm.ApiRestControleDeContatos.model.Pessoas;
import br.com.hcm.ApiRestControleDeContatos.repository.ContatoRepository;
import br.com.hcm.ApiRestControleDeContatos.repository.PessoaRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	// CREATE
	public Contatos save(Contatos contato) {

		if (contato.getTipoContato() == null)
			throw new NullException("O tipo de contato não pode ser nulo!");
		if (contato.getContato() == null)
			throw new NullException("contato não pode ser nulo!");
		Optional<Pessoas> findId = pessoaRepository.findById(contato.getPessoa().getId());
		if (findId.isEmpty())
			throw new EntityException();
		return contatoRepository.save(contato);
	}

	// READ
	public List<Contatos> findAll(Long id) {
		if (pessoaRepository.findById(id).isEmpty())
			throw new EntityException();
		if (contatoRepository.findByPessoaId(id).size() == 0)
			throw new IndexArrayException("a pessoa não tem nenhum tipo de contato");
		return contatoRepository.findByPessoaId(id);
	}

	// READ
	public Optional<Contatos> findById(Long id) {
		if (contatoRepository.findById(id).isEmpty())
			throw new EntityException();
		return contatoRepository.findById(id);
	}

	// UPDATE
	public Contatos update(@PathVariable Long id, Contatos contato) {
		Optional<Contatos> findContato = contatoRepository.findById(id);
		if (contato.getTipoContato() == null)
			throw new NullException("O tipo de contato não pode ser nulo!");
		if (contato.getContato() == null)
			throw new NullException("contato não pode ser nulo!");
		if (findContato.isEmpty())
			throw new EntityException();
		Contatos updContato = findContato.get();
		updContato.setTipoContato(contato.getTipoContato());
		updContato.setContato(contato.getContato());
		return contatoRepository.save(updContato);
	}

	// DELETE
	public void delete(Long id) {
		if (contatoRepository.findById(id).isEmpty())
			throw new EntityException();
		contatoRepository.deleteById(id);
	}
}
