/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.DAO_Empresa;
import Mapeamento.Empresa;
import java.math.BigInteger;
import java.util.ArrayList;
import org.hibernate.Transaction;
import DAO.GeneralDAO;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class ControleEmpresa {

    public boolean inserir(String nomefantasia, String area, String segmento, GeneralDAO dao) {

        boolean retorno;

        try {
            Empresa empresa = new Empresa();

            BigInteger cont = (BigInteger) dao.encontraChavePrimaria("select max(codigoempresa) from empresa");

            long codigo = cont.add(new BigInteger("1")).longValue();
            empresa.setNomefantasia(nomefantasia);
            empresa.setArea(area);
            empresa.setSegmentomercado(segmento);
            empresa.setCodigoempresa(codigo);

            dao.salvar(empresa);
            Transaction transaction = dao.getSessao().beginTransaction();
            transaction.commit();
            retorno = true;
        } catch (Exception ex) {
            dao.getSessao().getTransaction().rollback();
            retorno = false;
        }

        return retorno;
    }

    public boolean seEmpresaCadastrada(String nome, String area, String segmento, GeneralDAO dao) {
        DAO_Empresa dao_empresa = new DAO_Empresa(dao.getSessao());
        return dao_empresa.seEmpresaCadastrada(nome, area, segmento);
    }

    public ArrayList<Long> buscaCodigoEmpresa(String nome, GeneralDAO dao) {
        DAO_Empresa dao_empresa = new DAO_Empresa(dao.getSessao());
        return dao_empresa.buscaCodigoEmpresa(nome);
    }

    public ArrayList listarEmpresas(GeneralDAO dao) {
        return dao.listar("Select nomefantasia, area, segmentomercado from "
                + "Empresa order by nomefantasia");
    }

    public ArrayList buscarEmpresas(String nome, GeneralDAO dao) {
        return dao.listar("Select nomefantasia, area, segmentomercado "
                + "from Empresa where nomefantasia='" + nome + "'");
    }

    public long buscaCodigoEmpresaCompleto(String nome, String area, String segmento, GeneralDAO dao) {
        return dao.codigo("Select codigoempresa from Empresa where nomefantasia "
                + "= '" + nome + "' and area='" + area + "' and segmentomercado='" + segmento + "'");
    }

    public boolean deletarEmpresa(String nome, String area, String segmento, GeneralDAO dao) {
        long codigo = buscaCodigoEmpresaCompleto(nome, area, segmento, dao);

        Empresa empresa = new Empresa();
        empresa.setCodigoempresa(codigo);
        empresa.setArea(area);
        empresa.setNomefantasia(nome);
        empresa.setSegmentomercado(segmento);
        boolean retorno;
        try {
            dao.apagar(empresa);
            Transaction transaction = dao.getSessao().beginTransaction();
            transaction.commit();
            retorno = true;
        } catch (Exception exc) {
            System.out.println(exc);
            retorno = false;
        }
        return retorno;
    }

    public boolean atualizarEmpresa(String nomeAntigo, String areaAntigo, String segmentoAntigo,
            String nome, String area, String segmento, GeneralDAO dao) {
        long codigoEmpresa = buscaCodigoEmpresaCompleto(nomeAntigo, areaAntigo, segmentoAntigo, dao);
        Empresa empresa = new Empresa();
        dao.carregar(empresa, codigoEmpresa);

        boolean retorno;

        try {
            empresa.setNomefantasia(nome);
            empresa.setArea(area);
            empresa.setSegmentomercado(segmento);
            dao.atualizar(empresa);
            Transaction transaction = dao.getSessao().beginTransaction();
            transaction.commit();
            retorno = true;
        } catch (Exception exc) {
            retorno = false;
        }

        return retorno;
    }

}
