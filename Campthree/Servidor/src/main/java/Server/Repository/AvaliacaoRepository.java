package Server.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Server.Models.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {

	Optional<Avaliacao> findById(Integer id);

	List<Avaliacao> findAll();
}
