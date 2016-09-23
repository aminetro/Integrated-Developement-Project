/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Mohamedamine
 */
public class ProjetHandler extends DefaultHandler {
      private Vector Projets;
    String idTag = "close";
    String titreTag = "close";
    String categorieTag = "close";
    String dureeTag = "close";
    String descriptionTag = "close";
    String pseudoJTag = "close";
    String pseudoFTag = "close";  
    
    public ProjetHandler() {
        Projets = new Vector();
    }
     public Projet[] getProjet() {
        Projet[] projets1 = new Projet[Projets.size()];
        Projets.copyInto(projets1);
        return projets1;
    }
     private Projet currentProjet;
     
          public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
          //ce if vaux dire si enditecte la balise person on cre une personne 
        if (qName.equals("person")) {
            currentProjet = new Projet();
            //2ème methode pour parser les attributs
           currentProjet.setId(attributes.getValue("id"));
            currentProjet.setTitre(attributes.getValue("titre_p"));
            currentProjet.setCategorie(attributes.getValue("categorie_p"));
            currentProjet.setDuree(attributes.getValue("duree_p"));
            currentProjet.setDescription(attributes.getValue("description_p"));
            currentProjet.setPseudoJ(attributes.getValue("owner_p"));
            currentProjet.setPseudoF(attributes.getValue("pseudo_f"));
     
           
                  
            /****/
            
        } else if (qName.equals("id")) {
            
            idTag = "open";
        } else if (qName.equals("titre_p")) {
            titreTag = "open";
        } else if (qName.equals("categorie_p")) {
           categorieTag= "open";
        }
        else if (qName.equals("duree_p")) {
           dureeTag = "open";
        }
         else if (qName.equals("description_p")) {
            descriptionTag = "open";
        }
         else if (qName.equals("owner_p")) {
            pseudoJTag= "open";
        }
         else if (qName.equals("pseudo_f")) {
            pseudoFTag = "open";
        }
    }
          
           public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("person")) {
            // we are no longer processing a <reg.../> tag
            Projets.addElement(currentProjet);
            currentProjet = null;
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("titre_p")) {
            titreTag= "close";
        } else if (qName.equals("categorie_p")){
           categorieTag = "close";
        }else if (qName.equals("duree_p")) {
             dureeTag = "close";
        }else if (qName.equals("description_p")) {
            descriptionTag = "close";
        }else if (qName.equals("owner_p")) {
            pseudoJTag= "close";
        }else if (qName.equals("pseudo_f")) {
           pseudoFTag = "close";
              }
    }
        
   
           
           public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentProjet != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentProjet.setId(id);
            } else
                if (titreTag.equals("open")) {
                String titre = new String(ch, start, length).trim();
                currentProjet.setTitre(titre);
            } else
                    if (categorieTag.equals("open")) {
                String categ = new String(ch, start, length).trim();
                currentProjet.setCategorie(categ);
            }
            } else
                    if (dureeTag.equals("open")) {
                String dure = new String(ch, start, length).trim();
                currentProjet.setDuree(dure);
            }
            else
                    if (descriptionTag.equals("open")) {
                String desc = new String(ch, start, length).trim();
                currentProjet.setDescription(desc);
            }
             else
                    if (pseudoJTag.equals("open")) {
                String pseuJ = new String(ch, start, length).trim();
                currentProjet.setPseudoJ(pseuJ);
            }
             else
                    if (pseudoFTag.equals("open")) {
                String pseuF = new String(ch, start, length).trim();
                currentProjet.setPseudoF(pseuF);
            }
            
        }

} 
