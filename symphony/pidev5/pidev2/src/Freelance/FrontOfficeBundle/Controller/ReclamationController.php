<?php
namespace Freelance\FrontOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Freelance\FrontOfficeBundle\Entity\Membre AS Membre;
use Freelance\FrontOfficeBundle\Entity\Reclamation AS Reclamation;
use Freelance\FrontOfficeBundle\Form\ReclamationForm AS ReclamationForm;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of ReclamationController
 *
 * @author hp
 */
class ReclamationController  extends Controller{
 public function ReclamationAjouterAction($pseudo,$type) {
        $em = $this->getDoctrine()->getManager();
        $Reclamation = new Reclamation();
        $ff = new ReclamationForm();

        $form = $this->createForm($ff, $Reclamation);
        $request = $this->get('request');


        if ($form->handleRequest($request)->isValid()) {

            $Reclamation->setExpediteur($pseudo);
            $Reclamation->setDate(new \DateTime());

            $em1 = $this->getDoctrine()->getManager();
            $em1->persist($Reclamation);
            $em1->flush();
            if($type=='free')
            return $this->redirect($this->generateUrl('freelance_front_office_AfficherFreelancer'));
            
            if($type=='job')
            return $this->redirect($this->generateUrl('freelance_front_office_AfficherJobowner'));
        }

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:ReclamationAjouter.html.twig', array('form' => $form->createView(), 'R' => $Reclamation));
    }
    //affichage 
    public function AfficherReclamationAction()
    {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('FreelanceFrontOfficeBundle:Reclamation')->findAll();

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:afficherReclamation.html.twig', 
                array(
            'entities' => $entities,
        ));
    }
    //supprimer
     public function supprimerReclamationAction($id)
    {
        $em=$this->getDoctrine()->getManager();
        $reclamation=$em->getRepository('FreelanceFrontOfficeBundle:Reclamation')->findOneById($id);
        $em->remove($reclamation);
        $em->flush();
       return $this->redirect($this->generateUrl('freelance_front_afficherReclamation'));
       // return $this->render('EspritEtudiantBundle:Etudiant:supprimer.html.twig');
    }}
