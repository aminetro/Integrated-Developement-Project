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
public class MembreHandler extends DefaultHandler {
     private Vector Membres;
    String idTag = "close";
    String nomTag = "close";
    String prenTag = "close";
    String payTag = "close";
    String vilTag = "close";
    String pseuTag = "close";
    String mailTag = "close";
    String societeTag = "close";
    
    public MembreHandler() {
        Membres = new Vector();
    }
      public Membre[] getMembre() {
        Membre[] membres1 = new Membre[Membres.size()];
        Membres.copyInto(membres1);
        return membres1;
    }
        private Membre currentMembre;

          public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
          //ce if vaux dire si enditecte la balise person on cre une personne 
        if (qName.equals("person")) {
            currentMembre = new Membre();
            //2ème methode pour parser les attributs
            currentMembre.setId(attributes.getValue("id"));
            currentMembre.setNom(attributes.getValue("nom"));
            currentMembre.setPrenom(attributes.getValue("prenom"));
            currentMembre.setPays(attributes.getValue("pays"));
            currentMembre.setVille(attributes.getValue("ville"));
            currentMembre.setPseudo(attributes.getValue("pseudo"));
            currentMembre.setMail(attributes.getValue("email"));
             currentMembre.setSociete(attributes.getValue("societe_j"));
     
           
                  
            /****/
            
        } else if (qName.equals("id")) {
            
            idTag = "open";
        } else if (qName.equals("nom")) {
            nomTag = "open";
        } else if (qName.equals("prenom")) {
            prenTag = "open";
        }
        else if (qName.equals("pays")) {
            payTag = "open";
        }
         else if (qName.equals("ville")) {
            vilTag = "open";
        }
         else if (qName.equals("pseudo")) {
            pseuTag = "open";
        }
         else if (qName.equals("email")) {
            mailTag = "open";
        }
         else if (qName.equals("societe_j")) {
            societeTag = "open";
        }
    }
//detecte les balise fermante 
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("person")) {
            // we are no longer processing a <reg.../> tag
            Membres.addElement(currentMembre);
            currentMembre = null;
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("nom")) {
            nomTag = "close";
        } else if (qName.equals("prenom")){
            prenTag = "close";
        }else if (qName.equals("pays")) {
            payTag = "close";
        }else if (qName.equals("ville")) {
            vilTag = "close";
        }else if (qName.equals("pseudo")) {
            pseuTag = "close";
        }else if (qName.equals("email")) {
           mailTag = "close";
        }else if (qName.equals("societe_j")) {
           societeTag = "close";
              }
    }
       public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentMembre != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentMembre.setId(id);
            } else
                if (nomTag.equals("open")) {
                String nom = new String(ch, start, length).trim();
                currentMembre.setNom(nom);
            } else
                    if (prenTag.equals("open")) {
                String pren = new String(ch, start, length).trim();
                currentMembre.setPrenom(pren);
            }
            } else
                    if (payTag.equals("open")) {
                String pay = new String(ch, start, length).trim();
                currentMembre.setPays(pay);
            }
            else
                    if (vilTag.equals("open")) {
                String vil = new String(ch, start, length).trim();
                currentMembre.setVille(vil);
            }
             else
                    if (pseuTag.equals("open")) {
                String pseu = new String(ch, start, length).trim();
                currentMembre.setPseudo(pseu);
            }
            
             else
                    if (mailTag.equals("open")) {
                String mail = new String(ch, start, length).trim();
                currentMembre.setMail(mail);
            }
         else
                    if (societeTag.equals("open")) {
                String mail = new String(ch, start, length).trim();
                currentMembre.setMail(mail);
            }
        }




}
