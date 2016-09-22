<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
namespace Freelance\FrontOfficeBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

use Freelance\FrontOfficeBundle\Entity\Notetest as Notetest;
use Freelance\FrontOfficeBundle\Form\NotetestForm;
/**
 * Description of Notetest
 *
 * @author Amine
 */
class NotetestController extends Controller{
    public function AjouterNotetestAction($idf)
    {
        $notetest = new Notetest();
        $f= new NotetestForm();
        $form=$this->createForm($f,$notetest);
        $request=$this->get('request');
        if($request->getMethod()=="POST"){
            $form->bind($request);
            if($form->isValid()){
                $nom=$request->get('nom');
                $em=$this->getDoctrine()->getManager();
                $note=$em->getRepository('FreelanceFrontOfficeBundle:Notetest')
                        ->findBy(array('idf' => $idf, 'nomTest' => $nom));
                $em->remove($note);
                $em->flush();
                $em->persist($notetest);
                $em->flush();
                return $this->redirect($this->generateUrl('freelance_front_office_AffichertoutTest'));
            }
        }
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AjouterNotetest.html.twig',array('form'=>$form->createView()));
    }
    
    
    public function AfficherNotetestAction($idf)
    {
     
         $connection = $this->get('database_connection');
    
     $dql ="select * from notetest where id_f=?";
$stmt = $connection->prepare($dql);
$stmt->bindValue(1, $idf);
$stmt->execute();
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AfficherNotetest.html.twig', array('entities' => $stmt));
    }
    
}
