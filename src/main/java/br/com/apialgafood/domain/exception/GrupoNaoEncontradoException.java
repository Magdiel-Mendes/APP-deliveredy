package br.com.apialgafood.domain.exception;


public class GrupoNaoEncontradoException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;
	

	public GrupoNaoEncontradoException(String msg) {
		super(msg);
		}


	public GrupoNaoEncontradoException(Long grupoId) {
		this(String.format("Não existe um cadastro de de grupo com código %d", grupoId));
	}

}
