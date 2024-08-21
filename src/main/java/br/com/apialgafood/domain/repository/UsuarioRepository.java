package br.com.apialgafood.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.apialgafood.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends CustomRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
	
}