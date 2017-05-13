package model;

public class LogicaDeNegocioException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LogicaDeNegocioException(String txt) {
		super(txt);
	}
}
