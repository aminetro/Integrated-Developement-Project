
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi;

/**
 *
 * @author Mariem
 */
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class JobownerHandler extends DefaultHandler {

    private final Vector jobowners;
    String emailTag = "close";
    String idjTag = "close";
    String societejTag = "close";
    String nomTag = "close";
    String prenomTag = "close";
    String paysTag = "close";
    String villeTag = "close";
    String pseudoTag = "close";

    public JobownerHandler() {
        jobowners = new Vector();
    }

    public Jobowner[] getJobowners() {
        Jobowner[] jobownerss = new Jobowner[jobowners.size()];
        jobowners.copyInto(jobownerss);
        return jobownerss;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Jobowner currentJobowner;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("jobowner")) {
            currentJobowner = new Jobowner();
            //2ème methode pour parser les attributs
            currentJobowner.setId(attributes.getValue("id_j"));
            currentJobowner.setSociete_j(attributes.getValue("societe_j"));
            currentJobowner.setPrenom(attributes.getValue("prenom"));
            currentJobowner.setNom(attributes.getValue("nom"));
            currentJobowner.setEmail(attributes.getValue("email"));
            currentJobowner.setPays(attributes.getValue("pays"));
            currentJobowner.setVille(attributes.getValue("ville"));
            currentJobowner.setPseudo(attributes.getValue("pseudo"));
            /**
             * *
             */

        } else if (qName.equals("id_j")) {
            idjTag = "open";
        } else if (qName.equals("societe_j")) {
            societejTag = "open";

        } else if (qName.equals("prenom")) {
            prenomTag = "open";
        } else if (qName.equals("nom")) {
            nomTag = "open";
        } else if (qName.equals("email")) {
            emailTag = "open";
        } else if (qName.equals("pays")) {
            paysTag = "open";
        } else if (qName.equals("ville")) {
            villeTag = "open";
        } else if (qName.equals("pseudo")) {
            pseudoTag = "open";
        }

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("jobowner")) {
            // we are no longer processing a <reg.../> tag
            jobowners.addElement(currentJobowner);//vecteur de rclamations
            currentJobowner = null;
            //2eme methode
        } else if (qName.equals("id")) {
            idjTag = "close";

        } else if (qName.equals("societe_j")) {
            societejTag = "close";
        } else if (qName.equals("prenom")) {
            prenomTag = "close";
        } else if (qName.equals("nom")) {
            nomTag = "close";
        } else if (qName.equals("email")) {
            emailTag = "close";
        } else if (qName.equals("pays")) {
            paysTag = "close";
        } else if (qName.equals("ville")) {
            villeTag = "close";
        } else if (qName.equals("pseudo")) {
            pseudoTag = "close";
        }
    }
    // "characters" are the text between tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentJobowner != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idjTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentJobowner.setId(id);
            } else if (societejTag.equals("open")) {
                String societe = new String(ch, start, length).trim();
                currentJobowner.setSociete_j(societejTag);
            } else if (prenomTag.equals("open")) {
                String prenom = new String(ch, start, length).trim();
                currentJobowner.setPrenom(prenomTag);
            } else if (nomTag.equals("open")) {
                String nom = new String(ch, start, length).trim();
                currentJobowner.setNom(nomTag);
            } else if (emailTag.equals("open")) {
                String email = new String(ch, start, length).trim();
                currentJobowner.setEmail(emailTag);
            } else if (paysTag.equals("open")) {
                String pays = new String(ch, start, length).trim();
                currentJobowner.setPays(paysTag);
            } else if (villeTag.equals("open")) {
                String ville = new String(ch, start, length).trim();
                currentJobowner.setVille(villeTag);
            } else if (pseudoTag.equals("open")) {
                String pseudo = new String(ch, start, length).trim();
                currentJobowner.setPseudo(pseudoTag);
            }

        }
    }

}
