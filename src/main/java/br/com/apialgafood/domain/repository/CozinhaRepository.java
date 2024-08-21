package br.com.apialgafood.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.apialgafood.domain.model.Cozinha;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{
	
	List<Cozinha> findByNomeContaining(String nome);
	
	boolean existsByNome(String nome);
	

}
