<?php

/* FOSUserBundle:Security:login.html.twig */
class __TwigTemplate_692c99b31ff7319e8e37918e7054fd6c47177a8171f1cad98199fb0c5f752886 extends Twig_Template
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

    // line 2
    public function block_content($context, array $blocks = array())
    {
        echo " 
<center>
";
        // line 5
        echo "

";
        // line 7
        if ($this->getContext($context, "error")) {
            // line 8
            echo "    <div>";
            echo twig_escape_filter($this->env, $this->env->getExtension('translator')->trans($this->getAttribute($this->getContext($context, "error"), "messageKey", array()), $this->getAttribute($this->getContext($context, "error"), "messageData", array()), "security"), "html", null, true);
            echo "</div>
";
        }
        // line 10
        echo "
<form action=\"";
        // line 11
        echo $this->env->getExtension('routing')->getPath("fos_user_security_check");
        echo "\" method=\"post\">
    <input type=\"hidden\" name=\"_csrf_token\" value=\"";
        // line 12
        echo twig_escape_filter($this->env, $this->getContext($context, "csrf_token"), "html", null, true);
        echo "\" />

    <label for=\"username\">Username</label>
    <input type=\"text\" class=\"span3\" id=\"username\" name=\"_username\" value=\"";
        // line 15
        echo twig_escape_filter($this->env, $this->getContext($context, "last_username"), "html", null, true);
        echo "\" required=\"required\" />

    <label for=\"password\">Password</label>
    <input type=\"password\" class=\"span3\" id=\"password\" name=\"_password\" required=\"required\" />
    <br/>

    <input type=\"submit\" id=\"_submit\" name=\"_submit\" value=\"Se Connecter\" class=\"btn btn-primary btn-large\"/>
</form>
    </center>
";
    }

    public function getTemplateName()
    {
        return "FOSUserBundle:Security:login.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  67 => 15,  61 => 12,  57 => 11,  54 => 10,  48 => 8,  46 => 7,  42 => 5,  36 => 2,  11 => 1,);
    }
}
