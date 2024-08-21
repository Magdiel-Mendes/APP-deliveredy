package br.com.apialgafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.apialgafood.domain.model.Restaurante;

public interface RestauranteRepository extends CustomRepository<Restaurante, Long>,
											   RestauranteRepositoryQueries,
											   JpaSpecificationExecutor<Restaurante>{
	@Query("from Restaurante r join r.cozinha left join fetch r.formasPagamento")
	List<Restaurante> findAll();
	
	// metodo que busca valores que estejan entre as taxas passadas pelo usuário
	List<Restaurante> queryByTaxaFreteBetween(BigDecimal taxaInicio, BigDecimal taxaFim);
	
	// Metodo para consultar com query/consulta personalizada
	List<Restaurante> consultarPorNome(String nome, @Param("id") Long cozinha);

	// busca um restaurante que contenha o nome e id passados
	List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinhaId);
	
	// Retorna o primeiro restaurante com base no nome
	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	// Metodo com limite, retorna os dois primeiros conforme o nome passado
	List<Restaurante> findTop2ByNomeContaining(String nome);
	
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
}
