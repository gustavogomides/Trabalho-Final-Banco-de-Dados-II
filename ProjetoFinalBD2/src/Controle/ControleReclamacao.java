/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Mapeamento.Empresa;
import Mapeamento.Reclamacao;
import Mapeamento.Usuario;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Transaction;
import DAO.GeneralDAO;
import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class ControleReclamacao {

    public List<String> buscaAssunto(GeneralDAO dao) {
        return dao.buscaAtributo("select distinct(assunto) from Reclamacao order by assunto");
    }

    public List<String> comoComprouContratou(GeneralDAO dao) {
        return dao.buscaAtributo("select distinct(comocomproucontratou) from Reclamacao order by comocomproucontratou");
    }

    public List<String> grupoproblema(GeneralDAO dao) {
        return dao.buscaAtributo("select distinct(grupoproblema) from Reclamacao order by grupoproblema");
    }

    public List<String> problema(GeneralDAO dao) {
        return dao.buscaAtributo("select distinct(problema) from Reclamacao order by problema");
    }

    public boolean cadastrarReclamacao(String regiao, String uf, String cidade, String assunto, 
            int mesabertura, Date dataabertura, int notaconsumidor,
            int anoabertura, String comocomproucontratou, String grupoproblema, String procurouempresa,
            int temporesposta, String avaliacaoreclamacao, String situacao, String respondida,
            Date datafinalizacao, Date dataresposta, String problema, GeneralDAO dao,
            String nomefantasia, String area, String segmento,
            String sexo, String faixaetaria) {

        boolean retorno;
        char sex = sexo.charAt(0);
        char procurou = procurouempresa.charAt(0);
        char respond = respondida.charAt(0);

        ControleUsuario controleUsuario = new ControleUsuario();
        ControleEmpresa controleEmpresa = new ControleEmpresa();

        long codusuario = controleUsuario.codigoUsuario(sex, faixaetaria, dao);
        long codempresa = controleEmpresa.buscaCodigoEmpresaCompleto(nomefantasia, area, segmento, dao);

        Usuario usuario = new Usuario();
        Empresa empresa = new Empresa();

        try {
            Reclamacao reclamacao = new Reclamacao();

            BigInteger cont = (BigInteger) dao.encontraChavePrimaria("select count(codigoreclamacao) from reclamacao");
            long codigo = cont.add(new BigInteger("1")).longValue();

            dao.carregar(usuario, codusuario);
            dao.carregar(empresa, codempresa);

            reclamacao.setRegiao(regiao);
            reclamacao.setUf(uf);
            reclamacao.setCidade(cidade);
            reclamacao.setAnoabertura(anoabertura);
            reclamacao.setAssunto(assunto);
            reclamacao.setAvaliacaoreclamacao(avaliacaoreclamacao);
            reclamacao.setCodigoreclamacao(codigo);
            reclamacao.setComocomproucontratou(comocomproucontratou);
            reclamacao.setDataabertura(dataabertura);
            reclamacao.setDatafinalizacao(datafinalizacao);
            reclamacao.setDataresposta(dataresposta);
            reclamacao.setEmpresa(empresa); // empresa
            reclamacao.setGrupoproblema(grupoproblema);
            reclamacao.setMesabertura(mesabertura);
            reclamacao.setNotaconsumidor(notaconsumidor);
            reclamacao.setProblema(problema);
            reclamacao.setProcurouempresa(procurou);
            reclamacao.setRespondida(respond);
            reclamacao.setSituacao(situacao);
            reclamacao.setTemporesposta(temporesposta);
            reclamacao.setUsuario(usuario);//usuario

            dao.salvar(reclamacao);
            Transaction transaction = dao.getSessao().beginTransaction();
            transaction.commit();

            retorno = true;
        } catch (Exception ex) {
            retorno = false;
        }

        return retorno;
    }

    public ArrayList listarReclamacoes(GeneralDAO dao) {

        String consulta = "Select regiao, uf, cidade, assunto, mesabertura, anoabertura, dataabertura"
                + ", datafinalizacao, dataresposta, notaconsumidor, comocomproucontratou"
                + ", grupoproblema, procurouempresa, temporesposta, avaliacaoreclamacao"
                + ", situacao, respondida, problema"
                + " from Reclamacao order by assunto";

        return dao.listar(consulta);
    }

    public ArrayList buscarReclamacaoEmpresa(long codigoempresa, GeneralDAO dao) {
        String consulta = "Select regiao, uf, cidade, assunto, mesabertura, anoabertura, dataabertura"
                + ", datafinalizacao, dataresposta, notaconsumidor, comocomproucontratou"
                + ", grupoproblema, procurouempresa, temporesposta, avaliacaoreclamacao"
                + ", situacao, respondida, problema"
                + " from Reclamacao where codempresa=" + codigoempresa + " order by assunto";

        return dao.listar(consulta);
    }

    public ArrayList buscarReclamacaoAssunto(String assunto, GeneralDAO dao) {
        String consulta = "Select regiao, uf, cidade, mesabertura, anoabertura, dataabertura"
                + ", datafinalizacao, dataresposta, notaconsumidor, comocomproucontratou"
                + ", grupoproblema, procurouempresa, temporesposta, avaliacaoreclamacao"
                + ", situacao, respondida, problema"
                + " from Reclamacao where assunto='" + assunto + "' order by assunto";

        return dao.listar(consulta);
    }

    public ArrayList buscarReclamacaoMesAnoAbertura(int mes, int ano, GeneralDAO dao) {
        String consulta = "Select regiao, uf, cidade, assunto, dataabertura"
                + ", datafinalizacao, dataresposta, notaconsumidor, comocomproucontratou"
                + ", grupoproblema, procurouempresa, temporesposta, avaliacaoreclamacao"
                + ", situacao, respondida, problema"
                + " from Reclamacao where mesabertura=" + mes + " and anoabertura=" + ano + " order by assunto";

        return dao.listar(consulta);
    }

    public List<String> cidade(GeneralDAO dao) {
        String consulta = "select distinct(cidade) from Reclamacao order by cidade";
        return dao.buscaAtributo(consulta);
    }

}
