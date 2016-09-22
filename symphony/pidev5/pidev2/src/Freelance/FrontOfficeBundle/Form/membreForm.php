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
 * Description of membreForm
 *
 * @author hp
 */
class membreForm extends AbstractType {

    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
               ->add('nom', 'text', array('attr' => array('class' => 'required')))
                ->add('prenom', 'text', array('attr' => array('class' => 'required')))
                ->add('pays', 'text', array('attr' => array('class' => 'required')))
                ->add('ville', 'text', array('attr' => array('class' => 'required')))
                ->add('pseudo', 'text', array('attr' => array('class' => 'required')))
            ->add('email', 'email', array('label' => 'form.email', 'translation_domain' => 'FOSUserBundle'))
            ->add('username', null, array('label' => 'form.username', 'translation_domain' => 'FOSUserBundle'))
            ->add('plainPassword', 'repeated', array(
                'type' => 'password',
                'options' => array('translation_domain' => 'FOSUserBundle'),
                'first_options' => array('label' => 'form.password'),
                'second_options' => array('label' => 'form.password_confirmation'),
                'invalid_message' => 'fos_user.password.mismatch',
            ))
        ;
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
    public function setDefaultOptions(OptionsResolverInterface $resolver) {
        $resolver->setDefaults(array(
            'data_class' => 'Freelance\FrontOfficeBundle\Entity\Membre'
        ));
    }

}
