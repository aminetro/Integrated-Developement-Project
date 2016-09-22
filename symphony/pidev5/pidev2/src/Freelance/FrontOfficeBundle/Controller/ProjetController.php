<?php


namespace Freelance\FrontOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Freelance\FrontOfficeBundle\Entity\Membre AS Membre;
use Freelance\FrontOfficeBundle\Entity\Projet AS Projet;
use Freelance\FrontOfficeBundle\Form\ProjetForm AS ProjetForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of ProjetController
 *
 * @author hp
 */
class ProjetController extends Controller {

    public function AjouterProjetAction($pseudo) {

        $em = $this->getDoctrine()->getManager();
        $Membre = new Membre();
        $Membre = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);
        $Projet = new Projet();
        $ff = new ProjetForm();

        $form = $this->createForm($ff, $Projet);
        $request = $this->get('request');


        if ($form->handleRequest($request)->isValid()) {

            $Projet->setOwnerP($pseudo);

            $em1 = $this->getDoctrine()->getManager();
            $em1->persist($Projet);
            $em1->flush();
            return $this->redirect($this->generateUrl('freelance_front_office_AfficherJobowner'));
        }

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AjouterProjet.html.twig', array('form' => $form->createView(), 'p' => $Projet));
    }

    public function AfficherJobownerProjetAction($pseudo) {

        $connection = $this->get('database_connection');

        $dql = "SELECT * from projet where owner_p=?";
        $stmt = $connection->prepare($dql);
        $stmt->bindValue(1, $pseudo);
        $stmt->execute();


        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AfficherJobownerProjet.html.twig', array('projet' => $stmt));
    }

    public function AfficherFreelancerProjetAction($pseudo) {

        $connection = $this->get('database_connection');

        $dql = "SELECT * from projet where pseudo_f=?";
        $stmt = $connection->prepare($dql);
        $stmt->bindValue(1, $pseudo);
        $stmt->execute();


        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AfficherFreelancerProjet.html.twig', array('projet' => $stmt));
    }

    public function RechercherProjetJobownerAction() {

       $connection = $this->get('database_connection');
        
        $dql = "SELECT * from projet ";
        $stmt = $connection->prepare($dql);

        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
            $search = $Request->get('search');
            $dql = "SELECT * from projet where categorie_p=?";
            $stmt = $connection->prepare($dql);
            $stmt->bindValue(1, $search);
            $stmt->execute();
        }
        $stmt->execute();
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:RechercherProjetJobowner.html.twig', array('projet' => $stmt));
    }
 public function RechercherProjetFreelancerAction() {

       $connection = $this->get('database_connection');
        
        $dql = "SELECT * from projet ";
        $stmt = $connection->prepare($dql);

        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
            $search = $Request->get('search');
            $dql = "SELECT * from projet where categorie_p=?";
            $stmt = $connection->prepare($dql);
            $stmt->bindValue(1, $search);
            $stmt->execute();
        }
        $stmt->execute();
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:RechercherProjetFreelancer.html.twig', array('projet' => $stmt));
    }
    public function ModifierProjetAction($id) {

        $Projet = new Projet();


        //$Cvfreelancer->setIdCv($Membre->getId());
        $em = $this->getDoctrine()->getManager();

        $Projet = $em->getRepository('FreelanceFrontOfficeBundle:Projet')->find($id);

        $ff = new ProjetForm();

        $form = $this->createForm($ff, $Projet);
        $request = $this->get('request');



        if ($form->handleRequest($request)->isValid()) {

            $titre = $Projet->getTitreP();
            $categorie = $Projet->getCategorieP();
            $duree = $Projet->getDureeP();
            $description = $Projet->getDescriptionP();

            $connection = $this->get('database_connection');
            $dql = "UPDATE `projet` SET `titre_p` = ?,`categorie_p` = ?,`duree_p` = ?,`description_p` = ? WHERE  `id` =?;";
            $stmt = $connection->prepare($dql);

            $stmt->bindValue(1, $titre);
            $stmt->bindValue(2, $categorie);
            $stmt->bindValue(3, $duree);
            $stmt->bindValue(4, $description);
            $stmt->bindValue(5, $id);

            $stmt->execute();
            return $this->redirect($this->generateUrl('freelance_front_office_AfficherJobowner'));
        }

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:ModifierProjet.html.twig', array('form' => $form->createView(), 'p' => $Projet));
    }

    public function RechercherListProjetAction() {
        $connection = $this->get('database_connection');
       
        $dql = "SELECT * from projet ";
        $stmt = $connection->prepare($dql);

        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
            $search = $Request->get('search');
            $dql = "SELECT * from projet where categorie_p=?";
            $stmt = $connection->prepare($dql);
            $stmt->bindValue(1, $search);
            $stmt->execute();
        }
        $stmt->execute();
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AfficherListProjet.html.twig', array('projet' => $stmt));
    }
    public function SuprimerProjetAction($id)
    {
        $em=$this->getDoctrine()->getManager();
        $test=$em->getRepository('FreelanceFrontOfficeBundle:Projet')->findOneById($id);
        $em->remove($test);
        $em->flush();
       return $this->redirect($this->generateUrl('freelance_front_office_AfficherJobowner'));
    }
}
