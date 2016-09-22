<?php

/* FreelanceFrontOfficeBundle:FrontOffice:AffichageJobowner.html.twig */
class __TwigTemplate_c97ef37a5a1e728dfb407a50b4cc3e2ffbc1174fb9fbfc31ff4e72f6f9e9c4cf extends Twig_Template
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
<h1> Profil Jobowner</h1>

<table class=\"table table-striped\">
    <thead>
   
    <th> nom </th>
    <th> Prenom </th>
    <th> Pays </th>
    <th> Ville </th>
   
    
    <th> Pseudo </th>
   
    <th>Mail</th>
 
  <th> Photo </th>
  
</thead>


<tr>

    <td>";
        // line 26
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "nom", array()), "html", null, true);
        echo "</td>
    <td>";
        // line 27
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "prenom", array()), "html", null, true);
        echo "</td>
    <td>";
        // line 28
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "pays", array()), "html", null, true);
        echo "</td>
    <td>";
        // line 29
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "ville", array()), "html", null, true);
        echo "</td>
    <td>";
        // line 30
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "pseudo", array()), "html", null, true);
        echo "</td>

    <td>";
        // line 32
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "email", array()), "html", null, true);
        echo "</td>

 <td> <img  class=\"img-circle\" data-src=\"";
        // line 34
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("holder.js/140x140"), "html", null, true);
        echo "\" alt=\"100x100\" style=\"width: 100px; height: 100px;\" src=\"";
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl($this->env->getExtension('routing')->getPath("freelance_front_office_AfficherPhotoJobowner", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "pseudo", array())))), "html", null, true);
        echo "\"/> 
</td>



</tr>

</table>
 ";
    }

    public function getTemplateName()
    {
        return "FreelanceFrontOfficeBundle:FrontOffice:AffichageJobowner.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  89 => 34,  84 => 32,  79 => 30,  75 => 29,  71 => 28,  67 => 27,  63 => 26,  36 => 3,  11 => 1,);
    }
}
