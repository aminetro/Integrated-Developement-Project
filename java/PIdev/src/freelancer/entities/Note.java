/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.entities;

/**
 *
 * @author Amine
 */
public class Note {
    private String nom;
    private int not;

    public Note() {
    }

    public Note(String nom, int not) {
        this.nom = nom;
        this.not = not;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNot() {
        return not;
    }

    public void setNot(int not) {
        this.not = not;
    }
    
}
