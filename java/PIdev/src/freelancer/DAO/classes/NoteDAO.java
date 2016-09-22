/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.DAO.classes;

import freelancer.connection.DataSource;
import freelancer.entities.Note;
import freelancer.entities.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amine
 */
public class NoteDAO {
    private Connection connection;
    public NoteDAO() {
        connection = DataSource.getInstance().getConnection();
        
    }
    
    public List<Note> DisplayNoteTestPasserParFreelancer(int id){
        List<Note> listnote = new ArrayList<Note>();
        String requete="select id_f,nom_test,note_test from notetest where id_f="+id;
        try {
            Statement statement = connection .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Note t = new Note();
                
                t.setNom(resultat.getString(2));
                t.setNot(resultat.getInt(3));
                
                
                listnote.add(t);
            }
            return listnote;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des note " + ex.getMessage());
            return null;
        }
    }
}
