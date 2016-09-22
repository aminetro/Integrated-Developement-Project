<?php
namespace Freelance\BackOfficeBundle\Form;
use Symfony\Component\Form\AbstractType;

use Symfony\Component\Form\FormBuilderInterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of MessageForme
 *
 * @author sou hm
 */


class  MessagerieForm extends AbstractType  {
  
    public function buildForm(FormBuilderInterface $builder, array $options) {
      $builder ->add('expediteur')
               ->add('recepteur')
               ->add('date')
               ->add('sujet')
               ->add('message');
              
              
    }
    
    
    
    public function getName() {
        return "Messagerie";
    }

}
