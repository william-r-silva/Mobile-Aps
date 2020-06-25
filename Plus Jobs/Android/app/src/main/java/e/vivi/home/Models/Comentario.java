package e.vivi.home.Models;

public class Comentario {

    private Integer id;
    private boolean positivo;
    private String conteudo;

    private Empresa empresa;
    private User user;

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

    public Comentario() {
        this.id = id;
        this.positivo = false;
        this.conteudo = null;
        this.nvPossibilidadeCresimento = 1;
        this.nvComunicacaoInterna = 1;
        this.nvEsforcoFisico = 1;
        this.nvEstresse = 1;
        this.nvAcessibilidade = 1;
        this.nvFacilidadeAcessoSuperiores = 1;
        this.nvCobranca = 1;
        this.nvEsforcoItelectual = 1;
        this.nvValorizacaoTrabalho = 1;
        this.nvNogociacaoDeSalarioBeneficio = 1;
        this.nvAcessoTerreno = 1;
        this.nvValeTransporte = 1;
        this.nvValeRefeicao = 1;
        this.nvValeAlimentacao = 1;
        this.nvPlanoSaude = 1;
        this.empresa = null;
        this.user = null;
    }

    public Comentario(Integer id, boolean comenPositivo, String conteudo, Empresa empresa, User user, short nvPossibilidadeCresimento, short nvComunicacaoInterna, short nvEsforcoFisico, short nvEstresse, short nvAcessibilidade, short nvFacilidadeAcessoSuperiores, short nvCobranca, short nvEsforcoItelectual, short nvValorizacaoTrabalho, short nvNogociacaoDeSalarioBeneficio, short nvAcessoTerreno, short nvValeTransporte, short nvValeRefeicao, short nvValeAlimentacao, short nvPlanoSaude, short nvRelacionamentoColaboradores) {
        this.id = id;
        this.positivo = comenPositivo;
        this.conteudo = conteudo;
        this.empresa = empresa;
        this.user = user;
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
    }

    public short getNvRelacionamentoColaboradores() {
        return nvRelacionamentoColaboradores;
    }

    public void setNvRelacionamentoColaboradores(short nvRelacionamentoColaboradores) {
        this.nvRelacionamentoColaboradores = nvRelacionamentoColaboradores;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isComenPositivo() {
        return positivo;
    }

    public void setComenPositivo(boolean comenPositivo) {
        this.positivo = comenPositivo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
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

    public short getNvFacilidadeAcessoSuperiores() {
        return nvFacilidadeAcessoSuperiores;
    }

    public void setNvFacilidadeAcessoSuperiores(short nvFacilidadeAcessoSuperiores) {
        this.nvFacilidadeAcessoSuperiores = nvFacilidadeAcessoSuperiores;
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

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", comenPositivo=" + positivo +
                ", conteudo='" + conteudo + '\'' +
                ", nvPossibilidadeCresimento=" + nvPossibilidadeCresimento +
                ", nvComunicacaoInterna=" + nvComunicacaoInterna +
                ", nvEsforcoFisico=" + nvEsforcoFisico +
                ", nvEstresse=" + nvEstresse +
                ", nvAcessibilidade=" + nvAcessibilidade +
                ", nvFacilidadeAcessoSuperiores=" + nvFacilidadeAcessoSuperiores +
                ", nvCobranca=" + nvCobranca +
                ", nvEsforcoItelectual=" + nvEsforcoItelectual +
                ", nvValorizacaoTrabalho=" + nvValorizacaoTrabalho +
                ", nvNogociacaoDeSalarioBeneficio=" + nvNogociacaoDeSalarioBeneficio +
                ", nvAcessoTerreno=" + nvAcessoTerreno +
                ", nvValeTransporte=" + nvValeTransporte +
                ", nvValeRefeicao=" + nvValeRefeicao +
                ", nvValeAlimentacao=" + nvValeAlimentacao +
                ", nvPlanoSaude=" + nvPlanoSaude +
                ", empresa=" + empresa +
                ", user=" + user +
                '}';
    }
}
