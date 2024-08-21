package br.com.apialgafood.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CozinhaInput {

	@NotBlank
	private String nome;
}
