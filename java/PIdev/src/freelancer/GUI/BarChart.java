package freelancer.GUI;

import freelancer.connection.DataSource;
import java.io.IOException;
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
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;



public class BarChart extends ApplicationFrame {
    private Connection connection;
    int tunisie,france,italie,amerique,canada;
    public BarChart(final String title) throws IOException {
        super(title);
         setSize(800,600);
    setResizable(false);this.setLocationRelativeTo(null);
        final CategoryDataset dataset = createDataset();
        final JFreeChart graphe = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(graphe);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        setContentPane(chartPanel);
         
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
    public static void main(final String[] args) throws IOException {
        final BarChart demo = new BarChart("Test de la couverture ");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }
}
