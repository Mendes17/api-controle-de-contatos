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

import br.com.hcm.ApiRestControleDeContatos.example.ContatoSwaggerExample;
import br.com.hcm.ApiRestControleDeContatos.model.Contatos;
import br.com.hcm.ApiRestControleDeContatos.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	// POST-CONTATO ----------------------
	@Operation(summary = "Este endpoint adiciona um novo contato a uma Pessoa", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", examples = {
			@ExampleObject( // exemplo json post-contato
					name = "JSON POST-CONTATO", value = ContatoSwaggerExample.POST_CONTATO_EXAMPLE) })))
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso POST-CONTATO", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json erro 200
							name = "Response 200", value = ContatoSwaggerExample.GET_200_CONTATO_EXAMPLE) })),
			@ApiResponse(responseCode = "400", description = "Caso tipo contato seja nulp", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json erro 400
							name = "Response 400", value = ContatoSwaggerExample.ERRO_400_TIPO_CONTATO_EXAMPLE) })),
			@ApiResponse(responseCode = "404", description = "Id não encontrado", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json erro 404
							name = "Response 404", value = ContatoSwaggerExample.ERRO_404_CONTATO_EXAMPLE) })) })
	@PostMapping // POST http://localhost:8080/api/contatos
	public ResponseEntity<Contatos> save(@RequestBody Contatos contato) {
		Contatos newContato = contatoService.save(contato);
		return ResponseEntity.ok(newContato);
	}

	// GET-CONTATO-ID ----------------------
	@Operation(summary = "Este endpoint retorna os dados de um Contato por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso GET-CONTATO-ID", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json post-contato
							name = "Response 200", value = ContatoSwaggerExample.GET_200_CONTATO_EXAMPLE) })),
			@ApiResponse(responseCode = "404", description = "Id não encontrado", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json erro 404
							name = "Response 404", value = ContatoSwaggerExample.ERRO_404_CONTATO_EXAMPLE) })) })
	@GetMapping("/{id}") // GET http://localhost:8080/api/contatos/{id}
	public ResponseEntity<Optional<Contatos>> findById(@PathVariable Long id) {
		Optional<Contatos> contato = contatoService.findById(id);
		return ResponseEntity.ok(contato);
	}

	// GET-CONTATO-PESSOA-ID --------------
	@Operation(summary = "Este endpoint retorna uma lista de todos os Contatos de uma Pessoa")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso GET-CONTATO-PESSOA-ID", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json post-contato
							name = "Response 200", value = ContatoSwaggerExample.GET_200_CONTATO_PESSOA_ID_EXAMPLE) })),
			@ApiResponse(responseCode = "400", description = "Caso contato seja nulo", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json erro 400
							name = "Response 400", value = ContatoSwaggerExample.ERRO_400_CONTATO_EXAMPLE) })),
			@ApiResponse(responseCode = "404", description = "Existem dois tipo de 404 ('id-não-encontrado' e 'nenhum-tipo-de-contato')", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json erro 404
							name = "Response 404 - id não encontrado", value = ContatoSwaggerExample.ERRO_404_CONTATO_EXAMPLE),
					@ExampleObject( // exemplo json erro 404
							name = "Response 404 - nenhum tipo de contato", value = ContatoSwaggerExample.ERRO_404_CONTATO_PESSOA_EXAMPLE) })) })
	@GetMapping("/pessoa/{id}") // GET http://localhost:8080/api/contatos/pessoa/{id}
	public ResponseEntity<List<Contatos>> findByIdPerson(@PathVariable Long id) {
		List<Contatos> contatos = contatoService.findAll(id);
		return ResponseEntity.ok(contatos);
	}

	// PUT-CONTATO ----------------------
	@Operation(summary = "Este endpoint atualiza um contato existente (deve ser informado o ID do contato que será atualizado!)", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json", examples = {
			@ExampleObject( // exemplo json put-contato
					name = "JSON PUT-CONTATO", value = ContatoSwaggerExample.PUT_CONTATO_EXAMPLE) })))
	@ApiResponses(value = {
			@ApiResponse(responseCode = "400", description = "Existem dois tipo de erro 400 ('contato-nulo' e 'tipo-contato-nulo')", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json erro 400
							name = "Response 400 - tipo do contato nulo", value = ContatoSwaggerExample.ERRO_400_TIPO_CONTATO_EXAMPLE),
					@ExampleObject( // exemplo json erro 400
							name = "Response 400 - contato nulo", value = ContatoSwaggerExample.ERRO_400_CONTATO_EXAMPLE) })),
			@ApiResponse(responseCode = "404", description = "Id não encontrado", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json erro 404
							name = "Response 404", value = ContatoSwaggerExample.ERRO_404_CONTATO_EXAMPLE) }))

	})
	@PutMapping("/{id}") // PUT http://localhost:8080/api/contatos/{id}
	public ResponseEntity<Contatos> update(@PathVariable Long id, @RequestBody Contatos contato) {
		contato.setId(id);
		Contatos upContato = contatoService.update(id, contato);
		return ResponseEntity.ok(upContato);
	}

	// DELETE - CONTATO ----------------------
	@Operation(summary = "Este endpoint remove um contato pelo o ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Sucesso DELETE-CONTATO"),
			@ApiResponse(responseCode = "404", description = "Id não encontrado", content = @Content(mediaType = "application/json", examples = {
					@ExampleObject( // exemplo json erro 404
							name = "Response 404", value = ContatoSwaggerExample.ERRO_404_CONTATO_EXAMPLE) })) })
	@DeleteMapping("/{id}") // DELETE http://localhost:8080/api/contatos/{id}
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		contatoService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
