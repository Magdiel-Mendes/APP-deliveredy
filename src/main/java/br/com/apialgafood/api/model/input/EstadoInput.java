package br.com.apialgafood.api.model.input;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EstadoInput {
	
	@NotNull
	private String nome;
}
