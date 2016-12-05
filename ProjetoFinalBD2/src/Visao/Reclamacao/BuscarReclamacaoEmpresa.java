/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Reclamacao;

import Controle.ControlePrincipal;
import Modelo.ModeloTabela;
import java.awt.Dimension;
import java.awt.Point;
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
public class BuscarReclamacaoEmpresa extends javax.swing.JDialog {

    private GeneralDAO dao;
    private ControlePrincipal controlePrincipal = new ControlePrincipal();

    /**
     * Creates new form BuscarEmpresa
     */
    public BuscarReclamacaoEmpresa(java.awt.Frame parent, boolean modal, GeneralDAO dao) {
        super(parent, modal);
        initComponents();
        this.dao = dao;
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        this.setSize(screenWidth, screenHeight - 100);
        jTableReclamacoesBuscadas.setAutoCreateRowSorter(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomeEmpresa = new javax.swing.JTextField();
        jButtonBuscarReclamacao = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableReclamacoesBuscadas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldQtdReclamacao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Empresa");

        jLabel1.setText("Nome:");

        jButtonBuscarReclamacao.setText("Buscar");
        jButtonBuscarReclamacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarReclamacaoActionPerformed(evt);
            }
        });

        jTableReclamacoesBuscadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableReclamacoesBuscadas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableReclamacoesBuscadasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableReclamacoesBuscadas);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Quantidade de Reclamações:");

        jTextFieldQtdReclamacao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldQtdReclamacao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldQtdReclamacao.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNomeEmpresa))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(297, 297, 297)
                                .addComponent(jButtonBuscarReclamacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldQtdReclamacao, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldQtdReclamacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonBuscarReclamacao)
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarReclamacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarReclamacaoActionPerformed
        String nome = jTextFieldNomeEmpresa.getText();
        if (nome.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite um nome de busca!", "Campo Vazio", JOptionPane.ERROR_MESSAGE);

        } else {
            ArrayList<Long> codigoempresa = controlePrincipal.buscaCodigoEmpresa(nome, dao);

            if (codigoempresa.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Empresa não cadastrada!", "Empresa não cadastrada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                ArrayList reclamacao = null;
                for (Long l : codigoempresa) {
                    reclamacao = controlePrincipal.buscarReclamacaoEmpresa(l, dao);
                    preencherTabela(reclamacao, nome);
                }

                jTextFieldQtdReclamacao.setText(String.valueOf(reclamacao.size()));
            }
        }
    }//GEN-LAST:event_jButtonBuscarReclamacaoActionPerformed

    private void jTableReclamacoesBuscadasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableReclamacoesBuscadasMouseClicked

        int selecionada = jTableReclamacoesBuscadas.getSelectedRow();
        String s = "\nRegião: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 0).toString()
                + "\nUF: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 1).toString()
                + "\nCidade: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 2).toString()
                + "\nAssunto: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 3).toString()
                + "\nMês Abertura: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 4).toString()
                + "\nAno Abertura: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 5).toString()
                + "\nData Abertura: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 6).toString()
                + "\nData Finalização: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 7).toString()
                + "\nData Resposta: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 8).toString()
                + "\nNota Consumidor: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 9).toString()
                + "\nComo Comprou Contratou: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 10).toString()
                + "\nGrupo Problema: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 11).toString()
                + "\nProcurou Empresa: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 12).toString()
                + "\nTempo Resposta: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 13).toString()
                + "\nAvaliação: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 14).toString()
                + "\nSituação: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 15).toString()
                + "\nRespondida: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 16).toString()
                + "\nProblema: " + jTableReclamacoesBuscadas.getValueAt(selecionada, 17).toString();

        JOptionPane.showMessageDialog(null, s, "Reclamação Cadastrada", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jTableReclamacoesBuscadasMouseClicked

    private void preencherTabela(ArrayList dados, String nome) {
        try {

            String[] nomeColunas = new String[]{"Região", "UF", "Cidade", "Assunto", "Mês Abertura", "Ano Abertura", "Data Abertura",
                "Data Finalização", "Data Resposta", "Nota Consumidor", "Como Comprou Contratou",
                "Grupo Problema", "Procurou Empresa", "Tempo Resposta", "Avaliação",
                "Situação", "Respondida", "Problema"};

            DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
            centralizado.setHorizontalAlignment(SwingConstants.CENTER);
            ModeloTabela modeloTabela = new ModeloTabela(dados, nomeColunas);
            jTableReclamacoesBuscadas.setModel(modeloTabela);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(0).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(0).setHeaderValue(modeloTabela.getColumnNome(0));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(0).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(1).setPreferredWidth(20);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(1).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(1).setHeaderValue(modeloTabela.getColumnNome(1));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(1).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(2).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(2).setHeaderValue(modeloTabela.getColumnNome(2));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(2).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(3).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(3).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(3).setHeaderValue(modeloTabela.getColumnNome(3));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(3).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(4).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(4).setHeaderValue(modeloTabela.getColumnNome(4));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(4).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(5).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(5).setHeaderValue(modeloTabela.getColumnNome(5));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(5).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(6).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(6).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(6).setHeaderValue(modeloTabela.getColumnNome(6));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(6).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(7).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(7).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(7).setHeaderValue(modeloTabela.getColumnNome(7));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(7).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(8).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(8).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(8).setHeaderValue(modeloTabela.getColumnNome(8));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(8).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(9).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(9).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(9).setHeaderValue(modeloTabela.getColumnNome(9));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(9).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(10).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(10).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(10).setHeaderValue(modeloTabela.getColumnNome(10));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(10).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(11).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(11).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(11).setHeaderValue(modeloTabela.getColumnNome(11));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(11).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(12).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(12).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(12).setHeaderValue(modeloTabela.getColumnNome(12));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(12).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(13).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(13).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(13).setHeaderValue(modeloTabela.getColumnNome(13));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(13).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(14).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(14).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(14).setHeaderValue(modeloTabela.getColumnNome(14));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(14).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(15).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(15).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(15).setHeaderValue(modeloTabela.getColumnNome(15));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(15).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(16).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(16).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(16).setHeaderValue(modeloTabela.getColumnNome(16));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(16).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getColumnModel().getColumn(17).setPreferredWidth(50);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(17).setResizable(true);
            jTableReclamacoesBuscadas.getColumnModel().getColumn(17).setHeaderValue(modeloTabela.getColumnNome(17));
            jTableReclamacoesBuscadas.getColumnModel().getColumn(17).setCellRenderer(centralizado);

            jTableReclamacoesBuscadas.getTableHeader().setReorderingAllowed(false);
            jTableReclamacoesBuscadas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jTableReclamacoesBuscadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, "Erro ao listar as empresas de nome " + nome + "!");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarReclamacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableReclamacoesBuscadas;
    private javax.swing.JTextField jTextFieldNomeEmpresa;
    private javax.swing.JTextField jTextFieldQtdReclamacao;
    // End of variables declaration//GEN-END:variables
}
