<?php

/* FreelanceFrontOfficeBundle:FrontOffice:FreelancerRechercherFreelancer.html.twig */
class __TwigTemplate_4adf6f5a2ad71bc17db2403773b0ea519b26e03a1b9a81a9037a04678e4c78ff extends Twig_Template
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

    // line 4
    public function block_content($context, array $blocks = array())
    {
        echo " 
<h1> Liste des Freelancers </h1>
<form action=\"\" class=\"content-form\" method=\"POST\">
  <input type=\"text\" class=\"input-medium search-query\"  placeholder=\"Rechercher Par Pseudo\"size=\"35\" name=\"search\"/>
    <input type=\"submit\" class=\"btn btn-primary\" value=\"Recherche\">

</form>
<table class=\"table table-bordered\">
    <thead>

    <th> nom </th>
    <th> Prenom </th>
    <th> Pays </th>
    <th> Ville </th>
    <th> Pseudo </th>
    <th> Email</th>
    <th> Disponibilite </th>


    <th> Photo</th>




</thead>

";
        // line 30
        $context['_parent'] = (array) $context;
        $context['_seq'] = twig_ensure_traversable($this->getContext($context, "membre"));
        foreach ($context['_seq'] as $context["_key"] => $context["m"]) {
            // line 31
            echo "<tr>

    <td>";
            // line 33
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "nom", array()), "html", null, true);
            echo "</td>
    <td>";
            // line 34
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "prenom", array()), "html", null, true);
            echo "</td>
    <td>";
            // line 35
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "pays", array()), "html", null, true);
            echo "</td>
    <td>";
            // line 36
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "ville", array()), "html", null, true);
            echo "</td>
    <td>";
            // line 37
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "pseudo", array()), "html", null, true);
            echo "</td>

    <td>";
            // line 39
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "email", array()), "html", null, true);
            echo "</td>
    <td>";
            // line 40
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "disponibilite_f", array()), "html", null, true);
            echo "</td>
    <td><img  class=\"img-circle\" data-src=\"holder.js/140x140\" alt=\"140x140\" style=\"width: 140px; height: 140px;\" src=\"";
            // line 41
            echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl($this->env->getExtension('routing')->getPath("freelance_front_office_AfficherPhotoFreelancer", array("pseudo" => $this->getAttribute($context["m"], "pseudo", array())))), "html", null, true);
            echo "\"/> </td>
<td>
\t\t\t\t\t\t\t\t<a href=\"";
            // line 43
            echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl($this->env->getExtension('routing')->getPath("freelance_front_FreelancerMessagerieAjouter", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "pseudo", array()), "pseudo1" => $this->getAttribute($context["m"], "pseudo", array())))), "html", null, true);
            echo "\">Envoyer Un Message</a>
\t\t\t\t\t\t\t</td>

</tr>
";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['m'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 48
        echo "</table>
";
    }

    public function getTemplateName()
    {
        return "FreelanceFrontOfficeBundle:FrontOffice:FreelancerRechercherFreelancer.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  119 => 48,  108 => 43,  103 => 41,  99 => 40,  95 => 39,  90 => 37,  86 => 36,  82 => 35,  78 => 34,  74 => 33,  70 => 31,  66 => 30,  36 => 4,  11 => 1,);
    }
}
