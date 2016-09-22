<?php

namespace Freelance\SwiftMailBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Silex\Application;



use Freelance\SwiftMailBundle\Entity\Mail AS Mail;
//use Freelance\FrontOfficeBundle\Form\freelanceForm AS freelancerForm;
use Freelance\SwiftMailBundle\Form\MailType AS MailType;

use Swift_Message;

class DefaultController extends Controller
{
    public function indexAction($name)
    {
        return $this->render('FreelanceSwiftMailBundle:Default:index.html.twig', array('name' => $name));
    }
    public function sendMailAction()
    {
    $to="elusive.di.elusive@gmail.com";
$mail=new Mail();
$form=$this->createForm(new MailType(),$mail);
 $request = $this->get('request');

      //  $request = ob_get_contents();
      //  $request = $this->get('request');
 $form->handleRequest($request);

if($form->isValid())
{
$message=Swift_Message::newinstance()
->setSubject($mail->getSubject())
->setFrom($to)
->setTo($mail->getTo())
->setBody($mail->getText());
//array($mail->getPrenom(),$mail->getTel())
$this->get('mailer')->send($message);
return $this->render('FreelanceSwiftMailBundle:Mail:mail.html.twig');

}

        
return $this->render('FreelanceSwiftMailBundle:Mail:new.html.twig',array('form'=>$form->createView()));

    }
   
        


public function CantactUsAction()
    {
    $to="elusive.di.elusive@gmail.com";
$mail=new Mail();
$form=$this->createForm(new MailType(),$mail);
 $request = $this->get('request');

      //  $request = ob_get_contents();
      //  $request = $this->get('request');
 $form->handleRequest($request);

if($form->isValid())
{
$message=Swift_Message::newinstance()
->setSubject($mail->getSubject())
->setFrom($to)
->setTo($to)
->setBody("Sent By : ".$mail->getNom()."\nMail : ".$mail->getTo()."\nMessage : ".$mail->getText());
//array($mail->getPrenom(),$mail->getTel())
$this->get('mailer')->send($message);
return $this->render('FreelanceSwiftMailBundle:Mail:mail.html.twig');

}
    

        
return $this->render('FreelanceSwiftMailBundle:Mail:new.html.twig',array('form'=>$form->createView()));
    }
    


     public function FreelancerCantactUsAction()
    {
    $to="elusive.di.elusive@gmail.com";
$mail=new Mail();
$form=$this->createForm(new MailType(),$mail);
 $request = $this->get('request');

      //  $request = ob_get_contents();
      //  $request = $this->get('request');
 $form->handleRequest($request);

if($form->isValid())
{
$message=Swift_Message::newinstance()
->setSubject($mail->getSubject())
->setFrom($to)
->setTo($mail->getTo())
->setBody($mail->getText());
//array($mail->getPrenom(),$mail->getTel())
$this->get('mailer')->send($message);
return $this->render('FreelanceSwiftMailBundle:Mail:FreelancerSucess.html.twig');

}

        
return $this->render('FreelanceSwiftMailBundle:Mail:FreelancerCantactUS.html.twig',array('form'=>$form->createView()));

    }   
   public function JobownerCantactUsAction()
    {
    $to="elusive.di.elusive@gmail.com";
$mail=new Mail();
$form=$this->createForm(new MailType(),$mail);
 $request = $this->get('request');

      //  $request = ob_get_contents();
      //  $request = $this->get('request');
 $form->handleRequest($request);

if($form->isValid())
{
$message=Swift_Message::newinstance()
->setSubject($mail->getSubject())
->setFrom($to)
->setTo($mail->getTo())
->setBody($mail->getText());
//array($mail->getPrenom(),$mail->getTel())
$this->get('mailer')->send($message);
return $this->render('FreelanceSwiftMailBundle:Mail:JobownerSucess.html.twig');

}

        
return $this->render('FreelanceSwiftMailBundle:Mail:JobownerCantactUS.html.twig',array('form'=>$form->createView()));

    }
}
