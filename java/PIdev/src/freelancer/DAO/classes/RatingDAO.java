/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.DAO.classes;

import freelancer.connection.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.math.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amine
 */
public class RatingDAO {
    private Connection connection;
    public RatingDAO() {
        connection = DataSource.getInstance().getConnection();       
    }
    
    public void CalculRating(String pseudo_vote,String pseudo_voteur,int vote){
        try {
            String requete;
            requete = "delete from rating where pseudo_vote = '" + pseudo_vote + "' and pseudo_voteur='" + pseudo_voteur + "'";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.executeUpdate();
            System.out.println("vote suprime");
            requete = "insert into rating values('" + pseudo_vote + "','" + pseudo_voteur + "'," + vote + ")";
            PreparedStatement ps2 = connection.prepareStatement(requete);
            ps2.executeUpdate();
            System.out.println("vote affecte");
        } catch (SQLException ex) {
            System.out.println("erreur lors du vote" + ex.getMessage());
        }
    }
    
    
    public int getRating(String pseudo_vote){        
        try {
            String requete = "select rate from rating where pseudo_vote='" + pseudo_vote + "'";
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            int i=0;
            int y=0;
            while (resultat.next()) {
                i++;
                y += resultat.getInt(1);                
            }
            if(i==0)
                return 0;
            return Math.round(y / i);
        } catch (Exception ex) {
            System.out.println("erreur lors du chargement de rating" + ex.getMessage());
        }
        return 0;
    }
    
    
    public String getMaxRatingFreelancer(){
        String maxS="";int maxR=0;int x;
        try {
            String requete="select pseudo from membre m , freelancer f where m.id=f.id_f";
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                x=getRating(resultat.getString(1));
                if(maxR<x){
                    maxR=x;maxS=resultat.getString(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RatingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxS;
    }
    
    
    public String getMaxRatingJobowner(){
        String maxS="";int maxR=0;int x;
        try {
            String requete="select pseudo from membre m , jobowner j where m.id=j.id_j";
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next()){
                x=getRating(resultat.getString(1));
                if(maxR<x){
                    maxR=x;maxS=resultat.getString(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RatingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxS;
    }
    
}
