/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.util.Date;

/**
 *
 * @author Mohamedamine
 */
public class cv {
    private int id;
    private Date  date;
    private String experience;
    private String langue;
    private String certification;
    private String formation;

    public cv(int id, Date date, String experience, String langue, String certification, String formation) {
        this.id = id;
        this.date = date;
        this.experience = experience;
        this.langue = langue;
        this.certification = certification;
        this.formation = formation;
    }
    public cv() {
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    void setId(String id) {
        this.id = Integer.parseInt(id);
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public String toString() {
        return "cv{" + "id=" + id + ", date=" + date + ", experience=" + experience + ", langue=" + langue + ", certification=" + certification + ", formation=" + formation + '}';
    }
   cv getcv() {
        return null;
    }
}
