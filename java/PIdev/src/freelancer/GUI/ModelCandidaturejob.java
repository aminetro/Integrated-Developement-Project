/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.dao.classes.CandidatureDAO;
import freelancer.dao.classes.ProjetDAO;
import freelancer.entities.Candidature;
import freelancer.entities.Projet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mariem
 */
public class ModelCandidaturejob extends AbstractTableModel{
    String[] col_names = {"id","id projet","Pseudo Freelancer","Estimation","Lettre motivation","Question"};
    ArrayList<Candidature> C_Candidature;
    ArrayList<Projet> P_Projets;

    public ModelCandidaturejob(String pseudo) {
        CandidatureDAO can = new CandidatureDAO();
        C_Candidature=(ArrayList<Candidature>) can.DisplayCandidatureParOwner(pseudo);
        
        
    }
    @Override
    public int getRowCount() {
        return C_Candidature.size();
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
        ProjetDAO p = new ProjetDAO();
                Projet pro=new Projet();
                int id;
        switch (columnIndex) {
            case 0:
                return C_Candidature.get(rowIndex).getId();
            case 1:
                return C_Candidature.get(rowIndex).getId_p();
            case 2:
                 return C_Candidature.get(rowIndex).getPseufreelancer();
            case 3:
                return C_Candidature.get(rowIndex).getEstimation();
            case 4:
                return C_Candidature.get(rowIndex).getLettre_mot();  
            case 5:
                return C_Candidature.get(rowIndex).getQuestion();
            default:
                return null;
        }
    }
}