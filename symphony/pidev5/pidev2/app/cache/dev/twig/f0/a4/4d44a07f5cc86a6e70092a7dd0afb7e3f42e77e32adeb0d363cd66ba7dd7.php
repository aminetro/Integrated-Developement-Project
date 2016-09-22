<?php

/* FreelanceFrontOfficeBundle:FrontOffice:AfficherListFavoris.html.twig */
class __TwigTemplate_f0a44d44a07f5cc86a6e70092a7dd0afb7e3f42e77e32adeb0d363cd66ba7dd7 extends Twig_Template
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
<h1> Liste des projets</h1>
<form action=\"\"  method=\"POST\">
    Recherche par titre du film:  <input type=\"text\" class=\"required\"  size=\"35\" name=\"search\"/>
    <input type=\"submit\" class=\"button\" value=\"Recherche\">
</form>
<table class=\"table table-bordered\">
    <thead>
       
        <th> Titre </th>
        <th> Categorie </th>
        <th> Duree </th>
        <th> Description </th>
        <th> Nom JOB Owner </th>
        <th> Nom Freelancer</th>
        <th> Candidater </th>
        <th> défavoriser </th>
 </thead>

";
        // line 22
        $context['_parent'] = (array) $context;
        $context['_seq'] = twig_ensure_traversable($this->getContext($context, "projet"));
        foreach ($context['_seq'] as $context["_key"] => $context["p"]) {
            // line 23
            echo "    <tr>
       
        <td>";
            // line 25
            echo twig_escape_filter($this->env, $this->getAttribute($context["p"], "titre_p", array()), "html", null, true);
            echo "</td>
        <td>";
            // line 26
            echo twig_escape_filter($this->env, $this->getAttribute($context["p"], "categorie_p", array()), "html", null, true);
            echo "</td>
        <td>";
            // line 27
            echo twig_escape_filter($this->env, $this->getAttribute($context["p"], "duree_p", array()), "html", null, true);
            echo "</td>
        <td>";
            // line 28
            echo twig_escape_filter($this->env, $this->getAttribute($context["p"], "description_p", array()), "html", null, true);
            echo "</td>
        <td>";
            // line 29
            echo twig_escape_filter($this->env, $this->getAttribute($context["p"], "owner_p", array()), "html", null, true);
            echo "</td>
        <td>";
            // line 30
            echo twig_escape_filter($this->env, $this->getAttribute($context["p"], "pseudo_f", array()), "html", null, true);
            echo "</td>
      
 <td><a href=\"";
            // line 32
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_AjouterCandidature", array("pseudo" => $this->getAttribute($this->getContext($context, "membre"), "pseudo", array()), "id" => $this->getAttribute($context["p"], "id", array()))), "html", null, true);
            echo "\">Envoyer  Candidature</a></td>
  <td><a href=\"";
            // line 33
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_SupprimerFavoris", array("idf" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "id", array()), "idp" => $this->getAttribute($context["p"], "id", array()))), "html", null, true);
            echo "\">Défavoris</a></td>
    </tr>
";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['p'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 36
        echo "</table>

 ";
    }

    public function getTemplateName()
    {
        return "FreelanceFrontOfficeBundle:FrontOffice:AfficherListFavoris.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  105 => 36,  96 => 33,  92 => 32,  87 => 30,  83 => 29,  79 => 28,  75 => 27,  71 => 26,  67 => 25,  63 => 23,  59 => 22,  36 => 3,  11 => 1,);
    }
}
