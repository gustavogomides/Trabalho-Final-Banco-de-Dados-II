/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Relatorio;

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
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Gustavo
 */
public class GraficoPerCapta extends javax.swing.JDialog {

    private GeneralDAO dao;
    private Frame parent;
    private List<String> estados = new ArrayList<>();
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Dimension screenSize = kit.getScreenSize();
    private JFreeChart barChart;

    /**
     * Creates new form GraficoPerCapta
     */
    public GraficoPerCapta(java.awt.Frame parent, boolean modal, GeneralDAO dao) {
        super(parent, modal);
        initComponents();
        this.dao = dao;
        this.parent = parent;
        grafico();

        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        this.setSize(screenWidth, screenHeight - 100);
    }

    private void grafico() {
        estados = dao.buscaAtributo("select distinct(uf) from Reclamacao order by uf");
        ArrayList<Double> indices = new ArrayList<>();

        for (String estado : estados) {
            long quantidadeReclamacao = dao.codigo("select count(codigoreclamacao)"
                    + " from Reclamacao where uf='" + estado + "'");
            int pop = populacao(estado);
            double porestado = (double) ((double) (quantidadeReclamacao) / (double) (pop));
            indices.add(porestado);
        }

        plotarGrafico("Indíce de Reclamação Per Capta dos Estados", indices);

    }

    public void plotarGrafico(String chartTitle, ArrayList<Double> indices) {
        barChart = ChartFactory.createBarChart3D(
                chartTitle,
                "Estado",
                "Índice de Reclamação",
                createDataset(indices),
                PlotOrientation.VERTICAL,
                true, true, false);

        barChart.setBackgroundPaint(Color.WHITE);

        CategoryPlot p = barChart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLUE);

        ChartPanel panel = new ChartPanel(barChart);
        panel.setVisible(true);
        panel.setSize(screenSize.width - 210, screenSize.height - 140);
        this.add(panel);
    }

    private CategoryDataset createDataset(ArrayList<Double> indices) {

        final DefaultCategoryDataset dataset
                = new DefaultCategoryDataset();

        for (int i = 0; i < indices.size(); i++) {
            dataset.addValue(indices.get(i), estados.get(i), estados.get(i));
        }

        return dataset;
    }

    private int populacao(String estado) {
        int populacao = 0;
        switch (estado) {
            case "SP":
                populacao = 44396484;
                break;
            case "MG":
                populacao = 20869101;
                break;
            case "RJ":
                populacao = 16550024;
                break;
            case "BA":
                populacao = 15203934;
                break;
            case "RS":
                populacao = 11247972;
                break;
            case "PR":
                populacao = 11163018;
                break;
            case "PE":
                populacao = 9345173;
                break;
            case "CE":
                populacao = 8904459;
                break;
            case "PA":
                populacao = 8175113;
                break;
            case "MA":
                populacao = 6904241;
                break;
            case "SC":
                populacao = 6819190;
                break;
            case "GO":
                populacao = 6610681;
                break;
            case "PB":
                populacao = 3972202;
                break;
            case "AM":
                populacao = 3938336;
                break;
            case "ES":
                populacao = 3929911;
                break;
            case "RN":
                populacao = 3442175;
                break;
            case "AL":
                populacao = 3340932;
                break;
            case "MT":
                populacao = 3270973;
                break;
            case "PI":
                populacao = 3204028;
                break;
            case "DF":
                populacao = 2914830;
                break;
            case "MS":
                populacao = 2651235;
                break;
            case "SE":
                populacao = 2242937;
                break;
            case "RO":
                populacao = 1768204;
                break;
            case "TO":
                populacao = 1515126;
                break;
            case "AC":
                populacao = 803513;
                break;
            case "AP":
                populacao = 803513;
                break;
            case "RR":
                populacao = 505665;
                break;

        }
        return populacao;
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
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButtonPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Indíce de Reclamação Per Capta dos Estados");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("SP\t44 396 484\nMG\t20 869 101\nRJ\t16 550 024\nBA\t15 203 934\nRS\t11 247 972\nPR\t11 163 018\nPE\t9 345 173\nCE\t8 904 459\nPA\t8 175 113\nMA\t6 904 241\nSC\t6 819 190\nGO\t6 610 681\nPB\t3 972 202\nAM\t3 938 336\nES\t3 929 911\nRN\t3 442 175\nAL\t3 340 932\nMS\t3 270 973\nPI\t3 204 028\nDF\t2 914 830\nMS\t2 651 235\nSE\t2 242 937\nRO\t1 768 204\nTO\t1 515 126\nAC\t803 513\nAP\t766 679\nRR\t505 665");
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("População dos Estados ");

        jButtonPDF.setText("Gerar PDF");
        jButtonPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 213, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonPDF)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPDF))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPDFActionPerformed

        try {
            Date hoje = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String data = dateFormat.format(hoje);
            create(new FileOutputStream(
                    new File("src\\PDF\\Índice Per Capta\\Índice_" + data + ".pdf")), barChart);
            JOptionPane.showMessageDialog(null, "PDF gerado com sucesso!\n\n"
                    + "Salvo em: PDF\\Índice Per Capta\\Índice_" + data + ".pdf");
        } catch (IOException | DocumentException ex) {
            Logger.getLogger(Relatorio_QuantidadeReclamacoesUF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonPDFActionPerformed

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
            String quebralinha = "\n\nPopulação dos Estados\n\n";
            Paragraph preface = new Paragraph(quebralinha, boldFont);
            preface.setAlignment(Element.ALIGN_CENTER);
            document.add(preface);

            PdfPTable table = new PdfPTable(2);

            PdfPCell pdfWordCell = new PdfPCell();
            PdfPCell pdfWordCell1 = new PdfPCell();
            Phrase firstLine = new Phrase("UF", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));
            Phrase secondLine = new Phrase("População", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD));

            pdfWordCell.addElement(firstLine);
            pdfWordCell1.addElement(secondLine);

            table.addCell(pdfWordCell);
            table.addCell(pdfWordCell1);

            table.addCell("SP");
            table.addCell(String.valueOf(44396484));

            table.addCell("MG");
            table.addCell(String.valueOf(20869101));

            table.addCell("RJ");
            table.addCell(String.valueOf(16550024));

            table.addCell("BA");
            table.addCell(String.valueOf(15203934));

            table.addCell("RS");
            table.addCell(String.valueOf(11247972));

            table.addCell("PR");
            table.addCell(String.valueOf(11163018));

            table.addCell("PE");
            table.addCell(String.valueOf(9345173));

            table.addCell("CE");
            table.addCell(String.valueOf(8904459));

            table.addCell("PA");
            table.addCell(String.valueOf(8175113));

            table.addCell("MA");
            table.addCell(String.valueOf(6904241));

            table.addCell("SC");
            table.addCell(String.valueOf(6819190));

            table.addCell("GO");
            table.addCell(String.valueOf(6610681));

            table.addCell("PB");
            table.addCell(String.valueOf(3972202));

            table.addCell("AM");
            table.addCell(String.valueOf(3938336));

            table.addCell("ES");
            table.addCell(String.valueOf(3929911));

            table.addCell("RN");
            table.addCell(String.valueOf(3442175));

            table.addCell("AL");
            table.addCell(String.valueOf(3340932));

            table.addCell("MT");
            table.addCell(String.valueOf(3270973));

            table.addCell("PI");
            table.addCell(String.valueOf(3204028));

            table.addCell("DF");
            table.addCell(String.valueOf(2914830));

            table.addCell("MS");
            table.addCell(String.valueOf(2651235));

            table.addCell("SE");
            table.addCell(String.valueOf(2242937));

            table.addCell("RO");
            table.addCell(String.valueOf(1768204));

            table.addCell("TO");
            table.addCell(String.valueOf(1515126));

            table.addCell("AC");
            table.addCell(String.valueOf(803513));

            table.addCell("AP");
            table.addCell(String.valueOf(766679));

            table.addCell("RR");
            table.addCell(String.valueOf(505665));

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
    private javax.swing.JButton jButtonPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
