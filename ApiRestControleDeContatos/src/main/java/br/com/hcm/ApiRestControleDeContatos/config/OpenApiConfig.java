package br.com.hcm.ApiRestControleDeContatos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("basicScheme",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
				.info(new Info().title("API de Controle de Contatos").description(
						"Esta é uma API RESTful que foi desenvolvida em Java e Spring Boot, permite gerenciar o cadastro de Pessoas e seus respectivos Contatos. Cada pessoa pode ter vários contatos (TELEFONE, CELULAR ou EMAIL), a API oferece operações CRUD(CREATE, READ, UPDATE e DELETE) para ambas entidades (Pessoas e Contatos)")
						.contact(new Contact().name("Nome").email("Email").url("URL")).version("v1.0.1"));
	}
}