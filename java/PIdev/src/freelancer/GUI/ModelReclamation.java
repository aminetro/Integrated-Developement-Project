/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.dao.classes.AdministrateurDAO;
import freelancer.dao.classes.ReclamationDAO;
import freelancer.entities.Administrateur;
import freelancer.entities.Reclamation;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Amine
 */
public class ModelReclamation extends AbstractTableModel{
    String[] col_names = {"Id", "Expediteur" , "Date", "Sujet","Reclamation"};
   ArrayList<Reclamation> R_Reclamation;
   //List<Administrateur> listadmin = new ArrayList<Administrateur>();

    public ModelReclamation() {
        ReclamationDAO rec = new ReclamationDAO();
        //v_personnes = new Vector<Personne>();
        R_Reclamation=(ArrayList<Reclamation>) rec.DisplayAllReclamations();
        
    }

    @Override
    public int getRowCount() {
        return R_Reclamation.size();
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
                return R_Reclamation.get(rowIndex).getId();
            case 1:
                return R_Reclamation.get(rowIndex).getExpediteur();
            case 2:
                return R_Reclamation.get(rowIndex).getDate();
            case 3:
                return R_Reclamation.get(rowIndex).getSujet();
            case 4:
                return R_Reclamation.get(rowIndex).getMessage();
             
            default:
                return null;
        }
    }
   
    

  
    
}