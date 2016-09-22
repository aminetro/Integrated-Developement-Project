<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

namespace Freelance\FrontOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Freelance\FrontOfficeBundle\Entity\Favoris AS Favoris;
use Freelance\FrontOfficeBundle\Entity\Membre AS Membre;

/**
 * Description of FavorisController
 *
 * @author Amine
 */
class FavorisController extends Controller {

    public function AjouterFavorisAction($pseudo, $idp) {

        $em1 = $this->getDoctrine()->getManager();
        $Membre = new Membre();
        $Membre = $em1->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);
        $fav = new Favoris();

        $fav->setIdF($Membre->getId());
        $fav->setIdP($idp);
        $em1 = $this->getDoctrine()->getManager();
        $em1->persist($fav);
        $em1->flush();
        return $this->redirect($this->generateUrl('freelance_front_RechercherProjetFreelancer', array('pseudo' => $pseudo)));
    }

    public function AfficherListFavorisAction($pseudo) {

        $connection = $this->get('database_connection');
        $em = $this->getDoctrine()->getManager();
        $Membre = new Membre();
        $Membre = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);
        $idd = $Membre->getId();
        $sql = "SELECT titre_p,categorie_p,duree_p,description_p,owner_p,pseudo_f,p.id from projet p, favoris f where ((p.id=f.id_p) and (f.id_f='$idd')) ";
        $stmt = $connection->prepare($sql);

        $stmt->execute();

        /*   $query = $em->createQuery("SELECT p from FreelanceFrontOfficeBundle:Projet p, FreelanceFrontOfficeBundle:Favoris f where ((p.id=f.idP) and (f.idF=:idm))" ); 
          $query->setParameter('idm',  $idd);
          $query->execute();
          $users = $query->getResult();
         */

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AfficherListFavoris.html.twig', array('projet' => $stmt, 'membre' => $Membre));
    }

    public function SupprimerFavorisAction($idf, $idp) {
        $em = $this->getDoctrine()->getManager();
        $test = $em->getRepository('FreelanceFrontOfficeBundle:Favoris')->findOneBy(array('idP' => $idp, 'idF' => $idf));
        $em->remove($test);
        $em->flush();
        return $this->redirect($this->generateUrl('freelance_front_office_AfficherFreelancer'));
    }

}
