package br.com.hcm.ApiRestControleDeContatos.exception;

public class EntityException extends IllegalArgumentException {
	
	private static final long serialVersionUID = 1L;

	public EntityException() { super("id não encontrado!"); }
	
	public EntityException(String message) { super(message); }
	 
}
