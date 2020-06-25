package Server.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import Server.Repository.ComentarioRepository;

@Entity
@Table(name = "comentario")
public class Comentario {
	
	
	//atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String conteudo;
	private boolean positivo;

	private short nvPossibilidadeCresimento;
	private short nvComunicacaoInterna;
	private short nvEsforcoFisico;
	private short nvEstresse;
	private short nvAcessibilidade;
	private short nvFacilidadeAcessoSuperiores;
    private short nvCobranca;
    private short nvEsforcoItelectual;
    private short nvValorizacaoTrabalho;
    private short nvNogociacaoDeSalarioBeneficio;
    private short nvAcessoTerreno;
    private short nvValeTransporte;
    private short nvValeRefeicao;
    private short nvValeAlimentacao;
    private short nvPlanoSaude;
    private short nvRelacionamentoColaboradores;
    
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	//@JsonManagedReference
	//@JsonIgnoreProperties("empresa")
	

	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	//@JsonManagedReference
	//@JsonIgnoreProperties("user")
	private User user;
	
	//getters n setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	
	public short getNvFacilidadeAcessoSuperiores() {
		return nvFacilidadeAcessoSuperiores;
	}


	public void setNvFacilidadeAcessoSuperiores(short nvFacilidadeAcessoSuperiores) {
		this.nvFacilidadeAcessoSuperiores = nvFacilidadeAcessoSuperiores;
	}


	public short getNvRelacionamentoColaboradores() {
		return nvRelacionamentoColaboradores;
	}


	public void setNvRelacionamentoColaboradores(short nvRelacionamentoColaboradores) {
		this.nvRelacionamentoColaboradores = nvRelacionamentoColaboradores;
	}


	public short getNvPossibilidadeCresimento() {
		return nvPossibilidadeCresimento;
	}

	public void setNvPossibilidadeCresimento(short nvPossibilidadeCresimento) {
		this.nvPossibilidadeCresimento = nvPossibilidadeCresimento;
	}

	public short getNvComunicacaoInterna() {
		return nvComunicacaoInterna;
	}

	public void setNvComunicacaoInterna(short nvComunicacaoInterna) {
		this.nvComunicacaoInterna = nvComunicacaoInterna;
	}

	public short getNvEsforcoFisico() {
		return nvEsforcoFisico;
	}

	public void setNvEsforcoFisico(short nvEsforcoFisico) {
		this.nvEsforcoFisico = nvEsforcoFisico;
	}

	public short getNvEstresse() {
		return nvEstresse;
	}

	public void setNvEstresse(short nvEstresse) {
		this.nvEstresse = nvEstresse;
	}

	public short getNvAcessibilidade() {
		return nvAcessibilidade;
	}

	public void setNvAcessibilidade(short nvAcessibilidade) {
		this.nvAcessibilidade = nvAcessibilidade;
	}

	public short getNvCobranca() {
		return nvCobranca;
	}

	public void setNvCobranca(short nvCobranca) {
		this.nvCobranca = nvCobranca;
	}

	public short getNvEsforcoItelectual() {
		return nvEsforcoItelectual;
	}

	public void setNvEsforcoItelectual(short nvEsforcoItelectual) {
		this.nvEsforcoItelectual = nvEsforcoItelectual;
	}

	public short getNvValorizacaoTrabalho() {
		return nvValorizacaoTrabalho;
	}

	public void setNvValorizacaoTrabalho(short nvValorizacaoTrabalho) {
		this.nvValorizacaoTrabalho = nvValorizacaoTrabalho;
	}

	public short getNvNogociacaoDeSalarioBeneficio() {
		return nvNogociacaoDeSalarioBeneficio;
	}

	public void setNvNogociacaoDeSalarioBeneficio(short nvNogociacaoDeSalarioBeneficio) {
		this.nvNogociacaoDeSalarioBeneficio = nvNogociacaoDeSalarioBeneficio;
	}

	public short getNvAcessoTerreno() {
		return nvAcessoTerreno;
	}

	public void setNvAcessoTerreno(short nvAcessoTerreno) {
		this.nvAcessoTerreno = nvAcessoTerreno;
	}

	public short getNvValeTransporte() {
		return nvValeTransporte;
	}

	public void setNvValeTransporte(short nvValeTransporte) {
		this.nvValeTransporte = nvValeTransporte;
	}

	public short getNvValeRefeicao() {
		return nvValeRefeicao;
	}

	public void setNvValeRefeicao(short nvValeRefeicao) {
		this.nvValeRefeicao = nvValeRefeicao;
	}

	public short getNvValeAlimentacao() {
		return nvValeAlimentacao;
	}

	public void setNvValeAlimentacao(short nvValeAlimentacao) {
		this.nvValeAlimentacao = nvValeAlimentacao;
	}

	public short getNvPlanoSaude() {
		return nvPlanoSaude;
	}

	public void setNvPlanoSaude(short nvPlanoSaude) {
		this.nvPlanoSaude = nvPlanoSaude;
	}

	public boolean isPositivo() {
		return positivo;
	}

	public void setPositivo(boolean positivo) {
		this.positivo = positivo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	//construtores
	
	public Comentario(Integer id, String conteudo, boolean positivo, short nvPossibilidadeCresimento,
			short nvComunicacaoInterna, short nvEsforcoFisico, short nvEstresse, short nvAcessibilidade,
			short nvFacilidadeAcessoSuperiores, short nvCobranca, short nvEsforcoItelectual,
			short nvValorizacaoTrabalho, short nvNogociacaoDeSalarioBeneficio, short nvAcessoTerreno,
			short nvValeTransporte, short nvValeRefeicao, short nvValeAlimentacao, short nvPlanoSaude,
			short nvRelacionamentoColaboradores, Empresa empresa, User user) {
		super();
		this.id = id;
		this.conteudo = conteudo;
		this.positivo = positivo;
		this.nvPossibilidadeCresimento = nvPossibilidadeCresimento;
		this.nvComunicacaoInterna = nvComunicacaoInterna;
		this.nvEsforcoFisico = nvEsforcoFisico;
		this.nvEstresse = nvEstresse;
		this.nvAcessibilidade = nvAcessibilidade;
		this.nvFacilidadeAcessoSuperiores = nvFacilidadeAcessoSuperiores;
		this.nvCobranca = nvCobranca;
		this.nvEsforcoItelectual = nvEsforcoItelectual;
		this.nvValorizacaoTrabalho = nvValorizacaoTrabalho;
		this.nvNogociacaoDeSalarioBeneficio = nvNogociacaoDeSalarioBeneficio;
		this.nvAcessoTerreno = nvAcessoTerreno;
		this.nvValeTransporte = nvValeTransporte;
		this.nvValeRefeicao = nvValeRefeicao;
		this.nvValeAlimentacao = nvValeAlimentacao;
		this.nvPlanoSaude = nvPlanoSaude;
		this.nvRelacionamentoColaboradores = nvRelacionamentoColaboradores;
		this.empresa = empresa;
		this.user = user;
	}


	public Comentario() {
		super();
	}

	//hash code
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conteudo == null) ? 0 : conteudo.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + nvAcessibilidade;
		result = prime * result + nvAcessoTerreno;
		result = prime * result + nvCobranca;
		result = prime * result + nvComunicacaoInterna;
		result = prime * result + nvEsforcoFisico;
		result = prime * result + nvEsforcoItelectual;
		result = prime * result + nvEstresse;
		result = prime * result + nvFacilidadeAcessoSuperiores;
		result = prime * result + nvNogociacaoDeSalarioBeneficio;
		result = prime * result + nvPlanoSaude;
		result = prime * result + nvPossibilidadeCresimento;
		result = prime * result + nvRelacionamentoColaboradores;
		result = prime * result + nvValeAlimentacao;
		result = prime * result + nvValeRefeicao;
		result = prime * result + nvValeTransporte;
		result = prime * result + nvValorizacaoTrabalho;
		result = prime * result + (positivo ? 1231 : 1237);
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Comentario other = (Comentario) obj;
		if (conteudo == null) {
			if (other.conteudo != null)
				return false;
		} else if (!conteudo.equals(other.conteudo))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nvAcessibilidade != other.nvAcessibilidade)
			return false;
		if (nvAcessoTerreno != other.nvAcessoTerreno)
			return false;
		if (nvCobranca != other.nvCobranca)
			return false;
		if (nvComunicacaoInterna != other.nvComunicacaoInterna)
			return false;
		if (nvEsforcoFisico != other.nvEsforcoFisico)
			return false;
		if (nvEsforcoItelectual != other.nvEsforcoItelectual)
			return false;
		if (nvEstresse != other.nvEstresse)
			return false;
		if (nvFacilidadeAcessoSuperiores != other.nvFacilidadeAcessoSuperiores)
			return false;
		if (nvNogociacaoDeSalarioBeneficio != other.nvNogociacaoDeSalarioBeneficio)
			return false;
		if (nvPlanoSaude != other.nvPlanoSaude)
			return false;
		if (nvPossibilidadeCresimento != other.nvPossibilidadeCresimento)
			return false;
		if (nvRelacionamentoColaboradores != other.nvRelacionamentoColaboradores)
			return false;
		if (nvValeAlimentacao != other.nvValeAlimentacao)
			return false;
		if (nvValeRefeicao != other.nvValeRefeicao)
			return false;
		if (nvValeTransporte != other.nvValeTransporte)
			return false;
		if (nvValorizacaoTrabalho != other.nvValorizacaoTrabalho)
			return false;
		if (positivo != other.positivo)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	
	

}