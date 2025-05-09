package br.com.hcm.ApiRestControleDeContatos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hcm.ApiRestControleDeContatos.dto.PessoaDto;
import br.com.hcm.ApiRestControleDeContatos.example.PessoaSwaggerExample;
import br.com.hcm.ApiRestControleDeContatos.model.Pessoas;
import br.com.hcm.ApiRestControleDeContatos.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/pessoas") // http://localhost:8080/api/pessoas
public class PessoasController {

	@Autowired
	private PessoaService pessoaService;

	// POST-PESSOA ----------------------
	@Operation(summary = "Este endpoint adiciona uma nova pessoa ao banco de dados.", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", examples = {
			@ExampleObject( // exemplo json para inserir uma pessoa
					name = "JSON POST-PESSOA", value = PessoaSwaggerExample.POST_PESSOA_EXAMPLE) })))
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso POST-PESSOA!", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json retorno erro 200 post-pessoa
							name = "Response 200", value = PessoaSwaggerExample.ERRO_200_EXAMPLE) })),
			@ApiResponse(responseCode = "400", description = "Caso nome seja nulo", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json retorno erro 400 post-pessoa
							name = "Response 400", value = PessoaSwaggerExample.ERRO_400_PESSOA_EXAMPLE) })), })
	@PostMapping // POST http://localhost:8080/api/pessoas
	public ResponseEntity<Pessoas> save(@RequestBody Pessoas pessoa) {
		Pessoas newPessoa = pessoaService.save(pessoa);
		return ResponseEntity.ok(newPessoa);
	}

	// GET-PESSOAS ----------------------
	@Operation(summary = "Este endpoint retorna todas as pessoas que estão no banco de dados.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso GET-PESSOAS", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json retorno erro 404 get-pessoa-findAll
							name = "Response 200", value = PessoaSwaggerExample.GET_200_PESSOA_FINDALL_EXAMPLE) })),
			@ApiResponse(responseCode = "404", description = "Nenhuma Pessoa no banco de dados", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json retorno erro 404 get-pessoa-findAll
							name = "Response 404", value = PessoaSwaggerExample.GET_ERRO_404_PESSOA_FINDALL_EXAMPLE) })) })
	@GetMapping // GET http://localhost:8080/api/pessoas
	public ResponseEntity<List<Pessoas>> findAll() {
		List<Pessoas> pessoas = pessoaService.findAll();
		return ResponseEntity.ok(pessoas);
	}

	// GET-PESSOA-ID ----------------------
	@Operation(summary = "Este endpoint retorna uma pessoa pelo id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso GET-PESSOA-ID", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json retorno erro 200 get-pessoa-findById
							name = "Response 200", value = PessoaSwaggerExample.ERRO_200_EXAMPLE) })),
			@ApiResponse(responseCode = "404", description = "Id não encontrado", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json retorno erro 404 get-pessoa-findById
							name = "Response 404", value = PessoaSwaggerExample.ERRO_404_EXAMPLE) })) })
	@GetMapping("/{id}") // GET http://localhost:8080/api/pessoas/{id}
	public ResponseEntity<Optional<Pessoas>> findById(@PathVariable Long id) {
		Optional<Pessoas> pessoa = pessoaService.findById(id);
		return ResponseEntity.ok(pessoa);
	}

	// GET-PESSOA-MALA-DIRETA ----------------------
	@Operation(summary = "Este endpoint retorna uma pessoa através do id informado e devolve somente [nome, endereço, cep, cidade e uf].")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso GET-PESSOA-MALA-DIRETA", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json retorno erro 200 get-pessoa-malaDireta
							name = "Response 200", value = PessoaSwaggerExample.GET_200_PESSOA_MALADIRETA_EXAMPLE) })),
			@ApiResponse(responseCode = "404", description = "Id não encontrado", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json retorno erro 404 get-pessoa-malaDireta
							name = "Response 404", value = PessoaSwaggerExample.ERRO_404_EXAMPLE) })) })
	@GetMapping("/maladireta/{id}") // GET http://localhost:8080/api/pessoas/maladireta/{id}
	public ResponseEntity<Optional<PessoaDto>> malaDireta(@PathVariable Long id) {
		Optional<PessoaDto> pessoaDto = pessoaService.findByIdMalaDireta(id);
		return ResponseEntity.ok(pessoaDto);
	}

	// PUT-PESSOA ----------------------
	@Operation(summary = "Este endpoint atualiza os dados da pessoa, deve ser informado o id e a pessoa deve existir no banco de dados!", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", examples = {
			@ExampleObject( // exemplo json para atualizar uma pessoa
					name = "JSON PUT-PESSOA", value = PessoaSwaggerExample.PUT_PESSOA_EXAMPLE) })))
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso PUT", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json retorno erro 200 put-pessoa
							name = "Response 200", value = PessoaSwaggerExample.PUT_RESPONSE_PESSOA_EXAMPLE) })),
			@ApiResponse(responseCode = "400", description = "Caso nome seja nulo", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json retorno erro 400 put-pessoa
							name = "Response 400", value = PessoaSwaggerExample.ERRO_400_PESSOA_EXAMPLE) })),
			@ApiResponse(responseCode = "404", description = "Id não encontrado", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json retorno erro 404 put-pessoa
							name = "Response 404", value = PessoaSwaggerExample.ERRO_404_EXAMPLE) })) })
	@PutMapping("/{id}") // PUT http://localhost:8080/api/pessoas/{id}
	public ResponseEntity<Pessoas> update(@PathVariable Long id, @RequestBody Pessoas pessoa) {
		pessoa.setId(id);
		Pessoas upPessoa = pessoaService.update(pessoa);
		return ResponseEntity.ok(upPessoa);
	}

	// DELETE-PESSOA ----------------------
	@Operation(summary = "Este endpoint deleta os dados da pessoa no banco de dados apartir do id informado.")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Sucesso DELETE"),
			@ApiResponse(responseCode = "404", description = "Id não encontrado", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json retorno erro 404 delete-pessoa
							name = "Response 404", value = PessoaSwaggerExample.ERRO_404_EXAMPLE) })) })
	@DeleteMapping("/{id}") // DELETE http://localhost:8080/api/pessoas/{id}
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
