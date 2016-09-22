/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.dao.classes;

import freelancer.entities.Projet;
import freelancer.connection.DataSource;
import freelancer.entities.Jobowner;
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
 * @author ASUS
 */
public class ProjetDAO{
   private Connection connection;
    public ProjetDAO() {
        connection = DataSource.getInstance().getConnection();
    }
  
    
    public void insertProjet(Projet p) {
        String requete =  "INSERT INTO `projet`(`titre_p`,`categorie_p`,`duree_p`,`description_p`,`owner_p`)VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, p.getTitre());
            ps.setString(2, p.getCategorie());
            ps.setString(3, p.getDuree());
            ps.setString(4, p.getDescription());
            ps.setString(5, p.getOwner());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("valider");
    }


    
    public void updateProjet(Projet p) {
            String requete = "UPDATE `projet` SET `titre_p` = ?,`categorie_p` = ?,`duree_p` = ?," +
                "`description_p` = ?,`owner_p` = ? WHERE  `id` =?;";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.setString(1, p.getTitre());
            ps.setString(2, p.getCategorie());
            ps.setString(3, p.getDuree());
            ps.setString(4, p.getDescription());
            ps.setString(5, p.getOwner());
            ps.setInt(6, p.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

   
    
    public void deleteProjet(int id) {
        String requete = "delete from projet where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Projet Supprimer");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }



    
    public List<Projet> DisplayAllProjet() {
   
        List<Projet> listprojet = new ArrayList<Projet>();

        String requete = "SELECT  `id`, `titre_p`, `categorie_p`, `duree_p`, `description_p`, `owner_p`, `pseudo_f`, `photo_p` from projet";
        try {
            Statement statement = connection .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Projet p = new Projet();
                p.setId(resultat.getInt(1));
                p.setTitre(resultat.getString(2));
                p.setCategorie(resultat.getString(3));
                p.setDuree(resultat.getString(4));
                p.setDescription(resultat.getString(5));
                p.setOwner(resultat.getString(6));
                
                listprojet.add(p);
            }
            return listprojet;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    
    
    public List<Projet> DisplayProjetParOwner(String pseudo) {
   
        List<Projet> listprojet = new ArrayList<Projet>();

        String requete = "SELECT `id`, `titre_p`, `categorie_p`, `duree_p`, `description_p`, `owner_p`, `pseudo_f`, `photo_p` from projet where owner_p='"+pseudo+"'";
        try {
            Statement statement = connection .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Projet p = new Projet();
                p.setId(resultat.getInt(1));
                p.setTitre(resultat.getString(2));
                p.setCategorie(resultat.getString(3));
                p.setDuree(resultat.getString(4));
                p.setDescription(resultat.getString(5));
                p.setOwner(resultat.getString(6));
                
                listprojet.add(p);
            }
            return listprojet;
        } catch (SQLException ex) {
            Logger.getLogger(ProjetDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    
    
    public List<Projet> DisplayProjetParFreelancer(String pseudo) {
   
        List<Projet> listprojet = new ArrayList<Projet>();

        String requete = "SELECT `id`, `titre_p`, `categorie_p`, `duree_p`, `description_p`, `owner_p`, `pseudo_f`, `photo_p` from projet where pseudo_f='"+pseudo+"'";
        try {
            Statement statement = connection .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Projet p = new Projet();
                p.setId(resultat.getInt(1));
                p.setTitre(resultat.getString(2));
                p.setCategorie(resultat.getString(3));
                p.setDuree(resultat.getString(4));
                p.setDescription(resultat.getString(5));
                p.setOwner(resultat.getString(6));
                
                listprojet.add(p);
            }
            return listprojet;
        } catch (SQLException ex) {
            Logger.getLogger(ProjetDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    
    
    public Projet GetProjetById(int id) {
   
        Projet p = new Projet();

        String requete = "SELECT `id`, `titre_p`, `categorie_p`, `duree_p`, `description_p`, `owner_p`, `pseudo_f`, `photo_p` from projet where id="+id;
        try {
            Statement statement = connection .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            if (resultat.next()) {
                
                p.setId(resultat.getInt(1));
                p.setTitre(resultat.getString(2));
                p.setCategorie(resultat.getString(3));
                p.setDuree(resultat.getString(4));
                p.setDescription(resultat.getString(5));
                p.setOwner(resultat.getString(6));
                
            }
            return p;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    
    
    public int getId(String pseudo) throws SQLException{
         String requete1 = "select id from projet where owner_p='"+pseudo+"'";
            Statement statement = connection.createStatement();
            ResultSet resultat1 = statement.executeQuery(requete1);
            resultat1.beforeFirst();
            if(resultat1.next())
                return resultat1.getInt(1);
        return 0;
    }
    
    public int getIdProjet(String titre,String categorie,String duree,String desc,String owner) throws SQLException{
         String requete1 = "select id from projet where titre_p='"+titre+"' and duree_p='"+duree+"'and"
                 + " categorie_p='"+categorie+"' and description_p='"+desc+"' and owner_p='"+owner+"'";
            Statement statement = connection.createStatement();
            ResultSet resultat1 = statement.executeQuery(requete1);
            resultat1.beforeFirst();
            if(resultat1.next())
                return resultat1.getInt(1);
        return 0;
    }
    
    
    public void updatProjet(int id, String pseudo) {
            String requete = "UPDATE `projet` SET `pseudo_f` = ? WHERE  `id` =?;";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           
            ps.setString(1, pseudo);
            ps.setInt(2,id);
            ps.executeUpdate();
            System.out.println("Affectation réussie");
        } catch (SQLException ex) {
            
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    
    public void updateProjet(Projet p,int id) {
            String requete = "UPDATE `projet` SET `titre_p` = ?,`categorie_p` = ?,`duree_p` = ?," +
                "`description_p` = ?,`owner_p` = ? WHERE  `id` =?;";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.setString(1, p.getTitre());
            ps.setString(2, p.getCategorie());
            ps.setString(3, p.getDuree());
            ps.setString(4, p.getDescription());
            ps.setString(5, p.getOwner());
            ps.setInt(6, p.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    public List<Projet> DisplayProjetParCategorie(String categorie) {
               List<Projet> listProjet = new ArrayList<Projet>();
        

        String requete = "SELECT `id`, `titre_p`, `categorie_p`, `duree_p`, `description_p`, `owner_p`, `pseudo_f`, `photo_p` from projet where categorie_p like '%"+categorie+"%'";
        try {
            Statement statement = connection .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Projet p = new Projet();
                p.setId(resultat.getInt(1));
                p.setTitre(resultat.getString(2));
                p.setCategorie(resultat.getString(3));
                p.setDuree(resultat.getString(4));
                p.setDescription(resultat.getString(5));
                p.setOwner(resultat.getString(6));
                listProjet.add(p);
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
        return listProjet;
    }
    
}
