<?php
namespace Freelance\BackOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Freelance\BackOfficeBundle\Form\MessagerieForm;
use Freelance\BackOfficeBundle\Entity\Messagerie;
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
   
    
    public function ajoutAction()
{
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
       
          return $this->render('FreelanceBackOfficeBundle:Admin:EnvoyerMessagerie.html.twig', array('form'=>$form->createView()));
          
    }
    
     public function AfficherMessagerieAction($id) {
 
        $connection = $this->get('database_connection');

        $dql = "SELECT expediteur,date,sujet,message  FROM membre mb ,messagerie m where m.recepteur=mb.nom and mb.id=?";
        $stmt = $connection->prepare($dql);
        $stmt->bindValue(1, $id);
        $stmt->execute();

        return $this->render('FreelanceBackOfficeBundle:Admin:GestionMessagerie.html.twig', array('messages' => $stmt));
    }
    
     public function rechercherAction($pseudo)
      {   
      $connection = $this->get('database_connection');
         $dql = "SELECT expediteur,date,sujet,message  FROM messagerie recepteur=?";
        $stmt = $connection->prepare($dql);
        $stmt->bindValue(1, $pseudo);
        
        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
         
        $search = $Request->get('search');
        $dql = "SELECT expediteur,date,sujet,message  FROM  `messagerie` where expediteur=? and recepteur=? ";
        $stmt = $connection->prepare($dql);
         $stmt->bindValue(1, $search);
       $stmt->bindValue(2, $pseudo);
         $stmt->execute();
        }
          $stmt->execute();
         return $this->render('FreelanceBackOfficeBundle:Admin:AfficherMessagerie.html.twig', array('messages' => $stmt));
      }

}
