<?php

namespace Freelance\FrontOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

namespace Freelance\FrontOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Freelance\FrontOfficeBundle\Entity\Membre AS Membre;
use Freelance\FrontOfficeBundle\Entity\Projet AS Projet;
use Freelance\FrontOfficeBundle\Entity\Candidature AS Candidature;
use Freelance\FrontOfficeBundle\Form\CandidatureForm AS CandidatureForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of CandidatureController
 *
 * @author hp
 */
class CandidatureController extends Controller {

    public function AjouterCandidatureAction($pseudo, $id) {

        $em = $this->getDoctrine()->getManager();
        $Membre = new Membre();
        $Membre = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);

        //$Projet = new Projet();
        //$Projet = $em->getRepository('FreelanceFrontOfficeBundle:Projet')->find($id);


        $Candidature = new Candidature();
        $ff = new CandidatureForm();

        $form = $this->createForm($ff, $Candidature);
        $request = $this->get('request');
      

        if ($form->handleRequest($request)->isValid()) {
            $Candidature->setPseufreelancer($Membre->getPseudo());
            $Candidature->setIdp($id);
            $em1 = $this->getDoctrine()->getManager();
            $em1->persist($Candidature);
            $em1->flush();
            return $this->redirect($this->generateUrl('freelance_front_office_AfficherFreelancer'));
        }

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AjouterCandidature.html.twig', array('formCandidature' => $form->createView(),'m'=>$Membre));
    }

    public function AfficherListCandidatureAction($pseudo) {
//Afficher les candidatires pour JOBOWNER
        $connection = $this->get('database_connection');

        $dql = "select c.id,c.id_p,c.pseufreelancer,c.estimation,c.lettre_mot,c.question from candidature c,projet p where c.id_p=p.id and p.owner_p=?";
        $stmt = $connection->prepare($dql);
        $stmt->bindValue(1, $pseudo);
        $stmt->execute();

      
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AfficherListCandidature.html.twig', array('ca' => $stmt));
    }

    public function AfficherMesCandidatureAction($pseudo) {
//Afficher les candidatires pour Freelancer

        $connection = $this->get('database_connection');

        $dql = "select * from candidature where pseufreelancer =?";
        $stmt = $connection->prepare($dql);
        $stmt->bindValue(1, $pseudo);
        $stmt->execute();

      
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AfficherMesCandidature.html.twig', array('ca' => $stmt));
    }

    public function AffecterCandidatureAction($pseudo, $id) {

        $connection = $this->get('database_connection');

        $dql = "UPDATE `projet` SET `pseudo_f` = ? WHERE  `id` =?";
        $stmt = $connection->prepare($dql);
        $stmt->bindValue(1, $pseudo);
        $stmt->bindValue(2, $id);
        $stmt->execute();

      
        return $this->redirect($this->generateUrl('freelance_front_office_AfficherJobowner'));
    }

    public function ModifierCandidatureAction($id) {


        $Candidature = new Candidature();
        $ff = new CandidatureForm();
        //$Cvfreelancer->setIdCv($Membre->getId());
        $em = $this->getDoctrine()->getManager();

        $Candidature = $em->getRepository('FreelanceFrontOfficeBundle:Candidature')->find($id);


        $form = $this->createForm($ff, $Candidature);
        $request = $this->get('request');



        if ($form->handleRequest($request)->isValid()) {

            $estimation= $Candidature->getEstimation();
            $lettre = $Candidature->getLettremot();
            $question = $Candidature->getQuestion();
           

            $connection = $this->get('database_connection');
            $dql =  "UPDATE `candidature` SET `estimation`=?,`lettre_mot`=?,`question`=?  WHERE `id`=?";
            $stmt = $connection->prepare($dql);

            $stmt->bindValue(1, $estimation);
            $stmt->bindValue(2, $lettre);
            $stmt->bindValue(3, $question);
         $stmt->bindValue(4, $id);

            $stmt->execute();
            return $this->redirect($this->generateUrl('freelance_front_office_AfficherFreelancer'));
        }

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:ModifierCandidature.html.twig', array('formCandidature' => $form->createView(), 'ca' => $Candidature));
    }
    public function SuprimerCandidatureAction($id)
    {
        $em=$this->getDoctrine()->getManager();
        $test=$em->getRepository('FreelanceFrontOfficeBundle:Candidature')->findOneById($id);
        $em->remove($test);
        $em->flush();
       return $this->redirect($this->generateUrl('freelance_front_office_AfficherFreelancer'));
    }
}
