package Login;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class LocalisationHandler extends DefaultHandler{
    private Vector localisations;
    String idTag = "close";
    String nomTag = "close";
    String longitudeTag = "close";
    String latitudeTag = "close";
    
    public LocalisationHandler() {
        localisations = new Vector();
    }

    public Localisation[] getLocalisation() {
        Localisation[] localisationss = new Localisation[localisations.size()];
        localisations.copyInto(localisationss);
        return localisationss;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Localisation currentLocalisation;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("person")) {
            currentLocalisation = new Localisation();
            //2ème methode pour parser les attributs
            currentLocalisation.setId(attributes.getValue("id"));
            currentLocalisation.setNom(attributes.getValue("nom"));
            currentLocalisation.setLatitude(attributes.getValue("latitude"));
            currentLocalisation.setLongitude(attributes.getValue("longitude"));
            /****/
            
        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("nom")) {
            nomTag = "open";
        } else if (qName.equals("longitude")) {
            longitudeTag = "open";
        }
        else if (qName.equals("latitude")) {
            latitudeTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("person")) {
            // we are no longer processing a <reg.../> tag
            localisations.addElement(currentLocalisation);
            currentLocalisation = null;
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("nom")) {
            nomTag = "close";
        } else if (qName.equals("longitude")) {
            longitudeTag = "close";
        }
        else if (qName.equals("latitude")) {
            latitudeTag = "close";
        }
    }
    // "characters" are the text between tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentLocalisation != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentLocalisation.setId(id);
            } else
                if (nomTag.equals("open")) {
                String nom = new String(ch, start, length).trim();
                currentLocalisation.setNom(nom);
            } else
                    if (longitudeTag.equals("open")) {
                String longitude = new String(ch, start, length).trim();
                currentLocalisation.setLongitude(longitude);
            }
              else
                    if (latitudeTag.equals("open")) {
                String lat = new String(ch, start, length).trim();
                currentLocalisation.setLatitude(lat);
            }
        }
    }
    
}
