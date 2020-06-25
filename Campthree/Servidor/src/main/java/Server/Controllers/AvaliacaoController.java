package Server.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Server.Models.Avaliacao;
import Server.Repository.AvaliacaoRepository;

@CrossOrigin
@RestController
@RequestMapping("/avaliacao/")
public class AvaliacaoController  {
	
	@Autowired
	private AvaliacaoRepository avaliacaoR;
	
	
	@GetMapping("{id}")
	public Avaliacao getById(@PathVariable(name = "id") Integer id) {
		return avaliacaoR.findById(id).get();
	}
	
	
	@GetMapping()
	public List<Avaliacao> getAll() {
		return avaliacaoR.findAll();
	}
	
	
	@PostMapping
	public ResponseEntity<Avaliacao> adicionar(@RequestBody Avaliacao novo) {
		return ResponseEntity.ok(avaliacaoR.save(novo));
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		if (avaliacaoR.existsById(id)) {
			avaliacaoR.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PutMapping()
	public ResponseEntity<Avaliacao> atualizar(@RequestBody Avaliacao novo) {
			Avaliacao old = avaliacaoR.getOne(novo.getId());
			old.setCampanha(novo.getCampanha());
			old.setDescricao(novo.getDescricao());
			old.setId(novo.getId());
			old.setNota(novo.getNota());
			old.setUser(novo.getUser());
			old = avaliacaoR.save(old);
			return ResponseEntity.ok(old);
	}

}
