/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.connection.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ASUS
 */
public class BarChart3 extends javax.swing.JFrame {
 private Connection connection;
    int tunisie,france,italie,amerique,canada;
    /**
     * Creates new form BarChart3
     */
    public BarChart3() {
       setSize(800,600);
    setResizable(false);
        final CategoryDataset dataset = createDataset();
        final JFreeChart graphe = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(graphe);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        setContentPane(chartPanel);this.setLocationRelativeTo(null);
    }
public CategoryDataset createDataset() {
        // 0. Création d'un diagramme.
   
    connection = DataSource.getInstance().getConnection();
          String requete = "SELECT COUNT(pays) FROM membre where pays='tunisie'";
         String requete1 = "SELECT COUNT(pays) FROM membre where pays='france'";
          String requete2 = "SELECT COUNT(pays) FROM membre where pays='amerique'";
             String requete3 = "SELECT COUNT(pays) FROM membre where pays='canada'";
          String requete4 = "SELECT COUNT(pays) FROM membre where pays='italie'";
             try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
           while ((resultat.next())) {tunisie=resultat.getInt(1);
             }} catch (SQLException ex) {System.out.println("erreur lors du chargement des depots " + ex.getMessage());}
             try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat1 = statement.executeQuery(requete1);
           while ((resultat1.next())) {france=resultat1.getInt(1);
             }} catch (SQLException ex) {System.out.println("erreur lors du chargement des depots " + ex.getMessage());}
             try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat2 = statement.executeQuery(requete2);
           while ((resultat2.next())) {amerique=resultat2.getInt(1);
             }} catch (SQLException ex) {System.out.println("erreur lors du chargement des depots " + ex.getMessage());}
             try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat3 = statement.executeQuery(requete3);
           while ((resultat3.next())) {canada=resultat3.getInt(1);
             }} catch (SQLException ex) {System.out.println("erreur lors du chargement des depots " + ex.getMessage());}
             try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat4 = statement.executeQuery(requete4);
           while ((resultat4.next())) {italie=resultat4.getInt(1);
             }} catch (SQLException ex) {System.out.println("erreur lors du chargement des depots " + ex.getMessage());} 
    
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       //Valeurs statiques
        dataset.addValue(tunisie, "Tunisie", " ");
        dataset.addValue(france, " France", " ");
        dataset.addValue(italie, "Italie", " ");
        dataset.addValue(amerique, "Amerique", " ");
         dataset.addValue(canada, "Canada", " ");
       return dataset;
    }
public JFreeChart createChart(CategoryDataset dataset) {
        final JFreeChart chart = ChartFactory.createBarChart3D(
                " le taux d'inscription par pays ", // chart title
                " ", // domain axis label
                "  le nombre d'inscription par pays ", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                true // urls
                );

 final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 2.0));
        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setItemLabelsVisible(true); 
        return chart;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BarChart3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarChart3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarChart3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarChart3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                 BarChart3 chart = new   BarChart3();
        chart.pack();
        chart.setVisible(true);
        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
