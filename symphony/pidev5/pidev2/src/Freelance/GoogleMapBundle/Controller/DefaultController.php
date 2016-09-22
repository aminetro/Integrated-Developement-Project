<?php

namespace Freelance\GoogleMapBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {   
        
        $Latitudes='-24';
        $Longitudes='142';
        //$name='name';
        return $this->render('FreelanceGoogleMapBundle:Default:index.html.twig', array('Latitudes' => $Latitudes , 'Longitudes'=>$Longitudes ));
    }
 
}
