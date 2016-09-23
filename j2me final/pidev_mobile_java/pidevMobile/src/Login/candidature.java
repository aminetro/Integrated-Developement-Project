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
public class candidature {
    private int id;
     private int id_p;
    private String  pseufreelancer;
    private String estimation;
    private String lettre_mot;
    private String question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }
    void setIdp(String id_p) {
        this.id_p = Integer.parseInt(id_p);
    }
    public String getPseufreelancer() {
        return pseufreelancer;
    }

    public void setPseufreelancer(String pseufreelancer) {
        this.pseufreelancer = pseufreelancer;
    }

    public String getEstimation() {
        return estimation;
    }

    public void setEstimation(String estimation) {
        this.estimation = estimation;
    }

    public String getLettre_mot() {
        return lettre_mot;
    }

    public void setLettre_mot(String lettre_mot) {
        this.lettre_mot = lettre_mot;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public candidature(int id, int id_p, String pseufreelancer, String estimation, String lettre_mot, String question) {
        this.id = id;
        this.id_p = id_p;
        this.pseufreelancer = pseufreelancer;
        this.estimation = estimation;
        this.lettre_mot = lettre_mot;
        this.question = question;
    }
    public candidature() {
       
    }

    public String toString() {
        return "candidature{" + "id=" + id + ", id_p=" + id_p + ", pseufreelancer=" + pseufreelancer + ", estimation=" + estimation + ", lettre_mot=" + lettre_mot + ", question=" + question + '}';
    }
    
    candidature getcandidature() {
        return null;
    }
}
