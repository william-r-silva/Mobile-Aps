package Server.Controllers;

import java.util.ArrayList;
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

import Server.Models.Comentario;
import Server.Models.Empresa;
import Server.Models.User;
import Server.Repository.ComentarioRepository;
import Server.Repository.EmpresaRepository;

@CrossOrigin
	@RestController
	@RequestMapping("/comentario/")
	public class ComentarioController {
		@Autowired
		private ComentarioRepository comentarioR;
		
		@Autowired
		private EmpresaRepository empresaR;

		@GetMapping("{id}")
		public Comentario getComentario(@PathVariable(name = "id") Integer id) {
			return comentarioR.findById(id).get();
		}
		
		@GetMapping()
		public List<Comentario> getAll() {
			return comentarioR.findAll();
		}
		
		@GetMapping("cidadeestado/{cidade}/{estado}")
		public ArrayList<Comentario> getByCidadeEstado(@PathVariable(name="cidade") String cidade, @PathVariable(name="estado") String estado){
			ArrayList<Comentario> x = (ArrayList<Comentario>) comentarioR.findAll();
			for(int i = 0;i<x.size();i++) {
				if(!(x.get(i).getEmpresa().getCidade().equals(cidade) && x.get(i).getEmpresa().getEstado().equals(estado))) {
					x.remove(i);
					i--;
				}
			}
			return x;
			
		}
		
		@GetMapping("estado/{estado}")
		public ArrayList<Comentario> getByEstado(@PathVariable(name="estado") String estado){
			ArrayList<Comentario> x = (ArrayList<Comentario>) comentarioR.findAll();
			for(int i = 0;i<x.size();i++) {
				if(!x.get(i).getEmpresa().getEstado().equals(estado)) {
					x.remove(i);
					i--;
				}
			}
			return x;
		}
		
		@GetMapping("empresa/{id}")
		public ArrayList<Comentario> getByEmpresa(@PathVariable(name="id") Integer id){
			ArrayList<Comentario> x = (ArrayList<Comentario>) comentarioR.findAll();
			for(int i = 0;i<x.size();i++) {
				if(x.get(i).getEmpresa().getId() !=id) {
					x.remove(i);
					i--;
				}
			}
			return x;
			
		}
		
		@GetMapping("user/{id}")
		public ArrayList<Comentario> getByUser(@PathVariable(name="id") Integer id){
			System.out.println(id);
			ArrayList<Comentario> x = (ArrayList<Comentario>) comentarioR.findAll();
			for(int i = 0;i<x.size();i++) {
				if(x.get(i).getUser().getId() != id) {
					x.remove(i);
					i--;
				}
			}
			return x;
			
		}
	
		@PostMapping
		public ResponseEntity<Comentario> adicionar(@RequestBody Comentario novo) {
			
			Empresa old = empresaR.getOne(novo.getEmpresa().getId());
			old.setNvCobranca(old.getNvCobranca()+novo.getNvCobranca());
			old.setNvAcessibilidade(old.getNvAcessibilidade() + novo.getNvAcessibilidade());
			old.setNvAcessoTerreno(old.getNvAcessoTerreno() + novo.getNvAcessoTerreno());
			old.setNvComunicacaoInterna(old.getNvComunicacaoInterna()+novo.getNvComunicacaoInterna());
			old.setNvEsfocoFisico(old.getNvEsfocoFisico()+novo.getNvEsforcoFisico());
			old.setNvEsforcoItelectual(old.getNvEsforcoItelectual()+novo.getNvEsforcoItelectual());
			old.setNvEstresse(old.getNvEstresse()+novo.getNvEstresse());
			old.setNvFacilidadeAcessoSuperiores(old.getNvFacilidadeAcessoSuperiores()+novo.getNvFacilidadeAcessoSuperiores());
			old.setNvNegociacaoDeSalarioBeneficio(old.getNvNegociacaoDeSalarioBeneficio()+novo.getNvNogociacaoDeSalarioBeneficio());
			old.setNvPlanoSaude(old.getNvPlanoSaude()+novo.getNvPlanoSaude());
			old.setNvPossibilidadeCresimento(old.getNvPossibilidadeCresimento()+novo.getNvPossibilidadeCresimento());
			old.setNvRelacionamentoColaboradores(old.getNvRelacionamentoColaboradores()+novo.getNvRelacionamentoColaboradores());
			old.setNvValeAlimentacao(old.getNvValeAlimentacao()+novo.getNvValeAlimentacao());
			old.setNvValeRefeicao(old.getNvValeRefeicao() +novo.getNvValeRefeicao());
			old.setNvValeTransporte(old.getNvValeTransporte() + novo.getNvValeTransporte());
			old.setNvValorizacaoTrabalho(old.getNvValorizacaoTrabalho()+novo.getNvValorizacaoTrabalho());
			old.setNroComentarios(old.getNroComentarios() +1);
			old.setTotal();
			empresaR.save(old);
			
			novo.setEmpresa(old);
			
			return ResponseEntity.ok(comentarioR.save(novo));
		}
		

		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deletar(@PathVariable Integer id) {
			if (comentarioR.existsById(id)) {
				comentarioR.deleteById(id);
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.notFound().build();
		}
		@PutMapping()
		public ResponseEntity<Comentario> atualizar(@RequestBody Comentario novo) {
				Comentario old = comentarioR.getOne(novo.getId());
				old = novo;

				old = comentarioR.save(old);

				return ResponseEntity.ok(old);
	
		}
		
		
	}

