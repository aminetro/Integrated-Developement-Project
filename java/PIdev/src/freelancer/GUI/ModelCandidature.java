/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.dao.classes.CandidatureDAO;
import freelancer.dao.classes.FavorisDAO;
import freelancer.dao.classes.MembreDAO;
import freelancer.dao.classes.ProjetDAO;
import freelancer.entities.Candidature;
import freelancer.entities.Projet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Amine
 */
public class ModelCandidature extends AbstractTableModel{
    String[] col_names = {"id","Projet","Estimation","Lettre mot","Question"};
    ArrayList<Candidature> C_Candidature;
    ArrayList<Projet> P_Projets;

    public ModelCandidature(String pseudo) {
        CandidatureDAO can = new CandidatureDAO();
        C_Candidature=(ArrayList<Candidature>) can.DisplayAllCandidature(pseudo);
        
        
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
                id=C_Candidature.get(rowIndex).getId_p();
                pro=p.GetProjetById(id);
                return "Owner : "+pro.getOwner()+":"+pro.getTitre()+" : "+pro.getDescription();
            case 2:
                return C_Candidature.get(rowIndex).getEstimation();
            case 3:
                return C_Candidature.get(rowIndex).getLettre_mot();  
            case 4:
                return C_Candidature.get(rowIndex).getQuestion();
            default:
                return null;
        }
    }
}