package e.vivi.home.Models;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private Integer id;
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

    private int nroComentarios;


    private String nomeMarca;
    private String cidade;
    private String estado;
    private String rua;
    private int numero;
    private String bairro;
    private String tipoRegimeTrabalho;

    private boolean autorizado;

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nvTotal=" + nvTotal +
                ", nvPossibilidadeCresimento=" + nvPossibilidadeCresimento +
                ", nvComunicacaoInterna=" + nvComunicacaoInterna +
                ", nvEsfocoFisico=" + nvEsfocoFisico +
                ", nvEstresse=" + nvEstresse +
                ", nvAcessibilidade=" + nvAcessibilidade +
                ", nvFacilidadeAcessoSuperiores=" + nvFacilidadeAcessoSuperiores +
                ", nvCobranca=" + nvCobranca +
                ", nvEsforcoItelectual=" + nvEsforcoItelectual +
                ", nvValorizacaoTrabalho=" + nvValorizacaoTrabalho +
                ", nvNegociacaoDeSalarioBeneficio=" + nvNegociacaoDeSalarioBeneficio +
                ", nvAcessoTerreno=" + nvAcessoTerreno +
                ", nvValeTransporte=" + nvValeTransporte +
                ", nvValeRefeicao=" + nvValeRefeicao +
                ", nvValeAlimentacao=" + nvValeAlimentacao +
                ", nvPlanoSaude=" + nvPlanoSaude +
                ", nvRelacionamentoColaboradores=" + nvRelacionamentoColaboradores +
                ", nroComentarios=" + nroComentarios +
                ", nomeMarca='" + nomeMarca + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", rua='" + rua + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", tipoRegimeTrabalho='" + tipoRegimeTrabalho + '\'' +
                ", autorizado=" + autorizado +
                '}';
    }

    public Empresa() {
    }

    public Empresa(String nomeMarca, String cidade, String estado, String rua, int numero, String bairro, String tipoRegimeTrabalho) {
        this.id = 0;
        this.nvTotal = 0;
        this.nvPossibilidadeCresimento = 0;
        this.nvComunicacaoInterna = 0;
        this.nvEsfocoFisico = 0;
        this.nvEstresse = 0;
        this.nvAcessibilidade = 0;
        this.nvFacilidadeAcessoSuperiores = 0;
        this.nvCobranca = 0;
        this.nvEsforcoItelectual = 0;
        this.nvValorizacaoTrabalho = 0;
        this.nvNegociacaoDeSalarioBeneficio = 0;
        this.nvAcessoTerreno = 0;
        this.nvValeTransporte = 0;
        this.nvValeRefeicao = 0;
        this.nvValeAlimentacao = 0;
        this.nvPlanoSaude = 0;
        this.nvRelacionamentoColaboradores = 0;
        this.nroComentarios = 0;
        this.nomeMarca = nomeMarca;
        this.cidade = cidade;
        this.estado = estado;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.tipoRegimeTrabalho = tipoRegimeTrabalho;
        this.autorizado = false;
    }

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

    public int getNvNogociacaoDeSalarioBeneficio() {
        return nvNegociacaoDeSalarioBeneficio;
    }

    public void setNvNogociacaoDeSalarioBeneficio(int nvNogociacaoDeSalarioBeneficio) {
        this.nvNegociacaoDeSalarioBeneficio = nvNogociacaoDeSalarioBeneficio;
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

    public int getNvRelacionamentoColaboradores() {
        return nvRelacionamentoColaboradores;
    }

    public void setNvRelacionamentoColaboradores(int nvRelacionamentoColaboradores) {
        this.nvRelacionamentoColaboradores = nvRelacionamentoColaboradores;
    }

    public int getNroComentarios() {
        return nroComentarios;
    }

    public void setNroComentarios(int nroComentarios) {
        this.nroComentarios = nroComentarios;
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
}
