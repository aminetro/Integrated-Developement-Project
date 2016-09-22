<?php

namespace Freelance\BackOfficeBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

use Freelance\BackOfficeBundle\Entity\Test as Test;
use Freelance\BackOfficeBundle\Entity\Notetest as Notetest;
use Freelance\BackOfficeBundle\Form\TestType;

/**
 * Test controller.
 *
 */
class TestController extends Controller
{

    /**
     * Lists all Test entities.
     *
     */
    public function AffichertoutTestAction()
    {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('FreelanceBackOfficeBundle:Test')->findAll();

        return $this->render('FreelanceBackOfficeBundle:Admin:AffichertoutTest.html.twig', array(
            'entities' => $entities,
        ));
    }




    /**
     * Displays a form to create a new Test entity.
     *
     */
    public function AjouterTestAction()
    {
        $test = new  Test();
        $f= new TestType();
        $form=$this->createForm($f,$test);
        $request=$this->get('request');
        if($request->getMethod()=="POST"){
            $form->bind($request);
            if($form->isValid()){
                $em=$this->getDoctrine()->getManager();
                $em->persist($test);
                $em->flush();
                return $this->redirect($this->generateUrl('freelance_Back_AffichertoutTest'));
            }
        }
        return $this->render('FreelanceBackOfficeBundle:Admin:AjouterTest.html.twig',array('form'=>$form->createView()));
    }

    /**
     * Finds and displays a Test entity.
     *
     */
    public function AfficheTestAction()
    {
        $connection = $this->get('database_connection');

        $sql = "SELECT id, nom, question1, question2, question3, question4,question5,question6 From test ";
        $stmt = $connection->prepare($sql);
        $stmt->execute();
        return $this->render('FreelanceBackOfficeBundle:Admin:AfficherTest.html.twig', array('test' => $stmt));
    }
    


    /**
     * Displays a form to edit an existing Test entity.
     *
     */
    public function ModifierTestAction(Request $request, $id)
    {
        $em=$this->getDoctrine()->getManager();
        
        $test= new Test();  
        $test = $em->getRepository('FreelanceBackOfficeBundle:Test')->find($id);
      
        $ff= new TestType();
        
        $form=$this->createForm($ff,$test);
        $request=$this->get('request');
        if($form->handleRequest($request)->isValid()){
            $nomt=$test->getNom(); 
            $q1=$test->getQuestion1(); 
            $q2=$test->getQuestion2();
            $q3=$test->getQuestion3();
            $q4=$test->getQuestion4();
            $q5=$test->getQuestion5();
            $q6=$test->getQuestion6();
            $r1=$test->getReponse1(); 
            $r2=$test->getReponse2();
            $r3=$test->getReponse3();
            $r4=$test->getReponse4();
            $r5=$test->getReponse5();
            $r6=$test->getReponse6();
            $connection = $this->get('database_connection');
            $dql ="UPDATE `test` SET `nom` = ?,`question1` = ?,`reponse1` = ?,`question2` = ?,`reponse2` = ? ,`question3` = ?,`reponse3` = ?,`question4` = ?,`reponse4` = ? ,`question5` = ?,`reponse5` = ?,`question6` = ?,`reponse6` = ?  WHERE  `id` =?";
            $stmt = $connection->prepare($dql);

                $stmt->bindValue(1, $nomt);
                $stmt->bindValue(2, $q1);
                $stmt->bindValue(3, $r1);
                $stmt->bindValue(4, $q2);
                $stmt->bindValue(5, $r2);
                $stmt->bindValue(6, $q3);
                $stmt->bindValue(7, $r3);
                $stmt->bindValue(8, $q4);
                $stmt->bindValue(9, $r4);
                $stmt->bindValue(10, $q5);
                $stmt->bindValue(11, $r5);
                $stmt->bindValue(12, $q6);
                $stmt->bindValue(13, $r6);
                $stmt->bindValue(14, $id);
            $stmt->execute();
            return $this->redirect($this->generateUrl('freelance_Back_AffichertoutTest'));
         }
         return $this->render('FreelanceBackOfficeBundle:Admin:ModifierTest.html.twig',array('form'=>$form->createView(),'test'=>$test));
            
    }

public function SuprimerTestAction($id)
    {
        $em=$this->getDoctrine()->getManager();
        $test=$em->getRepository('FreelanceBackOfficeBundle:Test')->findOneById($id);
        $em->remove($test);
        $em->flush();
       return $this->redirect($this->generateUrl('freelance_Back_AffichertoutTest'));
    }

 
   
}
