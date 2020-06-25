package Server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Server.Models.Campanha;
import Server.Models.Instituicao;
import Server.Models.User;

public interface CampanhaRepository extends JpaRepository<Campanha, Integer> {

	Optional<Campanha> findById(Integer id);

	List<Campanha> findAll();
	
	List<Campanha> findByValidada(Boolean b);
	
	List<Campanha> findByValidadaAndUserIn(Boolean b, User u);
	
	List<Campanha> findByValidadaAndInstituicaoIn(Boolean b, Instituicao i);
}
