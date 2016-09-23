/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.util.Date;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Mohamedamine
 */
public class candidatureHandler extends DefaultHandler{
     private Vector cans;
    String idTag = "close";
    String id_pTag = "close";
    String pseufreelancerTag = "close";
    String estimationTag = "close";
    String lettre_motTag = "close";
    String questionTag = "close"; 
     
    public candidatureHandler() {
        cans = new Vector();
    }
    public candidature[] getcandidature() {
        candidature[] cvs1 = new candidature[cans.size()];
        cans.copyInto(cvs1);
        return cvs1;
    }
      private candidature currentcv;
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
          //ce if vaux dire si enditecte la balise person on cre une personne 
        if (qName.equals("person")) {
            currentcv = new candidature();
            //2ème methode pour parser les attributs
            currentcv.setId(attributes.getValue("id"));
            currentcv.setIdp(attributes.getValue("id_p"));
            currentcv.setPseufreelancer(attributes.getValue("pseufreelancer"));
            currentcv.setEstimation(attributes.getValue("estimation"));
            currentcv.setLettre_mot(attributes.getValue("lettre_mot"));
            currentcv.setQuestion(attributes.getValue("question"));
            
     
           
                  
            /****/
            
        } else if (qName.equals("id")) {
            
            idTag = "open";
        } else if (qName.equals("id_p")) {
            id_pTag = "open";
        } else if (qName.equals("pseufreelancer")) {
           pseufreelancerTag= "open";
        }
        else if (qName.equals("estimation")) {
           estimationTag= "open";
        }
        else if (qName.equals("lettre_mot")) {
           lettre_motTag = "open";
        }
          else if (qName.equals("question")) {
           questionTag = "open";
        }
         
    }
               public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("person")) {
            // we are no longer processing a <reg.../> tag
            cans.addElement(currentcv);
            currentcv = null;
        } else if (qName.equals("id_cv")) {
            idTag = "close";
        } else if (qName.equals("id_p")) {
            id_pTag= "close";
        } else if (qName.equals("pseufreelancer")){
           pseufreelancerTag = "close";
        }else if (qName.equals("estimation")) {
             estimationTag = "close";
        }else if (qName.equals("lettre_mot")) {
            lettre_motTag = "close";
        }else if (qName.equals("question")) {
            questionTag = "close";
        }
    }
               
                
           public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentcv != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentcv.setId(id);
            } else
                if (id_pTag.equals("open")) {
                String exp = new String(ch, start, length).trim();
                currentcv.setIdp(exp);
            } else
                    if (pseufreelancerTag.equals("open")) {
                String lang = new String(ch, start, length).trim();
                currentcv.setPseufreelancer(lang);
            }
            } else
                    if (estimationTag.equals("open")) {
                String cer = new String(ch, start, length).trim();
                currentcv.setEstimation(cer);
            }
            else
                    if (lettre_motTag.equals("open")) {
                String form = new String(ch, start, length).trim();
                currentcv.setLettre_mot(form);
            }
             
             else
                    if (questionTag.equals("open")) {
                String form = new String(ch, start, length).trim();
                currentcv.setQuestion(form);
            }
            
        }
}
