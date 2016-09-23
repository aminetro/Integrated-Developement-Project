/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

import java.util.Date;

/**
 *
 * @author Mariem
 */
public class Reclamation {

    private int id;
    private String expediteur;
    private String sujet;
    private String message;
    private Date date;

  

    public Reclamation() {
    }

    public int getId() {
        return id;
    }

    public Reclamation(int id, String expediteur, String sujet, String message, Date date) {
        this.id = id;
        this.expediteur = expediteur;
        this.sujet = sujet;
        this.message = message;
        this.date = date;
    }

    public String getExpediteur() {
        return expediteur;
    }

    public void setExpediteur(String expediteur) {
        this.expediteur = expediteur;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
 
    public String toString() {
        return "Reclamation{" + "id=" + id + ", expediteur=" + expediteur + ", sujet=" + sujet + ", message=" + message + ", date=" + date + '}';
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }
    public void setDate (String date)
    {
        this.date=getDate();
    }
   

    Reclamation getReclamation() {
        return null;
    }

}
