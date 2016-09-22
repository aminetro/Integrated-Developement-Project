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
 * Description of FormType
 *
 * @author hp
 */
class FormType extends AbstractType {
 public function buildForm(FormBuilderInterface $builder, array $options) {
        parent::buildForm($builder, $options);
        $builder
                ->add('nom','text')
                ->add('prenom','text')
                ->add('tel','text')
                ->add('from','email')
                ->add('text','textarea')

                ;
      }
    

    public function getName() {
        return "nom";
    }
    
 
    
    
}
