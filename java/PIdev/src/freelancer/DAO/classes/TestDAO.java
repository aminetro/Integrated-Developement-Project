/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.DAO.classes;

import freelancer.connection.DataSource;
import freelancer.entities.Projet;
import freelancer.entities.Test;
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
 * @author Amine
 */
public class TestDAO {
    private Connection connection;
    public TestDAO() {
        connection = DataSource.getInstance().getConnection();
        
    }
    public void insertTest(Test t) {
        String requete =  "INSERT INTO `test`VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, t.getNom());
            ps.setString(2, t.getQuestion1());
            ps.setString(3, t.getReponse1());
            ps.setString(4, t.getQuestion2());
            ps.setString(5, t.getReponse2());
            ps.setString(6, t.getQuestion3());
            ps.setString(7, t.getReponse3());
            ps.setString(8, t.getQuestion4());
            ps.setString(9, t.getReponse4());
            ps.setString(10, t.getQuestion5());
            ps.setString(11, t.getReponse5());
            ps.setString(12, t.getQuestion6());
            ps.setString(13, t.getReponse6());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(freelancer.dao.classes.ProjetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("valider");
    }
    
    
    public List<Test> DisplayAllTests() {
   
        List<Test> listtest = new ArrayList<Test>();

        String requete = "SELECT * from test";
        try {
            Statement statement = connection .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Test t = new Test();
                t.setId(resultat.getInt(1));
                t.setNom(resultat.getString(2));
                t.setQuestion1(resultat.getString(3));
                t.setReponse1(resultat.getString(4));
                t.setQuestion2(resultat.getString(5));
                t.setReponse2(resultat.getString(6));
                t.setQuestion3(resultat.getString(7));
                t.setReponse3(resultat.getString(8));
                t.setQuestion4(resultat.getString(9));
                t.setReponse4(resultat.getString(10));
                t.setQuestion5(resultat.getString(11));
                t.setReponse5(resultat.getString(12));
                t.setQuestion6(resultat.getString(13));
                t.setReponse6(resultat.getString(14));
                
                listtest.add(t);
            }
            return listtest;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    
    
    public void deleteTest(int id) {
        String requete = "delete from test where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Test Supprimer");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }
    
    
    public void updateTest(Test t) {
            String requete = "UPDATE `test` SET `nom` = ?,`question1` = ?,`reponse1` = ?," +
                "`question2` = ?,`reponse2` = ? ,`question3` = ?,`reponse3` = ? "
                    + ",`question4` = ?,`reponse4` = ? ,`question5` = ?,`reponse5` = ? "
                    + ",`question6` = ?,`reponse6` = ?  WHERE  `id` =?;";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.setString(1, t.getNom());
            ps.setString(2, t.getQuestion1());
            ps.setString(3, t.getReponse1());
            ps.setString(4, t.getQuestion2());
            ps.setString(5, t.getReponse2());
            ps.setString(6, t.getQuestion3());
            ps.setString(7, t.getReponse3());
            ps.setString(8, t.getQuestion4());
            ps.setString(9, t.getReponse4());
            ps.setString(10, t.getQuestion5());
            ps.setString(11, t.getReponse5());
            ps.setString(12, t.getQuestion6());
            ps.setString(13, t.getReponse6());
            ps.setInt(14, t.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
    
    public Test GetTest(String nom) {
   
            Test t = new Test();
        String requete = "SELECT * from test where nom ='"+nom+"'";
        try {
            Statement statement = connection .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                
                t.setId(resultat.getInt(1));
                t.setNom(resultat.getString(2));
                t.setQuestion1(resultat.getString(3));
                t.setReponse1(resultat.getString(4));
                t.setQuestion2(resultat.getString(5));
                t.setReponse2(resultat.getString(6));
                t.setQuestion3(resultat.getString(7));
                t.setReponse3(resultat.getString(8));
                t.setQuestion4(resultat.getString(9));
                t.setReponse4(resultat.getString(10));
                t.setQuestion5(resultat.getString(11));
                t.setReponse5(resultat.getString(12));
                t.setQuestion6(resultat.getString(13));
                t.setReponse6(resultat.getString(14));
                
 
            }
            return t;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
    
    public int GetNoteTest(String nom,String r1,String r2,String r3,String r4,String r5,String r6,int idd){
        
        int i=0;
        
        String[]tab={r1,r2,r3,r4,r5,r6};
        String requete;
        requete="delete from notetest where nom_test = '"+nom+"'";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.executeUpdate();
        for (int j=1;j<7;j++)
        {
            requete="select * from test where nom='"+nom+"' and reponse"+j+" = '"+tab[j-1]+"'";
            
            Statement statement = connection .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            resultat.beforeFirst();
            if (resultat.next()) {
               i++;
            }
        
        
        }
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
        }
        System.out.println("note = "+i);
        requete="insert into notetest values("+i+",'"+nom+"',"+idd+")";
        try{
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.executeUpdate();
            System.out.println("Note Affecte avec succès");
        }catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
        
        return i;
    }
    
    
}
