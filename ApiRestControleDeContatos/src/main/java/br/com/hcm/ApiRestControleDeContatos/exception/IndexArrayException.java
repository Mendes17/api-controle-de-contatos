package br.com.hcm.ApiRestControleDeContatos.exception;

public class IndexArrayException extends IndexOutOfBoundsException {
	
	private static final long serialVersionUID = 1L;

	public IndexArrayException() { super("índice não existente!"); }
	
	public IndexArrayException(String message) { super(message); }
	
}
