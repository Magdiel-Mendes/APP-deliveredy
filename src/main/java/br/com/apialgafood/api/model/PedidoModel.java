package br.com.apialgafood.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import lombok.Data;

@Data
public class PedidoModel {
	
		private Long id;
	    private BigDecimal subtotal;
	    private BigDecimal taxaFrete;
	    private BigDecimal valorTotal;
	    private String status;
	    private OffsetDateTime dataCriacao;
	    private OffsetDateTime dataConfirmacao;
	    private OffsetDateTime dataEntrega;
	    private OffsetDateTime dataCancelamento;
	    private RestauranteResumoModel restaurante;
	    private UsuarioModel cliente;
	    private FormaPagamentoModel formaPagamento;
	    private EnderecoModel enderecoEntrega;
	    private List<ItemPedidoModel> itens;   
}
