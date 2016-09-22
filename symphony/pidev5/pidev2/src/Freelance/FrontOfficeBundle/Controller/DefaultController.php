<?php

namespace Freelance\FrontOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function AcceuilFreelanceAction()
    {
       // return $this->render('FreelanceFrontOfficeBundle:Default:index.html.twig', array('name' => $name));
            return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AcceuilFreelance.html.twig');

        
    }
    public function AccessDeniedAction()
    {
       // return $this->render('FreelanceFrontOfficeBundle:Default:index.html.twig', array('name' => $name));
            return $this->render('FreelanceFrontOfficeBundle:FrontOffice:403.html.twig');

        
    }
    
    public function AboutUsAction()
    {
       // return $this->render('FreelanceFrontOfficeBundle:Default:index.html.twig', array('name' => $name));
            return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AboutUs.html.twig');

        
    }
}
