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
public class Freelancer  extends Membre{
     private String disponibilite_f;
     private int id_f;

    public Freelancer() {
    }

    public Freelancer(String disponibilite_f, int id_f, int id, String nom, String prenom, String pays, String ville, String pseudo, String password, String email) {
        super(id, nom, prenom, pays, ville, pseudo, password, email);
        this.disponibilite_f = disponibilite_f;
        this.id_f = id_f;
    }

    public String getDisponibilite_f() {
        return disponibilite_f;
    }

    public void setDisponibilite_f(String disponibilite_f) {
        this.disponibilite_f = disponibilite_f;
    }

    public int getId_f() {
        return id_f;
    }

    public void setId_f(int id_f) {
        this.id_f = id_f;
    }
    public void setId_f(String id_f) {
        this.id_f = Integer.parseInt(id_f);
    }

    public String toString() {
        return super.toString()+"Freelancer{" + "disponibilite_f=" + disponibilite_f + ", id_f=" + id_f + '}';
    }

 Freelancer getFreelancer() {
        return null;
    }
}
