package br.com.apialgafood.domain.exception;

public class FormaPagamentoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	

	public FormaPagamentoNaoEncontradaException(String msg) {
		super(msg);
		}


	public FormaPagamentoNaoEncontradaException(Long formaPagamentoNaoEncontradaId) {
		this(String.format("Não existe uma forma de pagamento com código %d", formaPagamentoNaoEncontradaId));
	}
}
