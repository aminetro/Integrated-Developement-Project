
package Login;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Date;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.midlet.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Autentification extends MIDlet implements CommandListener, Runnable{
    String logged ="";String type="";String traitement="login";
    
    Form f1contacterMail = new Form("Email");
    Form ajoutcontacterMail = new Form("ajout");
    TextField tfUsernamecontacterMail = new TextField("From Email", null, 100, TextField.ANY);
    //TextField tfPassword = new TextField("Password", null, 100, TextField.ANY);
   // TextField tfEmail = new TextField("To Email", null, 100, TextField.ANY);
    TextField tfNomcontacterMail = new TextField("Sujet", null, 100, TextField.ANY);
    TextField tfPrenomcontacterMail = new TextField("message", null, 100, TextField.ANY);
    Command cmdValidercontacterMail = new Command("valider", Command.SCREEN, 0);
    Command cmdContact = new Command("Contact", Command.SCREEN, 0);
    Command cmdBack = new Command("cmdBack", Command.BACK, 0);

    Form f2contacterMail = new Form("l'email à été envoyé");
    Form f3contacterMail = new Form("l'email à été envoyé");

    Alert alerta1contacterMail = new Alert("Success", "Mail envoyé", null, AlertType.INFO);
    Alert alertacontacterMail = new Alert("Error", "Sorry", null, AlertType.INFO);
    String messagecontacterMail;
    List lstmap = new List("Examples", List.IMPLICIT);
      Form fmap= new Form("choisir pays");
     
     TextField tfPaysmaps = new TextField("choisir pays", null, 100, TextField.ANY);
    Command cmdValidermaps = new Command("valider", Command.SCREEN, 0);
    Localisation[] localisations;
    
    Display disp = Display.getDisplay(this);
      private Player player = null;
    private Player player2 = null;
    //Form 1
    int nbphotoshop;
    int nbjava;
    int nbweb;
    int nbphyton;
    int nbcsharp;
    int nbtunisie;
    int nbfrance;
    int nbamerique;
    int nbcanada;
    int nbitalie;
    Image img ;
    ImageItem imgt;
    Image img2 ;
    ImageItem imgt2;
    Draw d1 = new Draw();
    
    
    
   ChoiceGroup lpaysfree = new ChoiceGroup("Pays : ", ChoiceGroup.POPUP);
   ChoiceGroup lpaysjob = new ChoiceGroup("Pays : ", ChoiceGroup.POPUP);
   ChoiceGroup lcategorieprojet = new ChoiceGroup("Categorie : ", ChoiceGroup.POPUP);
   
    
    HttpConnection hc;
    DataInputStream dis;
   // StringBuffer sb = new StringBuffer();
    int ch, web, java, csharp, phyton, photoshop;
    Form formStatistique = new Form("Statistique");
   Alert connectionOk;
   
   Alert connectionKo;
        Form affichagefreelancer = new Form("affichagefreelancer");
        ////////////////////
        candidature[] Jobownercands;
        
        Command listfree=new Command("Freelancers", Command.SCREEN, 0);
        Command listjob=new Command("Jobowners", Command.SCREEN, 0);
        Form fFreelancerMembre = new Form("Liste des Membres");
        
    Command statprojet = new Command("Statistique des Projets ", Command.SCREEN, 0);
    Command statpays = new Command("Statistique des Membres ", Command.SCREEN, 0);
    Form fLogin = new Form("Authentification");
    Command map = new Command("Map ", Command.SCREEN, 0);
    TextField tfLogin = new TextField("Username : ", null, 100, TextField.ANY);
    TextField tfPass = new TextField("Password :", null, 100, TextField.PASSWORD);
    
    Command supprimerCV = new Command("supprimer", Command.SCREEN, 0);
    Command modifierCV = new Command("modifier", Command.SCREEN, 0);
    cv[] cvs;
    Command InscriptionFree = new Command("Inscription Freelancer", Command.SCREEN, 0);
    Command InscriptionJob = new Command("Inscription Jobowner", Command.SCREEN, 0);

    Command cmdValider = new Command("valider", Command.SCREEN, 0);
    Command cmdLogout = new Command("Logout", Command.BACK, 0);
    
    Form fErreur = new Form("Erreur");
   
    Command freeCv = new Command("CV", Command.SCREEN, 0);
    Command freeProfil = new Command("Profil", Command.SCREEN, 0);
    Command freeProjet = new Command("Projet", Command.SCREEN, 0);
    Command freeCandidature = new Command("Candidature", Command.SCREEN, 0);
    Command freeTest = new Command("Test", Command.SCREEN, 0);
    Command freeMessage = new Command("Message", Command.SCREEN, 0);
    Command freeReclamation = new Command("Reclamation", Command.SCREEN, 0);
    Command Statistique = new Command("Statistique", Command.SCREEN, 0);
    Command freeMembres = new Command("Membres", Command.SCREEN, 0);
    
    Command jobProfil = new Command("Profil", Command.SCREEN, 0);
    Command jobProjet = new Command("Projet", Command.SCREEN, 0);
    Command jobCandidature = new Command("Candidature", Command.SCREEN, 0);
    Command jobMessage = new Command("Message", Command.SCREEN, 0);
    Command jobReclamation = new Command("Reclamation", Command.SCREEN, 0);
    
    Command backmap = new Command("Back", Command.SCREEN, 0);
    
    Command freeCvAjout=new Command("Ajouter", Command.SCREEN, 0);
    Command freeAjouterCandidature=new Command("Candidater", Command.SCREEN, 0);
    Command freeAjouterFav=new Command("favoriser", Command.SCREEN, 0);
    
     //inscription freelancer
    TextField tfNom = new TextField("Nom", null, 100, TextField.ANY);
    TextField tfPrenom = new TextField("Prenom", null, 100, TextField.ANY);
    TextField tfEmail = new TextField("Email", null, 100, TextField.ANY);
    TextField tfPseudo = new TextField("Pseudo", null, 100, TextField.ANY);
    TextField tfPassword = new TextField("Password", null, 100, TextField.PASSWORD);
    TextField tfPays = new TextField("Pays", null, 100, TextField.ANY);
    TextField tfVille = new TextField("Ville", null, 100, TextField.ANY);

//inscription jobowner
    TextField tfJNom = new TextField("Nom", null, 100, TextField.ANY);
    TextField tfJPrenom = new TextField("Prenom", null, 100, TextField.ANY);
    TextField tfJEmail = new TextField("Email", null, 100, TextField.ANY);
    TextField tfJPseudo = new TextField("Pseudo", null, 100, TextField.ANY);
    TextField tfJPassword = new TextField("Password", null, 100, TextField.PASSWORD);
    TextField tfJPays = new TextField("Pays", null, 100, TextField.ANY);
    TextField tfJVille = new TextField("Ville", null, 100, TextField.ANY);
    TextField tfJSociete = new TextField("Societe", null, 100, TextField.ANY);
    
    Command jobProjetAjout = new Command("Ajouter", Command.SCREEN, 0);
    
    Form fFreelancerMenu = new Form("freelancer");
    
    TextField tfExp_cv = new TextField("Experience : ", null, 100, TextField.ANY);
    TextField tfLangue_cv = new TextField("Langue : ", null, 100, TextField.ANY);
    TextField tfCertif_cv = new TextField("Certification : ", null, 100, TextField.ANY);
    TextField tfForma_cv = new TextField("Formation : ", null, 100, TextField.ANY);
    
    TextField tfR_sujet = new TextField("Sujet : ", null, 100, TextField.ANY);
    TextField tfR_message = new TextField("Message : ", null, 100, TextField.ANY);

    Form fInscriptionFree = new Form("Inscription Freelancer");
    Form fInscriptionJob = new Form("Inscription Jobowner");
    
    Form fFreelancerCvAjout = new Form("freelancer CV");
    Form fFreelancerCvAfficheOne= new Form("Infos cv");
    
    TextField tfExperience = new TextField("Experience : ",null, 100, TextField.ANY);
     TextField tfFormation = new TextField("Formation : ",null, 100, TextField.ANY);
     TextField tfLangue = new TextField("Langue : ",null, 100, TextField.ANY);
     TextField tfCertification = new TextField("Certification : ",null, 100, TextField.ANY);
    Form fFreelanceCVModif = new Form("Modifier CV");
    Form fFreelancerCv = new Form("freelancer CV");
    
    Form fFreelancerProfil = new Form("freelancer profil");
    
    
    List fFreelancerProjetAffiche = new List("Projets", List.IMPLICIT);
    Form fFreelancerProjetAfficheOne = new Form("Infos Projets");
    Form fFreelancerProjet = new Form("freelancer projet");
    
    Form fFreelancerCandidature = new Form("freelancer candidature");
    
    Form fFreelancerTest = new Form("freelancer test");
    
    Form fFreelancerMessage = new Form("freelancer msg");
    
    Form fFreelancerRecAjout = new Form("freelancer Reclamation");
    Form fFreelancerReclamation = new Form("freelancer Reclamation");
    
    
    Form fFreelancerMembres = new Form("freelancer liste des membres");
    
    
    
    Form fJobownerMenu = new Form("jobowner");
    
    Form fJobownerProfil = new Form("jobowner profil");
    
    TextField tftitre = new TextField("Titre : ", null, 100, TextField.ANY);
    TextField tfcategorie = new TextField("Categorie : ", null, 100, TextField.ANY);
    Gauge dureeprojet;
    TextField tfdesc = new TextField("Description : ", null, 100, TextField.ANY);
    TextField tftitremodif = new TextField("Titre : ", null, 100, TextField.ANY);
    TextField tfcategoriemodif = new TextField("Categorie : ", null, 100, TextField.ANY);
    Gauge dureeprojetmodif;
    TextField tfdescmodif = new TextField("Description : ", null, 100, TextField.ANY);
    
    
    Form fJobownerProjetAjout = new Form("jobowner projet");
    Form fJobownerProjet = new Form("jobowner projet");
    
    Form fJobownerCandidature = new Form("jobowner candidature");
    
    Form fJobownerMessage = new Form("jobowner msg");
    
    Form fJobownerRecAjout = new Form("jobowner Reclamation");
    Form fJobownerReclamation = new Form("jobowner Reclamation");
    
    Form fStatistique = new Form(" stat");
    
    Form fJobownerMembres = new Form("jobowner membres");
    
    Form fa = new Form("admin");
    
    Command supprimerProjet = new Command("supprimer", Command.SCREEN, 0);
    Command modifierProjet = new Command("modifier", Command.SCREEN, 0);
    Projet[] Projets;
    List fJobownerProjetAffiche = new List("Projets", List.IMPLICIT);
    Form fJobownerProjetAfficheOne = new Form("Infos Projets");
    //Form loadingDialog = new Form("Please Wait");
    StringBuffer sb = new StringBuffer();
    StringBuffer sb2 = new StringBuffer();
     StringBuffer sb3 = new StringBuffer();
    /*fin affichage*/
     Form f3 = new Form("Erreur");
    Command cmdParse = new Command("projets", Command.SCREEN, 0);
    Command cmdParsecv = new Command("CV", Command.SCREEN, 0);
     //Connexion
     Command cmdBackwelcom = new Command("Back", Command.BACK, 0);
  //fFreelancerCandidature
     TextField tfEstimation = new TextField("Estimation", null, 100, TextField.ANY);
    TextField tfLettreMot = new TextField("Lettre de motivation", null, 100, TextField.ANY);
    TextField tfQuestion = new TextField("Question", null, 100, TextField.ANY);
    Command acceptCandJobowner = new Command("accepter", Command.SCREEN, 0);
     Command supprimerCandJobowner = new Command("refuser", Command.SCREEN, 0);

    List fJobownerCandAffiche = new List("Candidature", List.IMPLICIT);
    Form  fJobownerCand = new Form("Accueil");
    Form  fJobownerCandAfficheOne = new Form("Infos Candidature Jobowner");
   
    Command jobcand = new Command("Candidature", Command.SCREEN, 0);
    /*modifier Projet*/
    Form fJobownerProjetModif = new Form("Modifier Projet");
    Alert alerta = new Alert("Error", "Sorry", null, AlertType.ERROR);
String url = "";
    DataInputStream ds;
    StringBuffer conca;
    int resServeur = 0;
      List fFreelancerCandAffiche = new List("Candidature", List.IMPLICIT);
    Form  fFreelancerCand = new Form("Accueil");
    Form  fFreelancerCandAfficheOne = new Form("Infos Candidature");
    
     Command supprimerFreelancerCand = new Command("supprimer", Command.SCREEN, 0);
    Command modifierFreelancerCand = new Command("modifier", Command.SCREEN, 0);
    Command freecandida = new Command("Candidature", Command.SCREEN, 0);
    //Connexion
   Command cmdParseJobowner = new Command("Jobowners", Command.SCREEN, 0);
    Membre[] Jobownermembres;
    List fjobownerAffich = new List("Membres", List.IMPLICIT);
    Form fJobowner = new Form("Accueil");
    Form fjobownerAffichOne = new Form("Infos Jobowner");
    Form loadingDialog = new Form("Please Wait");
    Command cmdParseFree = new Command("Freelancers", Command.SCREEN, 0);
    Freelancer[] freelancers;
    List fFreelancerAffich = new List("freelancers", List.IMPLICIT);
    Form fFreelancer = new Form("Accueil");
    Form fFreelancerAffichone = new Form("Infos freelancers");
    Form fFreelanceCandModif = new Form("Modifier Candidature");
    Command cmdValiderCandmodif = new Command("valider", Command.SCREEN, 0);   
    TextField estimation = new TextField("Estimation",null, 100, TextField.ANY);
     TextField lettre_mot = new TextField("Lettre_mot",null, 100, TextField.ANY);
     TextField question = new TextField("Question",null, 100, TextField.ANY);
    Command modifierJobownerProfil = new Command("modifier", Command.SCREEN, 0);
       Form fJobownerModifProfil = new Form("Modifier Jobowner");
    Command cmdValiderjobownerModif = new Command("valider", Command.SCREEN, 0);   
    TextField tfnomJobowner = new TextField("nom",null, 100, TextField.ANY);
     TextField tfprenomJobowner = new TextField("prenom",null, 100, TextField.ANY);
     TextField tfpseudoJobowner = new TextField("pseudo",null, 100, TextField.ANY);
     TextField tfpaysJobowner = new TextField("pays",null, 100, TextField.ANY);
      TextField tfvilleJobowner = new TextField("ville",null, 100, TextField.ANY);
     TextField tfemailJobowner = new TextField("email",null, 100, TextField.ANY);
     TextField tfsocieteJobowner = new TextField("societe",null, 100, TextField.ANY);
     Form fFreelancerAffichoneProfil = new Form("Infos freelancers");
  
     Command modifierFreelancer = new Command("modifier", Command.SCREEN, 0);
       Form fFreelancerModif = new Form("Modifier Freelancer");
    Command cmdValiderFreelancerModif = new Command("valider", Command.SCREEN, 0);   
    TextField tfnomFreelacer = new TextField("nom",null, 100, TextField.ANY);
     TextField tfprenomFreelacer = new TextField("prenom",null, 100, TextField.ANY);
     TextField tfpseudoFreelacer = new TextField("pseudo",null, 100, TextField.ANY);
     TextField tfpaysFreelacer = new TextField("pays",null, 100, TextField.ANY);
      TextField tfvilleFreelacer = new TextField("ville",null, 100, TextField.ANY);
     TextField tfemailFreelacer = new TextField("email",null, 100, TextField.ANY);
  ChoiceGroup tfdisponibiliteFreelacer = new ChoiceGroup("disponibilite", ChoiceGroup.POPUP);
    Form fjobownerAffichOneProfil = new Form("Infos Jobowner");
    /*Messagerie*/
     Command EnvoyerMessageFreelancer = new Command("envoyer Message", Command.SCREEN, 0);
     Form fFreelancerenvoyerMessage = new Form("envoyer message");
     TextField tfsujetFreelacer = new TextField("Sujet",null, 100, TextField.ANY);
     TextField tfmessageFreelacer = new TextField("Message",null, 100, TextField.ANY);
     Command cmdValiderFreelancerEnoyerMessage = new Command("valider", Command.SCREEN, 0);
     /*Messagerie*/
     
      /*Messagerie*/
     Command EnvoyerMessageJobowner = new Command("envoyer Message", Command.SCREEN, 0);
     Form fJobownerenvoyerMessage = new Form("envoyer message");
     TextField tfsujetJobowner = new TextField("Sujet",null, 100, TextField.ANY);
     TextField tfmessageJobowner = new TextField("Message",null, 100, TextField.ANY);
     Command cmdValiderJobownerEnoyerMessage = new Command("valider", Command.SCREEN, 0);
     /*Messagerie*/
    public void startApp() {
        try {
            img = Image.createImage("Images/freelancer.png");
            img2 = Image.createImage("Images/jobOwner.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        /*Messagerie*/
        fFreelancerAffichone.addCommand(EnvoyerMessageFreelancer);
        fFreelancerAffichone.setCommandListener(this);
        fFreelancerenvoyerMessage.addCommand(cmdValiderFreelancerEnoyerMessage);
        fFreelancerenvoyerMessage.append(tfsujetFreelacer);
        fFreelancerenvoyerMessage.append(tfmessageFreelacer);
        fFreelancerenvoyerMessage.setCommandListener(this);
          /*Messagerie*/
         /*Messagerie*/
        fjobownerAffichOne.addCommand(EnvoyerMessageJobowner);
        fjobownerAffichOne.setCommandListener(this);
        fJobownerenvoyerMessage.addCommand(cmdValiderJobownerEnoyerMessage);
        fJobownerenvoyerMessage.append(tfsujetJobowner);
        fJobownerenvoyerMessage.append(tfmessageJobowner);
        fJobownerenvoyerMessage.setCommandListener(this);
          /*Messagerie*/
        
        dureeprojet = new Gauge("Duree : ", true, 30, 1);
        dureeprojetmodif = new Gauge("Duree : ", true, 30, 1);
        imgt = new ImageItem("", img, ImageItem.LAYOUT_CENTER, "");
        imgt2 = new ImageItem("", img2, ImageItem.LAYOUT_CENTER, "");
         fFreelancer.append("Click Membres to get your membres_list");
        fFreelancer.addCommand(cmdParseFree);
        fFreelancer.setCommandListener(this);
        fFreelancerAffich.setCommandListener(this);
       fFreelancerAffichone.addCommand(cmdBack);
       fFreelancerAffichone.setCommandListener(this);
        fmap.addCommand(backmap);
        fLogin.append(tfLogin);
        fLogin.append(tfPass);
        fLogin.addCommand(cmdValider);
        fLogin.addCommand(cmdContact);
fLogin.addCommand(map);
        fLogin.addCommand(InscriptionFree);
        fLogin.addCommand(InscriptionJob);
        fLogin.setCommandListener(this);
        fFreelancerCv.append("Click liste to get your CV_list");
        fFreelancerCv.addCommand(cmdParsecv);
        fFreelancerCv.setCommandListener(this);
        fFreelancerCvAfficheOne.addCommand(cmdBack);
        fFreelancerCvAfficheOne.setCommandListener(this);
        //inscription freelancer
        fInscriptionFree.append(tfNom);
        fInscriptionFree.append(tfPrenom);
        fInscriptionFree.append(tfEmail);
        fInscriptionFree.append(tfPseudo);
        fInscriptionFree.append(tfPassword);
        fInscriptionFree.append(lpaysfree);
        fInscriptionFree.append(tfVille);
        fInscriptionFree.addCommand(cmdValider);
        fInscriptionFree.addCommand(cmdBack);
        fInscriptionFree.setCommandListener(this);
        //inscription Jobowner
        fInscriptionJob.append(tfJNom);
        fInscriptionJob.append(tfJPrenom);
        fInscriptionJob.append(tfJEmail);
        fInscriptionJob.append(tfJPseudo);
        fInscriptionJob.append(tfJPassword);
        fInscriptionJob.append(lpaysjob);
        fInscriptionJob.append(tfJVille);
        fInscriptionJob.append(tfJSociete);
        fInscriptionJob.addCommand(cmdValider);
        fInscriptionJob.addCommand(cmdBack);
        fInscriptionJob.setCommandListener(this);

        fFreelancerRecAjout.append(tfR_sujet);
        fFreelancerRecAjout.append(tfR_message);
        fFreelancerRecAjout.addCommand(cmdBack);
        fFreelancerRecAjout.addCommand(cmdValider);
        fFreelancerRecAjout.setCommandListener(this);
        fFreelancerCvAfficheOne.addCommand(supprimerCV);
       fFreelancerCvAfficheOne.addCommand(modifierCV);
       fFreelancerCvAfficheOne.setCommandListener(this);
        
      fFreelanceCVModif.append(tfExperience);
      fFreelanceCVModif.append(tfFormation);
      fFreelanceCVModif.append(tfLangue);
      fFreelanceCVModif.append(tfCertification);
      fFreelanceCVModif.addCommand(cmdValider);
      fFreelanceCVModif.setCommandListener(this);
        fJobownerMenu.append(imgt2);
        fFreelancerMenu.append(imgt);
        fFreelancerMenu.addCommand(freeProjet);
        fFreelancerMenu.addCommand(freeCandidature);
        fFreelancerMenu.addCommand(freeCv);
        fFreelancerMenu.addCommand(freeMembres);
        fFreelancerMenu.addCommand(freeMessage);
        fFreelancerMenu.addCommand(freeProfil);
        fFreelancerMenu.addCommand(freeReclamation);
        fFreelancerMenu.addCommand(Statistique);
        fFreelancerMenu.addCommand(freeTest);
        fFreelancerMenu.addCommand(cmdLogout);
        fFreelancerMenu.setCommandListener(this);
        
        connectionOk=new Alert("Login Ok", "votre session est ouverte correctement", null, AlertType.INFO);
        connectionKo=new Alert("Login Ko", "les donnees que vous avez entre sont incorrectes", null, AlertType.INFO);
        fFreelancerProjet.append("Click to get your Projets List");
        fFreelancerProjet.addCommand(cmdBack);
        fFreelancerProjet.addCommand(cmdParse);
        fFreelancerProjet.setCommandListener(this);
        fJobownerProjetAffiche.addCommand(cmdBack);
        fFreelancerProjetAffiche.addCommand(cmdBack);
        fFreelancerProjetAffiche.setCommandListener(this);
        
        fFreelancerProjetAfficheOne.addCommand(cmdBack);
        fFreelancerProjetAfficheOne.addCommand(freeAjouterCandidature);
        fFreelancerProjetAfficheOne.addCommand(freeAjouterFav);
        fFreelancerProjetAfficheOne.setCommandListener(this);
        
        fFreelancerCv.addCommand(cmdBack);
        fFreelancerCv.addCommand(freeCvAjout);
        fFreelancerCv.setCommandListener(this);
        
        fFreelancerCvAjout.append(tfExp_cv);
        fFreelancerCvAjout.append(tfLangue_cv);
        fFreelancerCvAjout.append(tfForma_cv);
        fFreelancerCvAjout.append(tfCertif_cv);
        fFreelancerCvAjout.addCommand(cmdBack);
        fFreelancerCvAjout.addCommand(cmdValider);
        fFreelancerCvAjout.setCommandListener(this);
        formStatistique.addCommand(statprojet);
        formStatistique.addCommand(statpays);
        formStatistique.addCommand(cmdBack);
        formStatistique.setCommandListener(this);
        fJobownerMenu.addCommand(jobProjet);
        fJobownerMenu.addCommand(jobCandidature);
        fJobownerMenu.addCommand(freeMembres);
        fJobownerMenu.addCommand(jobMessage);
        fJobownerMenu.addCommand(jobProfil);
        fJobownerMenu.addCommand(jobReclamation);
        fJobownerMenu.addCommand(Statistique);
        fJobownerMenu.addCommand(cmdLogout);
        fJobownerMenu.setCommandListener(this);
        
        fJobownerProjet.append("Click to get your Projets List");
        fJobownerProjet.addCommand(cmdBack);
        fJobownerProjet.addCommand(cmdParse);
        fJobownerProjet.addCommand(jobProjetAjout);
        fJobownerProjet.setCommandListener(this);
        
        fJobownerProjetAjout.append(tftitre);
        fJobownerProjetAjout.append(lcategorieprojet);
        fJobownerProjetAjout.append(dureeprojet);
        fJobownerProjetAjout.append(tfdesc);
        fJobownerProjetAjout.addCommand(cmdBack);
        fJobownerProjetAjout.addCommand(cmdValider);
        fJobownerProjetAjout.setCommandListener(this);
        
        
        fJobownerProjetAffiche.setCommandListener(this);
        
        fJobownerProjetAfficheOne.addCommand(cmdBack);
        fJobownerProjetAfficheOne.addCommand(supprimerProjet);
         fJobownerProjetAfficheOne.addCommand(modifierProjet);
        fJobownerProjetAfficheOne.setCommandListener(this);
         /*fin affichage*/
      
       fJobownerProjetModif.append(tftitremodif);
       fJobownerProjetModif.append(tfcategoriemodif);
       fJobownerProjetModif.append(tfdescmodif);
       fJobownerProjetModif.append(dureeprojetmodif);
       fJobownerProjetModif.addCommand(cmdValider);
       fJobownerProjetModif.setCommandListener(this);
        
        fFreelancerCandidature.append(tfEstimation);
        fFreelancerCandidature.append(tfLettreMot);
        fFreelancerCandidature.append(tfQuestion);
        fFreelancerCandidature.addCommand(cmdBack);
        fFreelancerCandidature.addCommand(cmdValider);
        fFreelancerCandidature.setCommandListener(this);
     
        fFreelancerMembres.addCommand(cmdBack);
        fFreelancerMembres.addCommand(listfree);
        fFreelancerMembres.addCommand(listjob);
        fFreelancerMembres.setCommandListener(this);
        
        d1.addCommand(cmdBack);
        d1.setCommandListener(this);
        fa.addCommand(cmdLogout);
        fa.setCommandListener(this);
        fErreur.addCommand(cmdLogout);
        fErreur.setCommandListener(this);
        
        fJobowner.append("Click Jobowners to get your Jobowners_list");
        fJobowner.addCommand(cmdParseJobowner);
        fJobowner.setCommandListener(this);
        fjobownerAffich.setCommandListener(this);
        fjobownerAffichOne.addCommand(cmdBack);
         fjobownerAffichOne.setCommandListener(this);
        fJobownerProfil.append("Click Membres to get your membres_list");
        fJobownerProfil.setCommandListener(this);
       
        fjobownerAffichOneProfil.addCommand(cmdBack);
        fjobownerAffichOneProfil.addCommand(modifierJobownerProfil);
        fjobownerAffichOneProfil.setCommandListener(this);
         fJobownerModifProfil.addCommand(cmdValiderjobownerModif);
        fJobownerModifProfil.append(tfnomJobowner);
        fJobownerModifProfil.append(tfprenomJobowner);
        fJobownerModifProfil.append(tfpseudoJobowner);
        fJobownerModifProfil.append(tfpaysJobowner);
        fJobownerModifProfil.append(tfvilleJobowner);
        fJobownerModifProfil.append(tfemailJobowner);
        fJobownerModifProfil.append(tfsocieteJobowner);
        fJobownerModifProfil.setCommandListener(this);
        fFreelancerProfil.append("Click Membres to get your membres_list");
        fFreelancerProfil.addCommand(cmdParse);
        fFreelancerProfil.setCommandListener(this);
        fJobownerCand.append("Click Candidature to get your Candidature_list");
        fJobownerCand.addCommand(jobcand);
       
        fJobownerCand.setCommandListener(this);
        fJobownerCandAffiche.setCommandListener(this);
        fJobownerCandAfficheOne.addCommand(cmdBack);
        fJobownerCandAfficheOne.addCommand(acceptCandJobowner);
        fJobownerCandAfficheOne.addCommand(supprimerCandJobowner);

        fJobownerCandAfficheOne.setCommandListener(this);
       
        fFreelancerCand.append("Click Candidature to get your Candidature_list");
        fFreelancerCand.addCommand(freecandida);
       
        fFreelancerCand.setCommandListener(this);
        fFreelancerCandAffiche.addCommand(cmdBack);
        fFreelancerCandAffiche.setCommandListener(this);
        fFreelancerCandAfficheOne.addCommand(cmdBack);
        fFreelancerCandAfficheOne.addCommand(supprimerFreelancerCand);
         fFreelancerCandAfficheOne.addCommand(modifierFreelancerCand);
        fFreelancerCandAfficheOne.setCommandListener(this);
        fFreelanceCandModif.addCommand(cmdValiderCandmodif);
      
        fFreelanceCandModif.append(estimation);
        fFreelanceCandModif.append(lettre_mot);
        fFreelanceCandModif.append(question);
        fFreelanceCandModif.setCommandListener(this);
        fFreelancerAffichoneProfil.addCommand(cmdBack);
        fFreelancerAffichoneProfil.addCommand(modifierFreelancer);
        fFreelancerAffichoneProfil.setCommandListener(this);
        fFreelancerModif.addCommand(cmdValiderFreelancerModif);
        fFreelancerModif.append(tfnomFreelacer);
        fFreelancerModif.append(tfprenomFreelacer);
        fFreelancerModif.append(tfpseudoFreelacer);
        fFreelancerModif.append(tfpaysFreelacer);
        fFreelancerModif.append(tfvilleFreelacer);
        fFreelancerModif.append(tfemailFreelacer);
       
        
        lpaysfree.append("tunisie", null);
        lpaysfree.append("france", null);
        lpaysfree.append("italie", null);
        lpaysfree.append("amerique", null);
        lpaysfree.append("canada", null);
        
        lpaysjob.append("tunisie", null);
        lpaysjob.append("france", null);
        lpaysjob.append("italie", null);
        lpaysjob.append("amerique", null);
        lpaysjob.append("canada", null);
        
        
        
        lcategorieprojet.append("java", null);
        lcategorieprojet.append("web", null);
        lcategorieprojet.append("phyton", null);
        lcategorieprojet.append("photoshop", null);
        lcategorieprojet.append("c#", null);
        
        
        
        fFreelancerModif.append(tfdisponibiliteFreelacer);
        fFreelancerModif.setCommandListener(this);
        
        f1contacterMail.append(tfUsernamecontacterMail);
       /* f1.append(tfPassword);
        f1.append(tfEmail);*/
        f1contacterMail.append(tfNomcontacterMail);
        f1contacterMail.append(tfPrenomcontacterMail);
        f1contacterMail.addCommand(cmdBack);
        f1contacterMail.addCommand(cmdValidercontacterMail);
        f1contacterMail.setCommandListener(this);
        
        f2contacterMail.setCommandListener(this);
        
        
        
        
        
        fmap.append(tfPaysmaps);
        fmap.addCommand(cmdValidermaps);
        fmap.setCommandListener(this);
      
        
        
        disp.setCurrent(fLogin);
        SplashScreen0 s0 = new SplashScreen0(this);
        disp.setCurrent(s0);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        SplashScreen1 s1 = new SplashScreen1(this);
        disp.setCurrent(s1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        SplashScreen2 s2 = new SplashScreen2(this);
        disp.setCurrent(s2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if(c==cmdContact){
            disp.setCurrent(f1contacterMail);
            traitement="contacter mail";
        }
        
        if (c == cmdValidercontacterMail) {
            Thread th = new Thread(this);
            th.start();
        }
        if (c == cmdBack && d==f1contacterMail) {
            
            disp.setCurrent(fLogin);
        }
        if(c==map){
            
        disp.setCurrent(fmap);
        }
        if(d==fmap){
      traitement="map";
     }
        if(c==backmap){
    
        disp.setCurrent(fLogin);
        }
                
       if(c==cmdValidermaps){
    
           Thread th = new Thread(this);
            th.start();
        }
        if (d==fFreelancer){
          traitement="Freelancer affichage";
        }
        if ((c == List.SELECT_COMMAND)&&(d==fJobownerCandAffiche)) {
            fJobownerCandAfficheOne.append("Informations Candidature: \n");
            fJobownerCandAfficheOne.append(showCandidature(fJobownerCandAffiche.getSelectedIndex()));
            
            disp.setCurrent(fJobownerCandAfficheOne);
         System.out.println(Jobownercands[fJobownerCandAffiche.getSelectedIndex()].getId() );
        }
        if (c == cmdParseFree) {
            disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }

        if ((c == List.SELECT_COMMAND)&&(d==fFreelancerAffich)) {
            fFreelancerAffichone.append("Informations Freelancer: \n");
            fFreelancerAffichone.append(showFreelancer(fFreelancerAffich.getSelectedIndex()));
            disp.setCurrent(fFreelancerAffichone);
        }
        if (c == cmdValiderjobownerModif) {
          
             Thread th = new Thread(this);
            th.start();
            traitement="jobowner modifier Profil";
     
        }
        if (c == modifierJobownerProfil) {
        tfnomJobowner.setString("");tfprenomJobowner.setString("");
         tfpseudoJobowner.setString("");tfpaysJobowner.setString("");
         tfvilleJobowner.setString("");tfemailJobowner.setString("");tfsocieteJobowner.setString("");
         tfnomJobowner.setString(Jobownermembres[0].getNom());tfprenomJobowner.setString(Jobownermembres[0].getPrenom());
         tfpseudoJobowner.setString(Jobownermembres[0].getPseudo());tfpaysJobowner.setString(Jobownermembres[0].getPays());
         tfvilleJobowner.setString(Jobownermembres[0].getVille());tfemailJobowner.setString(Jobownermembres[0].getMail());tfsocieteJobowner.setString(Jobownermembres[0].getSociete());
          disp.setCurrent(fJobownerModifProfil);    
        }
        if ((c==jobProfil)) {
            traitement="jobowner affichage Profil";
            disp.setCurrent(fjobownerAffichOneProfil);
            Thread th = new Thread(this);
            th.start();
        }
         if ((c==freeProfil)) {
          traitement="Freelancer affichage Profil";
            disp.setCurrent(fFreelancerAffichoneProfil);
            Thread th = new Thread(this);
            th.start();
        }
        if (d==fJobowner){
          traitement="jobowner affichage";
        }
        if (c == listjob) {
            disp.setCurrent(fJobowner);
        }
        if (c == listfree) {
            disp.setCurrent(fFreelancer);
        }
        if (c == freeMembres) {
            disp.setCurrent(fFreelancerMembres);
        }
        if (c == cmdParseJobowner) {
            disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }

        if ((c == List.SELECT_COMMAND)&&(d==fjobownerAffich)) {
            fjobownerAffichOne.append("Informations Membre: \n");
            fjobownerAffichOne.append(showMembre(fjobownerAffich.getSelectedIndex()));
            disp.setCurrent(fjobownerAffichOne);
        }
        if (d==fFreelancerCv){
        traitement="cv accueil";
        } 
        
        if (c == cmdParsecv) {
         
            Thread th = new Thread(this);
            th.start();
        }
        if (c == supprimerCV) {
           
             Thread th = new Thread(this);
            th.start();
            traitement="cv supprimer";
        }
         if (c == modifierCV) {
         tfExperience.setString("");tfFormation.setString("");
         tfLangue.setString("");tfCertification.setString("");
         tfExperience.insert(cvs[0].getExperience(), 0);
        tfFormation.insert(cvs[0].getFormation(), 0);
        tfLangue.insert(cvs[0].getLangue(), 0);
        tfCertification.insert(cvs[0].getCertification(), 0);
     disp.setCurrent(fFreelanceCVModif);    
     
        }
          if ((c == cmdValider)&&(d==fFreelanceCVModif)) {
           
             Thread th = new Thread(this);
            th.start();
            traitement="cv modif";
        }
        if ((c == cmdValider)&&(d==fLogin)) {
            traitement="login";
            Thread th = new Thread(this);
            th.start();
        }
        if ((c == cmdValider)&&(d==fJobownerProjetAjout)) {
            traitement="projet ajout";
            Thread th = new Thread(this);
            th.start();
        }
        if ((c == cmdValider)&&(d==fFreelancerCvAjout)) {
            traitement="cv ajout";
            Thread th = new Thread(this);
            th.start();
        }
        if ((c == cmdValider)&&((d==fJobownerRecAjout)||(d==fFreelancerRecAjout))) {
            traitement="reclamation ajout";
            Thread th = new Thread(this);
            th.start();
        }
        if ((c == cmdValider) && (d == fInscriptionFree)) {
            traitement = "Inscription Freelancer";
            Thread th = new Thread(this);
            th.start();
        }
        if ((c == cmdValider) && (d == fInscriptionJob)) {
            traitement = "Inscription Jobowner";
            Thread th = new Thread(this);
            th.start();
        }
        if (c == cmdLogout) {
            logged="";traitement="login";fFreelancerMenu.setTitle("Freelancer");fJobownerMenu.setTitle("Jobowner");
            disp.setCurrent(fLogin);
        }
        if ((c == cmdBack)&&("free".equals(type))) {
            disp.setCurrent(fFreelancerMenu);
        }
        if ((c == cmdBack)&&("job".equals(type))) {
            disp.setCurrent(fJobownerMenu);
        }
        if(c==freeCv){
            disp.setCurrent(fFreelancerCv);
        }
        if(c==freeProjet){
            traitement="projet accueil free";
            Thread th = new Thread(this);
            th.start();
        }
        if(c==freeAjouterFav){
            traitement="favoriser";
            Thread th = new Thread(this);
            th.start();
            
        }
        if (c == supprimerFreelancerCand) {
           
             Thread th = new Thread(this);
            th.start();
            traitement="candidature freelancer supprimer";
        }
        if (c == modifierFreelancerCand) {
         estimation.setString("");lettre_mot.setString(""); question.setString("");
         estimation.setString(Jobownercands[fFreelancerCandAffiche.getSelectedIndex()].getEstimation());
         lettre_mot.setString(Jobownercands[fFreelancerCandAffiche.getSelectedIndex()].getLettre_mot());
         question.setString(Jobownercands[fFreelancerCandAffiche.getSelectedIndex()].getQuestion());
       
     disp.setCurrent(fFreelanceCandModif);    
     
        }
         if (c == cmdValiderCandmodif) {
        
             Thread th = new Thread(this);
            th.start();
            traitement="candidature freelancer modif";
     
        }
         if (d==fFreelancerCand){
        traitement="candidature freelancer accueil";
        } 
        if (c == freecandida) {
            disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }
          if ((c == List.SELECT_COMMAND)&&(d==fFreelancerCandAffiche)) {
            fFreelancerCandAfficheOne.append("Informations candidature: \n");
            fFreelancerCandAfficheOne.append(showCandidature(fFreelancerCandAffiche.getSelectedIndex()));
            System.out.println( );
            disp.setCurrent(fFreelancerCandAfficheOne);
            System.out.println(Jobownercands[fFreelancerCandAffiche.getSelectedIndex()].getId());
        }
        if (c == supprimerCandJobowner) {
           
             Thread th = new Thread(this);
            th.start();
            traitement="candidature jobowner supprimer";
        }
        if (d==fJobownerCand){
        traitement="candidature jobowner accueil";
        } 
        if (c == jobCandidature) {
             disp.setCurrent(fJobownerCand);
        }
                if (c == freeCandidature) {
             disp.setCurrent(fFreelancerCand);
        }
        if (c == acceptCandJobowner) {
           
             Thread th = new Thread(this);
            th.start();
            traitement="candidature jobowner accept";
        }
        if ((c == List.SELECT_COMMAND)&&(d==fJobownerCandAffiche)) {
            fJobownerCandAfficheOne.append("Informations Candidature: \n");
            fJobownerCandAfficheOne.append(showCandidature(fJobownerCandAffiche.getSelectedIndex()));
            
            disp.setCurrent(fJobownerCandAfficheOne);
         System.out.println(Jobownercands[fJobownerCandAffiche.getSelectedIndex()].getId() );
        }
        if (c == jobcand) {
            disp.setCurrent(loadingDialog);traitement="candidature jobowner accueil";
            Thread th = new Thread(this);
            th.start();
        }
        if(c==freeCvAjout){
            disp.setCurrent(fFreelancerCvAjout);
        }
        if(c==jobProjet){
            disp.setCurrent(fJobownerProjet);
        }
        if(c==jobProjetAjout){
            disp.setCurrent(fJobownerProjetAjout);
        }
        if (d==fJobownerProjet){
        traitement="projet accueil";
        } 
        if (c == freeReclamation) {
            disp.setCurrent(fFreelancerRecAjout);
        }
        if (c == jobReclamation) {
            disp.setCurrent(fFreelancerRecAjout);
        }
        if (c == InscriptionFree) {
            disp.setCurrent(fInscriptionFree);
        }
        if (c == InscriptionJob) {
            disp.setCurrent(fInscriptionJob);
        }
        if (c == cmdParse) {
            //disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }

        if ((c == List.SELECT_COMMAND)&&(d==fJobownerProjetAffiche)) {
            fJobownerProjetAfficheOne.append("Informations Projet: \n");
            fJobownerProjetAfficheOne.append(showProjet(fJobownerProjetAffiche.getSelectedIndex()));
            disp.setCurrent(fJobownerProjetAfficheOne);
         
        }
        if ((c == List.SELECT_COMMAND)&&(d==fFreelancerProjetAffiche)) {
            fFreelancerProjetAfficheOne.append("Informations Projet: \n");
            fFreelancerProjetAfficheOne.append(showProjet(fFreelancerProjetAffiche.getSelectedIndex()));
            disp.setCurrent(fFreelancerProjetAfficheOne);
         
        }
         if(c==freeAjouterCandidature){
            disp.setCurrent(fFreelancerCandidature);
        }
         if ((c == cmdValider)&&(d==fFreelancerCandidature)) {
            traitement="Envoyer Candidature";
            Thread th = new Thread(this);
            th.start();
        }
        if (c == supprimerProjet) {
           
             Thread th = new Thread(this);
            th.start();
            traitement="projet supprimer";
        }
        
        if (c == modifierProjet) {
         System.out.println("Projet*******************");
         tftitremodif.setString("");//dureeprojetmodif.setValue(1);
         tfcategoriemodif.setString("");tfdescmodif.setString("");
         tftitremodif.insert(Projets[fJobownerProjetAffiche.getSelectedIndex()].getTitre(), 0);
        tfcategoriemodif.insert(Projets[fJobownerProjetAffiche.getSelectedIndex()].getCategorie(), 0);
       // dureeprojetmodif.setValue(Integer.parseInt(Projets[fJobownerProjetAffiche.getSelectedIndex()].getDuree()));
        tfdescmodif.insert(Projets[fJobownerProjetAffiche.getSelectedIndex()].getDescription(), 0);
        disp.setCurrent(fJobownerProjetModif);    
     
        }
        if (c == Statistique) {
            disp.setCurrent(formStatistique);
        }
        if (c == statprojet) {
            Thread th = new Thread(this);
            th.start();
            traitement = "StatProjet";
        }
        if (c == statpays) {
            Thread th = new Thread(this);
            th.start();
            traitement = "StatPays";
        }
        if ((c == cmdValider)&&(d==fJobownerProjetModif)) {
           
             Thread th = new Thread(this);
            th.start();
            traitement="projet modif";
        }
        if (c == modifierFreelancer) {
                
        tfdisponibiliteFreelacer.deleteAll();
        tfnomFreelacer.setString("");tfprenomFreelacer.setString("");
         tfpseudoFreelacer.setString("");tfpaysFreelacer.setString("");
         tfvilleFreelacer.setString("");tfemailFreelacer.setString("");//tfdFreelacerisponibilite.setString("");
         tfnomFreelacer.setString(freelancers[0].getNom());tfprenomFreelacer.setString(freelancers[0].getPrenom());
         tfpseudoFreelacer.setString(freelancers[0].getPseudo());tfpaysFreelacer.setString(freelancers[0].getPays());
         tfvilleFreelacer.setString(freelancers[0].getVille());tfemailFreelacer.setString(freelancers[0].getMail());//tfdisponibilite.setString(freelancers[lst.getSelectedIndex()].getDisponibilite());
         if("indisponible".equals(freelancers[0].getDisponibilite())){
              tfdisponibiliteFreelacer.append("disponible", null);
             tfdisponibiliteFreelacer.append("indisponible", null);
            
        
         }
          if("disponible".equals(freelancers[0].getDisponibilite())){
             tfdisponibiliteFreelacer.append("indisponible", null);
             tfdisponibiliteFreelacer.append("disponible", null);
         
         }
       tfdisponibiliteFreelacer.setSelectedIndex(1, true);
        disp.setCurrent(fFreelancerModif);    
          
        }
          if (c == cmdValiderFreelancerModif) {
        
             Thread th = new Thread(this);
            th.start();
            traitement="Freelancer modifier Profil";
     
        }
          /*Messagerie*/
          if(c==EnvoyerMessageFreelancer){
          tfmessageFreelacer.setString("");  tfsujetFreelacer.setString("");
          disp.setCurrent(fFreelancerenvoyerMessage);
          }
          if(c==cmdValiderFreelancerEnoyerMessage){
          Thread th = new Thread(this);
            th.start();
            traitement="Freelancer enoyer Message";
          }
          /*Messagerie*/
          /*Messagerie*/
          if(c==EnvoyerMessageJobowner){
          tfmessageJobowner.setString("");  tfsujetJobowner.setString("");
          disp.setCurrent(fJobownerenvoyerMessage);
          }
          if(c==cmdValiderJobownerEnoyerMessage){
          Thread th = new Thread(this);
            th.start();
            traitement="Jobowner enoyer Message";
          }
          /*Messagerie*/
    }

    public void run() {
         if( traitement=="contacter mail"){
             
     try { 
         System.out.println("**********");
         messagecontacterMail=tfUsernamecontacterMail.getString().trim()+"<br/>"+tfPrenomcontacterMail.getString().trim();
         System.out.println();
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/mail/PHPMailer-master/sendphpmailer2.php"+"?sujet="+tfNomcontacterMail.getString().trim()+"&message="+messagecontacterMail);
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    disp.setCurrent(alerta1contacterMail, fLogin);
                }else{
                    disp.setCurrent(alertacontacterMail, fLogin);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    
    
    
    }
        if(traitement=="map"){
           try {
               System.out.println("******************************");
            // this will handle our XML
            LocalisationHandler localisationHandler = new LocalisationHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)

            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/map/getXmlPersons_Attributes.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                
            parser.parse(dis, localisationHandler);
            // display the result
                
            localisations = localisationHandler.getLocalisation();
                
            if (localisations.length > 0) {
                
                for (int i = 0; i < localisations.length; i++) {
                    
                    if (localisations[i].getNom().equals(tfPaysmaps.getString())){
                         System.out.println(""+tfPaysmaps.getString());
                          
                       
                           disp.setCurrent(new GoogleMapsZoomCanvas(this, fmap,Double.parseDouble(localisations[i].getLongitude()),Double.parseDouble(localisations[i].getLatitude())));
                    }
                    

                }
                
                
               
                
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
    }
        if( traitement=="Freelancer affichage"){
        try {
            fFreelancerAffich.deleteAll();
             fFreelancer.deleteAll();
             fFreelancerAffichone.deleteAll();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // this will handle our XML
            FreelancerHandler membresHandler = new  FreelancerHandler();
            // get a parser object
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/freelancer/getXmlPersons_Attributes.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, membresHandler);
            // display the result
            freelancers = membresHandler.getFreelancer();

            if (freelancers.length > 0) {
                for (int i = 0; i < freelancers.length; i++) {
                    fFreelancerAffich.append(freelancers[i].getNom()+" "
                            +freelancers[i].getPrenom(), null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(fFreelancerAffich);}
        
        if (  traitement=="jobowner affichage"){
        try {
             fjobownerAffich.deleteAll();
             fJobowner.deleteAll();
             fjobownerAffichOne.deleteAll();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // this will handle our XML
            MembreHandler membresHandler = new MembreHandler();
            // get a parser object
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/Jobowner/getXmlPersons_Attributes.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, membresHandler);
            // display the result
            Jobownermembres = membresHandler.getMembre();

            if (Jobownermembres.length > 0) {
                for (int i = 0; i < Jobownermembres.length; i++) {
                    fjobownerAffich.append(Jobownermembres[i].getNom()+" "
                            +Jobownermembres[i].getPrenom(), null);

                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(fjobownerAffich);
        }
        if (  traitement=="jobowner affichage Profil"){
        try {
           
             fJobownerProfil.deleteAll();
             fjobownerAffichOneProfil.deleteAll();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // this will handle our XML
            MembreHandler membresHandler = new MembreHandler();
            // get a parser object
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/JobownerProfil/getXmlPersons_Attributes.php"+"?username="+logged);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, membresHandler);
            // display the result
            Jobownermembres = membresHandler.getMembre();

            

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
    fjobownerAffichOneProfil.append("Informations Profil: \n");
            fjobownerAffichOneProfil.append(showMembre(0));
            disp.setCurrent(fjobownerAffichOneProfil);
        }
        if( traitement=="Freelancer affichage Profil"){
        try {
                fFreelancerProfil.deleteAll();
             fFreelancerAffichoneProfil.deleteAll();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // this will handle our XML
            FreelancerHandler membresHandler = new  FreelancerHandler();
            // get a parser object
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/freelancerProfil/getXmlPersons_Attributes.php"+"?username="+logged);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, membresHandler);
            // display the result
            freelancers = membresHandler.getFreelancer();


        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
         fFreelancerAffichoneProfil.append("Informations Membre: \n");
            fFreelancerAffichoneProfil.append(showFreelancer(0));
            disp.setCurrent(fFreelancerAffichoneProfil);
      }
          if (  traitement=="Freelancer modifier Profil"){
        try { HttpConnection hc;
    DataInputStream dis;int ch;
 
     
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/freelancerProfil/modifier.php"+"?nom="+tfnomFreelacer.getString().trim()+"&prenom="+tfprenomFreelacer.getString().trim()+"&pseudo="+tfpseudoFreelacer.getString().trim()+"&pays="+tfpaysFreelacer.getString().trim()
                        +"&ville="+tfvilleFreelacer.getString().trim()+"&email="+tfemailFreelacer.getString().trim()+"&disponibilite="+tfdisponibiliteFreelacer.getString(tfdisponibiliteFreelacer.getSelectedIndex()).trim()+"&id="+freelancers[0].getId());
                dis = new DataInputStream(hc.openDataInputStream());
                 while ((ch = dis.read()) != -1) {
                    sb3.append((char)ch);
                }
                if ("OK".equals(sb3.toString().trim())) {
                 
                   fFreelancerAffichoneProfil.deleteAll();
                   disp.setCurrent(fFreelancerMenu);
                    
                    dis.close();
                }else{
                     
                   
                   fFreelancerAffichoneProfil.deleteAll();
                   disp.setCurrent(fFreelancerMenu);
                    
                  
               
                   
                    dis.close();
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (  traitement=="jobowner modifier Profil"){
            
        try { HttpConnection hc;
    DataInputStream dis;int ch;
 
     
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/JobownerProfil/modifier.php"+"?nom="+tfnomJobowner.getString().trim()+"&prenom="+tfprenomJobowner.getString().trim()+"&pseudo="+tfpseudoJobowner.getString().trim()+"&pays="+tfpaysJobowner.getString().trim()
                        +"&ville="+tfvilleJobowner.getString().trim()+"&email="+tfemailJobowner.getString().trim()+"&societe="+tfsocieteJobowner.getString().trim()+"&id="+Jobownermembres[0].getId()+"?username="+logged);
                dis = new DataInputStream(hc.openDataInputStream());
                 while ((ch = dis.read()) != -1) {
                    sb3.append((char)ch);
                }
                if ("OK".equals(sb3.toString().trim())) {
                 
                   fjobownerAffichOneProfil.deleteAll();
                   disp.setCurrent(fJobownerMenu);
                    
                    dis.close();
                }else{
                     
                  
                   fjobownerAffichOneProfil.deleteAll();
                   disp.setCurrent(fJobownerMenu);
                    
                  
               
                   
                    dis.close();
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(traitement=="login"){
        try {
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/login.php"+"?login="+tfLogin.getString().trim()
                                        +"&pass="+tfPass.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("free".equals(sb.toString().trim())) {
                    logged=tfLogin.getString();type="free";
                    fFreelancerMenu.setTitle(fFreelancerMenu.getTitle()+" : "+logged);
                    disp.setCurrent(connectionOk, fFreelancerMenu);
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
                }else if ("job".equals(sb.toString().trim())) {
                    
                    disp.setCurrent(connectionOk, fJobownerMenu);
                    try {
                        type="job";
                    logged=tfLogin.getString();
                    
                        player2 = Manager.createPlayer(getClass().getResourceAsStream("/audio/welcome.wav"), "audio/x-wav");
                     player2.setLoopCount(1);
            player2.start();
          //  Thread.sleep(10000);//set for 5 seconds
           player.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (MediaException ex) {
                        ex.printStackTrace();
                    
                    }fJobownerMenu.setTitle(fJobownerMenu.getTitle()+" : "+logged);
                }else if ("admin".equals(sb.toString().trim())) {
                    disp.setCurrent(fa);
                }else if (("OK".equals(sb.toString().trim()))&&("free".equals(type))) {
                    disp.setCurrent(fFreelancerMenu);
                }else if (("OK".equals(sb.toString().trim()))&&("job".equals(type))) {
                    disp.setCurrent(fJobownerMenu);
                }else{
                    disp.setCurrent(connectionKo, fLogin);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
        if (traitement == "reclamation ajout") {
            try {
                Date d = new Date();
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/reclamation/reclamationAjouter.php" + "?pseudo=" + logged
                        + "&sujet=" + tfR_sujet.getString().trim()
                        + "&message=" + tfR_message.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char) ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    if("free".equals(type))
                        disp.setCurrent(fFreelancerMenu);
                    if("job".equals(type))
                        disp.setCurrent(fJobownerMenu);
                } else {
                    if("free".equals(type))
                        disp.setCurrent(fFreelancerMenu);
                    if("job".equals(type))
                        disp.setCurrent(fJobownerMenu);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if (traitement == "Inscription Freelancer") {
            try {

                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/Freelancer/ajout.php" + "?nom=" + tfNom.getString().trim()
                        + "&email=" + tfEmail.getString().trim() + "&password=" + tfPassword.getString().trim()
                        + "&pays=" + lpaysfree.getString(lpaysfree.getSelectedIndex()).trim() + "&prenom=" + tfPrenom.getString().trim()
                        + "&username=" + tfPseudo.getString().trim() + "&ville=" + tfVille.getString().trim());

                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char) ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    
                    logged=tfLogin.getString();type="free";
                    fFreelancerMenu.setTitle(fFreelancerMenu.getTitle()+" : "+logged);
                    disp.setCurrent(connectionOk, fFreelancerMenu);
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
                } else {
                    disp.setCurrent(fErreur);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (traitement == "Inscription Jobowner") {
            try {

                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/Jobowner/JobownerInscription.php" + "?nom=" + tfJNom.getString().trim()
                        + "&email=" + tfJEmail.getString().trim() + "&password=" + tfJPassword.getString().trim()
                        + "&pays=" +lpaysjob.getString(lpaysjob.getSelectedIndex()).trim() + "&prenom=" + tfJPrenom.getString().trim()
                        + "&username=" + tfJPseudo.getString().trim() + "&ville=" + tfJVille.getString() + "&societe=" + tfJSociete.getString().trim());

                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char) ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    
                    logged=tfLogin.getString();type="job";
                    fFreelancerMenu.setTitle(fFreelancerMenu.getTitle()+" : "+logged);
                    disp.setCurrent(connectionOk, fFreelancerMenu);
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
                } else {
                    disp.setCurrent(fErreur);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(traitement=="cv ajout"){
                 try {
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/cv/ajout.php"+"?pseudo="+logged
                                        +"&exp="+tfExp_cv.getString().trim()
                                        +"&langue="+tfLangue_cv.getString().trim()
                                        +"&certif="+tfCertif_cv.getString().trim()
                                        +"&formation="+tfForma_cv.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    disp.setCurrent(fFreelancerMenu);
                }else{
                    disp.setCurrent(fErreur);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
            if(traitement=="projet ajout"){
                 try {
                     System.out.println(lcategorieprojet.getString(lcategorieprojet.getSelectedIndex()).trim()+" :::   "+dureeprojet.getValue());
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/projet/ajout.php"+"?pseudo="+logged
                                        +"&titre="+tftitre.getString().trim()
                                        +"&categ="+lcategorieprojet.getString(lcategorieprojet.getSelectedIndex()).trim()
                                        +"&duree="+dureeprojet.getValue()
                                        +"&desc="+tfdesc.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    disp.setCurrent(fJobownerMenu);
                }else{
                    
                    disp.setCurrent(fJobownerMenu);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
            if (traitement=="projet accueil free"){
        try {
            fFreelancerProjetAfficheOne.deleteAll();
                     fFreelancerProjetAffiche.deleteAll();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // this will handle our XML
            ProjetHandler membresHandler = new ProjetHandler();
            // get a parser object
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/projet/getXmlPersons_Attributes.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, membresHandler);
            // display the result
            Projets = membresHandler.getProjet();

            if (Projets.length > 0) {
                for (int i = 0; i < Projets.length; i++) {
                    fFreelancerProjetAffiche.append(Projets[i].getTitre()+" "
                            +Projets[i].getCategorie(), null);

                }
            }
       
        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(fFreelancerProjetAffiche);
         /*fin affichage*/}
            if (traitement=="cv accueil"){
        try {
            fFreelancerCvAfficheOne.deleteAll();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
          
            cvHandler membresHandler = new cvHandler();
            
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/cv/getXmlPersons_Attributes.php"+"?username="+logged);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, membresHandler);
         
            cvs = membresHandler.getcv();

         
       
        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
      fFreelancerCvAfficheOne.append("Informations CV: \n");
             fFreelancerCvAfficheOne.append(showcv(0));
            System.out.println( );
            disp.setCurrent(fFreelancerCvAfficheOne);
         /*fin affichage*/}
        if( traitement=="cv supprimer"){try {
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/cv/supprimer.php"+"?id="+cvs[0].getId());
                dis = new DataInputStream(hc.openDataInputStream());
                 while ((ch = dis.read()) != -1) {
                    sb2.append((char)ch);
                }
                if ("OK".equals(sb2.toString().trim())) {
                 
                    fFreelancerCvAfficheOne.deleteAll();
                     fFreelancerCvAfficheOne.deleteAll();
                    disp.setCurrent(fFreelancerCv);
                 
                }else{
                    disp.setCurrent(f3);
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }}
        if(traitement=="cv modif"){try {

                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/cv/modifier.php"+"?exp="+tfExperience.getString().trim()+"&cert="+tfCertification.getString().trim()+"&form="+tfFormation.getString().trim()+"&Lang="+tfLangue.getString().trim()+"&id="+cvs[0].getId());
                dis = new DataInputStream(hc.openDataInputStream());
                 while ((ch = dis.read()) != -1) {
                    sb3.append((char)ch);
                }
                if ("OK".equals(sb3.toString().trim())) {
                   
                    fFreelancerCvAfficheOne.deleteAll();
                    
                  
                    disp.setCurrent(fFreelancerCv);
                    
                    dis.close();
                }else{
                     
                    fFreelancerCvAfficheOne.deleteAll();
                    disp.setCurrent(fFreelancerCv);
                    dis.close();
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }}
            /*affichage*/
       if (traitement=="projet accueil"){
        try {
            fJobownerProjetAfficheOne.deleteAll();
                     fJobownerProjetAffiche.deleteAll();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // this will handle our XML
            ProjetHandler membresHandler = new ProjetHandler();
            // get a parser object
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/projet/getXmlPersons_Attributes2.php?pseu="+logged);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, membresHandler);
            // display the result
            Projets = membresHandler.getProjet();

            if (Projets.length > 0) {
                for (int i = 0; i < Projets.length; i++) {
                    fJobownerProjetAffiche.append(Projets[i].getTitre()+" "
                            +Projets[i].getCategorie(), null);

                }
            }
       
        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(fJobownerProjetAffiche);
         /*fin affichage*/}
       
         if( traitement=="projet supprimer"){
             try {
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/projet/supprimer.php"+"?id="+Projets[fJobownerProjetAffiche.getSelectedIndex()].getId());
                dis = new DataInputStream(hc.openDataInputStream());
                 while ((ch = dis.read()) != -1) {
                    sb2.append((char)ch);
                }
                if ("OK".equals(sb2.toString().trim())) {
                 
                    fJobownerProjetAfficheOne.deleteAll();
                     fJobownerProjetAffiche.deleteAll();
                    disp.setCurrent(fJobownerProjet);
                 
                }else{
                    disp.setCurrent(fErreur);
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
         }
         if(traitement=="projet modif"){
             try {

                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/projet/modifier.php"+"?titre="+tftitremodif.getString().trim()+"&desc="+tfdescmodif.getString().trim()+"&duree="+dureeprojetmodif.getValue()+"&cat="+tfcategoriemodif.getString().trim()+"&id="+Projets[fJobownerProjetAffiche.getSelectedIndex()].getId());
                dis = new DataInputStream(hc.openDataInputStream());
                 while ((ch = dis.read()) != -1) {
                    sb3.append((char)ch);
                }
                if ("OK".equals(sb3.toString().trim())) {
                   
                    fJobownerProjetAfficheOne.deleteAll();
                    fJobownerProjetAffiche.deleteAll();
                  
                    disp.setCurrent(fJobownerProjet);
                    
                    dis.close();
                }else{
                     
                    disp.setCurrent(fJobownerProjet);
                    
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
         }
         if(traitement=="favoriser"){
                 try {
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/favoris/ajout.php"+"?pseudo="+logged+"&idp="+Projets[fFreelancerProjetAffiche.getSelectedIndex()].getId());
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char)ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    disp.setCurrent(fFreelancerMenu);
                }else{
                    disp.setCurrent(fFreelancerMenu);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
         if (traitement == "Envoyer Candidature") {
            try {

                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/candidature/EnvoyerCandidature.php" + "?pseudo=" + logged 
                        +"&idprojet="+Projets[fFreelancerProjetAffiche.getSelectedIndex()].getId()
                        + "&estimation=" + tfEstimation.getString().trim() + "&lettre_mot=" + tfLettreMot.getString().trim()
                        + "&question=" + tfQuestion.getString().trim());

                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char) ch);
                }
                if ("OK".equals(sb.toString().trim())) {
                    disp.setCurrent(fFreelancerMenu);
                } else {
                    disp.setCurrent(fErreur);
                    System.out.println(Projets[fFreelancerProjetAffiche.getSelectedIndex()].getId());
                     System.out.println(logged);
                }
                sb = new StringBuffer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
         if (traitement == "StatProjet") {
             
            try {

                url = ("http://localhost/pidev_mobile/stat/projet/web.php");
                hc = (HttpConnection) Connector.open(url);
                ds = hc.openDataInputStream();
                int ch;
                conca = new StringBuffer();
                while ((ch = ds.read()) != -1) {
                    conca.append((char) ch);
                }
                resServeur = Integer.parseInt((conca.toString()).trim());
                nbweb = resServeur;
                //nbphotoshop=8;
                System.out.println("**jour*" + resServeur + "***");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //java
            try {

                url = ("http://localhost/pidev_mobile/stat/projet/java.php");
                hc = (HttpConnection) Connector.open(url);
                ds = hc.openDataInputStream();
                int ch;
                conca = new StringBuffer();
                while ((ch = ds.read()) != -1) {
                    conca.append((char) ch);
                }
                resServeur = Integer.parseInt((conca.toString()).trim());
                nbjava = resServeur;
                //nbphotoshop=8;
                System.out.println("**jour*" + resServeur + "***");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //photoshop
            try {

                url = ("http://localhost/pidev_mobile/stat/projet/photoshop.php");
                hc = (HttpConnection) Connector.open(url);
                ds = hc.openDataInputStream();
                int ch;
                conca = new StringBuffer();
                while ((ch = ds.read()) != -1) {
                    conca.append((char) ch);
                }
                resServeur = Integer.parseInt((conca.toString()).trim());
                nbphotoshop = resServeur;
                //nbphotoshop=8;
                System.out.println("**jour*" + resServeur + "***");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //photoshop
            try {

                url = ("http://localhost/pidev_mobile/stat/projet/phyton.php");
                hc = (HttpConnection) Connector.open(url);
                ds = hc.openDataInputStream();
                int ch;
                conca = new StringBuffer();
                while ((ch = ds.read()) != -1) {
                    conca.append((char) ch);
                }
                resServeur = Integer.parseInt((conca.toString()).trim());
                nbphyton = resServeur;
                //nbphotoshop=8;
                System.out.println("**jour*" + resServeur + "***");

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            //c#
            try {

                url = ("http://localhost/pidev_mobile/stat/projet/c#.php");
                hc = (HttpConnection) Connector.open(url);
                ds = hc.openDataInputStream();
                int ch;
                conca = new StringBuffer();
                while ((ch = ds.read()) != -1) {
                    conca.append((char) ch);
                }
                resServeur = Integer.parseInt((conca.toString()).trim());
                nbcsharp = resServeur;
                //nbphotoshop=8;
                System.out.println("**jour*" + resServeur + "***");

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            disp.setCurrent(d1);
        }
        
        //Stistique des membres par pays 
        if (traitement == "StatPays") {
            try {

                url = ("http://localhost/pidev_mobile/stat/pays/tunisie.php");
                hc = (HttpConnection) Connector.open(url);
                ds = hc.openDataInputStream();
                int ch;
                conca = new StringBuffer();
                while ((ch = ds.read()) != -1) {
                    conca.append((char) ch);
                }
                resServeur = Integer.parseInt((conca.toString()).trim());
                nbtunisie = resServeur;
                //nbphotoshop=8;
                System.out.println("**jour*" + resServeur + "***");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //java
            try {

                url = ("http://localhost/pidev_mobile/stat/pays/france.php");
                hc = (HttpConnection) Connector.open(url);
                ds = hc.openDataInputStream();
                int ch;
                conca = new StringBuffer();
                while ((ch = ds.read()) != -1) {
                    conca.append((char) ch);
                }
                resServeur = Integer.parseInt((conca.toString()).trim());
                nbfrance = resServeur;
                //nbphotoshop=8;
                System.out.println("**jour*" + resServeur + "***");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //photoshop
            try {

                url = ("http://localhost/pidev_mobile/stat/pays/canada.php");
                hc = (HttpConnection) Connector.open(url);
                ds = hc.openDataInputStream();
                int ch;
                conca = new StringBuffer();
                while ((ch = ds.read()) != -1) {
                    conca.append((char) ch);
                }
                resServeur = Integer.parseInt((conca.toString()).trim());
                nbcanada = resServeur;
                //nbphotoshop=8;
                System.out.println("**jour*" + resServeur + "***");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //photoshop
            try {

                url = ("http://localhost/pidev_mobile/stat/pays/amerique.php");
                hc = (HttpConnection) Connector.open(url);
                ds = hc.openDataInputStream();
                int ch;
                conca = new StringBuffer();
                while ((ch = ds.read()) != -1) {
                    conca.append((char) ch);
                }
                resServeur = Integer.parseInt((conca.toString()).trim());
                nbamerique = resServeur;
                //nbphotoshop=8;
                System.out.println("**jour*" + resServeur + "***");

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            //c#
            try {

                url = ("http://localhost/pidev_mobile/stat/pays/italie.php");
                hc = (HttpConnection) Connector.open(url);
                ds = hc.openDataInputStream();
                int ch;
                conca = new StringBuffer();
                while ((ch = ds.read()) != -1) {
                    conca.append((char) ch);
                }
                resServeur = Integer.parseInt((conca.toString()).trim());
                nbitalie = resServeur;
                //nbphotoshop=8;
                System.out.println("**jour*" + resServeur + "***");

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            disp.setCurrent(d1);
        }
        
        if (traitement=="candidature jobowner accueil"){
        try {fJobownerCandAfficheOne.deleteAll();
                     fJobownerCandAffiche.deleteAll();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // this will handle our XML
            candidatureHandler candHandler = new candidatureHandler();
            // get a parser object
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/candidature/Jobowner/getXmlPersons_Attributes.php"+"?username="+logged);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, candHandler);
            // display the result
            Jobownercands = candHandler.getcandidature();

            if (Jobownercands.length > 0) {
                for (int i = 0; i < Jobownercands.length; i++) {
                    fJobownerCandAffiche.append(Jobownercands[i].getPseufreelancer()+" "
                            +Jobownercands[i].getEstimation(), null);
                   
                         
                }
            }
       
        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(fJobownerCandAffiche);
         /*fin affichage*/}
         if( traitement=="candidature jobowner supprimer"){try {
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/candidature/Jobowner/supprimer.php"+"?id="+Jobownercands[fJobownerCandAffiche.getSelectedIndex()].getId());
                dis = new DataInputStream(hc.openDataInputStream());
                 while ((ch = dis.read()) != -1) {
                    sb2.append((char)ch);
                }
                if ("OK".equals(sb2.toString().trim())) {
                 
                    fJobownerCandAfficheOne.deleteAll();
                     fJobownerCandAffiche.deleteAll();
                    disp.setCurrent(fJobownerCand);
                 
                }else{
                    disp.setCurrent(fJobownerCand);
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }}
     if (traitement=="candidature freelancer accueil"){
        try {
            fFreelancerCandAfficheOne.deleteAll();
                     fFreelancerCandAffiche.deleteAll();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // this will handle our XML
            candidatureHandler candHandler = new candidatureHandler();
            // get a parser object
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/candidature/freelancer1/getXmlPersons_Attributes.php"+"?username="+logged);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, candHandler);
            // display the result
            Jobownercands = candHandler.getcandidature();

            if (Jobownercands.length > 0) {
                for (int i = 0; i < Jobownercands.length; i++) {
                    fFreelancerCandAffiche.append(Jobownercands[i].getPseufreelancer()+" "
                            +Jobownercands[i].getEstimation(), null);

                }
            }
       
        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        disp.setCurrent(fFreelancerCandAffiche);
         /*fin affichage*/}
         if( traitement=="candidature freelancer supprimer"){try {
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/candidature/freelancer1/supprimer.php"+"?id="+Jobownercands[fFreelancerCandAffiche.getSelectedIndex()].getId());
                dis = new DataInputStream(hc.openDataInputStream());
                 while ((ch = dis.read()) != -1) {
                    sb2.append((char)ch);
                }
                if ("OK".equals(sb2.toString().trim())) {
                 
                    fFreelancerCandAfficheOne.deleteAll();
                     fFreelancerCandAffiche.deleteAll();
                    disp.setCurrent(fFreelancerCand);
                 
                }else{
                   fFreelancerCandAfficheOne.deleteAll();
                     fFreelancerCandAffiche.deleteAll();
                    disp.setCurrent(fFreelancerCand);
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }}
           if(traitement=="candidature freelancer modif"){try {

                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/candidature/Jobowner/modifier.php"+"?estimation="+estimation.getString().trim()+"&lettre="+lettre_mot.getString().trim()+"&question="+question.getString().trim()+"&id="+Jobownercands[fFreelancerCandAffiche.getSelectedIndex()].getId());
                dis = new DataInputStream(hc.openDataInputStream());
                 while ((ch = dis.read()) != -1) {
                    sb3.append((char)ch);
                }
                if ("OK".equals(sb3.toString().trim())) {
                   
                    fFreelancerCandAfficheOne.deleteAll();
                   disp.setCurrent(fFreelancerCand);
                    
                    dis.close();
                }else{
                     
                   fFreelancerCandAfficheOne.deleteAll();
                   disp.setCurrent(fFreelancerCand);
                    
                  
               
                   
                    dis.close();
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }}
     
    if( traitement=="candidature jobowner accept"){try {
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/candidature/Jobowner/accepter.php?id="+Jobownercands[fJobownerCandAffiche.getSelectedIndex()].getId_p()+"&pseu="+Jobownercands[fJobownerCandAffiche.getSelectedIndex()].getPseufreelancer());
                dis = new DataInputStream(hc.openDataInputStream());
                 while ((ch = dis.read()) != -1) {
                    sb3.append((char)ch);
                }
                if ("OK".equals(sb3.toString().trim())) {
                 
                    fJobownerCandAfficheOne.deleteAll();
                     fJobownerCandAffiche.deleteAll();
                    disp.setCurrent(fJobownerCand);
                 
                }else{
                    disp.setCurrent(f3);
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }}
    
   
    if (  traitement=="Freelancer enoyer Message"){
        try { HttpConnection hc;
    DataInputStream dis;int ch;
 
     
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/messagerie/ajout.php"+"?expediteur="+logged+"&recepteur="+freelancers[fFreelancerAffich.getSelectedIndex()].getPseudo()+"&sujet="+tfsujetFreelacer.getString().trim()+"&message="+tfmessageFreelacer.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                 while ((ch = dis.read()) != -1) {
                    sb3.append((char)ch);
                }
                if ("OK".equals(sb3.toString().trim())) {
                        // fFreelancerenvoyerMessage.deleteAll();

                /*   fFreelancerAffichoneProfil.deleteAll();*/
                //   disp.setCurrent(fFreelancerMenu);
               if(type=="free"){
                    disp.setCurrent(fFreelancerMenu);
                   }
                   if(type=="job"){
                     disp.setCurrent(fJobownerMenu);
                   }
                    
                  
                }else{
                     
                   
                  /* fFreelancerAffichoneProfil.deleteAll();
                   disp.setCurrent(fFreelancerProfil);*/
                    
                  if(type=="free"){
                    disp.setCurrent(fFreelancerMenu);
                   }
                   if(type=="job"){
                     disp.setCurrent(fJobownerMenu);
                   }
               
                   
                    dis.close();
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    
 if (  traitement=="Jobowner enoyer Message"){
        try { HttpConnection hc;
    DataInputStream dis;int ch;
 
     
                hc = (HttpConnection) Connector.open("http://localhost/pidev_mobile/messagerie/ajout.php"+"?expediteur="+logged+"&recepteur="+Jobownermembres[fjobownerAffich.getSelectedIndex()].getPseudo()+"&sujet="+tfsujetJobowner.getString().trim()+"&message="+tfmessageJobowner.getString().trim());
                dis = new DataInputStream(hc.openDataInputStream());
                 while ((ch = dis.read()) != -1) {
                    sb3.append((char)ch);
                }
                if ("OK".equals(sb3.toString().trim())) {
                        // fFreelancerenvoyerMessage.deleteAll();

             //   fFreelancerAffichoneProfil.deleteAll();
                   if(type=="free"){
                    disp.setCurrent(fFreelancerMenu);
                   }
                   if(type=="job"){
                     disp.setCurrent(fJobownerMenu);
                   }
                    
                  
                }else{
                     
                   
                  //fFreelancerAffichoneProfil.deleteAll();
                   //disp.setCurrent(fFreelancerProfil);
                    
                    disp.setCurrent(fFreelancerMenu);
               
                   
                    dis.close();
                }
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    
    }
    private String showProjet(int i) {
 String res = "";
        if (Projets.length > 0) {
            
            sb.append("* Titre : ");
            sb.append(Projets[i].getTitre());
            sb.append("\n");
            sb.append("* Categorie :  ");
            sb.append(Projets[i].getCategorie());
            sb.append("\n");
            sb.append("* Duree :  ");
            sb.append(Projets[i].getDuree());
            sb.append("\n");
            sb.append("* Description : ");
            sb.append(Projets[i].getDescription());
            sb.append("\n");
            sb.append("* Pseudo Jobowner:  ");
            sb.append(Projets[i].getPseudoJ());
            sb.append("\n");
            sb.append("* Pseudo Freelancer : ");
            sb.append(Projets[i].getPseudoF());
            sb.append("\n");
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
    private String showcv(int i) {
     String res = "";
        if (cvs.length > 0) {
            
            sb.append("* Experience : ");
            sb.append(cvs[i].getExperience());
            sb.append("\n");
            sb.append("* Formation :  ");
            sb.append(cvs[i].getFormation());
            sb.append("\n");
            sb.append("* Langue :  ");
            sb.append(cvs[i].getLangue());
            sb.append("\n");
            sb.append("* Certification : ");
            sb.append(cvs[i].getCertification());
            sb.append("\n");
            
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
    public class Draw extends Canvas {

        int w = getWidth();
        int h = getHeight();

        protected void paint(Graphics g) {
 
            
            if(traitement=="StatProjet")
            {
            g.setColor(255, 255, 255);
            g.fillRect(0, 0, getWidth(), getHeight());
            System.out.println("c'est canvas");
            System.out.println("photoshop=" + nbphotoshop + "web=" + nbweb + "java" + nbjava + "c#" + nbcsharp + "phyton" + nbphyton);
            float division = (float) 360 / (nbphotoshop + nbweb + nbjava + nbcsharp + nbphyton);

            System.out.println("div=" + division);

            g.setColor(0, 255, 0);
            int anglephotoshop = (int) (nbphotoshop * division);
            int angleweb = (int) (nbweb * division);
            int anglejava = (int) (nbjava * division);
            int anglecsharp = (int) (nbcsharp * division);
            int anglephyton = (int) (nbphyton * division);

            System.out.println("angle photoshop=" + anglephotoshop);
            System.out.println("angle web=" + angleweb);
            System.out.println("anglejava=" + anglejava);
            System.out.println("angle c#=" + anglecsharp);
            System.out.println("angle phyton=" + anglephyton);
            g.setColor(95, 158, 160);
            g.fillArc(getWidth() / 2 - 75, getHeight() / 2 - 140, 150, 150, 0, anglecsharp);
            g.setColor(0, 238, 238);
            g.fillArc(getWidth() / 2 - 75, getHeight() / 2 - 140, 150, 150, anglecsharp, anglejava);
            g.setColor(74, 112, 139);
            g.fillArc(getWidth() / 2 - 75, getHeight() / 2 - 140, 150, 150, anglecsharp + anglejava, anglephotoshop);
            g.setColor(141, 182, 205);
            g.fillArc(getWidth() / 2 - 75, getHeight() / 2 - 140, 150, 150, anglecsharp + anglejava + anglephotoshop, anglephyton);

            g.setColor(69, 139, 116);
            g.fillArc(getWidth() / 2 - 75, getHeight() / 2 - 140, 150, 150, anglecsharp + anglejava + anglephotoshop + anglephyton, 360-(anglecsharp + anglejava + anglephotoshop + anglephyton));

            ////legendes
            g.setColor(95, 158, 160);
            g.fillRect(20, getHeight() / 2 + 50, 10, 10);
            g.setColor(95, 158, 160);
            g.drawString("C#:"+anglecsharp*100/360+"%", 35, getHeight() / 2 + 65, Graphics.LEFT | Graphics.BOTTOM);

            g.setColor(0, 238, 238);
            g.fillRect(20, getHeight() / 2 + 75, 10, 10);
            g.setColor(0, 238, 238);
            g.drawString("Java:"+anglejava*100/360+"%", 35, getHeight() / 2 + 90, Graphics.LEFT | Graphics.BOTTOM);

            g.setColor(74, 112, 139);
            g.fillRect(120, getHeight() / 2 + 50, 10, 10);
            g.setColor(74, 112, 139);
            g.drawString("Photoshop:"+anglephotoshop*100/360+"%", 235, getHeight() / 2 + 65, Graphics.RIGHT | Graphics.BOTTOM);

            g.setColor(141, 182, 205);
            g.fillRect(120, getHeight() / 2 + 75, 10, 10);
            g.setColor(141, 182, 205);
            g.drawString("Phyton:"+anglephyton*100/360+"%", 215, getHeight() / 2 + 90, Graphics.RIGHT | Graphics.BOTTOM);

            g.setColor(69, 139, 116);
            g.fillRect(57, getHeight() / 2 + 100, 10, 10);
            g.setColor(69, 139, 116);
            g.drawString("Web:"+(360-(anglecsharp + anglejava + anglephotoshop + anglephyton))*100/360+"%", 135, getHeight() / 2 + 115, Graphics.RIGHT | Graphics.BOTTOM);

            g.setColor(0, 0, 0);
            g.drawString("Les projets par catégories", 35, getHeight() / 2 + 140, Graphics.LEFT | Graphics.BOTTOM);
        }
            
            //Stastique par pays membres
            if(traitement=="StatPays")
            {
            g.setColor(255, 255, 255);
            g.fillRect(0, 0, getWidth(), getHeight());
            System.out.println("c'est canvas");
            System.out.println("photoshop=" + nbphotoshop + "web=" + nbweb + "java" + nbjava + "c#" + nbcsharp + "phyton" + nbphyton);
            float division = (float) 360 / (nbtunisie + nbfrance + nbitalie + nbamerique + nbcanada);

            System.out.println("div=" + division);

            g.setColor(0, 255, 0);
            int angletunisie = (int) (nbtunisie * division);
            int anglefrance = (int) (nbfrance * division);
            int anglecanada = (int) (nbitalie * division);
            int angleamerique = (int) (nbamerique * division);
            int angleitalie = (int) (nbcanada * division);

            System.out.println("angle tunisie=" + angletunisie);
            System.out.println("angle france=" + anglefrance);
            System.out.println("angle canada=" + anglecanada);
            System.out.println("angle amerique=" + angleamerique);
            System.out.println("angle italie=" + angleitalie);

            g.setColor(95, 158, 160);
            g.fillArc(getWidth() / 2 - 75, getHeight() / 2 - 140, 150, 150, 0, angletunisie);
            g.setColor(0, 238, 238);
            g.fillArc(getWidth() / 2 - 75, getHeight() / 2 - 140, 150, 150, angletunisie, anglefrance);
            g.setColor(74, 112, 139);
            g.fillArc(getWidth() / 2 - 75, getHeight() / 2 - 140, 150, 150, angletunisie + anglefrance, anglecanada);
            g.setColor(141, 182, 205);
            g.fillArc(getWidth() / 2 - 75, getHeight() / 2 - 140, 150, 150, angletunisie + anglefrance + anglecanada, angleamerique);

            g.setColor(69, 139, 116);
            g.fillArc(getWidth() / 2 - 75, getHeight() / 2 - 140, 150, 150, angletunisie + anglefrance + anglecanada + angleamerique, 360-(angletunisie + anglefrance + anglecanada + angleamerique));

            ////legendes
            g.setColor(95, 158, 160);
            g.fillRect(20, getHeight() / 2 + 50, 10, 10);
            g.setColor(95, 158, 160);
            g.drawString("Tunisie:"+angletunisie*100/360+"%", 35, getHeight() / 2 + 65, Graphics.LEFT | Graphics.BOTTOM);

            g.setColor(0, 238, 238);
            g.fillRect(20, getHeight() / 2 + 75, 10, 10);
            g.setColor(0, 238, 238);
            g.drawString("France:"+anglefrance*100/360+"%", 35, getHeight() / 2 + 90, Graphics.LEFT | Graphics.BOTTOM);

            g.setColor(74, 112, 139);
            g.fillRect(130, getHeight() / 2 + 50, 10, 10);
            g.setColor(74, 112, 139);
            g.drawString("Canada:"+anglecanada*100/360+"%", 220, getHeight() / 2 + 65, Graphics.RIGHT | Graphics.BOTTOM);

            g.setColor(141, 182, 205);
            g.fillRect(130, getHeight() / 2 + 75, 10, 10);
            g.setColor(141, 182, 205);
            g.drawString("Amerique:"+angleamerique*100/360+"%", 230, getHeight() / 2 + 90, Graphics.RIGHT | Graphics.BOTTOM);

            g.setColor(69, 139, 116);
            g.fillRect(57, getHeight() / 2 + 100, 10, 10);
            g.setColor(69, 139, 116);
            g.drawString("Italie:"+(360-(angletunisie + anglefrance + anglecanada + angleamerique))*100/360+"%", 135, getHeight() / 2 + 115, Graphics.RIGHT | Graphics.BOTTOM);

            g.setColor(0, 0, 0);
            g.drawString("Les membres par pays", 35, getHeight() / 2 + 140, Graphics.LEFT | Graphics.BOTTOM);
        }
            
            
            
            
            
}
    }
    private char[] append(String showProjet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int getSelectedIndex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
     public class SplashScreen0 extends Canvas implements Runnable {

        private Image sp0Image;
        private Autentification projectMIDlet;

        /**
         * The constructor attempts to load the named image and begins a timeout
         * thread. The splash screen can be dismissed with a key press, a
         * pointer press, or a timeout
         *
         * @param projectMIDlet instance of MIDlet
         */
        public SplashScreen0(Autentification projectMIDlet) {
            this.projectMIDlet = projectMIDlet;
            try {
                sp0Image = Image.createImage("/Images/sp0.png");
                Thread t = new Thread(this);
                t.start();
            } catch (IOException e) {
            }
        }

        /**
         * Paints the image centered on the screen.
         */
        public void paint(Graphics g) {
            int width = getWidth();
            int height = getHeight();
            //set background color to overdraw what ever was previously displayed
            g.setColor(0x000000);
//        000000
            g.fillRect(0, 0, width, height);
            g.drawImage(sp0Image, width / 2, height / 2, Graphics.HCENTER | Graphics.VCENTER);
            repaint();
        }

        /**
         * Dismisses the splash screen with a key press or a pointer press
         */
        public void dismiss() {
            if (isShown()) {
               // Display.getDisplay(projectMIDlet).setCurrent(fLogin);
            }

        }

        /**
         * Default timeout with thread
         */
        public void run() {
            try {
                Thread.sleep(1000);//set for 3 seconds
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");

            }
            dismiss();
        }
        /**
         * A key release event triggers the dismiss() method to be called.
         */
    }
      public class SplashScreen1 extends Canvas implements Runnable {

        private Image sp1Image;
        private Autentification projectMIDlet;

        /**
         * The constructor attempts to load the named image and begins a timeout
         * thread. The splash screen can be dismissed with a key press, a
         * pointer press, or a timeout
         *
         * @param projectMIDlet instance of MIDlet
         */
        public SplashScreen1(Autentification projectMIDlet) {
            this.projectMIDlet = projectMIDlet;
            try {
                sp1Image = Image.createImage("/Images/sp1.png");
                Thread t = new Thread(this);
                t.start();
            } catch (IOException e) {
            }
        }

        /**
         * Paints the image centered on the screen.
         */
        public void paint(Graphics g) {
            int width = getWidth();
            int height = getHeight();
            //set background color to overdraw what ever was previously displayed
            g.setColor(0x000000);
//        000000
            g.fillRect(0, 0, width, height);
            g.drawImage(sp1Image, width / 2, height / 2, Graphics.HCENTER | Graphics.VCENTER);
            repaint();
        }

        /**
         * Dismisses the splash screen with a key press or a pointer press
         */
        public void dismiss() {
            if (isShown()) {
               // Display.getDisplay(projectMIDlet).setCurrent(fLogin);
            }

        }

        /**
         * Default timeout with thread
         */
        public void run() {
            try {
                Thread.sleep(1000);//set for 3 seconds
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");

            }
            dismiss();
        }
        /**
         * A key release event triggers the dismiss() method to be called.
         */
    }
      public class SplashScreen2 extends Canvas implements Runnable {

        private Image sp2Image;
        private Autentification projectMIDlet;

        /**
         * The constructor attempts to load the named image and begins a timeout
         * thread. The splash screen can be dismissed with a key press, a
         * pointer press, or a timeout
         *
         * @param projectMIDlet instance of MIDlet
         */
        public SplashScreen2(Autentification projectMIDlet) {
            this.projectMIDlet = projectMIDlet;
            try {
                sp2Image = Image.createImage("/Images/sp2.png");
                Thread t = new Thread(this);
                t.start();
            } catch (IOException e) {
            }
        }

        /**
         * Paints the image centered on the screen.
         */
        public void paint(Graphics g) {
            int width = getWidth();
            int height = getHeight();
            //set background color to overdraw what ever was previously displayed
            g.setColor(0x000000);
//        000000
            g.fillRect(0, 0, width, height);
            g.drawImage(sp2Image, width / 2, height / 2, Graphics.HCENTER | Graphics.VCENTER);
            repaint();
        }

        /**
         * Dismisses the splash screen with a key press or a pointer press
         */
        public void dismiss() {
            if (isShown()) {
                Display.getDisplay(projectMIDlet).setCurrent(fLogin);
            }

        }

        /**
         * Default timeout with thread
         */
        public void run() {
            try {
                Thread.sleep(1000);//set for 3 seconds
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");

            }
            dismiss();
        }
        /**
         * A key release event triggers the dismiss() method to be called.
         */
    }
  
        private String showCandidature(int i) {
        String res = "";
        if (Jobownercands.length > 0) {
            
            sb.append("* pseufreelancer : ");
            sb.append(Jobownercands[i].getPseufreelancer());
            sb.append("\n");
            sb.append("* estimation :  ");
            sb.append(Jobownercands[i].getEstimation());
            sb.append("\n");
            sb.append("* lettre_mot :  ");
            sb.append(Jobownercands[i].getLettre_mot());
            sb.append("\n");
            sb.append("* question : ");
            sb.append(Jobownercands[i].getQuestion());
            sb.append("\n");
            
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
      private String showMembre(int i) {
        String res = "";
        if (Jobownermembres.length > 0) {
            
            sb.append("* Prenom : ");
            sb.append(Jobownermembres[i].getPrenom());
            sb.append("\n");
            sb.append("* Nom :  ");
            sb.append(Jobownermembres[i].getNom());
            sb.append("\n");
            sb.append("* Pays :  ");
            sb.append(Jobownermembres[i].getPays());
            sb.append("\n");
            sb.append("* Ville : ");
            sb.append(Jobownermembres[i].getVille());
            sb.append("\n");
            sb.append("* Pseudo :  ");
            sb.append(Jobownermembres[i].getPseudo());
            sb.append("\n");
            sb.append("* Mail : ");
            sb.append(Jobownermembres[i].getMail());
            sb.append("\n");
             sb.append("* Societe : ");
            sb.append(Jobownermembres[i].getSociete());
            
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
      private String showFreelancer(int i) {
         String res = "";
        if (freelancers.length > 0) {
            
            sb.append("* Prenom : ");
            sb.append(freelancers[i].getPrenom());
            sb.append("\n");
            sb.append("* Nom :  ");
            sb.append(freelancers[i].getNom());
            sb.append("\n");
            sb.append("* Pays :  ");
            sb.append(freelancers[i].getPays());
            sb.append("\n");
            sb.append("* Ville : ");
            sb.append(freelancers[i].getVille());
            sb.append("\n");
            sb.append("* Pseudo :  ");
            sb.append(freelancers[i].getPseudo());
            sb.append("\n");
            sb.append("* Mail : ");
            sb.append(freelancers[i].getMail());
            sb.append("\n");
             sb.append("* Disponibilite : ");
            sb.append(freelancers[i].getDisponibilite());
            
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
      
}
