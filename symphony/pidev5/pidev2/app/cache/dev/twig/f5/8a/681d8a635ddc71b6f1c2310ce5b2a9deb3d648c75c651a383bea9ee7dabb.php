<?php

/* FreelanceFrontOfficeBundle:FrontOffice:FreelancerRechercherJobowner.html.twig */
class __TwigTemplate_f58a681d8a635ddc71b6f1c2310ce5b2a9deb3d648c75c651a383bea9ee7dabb extends Twig_Template
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
<h1> Liste des Jobowners</h1>
<div clas=\"control-group\">
<form action=\"\" method=\"POST\">
 <input type=\"text\" class=\"input-medium search-query\"  placeholder=\"Rechercher Par Pseudo\"size=\"35\" name=\"search\"/>
    <input type=\"submit\" class=\"btn btn-primary\" value=\"Recherche\">
</form>
</div>
<table class=\"table table-bordered\">
    <thead>
   
    <th> nom </th>
    <th> Prenom </th>
    <th> Pays </th>
    <th> Ville </th>
    <th> Pseudo </th>
    
    <th> Mail </th>
      <th> Photo </th>
    <th> Nom DE LA SOCIETE  </th>
 
   
  
</thead>

";
        // line 28
        $context['_parent'] = (array) $context;
        $context['_seq'] = twig_ensure_traversable($this->getContext($context, "jobowners"));
        foreach ($context['_seq'] as $context["_key"] => $context["m"]) {
            // line 29
            echo "<tr>

    <td>";
            // line 31
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "nom", array()), "html", null, true);
            echo "</td>
    <td>";
            // line 32
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "prenom", array()), "html", null, true);
            echo "</td>
    <td>";
            // line 33
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "pays", array()), "html", null, true);
            echo "</td>
    <td>";
            // line 34
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "ville", array()), "html", null, true);
            echo "</td>
    <td>";
            // line 35
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "pseudo", array()), "html", null, true);
            echo "</td>

    <td>";
            // line 37
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "email", array()), "html", null, true);
            echo "</td>
   <td> <img  class=\"img-circle\" data-src=\"";
            // line 38
            echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("holder.js/140x140"), "html", null, true);
            echo "\" alt=\"100x100\" style=\"width: 100px; height: 100px;\" src=\"";
            echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl($this->env->getExtension('routing')->getPath("freelance_front_office_AfficherPhotoJobowner", array("pseudo" => $this->getAttribute($context["m"], "pseudo", array())))), "html", null, true);
            echo "\"/> 
</td>
    <td>";
            // line 40
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "societe_j", array()), "html", null, true);
            echo "</td>
    <td>
\t\t\t\t\t\t\t\t<a href=\"";
            // line 42
            echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl($this->env->getExtension('routing')->getPath("freelance_front_FreelancerMessagerieAjouter", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "pseudo", array()), "pseudo1" => $this->getAttribute($context["m"], "pseudo", array())))), "html", null, true);
            echo "\">Envoyer Un Message</a>
\t\t\t\t\t\t\t</td>

   


</tr>
";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['m'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 50
        echo "</table>
 ";
    }

    public function getTemplateName()
    {
        return "FreelanceFrontOfficeBundle:FrontOffice:FreelancerRechercherJobowner.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  124 => 50,  110 => 42,  105 => 40,  98 => 38,  94 => 37,  89 => 35,  85 => 34,  81 => 33,  77 => 32,  73 => 31,  69 => 29,  65 => 28,  36 => 3,  11 => 1,);
    }
}
