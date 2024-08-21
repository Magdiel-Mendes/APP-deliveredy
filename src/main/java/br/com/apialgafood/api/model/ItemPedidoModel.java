package br.com.apialgafood.api.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ItemPedidoModel {
	
		private Long produtoId;
	    private String produtoNome;
	    private Integer quantidade;
	    private BigDecimal precoUnitario;
	    private BigDecimal precoTotal;
	    private String observacao;         
}
