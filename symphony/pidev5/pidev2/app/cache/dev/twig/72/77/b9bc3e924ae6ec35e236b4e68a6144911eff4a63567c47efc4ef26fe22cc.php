<?php

/* FreelanceFrontOfficeBundle:FrontOffice:AjouterPhotoFreelancer.html.twig */
class __TwigTemplate_7277b9bc3e924ae6ec35e236b4e68a6144911eff4a63567c47efc4ef26fe22cc extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        try {
            $this->parent = $this->env->loadTemplate("FreelanceFrontOfficeBundle::layout.html.twig");
        } catch (Twig_Error_Loader $e) {
            $e->setTemplateFile($this->getTemplateName());
            $e->setTemplateLine(1);

            throw $e;
        }

        $this->blocks = array(
            'content' => array($this, 'block_content'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "FreelanceFrontOfficeBundle::layout.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $this->parent->display($context, array_merge($this->blocks, $blocks));
    }

    // line 3
    public function block_content($context, array $blocks = array())
    {
        echo " 
 <h2> <strong> Ajouter Une Photo</strong> </h2>

 <hr>

 ";
        // line 8
        echo         $this->env->getExtension('form')->renderer->renderBlock($this->getContext($context, "Form"), 'form');
        echo "
 ";
    }

    public function getTemplateName()
    {
        return "FreelanceFrontOfficeBundle:FrontOffice:AjouterPhotoFreelancer.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  45 => 8,  36 => 3,  11 => 1,);
    }
}
