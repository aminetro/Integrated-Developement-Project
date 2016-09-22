<?php

/* FreelanceFrontOfficeBundle:FrontOffice:AjouterFreelancer.html.twig */
class __TwigTemplate_6f6568e1e4f8d2a4d839fa9e99b4eb84fd7d8895a7e045bf0665f16fc60925e2 extends Twig_Template
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
<div class=\"container\">

\t\t\t\t\t<div class=\"row\">
<div class=\"span6\">

    <div class=\"alert alert-success hidden\" id=\"contactSuccess\">
        <strong>Success!</strong> Your message has been sent to us.
    </div>

    <div class=\"alert alert-error hidden\" id=\"contactError\">
        <strong>Error!</strong> There was an error sending your message.
    </div>

    <h2 class=\"short\"><strong>Inscription Freelancer </strong></h2>
    <form  id=\"contactForm\" method=\"post\">
        <div class=\"row controls\">
            <div class=\"span3 control-group\">

         ";
        // line 22
        echo         $this->env->getExtension('form')->renderer->renderBlock($this->getContext($context, "form"), 'form');
        echo "


                <div class=\"btn-toolbar\">
                    <input type=\"submit\" value=\"S'inscrire\" class=\"btn btn-primary btn-large\" data-loading-text=\"Loading...\">

                </div>
            </div>
        </div>             
   ";
        // line 31
        echo $this->env->getExtension('form')->renderer->searchAndRenderBlock($this->getContext($context, "form"), 'rest');
        echo "
    </form>
</div> </div></div>

 ";
    }

    public function getTemplateName()
    {
        return "FreelanceFrontOfficeBundle:FrontOffice:AjouterFreelancer.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  71 => 31,  59 => 22,  36 => 3,  11 => 1,);
    }
}
