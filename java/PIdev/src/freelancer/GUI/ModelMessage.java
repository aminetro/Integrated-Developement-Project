/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.dao.classes.MessagerieDAO;
import freelancer.dao.classes.ReclamationDAO;
import freelancer.entities.Messagerie;
import freelancer.entities.Reclamation;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Amine
 */
public class ModelMessage extends AbstractTableModel{
    String[] col_names = {"Id", "Expediteur" , "Recepteur" , "Date", "Sujet","Reclamation"};
   ArrayList<Messagerie> M_Message;
   //List<Administrateur> listadmin = new ArrayList<Administrateur>();

    public ModelMessage(String pseudo) {
        MessagerieDAO msg = new MessagerieDAO();
        //v_personnes = new Vector<Personne>();
        M_Message=(ArrayList<Messagerie>) msg.DisplayMessageries(pseudo);
        
    }

    @Override
    public int getRowCount() {
        return M_Message.size();
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
                return M_Message.get(rowIndex).getId();
            case 1:
                return M_Message.get(rowIndex).getExpediteur();
            case 2:
                return M_Message.get(rowIndex).getRecepteur();
            case 3:
                return M_Message.get(rowIndex).getDate();
            case 4:
                return M_Message.get(rowIndex).getSujet();
            case 5:
                return M_Message.get(rowIndex).getMsg();
             
            default:
                return null;
        }
    }
   
    

  
    
}