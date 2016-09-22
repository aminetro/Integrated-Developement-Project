/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.DAO.classes;

import freelancer.entities.SuperAdmin;
import freelancer.connection.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class SuperAdminDAO {
      private Connection connection;
         public SuperAdminDAO() {
        connection = DataSource.getInstance().getConnection();
        
    }
          public void updateSuperAdministrateur(SuperAdmin SAd) {
      String requete = "UPDATE  `superadmin` SET  `pseudo` =?,\n" +
"`password` =? WHERE  `superadmin`.`id` =1;";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, SAd.getPseudo());
            ps.setString(2, SAd.getPassword());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
          public List<SuperAdmin> DisplayAllSuperAdministrateurs() {

        List<SuperAdmin> listsuperadmin = new ArrayList<SuperAdmin>();

        String requete = "SELECT pseudo, \n" +
"PASSWORD FROM superadmin";
        try {
            Statement statement = connection
                    .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                SuperAdmin add = new SuperAdmin();
                add.setPseudo(resultat.getString(1));
                add.setPassword(resultat.getString(2));
                //System.out.println(add.getPseudo()+""+add.getPassword());
                listsuperadmin.add(add);
            }
            return listsuperadmin;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
         
}
