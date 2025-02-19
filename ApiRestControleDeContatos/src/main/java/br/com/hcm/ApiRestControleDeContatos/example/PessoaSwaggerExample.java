package br.com.hcm.ApiRestControleDeContatos.example;

public class PessoaSwaggerExample {
	
	public static final String POST_PESSOA_EXAMPLE = "{" // exemplo json post-pessoa
            + "\"nome\": \"Henrique\", "
            + "\"endereco\": \"Rua das Flores, 555\", "
            + "\"cep\": \"05050-555\", "
            + "\"cidade\": \"Osasco\", "
            + "\"uf\": \"SP\""
            + "}";
	
	public static final String ERRO_200_EXAMPLE = "{" // exemplo json erro 200 post-pessoa
			+ "\"id\": 1, "
            + "\"nome\": \"Henrique\", "
            + "\"endereco\": \"Rua das Flores, 555\", "
            + "\"cep\": \"05050-555\", "
            + "\"cidade\": \"Osasco\", "
            + "\"uf\": \"SP\""
            + "}";
	
	public static final String ERRO_400_PESSOA_EXAMPLE = "{" // exemplo json erro 400 post-pessoa
            + "\"status\": \"BAD_REQUEST\", "
            + "\"message\": \"Nome não pode ser nulo!\"}";
	
	public static final String GET_200_PESSOA_FINDALL_EXAMPLE = "["  
            + "{" 
            + "\"id\": 1, "
            + "\"nome\": \"Henrique\", "
            + "\"endereco\": \"Rua das Flores, 555\", "
            + "\"cep\": \"05050-555\", "
            + "\"cidade\": \"Osasco\", "
            + "\"uf\": \"SP\""
            + "}, "
            
            + "{"  
            + "\"id\": 2, "
            + "\"nome\": \"Fernando Oliver\", "
            + "\"endereco\": \"Rua das Arvores, 556\", "
            + "\"cep\": \"05577-555\", "
            + "\"cidade\": \"Barueri\", "
            + "\"uf\": \"SP\""
            + "}, "
            
            + "{"  
            + "\"id\": 3, "
            + "\"nome\": \"Gabriel Silva\", "
            + "\"endereco\": \"Rua dos Rios, 557\", "
            + "\"cep\": \"06577-885\", "
            + "\"cidade\": \"Carapicuíba\", "
            + "\"uf\": \"SP\""
            + "}" 
            + "]";
	
	public static final String GET_ERRO_404_PESSOA_FINDALL_EXAMPLE = "{" // exemplo json erro 404
            + "\"status\": \"NOT_FOUND\", "
            + "\"message\": \"Não há nada adicionado ao banco de dados!!\"}";
	
	public static final String ERRO_404_EXAMPLE = "{" // exemplo json erro 404
            + "\"status\": \"NOT_FOUND\", "
            + "\"message\": \"id não encontrado!\"}";
	
	
	public static final String GET_200_PESSOA_MALADIRETA_EXAMPLE = "{"
            + "\"id\": 1, "
            + "\"nome\": \"Henrique\", "
            + "\"malaDireta\": \"Rua das flores, 555 - CEP: 05050-555 - Osasco/SP\""
            + "}";
	
	public static final String PUT_PESSOA_EXAMPLE = "{" // exemplo json put-pessoa
            + "\"nome\": \"Henrique\", "
            + "\"endereco\": \"Rua dos Ceus, 1717\", "
            + "\"cep\": \"05990-665\", "
            + "\"cidade\": \"Santana de Parnaiba\", "
            + "\"uf\": \"SP\""
            + "}";
	
	public static final String PUT_RESPONSE_PESSOA_EXAMPLE= "{" // exemplo json put-pessoa
			+ "\"id\": 1, "
            + "\"nome\": \"Henrique\", "
            + "\"endereco\": \"Rua dos Ceus, 1717\", "
            + "\"cep\": \"05990-665\", "
            + "\"cidade\": \"Santana de Parnaiba\", "
            + "\"uf\": \"SP\""
            + "}";
	
	
}
