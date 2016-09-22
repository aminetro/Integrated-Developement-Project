<?php

namespace Freelance\BackOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Freelance\BackOfficeBundle\Entity\Administrateur;
use Freelance\BackOfficeBundle\Entity\membre;
use Freelance\BackOfficeBundle\Entity\Messagerie;
use Freelance\BackOfficeBundle\Form\AdministrateurForm;
use Freelance\BackOfficeBundle\Form\MessagerieForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of AdministrateurController
 *
 * @author Amine
 */
class AdministrateurController extends Controller {
    
     public function indexAction(){ 
        return $this->render('FreelanceBackOfficeBundle::Layout.html.twig');
    }
     
    public function TableAction(){    
        return $this->render('FreelanceBackOfficeBundle:Admin:Table.html.twig');
    }
    
  public function StatPaysAction(){    
        return $this->render('FreelanceBackOfficeBundle:Admin:StatistiqueParPays.html.twig');
    }
  public function StatProjetAction(){    
        return $this->render('FreelanceBackOfficeBundle:Admin:StatistiqueParProjet.html.twig');
    }
    
     public function GestionMessageAction(){    
        return $this->render('FreelanceBackOfficeBundle:Admin:GestionMessage.html.twig');
    }
    
 
     public function TableRecAction(){    
        return $this->render('FreelanceBackOfficeBundle:Admin:Reclamation.html.twig');
    }
    
     public function RepondreRecAction(){    
         
           $Messagerie = new Messagerie();
        $f= new MessagerieForm();
        $form=$this->createForm($f,$Messagerie);
        $request=$this->get('request');
        
    if(($form->handleRequest($request)->isValid())){
                $Messagerie->setDate(new \DateTime()); 
               
                $em=$this->getDoctrine()->getManager();
                $em->persist($Messagerie);
                $em->flush();
                
    }
       
          return $this->render('FreelanceBackOfficeBundle:Admin:RepondreRec.html.twig', array('form'=>$form->createView()));
          
    }
    
    
    
      
   
    
    
     public function modifierProfilAction($id){
        $em=$this->getDoctrine()->getManager();
        $admin = $em->getRepository('FreelanceBackOfficeBundle:Membre')->find($id);
        $a= new AdministrateurForm();
        $form=$this->createForm($a,$admin);
        $request=$this->get('request');
        if($request->getMethod()=="POST"){
            $form->bind($request);
            if($form->isValid()){
                
                $em->persist($admin);
                $em->flush();
                return $this->redirect($this->generateUrl('freelance_Back_ModifierProfil'));
            }
        }
        return $this->render('FreelanceBackOfficeBundle:Admin:ModifierProfil.html.twig',array('form'=>$form->createView(),'Administrateur'=>$admin));
    }
    

    public function AfficherAction() {

        $connection = $this->get('database_connection');

        $sql = "SELECT id,nom,prenom,pays,ville,pseudo,email FROM membre m, administrateur ad WHERE  m.id = ad.id_a ";
        $stmt = $connection->prepare($sql);
        $stmt->execute();


        return $this->render('FreelanceBackOfficeBundle:Admin:AfficherAdmin.html.twig', array('administrateur' => $stmt));
    }

    
    
   public function AfficherJobownerAction() {

        $connection = $this->get('database_connection');

        $sql = "SELECT id,nom, prenom, pays, ville, pseudo,email,societe_j FROM membre m, jobowner j WHERE m.id = j.id_j";
        $stmt = $connection->prepare($sql);
        $stmt->execute();
        return $this->render('FreelanceBackOfficeBundle:Admin:AffichageJobowner.html.twig', array('jobowner' => $stmt));
    }
    
   public function rechercherJobownerAction() {
        $connection = $this->get('database_connection');
        $sql = "SELECT id,nom, prenom, pays, ville, pseudo, PASSWORD , email, societe_j FROM membre m, jobowner j WHERE m.id = j.id_j";
        $stmt = $connection->prepare($sql);

        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
            $search = $Request->get('search');
            $sql = "SELECT id, nom, prenom, pays, ville, pseudo, PASSWORD , email,societe_j FROM jobowner j, membre m WHERE j.id_j = m.id AND m.pseudo =  ?";
            $stmt = $connection->prepare($sql);
            $stmt->bindValue(1, $search);
            $stmt->execute();
        }
        $stmt->execute();
        return $this->render('FreelanceBackOfficeBundle:Admin:RechercheJobowner.html.twig', array('jobowner' => $stmt));
    }

    public function supprimerJobownerAction($id) {

        $connection = $this->get('database_connection');

        $sql = "DELETE  FROM membre  WHERE  id =$id ";
        $stmt = $connection->prepare($sql);
        $stmt->execute();

        return $this->redirect($this->generateUrl('freelance_Back_TableAdmin'));
    }

    public function rechercherJoobownerAction() {
        $connection = $this->get('database_connection');
        $sql = "SELECT id,nom, prenom, pays, ville, pseudo , email, societe_j FROM membre m, jobowner j WHERE m.id = j.id_j";
        $stmt = $connection->prepare($sql);

        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
            $search = $Request->get('search');
            $sql = "SELECT id, nom, prenom, pays, ville, pseudo , email,societe_j FROM jobowner j, membre m WHERE j.id_j = m.id AND m.pseudo =  ?";
            $stmt = $connection->prepare($sql);
            $stmt->bindValue(1, $search);
            $stmt->execute();
        }
        $stmt->execute();
        return $this->render('FreelanceBackOfficeBundle:Admin:RechercheJobowner.html.twig', array('jobowners' => $stmt));
    }

   
    
    
    
    public function AfficherFreelancerAction() {

        $connection = $this->get('database_connection');

        $sql = "SELECT id,nom, prenom, pays, ville, pseudo, email, disponibilite_f FROM membre m, freelancer f WHERE m.id = f.id_f";
        $stmt = $connection->prepare($sql);

        $stmt->execute();

        return $this->render('FreelanceBackOfficeBundle:Admin:AffichageFreelancer.html.twig', array('membre' => $stmt));
    }

    public function rechercherFreelancerAction() {
        $connection = $this->get('database_connection');
        $dql = "SELECT id,nom, prenom, pays, ville, pseudo, email, disponibilite_f FROM membre m, freelancer f WHERE m.id = f.id_f";
        $stmt = $connection->prepare($dql);

        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
            $search = $Request->get('search');
            $dql = "SELECT id, nom, prenom, pays, ville, pseudo , email,disponibilite_f FROM freelancer f, membre m WHERE f.id_f = m.id AND m.pseudo =  ?";
            $stmt = $connection->prepare($dql);
            $stmt->bindValue(1, $search);
            $stmt->execute();
        }
        $stmt->execute();
        return $this->render('FreelanceBackOfficeBundle:Admin:RechercheFreelancer.html.twig', array('freelancer' => $stmt));
    }

    public function supprimerfreelancerAction($id) {

        $connection = $this->get('database_connection');

        $sql = "DELETE  FROM membre  WHERE  id =$id ";
        $stmt = $connection->prepare($sql);
        $stmt->execute();

        return $this->redirect($this->generateUrl('freelance_Back_TableAdmin'));
    }

   
    
    
    public function AfficherReclamationAction() {

        $connection = $this->get('database_connection');

        $sql = "SELECT id,expediteur,date,sujet,message FROM reclamation ";
        $stmt = $connection->prepare($sql);

        $stmt->execute();

        return $this->render('FreelanceBackOfficeBundle:Admin:AffichageReclamation.html.twig', array('reclamation' => $stmt));
    }

    public function supprimerReclamationAction($id) {

        $connection = $this->get('database_connection');

        $sql = "DELETE  FROM reclamation  WHERE  id =$id ";
        $stmt = $connection->prepare($sql);
        $stmt->execute();

        return $this->redirect($this->generateUrl('freelance_Back_TableAdmin'));
    }

   
    
    
    public function mailAction($id) {
         
        $to = "your_email@gmail.com";
        $mail = new Mail();
        $form = $this->container->get('form.factory')
                ->create(new MailType(), $mail);

        if ($request->getMethod() == 'POST') {
            if ($form->isValid()) {
                $message = $Swift_Message::newinstance()
                        ->setSubject($mail->getNom())
                        ->setFrom($mail->getFrom())
                        ->setTo($to)
                        ->setBody($mai->getText());
                $this->get('mailer')->send($message);
                return $this->render('FreelanceBackOfficeBundle:Admin:mail:html.twig', array('to' => $to, 'from' => $mail->getFrom()));
            }
        }
    }
    
  

    
 
  
    
    
    
    
    
    
}
