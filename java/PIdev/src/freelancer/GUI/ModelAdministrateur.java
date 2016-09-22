/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;


import freelancer.dao.classes.AdministrateurDAO;
import freelancer.dao.classes.JobownerDAO;
import freelancer.entities.Administrateur;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class ModelAdministrateur extends AbstractTableModel{
    String[] col_names = {"nom", "prenom","pays","ville","pseudo","password","mail"};
   ArrayList<Administrateur> A_Administrateur;
   //List<Administrateur> listadmin = new ArrayList<Administrateur>();
 
   
    public ModelAdministrateur() {
        AdministrateurDAO admin = new AdministrateurDAO();
        //v_personnes = new Vector<Personne>()Superadmin_ajoutadministrateurnistSuperadmin_ajoutadministrateur_administrateur();
        A_Administrateur=(ArrayList<Administrateur>) admin.DisplayAllAdministrateurs();
        
    }

    @Override
    public int getRowCount() {
        return A_Administrateur.size();
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
                return A_Administrateur.get(rowIndex).getNom();
            case 1:
                return A_Administrateur.get(rowIndex).getPrenom();
            case 2:
                return A_Administrateur.get(rowIndex).getPays();
            case 3:
                return A_Administrateur.get(rowIndex).getVille();
            case 4:
                return A_Administrateur.get(rowIndex).getPseudo();  
            case 5:
                return A_Administrateur.get(rowIndex).getPassword();
            case 6:
                return A_Administrateur.get(rowIndex).getMail();        
            default:
                return null;
        }
    }

   
   
    

  
    
}
