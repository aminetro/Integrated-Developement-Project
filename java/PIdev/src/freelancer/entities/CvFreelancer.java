/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.entities;

import java.sql.Date;

/**
 *
 * @author hp
 */
public class CvFreelancer {
    public int id;
    public Date dernier_maj_cv;
    public String experience_cv;
    public String langue_cv;
    public String certification_cv;
    public String nfreelancer_cv;
    public String formation_cv;
    public String pseudo;
    public CvFreelancer()
    {}

    public String getFormation_cv() {
        return formation_cv;
    }

    public void setFormation_cv(String formation_cv) {
        this.formation_cv = formation_cv;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

  public CvFreelancer(Date dernier_maj_cv, String experience_cv, String langue_cv, String certification_cv,String formation_cv ) {
       this.dernier_maj_cv = dernier_maj_cv;
       this.experience_cv = experience_cv;
       this.langue_cv = langue_cv;
       this.certification_cv = certification_cv;
       this.formation_cv=formation_cv;
    }   
   
 public int  getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }
   

    public Date getDernier_maj_cv() {
        return dernier_maj_cv;
    }

    public void setDernier_maj_cv(Date dernier_maj_cv) {
        this.dernier_maj_cv = dernier_maj_cv;
    }

    public String getExperience_cv() {
        return experience_cv;
    }

    public void setExperience_cv(String experience_cv) {
        this.experience_cv = experience_cv;
    }

    public String getLangue_cv() {
        return langue_cv;
    }

    public void setLangue_cv(String langue_cv) {
        this.langue_cv = langue_cv;
    }

    public String getCertification_cv() {
        return certification_cv;
    }

    public void setCertification_cv(String certification_cv) {
        this.certification_cv = certification_cv;
    }

    public String getfreelancer_cv() {
        return nfreelancer_cv;
    }

    public void setnfreelancer_cv(String nfreelancer_cv) {
        this.nfreelancer_cv = nfreelancer_cv;
    }

    
}
