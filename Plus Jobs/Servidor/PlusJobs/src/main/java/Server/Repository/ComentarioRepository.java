package Server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Server.Models.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	Optional<Comentario> findById(Integer id);
	
	List<Comentario> findAll();

	

	

}