/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.dao.classes;

import freelancer.entities.Membre;
import freelancer.entities.Reclamation;
import freelancer.connection.DataSource;
import freelancer.entities.Messagerie;
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
public class MessagerieDAO{
  private Connection connection;

    public MessagerieDAO() {
        connection = DataSource.getInstance().getConnection();
    }

    
    
    public void envoyerMessage(Messagerie msg) {
        
        String requete = "INSERT INTO `messagerie`VALUES"
                + " (NULL,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, msg.getExpediteur());
             ps.setString(2, msg.getRecepteur());
            ps.setDate(3, (Date) msg.getDate());
            ps.setString(4, msg.getSujet());
             ps.setString(5, msg.getMsg());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessagerieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("valider");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public List<Messagerie> DisplayMessageries(String pseudo) {
        List<Messagerie> listMessagerie = new ArrayList<Messagerie>();

        String requete = "select * from messagerie where expediteur='"+pseudo+"' or recepteur='"+pseudo+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Messagerie msg = new Messagerie();
                msg.setId(resultat.getInt(1));
                msg.setExpediteur(resultat.getString(2));
                msg.setRecepteur(resultat.getString(3));
                msg.setDate(resultat.getDate(4));
                msg.setSujet(resultat.getString(5));
                msg.setMsg(resultat.getString(6));
                listMessagerie.add(msg);
                
            }
            return listMessagerie;
         } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des reclamation " + ex.getMessage());
            return null;
        }
    }
public void deleteMessage(int id) {
        String requete = "delete from messagerie where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Message Suprime");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }





   
    

   
    

}
