<?php
namespace Freelance\FrontOfficeBundle\Form;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of ImageForm
 *
 * @author hp
 */
class ImageForm  extends AbstractType {
            
           public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
->add('upload','file', array ('attr' => array('class' => 'btn btn-large disabled')))
    ->add('submit','submit', array ('attr' => array('class' => 'btn btn-primary btn-large')));
                
      }
    

    public function getName() {
        return "nom";
    }
    
    /*
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Freelance\FrontOfficeBundle\Entity\Membre',
        ));
    }
   */
    
    /**
     * @param OptionsResolverInterface $resolver
     */
   
            
}
