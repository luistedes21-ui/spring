package upc.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import upc.edu.pe.model.Users;

@Repository
public interface iUserRepository extends JpaRepository<Users, Long> {
	public Users findByUsername(String username);

}
