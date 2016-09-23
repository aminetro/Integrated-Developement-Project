/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Login;

/**
 *
 * @author Mohamedamine
 */
public class Membre {
    private int id;
    private String  nom;
    private String prenom;
    private String pays;
    private String ville;
    private String pseudo;
    private String password;
    private String mail;
    private String societe;

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Membre(int id, String nom, String prenom, String pays, String ville, String pseudo, String password, String mail, String societe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
        this.ville = ville;
        this.pseudo = pseudo;
        this.password = password;
        this.mail = mail;
        this.societe = societe;
    }

   
    public Membre() {
        
    }

    public String toString() {
        return "Membre{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", pays=" + pays + ", ville=" + ville + ", pseudo=" + pseudo + ", password=" + password + ", mail=" + mail + ", societe=" + societe + '}';
    }

   
    
    Membre getMembre() {
        return null;
    }
}
