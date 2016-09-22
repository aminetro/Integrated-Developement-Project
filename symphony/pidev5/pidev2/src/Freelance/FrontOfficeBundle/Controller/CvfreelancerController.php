<?php

namespace Freelance\FrontOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

namespace Freelance\FrontOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Freelance\FrontOfficeBundle\Entity\Membre AS Membre;
use Freelance\FrontOfficeBundle\Entity\Cvfreelancer AS Cvfreelancer;
use Freelance\FrontOfficeBundle\Form\CvfreelancerForm AS CvfreelancerForm;
use Freelance\FrontOfficeBundle\Form\ImageForm AS ImageForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of CvfreelancerController
 *
 * @author hp
 */
class CvfreelancerController extends Controller {

    public function AjouterCvFreelancerAction($pseudo) {
        $em = $this->getDoctrine()->getManager();
        $Membre = new Membre();
        $Membre = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);
        $Cvfreelancer = new Cvfreelancer();
        $ff = new CvfreelancerForm();

        $form = $this->createForm($ff, $Cvfreelancer);
        $request = $this->get('request');


        if ($form->handleRequest($request)->isValid()) {


            $Cvfreelancer->setIdCv($Membre->getId());
            // $date = date("Y-m-d");
            $Cvfreelancer->setDernierMajCv(new \DateTime());

            //$myEntity->setMyDate(new \DateTime());


            $em1 = $this->getDoctrine()->getManager();
            $em1->persist($Cvfreelancer);
            $em1->flush();
            return $this->redirect($this->generateUrl('freelance_front_office_AfficherFreelancer'));
        }

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AjouterCvFreelancer.html.twig', array('form' => $form->createView(), 'm' => $Membre));
    }

    public function AfficherCvFreelancerAction($pseudo) {
        /* $connection = $this->get('database_connection');
          $dql = "SELECT id_cv,dernier_maj_cv,experience_cv,langue_cv,Certification_cv,formation_cv FROM membre m, cvfreelancer cv WHERE  m.id = cv.id_cv AND m.pseudo =?";
          $stmt = $connection->prepare($dql);
          $stmt->bindValue(1, $pseudo);
          $stmt->execute();

          $em = $this->getDoctrine()->getManager();
         */
        $em = $this->getDoctrine()->getManager();
        $Membre = new Membre();
        $Membre = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);
        $id = $Membre->getId();
        $result = $em->createQueryBuilder();
        $dql = $result->select('c')
                        ->from('FreelanceFrontOfficeBundle:Cvfreelancer', 'c')
                        ->where('c.idCv = :idCv')
                        ->setParameter('idCv', $id)
                        ->getQuery()->getResult(\Doctrine\ORM\Query::HYDRATE_ARRAY);
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AfficherCvFreelancer.html.twig', array('cv' => $dql));
    }

    public function ModifierCvFreelancerAction($pseudo) {
        $em = $this->getDoctrine()->getManager();
        $Membre = new Membre();
        $Membre = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);

        $Cvfreelancer = new Cvfreelancer();


        $Cvfreelancer->setIdCv($Membre->getId());

        $Cvfreelancer = $em->getRepository('FreelanceFrontOfficeBundle:Cvfreelancer')->find($Cvfreelancer->getIdCv());

        $ff = new CvfreelancerForm();

        $form = $this->createForm($ff, $Cvfreelancer);
        $request = $this->get('request');



        if ($form->handleRequest($request)->isValid()) {


            /*
              $experience = $Cvfreelancer->getExperienceCv();
              $langue = $Cvfreelancer->getLangueCv();
              $certification = $Cvfreelancer->getCertificationCv();
              $formation = $Cvfreelancer->getFormationCv();
              $connection = $this->get('database_connection');
              $dql = "UPDATE cvfreelancer cv,membre m  SET cv.dernier_maj_cv=CURRENT_DATE,cv.experience_cv=?,cv.langue_cv=?,cv.certification_cv=?,cv.formation_cv=? WHERE cv.id_cv = m.id AND m.pseudo=?";
              $stmt = $connection->prepare($dql);

              $stmt->bindValue(1, $experience);
              $stmt->bindValue(2, $langue);
              $stmt->bindValue(3, $certification);
              $stmt->bindValue(4, $formation);
              $stmt->bindValue(5, $pseudo);

              $stmt->execute(); */
            $em->persist($Cvfreelancer);

            $em->flush();
            return $this->redirect($this->generateUrl('freelance_front_office_AfficherFreelancer'));

            /* $em->persist($Membre);
              $em->flush();
              return $this->redirect($this->generateUrl('freelance_front_office_AfficherMembre')); */
        }

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:ModifierCvFreelancer.html.twig', array('form' => $form->createView(), 'cv' => $Cvfreelancer, 'm' => $Membre));
    }

    public function AfficherCvFreelancerJobownerAction($pseudo) {
        $em = $this->getDoctrine()->getManager();
        $Membre = new Membre();
        $Membre = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);
        $id = $Membre->getId();
        $result = $em->createQueryBuilder();
        $dql = $result->select('c')
                        ->from('FreelanceFrontOfficeBundle:Cvfreelancer', 'c')
                        ->where('c.idCv = :idCv')
                        ->setParameter('idCv', $id)
                        ->getQuery()->getResult(\Doctrine\ORM\Query::HYDRATE_ARRAY);
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AfficherCvFreelancerJobowner.html.twig', array('cv' => $dql));
    }
    public function SuprimerCvfreelancerAction($id)
    {
        $em=$this->getDoctrine()->getManager();
        $test=$em->getRepository('FreelanceFrontOfficeBundle:Cvfreelancer')->findOneByIdCv($id);
        $em->remove($test);
        $em->flush();
       return $this->redirect($this->generateUrl('freelance_front_office_AfficherFreelancer'));
    }
}
