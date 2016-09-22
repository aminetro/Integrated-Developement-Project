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
 * Description of MessagerieForm
 *
 * @author hp
 */
class MessagerieForm  extends AbstractType{
     public function buildForm(FormBuilderInterface $builder, array $options) {
      $builder //->add('expediteur')
               //->add('date')
               //->add('recepteur')
               ->add('sujet')
               ->add('message','textarea',array ('attr' => array('class' => 'span6 control-group')));
               //->add('Save','submit');
               
               
    }

    public function getName() {
        return "Messagerie";
    }
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Freelance\FrontOfficeBundle\Entity\Messagerie'
          
        )); }

}