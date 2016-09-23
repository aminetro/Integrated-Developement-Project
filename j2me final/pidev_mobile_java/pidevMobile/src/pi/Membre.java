package pi;

public class Membre {

    private int id;
    private String nom;
    private String prenom;
     private String pays;
    private String ville;
    private String pseudo;
    private String password;
    private String email;
    private String societe;
    private String disponibilite;

    public Membre(int id, String prenom, String pays, String ville, String pseudo, String password, String email) {
        this.id = id;
        this.prenom = prenom;
        this.pays = pays;
        this.ville = ville;
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        
    }

    public Membre(int id, String nom, String prenom, String pays, String ville, String pseudo, String email, String societe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
        this.ville = ville;
        this.pseudo = pseudo;
        this.email = email;
        this.societe = societe;
    }

    public Membre(int id, String nom, String prenom, String pays, String ville, String pseudo, String password, String email, String disponibilite) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.pays = pays;
        this.ville = ville;
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.disponibilite = disponibilite;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }
    
    
    


    public Membre() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    void setId(String id) {
        this.id = Integer.parseInt(id);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Membre{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom +", pays=" + pays + 
                ", ville=" + ville +", pseydo=" + pseudo +", password=" + password +", email=" + email +'}';
    }
    public String toStringe() {
        return "Membre{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom +", pays=" + pays + 
                ", ville=" + ville +", pseydo=" + pseudo +", password=" + password +", email=" + email +", societe=" + societe+ '}';
    }
    public String toStringee() {
        return "Membre{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom +", pays=" + pays + 
                ", ville=" + ville +", pseydo=" + pseudo +", password=" + password +", email=" + email +", disponibilite=" + disponibilite +'}';
    }

    Membre getMembre() {
        return null;
    }
}
