package Server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Server.Models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findById(Integer id);
	
	List<User> findAll();
	
	User findByEmailAndSenhaIn(String email, String senha);

	

}


