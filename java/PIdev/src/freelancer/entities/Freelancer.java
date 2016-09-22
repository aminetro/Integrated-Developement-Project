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
public class Freelancer extends Membre{
    private String disponibilite;

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public Freelancer() {
        
    }

    public Freelancer(String disponibilite) {
        this.disponibilite = disponibilite;
    }

public Freelancer(String nom, String prenom, String pays, String ville, String pseudo, String password, String mail,String disponibilite) {
        super(nom, prenom, pays, ville, pseudo, password, mail);
        this.disponibilite = disponibilite;
    }
   
    
    
    
    
    
}
