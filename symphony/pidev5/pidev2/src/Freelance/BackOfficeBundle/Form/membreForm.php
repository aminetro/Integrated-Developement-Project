<?php
namespace Freelance\BackOfficeBundle\Form;
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
 * @author sou hm
 */
class membreForm  extends AbstractType {
    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder

                ->add('nom', 'text', array ('attr' => array('class' => 'required')))
                ->add('prenom', 'text', array ('attr' => array('class' => 'required')))
                ->add('pays', 'text', array ('attr' => array('class' => 'required')))
                ->add('ville', 'text', array ('attr' => array('class' => 'required')))
                ->add('pseudo', 'text', array ('attr' => array('class' => 'required')))
                ->add('password', 'text', array ('attr' => array('class' => 'required')))
                ->add('email', 'text', array ('attr' => array('class' => 'required')));
            //->add('Isncription','submit');
      }
    

    public function getName() {
        return "nom";
    }
    
    /*
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Freelance\BackOfficeBundle\Entity\Membre',
        ));
    }
   */
    
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Freelance\BackOfficeBundl\Entity\Membre'
          
        )); }
}
