/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.entities;

import java.util.Date;

/**
 *
 * @author Amine
 */
public class Messagerie {
    private int id;
    private String expediteur;
    private String recepteur;
    private Date date;
    private String sujet;
    private String msg;

    public Messagerie() {
    }

    public Messagerie(String expediteur, String recepteur, Date date, String sujet, String msg) {
        this.expediteur = expediteur;
        this.recepteur = recepteur;
        this.date = date;
        this.sujet = sujet;
        this.msg = msg;
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

    public String getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(String recepteur) {
        this.recepteur = recepteur;
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    
}
