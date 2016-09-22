/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.entities;

import java.util.Date;



/**
 *
 * @author ASUS
 */
public class Projet {
    private int id;
    Date date;
    private String titre;
    private String categorie ;
    private String duree;
    private String description;
    private String owner;


    
    public Projet(){
        
    }
    
    public Projet(String titre, String categorie, String duree, String description) {

        this.titre = titre;
        this.categorie = categorie;
        this.duree = duree;
        this.description = description;
    }

    public Projet(int id, Date date, String titre, String categorie, String duree, String description, String owner) {
        this.id = id;
        this.date = date;
        this.titre = titre;
        this.categorie = categorie;
        this.duree = duree;
        this.description = description;
        this.owner = owner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date d) {
        this.date = date;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }


    public String getTitre() {
        return titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDescription() {
        return description;
    }




    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    
    
    
}
