/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.entities;

/**
 *
 * @author sou hm
 */
public class Jobowner extends Membre {
    
    private String societe;

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public Jobowner() {
    }

    public Jobowner(String nom, String prenom, String pays, String ville, String pseudo, String password, String mail) {
        super(nom, prenom, pays, ville, pseudo, password, mail);
    }

    public Jobowner(String societe) {
        this.societe = societe;
    }
  public Jobowner(String nom, String prenom, String pays, String ville, String pseudo, String password, String mail,String societe) {
        super(nom, prenom, pays, ville, pseudo, password, mail);
        this.societe = societe;
    }
    
    
    
}
