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
public class cvHandler extends DefaultHandler{
     private Vector cvs;
    String idTag = "close";
    String expTag = "close";
    String langTag = "close";
    String certTag = "close";
    String formTag = "close";
     
    public cvHandler() {
        cvs = new Vector();
    }
    public cv[] getcv() {
        cv[] cvs1 = new cv[cvs.size()];
        cvs.copyInto(cvs1);
        return cvs1;
    }
     private cv currentcv;
              public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
          //ce if vaux dire si enditecte la balise person on cre une personne 
        if (qName.equals("person")) {
            currentcv = new cv();
            //2ème methode pour parser les attributs
            currentcv.setId(attributes.getValue("id_cv"));
            currentcv.setExperience(attributes.getValue("experience_cv"));
            currentcv.setLangue(attributes.getValue("langue_cv"));
            currentcv.setCertification(attributes.getValue("certification_cv"));
            currentcv.setFormation(attributes.getValue("formation_cv"));
            
     
           
                  
            /****/
            
        } else if (qName.equals("id_cv")) {
            
            idTag = "open";
        } else if (qName.equals("experience_cv")) {
            expTag = "open";
        } else if (qName.equals("langue_cv")) {
           langTag= "open";
        }
        else if (qName.equals("certification_cv")) {
           certTag= "open";
        }
        else if (qName.equals("formation_cv")) {
           formTag = "open";
        }
         
    }
               public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("person")) {
            // we are no longer processing a <reg.../> tag
            cvs.addElement(currentcv);
            currentcv = null;
        } else if (qName.equals("id_cv")) {
            idTag = "close";
        } else if (qName.equals("experience_cv")) {
            expTag= "close";
        } else if (qName.equals("langue_cv")){
           langTag = "close";
        }else if (qName.equals("certification_cv")) {
             certTag = "close";
        }else if (qName.equals("formation_cv")) {
            formTag = "close";
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
                if (expTag.equals("open")) {
                String exp = new String(ch, start, length).trim();
                currentcv.setExperience(exp);
            } else
                    if (langTag.equals("open")) {
                String lang = new String(ch, start, length).trim();
                currentcv.setLangue(lang);
            }
            } else
                    if (certTag.equals("open")) {
                String cer = new String(ch, start, length).trim();
                currentcv.setCertification(cer);
            }
            else
                    if (formTag.equals("open")) {
                String form = new String(ch, start, length).trim();
                currentcv.setFormation(form);
            }
             
            
            
        }
}
