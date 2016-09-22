<?php

namespace Freelance\GrapheBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction($name)
    {
        return $this->render('FreelanceGrapheBundle:Default:index.html.twig', array('name' => $name));
    }
}
