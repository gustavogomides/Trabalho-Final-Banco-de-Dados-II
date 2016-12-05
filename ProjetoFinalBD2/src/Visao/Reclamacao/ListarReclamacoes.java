/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Reclamacao;

import Controle.ControlePrincipal;
import Modelo.ModeloTabela;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import DAO.GeneralDAO;

/**
 *
 * @author Gustavo
 */
public class ListarReclamacoes extends javax.swing.JDialog {

    private GeneralDAO dao;
    private ControlePrincipal controlePrincipal = new ControlePrincipal();

    /**
     * Creates new form ListarReclamacoes
     */
    public ListarReclamacoes(java.awt.Frame parent, boolean modal, GeneralDAO dao) {
        super(parent, modal);
        initComponents();
        this.dao = dao;
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        this.setSize(screenWidth, screenHeight - 100);
        preencherTabela();
        jTableListarReclamacao.setAutoCreateRowSorter(true);
    }

    public void preencherTabela() {

        try {

            String[] nomeColunas = new String[]{"Região", "UF", "Cidade", "Assunto", "Mês Abertura", "Ano Abertura", "Data Abertura",
                "Data Finalização", "Data Resposta", "Nota Consumidor", "Como Comprou Contratou",
                "Grupo Problema", "Procurou Empresa", "Tempo Resposta", "Avaliação",
                "Situação", "Respondida", "Problema"};

            ArrayList dados = controlePrincipal.listaReclamacoes(dao);

            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            ModeloTabela modeloTabela = new ModeloTabela(dados, nomeColunas);
            jTableListarReclamacao.setModel(modeloTabela);

            jTableListarReclamacao.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTableListarReclamacao.getColumnModel().getColumn(0).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(0).setHeaderValue(modeloTabela.getColumnNome(0));
            jTableListarReclamacao.getColumnModel().getColumn(0).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTableListarReclamacao.getColumnModel().getColumn(1).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(1).setHeaderValue(modeloTabela.getColumnNome(1));
            jTableListarReclamacao.getColumnModel().getColumn(1).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(2).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(2).setHeaderValue(modeloTabela.getColumnNome(2));
            jTableListarReclamacao.getColumnModel().getColumn(2).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(3).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(3).setHeaderValue(modeloTabela.getColumnNome(3));
            jTableListarReclamacao.getColumnModel().getColumn(3).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(4).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(4).setHeaderValue(modeloTabela.getColumnNome(4));
            jTableListarReclamacao.getColumnModel().getColumn(4).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(5).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(5).setHeaderValue(modeloTabela.getColumnNome(5));
            jTableListarReclamacao.getColumnModel().getColumn(5).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(6).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(6).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(6).setHeaderValue(modeloTabela.getColumnNome(6));
            jTableListarReclamacao.getColumnModel().getColumn(6).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(7).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(7).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(7).setHeaderValue(modeloTabela.getColumnNome(7));
            jTableListarReclamacao.getColumnModel().getColumn(7).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(8).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(8).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(8).setHeaderValue(modeloTabela.getColumnNome(8));
            jTableListarReclamacao.getColumnModel().getColumn(8).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(9).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(9).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(9).setHeaderValue(modeloTabela.getColumnNome(9));
            jTableListarReclamacao.getColumnModel().getColumn(9).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(10).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(10).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(10).setHeaderValue(modeloTabela.getColumnNome(10));
            jTableListarReclamacao.getColumnModel().getColumn(10).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(11).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(11).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(11).setHeaderValue(modeloTabela.getColumnNome(11));
            jTableListarReclamacao.getColumnModel().getColumn(11).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(12).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(12).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(12).setHeaderValue(modeloTabela.getColumnNome(12));
            jTableListarReclamacao.getColumnModel().getColumn(12).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(13).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(13).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(13).setHeaderValue(modeloTabela.getColumnNome(13));
            jTableListarReclamacao.getColumnModel().getColumn(13).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(14).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(14).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(14).setHeaderValue(modeloTabela.getColumnNome(14));
            jTableListarReclamacao.getColumnModel().getColumn(14).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(15).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(15).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(15).setHeaderValue(modeloTabela.getColumnNome(15));
            jTableListarReclamacao.getColumnModel().getColumn(15).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(16).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(16).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(16).setHeaderValue(modeloTabela.getColumnNome(16));
            jTableListarReclamacao.getColumnModel().getColumn(16).setCellRenderer(centralizado);

            jTableListarReclamacao.getColumnModel().getColumn(17).setPreferredWidth(50);
            jTableListarReclamacao.getColumnModel().getColumn(17).setResizable(true);
            jTableListarReclamacao.getColumnModel().getColumn(17).setHeaderValue(modeloTabela.getColumnNome(17));
            jTableListarReclamacao.getColumnModel().getColumn(17).setCellRenderer(centralizado);

            jTableListarReclamacao.getTableHeader().setReorderingAllowed(false);
            jTableListarReclamacao.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jTableListarReclamacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        } catch (Exception exc) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListarReclamacao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Reclamações");

        jTableListarReclamacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableListarReclamacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListarReclamacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListarReclamacao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableListarReclamacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListarReclamacaoMouseClicked
        int selecionada = jTableListarReclamacao.getSelectedRow();
        String s = "\nRegião: " + jTableListarReclamacao.getValueAt(selecionada, 0).toString()
                + "\nUF: " + jTableListarReclamacao.getValueAt(selecionada, 1).toString()
                + "\nCidade: " + jTableListarReclamacao.getValueAt(selecionada, 2).toString()
                + "\nAssunto: " + jTableListarReclamacao.getValueAt(selecionada, 3).toString()
                + "\nMês Abertura: " + jTableListarReclamacao.getValueAt(selecionada, 4).toString()
                + "\nAno Abertura: " + jTableListarReclamacao.getValueAt(selecionada, 5).toString()
                + "\nData Abertura: " + jTableListarReclamacao.getValueAt(selecionada, 6).toString()
                + "\nData Finalização: " + jTableListarReclamacao.getValueAt(selecionada, 7).toString()
                + "\nData Resposta: " + jTableListarReclamacao.getValueAt(selecionada, 8).toString()
                + "\nNota Consumidor: " + jTableListarReclamacao.getValueAt(selecionada, 9).toString()
                + "\nComo Comprou Contratou: " + jTableListarReclamacao.getValueAt(selecionada, 10).toString()
                + "\nGrupo Problema: " + jTableListarReclamacao.getValueAt(selecionada, 11).toString()
                + "\nProcurou Empresa: " + jTableListarReclamacao.getValueAt(selecionada, 12).toString()
                + "\nTempo Resposta: " + jTableListarReclamacao.getValueAt(selecionada, 13).toString()
                + "\nAvaliação: " + jTableListarReclamacao.getValueAt(selecionada, 14).toString()
                + "\nSituação: " + jTableListarReclamacao.getValueAt(selecionada, 15).toString()
                + "\nRespondida: " + jTableListarReclamacao.getValueAt(selecionada, 16).toString()
                + "\nProblema: " + jTableListarReclamacao.getValueAt(selecionada, 17).toString();

        JOptionPane.showMessageDialog(null, s, "Reclamação Cadastrada", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jTableListarReclamacaoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListarReclamacao;
    // End of variables declaration//GEN-END:variables
}
