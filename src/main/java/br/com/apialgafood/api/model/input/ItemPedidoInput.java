package br.com.apialgafood.api.model.input;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;

@Data
public class ItemPedidoInput {

		@NotNull
	    private Long produtoId;
	    
	    @NotNull
	    @PositiveOrZero
	    private Integer quantidade;
	    
	    private String observacao;   
}
