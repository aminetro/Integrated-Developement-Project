<?php

namespace Freelance\FrontOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Freelance\FrontOfficeBundle\Entity\Membre AS Membre;
use Freelance\FrontOfficeBundle\Entity\Jobowner AS Jobowner;
//use Freelance\FrontOfficeBundle\Form\freelanceForm AS freelancerForm;
use Freelance\FrontOfficeBundle\Form\membreForm AS MembreForm;
use Freelance\FrontOfficeBundle\Form\MembreModifierForm AS MembreModifierForm;
use Freelance\FrontOfficeBundle\Form\JobownerForm AS JobownerForm;
use FOS\UserBundle\FOSUserEvents;
use FOS\UserBundle\Event\FormEvent;
use FOS\UserBundle\Event\GetResponseUserEvent;
use FOS\UserBundle\Event\FilterUserResponseEvent;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\HttpKernel\Exception\NotFoundHttpException;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use FOS\UserBundle\Model\UserInterface;
use Freelance\FrontOfficeBundle\Form\ImageForm AS ImageForm;
use Symfony\Component\HttpFoundation\StreamedResponse;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of JobownerController
 *
 * @author hp
 */
class JobownerController extends Controller {

   public function AjouterJobownerAction(Request $request) {
        $formFactory = $this->get('fos_user.registration.form.factory');
        /** @var $userManager \FOS\UserBundle\Model\UserManagerInterface */
        $userManager = $this->get('fos_user.user_manager');
        /** @var $dispatcher \Symfony\Component\EventDispatcher\EventDispatcherInterface */
        $dispatcher = $this->get('event_dispatcher');

        $user = $userManager->createUser();
        $user->setEnabled(true);
        
        $event = new GetResponseUserEvent($user, $request);
        $dispatcher->dispatch(FOSUserEvents::REGISTRATION_INITIALIZE, $event);
 $user->addRole("ROLE_JOBOWNER");
        if (null !== $event->getResponse()) {
            return $event->getResponse();
        }

        $form = $formFactory->createForm();
        $form->setData($user);

        

        $jobowner = new Jobowner();
        $f2 = new JobownerForm();
        
$form->handleRequest($request);
        if (($form->isValid())) {
             $em = $this->getDoctrine()->getManager();
            $event = new FormEvent($form, $request);
            $dispatcher->dispatch(FOSUserEvents::REGISTRATION_SUCCESS, $event);

            $userManager->updateUser($user);
$jobowner=new Jobowner();

            $jobowner->setIdJ($user->getId());
             $em= $this->getDoctrine()->getManager();
            $em->persist($jobowner);
            

            $em->flush();
            
        $url = $this->generateUrl('freelance_front_office_AfficherJobowner');
    $response = new RedirectResponse($url);
    $dispatcher->dispatch(FOSUserEvents::REGISTRATION_COMPLETED, new FilterUserResponseEvent($user, $request, $response));

            return $response;
        }

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AjouterJobowner.html.twig', array('form' => $form->createView()));
    }
public function AjouterPhotoJobownerAction($pseudo) {
        $em = $this->getDoctrine()->getManager();
        $Membre = new Membre();
        $Membre = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);


        $Imageform = $this->createForm(new ImageForm(), $Membre);

        $request = $this->get('request');

        $Imageform->handleRequest($request);

        if ($Imageform->isValid()) {

            $stream = fopen($Membre->getUpload(), 'rb');
            $Membre->setPhoto(stream_get_contents($stream));

            $em->persist($Membre);

            $em->flush();

             return $this->redirect($this->generateUrl('freelance_front_office_AfficherJobowner')); }

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AjouterPhotoJobowner.html.twig', array('Form' => $Imageform->createView()));
    }
    public function AfficherListJobownerAction() {

        $connection = $this->get('database_connection');

        $sql = "SELECT nom, prenom, pays, ville, pseudo,email,societe_j FROM membre m, jobowner j WHERE m.id = j.id_j";
        $stmt = $connection->prepare($sql);
        $stmt->execute();
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AffichageJobowner.html.twig', array('jobowners' => $stmt));
    }
public function FreelancerRechercherJobownerAction()
      { 
        $connection = $this->get('database_connection');
        $dql ="SELECT id,nom, prenom, pays, ville, pseudo, email, photo,societe_j FROM membre m, jobowner j WHERE m.id = j.id_j";
        $stmt = $connection->prepare($dql);
        
        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
        $search = $Request->get('search');
        $dql ="SELECT id, nom, prenom, pays, ville, pseudo, email,photo,societe_j FROM  membre m,jobowner j WHERE m.id = j.id_j AND m.pseudo like  ?";
        $stmt = $connection->prepare($dql);
         $stmt->bindValue(1, '%'.$search.'%');
        $stmt->execute();
        }
          $stmt->execute();
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:FreelancerRechercherJobowner.html.twig', array('jobowners'=>$stmt));
      }
    public function JobownerRechercherJobownerAction()
      { 
        $connection = $this->get('database_connection');
        $dql ="SELECT id,nom, prenom, pays, ville, pseudo, email, photo,societe_j FROM membre m, jobowner j WHERE m.id = j.id_j";
        $stmt = $connection->prepare($dql);
        
        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
        $search = $Request->get('search');
        $dql ="SELECT id, nom, prenom, pays, ville, pseudo, email,photo,societe_j FROM  membre m,jobowner j WHERE m.id = j.id_j AND m.pseudo like ?";
        $stmt = $connection->prepare($dql);
         $stmt->bindValue(1, '%'.$search.'%');
        $stmt->execute();
        }
          $stmt->execute();
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:JobownerRechercherJobowner.html.twig', array('jobowners'=>$stmt));
      }
        public function AfficherPhotoJobownerAction($pseudo) {
        $image_obj = new Membre();
        $em = $this->getDoctrine()->getManager();
        $image_obj = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);

        $photo = $image_obj->getPhoto();
        if( $photo  !=null){
        $response = new StreamedResponse(function () use ($photo) {
            echo stream_get_contents($photo);
        });
        $response->headers->set('Content-Type', 'image/jpeg');
        return $response;
        }else{
            $response = new StreamedResponse(function ()  {

            echo file_get_contents('c:/profileDefault.jpg');
            });
        $response->headers->set('Content-Type', 'image/jpeg');
        return $response;
        }
    }
    
      
    public function JobownerModifierAction($id)
    {$em=$this->getDoctrine()->getManager();
        $Membre = new  Membre();
        $Membre = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->find($id);
        $f= new MembreModifierForm();
        $form=$this->createForm($f,$Membre);
       
        $jobowner = new Jobowner();
        $jobowner = $em->getRepository('FreelanceFrontOfficeBundle:Jobowner')->find($id);
        $f2= new JobownerForm();
        $form2=$this->createForm($f2,$jobowner);
        $request=$this->get('request');
        if($request->getMethod()=="POST"){
            $form->bind($request);
            $form2->bind($request);
            if(($form->isValid())&&($form2->isValid())){
       
            $em->persist($Membre);
            $em->persist($jobowner);
              $em->flush();
                    return $this->redirect($this->generateUrl('freelance_front_office_AfficherJobowner'));

               
            }
        }
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:ModifierJobowner.html.twig',array('form'=>$form->createView(),'form2'=>$form2->createView(),'jobowners'=>$jobowner));
   }
}
