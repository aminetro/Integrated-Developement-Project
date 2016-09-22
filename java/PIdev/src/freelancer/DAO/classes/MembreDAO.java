/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.dao.classes;

import freelancer.entities.Administrateur;
import freelancer.entities.Membre;
import freelancer.connection.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */

public class MembreDAO{
  private Connection connection;

    public MembreDAO() {
        connection = DataSource.getInstance().getConnection();
        
    }
    
    
        public void inscription(Membre mb) {
      
         String requete = "INSERT INTO `membre`(`nom`, `prenom`,"
                + " `pays`, `ville`, `pseudo`, `password`, `email`) VALUES"
                + " (?,?,?,?,?,?,?)";
        
     try { 
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, mb.getNom());
            ps.setString(2, mb.getPrenom());
            ps.setString(3, mb.getPays());
            ps.setString(4, mb.getVille());
            ps.setString(5, mb.getPseudo());    
            ps.setString(6, mb.getPassword());
            ps.setString(7, mb.getMail());
            ps.executeUpdate();
       } catch (SQLException ex) {
            Logger.getLogger(MembreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("valider");
    }



    public void updateMembreById(Membre mb ,int id){
        String requete = "UPDATE membre SET nom = ?,\n" +
"prenom =  ?,\n" +
"pays =  ?,\n" +
"ville =  ?,\n" +
"pseudo =  ?,\n" +
"PASSWORD =  ?,\n" +
"email = ? WHERE id ="+id;
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, mb.getNom());
            ps.setString(2, mb.getPrenom());
            ps.setString(3, mb.getPays());
            ps.setString(4, mb.getVille());
            ps.setString(5, mb.getPseudo());
            ps.setString(6, mb.getPassword());
            ps.setString(7, mb.getMail());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    public void updateMembreByPseudo(Membre mb ,String pseudo){
        String requete = "UPDATE membre SET nom = ?,\n" +
"prenom =  ?,\n" +
"pays =  ?,\n" +
"ville =  ?,\n" +
"pseudo =  ?,\n" +
"PASSWORD =  ?,\n" +
"email = ? WHERE pseudo ='"+pseudo+"'";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, mb.getNom());
            ps.setString(2, mb.getPrenom());
            ps.setString(3, mb.getPays());
            ps.setString(4, mb.getVille());
            ps.setString(5, mb.getPseudo());
            ps.setString(6, mb.getPassword());
            ps.setString(7, mb.getMail());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    public void deleteMembreByPseudo(String pseudo) {
        String requete = "delete from membre where pseudo=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, pseudo);
            ps.executeUpdate();
            System.out.println("Membre Suprime");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public Membre findMembreById(int id) {
        Membre mb = new Membre();
        String requete = "select * from membre where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                mb.setId(resultat.getInt(1));
                mb.setNom(resultat.getString(2));
                mb.setPrenom(resultat.getString(3));
                mb.setPays(resultat.getString(4));
                mb.setVille(resultat.getString(5));
                mb.setPseudo(resultat.getString(6));
                mb.setPassword(resultat.getString(7));
                mb.setMail(resultat.getString(8));
            }
            return mb;
            
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du membre " + ex.getMessage());
            return null;
        }
       
    }

  public List<Membre> DisplayAllMembre() {

        List<Membre> listmembre = new ArrayList<Membre>();

        String requete = "select * from membre";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Membre add = new Membre();
                add.setNom(resultat.getString(2));
                add.setPseudo(resultat.getString(3));
                System.out.println(add.getNom());
                listmembre.add(add);
                
            }
            return listmembre;
         } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }

    public String authentification(String pseudo,String pass) throws SQLException{
        String requete1 = "select id from membre where pseudo='"+pseudo+"' and password like '%"+pass+"%'";
            Statement statement = connection.createStatement();
            ResultSet resultat1 = statement.executeQuery(requete1);
            resultat1.beforeFirst();
            if(resultat1.next()){
                
                int id=resultat1.getInt(1);
                String requete2 = "select id_a from administrateur where id_a="+id;
                    ResultSet resultat2 = statement.executeQuery(requete2);
                    resultat2.beforeFirst();
                    if(resultat2.next()){ return"admin"; }
                    
                String requete3 = "select id_f from freelancer where id_f="+id;
                    ResultSet resultat3 = statement.executeQuery(requete3);
                    resultat3.beforeFirst();
                    if(resultat3.next()){ return"freelancer"; }
                    
                String requete4 = "select id_j from jobowner where id_j="+id;
                    ResultSet resultat4 = statement.executeQuery(requete4);
                    resultat4.beforeFirst();
                    if(resultat4.next()){  return"jobowner"; }
                    
            }
      return "wrong";
        
    }
    
    public int getId(String pseudo){
         try {
            String requete1 = "select id from membre where pseudo='" + pseudo + "'";
            Statement statement = connection.createStatement();
            ResultSet resultat1 = statement.executeQuery(requete1);
            resultat1.beforeFirst();
            if (resultat1.next()) {
                return resultat1.getInt(1);
            }
        } catch (SQLException sQLException) {
        }
        return 0;
    }
     public String authentificationsuper(String pseudo,String pass) throws SQLException{
        String requete1 = "select id from superadmin where pseudo='"+pseudo+"' and password='"+pass+"'";
        
            Statement statement = connection.createStatement();
            ResultSet resultat1 = statement.executeQuery(requete1);
            resultat1.beforeFirst();
            if(resultat1.next()){
                 return"superadmin"; 
              }
      return "wrong";
        }
     
     
     public Membre findMembreBymail(String mail) {
        Membre mb = new Membre();
        String requete = "select (id,nom,prenom,pays,ville,username,password,email) from membre where mail=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, mail);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                mb.setId(resultat.getInt(1));
                mb.setNom(resultat.getString(2));
                mb.setPrenom(resultat.getString(3));
                mb.setPays(resultat.getString(4));
                mb.setVille(resultat.getString(5));
                mb.setPseudo(resultat.getString(6));
                mb.setPassword(resultat.getString(7));
                mb.setMail(resultat.getString(8));
            }
            return mb;
            
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du membre " + ex.getMessage());
            return null;} }
 }

