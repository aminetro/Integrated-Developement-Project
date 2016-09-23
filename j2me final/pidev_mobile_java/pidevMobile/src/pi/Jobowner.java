/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

/**
 *
 * @author Mariem
 */
public class Jobowner extends Membre {
       private int id_j;
    private String societe_j;

    public int getId_j() {
        return id_j;
    }

    public void setId_j(int id_j) {
        this.id_j = id_j;
    }

    public String getSociete_j() {
        return societe_j;
    }

    public void setSociete_j(String societe_j) {
        this.societe_j = societe_j;
    }
     public void setId(String id_j) {
        this.id_j = Integer.parseInt(id_j);
    }

    public Jobowner() {
    }

    public Jobowner(int id_j, String societe_j) {
        this.id_j = id_j;
        this.societe_j = societe_j;
    }

    public String toString() {
        return "Jobowner{" + "id_j=" + id_j + ", societe_j=" + societe_j + '}';
    }
    
    Jobowner getJobowner() {
        return null;
    }

    public Jobowner(int id_j, String societe_j, int id, String nom, String prenom, String pays, String ville, String pseudo, String password, String email) {
        super(id, nom, prenom, pays, ville, pseudo, password, email);
        this.id_j = id_j;
        this.societe_j = societe_j;
    }
    
}
