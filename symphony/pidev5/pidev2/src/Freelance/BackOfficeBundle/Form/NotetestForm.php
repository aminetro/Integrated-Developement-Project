<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

namespace Freelance\BackOfficeBundle\Form;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;
use Symfony\Component\Form\AbstractType;

/**
 * Description of NotetestForm
 *
 * @author sou hm
 */
class NotetestForm  extends AbstractType{
        public function buildForm(FormBuilderInterface $builder, array $options) {
        parent::buildForm($builder, $options);
        $builder
              //->add('idF')
                ->add('nomTest')
                ->add('noteTest')
              
             ->add('Isncription','submit');
      }
    
      
      
   
      

    public function getName() {
        return "nom";
    }
    
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Freelance\FrontOfficeBundle\Entity\Notetest'
          
        )); }
}
