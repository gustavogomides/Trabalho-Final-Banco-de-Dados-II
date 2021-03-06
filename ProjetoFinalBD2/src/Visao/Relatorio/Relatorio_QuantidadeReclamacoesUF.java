/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Relatorio;

import Controle.ControleRelatorio;
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
import java.awt.Color;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Gustavo
 */
public class Relatorio_QuantidadeReclamacoesUF extends javax.swing.JDialog {

    private GeneralDAO dao;
    private ControleRelatorio controleRelatorio;
    private DefaultCategoryDataset dataset;
    private JFreeChart chart;
    private Frame parent;

    /**
     * Creates new form UF
     */
    public Relatorio_QuantidadeReclamacoesUF(java.awt.Frame parent, boolean modal, GeneralDAO dao) {
        super(parent, modal);
        initComponents();
        this.dao = dao;
        controleRelatorio = new ControleRelatorio(dao);
        this.parent = parent;
        jButton2.setEnabled(false);
        Toolkit kit = this.getToolkit();
        java.awt.Image icone = kit.getImage("src/Icones/relatorio.png");
        this.setIconImage(icone);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quantidade de Reclamações por Estado");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Gráfico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Gerar PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addGap(55, 55, 55)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dataset = controleRelatorio.numeroReclamacoesEstadoGrafico();
        chart = ChartFactory.createBarChart3D("Quantidade de Reclamações por Estado",
                "Estado", "Quantidade",
                dataset, PlotOrientation.HORIZONTAL, true, true, true);
        chart.setBackgroundPaint(Color.WHITE);

        Grafico_QuantidadeReclamacoesUF dialog = null;
        dialog = new Grafico_QuantidadeReclamacoesUF(parent, true, dao, chart);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            Date hoje = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String data = dateFormat.format(hoje);
            create(new FileOutputStream(
                    new File("src\\PDF\\Estado\\Quantidade de Reclamações por Estado_" + data + ".pdf")), chart);
            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!\n\n"
                    + "Salvo em: PDF\\Estado\\Quantidade de Reclamações por Estado_" + data + ".pdf");
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(Relatorio_QuantidadeReclamacoesUF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public void create(OutputStream outputStream, JFreeChart chart) throws DocumentException, IOException {
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

            //add image
            int width = 500;
            int height = 400;

            BufferedImage bufferedImage = chart.createBufferedImage(width, height);
            Image image = Image.getInstance(writer, bufferedImage, 1.0f);
            document.add(image);

            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            String quebralinha = "\n\nQuantidade de reclamações por UF\n\n";
            Paragraph preface = new Paragraph(quebralinha, boldFont);
            preface.setAlignment(Element.ALIGN_CENTER);
            document.add(preface);

            PdfPTable table = new PdfPTable(2);

            PdfPCell pdfWordCell = new PdfPCell();
            PdfPCell pdfWordCell1 = new PdfPCell();
            Phrase firstLine = new Phrase("UF", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
            Phrase secondLine = new Phrase("Quantidade", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));

            pdfWordCell.addElement(firstLine);
            pdfWordCell1.addElement(secondLine);

            table.addCell(pdfWordCell);
            table.addCell(pdfWordCell1);

            String consulta = "Select uf, count(codigoreclamacao) from "
                    + "Reclamacao group by (uf) order by count(codigoreclamacao) desc";

            Iterator i = dao.getSessao().createSQLQuery(consulta).list().iterator();

            while (i.hasNext()) {
                Object[] reclamacao = (Object[]) i.next();
                table.addCell(reclamacao[0].toString());
                table.addCell(reclamacao[1].toString());
            }

            document.add(table);

            //release resources
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
