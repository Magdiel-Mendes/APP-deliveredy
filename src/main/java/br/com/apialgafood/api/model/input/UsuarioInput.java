package br.com.apialgafood.api.model.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UsuarioInput {

	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
}