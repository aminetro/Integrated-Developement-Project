
<?php

namespace Freelance\FrontOfficeBundle\Form;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Description of CvfreelancerForm
 *
 * @author hp
 */
class JobownerForm extends AbstractType {
  
     public function buildForm(FormBuilderInterface $builder, array $options) {
      
         $builder 
               ->add('societe_j', 'text', array ('attr' => array('class' => 'required'))); 
              
              }
public function getName() {
        return "jobowner";  
    }
}
