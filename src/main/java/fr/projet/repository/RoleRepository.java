package fr.projet.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.projet.domain.Role;

@Repository
@Transactional
public class RoleRepository extends AbstractJpaRepository<Role> {

	public RoleRepository() {
		super(Role.class);
	}
}
