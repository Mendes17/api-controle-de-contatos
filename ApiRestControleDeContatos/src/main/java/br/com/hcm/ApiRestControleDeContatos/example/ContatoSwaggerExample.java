package br.com.hcm.ApiRestControleDeContatos.example;

public class ContatoSwaggerExample {
	
	public static final String POST_CONTATO_EXAMPLE = "{" // exemplo json post-contato
            + "\"tipoContato\": \"CELULAR\", "
            + "\"contato\": \"11 9865-8220\", "
            + "\"pessoa\": {\"id\": 1}"
            + "}";
	
	public static final String GET_200_CONTATO_EXAMPLE = "{"
            + "\"id\": 1, "
            + "\"tipoContato\": \"CELULAR\", "
            + "\"contato\": \"11 9865-8220\", "
            + "\"pessoa\": {\"id\": 1, "
            + "\"nome\": \"Henrique\", "
            + "\"endereco\": \"Rua das Flores, 555\", "
            + "\"cep\": \"05050-555\", "
            + "\"cidade\": \"Osasco\", "
            + "\"uf\": \"SP\""
            + "}"
            + "}";
	
	public static final String ERRO_400_TIPO_CONTATO_EXAMPLE = "{" // exemplo json erro 400
            + "\"status\": \"BAD_REQUEST\", "
            + "\"message\": \"o tipo contato não pode ser nulo!\"}";
	
	public static final String ERRO_400_CONTATO_EXAMPLE = "{" // exemplo json erro 400
            + "\"status\": \"BAD_REQUEST\", "
            + "\"message\": \"contato não pode ser nulo!\"}";
	
	public static final String ERRO_404_CONTATO_EXAMPLE = "{" // exemplo json erro 404
            + "\"status\": \"NOT_FOUND\", "
            + "\"message\": \"id não encontrado!\"}";
	
	public static final String ERRO_404_CONTATO_PESSOA_EXAMPLE = "{" // exemplo json erro 404
            + "\"status\": \"NOT_FOUND\", "
            + "\"message\": \"a pessoa não tem nenhum tipo de contato\"}";
	
	public static final String PUT_CONTATO_EXAMPLE = "{"
	        + "\"tipoContato\": \"EMAIL\", "
	        + "\"contato\": \"henrique@gmail.com\""
	        + "}";
	
	public static final String GET_200_CONTATO_PESSOA_ID_EXAMPLE = "["
            + "{"
            + "\"id\": 1, "
            + "\"tipoContato\": \"CELULAR\", "
            + "\"contato\": \"11 9865-8220\", "
            + "\"pessoa\": {\"id\": 1, "
            + "\"nome\": \"Henrique\", "
            + "\"endereco\": \"Rua das Flores, 555\", "
            + "\"cep\": \"05050-555\", "
            + "\"cidade\": \"Osasco\", "
            + "\"uf\": \"SP\"}"
            + "},"
            + "{"
            + "\"id\": 2, "
            + "\"tipoContato\": \"EMAIL\", "
            + "\"contato\": \"henrique@email.com\", "
            + "\"pessoa\": {\"id\": 1, "
            + "\"nome\": \"Henrique\", "
            + "\"endereco\": \"Rua das Flores, 555\", "
            + "\"cep\": \"05050-555\", "
            + "\"cidade\": \"Osasco\", "
            + "\"uf\": \"SP\"}"
            + "},"
            + "{"
            + "\"id\": 3, "
            + "\"tipoContato\": \"TELEFONE\", "
            + "\"contato\": \"11 3333-4444\", "
            + "\"pessoa\": {\"id\": 1, "
            + "\"nome\": \"Henrique\", "
            + "\"endereco\": \"Rua das Flores, 555\", "
            + "\"cep\": \"05050-555\", "
            + "\"cidade\": \"Osasco\", "
            + "\"uf\": \"SP\"}"
            + "}"
            + "]";
	
}
