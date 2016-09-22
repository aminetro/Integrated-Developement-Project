<?php

/*
 * This file is part of the FOSUserBundle package.
 *
 * (c) FriendsOfSymfony <http://friendsofsymfony.github.com/>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

namespace FOS\UserBundle\Form\Type;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class RegistrationFormType extends AbstractType
{
    private $class;

    /**
     * @param string $class The User class name
     */
    public function __construct($class)
    {
        $this->class = $class;
    }

    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
                ->add('nom', 'text', array('attr' => array('class' => 'required')))
                ->add('prenom', 'text', array('attr' => array('class' => 'required')))
                ->add('pays', 'text', array('attr' => array('class' => 'required')))
                ->add('ville', 'text', array('attr' => array('class' => 'required')))
                ->add('pseudo', 'text', array('attr' => array('class' => 'required')))
            ->add('email', 'email', array('label' => 'email', 'translation_domain' => 'FOSUserBundle'))
            ->add('username', null, array('label' => 'username', 'translation_domain' => 'FOSUserBundle'))
            ->add('plainPassword', 'repeated', array(
                'type' => 'password',
                'options' => array('translation_domain' => 'FOSUserBundle'),
                'first_options' => array('label' => 'password'),
                'second_options' => array('label' => 'password confirmation'),
                'invalid_message' => 'fos_user.password.mismatch',
            ))
        ;
    }

    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => $this->class,
            'intention'  => 'registration',
        ));
    }

    public function getName()
    {
        return 'fos_user_registration';
    }
}
