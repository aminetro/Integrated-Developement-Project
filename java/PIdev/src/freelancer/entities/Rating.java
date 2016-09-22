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
public class Rating {
    private String pseudo_vote;
    private String pseudo_voteur;
    private int nbrvote;
    private float rate;

    public Rating() {
    }

    public Rating(String pseudo_vote, String pseudo_voteur, int nbrvote, float rate) {
        this.pseudo_vote = pseudo_vote;
        this.pseudo_voteur = pseudo_voteur;
        this.nbrvote = nbrvote;
        this.rate = rate;
    }

    public String getPseudo_vote() {
        return pseudo_vote;
    }

    public void setPseudo_vote(String pseudo_vote) {
        this.pseudo_vote = pseudo_vote;
    }

    public String getPseudo_voteur() {
        return pseudo_voteur;
    }

    public void setPseudo_voteur(String pseudo_voteur) {
        this.pseudo_voteur = pseudo_voteur;
    }

    public int getNbrvote() {
        return nbrvote;
    }

    public void setNbrvote(int nbrvote) {
        this.nbrvote = nbrvote;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
    
}
