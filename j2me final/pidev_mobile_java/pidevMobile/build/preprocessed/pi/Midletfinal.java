/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pi;

import javax.microedition.midlet.*;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import javax.microedition.midlet.*;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


/**
 * @author sou hm
 */
public class Midletfinal extends MIDlet implements CommandListener, Runnable{
  private Player player = null;
    private Player player2 = null;
    Display disp = Display.getDisplay(this);
    Image img;
    private Image image;
    String urlSJOB = "http://localhost/pidev_mobile/jobownerA/suppression.php";
    String urlSFREE = "http://localhost/pidev_mobile/freelancerA/suppression.php";
    String url = "http://localhost/pidev_mobile/Administrateur/suppression.php";
 Alert connectionOk;
   
   Alert connectionKo;
   
    Form fLogin = new Form("Authentification");
    TextField tfLogin = new TextField("Username : ", null, 100, TextField.ANY);
    TextField tfPass = new TextField("Password :", null, 100, TextField.PASSWORD);
    Command cmdlogin = new Command("valider", Command.SCREEN, 0);
    
   
   
    List lstAfficherJobowner = new List("Liste des Jobowners", List.IMPLICIT);
    List lstAfficherFreelancer = new List("Afficher Freelancer", List.IMPLICIT);
    Form fgestionuser = new Form("Accueil affichage ");
    Form formAfficherJobowner = new Form("Infos Jobowner");
    Form formAfficherFreelancer = new Form("Infos Freelancer");
    Form loadingDialog = new Form("Please Wait");
    Form formAfficherAdmin = new Form("Infos Administrateur");
    Form modifierAdmin = new Form("Modifier profil");
    List lstAfficherAdmin = new List("Afficher Administrateur", List.IMPLICIT);
    DataInputStream dataInputStream; //objet pour lire un flux de données

    Form fAfficher = new Form("Gestion  Admin ");
    Form fErreur = new Form("Erreur");

    StringBuffer sb = new StringBuffer();
    StringBuffer sb2 = new StringBuffer();
    StringBuffer sb3 = new StringBuffer();
    StringBuffer sb4 = new StringBuffer();
    private final Ticker ticker;
    private final Ticker ticker1;
    String action;
    int y;
    HttpConnection hc;
    DataInputStream dis;
    Membre[] membres;

    Alert erreur = new Alert("Error", "Sorry", null, AlertType.ERROR);
    Command cmdsupprimer = new Command("Supprimer ", Command.SCREEN, 1);

    Command cmdParseAdmin = new Command("Afficher Admin", Command.OK, 1);
    Command cmdAjoutAdmin = new Command("Ajouter Admin", Command.OK, 1);
    Command cmdAdminModidfier = new Command("Modifier ", Command.SCREEN, 1);
    Command cmdAdminsupprimer = new Command("Supprimer ", Command.SCREEN, 1);
    Command valider = new Command("Valider ", Command.SCREEN, 1);
    Command cmdParseJobowner = new Command("Jobowner", Command.SCREEN, 0);
    Command sms = new Command("Contacter", Command.SCREEN, 1);
    Command sms1 = new Command("Contacter", Command.SCREEN, 1);
    Command cmdParseFreelancer = new Command("freelancer", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);

    Form ajoutAdmin = new Form("AjoutAdmin");
    TextField tfNom = new TextField("nom", null, 100, TextField.ANY);
    TextField tfPrenom = new TextField("prenom", null, 100, TextField.ANY);
    TextField tfPays = new TextField("pays", null, 100, TextField.ANY);
    TextField tfVille = new TextField("ville", null, 100, TextField.ANY);
    TextField tfPseudo = new TextField("pseudo", null, 100, TextField.ANY);
    TextField tfPassword = new TextField("password", null, 100, TextField.ANY);
    TextField tfMail = new TextField("mail", null, 100, TextField.ANY);

    TextField tfMNom = new TextField("nom", null, 100, TextField.ANY);
    TextField tfMPrenom = new TextField("prenom", null, 100, TextField.ANY);
    TextField tfMPays = new TextField("pays", null, 100, TextField.ANY);
    TextField tfMVille = new TextField("ville", null, 100, TextField.ANY);
    TextField tfMPseudo = new TextField("pseudo", null, 100, TextField.ANY);
    TextField tfMPassword = new TextField("password", null, 100, TextField.ANY);
    TextField tfMMail = new TextField("mail", null, 100, TextField.ANY);

    Command cmdValider = new Command("valider", Command.SCREEN, 0);
    Alert alerta = new Alert("Error", "Sorry", null, AlertType.ERROR);
    Alert alert = new Alert("Error", "Sorry", null, AlertType.ERROR);
    String url1 = "http://localhost/pidev_mobile/Administrateur/ajout.php";

    Form acceuil = new Form("acceuil");
    Command admin = new Command("admin ", Command.SCREEN, 1);
    Command supera = new Command("super ", Command.SCREEN, 1);

    MessageConnection clientConn;
    Form compose = new Form("Compose Message");
    Form compose1 = new Form("Compose Message");
    TextField toWhom = new TextField("To", "", 10, TextField.PHONENUMBER);
    TextField message = new TextField("Message", "", 600, TextField.ANY);
    Command send = new Command("Send", Command.BACK, 0);
    TextField toWhom1 = new TextField("To", "", 10, TextField.PHONENUMBER);
    TextField message1 = new TextField("Message", "", 600, TextField.ANY);
    Command send1 = new Command("Send", Command.BACK, 0);
    Command exit = new Command("Exit", Command.SCREEN, 5);
    List lstRechJob = new List("Jobowners", List.IMPLICIT);
    int size;
    byte[] data;

    
    
    /*meriem*/
    
    
     Command cmdAffichRecMA = new Command("Afficher Reclamations", Command.SCREEN, 0);
    Command cmdBackMA = new Command("Back", Command.BACK, 0);
    Reclamation[] reclamations;
    List lstRec = new List("Reclamations", List.IMPLICIT);
    Form f = new Form("Accueil");
    Form formAffichRec = new Form("Infos Reclamation");
    Form formRechJob = new Form("Infos Jobowners");
    
     String tfrecherche;

    TextField expMA = new TextField("Expediteur", null, 100, TextField.ANY);

   
    Command cmdAffichJobMA = new Command("Afficher Jobowners", Command.SCREEN, 0);
   
    Jobowner[] jobowners;
    TextField pseuMAA = new TextField("Nom/Pseudo", null, 100, TextField.ANY);

  

    
    
    
   
    Reclamation[] reclamation;
    List lstRechRec = new List("Rechercher", List.IMPLICIT);
   Command cmdrechercheA = new Command("Rechercher", Command.SCREEN, 0);
    Form formRechRec = new Form("Infos Reclamation");
    Command rechercherjob = new Command("rechercher", Command.SCREEN, 1);
    Command rechercherfree = new Command("rechercher", Command.SCREEN, 1);
     
    Form f2 = new Form("Accueil");
    
     Command cmdAfficheFreeMA = new Command("Afficher Freelancers", Command.SCREEN, 0);
   
    Freelancer[] freelancers;
    List lstRechFree = new List("Freelancers", List.IMPLICIT);
    Form f3 = new Form("Accueil");
    Form formRechFreeMA = new Form("Infos Freelancer");
    
    TextField pseuMA = new TextField("Nom/Pseudo", null, 100, TextField.ANY);
    

    
    
    
    public Midletfinal() {

        disp = Display.getDisplay(this);
        ticker = new Ticker("Veuillez appuier sur le bouton admin pour afficher la liste");
        ticker1 = new Ticker("Veuillez séllectionner un utilisareur pour afficher plus de détails");
        fAfficher.setTicker(ticker);
       
        lstAfficherAdmin.setTicker(ticker1);

    }

    public void startApp() {
        
        connectionOk=new Alert("Login Ok", "votre session est ouverte correctement", null, AlertType.INFO);
        connectionKo=new Alert("Login Ko", "les donnees que vous avez entrees sont incorrectes", null, AlertType.INFO);
          fLogin.append(tfLogin);
        fLogin.append(tfPass);
        fLogin.addCommand(cmdlogin);

        fLogin.setCommandListener(this);
       // compose.append(toWhom);
        compose.append(message);
        compose.addCommand(send);
        compose.addCommand(cmdBack);
        compose.setCommandListener(this);

        compose1.append(message1);
        compose1.addCommand(send1);
        compose1.addCommand(cmdBack);
        compose1.setCommandListener(this);

        fgestionuser.append("Selectionez une action ");
        fgestionuser.addCommand(cmdParseJobowner);
        fgestionuser.setCommandListener(this);
        fgestionuser.addCommand(cmdBack);
        fgestionuser.addCommand(cmdParseFreelancer);
        fgestionuser.addCommand(sms);
        fgestionuser.addCommand(cmdAffichRecMA);
        fgestionuser.setCommandListener(this);

        lstAfficherJobowner.addCommand(cmdBack);
        lstAfficherJobowner.addCommand(rechercherjob);
        lstAfficherJobowner.setCommandListener(this);

        lstAfficherFreelancer.addCommand(cmdBack);
        lstAfficherFreelancer.addCommand(rechercherfree);
        lstAfficherFreelancer.setCommandListener(this);

        formAfficherJobowner.addCommand(cmdBack);
        formAfficherJobowner.addCommand(cmdsupprimer);
    

        formAfficherJobowner.setCommandListener(this);

        formAfficherFreelancer.addCommand(cmdBack);
        formAfficherFreelancer.addCommand(cmdsupprimer);
       
        formAfficherFreelancer.setCommandListener(this);

        fAfficher.addCommand(cmdAjoutAdmin);
        fAfficher.addCommand(cmdParseAdmin);
        fAfficher.addCommand(cmdBack);
        fAfficher.setCommandListener(this);

        lstAfficherAdmin.addCommand(cmdBack);
        lstAfficherAdmin.setCommandListener(this);

        formAfficherAdmin.addCommand(cmdAdminModidfier);
        formAfficherAdmin.addCommand(cmdAdminsupprimer);
        formAfficherAdmin.addCommand(cmdBack);
        formAfficherAdmin.addCommand(sms);

        formAfficherAdmin.setCommandListener(this);

        ajoutAdmin.append(tfNom);
        ajoutAdmin.append(tfPrenom);
        ajoutAdmin.append(tfPays);
        ajoutAdmin.append(tfVille);
        ajoutAdmin.append(tfPseudo);
        ajoutAdmin.append(tfPassword);
        ajoutAdmin.append(tfMail);

        ajoutAdmin.addCommand(cmdValider);
        ajoutAdmin.setCommandListener(this);
        ajoutAdmin.addCommand(cmdBack);
        ajoutAdmin.setCommandListener(this);

        modifierAdmin.append(tfMNom);
        modifierAdmin.append(tfMPrenom);
        modifierAdmin.append(tfMPays);
        modifierAdmin.append(tfMVille);
        modifierAdmin.append(tfMPseudo);
        modifierAdmin.append(tfMMail);
        modifierAdmin.addCommand(cmdBack);
        modifierAdmin.addCommand(valider);
        modifierAdmin.setCommandListener(this);
        
        acceuil.addCommand(admin);
        acceuil.addCommand(supera);
        acceuil.setCommandListener(this);
        disp.setCurrent(fLogin);
      
        
        
        
        
        
        
         f.append("Veuillez cliquer sur la reclamation pour afficher ses informations");
        f.addCommand(cmdAffichRecMA);
        f.setCommandListener(this);
        lstRec.setCommandListener(this);
        lstRec.addCommand(cmdBackMA);
        formAffichRec.addCommand(cmdBackMA);
        formAffichRec.setCommandListener(this);
       formRechRec.addCommand(cmdBackMA);
        formRechRec.setCommandListener(this);
     
         f2.append("Entrer Le pseudo du Jobowner ");
        f2.append(pseuMAA);
        f2.addCommand(cmdAffichJobMA);
        f2.setCommandListener(this);
        lstRechJob.addCommand(cmdBackMA);
        lstRechJob.setCommandListener(this);
        formRechJob.addCommand(cmdBack);
        formRechJob.setCommandListener(this);
       
            
        
        
         f3.append("Entrer Le pseudo du freelancer ");

        f3.append(pseuMA);
        f3.addCommand(cmdAfficheFreeMA);
        f3.setCommandListener(this);
        lstRechFree.addCommand(cmdBackMA);
        lstRechFree.setCommandListener(this);
        formRechFreeMA.addCommand(cmdBackMA);
        formRechFreeMA.setCommandListener(this);
       
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        // à remplacé par l'authentification
        if (c == cmdlogin) {
            action="login";
            Thread th = new Thread(this);
            th.start();
        }
       
        
        if(c==rechercherjob ){
            disp.setCurrent(f2);
        }
        if(c==cmdBack && d==lstRechRec){
            disp.setCurrent(f2);
        }
        
        if (c == cmdBack && d == fAfficher) {
            disp.setCurrent(fLogin);
        }
        if (c == cmdBack && d == fgestionuser) {
            disp.setCurrent(fLogin);
        }

        //affichage du freelancer et jobownerss
        if (c == cmdParseJobowner) {
            disp.setCurrent(loadingDialog);
            action = "afficherJobowner";
            Thread th = new Thread((Runnable) this);
            th.start();
            disp.setCurrent(lstAfficherJobowner);
        }

        if (c == cmdParseFreelancer) {
            disp.setCurrent(loadingDialog);
            action = "afficherfreelancer";
            Thread th = new Thread((Runnable) this);
            th.start();
            disp.setCurrent(lstAfficherFreelancer);
        }


        if (c == cmdBack && d == formAfficherJobowner) {
            formAfficherJobowner.deleteAll();

            disp.setCurrent(lstAfficherJobowner);
        }
        if (c == cmdBack && d == lstAfficherJobowner) {
            lstAfficherJobowner.deleteAll();

            disp.setCurrent(fgestionuser);
        }
        if (c == cmdBack && d == lstAfficherFreelancer) {
            lstAfficherFreelancer.deleteAll();

            disp.setCurrent(fgestionuser);
        }
        
      
        if (c == cmdBack && d == ajoutAdmin) {

            disp.setCurrent(fAfficher);

        }

        if (c == cmdBack && d == formAfficherFreelancer) {
            action = "afficherJobowner";
            formAfficherFreelancer.deleteAll();

            disp.setCurrent(lstAfficherFreelancer);
        }
        if (c == cmdBack && d == lstAfficherFreelancer) {
            lstAfficherFreelancer.deleteAll();

            disp.setCurrent(fgestionuser);
        }
        //supprission du freelancer et jobowner
        if (c == cmdsupprimer && d == formAfficherFreelancer) {
            action = "supprimerfreelancer";
            Thread th = new Thread(this);
            th.start();

        }
        if (c == cmdsupprimer && d == formAfficherJobowner) {
            action = "supprimreJobowner";
            Thread th = new Thread(this);
            th.start();

        }
         if (c == List.SELECT_COMMAND && d == lstAfficherJobowner) {
            formAfficherJobowner.append("Informations Jobowner: \n");
            formAfficherJobowner.append(showJobowner(lstAfficherJobowner.getSelectedIndex()));
            disp.setCurrent(formAfficherJobowner);
        }

        if (c == List.SELECT_COMMAND && d == lstAfficherFreelancer) {
            formAfficherFreelancer.append("Informations Freelancer: \n");
            formAfficherFreelancer.append(showJobowner(lstAfficherFreelancer.getSelectedIndex()));
            disp.setCurrent(formAfficherFreelancer);
        }
                 if(c==cmdBack && d==formAfficherJobowner){
                     disp.setCurrent(lstAfficherJobowner);
                 }
                 
                 if(c==cmdBack && d==formAfficherFreelancer){
                     disp.setCurrent(lstAfficherFreelancer);
                 }
        //affichage de l'admin
        if (c == cmdParseAdmin) {
            disp.setCurrent(loadingDialog);
            action = "afficherAdmin";
            Thread thA = new Thread((Runnable) this);
            thA.start();
            disp.setCurrent(lstAfficherAdmin);

        }

        if (c == List.SELECT_COMMAND) {
            formAfficherAdmin.append("Informations Administrateur : \n");
            formAfficherAdmin.append(showAdmin(lstAfficherAdmin.getSelectedIndex()));
            disp.setCurrent(formAfficherAdmin);

        }

        if (c == cmdBack && d == formAfficherAdmin) {
            formAfficherAdmin.deleteAll();

            disp.setCurrent(lstAfficherAdmin);
        }
        if (c == cmdBack && d == lstAfficherAdmin) {
            lstAfficherAdmin.deleteAll();

            disp.setCurrent(fAfficher);

        }
        if (c == cmdBack && d == modifierAdmin) {
            modifierAdmin.deleteAll();
            disp.setCurrent(lstAfficherAdmin);
        }

        if (c == cmdAdminsupprimer) {
            action = "supprimerAdmin";
            Thread th = new Thread(this);
            th.start();

        }
        if (c == cmdAjoutAdmin) {
            disp.setCurrent(ajoutAdmin);
        }

        if (c == cmdValider) {
            action = "ajouterAdmin";
            Thread th = new Thread(this);
            th.start();

        }

        if (c == cmdAdminModidfier) {

            tfNom.setString("");
            tfPrenom.setString("");
            tfPays.setString("");
            tfVille.setString("");
            tfPseudo.setString("");
            tfMail.setString("");

            tfMNom.insert(membres[0].getNom(), 0);
            tfMPrenom.insert(membres[0].getPrenom(), 0);
            tfMPays.insert(membres[0].getPays(), 0);
            tfMVille.insert(membres[0].getVille(), 0);
            tfMPseudo.insert(membres[0].getPseudo(), 0);
            tfMMail.insert(membres[0].getEmail(), 0);

            disp.setCurrent(modifierAdmin);

        }
        if (c == valider) {
            action = "modifierAdmin";
            Thread th = new Thread(this);
            th.start();
        }

        //envoi du sms
        if (c == cmdBack && d==compose) {
            disp.setCurrent(formAfficherAdmin);
        }
        if (c == send) {
            action = "Envoisms";
            Thread th = new Thread(this);
            th.start();
        }
        if (c == sms) {
            disp.setCurrent(compose);
        }
        if (c == cmdBack && d==compose1) {
            disp.setCurrent(fgestionuser);
        }
        if (c == send1) {
            action = "EnvoismsSuper";
            Thread th = new Thread(this);
            th.start();
        }
        if (c == sms1) {
            disp.setCurrent(compose1);
        }
   
    
        
        
    
       if (c == cmdAffichRecMA) {
            disp.setCurrent(loadingDialog);
            action="afficherReclamation";
            Thread th = new Thread(this);
            th.start();
        }

        if (c == List.SELECT_COMMAND) {
            formAffichRec.append("Voilà la reclamation: \n");
            formAffichRec.append(showReclamation(lstRec.getSelectedIndex()));
            disp.setCurrent(formAffichRec);
        }

        if (c == cmdBackMA && d==formAffichRec ) {
            formAffichRec.deleteAll();
            disp.setCurrent(lstRec);
        }
           if (c==cmdBackMA && d==lstRec)
        {
          disp.setCurrent(f);
        }
         if (c == cmdrechercheA) {
            disp.setCurrent(loadingDialog);
            action="rechercherReclamation";
            Thread th = new Thread(this);
            th.start();
        }

        if (c == List.SELECT_COMMAND) {
            formAffichRec.append("Voilà la reclamation: \n");
            formAffichRec.append(showReclamation(lstRec.getSelectedIndex()));
            disp.setCurrent(formAffichRec);
        }

     
        if (c == cmdBackMA && d==formRechRec) {
            formRechRec.deleteAll();
            disp.setCurrent(lstRechRec);
        }
          if (c==cmdBack && d==lstRechRec)
        {
          disp.setCurrent(f);
        }
          
          if (c == cmdAffichJobMA) {
              action="rj";
            disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }

        if (c == List.SELECT_COMMAND) {
            formRechJob.append("Voilà les infos du jobowner cherché: \n");
            formRechJob.append(showJobowner1(lstRechJob.getSelectedIndex()));
            disp.setCurrent(formRechJob);
        }

        if (c == cmdBack && d==formRechJob) {
            formRechJob.deleteAll();
            disp.setCurrent(lstRechJob);
        }
        if (c == cmdBackMA && d == lstRechJob) {
            disp.setCurrent(f);
        }
        
        
        
        
         if (c == cmdAfficheFreeMA) {
             action="rfreelancer";
            disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }

        if (c == List.SELECT_COMMAND) {
            formRechFreeMA.append("Voilà les infos du Freelancer cherché: \n");
            formRechFreeMA.append(showFreelancer(lstRechFree.getSelectedIndex()));
            disp.setCurrent(formRechFreeMA);
        }

        if (c == cmdBackMA && d==formRechFreeMA) {
            formRechFreeMA.deleteAll();
            disp.setCurrent(lstRechFree);
        }
          if (c==cmdBackMA && d==lstRechFree)
        {
          disp.setCurrent(f);
        }

    
    
    
    if(c==rechercherfree){
        disp.setCurrent(f3);
    }
    
    
    }

    public void run() {
        if(action=="login"){
        try {
            int ch;
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/loginAdmin.php"+"?login="+tfLogin.getString().trim()
                                        +"&pass="+tfPass.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("admin".equals(sb.toString().trim())) {
                    disp.setCurrent(connectionOk, fgestionuser);
                    try {
                        player2 = Manager.createPlayer(getClass().getResourceAsStream("/audio/welcome.wav"), "audio/x-wav");
                     player2.setLoopCount(1);
            player2.start();
          //  Thread.sleep(10000);//set for 5 seconds
           player.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (MediaException ex) {
                        ex.printStackTrace();
                    
                    }
                }else if ("super".equals(sb.toString().trim())) {
                    
                    disp.setCurrent(connectionOk, fAfficher);
                    try {
                        player2 = Manager.createPlayer(getClass().getResourceAsStream("/audio/welcome.wav"), "audio/x-wav");
                     player2.setLoopCount(1);
            player2.start();
          //  Thread.sleep(10000);//set for 5 seconds
           player.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (MediaException ex) {
                        ex.printStackTrace();
                    
                    }
                }else{
                    disp.setCurrent(connectionKo, fLogin);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
        if (action.equals("afficherJobowner")) {
            AfficherJobowner();
        }
        if (action.equals("afficherfreelancer")) {
            Afficherfreelancer();
        }
        if (action.equals("supprimerfreelancer")) {
            supprimerfreelancer();
        }
        if (action.equals("supprimreJobowner")) {
            supprimerJobonwer();
        }
        if (action.equals("afficherAdmin")) {
            afficherAdmin();
        }
        if (action.equals("supprimerAdmin")) {
            SupprimerAdmin();
        }
        if (action.equals("ajouterAdmin")) {
            AjouterAdmin();
        }
        if (action.equals("Envoisms")) {
            envoisms();
        }
        if (action.equals("modifierAdmin")) {
            ModifierAdmin();
        }
         if (action.equals("EnvoismsSuper")) {
            EnvoismsSuper();
        }
         
         
         
         if (action.equals("afficherReclamation")) {
             try { 
            // this will handle our XML
            ReclamationHandler reclamationsHandler = new ReclamationHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/parsing2/getXmlReclamations_Attributes.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, reclamationsHandler);
            // display the result
            reclamations = reclamationsHandler.getReclamation();

            if (reclamations.length > 0) {
                for (int i = 0; i < reclamations.length; i++) {
                    lstRec.append(reclamations[i].getExpediteur()+" "
                            +reclamations[i].getMessage()+reclamations[i].getDate()+reclamations[i].getSujet()+reclamations[i].getMessage(), null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(lstRec);
        }

         
      if(action.equals("rechercherReclamation")){
           try {
            // this will handle our XML
            ReclamationHandler reclamationsHandler = new ReclamationHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/parsing2/getXmlFreelancers_RechercheAttributes.php" + "?tfrecherche=" + expMA.getString());
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, reclamationsHandler);
            // display the result
            reclamation = reclamationsHandler.getReclamation();

            if (reclamation.length > 0) {
                for (int i = 0; i < reclamation.length; i++) {
                    lstRechRec.append(reclamation[i].getExpediteur() + " "
                            + reclamation[i].getMessage() + reclamation[i].getDate() + reclamation[i].getSujet() + reclamation[i].getMessage(), null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(lstRechRec);
      }
       
   if(action.equals("rj")) {
          try {
            // this will handle our XML
            JobownerHandler jobownersHandler = new JobownerHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/parsing2/getXmlJobowners_RechercheAttributes.php" + "?tfrecherche=" + pseuMAA.getString());
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, jobownersHandler);
            // display the result
            jobowners = jobownersHandler.getJobowners();

            if (jobowners.length > 0) {
                for (int i = 0; i < jobowners.length; i++) {
                    lstRechJob.append(jobowners[i].getPrenom() + " "
                            + jobowners[i].getNom() + jobowners[i].getEmail() + jobowners[i].getPays() + jobowners[i].getVille() + jobowners[i].getPseudo() + jobowners[i].getSociete_j(), null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(lstRechJob);
   }  
   
   if(action.equals("rfreelancer")){
         try {
            // this will handle our XML
            FreelancerHandler freelancersHandler = new FreelancerHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/parsing2/getXmlFreelancers_RechercheAttributes.php" + "?tfrecherche=" + pseuMA.getString());
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, freelancersHandler);
            // display the result
            freelancers = freelancersHandler.getFreelancers();

            if (freelancers.length > 0) {
                for (int i = 0; i < freelancers.length; i++) {
                    lstRechFree.append(freelancers[i].getPrenom() + " "
                            + freelancers[i].getNom() + freelancers[i].getEmail() + freelancers[i].getPays() + freelancers[i].getVille() + freelancers[i].getPseudo() + freelancers[i].getDisponibilite_f(), null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(lstRechFree);
   }
      
      
      
    }
    
    
    
    private String showReclamation(int i) {
        String res = "";
        if (reclamations.length > 0) {
            sb.append("Expediteur :");
           
            sb.append(reclamations[i].getExpediteur());
            sb.append("\n");
            sb.append("Date: ");
            sb.append(reclamations[i].getDate());
            sb.append("\n");
             sb.append("Sujet: ");
             sb.append(reclamations[i].getSujet());
            sb.append("\n");
             sb.append("Messsage: ");
             sb.append(reclamations[i].getMessage());
            sb.append("\n");
             
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
        
        
        
        
    }
    
       private String showJobowner1(int i) {
        String res = "";
        if (jobowners.length > 0) {
            sb.append("Prenom :");

            sb.append(jobowners[i].getPrenom());
            sb.append("\n");
            sb.append("Nom: ");
            sb.append(jobowners[i].getNom());
            sb.append("\n");
            sb.append("Emailt: ");
            sb.append(jobowners[i].getEmail());
            sb.append("\n");
            sb.append("Pays: ");
            sb.append(jobowners[i].getPays());
            sb.append("\n");
            sb.append("Ville: ");
            sb.append(jobowners[i].getVille());
            sb.append("\n");
            sb.append("Pseudo: ");
            sb.append(jobowners[i].getPseudo());
            sb.append("\n");
            sb.append("Societe: ");
            sb.append(jobowners[i].getSociete_j());
            sb.append("\n");

        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
    

    public String showJobowner(int i) {
        String res = "";
        if (membres.length > 0) {
            sb.append("*  Id : ");
            sb.append(membres[i].getId());
            sb.append("\n");
            sb.append("* Prenom : ");
            sb.append(membres[i].getPrenom());
            sb.append("\n");
            sb.append("* Nom :  ");
            sb.append(membres[i].getNom());
            sb.append("\n");
            sb.append("* Pays :  ");
            sb.append(membres[i].getPays());
            sb.append("\n");
            sb.append("* Ville : ");
            sb.append(membres[i].getVille());
            sb.append("\n");
            sb.append("* Pseudo :  ");
            sb.append(membres[i].getPseudo());
            sb.append("\n");
            sb.append("* Mail : ");
            sb.append(membres[i].getEmail());
            sb.append("\n");
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }

    private String showAdmin(int i) {
        String res = "";

        {

            if (membres.length > 0) {
                sb.append("*  Id : ");
                sb.append(membres[i].getId());
                sb.append("\n");
                sb.append("* Prenom : ");
                sb.append(membres[i].getPrenom());
                sb.append("\n");
                sb.append("* Nom :  ");
                sb.append(membres[i].getNom());
                sb.append("\n");
                sb.append("* Pays :  ");
                sb.append(membres[i].getPays());
                sb.append("\n");
                sb.append("* Ville : ");
                sb.append(membres[i].getVille());
                sb.append("\n");
                sb.append("* Pseudo :  ");
                sb.append(membres[i].getPseudo());
                sb.append("\n");
                sb.append("* Mail : ");
                sb.append(membres[i].getEmail());
                sb.append("\n");

            }
            res = sb.toString();
            sb = new StringBuffer("");
            return res;
        }
    }

    public void afficherAdmin() {
        try {
            formAfficherAdmin.deleteAll();
            lstAfficherAdmin.deleteAll();

            SAXParser parsAdmin = SAXParserFactory.newInstance().newSAXParser();
            MembreHandler AdminHandler = new MembreHandler();
            HttpConnection hcAdmin = (HttpConnection) Connector.open("http://localhost/pidev_mobile/Administrateur/getXmlAdmin_Attributes.php");
            DataInputStream disAdmin = new DataInputStream(hcAdmin.openDataInputStream());
            parsAdmin.parse(disAdmin, AdminHandler);
            // display the result
            membres = AdminHandler.getMembre();

            if (membres.length > 0) {
                for (int i = 0; i < membres.length; i++) {
                    lstAfficherAdmin.append(membres[i].getNom() + " "
                            + membres[i].getPrenom(), null);
                }
            }

        } catch (ParserConfigurationException e) {
            System.out.println("Exception:" + e.toString());
        } catch (SAXException e) {
            System.out.println("Exception:" + e.toString());
        } catch (IOException e) {
            System.out.println("Exception:" + e.toString());
        }
    }

    public void AjouterAdmin() {
        try {
            hc = (HttpConnection) Connector.open(url1 + "?nom=" + tfNom.getString().trim() + "&prenom=" + tfPrenom.getString().trim()
                    + "&pays=" + tfPays.getString().trim() + "&ville=" + tfVille.getString().trim() + "&pseudo=" + tfPseudo.getString().trim()
                    + "&password=" + tfPassword.getString().trim() + "&email=" + tfMail.getString().trim());
            dis = new DataInputStream(hc.openDataInputStream());
            while ((y = dis.read()) != -1) {
                sb.append((char) y);
            }
            if ("OK".equals(sb.toString().trim())) {
                disp.setCurrent(fAfficher);

            } else {
                disp.setCurrent(fAfficher);

            }
            sb = new StringBuffer();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void AfficherJobowner() {
        try {
            formAfficherJobowner.deleteAll();
            lstAfficherJobowner.deleteAll();
            // this will handle our XML
            // c'est une classe qui utilise le parseur pour desassembler le flus recue
            //sax qui est importer est un parseur xml
            MembreHandler JobownHandler = new MembreHandler();
            // get a parser object
            SAXParser parsJobown = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hcJobown = (HttpConnection) Connector.open("http://localhost/pidev_mobile/jobownerA/AfficherJobowner_attribut.php");
            DataInputStream disJobown = new DataInputStream(hcJobown.openDataInputStream());
            parsJobown.parse(disJobown, JobownHandler);
            // display the result
            membres = JobownHandler.getMembre();

            if (membres.length > 0) {
                for (int i = 0; i < membres.length; i++) {
                    lstAfficherJobowner.append(membres[i].getNom() + " "
                            + membres[i].getPrenom(), null);

                }
            }
        } catch (IOException e) {
            System.out.println("Exception:" + e.toString());
        } catch (ParserConfigurationException e) {
            System.out.println("Exception:" + e.toString());
        } catch (SAXException e) {
            System.out.println("Exception:" + e.toString());
        }
    }

    public void Afficherfreelancer() {
        try {
            formAfficherFreelancer.deleteAll();
            lstAfficherFreelancer.deleteAll();
            MembreHandler freeHandle = new MembreHandler();
            // get a parser object
            SAXParser parsfree = SAXParserFactory.newInstance().newSAXParser();
            HttpConnection hcfree = (HttpConnection) Connector.open("http://localhost/pidev_mobile/freelancerA/AfficherFreelancer_attribut.php");
            DataInputStream disfree = new DataInputStream(hcfree.openDataInputStream());
            parsfree.parse(disfree, freeHandle);
            // display the result
            membres = freeHandle.getMembre();
             String p;
            if (membres.length > 0) {
                for (int i = 0; i < membres.length; i++) {
                    lstAfficherFreelancer.append(membres[i].getNom() + " "
                            + membres[i].getPrenom(), null);
                   

                }
            }

        } catch (IOException e) {
            System.out.println("Exception:" + e.toString());
        } catch (ParserConfigurationException e) {
            System.out.println("Exception:" + e.toString());
        } catch (SAXException e) {
            System.out.println("Exception:" + e.toString());
        }
    }

    public void supprimerJobonwer() {
        try {

            hc = (HttpConnection) Connector.open(urlSJOB + "?id=" + membres[lstAfficherJobowner.getSelectedIndex()].getId());
            dis = new DataInputStream(hc.openDataInputStream());
            while ((y = dis.read()) != -1) {
                sb3.append((char) y);
            }
            if ("OK".equals(sb2.toString().trim())) {

                disp.setCurrent(lstAfficherJobowner);

            } 

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void supprimerfreelancer() {

        try {
            hc = (HttpConnection) Connector.open(urlSFREE + "?id=" + membres[lstAfficherFreelancer.getSelectedIndex()].getId());

            dis = new DataInputStream(hc.openDataInputStream());

            while ((y = dis.read()) != -1) {
                sb4.append((char) y);

            }
            if ("OK".equals(sb2.toString().trim())) {

                disp.setCurrent(fgestionuser);

            } 

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void SupprimerAdmin() {
        try {
            hc = (HttpConnection) Connector.open(url + "?id=" + membres[lstAfficherAdmin.getSelectedIndex()].getId());
            dis = new DataInputStream(hc.openDataInputStream());
            while ((y = dis.read()) != -1) {
                sb2.append((char) y);
            }
            if ("OK".equals(sb2.toString().trim())) {

                disp.setCurrent(fAfficher);

            } else {
                disp.setCurrent(fErreur);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void ModifierAdmin() {
        try {

            hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/Administrateur/modifier.php" + "?id" + membres[lstAfficherAdmin.getSelectedIndex()].getId() + "&nom=" + tfMNom.getString().trim() + "&prenom=" + tfMPrenom.getString().trim()
                    + "&pays=" + tfMPays.getString().trim() + "&ville=" + tfMVille.getString().trim() + "&pseudo=" + tfMPseudo.getString().trim()
                    + "&email=" + tfMMail.getString().trim());
            System.out.println(hc);
            dis = new DataInputStream(hc.openDataInputStream());

            while ((y = dis.read()) != -1) {

                sb3.append((char) y);

            }
            if ("OK".equals(sb3.toString().trim())) {

                formAfficherAdmin.deleteAll();

                disp.setCurrent(lstAfficherAdmin);

                dis.close();
            } else {

                formAfficherAdmin.deleteAll();
                disp.setCurrent(lstAfficherAdmin);
                dis.close();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void envoisms() {
       String mno = "876543262";
       
    
              System.out.println(mno);
        String msg = message.getString();
        if (mno.equals("")) {
            alert = new Alert("Alert");
            alert.setString("Enter Mobile Number!!!");
            alert.setTimeout(2000);
            disp.setCurrent(alert);
        } else {
            try {
                clientConn = (MessageConnection) Connector.open("sms://" + mno);
              
            } catch (Exception e) {
                alert = new Alert("Alert");
                alert.setString("Message envoyer");
                alert.setTimeout(2000);
                disp.setCurrent(alert);
                disp.setCurrent(formAfficherAdmin);
            }
            try {
                TextMessage textmessage = (TextMessage) clientConn.newMessage(MessageConnection.TEXT_MESSAGE);
                textmessage.setAddress("sms://" + mno);
                textmessage.setPayloadText(msg);
                clientConn.send(textmessage);
            } catch (IOException e) {
                Alert ealerte = new Alert("Alert", "", null, AlertType.INFO);
                ealerte.setTimeout(Alert.FOREVER);
                ealerte.setString("Unable to send");
                disp.setCurrent(ealerte);
            }
        }
    }
    
    public void EnvoismsSuper() {
       String mnoo = "876543262";
       
      String mno0 = System.getProperty(mnoo);
              System.out.println(mnoo);
        String msg = message1.getString();
        if (mnoo.equals("")) {
            alert = new Alert("Alert");
            alert.setString("Enter Mobile Number!!!");
            alert.setTimeout(2000);
            disp.setCurrent(alert);
        } else {
            try {
                clientConn = (MessageConnection) Connector.open("sms://" + mnoo);
                System.out.println("ffffffffffff");
            } catch (Exception e) {
                alert = new Alert("Alert");
                alert.setString("Message envoyer");
                alert.setTimeout(2000);
                disp.setCurrent(alert);
                disp.setCurrent(fgestionuser);
            }
            try {
                TextMessage textmessage = (TextMessage) clientConn.newMessage(MessageConnection.TEXT_MESSAGE);
                textmessage.setAddress("sms://" + mnoo);
                textmessage.setPayloadText(msg);
                clientConn.send(textmessage);
            } catch (IOException e) {
                Alert ealerte = new Alert("Alert", "", null, AlertType.INFO);
                ealerte.setTimeout(Alert.FOREVER);
                ealerte.setString("Unable to send");
                disp.setCurrent(ealerte);
            }
        }
    }

 
 
    public class Gestionuser extends Canvas implements CommandListener {

        int w = getWidth(); // largeur
        int h = getHeight(); // hauteur
        int c = 1;

        public Gestionuser(int choix) {
            c = choix;
        addCommand(cmdParseJobowner);
        addCommand(cmdBack);
        addCommand(cmdParseFreelancer);
        setCommandListener(this);
         
 String urlimg;

        urlimg = "http://localhost/pidev_mobile/gestionUser.png";

        try {
            hc = (HttpConnection) Connector.open(urlimg);//établir
            dataInputStream = hc.openDataInputStream();//récupérer la réponse

            //image
            size = (int) hc.getLength();//récupération de la taille de l'image
            data = new byte[size]; //initialisation du tableau d'octet
            dataInputStream.readFully(data);//remplissage du data
            img = Image.createImage(data, 0, size);
                     disp.setCurrent(new Gestionuser(1));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        }

        protected void paint(Graphics g) {
            g.setColor(255, 255, 255);//blanc
            g.fillRect(0, 0, w, h);
            g.drawImage(img, w / 2, h / 2, Graphics.HCENTER | Graphics.VCENTER);
            g.setColor(0, 0,255);
            g.fillRect(0,0, w, 20);
            g.setColor(255, 255, 255);
            g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_ITALIC, Font.SIZE_MEDIUM));
            g.drawImage(image, 10, 10, Graphics.VCENTER | Graphics.HCENTER);
            g.drawString("Selectioner un types d'étulisareur", w-15,0 , Graphics.RIGHT|Graphics.TOP);
             
           

        }
 protected void pointerPressed(int x, int y) {
              
            if(y>100 && y<150){
                action="afficherJobowner";
                commandAction(cmdParseJobowner, this);
            }
            if(y>200 && y<250){
                commandAction(cmdParseFreelancer, this);
            }
          
           repaint();
        }
        public void commandAction(Command c, Displayable d) {
            if (c == cmdParseJobowner) {
              disp.setCurrent(lstAfficherJobowner);
                 Thread t = new Thread(new Runnable() {

                    public void run() {
                        AfficherJobowner();
                    }
                });
                  t.start(); // lancer Thread t// appel run()
                
            }
            if (c == cmdParseFreelancer) {
                disp.setCurrent(lstAfficherFreelancer);
                 Thread t = new Thread(new Runnable() {

                    public void run() {
                        Afficherfreelancer();
                    }
                    
                });
                  t.start(); // lancer Thread t// appel run()
                
            }
            if (c == cmdBack ) {
                disp.setCurrent(acceuil);
            }
             if (c == List.SELECT_COMMAND && d == lstAfficherJobowner) {
            formAfficherJobowner.append("Informations Jobowner: \n");
            formAfficherJobowner.append(showJobowner(lstAfficherJobowner.getSelectedIndex()));
            disp.setCurrent(formAfficherJobowner);
        }

        if (c == List.SELECT_COMMAND && d == lstAfficherFreelancer) {
            formAfficherFreelancer.append("Informations Freelancer: \n");
            formAfficherFreelancer.append(showJobowner(lstAfficherFreelancer.getSelectedIndex()));
            disp.setCurrent(formAfficherFreelancer);
        }

        }

    }
   
  
   public void connecterImage() {
        String urlimg;

        urlimg = "http://localhost/pidev_mobile/gestionUser.png";

        try {
            hc = (HttpConnection) Connector.open(urlimg);//établir
            dataInputStream = hc.openDataInputStream();//récupérer la réponse

            //image
            size = (int) hc.getLength();//récupération de la taille de l'image
            data = new byte[size]; //initialisation du tableau d'octet
            dataInputStream.readFully(data);//remplissage du data
            img = Image.createImage(data, 0, size);
                     disp.setCurrent(new Gestionuser(1));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
   
   
   
   
     private String showFreelancer(int i) {
        String res = "";
        if (freelancers.length > 0) {
            sb.append("Prenom :");

            sb.append(freelancers[i].getPrenom());
            sb.append("\n");
            sb.append("Nom: ");
            sb.append(freelancers[i].getNom());
            sb.append("\n");
            sb.append("Emailt: ");
            sb.append(freelancers[i].getEmail());
            sb.append("\n");
            sb.append("Pays: ");
            sb.append(freelancers[i].getPays());
            sb.append("\n");
            sb.append("Ville: ");
            sb.append(freelancers[i].getVille());
            sb.append("\n");
            sb.append("Ppseudo: ");
            sb.append(freelancers[i].getPseudo());
            sb.append("\n");
            sb.append("Disponibilite: ");
            sb.append(freelancers[i].getDisponibilite_f());
            sb.append("\n");

        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }

    }
