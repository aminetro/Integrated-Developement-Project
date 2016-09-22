/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.DAO.classes.NoteDAO;
import freelancer.dao.classes.CandidatureDAO;
import freelancer.dao.classes.ProjetDAO;
import freelancer.entities.Candidature;
import freelancer.entities.Note;
import freelancer.entities.Projet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Amine
 */
public class ModelNote extends AbstractTableModel {
    
    String[] col_names = {"Nom De Test","Note"};
    ArrayList<Note> N_Note;
    
    public ModelNote(int id) {
        NoteDAO no = new NoteDAO();
        N_Note=(ArrayList<Note>) no.DisplayNoteTestPasserParFreelancer(id);
        
        
    }
    
    
    @Override
    public int getRowCount() {
        return N_Note.size();
    }

    @Override
    public int getColumnCount() {
         return col_names.length;
    }
    @Override
    public String getColumnName(int i) {
        return col_names[i];
    }
     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return N_Note.get(rowIndex).getNom();
            case 1:
                return N_Note.get(rowIndex).getNot();
  
            default:
                return null;
        }
    }
    
}
