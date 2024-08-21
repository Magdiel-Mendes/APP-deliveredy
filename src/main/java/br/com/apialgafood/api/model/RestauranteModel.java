package br.com.apialgafood.api.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RestauranteModel {
	private Long id;
	private String nome;
	private BigDecimal frete;
//	private CozinhaModel cozinha;
	private Long idCozinha ;
	private String nomeCozinha;
	private Boolean ativo;
	private EnderecoModel endereco;
	private Boolean aberto;

}
