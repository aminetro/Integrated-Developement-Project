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
 * Description of AdministrateurForm
 *
 * @author sou hm
 */
class AdministrateurForm extends AbstractType  {
  
    public function buildForm(FormBuilderInterface $builder, array $options) {
      $builder ->add('nom')
               ->add('prenom')
               ->add('pays')
               ->add('ville')
               ->add('email')
                     ->add('submit','submit');

      
              
          
              
    }
    
    
    
    public function getName() {
        return "Administrateur";
    }

}
