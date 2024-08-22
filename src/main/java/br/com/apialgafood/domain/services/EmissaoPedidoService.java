package br.com.apialgafood.domain.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apialgafood.domain.exception.NegocioException;
import br.com.apialgafood.domain.exception.PedidoNaoEncontradoException;
import br.com.apialgafood.domain.model.Cidade;
import br.com.apialgafood.domain.model.FormaPagamento;
import br.com.apialgafood.domain.model.Pedido;
import br.com.apialgafood.domain.model.Produto;
import br.com.apialgafood.domain.model.Restaurante;
import br.com.apialgafood.domain.model.Usuario;
import br.com.apialgafood.domain.repository.PedidoRepository;

@Service
public class EmissaoPedidoService {
	
	
		@Autowired
	    private PedidoRepository pedidoRepository;
	
		@Autowired
		private CadastroRestauranteService cadastroRestaurante;

		@Autowired
		private CadastroCidadeService cadastroCidade;

		@Autowired
		private CadastroUsuarioService cadastroUsuario;

		@Autowired
		private CadastroProdutoService cadastroProduto;

		@Autowired
		private CadastroFormaPagamentoService cadastroFormaPagamento;

		@Transactional
		public Pedido emitir(Pedido pedido) {
		    validarPedido(pedido);
		    validarItens(pedido);

		    pedido.setTaxaFrete(pedido.getRestaurante().getTaxaFrete());
		    pedido.calcularValorTotal();

		    return pedidoRepository.save(pedido);
		}

		private void validarPedido(Pedido pedido) {
		    Cidade cidade = cadastroCidade.buscarOuFalhar(pedido.getEnderecoEntrega().getCidade().getId());
		    Usuario cliente = cadastroUsuario.buscarOuFalhar(pedido.getCliente().getId());
		    Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(pedido.getRestaurante().getId());
		    FormaPagamento formaPagamento = cadastroFormaPagamento.buscarOuFalhar(pedido.getFormaPagamento().getId());

		    pedido.getEnderecoEntrega().setCidade(cidade);
		    pedido.setCliente(cliente);
		    pedido.setRestaurante(restaurante);
		    pedido.setFormaPagamento(formaPagamento);
		    
		    if (restaurante.naoAceitaFormaPagamento(formaPagamento)) {
		        throw new NegocioException(String.format("Forma de pagamento '%s' não é aceita por esse restaurante.",
		                formaPagamento.getDescricao()));
		    }
		}

		private void validarItens(Pedido pedido) {
		    pedido.getItens().forEach(item -> {
		        Produto produto = cadastroProduto.buscarOuFalhar(
		                pedido.getRestaurante().getId(), item.getProduto().getId());
		        
		        item.setPedido(pedido);
		        item.setProduto(produto);
		        item.setPrecoUnitario(produto.getPreco());
		    });
		}
	    public Pedido buscarOuFalhar(Long pedidoId) {
	        return pedidoRepository.findById(pedidoId)
	            .orElseThrow(() -> new PedidoNaoEncontradoException(pedidoId));
	    }            
}
