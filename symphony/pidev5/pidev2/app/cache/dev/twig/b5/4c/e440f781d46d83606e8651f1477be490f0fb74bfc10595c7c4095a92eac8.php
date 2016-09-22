<?php

/* FreelanceFrontOfficeBundle:FrontOffice:AfficherListCandidature.html.twig */
class __TwigTemplate_b54ce440f781d46d83606e8651f1477be490f0fb74bfc10595c7c4095a92eac8 extends Twig_Template
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
<h1> Liste des équipes</h1>

<table class=\"table table-bordered\">
    <thead>

        <th> pseufreelancer </th>
        <th> estimation </th>
        <th> lettre_mot </th>
        <th> question </th>
        <th> Accepter  Candidature </th>

    </thead>

";
        // line 17
        $context['_parent'] = (array) $context;
        $context['_seq'] = twig_ensure_traversable($this->getContext($context, "ca"));
        foreach ($context['_seq'] as $context["_key"] => $context["c"]) {
            // line 18
            echo "    <tr>

        <td>";
            // line 20
            echo twig_escape_filter($this->env, $this->getAttribute($context["c"], "pseufreelancer", array()), "html", null, true);
            echo "</td>
        <td>";
            // line 21
            echo twig_escape_filter($this->env, $this->getAttribute($context["c"], "estimation", array()), "html", null, true);
            echo "</td>
        <td>";
            // line 22
            echo twig_escape_filter($this->env, $this->getAttribute($context["c"], "lettre_mot", array()), "html", null, true);
            echo "</td>
        <td>";
            // line 23
            echo twig_escape_filter($this->env, $this->getAttribute($context["c"], "question", array()), "html", null, true);
            echo "</td>
              

        <td><a href=\"";
            // line 26
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_AffecterCandidature", array("pseudo" => $this->getAttribute($context["c"], "pseufreelancer", array()), "id" => $this->getAttribute($context["c"], "id_p", array()))), "html", null, true);
            echo "\">Accepter  Candidature</a></td>
 
    </tr>
";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['c'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 30
        echo "</table>

 ";
    }

    public function getTemplateName()
    {
        return "FreelanceFrontOfficeBundle:FrontOffice:AfficherListCandidature.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  90 => 30,  80 => 26,  74 => 23,  70 => 22,  66 => 21,  62 => 20,  58 => 18,  54 => 17,  36 => 3,  11 => 1,);
    }
}
