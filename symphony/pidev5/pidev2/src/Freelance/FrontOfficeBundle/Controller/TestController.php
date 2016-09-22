<?php

namespace Freelance\FrontOfficeBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

use Freelance\FrontOfficeBundle\Entity\Test as Test;
use Freelance\FrontOfficeBundle\Entity\Notetest as Notetest;
use Freelance\FrontOfficeBundle\Form\TestType;

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

        $entities = $em->getRepository('FreelanceFrontOfficeBundle:Test')->findAll();

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AffichertoutTest.html.twig', array(
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
                return $this->redirect($this->generateUrl('freelance_front_office_AffichertoutTest'));
            }
        }
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AjouterTest.html.twig',array('form'=>$form->createView()));
    }

    /**
     * Finds and displays a Test entity.
     *
     */
    public function AfficherTestAction($nom)
    {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('FreelanceFrontOfficeBundle:Test')->findOneByNom($nom);

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AfficherTest.html.twig'
                    ,array('entity'=>$entities));
    }

    /**
     * Displays a form to edit an existing Test entity.
     *
     */
    public function ModifierTestAction(Request $request, $id)
    {
        $em=$this->getDoctrine()->getManager();
        
        $test= new Test();  
        $test = $em->getRepository('FreelanceFrontOfficeBundle:Test')->find($id);
      
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
            return $this->redirect($this->generateUrl('freelance_front_office_AffichertoutTest'));
         }
         return $this->render('FreelanceFrontOfficeBundle:FrontOffice:ModifierTest.html.twig',array('form'=>$form->createView(),'test'=>$test));
            
    }

public function SuprimerTestAction($id)
    {
        $em=$this->getDoctrine()->getManager();
        $test=$em->getRepository('FreelanceFrontOfficeBundle:Test')->findOneById($id);
        $em->remove($test);
        $em->flush();
       return $this->redirect($this->generateUrl('freelance_front_office_AffichertoutTest'));
    }

    
public function PassageTestAction($id,$idf) {
      $em1=$this->getDoctrine()->getManager();
    $test= new Test();  
        $test = $em1->getRepository('FreelanceFrontOfficeBundle:Test')->find($id);
      
        $ff= new TestType();
        
        $form=$this->createForm($ff,$test);
        $request=$this->get('request');
        
        if($form->handleRequest($request)->isValid()){
            $em=$this->getDoctrine()->getManager();
            $em->getRepository('FreelanceFrontOfficeBundle:Notetest');
            $nomt=$test->getNom(); 
            $r1=$test->getReponse1(); 
            $r2=$test->getReponse2();
            $r3=$test->getReponse3();
            $r4=$test->getReponse4();
            $r5=$test->getReponse5();
            $r6=$test->getReponse6();
            $connection = $this->get('database_connection');

            $stmt1 = $em->createQueryBuilder('Notetest');
            $stmt1->select('COUNT(a)');
            $stmt1->from('FreelanceFrontOfficeBundle:Test', 'a');
            $stmt1->where('a.nom = :nom');
            $stmt1->andWhere('a.reponse1 = :reponse1');
            $stmt1->setParameter('nom', $nomt);
            $stmt1->setParameter('reponse1', $r1);
            $op1=$stmt1->getQuery()->getSingleScalarResult();
            
            $stmt2 = $em->createQueryBuilder('Notetest');
            $stmt2->select('COUNT(a)');
            $stmt2->from('FreelanceFrontOfficeBundle:Test', 'a');
            $stmt2->where('a.nom = :nom');
            $stmt2->andWhere('a.reponse2 = :reponse2');
            $stmt2->setParameter('nom', $nomt);
            $stmt2->setParameter('reponse2', $r2);
            $op2=$stmt2->getQuery()->getSingleScalarResult();
            
            $stmt3 = $em->createQueryBuilder('Notetest');
            $stmt3->select('COUNT(a)');
            $stmt3->from('FreelanceFrontOfficeBundle:Test', 'a');
            $stmt3->where('a.nom = :nom');
            $stmt3->andWhere('a.reponse3 = :reponse3');
            $stmt3->setParameter('nom', $nomt);
            $stmt3->setParameter('reponse3', $r3);
            $op3=$stmt3->getQuery()->getSingleScalarResult();
            
            $stmt4 = $em->createQueryBuilder('Notetest');
            $stmt4->select('COUNT(a)');
            $stmt4->from('FreelanceFrontOfficeBundle:Test', 'a');
            $stmt4->where('a.nom = :nom');
            $stmt4->andWhere('a.reponse4 = :reponse4');
            $stmt4->setParameter('nom', $nomt);
            $stmt4->setParameter('reponse4', $r4);
            $op4=$stmt4->getQuery()->getSingleScalarResult();
            
            $stmt5 = $em->createQueryBuilder('Notetest');
            $stmt5->select('COUNT(a)');
            $stmt5->from('FreelanceFrontOfficeBundle:Test', 'a');
            $stmt5->where('a.nom = :nom');
            $stmt5->andWhere('a.reponse5 = :reponse5');
            $stmt5->setParameter('nom', $nomt);
            $stmt5->setParameter('reponse5', $r5);
            $op5=$stmt5->getQuery()->getSingleScalarResult();
            
            $stmt6 = $em->createQueryBuilder('Notetest');
            $stmt6->select('COUNT(a)');
            $stmt6->from('FreelanceFrontOfficeBundle:Test', 'a');
            $stmt6->where('a.nom = :nom');
            $stmt6->andWhere('a.reponse6 = :reponse6');
            $stmt6->setParameter('nom', $nomt);
            $stmt6->setParameter('reponse6', $r6);
            $op6=$stmt6->getQuery()->getSingleScalarResult();

            
            $note=intval($op1)+intval($op2)+intval($op3)+intval($op4)+intval($op5)+intval($op6) ;
            $notetest = new Notetest();
            $notetest->setIdF($idf);
            $notetest->setNomTest($nomt);
            $notetest->setNoteTest($note);
            $noteancien=$em->getRepository('FreelanceFrontOfficeBundle:Notetest')
                        ->findOneBy(array('id_f' => $idf, 'nomTest' => $nomt));
               // $em->remove($noteancien);
               // $em->flush();
            $em->persist($notetest);
            $em->flush();
            return $this->redirect($this->generateUrl('freelance_front_office_AffichertoutTest'));
         }
         return $this->render('FreelanceFrontOfficeBundle:FrontOffice:PassageTest.html.twig',array('form'=>$form->createView(),'test'=>$test));
            
    
    
}
   
}
