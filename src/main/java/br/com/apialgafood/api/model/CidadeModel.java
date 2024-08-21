package br.com.apialgafood.api.model;

import lombok.Data;

@Data
public class CidadeModel {
	
	private Long id;
	private String nome;
	private EstadoModel estado;
}
