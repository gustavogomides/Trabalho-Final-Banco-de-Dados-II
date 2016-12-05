/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;
import java.util.List;
import DAO.GeneralDAO;
import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class ControlePrincipal {

    private ControleUsuario controleUsuário = new ControleUsuario();
    private ControleEmpresa controleEmpresa = new ControleEmpresa();
    private ControleReclamacao controleReclamacao = new ControleReclamacao();

    public ArrayList listarUsuarios(GeneralDAO dao) {
        return controleUsuário.listarUsuarios(dao);
    }

    public boolean inserirEmpresa(String nomefantasia, String area, String segmento, GeneralDAO dao) {
        return controleEmpresa.inserir(nomefantasia, area, segmento, dao);
    }

    public boolean verificanomefantasia(String nome, String area, String segmento, GeneralDAO dao) {
        return controleEmpresa.seEmpresaCadastrada(nome, area, segmento, dao);
    }

    public ArrayList listarEmpresas(GeneralDAO dao) {
        return controleEmpresa.listarEmpresas(dao);
    }

    public ArrayList buscarEmpresa(String nome, GeneralDAO dao) {
        return controleEmpresa.buscarEmpresas(nome, dao);
    }

    public ArrayList<Long> buscaCodigoEmpresa(String nome, GeneralDAO dao) {
        return controleEmpresa.buscaCodigoEmpresa(nome, dao);
    }

    public boolean deletarEmpresa(String nome, String area, String segmento, GeneralDAO dao) {
        return controleEmpresa.deletarEmpresa(nome, area, segmento, dao);
    }

    public List<String> assuntos(GeneralDAO dao) {
        return controleReclamacao.buscaAssunto(dao);
    }

    public List<String> comoComprouContratou(GeneralDAO dao) {
        return controleReclamacao.comoComprouContratou(dao);
    }

    public List<String> grupoProblema(GeneralDAO dao) {
        return controleReclamacao.grupoproblema(dao);
    }

    public List<String> problema(GeneralDAO dao) {
        return controleReclamacao.problema(dao);
    }

    public List<String> cidade(GeneralDAO dao) {
        return controleReclamacao.cidade(dao);
    }

    public boolean cadastrarReclamacao(String regiao, String uf, String cidade, String assunto,
            int mesabertura, Date dataabertura, int notaconsumidor,
            int anoabertura, String comocomproucontratou, String grupoproblema, String procurouempresa,
            int temporesposta, String avaliacaoreclamacao, String situacao, String respondida,
            Date datafinalizacao, Date dataresposta, String problema, GeneralDAO dao,
            String nomefantasia, String area, String segmento,
            String sexo, String faixaetaria) {
        return controleReclamacao.cadastrarReclamacao(regiao, uf, cidade, assunto, mesabertura, dataabertura,
                notaconsumidor, anoabertura, comocomproucontratou, grupoproblema,
                procurouempresa, temporesposta, avaliacaoreclamacao, situacao, respondida,
                datafinalizacao, dataresposta, problema, dao, nomefantasia, area, segmento, sexo, faixaetaria);
    }

    public ArrayList listaReclamacoes(GeneralDAO dao) {
        return controleReclamacao.listarReclamacoes(dao);
    }

    public ArrayList buscarReclamacaoEmpresa(long codigoempresa, GeneralDAO dao) {
        return controleReclamacao.buscarReclamacaoEmpresa(codigoempresa, dao);
    }

    public ArrayList buscarReclamacaoAssunto(String assunto, GeneralDAO dao) {
        return controleReclamacao.buscarReclamacaoAssunto(assunto, dao);
    }

    public ArrayList buscarReclamacaoMesAnoAbertura(int mes, int ano, GeneralDAO dao) {
        return controleReclamacao.buscarReclamacaoMesAnoAbertura(mes, ano, dao);
    }

    public boolean atualizarEmpresa(String nomeAntigo, String areaAntigo, String segmentoAntigo,
            String nome, String area, String segmento, GeneralDAO dao) {
        return controleEmpresa.atualizarEmpresa(nomeAntigo, areaAntigo, segmentoAntigo, nome, area, segmento, dao);
    }
}
