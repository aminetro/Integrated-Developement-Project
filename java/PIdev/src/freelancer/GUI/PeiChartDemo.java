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
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import static sun.misc.ClassFileTransformer.add;


/**
 *
 * @author ASUS
 */
public class PeiChartDemo extends JFrame {
    DefaultPieDataset dataset;
    JFreeChart graphe;
    ChartPanel panel;
    int Java,C,photoshop,web,phyton;
    private Connection connection;
    public PeiChartDemo() {
         setSize(800,600);
    setResizable(false);
        connection = DataSource.getInstance().getConnection();
          String requete = "SELECT COUNT(categorie_p) FROM projet where categorie_p='java'";
         String requete1 = "SELECT COUNT(categorie_p) FROM projet where categorie_p='C#'";
          String requete2 = "SELECT COUNT(categorie_p) FROM projet where categorie_p='photoshop'";
             String requete3 = "SELECT COUNT(categorie_p) FROM projet where categorie_p='web'";
          String requete4 = "SELECT COUNT(categorie_p) FROM projet where categorie_p='phyton'";
             try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
           while ((resultat.next())) {Java=resultat.getInt(1);
             }} catch (SQLException ex) {System.out.println("erreur lors du chargement des depots " + ex.getMessage());}
             try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat1 = statement.executeQuery(requete1);
           while ((resultat1.next())) {C=resultat1.getInt(1);
             }} catch (SQLException ex) {System.out.println("erreur lors du chargement des depots " + ex.getMessage());}
             try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat2 = statement.executeQuery(requete2);
           while ((resultat2.next())) {photoshop=resultat2.getInt(1);
             }} catch (SQLException ex) {System.out.println("erreur lors du chargement des depots " + ex.getMessage());}
             try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat3 = statement.executeQuery(requete3);
           while ((resultat3.next())) {web=resultat3.getInt(1);
             }} catch (SQLException ex) {System.out.println("erreur lors du chargement des depots " + ex.getMessage());}
             try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat4 = statement.executeQuery(requete4);
           while ((resultat4.next())) {phyton=resultat4.getInt(1);
             }} catch (SQLException ex) {System.out.println("erreur lors du chargement des depots " + ex.getMessage());} 
        dataset= new DefaultPieDataset();
dataset.setValue("java", new Double(Java));
dataset.setValue("C#", new Double(C));
dataset.setValue("Photoshop", new Double(photoshop));
dataset.setValue("web", new Double(web));
dataset.setValue("Phyton", new Double(phyton));
graphe=ChartFactory.createPieChart3D("pourcentage des modules",dataset,true, true,true );
panel=new ChartPanel(graphe);
add(panel);
}
    
    

public static void main(String[] args) {
PeiChartDemo framePeichanel=new PeiChartDemo ();
framePeichanel.pack();

framePeichanel.setVisible(true);


}
}