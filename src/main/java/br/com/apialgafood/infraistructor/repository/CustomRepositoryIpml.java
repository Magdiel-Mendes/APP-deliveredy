package br.com.apialgafood.infraistructor.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import br.com.apialgafood.domain.repository.CustomRepository;

public class CustomRepositoryIpml<T, ID> extends SimpleJpaRepository<T, ID> 
					implements CustomRepository<T,ID>	{


	private EntityManager manager;

	public CustomRepositoryIpml(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.manager = entityManager;
	}

	@Override
	public Optional<T> buscarPrimeiro() {
		var jpql = "from " + getDomainClass().getName();
	 T entity = manager.createQuery(jpql, getDomainClass())
			.setMaxResults(1)
			.getSingleResult();
	 return Optional.ofNullable(entity);
		
	}

	@Override
	public void detach(T entity) {
		manager.detach(entity);
		
	}

}
