/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class GeneralDAO {

    Session sessao;

    public GeneralDAO() {
        sessao = (Session) HibernateUtil.getSessionFactory().openSession();

    }

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public void salvar(Object entidade) {
        sessao.save(entidade);
    }

    public Object carregar(Object entidade, Serializable id) {
        sessao.load(entidade, id);
        return entidade;
    }

    public void apagar(Object entidade) {
        sessao.delete(entidade);
    }

    public void atualizar(Object entidade) {
        sessao.update(entidade);
    }

    public void fecharSessao() {
        sessao.close();
    }

    public ArrayList<Object> listaTodos(String tabela) {
        return (ArrayList<Object>) sessao.createQuery("from " + tabela).list();
    }

    public Object encontraChavePrimaria(String consulta) {
        Query q = this.getSessao().createSQLQuery(consulta);
        return q.uniqueResult();
    }

    public long codigo(String consulta) {

        Iterator i = getSessao().createQuery(consulta).list().iterator();
        long codigo = 0;
        while (i.hasNext()) {
            codigo = (Long) i.next();
        }
        return codigo;
    }

    public ArrayList listar(String consulta) {
        ArrayList dados = new ArrayList();

        Iterator i = getSessao().createQuery(consulta).list().iterator();
        while (i.hasNext()) {
            Object[] array = (Object[]) i.next();
            dados.add(array);
        }
        return dados;
    }
    public List<String> buscaAtributo(String consulta) {
        List<String> assuntos = new ArrayList<>();

        Iterator i = getSessao().createQuery(consulta).list().iterator();

        while (i.hasNext()) {
            assuntos.add(i.next().toString());
        }
        return assuntos;
    }
}
