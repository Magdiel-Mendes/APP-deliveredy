package br.com.apialgafood.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.apialgafood.domain.exception.EntidadeEmUsoException;
import br.com.apialgafood.domain.exception.FormaPagamentoNaoEncontradaException;
import br.com.apialgafood.domain.model.FormaPagamento;
import br.com.apialgafood.domain.repository.FormaPagamentoRepository;

@Service
public class FormaPagamentoService {
	
	private static final String MSG_FORMA_PAGAMENTO_EM_USO 
	= "Forma de pagamento de código %d não pode ser removido, pois está em uso";

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Transactional
	public FormaPagamento salvar(FormaPagamento pagamento) {
		return formaPagamentoRepository.save(pagamento);
	}
	
	@Transactional
	public void excluir(Long formaPagamentoId) {
		try {
			formaPagamentoRepository.deleteById(formaPagamentoId);
			formaPagamentoRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new FormaPagamentoNaoEncontradaException(formaPagamentoId);
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format(MSG_FORMA_PAGAMENTO_EM_USO, formaPagamentoId));
		}
	}
	
	
	@Transactional
	public FormaPagamento buscarOuFalhar(Long formaPamentoId) {
		return formaPagamentoRepository.findById(formaPamentoId)
			.orElseThrow(() -> new FormaPagamentoNaoEncontradaException(formaPamentoId));
	}
}
