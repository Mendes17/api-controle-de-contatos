package br.com.hcm.ApiRestControleDeContatos.exception;

public class NullException extends IllegalArgumentException {
	
	private static final long serialVersionUID = 1L;

	public NullException() { super("valor nulo!"); }
	
	public NullException(String message) { super(message); }
	
}
