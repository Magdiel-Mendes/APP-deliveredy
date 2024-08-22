package br.com.apialgafood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.apialgafood.domain.model.Pedido;

@Repository
public interface PedidoRepository extends CustomRepository<Pedido, Long>{
	
	@Query("from Pedido as p join fetch p.cliente join fetch p.restaurante r join fetch r.cozinha")
	List<Pedido> findAll();

}
