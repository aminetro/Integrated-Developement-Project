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
public class Projet {
    private int id;
    private String  titre;
    private String categorie;
    private String duree;
    private String description;
    private String pseudoJ;
    private String pseudoF;

    public Projet(int id, String titre, String categorie, String duree, String description, String pseudoJ, String pseudoF) {
        this.id = id;
        this.titre = titre;
        this.categorie = categorie;
        this.duree = duree;
        this.description = description;
        this.pseudoJ = pseudoJ;
        this.pseudoF = pseudoF;
    }
    public Projet() {
       
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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPseudoJ() {
        return pseudoJ;
    }

    public void setPseudoJ(String pseudoJ) {
        this.pseudoJ = pseudoJ;
    }

    public String getPseudoF() {
        return pseudoF;
    }

    public void setPseudoF(String pseudoF) {
        this.pseudoF = pseudoF;
    }

    public String toString() {
        return "Projet{" + "id=" + id + ", titre=" + titre + ", categorie=" + categorie + ", duree=" + duree + ", description=" + description + ", pseudoJ=" + pseudoJ + ", pseudoF=" + pseudoF + '}';
    }
    
      Projet getProjet() {
        return null;
    }
    
}
