/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.GUI;

import freelancer.DAO.classes.TestDAO;
import freelancer.dao.classes.ProjetDAO;
import freelancer.entities.Projet;
import freelancer.entities.Test;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Amine
 */
public class ModelTest extends AbstractTableModel{
 String[]col_names={"id","nom","question1","reponse1","question2","reponse2","question3","reponse3","question4","reponse4"
                        ,"question5","reponse5","question6","reponse6"};
  ArrayList<Test> T_test;
   public ModelTest() {
        TestDAO test = new TestDAO();
        
        T_test=(ArrayList<Test>) test.DisplayAllTests();
        
    }
    @Override
    public int getRowCount() {
        return T_test.size();
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
                return T_test.get(rowIndex).getId();
            case 1:
                return T_test.get(rowIndex).getNom();
            case 2:
                return T_test.get(rowIndex).getQuestion1();
            case 3:
                return T_test.get(rowIndex).getReponse1();
            case 4:
                return T_test.get(rowIndex).getQuestion2();  
            case 5:
                return T_test.get(rowIndex).getReponse2();
            case 6:
                return T_test.get(rowIndex).getQuestion3();
            case 7:
                return T_test.get(rowIndex).getReponse3();
            case 8:
                return T_test.get(rowIndex).getQuestion4();
            case 9:
                return T_test.get(rowIndex).getReponse4();
            case 10:
                return T_test.get(rowIndex).getQuestion5();  
            case 11:
                return T_test.get(rowIndex).getReponse5();
            case 12:
                return T_test.get(rowIndex).getQuestion6();  
            case 13:
                return T_test.get(rowIndex).getReponse6();
            default:
                return null;
        }
    }
    
}