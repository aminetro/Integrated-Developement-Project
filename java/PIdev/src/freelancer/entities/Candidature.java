/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.entities;

/**
 *
 * @author
 */
public class Candidature {
    private  int id;
    private int id_p;
 private String estimation ;
 private String lettre_mot;
 private String question;
 private String pseufreelancer;

    public Candidature(int id_p, String estimation, String lettre_mot, String question, String pseufreelancer) {
        this.id_p = id_p;
        this.estimation = estimation;
        this.lettre_mot = lettre_mot;
        this.question = question;
        this.pseufreelancer = pseufreelancer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseufreelancer() {
        return pseufreelancer;
    }

    public void setPseufreelancer(String pseufreelancer) {
        this.pseufreelancer = pseufreelancer;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
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

    public Candidature(String estimation, String lettre_mot, String question, String pseufreelancer, int id_p) {
        this.estimation = estimation;
        this.lettre_mot = lettre_mot;
        this.question = question;
        this.pseufreelancer = pseufreelancer;
        this.id_p = id_p;
    }

    public Candidature() {
    }


  
 
}
