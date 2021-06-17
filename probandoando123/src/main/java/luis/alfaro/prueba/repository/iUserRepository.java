package luis.alfaro.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import luis.alfaro.prueba.model.Users;

@Repository
public interface iUserRepository extends JpaRepository<Users, Long> {
	public Users findByUsername(String username);

}
