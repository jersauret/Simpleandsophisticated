package fr.projet.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.projet.domain.Right;

@Repository
@Transactional
public class RightRepository extends AbstractJpaRepository<Right> {
	
	public RightRepository() {
		super(Right.class);
	}
}
