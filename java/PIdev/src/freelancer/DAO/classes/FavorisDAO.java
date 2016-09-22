/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.dao.classes;

import freelancer.entities.Favoris;
import freelancer.entities.Membre;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import freelancer.connection.DataSource;
import freelancer.entities.Projet;
import java.sql.ResultSet;
/**
 *
 * @author Amine
 */
public class FavorisDAO{
  private Connection connection;

    public FavorisDAO() {
        connection = DataSource.getInstance().getConnection();
        
    }

    
    public void insertFavorit(Favoris fav) {
        String requete = "INSERT INTO `favoris`(`id_f`, `id_p`) VALUES(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
             ps.setInt(1, fav.getId_f());
            ps.setInt(2, fav.getId_p());
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(FavorisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("valider");
    }


    
    public void deleteFavorit(int id_f, int id_p) {
        String requete = "delete from favoris where ((id_f="+id_f+")and(id_p="+id_p+"))";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.executeUpdate();
            System.out.println("FAVORIS Suprime");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

   
    
    public List<Projet> DisplayFavorit(int id_f) {

        List<Projet> listfavorit = new ArrayList<Projet>();

        String requete = "select (titre_p,categorie_p,duree_p,description_p) "
                + "from favoris f,projet p where f.id_p=p.id AND id_f="+id_f;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Projet pro = new Projet();
                pro.setTitre(resultat.getString(1));
                pro.setCategorie(resultat.getString(2));
                pro.setDuree(resultat.getString(3));
                pro.setDescription(resultat.getString(4));
               
                listfavorit.add(pro);
                
            }
            return listfavorit;
         } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    
    public List<Projet> DisplayAllProjetByPseudo(String pseudo) {
   
        List<Projet> listprojet = new ArrayList<Projet>();
        String requete = "SELECT * from projet p,favoris f,membre m where "
                + "m.id=f.id_f AND f.id_p=p.id and m.pseudo ='"+pseudo+"'";
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
    
}
