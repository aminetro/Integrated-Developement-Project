/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.dao.classes.ProjetDAO;
import freelancer.entities.Projet;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mariem
 */
public class ModelProjet extends AbstractTableModel{
 String[] col_names = {"id","titre","categorie","duree","description","owner"};
  ArrayList<Projet> P_Projet;
  
  public ModelProjet() {
        ProjetDAO pro = new ProjetDAO();
        P_Projet=(ArrayList<Projet>) pro.DisplayAllProjet();

    }
   public ModelProjet(String pseudo) {
        ProjetDAO pro = new ProjetDAO();
        P_Projet=(ArrayList<Projet>) pro.DisplayProjetParOwner(pseudo);

    }
   public ModelProjet(String categorie,int i) {
        ProjetDAO pro = new ProjetDAO();
        P_Projet=(ArrayList<Projet>) pro.DisplayProjetParCategorie(categorie);

    }
   public ModelProjet(String pseudo,String h) {
        ProjetDAO pro = new ProjetDAO();
        P_Projet=(ArrayList<Projet>) pro.DisplayProjetParFreelancer(pseudo);

    }
    @Override
    public int getRowCount() {
        return P_Projet.size();
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
                return P_Projet.get(rowIndex).getId();
            case 1:
                return P_Projet.get(rowIndex).getTitre();
            case 2:
                return P_Projet.get(rowIndex).getCategorie();
            case 3:
                return P_Projet.get(rowIndex).getDuree();
            case 4:
                return P_Projet.get(rowIndex).getDescription();  
            case 5:
                return P_Projet.get(rowIndex).getOwner();
            default:
                return null;
        }
    }
    
}
