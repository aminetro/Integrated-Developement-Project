/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.entities;
import java.util.Date;

/**
 *
 * @author Mariem
 */
public class Reclamation {
    private int id;
    private String expediteur;
    private Date date;
    private String sujet;
    private String  message;
    
    public Reclamation(){};

    public Reclamation(String expediteur, Date date, String sujet, String message) {
        this.expediteur = expediteur;
        this.date = date;
        this.sujet = sujet;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    


}