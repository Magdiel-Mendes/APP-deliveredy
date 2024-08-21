package br.com.apialgafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.apialgafood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long>{

}
