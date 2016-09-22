package freelancer.dao.classes;

import freelancer.connection.DataSource;
import freelancer.entities.Administrateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import freelancer.dao.classes.MembreDAO;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sou hm
 */
public class AdministrateurDAO{
  private Connection connection;

    public AdministrateurDAO() {
        connection = DataSource.getInstance().getConnection();
        
    }

    public void insertAdministrateur(Administrateur ad) {
        MembreDAO m = new MembreDAO();
        m.inscription(ad);
      String requete = "insert into administrateur  select id from membre where pseudo='"+ad.getPseudo()+"'";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
             ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("valider");
        
        
    }
    
    public void insertAdministrateur(Administrateur ad,String pseudo) {
        MembreDAO m = new MembreDAO();
        m.inscription(ad);
      String requete = "insert into administrateur  select id from membre where pseudo='"+pseudo+"'";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
             ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("valider");
        
        
    }

    
    public void deleteAdministrateur(String pseudo) {
        MembreDAO m = new MembreDAO();
        int id=0;
        id=m.getId(pseudo);
        String requete = "DELETE FROM administrateur WHERE id_a =?;";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Administrateur Supprimer");
            m.deleteMembreByPseudo(pseudo);
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
        
    }




  public List<Administrateur> DisplayAllAdministrateurs() {

        List<Administrateur> listadmin = new ArrayList<Administrateur>();

        String requete = "SELECT id, nom, prenom, pays, ville, pseudo, password , email FROM administrateur a, membre m WHERE a.id_a = m.id";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Administrateur add = new Administrateur();
                add.setId(resultat.getInt(1));
                add.setNom(resultat.getString(2));
                add.setPrenom(resultat.getString(3));
                add.setPays(resultat.getString(4));
                add.setVille(resultat.getString(5));
                add.setPseudo(resultat.getString(6));
                add.setPassword(resultat.getString(7));
                add.setMail(resultat.getString(8));
                listadmin.add(add);
            }
            return listadmin;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Administraeur " + ex.getMessage());
            return null;
        }
    }
  

    public void updateAdministrateur(Administrateur ad,int id) {
        MembreDAO m = new MembreDAO();
        m.updateMembreById(ad, id);
    }

  public Administrateur findAdministrateurById(int id) {
        Administrateur admin = new Administrateur();
        String requete = "SELECT id, nom, prenom, pays, ville, pseudo, PASSWORD , email"
                + " FROM administrateur a, membre m WHERE a.id_a = m.id AND m.id =  ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                admin.setId(resultat.getInt(1));
                admin.setNom(resultat.getString(2));
                admin.setPrenom(resultat.getString(3));
                admin.setPays(resultat.getString(4));
                admin.setVille(resultat.getString(5));
                admin.setPseudo(resultat.getString(6));
                admin.setPassword(resultat.getString(7));
                admin.setMail(resultat.getString(8));
                System.out.println("Id : "+admin.getId()+" Nom : "+admin.getNom()+" Prenom : "+admin.getPrenom()+" Pays : "+admin.getPays()+" Ville : "+admin.getVille()+" Pseudo : "+admin.getPseudo()+" Password : "+admin.getPassword()+" Mail : "+admin.getMail());
            }
            
            if(admin.getPseudo() == null){
                System.out.println("vide");
            }
             return admin;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du Administrateur " + ex.getMessage());
            return null;
        }
     
      
    }

  
  
  public Administrateur findAdministrateurByPseudo(String pseudo) {
        Administrateur admin = new Administrateur();
        String requete = "SELECT id, nom, prenom, pays, ville, pseudo, PASSWORD , email"
                + " FROM administrateur a, membre m WHERE a.id_a = m.id AND m.pseudo =  ?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, pseudo);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                admin.setId(resultat.getInt(1));
                admin.setNom(resultat.getString(2));
                admin.setPrenom(resultat.getString(3));
                admin.setPays(resultat.getString(4));
                admin.setVille(resultat.getString(5));
                admin.setPseudo(resultat.getString(6));
                admin.setPassword(resultat.getString(7));
                admin.setMail(resultat.getString(8));
                System.out.println("Id : "+admin.getId()+" Nom : "+admin.getNom()+" Prenom : "+admin.getPrenom()+" Pays : "+admin.getPays()+" Ville : "+admin.getVille()+" Pseudo : "+admin.getPseudo()+" Password : "+admin.getPassword()+" Mail : "+admin.getMail());
            }
            
            if(admin.getPseudo() == null){
                System.out.println("vide");
            }
             return admin;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du Administrateur " + ex.getMessage());
            return null;
        }
     
      
    }  
  }
