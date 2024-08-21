package br.com.apialgafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.apialgafood.domain.model.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Long>  {

}
