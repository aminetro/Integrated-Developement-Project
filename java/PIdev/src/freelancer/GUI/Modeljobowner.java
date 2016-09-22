/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.dao.classes.FreelancerDAO;
import freelancer.dao.classes.JobownerDAO;
import freelancer.entities.Freelancer;
import freelancer.entities.Jobowner;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;



/**
 *
 * @author ASUS
 */


/**
 *
 * @author ASUS
 */
public class Modeljobowner extends AbstractTableModel {
 String[] col_names = {"nom", "prenom","pays","ville","pseudo","password","mail","societe"};
   ArrayList<Jobowner> J_Jobowner;
   
   
    public Modeljobowner() {
        JobownerDAO job = new JobownerDAO();
        J_Jobowner=(ArrayList<Jobowner>) job.DisplayAllJobowner();     
    }
    
    public Modeljobowner(String pseudo) {
        JobownerDAO job = new JobownerDAO();
        J_Jobowner=(ArrayList<Jobowner>) job.findJobownerByPseudoo(pseudo);             
    }
    
    @Override
    public int getRowCount() {
       return J_Jobowner.size();
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
                return J_Jobowner.get(rowIndex).getNom();
            case 1:
                return J_Jobowner.get(rowIndex).getPrenom();
            case 2:
                return J_Jobowner.get(rowIndex).getPays();
            case 3:
                return J_Jobowner.get(rowIndex).getVille();
            case 4:
                return J_Jobowner.get(rowIndex).getPseudo();  
            case 5:
                return J_Jobowner.get(rowIndex).getPassword();
            case 6:
                return J_Jobowner.get(rowIndex).getMail();  
             case 7:
                return J_Jobowner.get(rowIndex).getSociete();  
            default:
                return null;
        }
    }
    
}

    
  
    

