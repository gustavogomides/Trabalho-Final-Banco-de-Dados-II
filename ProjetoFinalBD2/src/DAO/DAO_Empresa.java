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

/**
 *
 * @author Gustavo
 */
public class DAO_Empresa {

    private Session sessao;

    public DAO_Empresa(Session sessao) {
        this.sessao = sessao;
    }

    public Session getSessao() {
        return sessao;
    }

    public boolean seEmpresaCadastrada(String nome, String area, String segmento) {
        String consulta = "from Empresa where nomefantasia = '" + nome + "'";

        Iterator i = getSessao().createQuery(consulta).list().iterator();
        int contador = 0;
        Empresa empresa;

        while (i.hasNext()) {
            empresa = (Empresa) i.next();
            if (empresa.getArea().equals(area) && empresa.getSegmentomercado().equals(segmento)) {
                contador++;
                break;
            }
        }

        return contador != 0;
    }

    public ArrayList<Long> buscaCodigoEmpresa(String nome) {
        ArrayList<Long> codigo = new ArrayList<>();
        String consulta = "Select codigoempresa from Empresa where nomefantasia = '" + nome + "'";

        Iterator i = getSessao().createQuery(consulta).list().iterator();

        while (i.hasNext()) {
            codigo.add((long) i.next());
        }

        return codigo;
    }

    
}
