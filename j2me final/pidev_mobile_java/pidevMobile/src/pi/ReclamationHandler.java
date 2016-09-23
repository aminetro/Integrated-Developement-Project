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


public class ReclamationHandler extends DefaultHandler{
    private final Vector reclamations;
    String idTag = "close";
    String expediteurTag = "close";
    String dateTag = "close";
    String sujetTag = "close";
    String messageTag = "close";

    public ReclamationHandler() {
        reclamations = new Vector();
    }

    public Reclamation[] getReclamation() {
        Reclamation[] reclamationss = new Reclamation[reclamations.size()];
        reclamations.copyInto(reclamationss);
        return reclamationss;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Reclamation currentReclamation;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("reclamation")) {
            currentReclamation = new Reclamation();
            //2ème methode pour parser les attributs
            currentReclamation.setId(attributes.getValue("id"));
            currentReclamation.setExpediteur(attributes.getValue("expediteur"));
            currentReclamation.setDate(attributes.getValue("date"));
            currentReclamation.setSujet(attributes.getValue("sujet"));
            currentReclamation.setMessage(attributes.getValue("message"));
            /****/
            
        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("expediteur")) {
            expediteurTag = "open";
        } else if (qName.equals("date")) {
            dateTag = "open";
        }
        else if (qName.equals("sujet")) {
            sujetTag = "open";
        }
        else if (qName.equals("message")) {
            messageTag = "open";
        }
        
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("reclamation")) {
            // we are no longer processing a <reg.../> tag
            reclamations.addElement(currentReclamation);//vecteur de rclamations
            currentReclamation = null;
            //2eme methode
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("expediteur")) {
            expediteurTag = "close";
        } else if (qName.equals("date")) {
            dateTag = "close";
        }
        else if (qName.equals("sujet")) {
            sujetTag = "close";
        }else if (qName.equals("message")) {
            messageTag = "close";
        }
    }
    // "characters" are the text between tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentReclamation != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentReclamation.setId(id);
            } else
                if (expediteurTag.equals("open")) {
                String exp = new String(ch, start, length).trim();
                currentReclamation.setExpediteur(expediteurTag);
            } else
                    if (dateTag.equals("open")) {
                String date = new String(ch, start, length).trim();
                currentReclamation.setDate(dateTag);
            }
            else
                    if (sujetTag.equals("open")) {
                String sujet = new String(ch, start, length).trim();
                currentReclamation.setSujet(sujetTag);
            }else
                    if (messageTag.equals("open")) {
                String mess = new String(ch, start, length).trim();
                currentReclamation.setMessage(messageTag);
            }
        }
    }
    
}
