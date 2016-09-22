<?php

/* FreelanceFrontOfficeBundle:FrontOffice:ModifierFreelancer.html.twig */
class __TwigTemplate_956d579708c5bc1f4c1b55f77f59258458db6c85e8b25aabdec3e4fd5c4d75cd extends Twig_Template
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

<<div class=\"container\">

\t\t\t\t\t<div class=\"row\">
<div class=\"span6\">

    <div class=\"alert alert-success hidden\" id=\"contactSuccess\">
        <strong>Success!</strong> Your message has been sent to us.
    </div>

    <div class=\"alert alert-error hidden\" id=\"contactError\">
        <strong>Error!</strong> There was an error sending your message.
    </div>

    <h2 class=\"short\"><strong>Modifier </strong>Mon Profil</h2>
    <form  id=\"contactForm\" method=\"post\"  action=\"";
        // line 19
        echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_ModifierFreelancer", array("pseudo" => $this->getAttribute($this->getContext($context, "m"), "pseudo", array()))), "html", null, true);
        echo "\">



        <div class=\"row controls\">
            <div class=\"span6 control-group\">
                <label>";
        // line 25
        echo $this->env->getExtension('form')->renderer->searchAndRenderBlock($this->getAttribute($this->getContext($context, "formMembre"), "nom", array()), 'label');
        echo "
                </label>
              ";
        // line 27
        echo $this->env->getExtension('form')->renderer->searchAndRenderBlock($this->getAttribute($this->getContext($context, "formMembre"), "nom", array()), 'widget');
        echo "
                <label >";
        // line 28
        echo $this->env->getExtension('form')->renderer->searchAndRenderBlock($this->getAttribute($this->getContext($context, "formMembre"), "prenom", array()), 'label');
        echo "</label>
                ";
        // line 29
        echo $this->env->getExtension('form')->renderer->searchAndRenderBlock($this->getAttribute($this->getContext($context, "formMembre"), "prenom", array()), 'widget');
        echo "
                <label >";
        // line 30
        echo $this->env->getExtension('form')->renderer->searchAndRenderBlock($this->getAttribute($this->getContext($context, "formMembre"), "pays", array()), 'label');
        echo "</label>
                ";
        // line 31
        echo $this->env->getExtension('form')->renderer->searchAndRenderBlock($this->getAttribute($this->getContext($context, "formMembre"), "pays", array()), 'widget');
        echo "
                <label>";
        // line 32
        echo $this->env->getExtension('form')->renderer->searchAndRenderBlock($this->getAttribute($this->getContext($context, "formMembre"), "ville", array()), 'label');
        echo "</label>
                ";
        // line 33
        echo $this->env->getExtension('form')->renderer->searchAndRenderBlock($this->getAttribute($this->getContext($context, "formMembre"), "ville", array()), 'widget');
        echo "
              
               
                <label>";
        // line 36
        echo $this->env->getExtension('form')->renderer->searchAndRenderBlock($this->getAttribute($this->getContext($context, "formMembre"), "email", array()), 'label');
        echo "</label>
                ";
        // line 37
        echo $this->env->getExtension('form')->renderer->searchAndRenderBlock($this->getAttribute($this->getContext($context, "formMembre"), "email", array()), 'widget');
        echo "
             
  <br/>
 <input type=\"submit\" value=\"Modifier Mon Profil\" class=\"btn btn-primary btn-large\" data-loading-text=\"Loading...\"/>

                </div>
               
            </div>

        ";
        // line 46
        echo $this->env->getExtension('form')->renderer->searchAndRenderBlock($this->getContext($context, "formMembre"), 'rest');
        echo "
   
    </form>
   
        </div> </div></div>
  
  
 ";
    }

    public function getTemplateName()
    {
        return "FreelanceFrontOfficeBundle:FrontOffice:ModifierFreelancer.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  116 => 46,  104 => 37,  100 => 36,  94 => 33,  90 => 32,  86 => 31,  82 => 30,  78 => 29,  74 => 28,  70 => 27,  65 => 25,  56 => 19,  36 => 3,  11 => 1,);
    }
}
