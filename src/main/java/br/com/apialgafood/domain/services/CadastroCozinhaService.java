package br.com.apialgafood.domain.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.apialgafood.domain.exception.CozinhaNaoEncontradaException;
import br.com.apialgafood.domain.exception.EntidadeEmUsoException;
import br.com.apialgafood.domain.model.Cozinha;
import br.com.apialgafood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {
			
		private static final String MSG_COZINHA_EM_USO 
		= "Cozinha de código %d não pode ser removida, pois está em uso";

		@Autowired
		private CozinhaRepository cozinhaRepository;
		
		@Transactional
		public Cozinha salvar(Cozinha cozinha) {
			return cozinhaRepository.save(cozinha);
		}
		
		@Transactional
		public void excluir(Long cozinhaId) {
			try {
				cozinhaRepository.deleteById(cozinhaId);
				cozinhaRepository.flush();
				
			} catch (EmptyResultDataAccessException e) {
				throw new CozinhaNaoEncontradaException(cozinhaId);
			
			} catch (DataIntegrityViolationException e) {
				throw new EntidadeEmUsoException(
					String.format(MSG_COZINHA_EM_USO, cozinhaId));
			}
		}
		
		public Cozinha buscarOuFalhar(Long cozinhaId) {
			return cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new CozinhaNaoEncontradaException(cozinhaId));
		}

}
