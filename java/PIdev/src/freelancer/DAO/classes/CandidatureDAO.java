/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.dao.classes;

import freelancer.entities.Candidature;
import freelancer.entities.CvFreelancer;
import freelancer.connection.DataSource;
import java.sql.Connection;
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
 * @author hp
 */
public class CandidatureDAO {
    private final Connection connection;

    public CandidatureDAO() {
        connection = DataSource.getInstance().getConnection();
        
    }
    
     

        public void insertCandidature(Candidature ca) {
        String requete =  "INSERT INTO `candidature`(`id_p`,`pseufreelancer`,`estimation`, `lettre_mot`, `question`)"
                + "VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps;
            ps = connection.prepareStatement(requete);
            
            ps.setInt(1, ca.getId_p());
            ps.setString(2, ca.getPseufreelancer());
            ps.setString(3, ca.getEstimation());
            ps.setString(4, ca.getLettre_mot());
            ps.setString(5, ca.getQuestion());
            
           
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("valider");

    }
    
    
        public void updateCandidature(Candidature ca) {
        String requete = "UPDATE `candidature` SET `id_p`=?,`pseufreelancer`=?,`estimation`=?,`lettre_mot`=?,`question`=?  WHERE `id`=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, ca.getId_p());
            ps.setString(2, ca.getPseufreelancer());
            ps.setString(3, ca.getEstimation());
            ps.setString(4, ca.getLettre_mot());
            ps.setString(5, ca.getQuestion());
             ps.setInt(6,ca.getId_p());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }


  public void deleteCandidature(int id ) {
          String requete = "delete from candidature where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Candidature Suprime");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    


    public List<Candidature> DisplayAllCandidature(String fpseudo) {


        List<Candidature> listCandidature = new ArrayList<Candidature>();
        String requete = "select `id`,  `id_p`,`pseufreelancer`, `estimation`, `lettre_mot`, `question` from candidature where pseufreelancer ='"+fpseudo+"'";

        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Candidature ca = new Candidature();
                ca.setId(resultat.getInt(1));
                ca.setId_p(resultat.getInt(2));
                ca.setPseufreelancer(resultat.getString(3));
                ca.setEstimation(resultat.getString(4));
                ca.setLettre_mot(resultat.getString(5));
                ca.setQuestion(resultat.getString(6));
                listCandidature.add(ca);
                
            }
            return listCandidature;
         } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Candidatures " + ex.getMessage());
            return null;
        }
    }

    
    public List<Candidature> DisplayCandidatureParOwner(String pseudo) {


        List<Candidature> listCandidature = new ArrayList<Candidature>();

        String requete = "select * from candidature c,projet p where c.id_p=p.id and p.owner_p='"+pseudo+"'";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Candidature ca = new Candidature();
                ca.setId(resultat.getInt(1));
                
                ca.setPseufreelancer(resultat.getString(2));
                ca.setId_p(resultat.getInt(3));
                ca.setEstimation(resultat.getString(4));
                ca.setLettre_mot(resultat.getString(5));
                ca.setQuestion(resultat.getString(6));
                listCandidature.add(ca);
                
            }
            return listCandidature;
         } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Candidatures " + ex.getMessage());
            return null;
        }
    }
        
}

