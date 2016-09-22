<?php

namespace Freelance\BackOfficeBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class TestType extends AbstractType
{
    /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('nom')
            ->add('question1')
            ->add('reponse1','choice', array('choices'   => array('' => '','Oui' => 'oui', 'Non' => 'non')))
            ->add('question2')
            ->add('reponse2','choice', array('choices'   => array('' => '','Oui' => 'oui', 'Non' => 'non')))
            ->add('question3')
            ->add('reponse3','choice', array('choices'   => array('' => '','Oui' => 'oui', 'Non' => 'non')))
            ->add('question4')
            ->add('reponse4','choice', array('choices'   => array('' => '','Oui' => 'oui', 'Non' => 'non')))
            ->add('question5')
            ->add('reponse5','choice', array('choices'   => array('' => '','Oui' => 'oui', 'Non' => 'non')))
            ->add('question6')
            ->add('reponse6','choice', array('choices'   => array('' => '','Oui' => 'oui', 'Non' => 'non')))
            ->add('Isncription','submit');
        ;
    }
    
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Freelance\FrontOfficeBundle\Entity\Test'
        ));
    }

    /**
     * @return string
     */
    public function getName()
    {
        return 'freelance_frontofficebundle_test';
    }
}
