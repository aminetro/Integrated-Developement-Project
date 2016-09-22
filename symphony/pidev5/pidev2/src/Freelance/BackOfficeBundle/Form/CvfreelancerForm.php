<?php
namespace Freelance\BackOfficeBundle\Form;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;
use Symfony\Component\Form\AbstractType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of CvfreelancerForm
 *
 * @author sou hm
 */
class CvfreelancerForm extends AbstractType{
    public function buildForm(FormBuilderInterface $builder, array $options) {
        parent::buildForm($builder, $options);
        $builder
                //->add('dernier_maj_cv')
                ->add('experience_cv', 'text', array ('attr' => array('class' => 'required')))
                ->add('langue_cv', 'text', array ('attr' => array('class' => 'required')))
                ->add('Certification_cv', 'text', array ('attr' => array('class' => 'required')))
                ->add('formation_cv', 'text', array ('attr' => array('class' => 'required')));

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
            'data_class' => 'Freelance\FrontOfficeBundle\Entity\Cvfreelancer'
          
        )); }
}
