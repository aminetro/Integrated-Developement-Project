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

public class FreelancerHandler extends DefaultHandler {

    private final Vector freelancers;
    String emailTag = "close";
    String idfTag = "close";
    String disponibiliteTag = "close";
    String nomTag = "close";
    String prenomTag = "close";
    String paysTag = "close";
    String villeTag = "close";
    String pseudoTag = "close";

    public FreelancerHandler() {
        freelancers = new Vector();
    }

    public Freelancer[] getFreelancers() {
        Freelancer[] freelancerss = new Freelancer[freelancers.size()];
        freelancers.copyInto(freelancerss);
        return freelancerss;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Freelancer currentFreelancer;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("freelancer")) {
            currentFreelancer = new Freelancer();
            //2ème methode pour parser les attributs
            currentFreelancer.setId_f(attributes.getValue("id_f"));
            currentFreelancer.setNom(attributes.getValue("nom"));
            currentFreelancer.setPrenom(attributes.getValue("prenom"));
            currentFreelancer.setEmail(attributes.getValue("email"));
            currentFreelancer.setPays(attributes.getValue("pays"));
            currentFreelancer.setVille(attributes.getValue("ville"));
            currentFreelancer.setPseudo(attributes.getValue("pseudo"));
            currentFreelancer.setDisponibilite_f(attributes.getValue("disponibilite_f"));
            /**
             * *
             */

        } else if (qName.equals("id_f")) {
            idfTag = "open";
        } 
        else if (qName.equals("nom")) {
            nomTag = "open";
        }
        else if (qName.equals("prenom")) {
            prenomTag = "open";
        }else if (qName.equals("email")) {
            emailTag = "open";
        }   else if (qName.equals("pays")) {
            paysTag = "open";
        } else if (qName.equals("ville")) {
            villeTag = "open";
        } else if (qName.equals("pseudo")) {
            pseudoTag = "open";
        }
        else if (qName.equals("disponibilite_f")) {
            disponibiliteTag = "open";
        } 

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("freelancer")) {
            // we are no longer processing a <reg.../> tag
            freelancers.addElement(currentFreelancer);//vecteur de freelancers
            currentFreelancer = null;
            //2eme methode
        } else if (qName.equals("id_f")) {
            idfTag = "close";
        } 
        else if (qName.equals("nom")) {
            nomTag = "close";
        }
        else if (qName.equals("prenom")) {
            prenomTag = "close";
        }else if (qName.equals("email")) {
            emailTag = "close";
        }   else if (qName.equals("pays")) {
            paysTag = "close";
        } else if (qName.equals("ville")) {
            villeTag = "close";
        } else if (qName.equals("pseudo")) {
            pseudoTag = "close";
        }
        else if (qName.equals("disponibilite_f")) {
            disponibiliteTag = "close";
        }
    }
    // "characters" are the text between tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentFreelancer != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idfTag.equals("open")) {
                String id_f = new String(ch, start, length).trim();
                currentFreelancer.setId_f(id_f);    
            }
            else if (nomTag.equals("open")) {
                String nom = new String(ch, start, length).trim();
                currentFreelancer.setNom(nomTag);
            } else if (prenomTag.equals("open")) {
                String prenom = new String(ch, start, length).trim();
                currentFreelancer.setPrenom(prenomTag);
            }else if (emailTag.equals("open")) {
                String email = new String(ch, start, length).trim();
                currentFreelancer.setEmail(emailTag);
            }  else if (paysTag.equals("open")) {
                String pays = new String(ch, start, length).trim();
                currentFreelancer.setPays(paysTag);
            } else if (villeTag.equals("open")) {
                String ville = new String(ch, start, length).trim();
                currentFreelancer.setVille(villeTag);
            } else if (pseudoTag.equals("open")) {
                String pseudo = new String(ch, start, length).trim();
                currentFreelancer.setPseudo(pseudoTag);
            }
            else if (disponibiliteTag.equals("open")) {
                String disponibilite = new String(ch, start, length).trim();
                currentFreelancer.setDisponibilite_f(disponibiliteTag);
            } 

        }
    }

}
