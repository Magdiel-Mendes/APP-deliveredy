package br.com.apialgafood.api.model.input;

import javax.validation.constraints.NotBlank;

public class CidadeInput {
	
	@NotBlank
	private String nome;
	
}