<?php

/* FreelanceFrontOfficeBundle:FrontOffice:JobownerMessagerieAfficher.html.twig */
class __TwigTemplate_1f8df8bc593c2a111a1cef2692537897d92a41373e30df9f978be1853431ec96 extends Twig_Template
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
<h1>Mes Messages </h1>
<form action=\"\" class=\"content-form\" method=\"POST\">

</form>
<table class=\"table table-striped\">
    <thead>
   
    <th> Expediteur </th>
    <th> Date </th>
    <th> Sujet </th>
    <th> Message </th>
    <th> Repondre </th>
     <th> Supprimer</th>


";
        // line 19
        $context['_parent'] = (array) $context;
        $context['_seq'] = twig_ensure_traversable($this->getContext($context, "messages"));
        foreach ($context['_seq'] as $context["_key"] => $context["m"]) {
            // line 20
            echo "<thead>

    <td>";
            // line 22
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "expediteur", array()), "html", null, true);
            echo "</td>
    <td>";
            // line 23
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "date", array()), "html", null, true);
            echo "</td>
    <td>";
            // line 24
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "sujet", array()), "html", null, true);
            echo "</td>
    <td>";
            // line 25
            echo twig_escape_filter($this->env, $this->getAttribute($context["m"], "message", array()), "html", null, true);
            echo "</td>
    <td><a href=\"";
            // line 26
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_JobownerMessagerieAjouter", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()), "pseudo1" => $this->getAttribute($context["m"], "expediteur", array()))), "html", null, true);
            echo "\">Envoyer</a></td>
  <td><a href=\"";
            // line 27
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_JobownerMessagerieSupprimer", array("id" => $this->getAttribute($context["m"], "id", array()))), "html", null, true);
            echo "\">Supprimer</a></td>

   </thead>


     ";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['m'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 33
        echo "   </table>
 ";
    }

    public function getTemplateName()
    {
        return "FreelanceFrontOfficeBundle:FrontOffice:JobownerMessagerieAfficher.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  96 => 33,  84 => 27,  80 => 26,  76 => 25,  72 => 24,  68 => 23,  64 => 22,  60 => 20,  56 => 19,  36 => 3,  11 => 1,);
    }
}
