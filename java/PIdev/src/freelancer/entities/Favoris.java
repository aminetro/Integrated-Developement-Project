/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package freelancer.entities;

/**
 *
 * @author Amine
 */
public class Favoris {
    private int id_f;
    private int id_p;
    
    public Favoris() {
    }
    public Favoris(int id_f, int id_p) {
        this.id_f = id_f;
        this.id_p = id_p;
    }

    public int getId_f() {
        return id_f;
    }

    public void setId_f(int id_f) {
        this.id_f = id_f;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }
}
