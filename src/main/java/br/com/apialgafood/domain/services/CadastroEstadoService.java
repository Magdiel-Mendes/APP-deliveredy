package br.com.apialgafood.domain.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import br.com.apialgafood.domain.exception.EntidadeEmUsoException;
import br.com.apialgafood.domain.exception.EstadoNaoEncontradaException;
import br.com.apialgafood.domain.model.Estado;
import br.com.apialgafood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

		private static final String MSG_ESTADO_EM_USO 
			= "Estado de código %d não pode ser removido, pois está em uso";
		
		
		@Autowired
		private EstadoRepository estadoRepository;

		@Transactional
		public Estado salvar(Estado estado) {
			return estadoRepository.save(estado);
		}
		@Transactional
		public void excluir(Long estadoId) {
			try {
				estadoRepository.deleteById(estadoId);
				estadoRepository.flush();
				
			} catch (EmptyResultDataAccessException e) {
				throw new EstadoNaoEncontradaException(estadoId);
			
			} catch (DataIntegrityViolationException e) {
				throw new EntidadeEmUsoException(
					String.format(MSG_ESTADO_EM_USO, estadoId));
			}
		}
		
		public Estado buscarOuFalhar(Long estadoId) {
			return estadoRepository.findById(estadoId)
				.orElseThrow(() -> new EstadoNaoEncontradaException(estadoId));
		}
}
