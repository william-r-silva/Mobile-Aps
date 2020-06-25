
package Server.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "empresa")
public class Empresa {
	
	//atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private	String tipoRegimeTrabalho;
	private boolean autorizado;
	private String nomeMarca;
	private String cidade;
	private String estado; //estado é uma quadrilha, imposto é roubo;
	private String rua;
	private int numero;
	private String bairro;
	
	private int nroComentarios;
	private double nvTotal;
	
	private int nvPossibilidadeCresimento;
	private int nvComunicacaoInterna;
	private int nvEsfocoFisico;
	private int nvEstresse;
	private int nvAcessibilidade;
	private int nvFacilidadeAcessoSuperiores;
    private int nvCobranca;
    private int nvEsforcoItelectual;
    private int nvValorizacaoTrabalho;
    private int nvNegociacaoDeSalarioBeneficio;
    private int nvAcessoTerreno;
    private int nvValeTransporte;
    private int nvValeRefeicao;
    private int nvValeAlimentacao;
    private int nvPlanoSaude;
    private int nvRelacionamentoColaboradores;
	
	@OneToMany(mappedBy = "empresa")
	//@JsonBackReference
	//@JsonIgnoreProperties("comentario")
	@JsonIgnore
	private List<Comentario> comentario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getNvTotal() {
		return nvTotal;
	}

	public void setNvTotal(double nvTotal) {
		this.nvTotal = nvTotal;
	}

	public int getNvPossibilidadeCresimento() {
		return nvPossibilidadeCresimento;
	}

	public void setNvPossibilidadeCresimento(int nvPossibilidadeCresimento) {
		this.nvPossibilidadeCresimento = nvPossibilidadeCresimento;
	}

	public int getNvComunicacaoInterna() {
		return nvComunicacaoInterna;
	}

	public void setNvComunicacaoInterna(int nvComunicacaoInterna) {
		this.nvComunicacaoInterna = nvComunicacaoInterna;
	}

	public int getNvEsfocoFisico() {
		return nvEsfocoFisico;
	}

	public void setNvEsfocoFisico(int nvEsfocoFisico) {
		this.nvEsfocoFisico = nvEsfocoFisico;
	}

	public int getNvEstresse() {
		return nvEstresse;
	}

	public void setNvEstresse(int nvEstresse) {
		this.nvEstresse = nvEstresse;
	}

	public int getNvAcessibilidade() {
		return nvAcessibilidade;
	}

	public void setNvAcessibilidade(int nvAcessibilidade) {
		this.nvAcessibilidade = nvAcessibilidade;
	}

	public int getNroComentarios() {
		return nroComentarios;
	}

	public void setNroComentarios(int nroComentarios) {
		this.nroComentarios = nroComentarios;
	}

	public int getNvFacilidadeAcessoSuperiores() {
		return nvFacilidadeAcessoSuperiores;
	}

	public void setNvFacilidadeAcessoSuperiores(int nvFacilidadeAcessoSuperiores) {
		this.nvFacilidadeAcessoSuperiores = nvFacilidadeAcessoSuperiores;
	}

	public int getNvCobranca() {
		return nvCobranca;
	}

	public void setNvCobranca(int nvCobranca) {
		this.nvCobranca = nvCobranca;
	}

	public int getNvEsforcoItelectual() {
		return nvEsforcoItelectual;
	}

	public void setNvEsforcoItelectual(int nvEsforcoItelectual) {
		this.nvEsforcoItelectual = nvEsforcoItelectual;
	}

	public int getNvValorizacaoTrabalho() {
		return nvValorizacaoTrabalho;
	}

	public void setNvValorizacaoTrabalho(int nvValorizacaoTrabalho) {
		this.nvValorizacaoTrabalho = nvValorizacaoTrabalho;
	}

	public int getNvAcessoTerreno() {
		return nvAcessoTerreno;
	}

	public void setNvAcessoTerreno(int nvAcessoTerreno) {
		this.nvAcessoTerreno = nvAcessoTerreno;
	}

	public int getNvValeTransporte() {
		return nvValeTransporte;
	}

	public void setNvValeTransporte(int nvValeTransporte) {
		this.nvValeTransporte = nvValeTransporte;
	}

	public int getNvValeRefeicao() {
		return nvValeRefeicao;
	}

	public void setNvValeRefeicao(int nvValeRefeicao) {
		this.nvValeRefeicao = nvValeRefeicao;
	}

	public int getNvValeAlimentacao() {
		return nvValeAlimentacao;
	}

	public void setNvValeAlimentacao(int nvValeAlimentacao) {
		this.nvValeAlimentacao = nvValeAlimentacao;
	}

	public int getNvPlanoSaude() {
		return nvPlanoSaude;
	}

	public void setNvPlanoSaude(int nvPlanoSaude) {
		this.nvPlanoSaude = nvPlanoSaude;
	}

	public String getTipoRegimeTrabalho() {
		return tipoRegimeTrabalho;
	}

	public void setTipoRegimeTrabalho(String tipoRegimeTrabalho) {
		this.tipoRegimeTrabalho = tipoRegimeTrabalho;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public List<Comentario> getComentario() {
		return comentario;
	}

	public void setComentario(List<Comentario> comentario) {
		this.comentario = comentario;
		}

	public int getNvNegociacaoDeSalarioBeneficio() {
		return nvNegociacaoDeSalarioBeneficio;
	}

	public void setNvNegociacaoDeSalarioBeneficio(int nvNegociacaoDeSalarioBeneficio) {
		this.nvNegociacaoDeSalarioBeneficio = nvNegociacaoDeSalarioBeneficio;
	}

	public int getNvRelacionamentoColaboradores() {
		return nvRelacionamentoColaboradores;
	}

	public void setNvRelacionamentoColaboradores(int nvRelacionamentoColaboradores) {
		this.nvRelacionamentoColaboradores = nvRelacionamentoColaboradores;
	}
	
	//construtores
	

	public Empresa(Integer id, String tipoRegimeTrabalho, boolean autorizado, String nomeMarca, String cidade,
			String estado, String rua, int numero, String bairro, int nroComentarios, double nvTotal,
			int nvPossibilidadeCresimento, int nvComunicacaoInterna, int nvEsfocoFisico, int nvEstresse,
			int nvAcessibilidade, int nvFacilidadeAcessoSuperiores, int nvCobranca, int nvEsforcoItelectual,
			int nvValorizacaoTrabalho, int nvNegociacaoDeSalarioBeneficio, int nvAcessoTerreno, int nvValeTransporte,
			int nvValeRefeicao, int nvValeAlimentacao, int nvPlanoSaude, int nvRelacionamentoColaboradores,
			List<Comentario> comentario) {
		super();
		this.id = id;
		this.tipoRegimeTrabalho = tipoRegimeTrabalho;
		this.autorizado = autorizado;
		this.nomeMarca = nomeMarca;
		this.cidade = cidade;
		this.estado = estado;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.nroComentarios = nroComentarios;
		this.nvTotal = nvTotal;
		this.nvPossibilidadeCresimento = nvPossibilidadeCresimento;
		this.nvComunicacaoInterna = nvComunicacaoInterna;
		this.nvEsfocoFisico = nvEsfocoFisico;
		this.nvEstresse = nvEstresse;
		this.nvAcessibilidade = nvAcessibilidade;
		this.nvFacilidadeAcessoSuperiores = nvFacilidadeAcessoSuperiores;
		this.nvCobranca = nvCobranca;
		this.nvEsforcoItelectual = nvEsforcoItelectual;
		this.nvValorizacaoTrabalho = nvValorizacaoTrabalho;
		this.nvNegociacaoDeSalarioBeneficio = nvNegociacaoDeSalarioBeneficio;
		this.nvAcessoTerreno = nvAcessoTerreno;
		this.nvValeTransporte = nvValeTransporte;
		this.nvValeRefeicao = nvValeRefeicao;
		this.nvValeAlimentacao = nvValeAlimentacao;
		this.nvPlanoSaude = nvPlanoSaude;
		this.nvRelacionamentoColaboradores = nvRelacionamentoColaboradores;
		this.comentario = comentario;
	}
	
	
	
	
	public Empresa() {
		super();
	}

	//hash code

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (autorizado ? 1231 : 1237);
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeMarca == null) ? 0 : nomeMarca.hashCode());
		result = prime * result + nroComentarios;
		result = prime * result + numero;
		result = prime * result + nvAcessibilidade;
		result = prime * result + nvAcessoTerreno;
		result = prime * result + nvCobranca;
		result = prime * result + nvComunicacaoInterna;
		result = prime * result + nvEsfocoFisico;
		result = prime * result + nvEsforcoItelectual;
		result = prime * result + nvEstresse;
		result = prime * result + nvFacilidadeAcessoSuperiores;
		result = prime * result + nvNegociacaoDeSalarioBeneficio;
		result = prime * result + nvPlanoSaude;
		result = prime * result + nvPossibilidadeCresimento;
		result = prime * result + nvRelacionamentoColaboradores;
		long temp;
		temp = Double.doubleToLongBits(nvTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + nvValeAlimentacao;
		result = prime * result + nvValeRefeicao;
		result = prime * result + nvValeTransporte;
		result = prime * result + nvValorizacaoTrabalho;
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
		result = prime * result + ((tipoRegimeTrabalho == null) ? 0 : tipoRegimeTrabalho.hashCode());
		return result;
	}
	
	//equals
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (autorizado != other.autorizado)
			return false;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeMarca == null) {
			if (other.nomeMarca != null)
				return false;
		} else if (!nomeMarca.equals(other.nomeMarca))
			return false;
		if (nroComentarios != other.nroComentarios)
			return false;
		if (numero != other.numero)
			return false;
		if (nvAcessibilidade != other.nvAcessibilidade)
			return false;
		if (nvAcessoTerreno != other.nvAcessoTerreno)
			return false;
		if (nvCobranca != other.nvCobranca)
			return false;
		if (nvComunicacaoInterna != other.nvComunicacaoInterna)
			return false;
		if (nvEsfocoFisico != other.nvEsfocoFisico)
			return false;
		if (nvEsforcoItelectual != other.nvEsforcoItelectual)
			return false;
		if (nvEstresse != other.nvEstresse)
			return false;
		if (nvFacilidadeAcessoSuperiores != other.nvFacilidadeAcessoSuperiores)
			return false;
		if (nvNegociacaoDeSalarioBeneficio != other.nvNegociacaoDeSalarioBeneficio)
			return false;
		if (nvPlanoSaude != other.nvPlanoSaude)
			return false;
		if (nvPossibilidadeCresimento != other.nvPossibilidadeCresimento)
			return false;
		if (nvRelacionamentoColaboradores != other.nvRelacionamentoColaboradores)
			return false;
		if (Double.doubleToLongBits(nvTotal) != Double.doubleToLongBits(other.nvTotal))
			return false;
		if (nvValeAlimentacao != other.nvValeAlimentacao)
			return false;
		if (nvValeRefeicao != other.nvValeRefeicao)
			return false;
		if (nvValeTransporte != other.nvValeTransporte)
			return false;
		if (nvValorizacaoTrabalho != other.nvValorizacaoTrabalho)
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		if (tipoRegimeTrabalho == null) {
			if (other.tipoRegimeTrabalho != null)
				return false;
		} else if (!tipoRegimeTrabalho.equals(other.tipoRegimeTrabalho))
			return false;
		return true;
	}
		
	//metodos
	
		public void setTotal() {
		 this.nvTotal = (double)((((double)((this.nroComentarios*4)+this.nvAcessibilidade+this.nvAcessoTerreno-this.nvCobranca+this.nvComunicacaoInterna-this.nvEstresse-this.nvEsfocoFisico-this.nvEsforcoItelectual+this.nvFacilidadeAcessoSuperiores+this.nvNegociacaoDeSalarioBeneficio+this.nvPlanoSaude+this.nvPossibilidadeCresimento+this.nvRelacionamentoColaboradores+this.nvValeAlimentacao+this.nvValeRefeicao+this.nvValeTransporte+this.nvValorizacaoTrabalho)))/((double)(16*this.nroComentarios)))*10;
		}
}
