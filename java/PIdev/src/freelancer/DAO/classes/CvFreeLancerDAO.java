/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.dao.classes;

import freelancer.entities.CvFreelancer;
import freelancer.entities.Freelancer;
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
 * @author hp
 */
public class CvFreeLancerDAO{
    
     private final Connection connection;

    public CvFreeLancerDAO() {
        connection = DataSource.getInstance().getConnection();
        
    }
    
     


    public void insertCvFreelancer(CvFreelancer cv,String pseudo) {
      //  "INSERT INTO  `freelancer`.`cvfreelancer` (`dernier_maj_cv`,`experience_cv`,`langue_cv`,`certification_cv`)VALUES (?,?,?,?);";

        String requete2= "insert into  `cvfreelancer` (id_cv) "
                 + "select id from membre where pseudo='"+pseudo+"'";  
      String requete1= "UPDATE cvfreelancer, membre SET cvfreelancer.dernier_maj_cv= ?, cvfreelancer.experience_cv= ?,cvfreelancer.langue_cv= ?,cvfreelancer.certification_cv= ?,cvfreelancer.formation_cv= ?"
              + "WHERE cvfreelancer.id_cv=membre.id and membre.pseudo='"+pseudo+"'";
      // MembreDAO m = new MembreDAO();
       // m.inscription(mb);
      try { 
          
       PreparedStatement ps = connection.prepareStatement(requete2);
           ps.executeUpdate();
           
     PreparedStatement pss = connection.prepareStatement(requete1);  
            pss.setDate(1, cv.getDernier_maj_cv());
            pss.setString(2, cv.getExperience_cv());
            pss.setString(3, cv.getLangue_cv());
            pss.setString(4, cv.getCertification_cv());
            pss.setString(5, cv.getFormation_cv());

          
         pss.executeUpdate();
   
    } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
                              System.out.println("********************!!**********exxxx************************************");

    }
  
      
    }

        public void updateCvFreelancer(CvFreelancer cv, String pseudo) {
       
                String requete1= "UPDATE cvfreelancer cv,membre m  SET cv.dernier_maj_cv=?,cv.experience_cv=?,cv.langue_cv=?,cv.certification_cv=?,cv.formation_cv=? WHERE cv.id_cv = m.id AND m.pseudo='"+pseudo+"'";

        try {
           
          
            PreparedStatement ps = connection.prepareStatement(requete1);
              ps.setDate(1, cv.getDernier_maj_cv());
            ps.setString(2, cv.getExperience_cv());
            ps.setString(3, cv.getLangue_cv());
            ps.setString(4, cv.getCertification_cv());
            ps.setString(5, cv.getFormation_cv());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
            
        }
            
            
        
    }


    public void deleteCvFreelancer(String pseudo) {
            String requete ="DELETE FROM cvfreelancer\n" +
"  WHERE id IN (SELECT id FROM membre WHERE pseudo =?);";
                    
                    //"DELETE FROM cvfreelancer cv , membre m WHERE cv.id_cv=m.id AND m.pseudo='"+pseudo+"'";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
           ps.setString(1, pseudo);
            ps.executeUpdate();
            System.out.println("cv freelancer Supprimer");
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
       
    }
    

    
    public List<CvFreelancer> DisplayAllCvFreelancer(String pseudo) {

 List<CvFreelancer> listCvFreelancer = new ArrayList<CvFreelancer>();

        String requete = "SELECT id_cv, dernier_maj_cv, experience_cv, langue_cv, Certification_cv,formation_cv,pseudo FROM membre m, cvfreelancer cv WHERE m.id = cv.id_cv AND m.pseudo ='"+pseudo+"'";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            
            
            /*PreparedStatement pss = connection.prepareStatement(requete1);  
          pss.setString(1, cv.getDernier_maj_cv());*/
            
                            CvFreelancer cv = new CvFreelancer();
                                                         Freelancer fl = new Freelancer();

            while (resultat.next()) {
                cv.setid(resultat.getInt(1));
                cv.setDernier_maj_cv(resultat.getDate(2));
                cv.setExperience_cv(resultat.getString(3));
                cv.setLangue_cv(resultat.getString(4));
                cv.setCertification_cv(resultat.getString(5));
                cv.setFormation_cv(resultat.getString(6));
                cv.setPseudo(resultat.getString(7));
//                 cv.setPhoto(resultat.getString(6));
                //pss.setBytes(5, cv.getPhoto());
               // free.setPseudo(resultat.getString(5));
               System.out.println("derniermis ajour : "+cv.getDernier_maj_cv()+" Date : "+cv.getExperience_cv()+" titre : "+cv.getLangue_cv()+"certification"+cv.getCertification_cv());
                
               listCvFreelancer.add(cv);
                
            
            }
          
               
            return listCvFreelancer;
            
            
         } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }

    
    public List<CvFreelancer> DisplayAllCvFreelancer() {
          List<CvFreelancer> listCvFreelancer = new ArrayList<CvFreelancer>();

        String requete = "SELECT * FROM cvfreelancer";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            
            
            /*PreparedStatement pss = connection.prepareStatement(requete1);  
          pss.setString(1, cv.getDernier_maj_cv());*/
            
            
            while (resultat.next()) {
                CvFreelancer cv = new CvFreelancer();
                Freelancer free = new Freelancer();
                cv.setid(resultat.getInt(1));
                cv.setDernier_maj_cv(resultat.getDate(2));
                cv.setExperience_cv(resultat.getString(3));
                cv.setLangue_cv(resultat.getString(4));
                cv.setCertification_cv(resultat.getString(5));
               //  cv.setPhoto(resultat.getString(6));
               // free.setPseudo(resultat.getString(5));
               System.out.println("derniermis ajour : "+cv.getDernier_maj_cv()+" Date : "+cv.getExperience_cv()+" titre : "+cv.getLangue_cv()+"certification"+cv.getCertification_cv());
               listCvFreelancer.add(cv);
                
            }
            return listCvFreelancer;
         } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    
     public CvFreelancer DisplayCvFreelancer(String pseudo) {

 List<CvFreelancer> listCvFreelancer = new ArrayList<CvFreelancer>();

        String requete = "SELECT id_cv, dernier_maj_cv, experience_cv, langue_cv, Certification_cv,formation_cv,pseudo FROM membre m, cvfreelancer cv WHERE m.id = cv.id_cv AND m.pseudo ='"+pseudo+"'";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            
          
            
                            CvFreelancer cv = new CvFreelancer();

            while (resultat.next()) {
                cv.setid(resultat.getInt(1));
                cv.setDernier_maj_cv(resultat.getDate(2));
                cv.setExperience_cv(resultat.getString(3));
                cv.setLangue_cv(resultat.getString(4));
                cv.setCertification_cv(resultat.getString(5));
                cv.setFormation_cv(resultat.getString(6));
                cv.setPseudo(resultat.getString(7));
//                 cv.setPhoto(resultat.getString(6));
                //pss.setBytes(5, cv.getPhoto());
               // free.setPseudo(resultat.getString(5));
               System.out.println("derniermis ajour : "+cv.getDernier_maj_cv()+" Date : "+cv.getExperience_cv()+" titre : "+cv.getLangue_cv()+"certification"+cv.getCertification_cv());
                
               listCvFreelancer.add(cv);
                
            
            }
          
               
            return cv;
            
            
         } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    
    
    
    }
    
    

