package br.com.apialgafood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.apialgafood.api.model.input.PedidoInput;
import br.com.apialgafood.domain.model.Pedido;

public class PedidoInputDisassembler {

	   	@Autowired
	    private ModelMapper modelMapper;
	    
	    public Pedido toDomainObject(PedidoInput pedidoInput) {
	        return modelMapper.map(pedidoInput, Pedido.class);
	    }
	    
	    public void copyToDomainObject(PedidoInput pedidoInput, Pedido pedido) {
	        modelMapper.map(pedidoInput, pedido);
	    }            
}
