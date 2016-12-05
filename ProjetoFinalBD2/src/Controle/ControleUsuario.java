/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.util.ArrayList;
import DAO.GeneralDAO;

/**
 *
 * @author Gustavo
 */
public class ControleUsuario {

    public ArrayList listarUsuarios(GeneralDAO dao) {
        return dao.listar("Select sexo, faixaetaria from "
                + "Usuario order by faixaetaria");
    }

    public long codigoUsuario(char sexo, String faixaetaria, GeneralDAO dao) {
        return dao.codigo("Select codigousuario from "
                + "Usuario where sexo='" + sexo + "' and faixaetaria='" + faixaetaria + "'");
    }
}
