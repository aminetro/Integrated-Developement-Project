<?php
namespace Freelance\BackOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Freelance\BackOfficeBundle\Entity\Administrateur;
use Freelance\BackOfficeBundle\Entity\Membre;
use Freelance\BackOfficeBundle\Form\AdministrateurForm;
use Freelance\BackOfficeBundle\Form\membreForm;
use FOS\UserBundle\FOSUserEvents;
use FOS\UserBundle\Event\FormEvent;
use FOS\UserBundle\Event\GetResponseUserEvent;
use FOS\UserBundle\Event\FilterUserResponseEvent;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\HttpKernel\Exception\NotFoundHttpException;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use FOS\UserBundle\Model\UserInterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of SuperAdminController
 *
 * @author hp
 */
class SuperAdminController  extends Controller{

  public function indexAction(){ 
        return $this->render('FreelanceBackOfficeBundle:SuperAdmin:index.html.twig');
    }  
    
    
   public function ajoutAdminAction(Request $request){
{
       /** @var $formFactory \FOS\UserBundle\Form\Factory\FactoryInterface */
       $formFactory = $this->get('fos_user.registration.form.factory');
        /** @var $userManager \FOS\UserBundle\Model\UserManagerInterface */
        $userManager = $this->get('fos_user.user_manager');
        /** @var $dispatcher \Symfony\Component\EventDispatcher\EventDispatcherInterface */
        $dispatcher = $this->get('event_dispatcher');

        $user = $userManager->createUser();
        
        $user->setEnabled(true);
        
        $event = new GetResponseUserEvent($user, $request);
        $dispatcher->dispatch(FOSUserEvents::REGISTRATION_INITIALIZE, $event);

        if (null !== $event->getResponse()) {
            return $event->getResponse();
        }

        $form = $formFactory->createForm();
        $form->setData($user);

        $form->handleRequest($request);

        if ($form->isValid()) {
            $event = new FormEvent($form, $request);
            $dispatcher->dispatch(FOSUserEvents::REGISTRATION_SUCCESS, $event);
            $user->addRole("ROLE_ADMIN");
            $userManager->updateUser($user);
            $admin = new \Freelance\FrontOfficeBundle\Entity\Administrateur;
        $em = $this->getDoctrine()->getManager();
echo("sqdqsd");
                $admin->setIdA($user->getId());
                 $em->persist($admin);

            $em->flush();
            if (null === $response = $event->getResponse()) {
                $url = $this->generateUrl('freelance_Back_indexSuperAdmin');
                $response = new RedirectResponse($url);
            }

            $dispatcher->dispatch(FOSUserEvents::REGISTRATION_COMPLETED, new FilterUserResponseEvent($user, $request, $response));

            return $response;
        }

           return $this->render('FreelanceBackOfficeBundle:SuperAdmin:AjouterAdmin.html.twig',array('form'=>$form->createView()));
    
        
        /***************************************
        $Administrateur = new Membre();
        $f= new AdministrateurForm();
        $form=$this->createForm($f,$Administrateur);
        $request=$this->get('request');
         $admin = new Administrateur();
        if($form->handleRequest($request)->isValid()){
             echo $Administrateur->getId();
                $em=$this->getDoctrine()->getManager();
                $em->persist($Administrateur);
                $em->flush(); 
               
                $admin->setId_a( $Administrateur->getId());   
                $em1=$this->getDoctrine()->getManager();
                $em1->persist($admin);
                $em1->flush(); 
             
            }
        
          return $this->render('FreelanceBackOfficeBundle:SuperAdmin:AjouterAdmin.html.twig',array('form'=>$form->createView()));
         */

    }   
      }
      
      
     
      
     public function  AfficherAction()
    { 
  
     $connection = $this->get('database_connection');
    
     $dql ="SELECT id,nom,prenom,pays,ville,pseudo,email FROM membre m, administrateur ad WHERE  m.id = ad.id_a ";
$stmt = $connection->prepare($dql);
$stmt->execute();


        return $this->render('FreelanceBackOfficeBundle:SuperAdmin:AfficherAdmin.html.twig',array('administrateur'=>$stmt));
    }
    
    
    
    
    
    public function RechercherAction() {
         $connection = $this->get('database_connection');
        $dql ="SELECT id,nom, prenom, pays, ville, pseudo, PASSWORD , email  FROM membre m, administrateur a  WHERE m.id = a.id_a";
        $stmt = $connection->prepare($dql);
        
        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
        $search = $Request->get('search');
        $dql ="SELECT id, nom, prenom, pays, ville, pseudo, PASSWORD , email FROM administrateur a, membre m WHERE a.id_a = m.id AND m.pseudo =  ?";
        $stmt = $connection->prepare($dql);
         $stmt->bindValue(1, $search);
        $stmt->execute();
        }
          $stmt->execute();
        return $this->render('FreelanceBackOfficeBundle:SuperAdmin:AfficherAdmin.html.twig', array('administrateur'=>$stmt));
      }
  
      
      
      

    public function modifierAction($id){
        $em=$this->getDoctrine()->getManager();
        $admin = $em->getRepository('FreelanceBackOfficeBundle:Membre')->find($id);
        $a= new AdministrateurForm();
        $form=$this->createForm($a,$admin);
        $request=$this->get('request');
        if($request->getMethod()=="POST"){
            $form->bind($request);
            if($form->isValid()){
                
                $em->persist($admin);
                $em->flush();
                return $this->redirect($this->generateUrl('freelance_Back_indexSuperAdmin'));
            }
        }
        return $this->render('FreelanceBackOfficeBundle:SuperAdmin:ModifierAdmin.html.twig',array('form'=>$form->createView(),'Administrateur'=>$admin));
    }
   
    
    
     public function  deleteAction($id) { 
  
     $connection = $this->get('database_connection');
    
     $dql ="DELETE  FROM membre  WHERE  id =$id ";
$stmt = $connection->prepare($dql);
$stmt->execute();

return $this->redirect($this->generateUrl('freelance_Back_AfficherAdmin'));
        
    }
      
    
    
     public function rechercherAdminAction()    { 
        $connection = $this->get('database_connection');
        $dql ="SELECT * FROM membre m , administrateur a WHERE m.id = a.id_a";
        $stmt = $connection->prepare($dql);
        
        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
        $search = $Request->get('search');
        $dql ="SELECT * FROM administrateur a, membre m WHERE m.id = a.id_a AND m.pseudo =  ?";
        $stmt = $connection->prepare($dql);
         $stmt->bindValue(1, $search);
        $stmt->execute();
        }
          $stmt->execute();
        return $this->render('FreelanceBackOfficeBundle:SuperAdmin:RechercherAdmin.html.twig', array('administrateur'=>$stmt));
      }
      
     
     
    
       }
