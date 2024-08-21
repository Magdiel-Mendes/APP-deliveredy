package br.com.apialgafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.apialgafood.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	
}
