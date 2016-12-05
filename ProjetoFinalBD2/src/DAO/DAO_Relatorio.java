/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Mapeamento.Empresa;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Gustavo
 */
public class DAO_Relatorio {

    private Session sessao;

    public DAO_Relatorio(Session sessao) {
        this.sessao = sessao;
    }

    public Session getSessao() {
        return sessao;
    }

    public DefaultCategoryDataset valoresGraficoBarras(String consulta) {

        Iterator i = getSessao().createSQLQuery(consulta).list().iterator();

        Object[] reclamacao;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        while (i.hasNext()) {
            reclamacao = (Object[]) i.next();
            dataset.setValue(Integer.parseInt(reclamacao[1].toString()), reclamacao[0].toString(), reclamacao[0].toString());
        }

        return dataset;
    }

    public String numeroReclamacoesEstadoSTR() {

        String consulta = "Select uf, count(codigoreclamacao) from "
                + "Reclamacao group by (uf) order by (uf)";

        Iterator i = getSessao().createSQLQuery(consulta).list().iterator();

        Object[] reclamacao;
        String saida = "";

        while (i.hasNext()) {
            reclamacao = (Object[]) i.next();

            saida += reclamacao[0].toString() + ": " + reclamacao[1].toString() + "\n";
        }

        return saida;
    }

    public DefaultPieDataset numeroReclamacoesSexoGrafico() {

        String consulta = "Select u.sexo, count(r.codigoreclamacao) from "
                + "reclamacao r join usuario u on r.codusuario = u.codigousuario group by (u.sexo)";

        Iterator i = getSessao().createSQLQuery(consulta).list().iterator();

        Object[] reclamacao = null;
        DefaultPieDataset dataset = new DefaultPieDataset();

        while (i.hasNext()) {
            reclamacao = (Object[]) i.next();
            String sexo;
            if (reclamacao[0].toString().equals("M")) {
                sexo = "Masculino";
            } else {
                sexo = "Feminino";
            }
            dataset.setValue(sexo, Integer.parseInt(reclamacao[1].toString()));
        }

        return dataset;
    }

    public String numeroReclamacoesSexo() {

        String consulta = "Select u.sexo, count(r.codigoreclamacao) from "
                + "reclamacao r join usuario u on r.codusuario = u.codigousuario group by (u.sexo)";

        Iterator i = getSessao().createSQLQuery(consulta).list().iterator();

        Object[] reclamacao = null;
        String saida = "";

        while (i.hasNext()) {
            reclamacao = (Object[]) i.next();
            String sexo;
            if (reclamacao[0].toString().equals("M")) {
                sexo = "Masculino";
            } else {
                sexo = "Feminino";
            }
            saida += "Sexo " + sexo + ": " + reclamacao[1].toString() + "\n";
        }

        return saida;
    }

    public int quantidadeRegistros(String consulta) {
        Iterator i = getSessao().createQuery(consulta).list().iterator();
        int qtd = 0;
        while (i.hasNext()) {
            qtd = (int) i.next();
        }
        return qtd;
    }

    public double funcaoAgregacaoDouble(String consulta) {
        double nota = 0;

        Iterator i = getSessao().createQuery(consulta).list().iterator();

        while (i.hasNext()) {
            nota = (double) i.next();
        }

        return nota;
    }

    public String cidadeMaisReclamada(String consulta) {
        List<String> cidades = new ArrayList<>();

        Iterator i = getSessao().createQuery(consulta).list().iterator();

        while (i.hasNext()) {
            cidades.add(i.next().toString());
        }

        return cidades.get(0);
    }

    public ArrayList<Long> codigosEmpresas(String nome) {
        ArrayList<Long> codigosEmpresa = new ArrayList();
        Iterator i = getSessao().createQuery("select codigoempresa from"
                + " Empresa where nomefantasia='" + nome + "'").list().iterator();
        while (i.hasNext()) {
            long array = (Long) i.next();
            codigosEmpresa.add(array);
        }
        return codigosEmpresa;
    }

}
