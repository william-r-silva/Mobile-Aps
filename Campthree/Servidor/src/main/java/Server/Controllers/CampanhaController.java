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
import Server.Models.Campanha;
import Server.Models.Instituicao;
import Server.Models.User;
import Server.Repository.CampanhaRepository;
import Server.Repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/campanha/")
public class CampanhaController  {
	
	@Autowired
	private CampanhaRepository campanhaR;
	
	@Autowired
	private UserRepository userR;
	
	
	@GetMapping("{id}")
	public Campanha getById(@PathVariable(name = "id") Integer id) {
		return campanhaR.findById(id).get();
	}
	
	@GetMapping("autorizada")
	public List<Campanha> getAutorizadas() {
		return campanhaR.findByValidada(true);
	}
	
	@GetMapping("autorizada/{id}")
	public List<Campanha> getAutorizadasUser(@PathVariable(name="id") Integer id) {
		return campanhaR.findByValidadaAndUserIn(true, userR.findById(id).get());
	}
	
	
	@PutMapping("acompanhar/{id}")
	public ResponseEntity<Campanha> acompanhar(@PathVariable(name="id") Integer id, @RequestBody Campanha novo) {
		Campanha old = campanhaR.getOne(novo.getId());
		List<User> x = old.getLista();
		x.add(userR.findById(id).get());
		old.setLista(x);
		old = campanhaR.save(old);
		User u = userR.getOne(id);
		List<Campanha> y = u.getParticipadas();
		y.add(novo);
		u.setParticipadas(y);
		u = userR.save(u);
		return ResponseEntity.ok(old);
	}
	
	@PutMapping("desistir/{id}")
	public ResponseEntity<Campanha> desistir(@PathVariable(name="id") Integer id, @RequestBody Campanha novo) {
		Campanha old = campanhaR.getOne(novo.getId());
		List<User> x = old.getLista();
		for(int i = 0;i<x.size();i++) {
			if(x.get(i).getId()==id) {
				x.remove(i);
				break;
			}
		}
		old.setLista(x);
		old = campanhaR.save(old);
		User u = userR.getOne(id);
		List<Campanha> y = u.getParticipadas();
		for(int i = 0;i<y.size();i++) {
			if(y.get(i).getId()==novo.getId()) {
				y.remove(i);
				break;
			}
		}
		u.setParticipadas(y);
		u = userR.save(u);
		return ResponseEntity.ok(old);
	}
	
	@GetMapping()
	public List<Campanha> getAll() {
		return campanhaR.findAll();
	}
	
	@GetMapping("/avaliacao/{id}")
	public List<Avaliacao> getAvaliacao(@PathVariable(name="id") Integer id){
		return campanhaR.findById(id).get().getAvalicao();
	}
	
	@PostMapping
	public ResponseEntity<Campanha> adicionar(@RequestBody Campanha novo) {
		return ResponseEntity.ok(campanhaR.save(novo));
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		if (campanhaR.existsById(id)) {
			campanhaR.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("{id}")
    public ResponseEntity<Campanha> addInstituicao(@PathVariable(name="id") Integer id,@RequestBody Instituicao i) {
        Campanha old = campanhaR.getOne(id);
        old.setInstituicao(i);
        old = campanhaR.save(old);
        return ResponseEntity.ok(old);
    }
	
	@PutMapping()
	public ResponseEntity<Campanha> atualizar(@RequestBody Campanha novo) {
			Campanha old = campanhaR.getOne(novo.getId());
			old.setDescricao(novo.getDescricao());
			old.setLocal(novo.getLocal());
			old.setGenero(novo.getGenero());
			old.setLista(novo.getLista());
			old.setNome(novo.getNome());
			old.setUser(novo.getUser());
			old.setValidada(novo.isValidada());
			old.setColaboracaoMonetario(novo.getColaboracaoMonetario());
			old.setDataFim(novo.getDataFim());
            old.setDataInicio(novo.getDataInicio());
			old = campanhaR.save(old);
			return ResponseEntity.ok(old);
	}
	
	@GetMapping("instituicao/{id}")
    public Instituicao getInstituicao(@PathVariable(name="id") Integer id) {
        return campanhaR.findById(id).get().getInstituicao();
    }

}
