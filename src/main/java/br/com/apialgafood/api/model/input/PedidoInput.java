package br.com.apialgafood.api.model.input;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PedidoInput {


    @Valid
    @NotNull
    private RestauranteIdInput restaurante;
    
    @Valid
    @NotNull
    private EnderecoInput enderecoEntrega;
    
    @Valid
    @NotNull
    private FormaPagamentoIdInput formaPagamento;
    
    @Valid
    @Size(min = 1)
    @NotNull
    private List<ItemPedidoInput> itens;
}
