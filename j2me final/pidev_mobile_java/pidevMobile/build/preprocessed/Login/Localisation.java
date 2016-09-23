/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login;

/**
 *
 * @author Khelifi
 */
public class Localisation {
    
    private int id;
    private String latitude;
    private String longitude;
    private String nom;

    public Localisation() {
    }

    public Localisation(int id, String latitude, String longitude, String nom) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public String toString() {
        return "Localisation{" + "id=" + id + ", nom=" + nom + ", longitude=" + longitude + ", latitude=" + latitude +'}';
    }

    Localisation getLocalisation() {
        return null;
    }
    
    
    

}
