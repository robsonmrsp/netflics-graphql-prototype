package br.com.netflics.core.rs.exception;

/* generated by JSetup v0.95 :  at 1 de fev de 2023 23:43:21 */
public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1970472314945851621L;
	private final String legalMessage;
	private final Exception origem;

	public ValidationException(String legalMessage) {
		this(null, legalMessage);
	}

	public ValidationException(Exception origem, String legalMessage) {
		super(origem);
		this.origem = origem;
		this.legalMessage = legalMessage;
	}

	public String getLegalMessage() {
		return legalMessage;
	}

	public Exception getOrigem() {
		if (origem == null) {
			return this;
		}
		return origem;
	}
}
