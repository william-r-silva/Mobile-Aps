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

import Server.Models.Empresa;
import Server.Models.User;
import Server.Repository.EmpresaRepository;

@CrossOrigin
	@RestController
	@RequestMapping("/empresa/")
	public class EmpresaController {
		@Autowired
		private EmpresaRepository empresaR;

		@GetMapping("{id}")
		public Empresa getEmpresa(@PathVariable(name = "id") Integer id) {
				System.out.println(id);
			return empresaR.findById(id).get();
		}
		
		@GetMapping("autorizado")
		public List<Empresa> getAutorizados(){
			return empresaR.findByAutorizado(true);
		}
		
		@GetMapping()
		public List<Empresa> getAll() {
			return empresaR.findAll();
		}
		
		@PostMapping
		public ResponseEntity<Empresa> adicionar(@RequestBody Empresa novo) {
			return ResponseEntity.ok(empresaR.save(novo));
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deletar(@PathVariable Integer id) {
			if (empresaR.existsById(id)) {
				empresaR.deleteById(id);
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.notFound().build();
		}
		
		@PutMapping()
		public ResponseEntity<Empresa> atualizar(@RequestBody Empresa novo) {
				Empresa old = empresaR.getOne(novo.getId());
				old = novo;

				old = empresaR.save(old);

				return ResponseEntity.ok(old);
	
		}
		
	}


