<?php
namespace Freelance\FrontOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Freelance\FrontOfficeBundle\Entity\Membre AS Membre;
use Freelance\FrontOfficeBundle\Entity\Messagerie AS Messagerie;
use Freelance\FrontOfficeBundle\Form\MessagerieForm AS MessagerieForm;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of MessagerieController
 *
 * @author hp
 */
class MessagerieController  extends Controller{
 public function  FreelancerMessagerieAjouterAction($pseudo,$pseudo1)
{
        $Messagerie = new Messagerie();
        $f= new messagerieForm();
        $form=$this->createForm($f,$Messagerie);
        $request=$this->get('request');
        
    if(($form->handleRequest($request)->isValid())){
                $Messagerie->setDate(new \DateTime()); 
                $Messagerie->setExpediteur($pseudo);
                $Messagerie->setRecepteur($pseudo1); 
                $em=$this->getDoctrine()->getManager();
                $em->persist($Messagerie);
                $em->flush();
               
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:FreelancerMessagerieSucess.html.twig');        
    }
       
          return $this->render('FreelanceFrontOfficeBundle:FrontOffice:FreelancerMessagerieAjouter.html.twig', array('form'=>$form->createView()));
          
    }
    
     public function FreelancerMessagerieAfficherAction($pseudo) {
 
        $connection = $this->get('database_connection');

        $dql = "SELECT expediteur,date,sujet,message  FROM  `messagerie` where recepteur=? or expediteur=?";
        $stmt = $connection->prepare($dql);
        $stmt->bindValue(1, $pseudo);$stmt->bindValue(2, $pseudo);
        $stmt->execute();

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:FreelancerMessagerieAfficher.html.twig', array('messages' => $stmt));
    }
    
     public function FreelancerMessagerieRechercherAction($pseudo)
      {   
      $connection = $this->get('database_connection');
         $dql = "SELECT id,expediteur,date,sujet,message  FROM  `messagerie` where recepteur=? or expediteur=?";
        $stmt = $connection->prepare($dql);
        $stmt->bindValue(1, $pseudo);
        $stmt->bindValue(2, $pseudo);
        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
         
        $search = $Request->get('search');
        $dql = "SELECT id,expediteur,date,sujet,message  FROM  `messagerie` where expediteur=? and recepteur=? ";
        $stmt = $connection->prepare($dql);
         $stmt->bindValue(1, $search);
       $stmt->bindValue(2, $pseudo);
         $stmt->execute();
        }
          $stmt->execute();
         return $this->render('FreelanceFrontOfficeBundle:FrontOffice:FreelancerMessagerieAfficher.html.twig', array('messages' => $stmt));
      }
      
         public function FreelancerMessagerieSupprimerAction($id)
    { $Messagerie=new Messagerie();
        $em=$this->getDoctrine()->getManager();
        $Messagerie=$em->getRepository('FreelanceFrontOfficeBundle:Messagerie')->findOneById($id);
        $pseudo=$Messagerie->getRecepteur();
        $em->remove($Messagerie);
        $em->flush();
       return $this->redirect($this->generateUrl('freelance_front_FreelancerMessagerieRechercher', array('pseudo' => $pseudo)));
       // return $this->render('EspritEtudiantBundle:Etudiant:supprimer.html.twig');
    }
    
         public function JobownerMessagerieSupprimerAction($id)
    { $Messagerie=new Messagerie();
        $em=$this->getDoctrine()->getManager();
        $Messagerie=$em->getRepository('FreelanceFrontOfficeBundle:Messagerie')->findOneById($id);
        $pseudo=$Messagerie->getRecepteur();
        $em->remove($Messagerie);
        $em->flush();
       return $this->redirect($this->generateUrl('freelance_front_JobownerMessagerieRechercher', array('pseudo' => $pseudo)));
       // return $this->render('EspritEtudiantBundle:Etudiant:supprimer.html.twig');
    }
public function  JobownerMessagerieAjouterAction($pseudo,$pseudo1)
{
        $Messagerie = new Messagerie();
        $f= new messagerieForm();
        $form=$this->createForm($f,$Messagerie);
        $request=$this->get('request');
        
    if(($form->handleRequest($request)->isValid())){
                $Messagerie->setDate(new \DateTime()); 
                $Messagerie->setExpediteur($pseudo);
                $Messagerie->setRecepteur($pseudo1); 
                $em=$this->getDoctrine()->getManager();
                $em->persist($Messagerie);
                $em->flush();
                 return $this->render('FreelanceFrontOfficeBundle:FrontOffice:JobownerMessagerieSucess.html.twig');        
  
    }
       
          return $this->render('FreelanceFrontOfficeBundle:FrontOffice:JobownerMessagerieAjouter.html.twig', array('form'=>$form->createView()));
          
    }
    
     public function JobownerMessagerieAfficherAction($pseudo) {
 
        $connection = $this->get('database_connection');

        $dql = "SELECT id,expediteur,date,sujet,message  FROM  `messagerie` where recepteur=? or expediteur=?";
        $stmt = $connection->prepare($dql);
        $stmt->bindValue(1, $pseudo);$stmt->bindValue(2, $pseudo);
        $stmt->execute();

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:JobownerMessagerieAfficher.html.twig', array('messages' => $stmt));
    }
    
     public function JobownerMessagerieRechercherAction($pseudo)
      {   
      $connection = $this->get('database_connection');
         $dql = "SELECT id,expediteur,date,sujet,message  FROM  `messagerie` where recepteur=? or expediteur=?";
        $stmt = $connection->prepare($dql);
        $stmt->bindValue(1, $pseudo);$stmt->bindValue(2, $pseudo);
        
        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
         
        $search = $Request->get('search');
        $dql = "SELECT id,expediteur,date,sujet,message  FROM  `messagerie` where expediteur=? or recepteur=? ";
        $stmt = $connection->prepare($dql);
         $stmt->bindValue(1, $search);
       $stmt->bindValue(2, $pseudo);
         $stmt->execute();
        }
          $stmt->execute();
         return $this->render('FreelanceFrontOfficeBundle:FrontOffice:JobownerMessagerieAfficher.html.twig', array('messages' => $stmt));
      }

    }
