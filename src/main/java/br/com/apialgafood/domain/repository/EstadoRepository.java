package br.com.apialgafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.apialgafood.domain.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
