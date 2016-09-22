/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package freelancer.entities;

import java.net.URL;

/**
 *
 * @author houssem_tmn
 */
public class Message {
    private String mailAdmin;
    private String passwordAdmin;
    private String objet;
    private String message;
    String url;
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
   
    public String getMailAdmin() {
        return mailAdmin;
    }

    public void setMailAdmin(String mailAdmin) {
        this.mailAdmin = mailAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

  

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
