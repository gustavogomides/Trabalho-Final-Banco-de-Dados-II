/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Relatorio;

import DAO.DAO_Relatorio;
import DAO.GeneralDAO;
import Mapeamento.Empresa;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class Relatorio_IndiceSolucao extends javax.swing.JDialog {

    private final GeneralDAO dao;
    private List<String> empresas;
    private String nome;
    private boolean periodo;
    private final DateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
    private Date Datedataabertura, Datedatafinalizacao;
    private double indicegeral;
    private Frame parent;

    /**
     * Creates new form Relatorio_IndiceSolucao
     *
     * @param parent
     * @param modal
     * @param dao
     */
    public Relatorio_IndiceSolucao(java.awt.Frame parent, boolean modal, GeneralDAO dao) {
        super(parent, modal);
        initComponents();
        this.dao = dao;
        preencherComboBox();
        jDateChooserAbertura.setVisible(false);
        jDateChooserFinalizacao.setVisible(false);
        jLabelAbertura.setVisible(false);
        jLabelFinalizada.setVisible(false);
        Toolkit kit = this.getToolkit();
        Image icone = kit.getImage("src/Icones/relatorio.png");
        this.setIconImage(icone);
        this.parent = parent;
    }

    private void preencherComboBox() {
        empresas = dao.buscaAtributo("select distinct(nomefantasia) from Empresa order by nomefantasia");
        empresas.stream().forEach((s) -> {
            jComboBoxEmpresa.addItem(s);
        });
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
        jComboBoxEmpresa = new javax.swing.JComboBox();
        jButtonCalcular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCheckBoxPeriodo = new javax.swing.JCheckBox();
        jLabelAbertura = new javax.swing.JLabel();
        jDateChooserAbertura = new com.toedter.calendar.JDateChooser();
        jLabelFinalizada = new javax.swing.JLabel();
        jDateChooserFinalizacao = new com.toedter.calendar.JDateChooser();
        jLabelSolucaoGeral = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Índice de Solução");

        jLabel1.setText("Empresa");

        jComboBoxEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEmpresaActionPerformed(evt);
            }
        });

        jButtonCalcular.setText("Calcular");
        jButtonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jCheckBoxPeriodo.setText("Período");
        jCheckBoxPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxPeriodoActionPerformed(evt);
            }
        });

        jLabelAbertura.setText("Data Abertura");

        jLabelFinalizada.setText("Data Finalização");

        jLabelSolucaoGeral.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxPeriodo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(153, 153, 153)
                                .addComponent(jButtonCalcular))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelAbertura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooserAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabelFinalizada)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooserFinalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSolucaoGeral)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxPeriodo)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAbertura)
                    .addComponent(jLabelFinalizada)
                    .addComponent(jDateChooserFinalizacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDateChooserAbertura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonCalcular)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelSolucaoGeral)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEmpresaActionPerformed
        nome = jComboBoxEmpresa.getSelectedItem().toString();
    }//GEN-LAST:event_jComboBoxEmpresaActionPerformed

    private void jButtonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularActionPerformed
        if (nome == null) {
            nome = empresas.get(0);
        }

        periodo = jCheckBoxPeriodo.isSelected();

        if (periodo) {

            if (this.jDateChooserAbertura.getDate() != null) {
                Datedataabertura = this.jDateChooserAbertura.getDate();

            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma data de abertura!", "Data Abertura", JOptionPane.WARNING_MESSAGE);
            }

            if (this.jDateChooserFinalizacao.getDate() != null) {
                Datedatafinalizacao = this.jDateChooserFinalizacao.getDate();
            } else {
                JOptionPane.showMessageDialog(null, "Selecione uma data de finalização!", "Data Finalização", JOptionPane.WARNING_MESSAGE);
            }

            long da = jDateChooserAbertura.getDate().getTime();
            long df = jDateChooserFinalizacao.getDate().getTime();

            if (da > df) {
                JOptionPane.showMessageDialog(null, "Data de Abertura não pode "
                        + "ser maior que Data de Finalização!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            } else {
                indicegeral();
                calcularIndice();
            }
        } else {
            indicegeral();
            calcularIndice();
        }
    }//GEN-LAST:event_jButtonCalcularActionPerformed

    private void jCheckBoxPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxPeriodoActionPerformed
        jDateChooserAbertura.setVisible(true);
        jDateChooserFinalizacao.setVisible(true);
        jLabelAbertura.setVisible(true);
        jLabelFinalizada.setVisible(true);
    }//GEN-LAST:event_jCheckBoxPeriodoActionPerformed

    private void calcularIndice() {
        DAO_Relatorio dao_relatorio = new DAO_Relatorio(dao.getSessao());

        ArrayList<Long> codigosEmpresa = dao_relatorio.codigosEmpresas(nome);

        long resolvida = 0, naoavaliada = 0, naoresolvida = 0;

        if (periodo) {
            String abertura = fmt.format(Datedataabertura);
            String finalizacao = fmt.format(Datedatafinalizacao);

            for (Long codigo : codigosEmpresa) {
                resolvida += dao.codigo("select count(codigoreclamacao)"
                        + " from Reclamacao"
                        + " where empresa = " + codigo
                        + " and dataabertura between '" + abertura + "' and '" + finalizacao + "'"
                        + " and avaliacaoreclamacao='Resolvida'");
                naoavaliada += dao.codigo("select count(codigoreclamacao)"
                        + " from Reclamacao"
                        + " where empresa = " + codigo
                        + " and dataabertura between '" + abertura + "' and '" + finalizacao + "'"
                        + " and avaliacaoreclamacao='Não Avaliada'");
                naoresolvida += dao.codigo("select count(codigoreclamacao)"
                        + " from Reclamacao"
                        + " where empresa = " + codigo
                        + " and dataabertura between '" + abertura + "' and '" + finalizacao + "'"
                        + " and avaliacaoreclamacao='Não Resolvida'");
            }
        } else {
            for (Long codigo : codigosEmpresa) {
                resolvida += dao.codigo("select count(codigoreclamacao)"
                        + " from Reclamacao"
                        + " where empresa = " + codigo + " and avaliacaoreclamacao='Resolvida'");
                naoavaliada += dao.codigo("select count(codigoreclamacao)"
                        + " from Reclamacao"
                        + " where empresa = " + codigo + " and avaliacaoreclamacao='Não Avaliada'");
                naoresolvida += dao.codigo("select count(codigoreclamacao)"
                        + " from Reclamacao"
                        + " where empresa = " + codigo + " and avaliacaoreclamacao='Não Resolvida'");

            }
        }
        long finalizadaAvaliada = resolvida + naoavaliada + naoresolvida;

        if (finalizadaAvaliada != 0) {

            double indiceSolucao = (double) (((double) (resolvida + naoavaliada))
                    / (double) (finalizadaAvaliada)) * 100;

            DecimalFormat format = new DecimalFormat("#.####");

            if (indiceSolucao < indicegeral) {
                jTextArea1.setDisabledTextColor(Color.RED);
            } else {
                jTextArea1.setDisabledTextColor(Color.BLUE);
            }

            jTextArea1.setText("Empresa: " + nome
                    + "\nÍndice de Solução: " + format.format(indiceSolucao) + " %");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível o cálculo do Índice de Solução!");
        }
    }

    private void indicegeral() {
        long resolvida = 0, naoavaliada = 0, naoresolvida = 0;

        if (periodo) {
            String abertura = fmt.format(Datedataabertura);
            String finalizacao = fmt.format(Datedatafinalizacao);

            resolvida += dao.codigo("select count(codigoreclamacao)"
                    + " from Reclamacao"
                    + " where dataabertura between '" + abertura + "' and '" + finalizacao + "'"
                    + " and avaliacaoreclamacao='Resolvida'");
            naoavaliada += dao.codigo("select count(codigoreclamacao)"
                    + " from Reclamacao"
                    + " where dataabertura between '" + abertura + "' and '" + finalizacao + "'"
                    + " and avaliacaoreclamacao='Não Avaliada'");
            naoresolvida += dao.codigo("select count(codigoreclamacao)"
                    + " from Reclamacao"
                    + " where dataabertura between '" + abertura + "' and '" + finalizacao + "'"
                    + " and avaliacaoreclamacao='Não Resolvida'");
        } else {
            resolvida += dao.codigo("select count(codigoreclamacao)"
                    + " from Reclamacao"
                    + " where avaliacaoreclamacao='Resolvida'");

            naoavaliada += dao.codigo("select count(codigoreclamacao)"
                    + " from Reclamacao"
                    + " where avaliacaoreclamacao='Não Avaliada'");

            naoresolvida += dao.codigo("select count(codigoreclamacao)"
                    + " from Reclamacao"
                    + " where avaliacaoreclamacao='Não Resolvida'");
        }
        long finalizadaAvaliada = resolvida + naoavaliada + naoresolvida;
        indicegeral = (double) (((double) (resolvida + naoavaliada))
                / (double) (finalizadaAvaliada)) * 100;

        DecimalFormat format = new DecimalFormat("#.####");
        jLabelSolucaoGeral.setText("Índice de Solução Geral: " + format.format(indicegeral) + " %");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCalcular;
    private javax.swing.JCheckBox jCheckBoxPeriodo;
    private javax.swing.JComboBox jComboBoxEmpresa;
    private com.toedter.calendar.JDateChooser jDateChooserAbertura;
    private com.toedter.calendar.JDateChooser jDateChooserFinalizacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAbertura;
    private javax.swing.JLabel jLabelFinalizada;
    private javax.swing.JLabel jLabelSolucaoGeral;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
