<?php

namespace Freelance\FrontOfficeBundle\Form;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;
use Symfony\Component\Form\AbstractType;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of ReclamationForm
 *
 * @author Mohamed
 */
class ReclamationForm extends AbstractType {
     public function buildForm(FormBuilderInterface $builder, array $options) {
      $builder //->add('expediteur')
               //->add('date')
               ->add('sujet')
               ->add('message')
               ;
               
               
    }
    public function getName() {
        return "Reclamation";
    }
 /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Freelance\FrontOfficeBundle\Entity\Reclamation'
          
        )); }
}