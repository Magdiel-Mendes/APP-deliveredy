package br.com.apialgafood.api.model.input;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class FormaPagamentoInput {
	
	@NotBlank
	private String descricao;

}
