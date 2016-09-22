/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.dao.classes;

import freelancer.entities.Freelancer;
import freelancer.entities.Membre;
import freelancer.connection.DataSource;
import freelancer.entities.Jobowner;
import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author sou hm
 */
public class FreelancerDAO{
   private  Connection connection;
   private int x;

    public FreelancerDAO() {
        connection = DataSource.getInstance().getConnection();
                
        
    
    }

        
    

    public void insertFreelancer(Freelancer free) {
         
      
       MembreDAO m = new MembreDAO();
        m.inscription(free);
        
        
      try { 
          String requete1= "insert into freelancer (id_f) "
                 + "select id from membre where pseudo='"+free.getPseudo()+"'";  
       PreparedStatement ps = connection.prepareStatement(requete1);
           ps.executeUpdate();
        String requete2= "UPDATE freelancer, membre SET freelancer.disponibilite_f= ? "
              + "WHERE freelancer.id_f=membre.id and membre.pseudo='"+free.getPseudo()+"'";   
     PreparedStatement pss = connection.prepareStatement(requete2);  
        pss.setString(1,free.getDisponibilite());
         pss.executeUpdate();
   
    } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion du Freelancer " + ex.getMessage());
    }
    }
    
 
    public void updateFreelancer(Freelancer free,String pseudo) {
         
          String requete1= "UPDATE freelancer, membre SET freelancer.disponibilite_f= ? "
              + "WHERE freelancer.id_f=membre.id and pseudo='"+pseudo+"'";
           MembreDAO m = new MembreDAO();
        m.updateMembreByPseudo(free, pseudo);
        try {
           
          
            PreparedStatement ps1 = connection.prepareStatement(requete1);
            ps1.setString(1, free.getDisponibilite());
            ps1.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
            
        }
    
    }


    public void deleteFreelancerByPseudo(String pseudo) {
        MembreDAO m = new MembreDAO();
        int id=0;
        id=m.getId(pseudo);
        String requete = "DELETE FROM freelancer where  id_f=?;";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("freelancer Supprimer");
                    m.deleteMembreByPseudo(pseudo);
        } catch (SQLException ex) {
            Logger.getLogger(FreelancerDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }

    }
    
    

  public List<Freelancer> DisplayAllFreelancer() {

        List<Freelancer> listFreelancer = new ArrayList<Freelancer>();

        String requete ="SELECT id, nom, prenom, pays, ville, pseudo, \n" +
"PASSWORD , email, disponibilite_f\n" +
"FROM membre m, freelancer f\n" +
"WHERE m.id = f.id_f";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
               Freelancer free = new Freelancer();
                free.setId(resultat.getInt(1));
                free.setNom(resultat.getString(2));
                free.setPrenom(resultat.getString(3));
                free.setPays(resultat.getString(4));
                free.setVille(resultat.getString(5));
                free.setPseudo(resultat.getString(6));
                free.setPassword(resultat.getString(7));
                free.setMail(resultat.getString(8));
                 free.setDisponibilite(resultat.getString(9));
             
                listFreelancer.add(free);
                
            }
            return listFreelancer;
         } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Freelancers " + ex.getMessage());
            return null;
        }
    }
    
    public Freelancer DisplaypseudoFreelancer(String pseudo) {
       //  List<Freelancer> listFreelancer = new ArrayList<Freelancer>();
    Freelancer fl =new Freelancer();
        String requete ="SELECT id, nom, prenom, pays, ville, pseudo, \n" +
"PASSWORD , email, disponibilite_f\n" +
"FROM membre m, freelancer f\n" +
"WHERE m.id = f.id_f and m.pseudo='"+pseudo+"'";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
           //    Freelancer free = new Freelancer();
                fl.setId(resultat.getInt(1));
                fl.setNom(resultat.getString(2));
                fl.setPrenom(resultat.getString(3));
                fl.setPays(resultat.getString(4));
                fl.setVille(resultat.getString(5));
                fl.setPseudo(resultat.getString(6));
                fl.setPassword(resultat.getString(7));
                fl.setMail(resultat.getString(8));
                 fl.setDisponibilite(resultat.getString(9));
             
               // listFreelancer.add(free);
                
            }
            return fl;
         } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Freelancers " + ex.getMessage());
            return null;
        }
    }
    
    
     public List<Freelancer> DisplaypseudoFreelancerr(String pseudo) {
    
       List<Freelancer> listFreelancer = new ArrayList<Freelancer>();
        
        String requete = "SELECT id, nom, prenom, pays, ville, pseudo, PASSWORD , email,disponibilite_f"
                + " FROM freelancer f, membre m WHERE f.id_f = m.id AND m.pseudo like '%"+pseudo+"%'";
               try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Freelancer job = new Freelancer();
                job.setId(resultat.getInt(1));
                job.setNom(resultat.getString(2));
                job.setPrenom(resultat.getString(3));
                job.setPays(resultat.getString(4));
                job.setVille(resultat.getString(5));
                job.setPseudo(resultat.getString(6));
                job.setPassword(resultat.getString(7));
                job.setMail(resultat.getString(8));
                job.setDisponibilite(resultat.getString(9));
                listFreelancer.add(job);
               
            }

             
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du free " + ex.getMessage());

        }
     return listFreelancer;
         
     }
    }
    



