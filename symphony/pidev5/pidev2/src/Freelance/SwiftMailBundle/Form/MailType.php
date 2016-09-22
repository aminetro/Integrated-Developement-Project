<?php
namespace  Freelance\SwiftMailBundle\Form;

use Symfony\Component\Form\AbstractType;

use Symfony\Component\Form\FormBuilderInterface;

use Symfony\Component\OptionsResolver\OptionsResolverInterface;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of MailType
 *
 * @author hp
 */
class MailType extends AbstractType {
   


 public function buildForm(FormBuilderInterface $builder, array $options)

 {

 $builder

 ->add('nom', 'text' ,array('attr' => array('class' => 'span3')))



 ->add('Subject', 'text',array('attr' => array('class' => 'span3')))

 ->add('to', 'email',array('label' => 'Votre Mail'),array('attr' => array('class' => 'span3')))

 ->add('text', 'textarea',array('attr' => array('class' => 'span6')))
       
         ->add('Envoyer', 'submit',array('attr' => array('class' => 'btn btn-primary btn-large')))

 ;

 }

 public function getName()

 {

 return 'Mail';

 }
}
