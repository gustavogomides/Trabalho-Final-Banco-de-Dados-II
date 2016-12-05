/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.DAO_Relatorio;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import DAO.GeneralDAO;

/**
 *
 * @author Gustavo
 */
public class ControleRelatorio {

    /*
     número de reclamações por estado, 
     ==> select uf, count(codigoreclamacao) from reclamacao group by (uf) order by (uf) desc; 
        
     10 empresas mais reclamadas, 
    
     número de reclamações por cidade, 
     ==> select cidade, count(codigoreclamacao) from reclamacao group by cidade order by cidade desc; 
    
     nota média dada pelos consumidores a empresa.    
     ==> select e.nomefantasia, avg(notaconsumidor) from reclamacao r join empresa e on r.codempresa = e.codigoempresa group by e.nomefantasia order by e.nomefantasia desc;
     */
    private GeneralDAO dao;
    private DAO_Relatorio dao_relatorio;

    public ControleRelatorio(GeneralDAO dao) {
        this.dao = dao;
        dao_relatorio = new DAO_Relatorio(dao.getSessao());
    }

    public DefaultCategoryDataset numeroReclamacoesEstadoGrafico() {

        String consulta = "Select uf, count(codigoreclamacao) from "
                + "Reclamacao group by (uf) order by count(codigoreclamacao) desc";
        return dao_relatorio.valoresGraficoBarras(consulta);
    }

    public String numeroReclamacoesEstadoSTR() {
        return dao_relatorio.numeroReclamacoesEstadoSTR();
    }

    public DefaultPieDataset numeroReclamacoesSexoGrafico() {
        return dao_relatorio.numeroReclamacoesSexoGrafico();
    }

    public String numeroReclamacoesSexo() {
        return dao_relatorio.numeroReclamacoesSexo();
    }

}
