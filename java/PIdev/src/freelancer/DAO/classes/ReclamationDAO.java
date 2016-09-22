/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.dao.classes;

import freelancer.entities.Membre;
import freelancer.entities.Reclamation;
import freelancer.connection.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mariem
 */
public class ReclamationDAO{
  private Connection connection;

    public ReclamationDAO() {
        connection = DataSource.getInstance().getConnection();
        
    }
 
    
    public void insertReclamation(Reclamation rec) {
        
        String requete = "INSERT INTO `reclamation`VALUES"
                + " (NULL,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, rec.getExpediteur());
            ps.setDate(2, (Date) rec.getDate());
            ps.setString(3, rec.getSujet());
            ps.setString(4, rec.getMessage());
            
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("valider");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    public List<Reclamation> DisplayAllReclamations() {
        List<Reclamation> listReclamation = new ArrayList<Reclamation>();

        String requete = "select * from reclamation";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Reclamation rec = new Reclamation();
                rec.setId(resultat.getInt(1));
                rec.setExpediteur(resultat.getString(2));
                rec.setDate(resultat.getDate(3));
                rec.setSujet(resultat.getString(4));
                rec.setMessage(resultat.getString(5));
                
                listReclamation.add(rec);
                
            }
            return listReclamation;
         } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des reclamation " + ex.getMessage());
            return null;
        }
    }
public void deleteReclamation(int id) {
        String requete = "delete from Reclamation where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Reclamation Suprime");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }


    
    

}
