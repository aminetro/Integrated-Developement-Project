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
 * Description of ProjetForm
 *
 * @author hp
 */
class ProjetForm  extends AbstractType{

    public function buildForm(FormBuilderInterface $builder, array $options) {
        $builder
                ->add('titre_p', 'text', array ('attr' => array('class' => 'required')))
                ->add('categorie_p', 'text', array ('attr' => array('class' => 'required')))
                ->add('duree_p', 'text', array ('attr' => array('class' => 'required')))
                ->add('description_p', 'text', array ('attr' => array('class' => 'required')));

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
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Freelance\FrontOfficeBundle\Entity\Projet'
          
        )); }}
