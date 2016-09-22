/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.dao.classes.CvFreeLancerDAO;
import freelancer.entities.CvFreelancer;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;




/**
 *
 * @author hp
 */
public class Model_freelancer_moncv extends AbstractTableModel{
    
     String[] col_names = {"Experience" , "Langue" , "Certification", "Formation","Dernier mis a jour","Pseudo"};
   ArrayList<CvFreelancer> cv_freelancer;
   
   public Model_freelancer_moncv(String pseudo) {
      CvFreeLancerDAO msg = new CvFreeLancerDAO();
        //v_personnes = new Vector<Personne>();
        cv_freelancer=(ArrayList<CvFreelancer>) msg.DisplayAllCvFreelancer(pseudo);
       
    }

    Model_freelancer_moncv() {
        
    }
    @Override
    public int getRowCount() {
       return cv_freelancer.size();
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
               return cv_freelancer.get(rowIndex).getExperience_cv();
            case 1:
                return cv_freelancer.get(rowIndex).getLangue_cv();
             case 2:
                return cv_freelancer.get(rowIndex).getCertification_cv();
             case 3:
                return cv_freelancer.get(rowIndex).getFormation_cv();
            case 4:
                return cv_freelancer.get(rowIndex).getDernier_maj_cv();
            case 5:
                return cv_freelancer.get(rowIndex).getPseudo();
            default:
                return null;
        }
    }
    
}
