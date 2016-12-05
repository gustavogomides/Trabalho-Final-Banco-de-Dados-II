/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Relatorio;

import DAO.DAO_Relatorio;
import DAO.GeneralDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo
 */
public class Relatorio_Geral extends javax.swing.JDialog {

    /**
     * Creates new form Relatorio_Geral
     */
    private GeneralDAO dao;
    private long quantidadeReclamacao, quantidadeEmpresa, quantidadeRegiao, quantidadeUF, quantidadeCidade;
    private double notamedia, resolvidaPorcentagem, naoresolvidaPorcentagem, naoavaliadaPorcentagem, tempoMedio;
    private long resolvida, naoresolvida, naoavaliada;
    private DecimalFormat decimalFormat = new DecimalFormat("#.###");

    public Relatorio_Geral(java.awt.Frame parent, boolean modal, GeneralDAO dao) {
        super(parent, modal);
        initComponents();
        this.dao = dao;
        preencher();
        Toolkit kit = this.getToolkit();
        java.awt.Image icone = kit.getImage("src/Icones/relatorio.png");
        this.setIconImage(icone);
    }

    private void preencher() {
        quantidadeReclamacao = dao.codigo("select count(codigoreclamacao) from Reclamacao");
        jTextFieldQuantidadeReclamacoes.setText(
                String.valueOf(quantidadeReclamacao));
        jTextFieldQuantidadeReclamacoes.setHorizontalAlignment(JTextField.CENTER);

        quantidadeEmpresa = dao.codigo("select count(codigoempresa) from Empresa");
        jTextFieldQuantidadeEmpresas.setText(
                String.valueOf(quantidadeEmpresa));
        jTextFieldQuantidadeEmpresas.setHorizontalAlignment(JTextField.CENTER);

        List<String> regiao = dao.buscaAtributo("select distinct(regiao) from Reclamacao");
        quantidadeRegiao = regiao.size();
        jTextFieldQuantidadeRegiao.setText(
                String.valueOf(quantidadeRegiao));
        jTextFieldQuantidadeRegiao.setHorizontalAlignment(JTextField.CENTER);

        List<String> uf = dao.buscaAtributo("select distinct(uf) from Reclamacao");
        quantidadeUF = uf.size();
        jTextFieldQuantidadeUF.setText(
                String.valueOf(quantidadeUF));
        jTextFieldQuantidadeUF.setHorizontalAlignment(JTextField.CENTER);

        List<String> cidades = dao.buscaAtributo("select distinct(cidade) from Reclamacao");
        quantidadeCidade = cidades.size();
        jTextFieldQuantidadeCidades.setText(
                String.valueOf(quantidadeCidade));
        jTextFieldQuantidadeCidades.setHorizontalAlignment(JTextField.CENTER);

        DAO_Relatorio dao_relatorio = new DAO_Relatorio(dao.getSessao());

        tempoMedio = dao_relatorio.funcaoAgregacaoDouble("select avg(temporesposta) from Reclamacao");
        jTextFieldTempoMedioResposta.setText(
                decimalFormat.format(tempoMedio) + " dias");
        jTextFieldTempoMedioResposta.setHorizontalAlignment(JTextField.CENTER);

        notamedia = dao_relatorio.funcaoAgregacaoDouble("select avg(notaconsumidor) from Reclamacao");
        jTextFieldNotaMedia.setText(
                decimalFormat.format(notamedia));
        jTextFieldNotaMedia.setHorizontalAlignment(JTextField.CENTER);

        resolvida = dao.codigo("select count(codigoreclamacao) from "
                + "Reclamacao where avaliacaoreclamacao='Resolvida'");
        resolvidaPorcentagem = (100 * resolvida) / quantidadeReclamacao;

        naoresolvida = dao.codigo("select count(codigoreclamacao) from "
                + "Reclamacao where avaliacaoreclamacao='Não Resolvida'");
        naoresolvidaPorcentagem = (100 * naoresolvida) / quantidadeReclamacao;

        naoavaliada = quantidadeReclamacao - (resolvida + naoresolvida);
        naoavaliadaPorcentagem = (100 * naoavaliada) / quantidadeReclamacao;

        if (resolvidaPorcentagem + naoresolvidaPorcentagem + naoavaliadaPorcentagem != 100) {
            naoresolvidaPorcentagem += 100 - (resolvidaPorcentagem + naoresolvidaPorcentagem + naoavaliadaPorcentagem);
        }

        jTextFieldReclamacoesResolvidas.setText(resolvida + " - " + resolvidaPorcentagem + "%");
        jTextFieldReclamacoesNãoResolvidas.setText(naoresolvida + " - " + naoresolvidaPorcentagem + "%");
        jTextFieldReclamacoesNãoAvaliadas.setText(naoavaliada + " - " + naoavaliadaPorcentagem + "%");
        jTextFieldReclamacoesResolvidas.setHorizontalAlignment(JTextField.CENTER);
        jTextFieldReclamacoesNãoResolvidas.setHorizontalAlignment(JTextField.CENTER);
        jTextFieldReclamacoesNãoAvaliadas.setHorizontalAlignment(JTextField.CENTER);

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
        jTextFieldQuantidadeReclamacoes = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldQuantidadeEmpresas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldQuantidadeCidades = new javax.swing.JTextField();
        jTextFieldTempoMedioResposta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNotaMedia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldReclamacoesResolvidas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldReclamacoesNãoResolvidas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldReclamacoesNãoAvaliadas = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldQuantidadeUF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldQuantidadeRegiao = new javax.swing.JTextField();
        jButtonGerarPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório Geral");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Quantidade de Reclamaçãoes Cadastradas:");

        jTextFieldQuantidadeReclamacoes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldQuantidadeReclamacoes.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldQuantidadeReclamacoes.setEnabled(false);
        jTextFieldQuantidadeReclamacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantidadeReclamacoesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Quantidade de Empresas Cadastradas:");

        jTextFieldQuantidadeEmpresas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldQuantidadeEmpresas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldQuantidadeEmpresas.setEnabled(false);
        jTextFieldQuantidadeEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantidadeEmpresasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Quantidade de Cidades Cadastradas:");

        jTextFieldQuantidadeCidades.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldQuantidadeCidades.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldQuantidadeCidades.setEnabled(false);
        jTextFieldQuantidadeCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantidadeCidadesActionPerformed(evt);
            }
        });

        jTextFieldTempoMedioResposta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldTempoMedioResposta.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldTempoMedioResposta.setEnabled(false);
        jTextFieldTempoMedioResposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTempoMedioRespostaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tempo Médio de Resposta:");

        jTextFieldNotaMedia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldNotaMedia.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldNotaMedia.setEnabled(false);
        jTextFieldNotaMedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNotaMediaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Nota média:");

        jTextFieldReclamacoesResolvidas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldReclamacoesResolvidas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldReclamacoesResolvidas.setEnabled(false);
        jTextFieldReclamacoesResolvidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldReclamacoesResolvidasActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Quantidade de Reclamações Resolvidas:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Quantidade de Reclamações Não Resolvidas:");

        jTextFieldReclamacoesNãoResolvidas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldReclamacoesNãoResolvidas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldReclamacoesNãoResolvidas.setEnabled(false);
        jTextFieldReclamacoesNãoResolvidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldReclamacoesNãoResolvidasActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Quantidade de Reclamações Não Avaliadas:");

        jTextFieldReclamacoesNãoAvaliadas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldReclamacoesNãoAvaliadas.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldReclamacoesNãoAvaliadas.setEnabled(false);
        jTextFieldReclamacoesNãoAvaliadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldReclamacoesNãoAvaliadasActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Quantidade de UFs Cadastrados:");

        jTextFieldQuantidadeUF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldQuantidadeUF.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldQuantidadeUF.setEnabled(false);
        jTextFieldQuantidadeUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantidadeUFActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Quantidade de Regiões Cadastradas:");

        jTextFieldQuantidadeRegiao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextFieldQuantidadeRegiao.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextFieldQuantidadeRegiao.setEnabled(false);
        jTextFieldQuantidadeRegiao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantidadeRegiaoActionPerformed(evt);
            }
        });

        jButtonGerarPDF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGerarPDF.setText("Gerar PDF");
        jButtonGerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jTextFieldQuantidadeReclamacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQuantidadeEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldReclamacoesResolvidas, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldReclamacoesNãoResolvidas, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldReclamacoesNãoAvaliadas, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTempoMedioResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQuantidadeUF, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNotaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQuantidadeRegiao, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQuantidadeCidades, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jButtonGerarPDF)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextFieldNotaMedia, jTextFieldQuantidadeCidades, jTextFieldQuantidadeEmpresas, jTextFieldQuantidadeReclamacoes, jTextFieldQuantidadeRegiao, jTextFieldQuantidadeUF, jTextFieldReclamacoesNãoAvaliadas, jTextFieldReclamacoesNãoResolvidas, jTextFieldReclamacoesResolvidas, jTextFieldTempoMedioResposta});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jTextFieldQuantidadeReclamacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuantidadeEmpresas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuantidadeRegiao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuantidadeUF, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldQuantidadeCidades, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTempoMedioResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNotaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldReclamacoesResolvidas, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldReclamacoesNãoResolvidas, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldReclamacoesNãoAvaliadas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jButtonGerarPDF)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextFieldNotaMedia, jTextFieldQuantidadeCidades, jTextFieldQuantidadeEmpresas, jTextFieldQuantidadeReclamacoes, jTextFieldQuantidadeRegiao, jTextFieldQuantidadeUF, jTextFieldReclamacoesNãoAvaliadas, jTextFieldReclamacoesNãoResolvidas, jTextFieldReclamacoesResolvidas, jTextFieldTempoMedioResposta});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldQuantidadeReclamacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeReclamacoesActionPerformed

    }//GEN-LAST:event_jTextFieldQuantidadeReclamacoesActionPerformed

    private void jTextFieldQuantidadeEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeEmpresasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQuantidadeEmpresasActionPerformed

    private void jTextFieldQuantidadeCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeCidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQuantidadeCidadesActionPerformed

    private void jTextFieldTempoMedioRespostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTempoMedioRespostaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTempoMedioRespostaActionPerformed

    private void jTextFieldNotaMediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNotaMediaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNotaMediaActionPerformed

    private void jTextFieldReclamacoesResolvidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldReclamacoesResolvidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldReclamacoesResolvidasActionPerformed

    private void jTextFieldReclamacoesNãoResolvidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldReclamacoesNãoResolvidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldReclamacoesNãoResolvidasActionPerformed

    private void jTextFieldReclamacoesNãoAvaliadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldReclamacoesNãoAvaliadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldReclamacoesNãoAvaliadasActionPerformed

    private void jTextFieldQuantidadeUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQuantidadeUFActionPerformed

    private void jTextFieldQuantidadeRegiaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuantidadeRegiaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQuantidadeRegiaoActionPerformed

    private void jButtonGerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarPDFActionPerformed
        try {
            Date hoje = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String data = dateFormat.format(hoje);
            String file = "src\\PDF\\Geral\\Relatório Geral_" + data + ".pdf";
            
            create(new FileOutputStream(
                    new File(file)));
            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!\n\n"
                    + "Salvo em: PDF\\Geral");
        } catch (IOException | DocumentException ex) {
            JOptionPane.showMessageDialog(null, "ERRO! PDF não foi gerado!");
            Logger.getLogger(Relatorio_QuantidadeReclamacoesUF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonGerarPDFActionPerformed

    public void create(OutputStream outputStream) throws DocumentException, IOException {
        Document document = null;
        PdfWriter writer = null;

        try {
            //instantiate document and writer
            document = new Document();
            writer = PdfWriter.getInstance(document, outputStream);

            //open document
            document.open();
            Image img = Image.getInstance("src\\Imagens\\logo.png");
            img.setAlignment(Element.ALIGN_CENTER);
            document.add(img);

            Paragraph paragraph = new Paragraph("\n\nRelatório Geral\n\n", new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD));
            paragraph.setAlignment(Element.ALIGN_CENTER);
            document.add(paragraph);

            document.add(new Paragraph("Quantidade de Reclamaçãoes Cadastradas: " + quantidadeReclamacao + "\n", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
            document.add(new Paragraph("Quantidade de Empresas Cadastradas: " + quantidadeEmpresa + "\n", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
            document.add(new Paragraph("Quantidade de Regiões Cadastradas: " + quantidadeRegiao + "\n", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
            document.add(new Paragraph("Quantidade de UFs Cadastrados: " + quantidadeUF + "\n", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
            document.add(new Paragraph("Quantidade de Cidades Cadastradas: " + quantidadeCidade + "\n", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
            document.add(new Paragraph("Tempo Médio de Resposta: " + decimalFormat.format(tempoMedio) + "\n", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
            document.add(new Paragraph("Nota Média: " + decimalFormat.format(notamedia) + "\n", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
            document.add(new Paragraph("Quantidade de Reclamações Resolvidas: " + resolvida + " - " + resolvidaPorcentagem + "%\n", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
            document.add(new Paragraph("Quantidade de Reclamações Não Resolvidas: " + naoresolvida + " - " + naoresolvidaPorcentagem + "%\n", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
            document.add(new Paragraph("Quantidade de Reclamações Não Avaliadas: " + naoavaliada + " - " + naoavaliadaPorcentagem + "%\n", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
            document.close();
            document = null;

            writer.close();
            writer = null;
        } catch (DocumentException | IOException de) {
            throw de;
        } finally {
            //release resources
            if (null != document) {
                try {
                    document.close();
                } catch (Exception ex) {
                }
            }

            if (null != writer) {
                try {
                    writer.close();
                } catch (Exception ex) {
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGerarPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldNotaMedia;
    private javax.swing.JTextField jTextFieldQuantidadeCidades;
    private javax.swing.JTextField jTextFieldQuantidadeEmpresas;
    private javax.swing.JTextField jTextFieldQuantidadeReclamacoes;
    private javax.swing.JTextField jTextFieldQuantidadeRegiao;
    private javax.swing.JTextField jTextFieldQuantidadeUF;
    private javax.swing.JTextField jTextFieldReclamacoesNãoAvaliadas;
    private javax.swing.JTextField jTextFieldReclamacoesNãoResolvidas;
    private javax.swing.JTextField jTextFieldReclamacoesResolvidas;
    private javax.swing.JTextField jTextFieldTempoMedioResposta;
    // End of variables declaration//GEN-END:variables
}
