/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.dao.classes;

import freelancer.entities.Jobowner;
import freelancer.entities.Membre;
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
 * @author sou hm
 */
public class JobownerDAO{
    private Connection connection;

    public JobownerDAO() {
        connection = DataSource.getInstance().getConnection();
        
    }  
 
    
    public void insertJobownerDAO(Jobowner jo) {
         String requete2= "insert into jobowner (id_j) "
                 + "select id from membre where pseudo='"+jo.getPseudo()+"'";  
      String requete1= "UPDATE jobowner, membre SET jobowner.societe_j= ? "
              + "WHERE jobowner.id_j=membre.id and membre.pseudo='"+jo.getPseudo()+"'";
       MembreDAO m = new MembreDAO();
        m.inscription(jo);
      try { 
          
       PreparedStatement ps = connection.prepareStatement(requete2);
          
       ps.executeUpdate();
           
     PreparedStatement pss = connection.prepareStatement(requete1);  
        pss.setString(1,jo.getSociete());
         pss.executeUpdate();
   
    } catch (SQLException ex) {
            Logger.getLogger(JobownerDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
    }
    }
    
   
    
    public void updateJobownerDAO(Jobowner jo,int id) {
         
          String requete1= "UPDATE jobowner, membre SET jobowner.societe_j= ? "
              + "WHERE jobowner.id_j=membre.id and id='"+id+"'";
           MembreDAO m = new MembreDAO();
        m.updateMembreById(jo, id);
        try {
           
          
            PreparedStatement ps1 = connection.prepareStatement(requete1);
            ps1.setString(1, jo.getSociete());
            ps1.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(JobownerDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
            
        }
    
    }

   
    
    public void deleteJobownerDAO(String pseudo) {
        MembreDAO m = new MembreDAO();
        int id=0;
        id=m.getId(pseudo);
        String requete = "DELETE FROM jobowner WHERE id_j=?;";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Jobowner Supprimer");
                m.deleteMembreByPseudo(pseudo);
        } catch (SQLException ex) {
            Logger.getLogger(JobownerDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }

    }
    
  
    
  public List<Jobowner> DisplayAllJobowner() {

        List<Jobowner> listJobowner = new ArrayList<Jobowner>();

        String requete ="SELECT id, nom, prenom, pays, ville, pseudo, \n" +
"PASSWORD , email, societe_j\n" +
"FROM membre m, jobowner j\n" +
"WHERE m.id = j.id_j";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
               Jobowner job = new Jobowner();
                job.setId(resultat.getInt(1));
                job.setNom(resultat.getString(2));
                job.setPrenom(resultat.getString(3));
                job.setPays(resultat.getString(4));
                job.setVille(resultat.getString(5));
                job.setPseudo(resultat.getString(6));
                job.setPassword(resultat.getString(7));
                job.setMail(resultat.getString(8));
                 job.setSociete(resultat.getString(9));
             
                listJobowner.add(job);
                
            }
            return listJobowner;
         } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }

   public Jobowner findJobownerByPseudo(String pseudo) {
        Jobowner job = new Jobowner();
        String requete = "SELECT id, nom, prenom, pays, ville, pseudo, PASSWORD , email,societe_j"
                + " FROM jobowner j, membre m WHERE j.id_j = m.id AND m.pseudo =  ?";
               try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, pseudo);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                job.setId(resultat.getInt(1));
                job.setNom(resultat.getString(2));
                job.setPrenom(resultat.getString(3));
                job.setPays(resultat.getString(4));
                job.setVille(resultat.getString(5));
                job.setPseudo(resultat.getString(6));
                job.setPassword(resultat.getString(7));
                job.setMail(resultat.getString(8));
                job.setSociete(resultat.getString(9));
                
                System.out.println("Id : "+job.getId()+" Nom : "+job.getNom()+
                        " Prenom : "+job.getPrenom()+" Pays : "+job.getPays()+
                        " Ville : "+job.getVille()+" Pseudo : "+job.getPseudo()+
                        " Password : "+job.getPassword()+" Mail : "+job.getMail()+" Société : "+job.getSociete());
            }
            
            if(job.getPseudo() == null){
                System.out.println("vide");
            }
             return job;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du Jobowner " + ex.getMessage());
            return null;
        }
     
   
       
}
     
   
   
   public List<Jobowner> findJobownerByPseudoo(String pseudo) {
       List<Jobowner> listJobowner = new ArrayList<Jobowner>();
        
        String requete = "SELECT id, nom, prenom, pays, ville, pseudo, PASSWORD , email,societe_j"
                + " FROM jobowner j, membre m WHERE j.id_j = m.id AND m.pseudo like  ?";
               try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, "%"+pseudo+"%");
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Jobowner job = new Jobowner();
                job.setId(resultat.getInt(1));
                job.setNom(resultat.getString(2));
                job.setPrenom(resultat.getString(3));
                job.setPays(resultat.getString(4));
                job.setVille(resultat.getString(5));
                job.setPseudo(resultat.getString(6));
                job.setPassword(resultat.getString(7));
                job.setMail(resultat.getString(8));
                job.setSociete(resultat.getString(9));
                listJobowner.add(job);
                System.out.println("Id : "+job.getId()+" Nom : "+job.getNom()+
                        " Prenom : "+job.getPrenom()+" Pays : "+job.getPays()+
                        " Ville : "+job.getVille()+" Pseudo : "+job.getPseudo()+
                        " Password : "+job.getPassword()+" Mail : "+job.getMail()+" Société : "+job.getSociete());
            }

             
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du Jobowner " + ex.getMessage());

        }
     return listJobowner;
   
       
}
   
   
   
    }
    
