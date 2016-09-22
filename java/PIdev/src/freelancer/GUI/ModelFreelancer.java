
package freelancer.gui;

import freelancer.dao.classes.FreelancerDAO;
import freelancer.entities.Freelancer;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;




public class ModelFreelancer extends AbstractTableModel {
 String[] col_names = {"nom", "prenom","pays","ville","pseudo","password","mail","disponibilite"};
   ArrayList<Freelancer> F_Freelancer;
   
   
    public ModelFreelancer() {
     FreelancerDAO free = new FreelancerDAO();
        
        F_Freelancer=(ArrayList<Freelancer>) free.DisplayAllFreelancer();
        
    }
    public ModelFreelancer(String pseudo) {
        FreelancerDAO free = new FreelancerDAO();
        F_Freelancer=(ArrayList<Freelancer>) free.DisplaypseudoFreelancerr(pseudo);
        
    }
    @Override
    public int getRowCount() {
       return F_Freelancer.size();
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
                return F_Freelancer.get(rowIndex).getNom();
            case 1:
                return F_Freelancer.get(rowIndex).getPrenom();
            case 2:
                return F_Freelancer.get(rowIndex).getPays();
            case 3:
                return F_Freelancer.get(rowIndex).getVille();
            case 4:
                return F_Freelancer.get(rowIndex).getPseudo();  
            case 5:
                return F_Freelancer.get(rowIndex).getPassword();
            case 6:
                return F_Freelancer.get(rowIndex).getMail();  
             case 7:
                return F_Freelancer.get(rowIndex).getDisponibilite();  
            default:
                return null;
        }
    }
    
}
