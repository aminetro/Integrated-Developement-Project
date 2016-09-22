<?php

/* FreelanceFrontOfficeBundle:FrontOffice:AfficherCvFreelancerJobowner.html.twig */
class __TwigTemplate_ad80397e0881c1e33b6cd3dddfa90f235bf73f24f441b464cc360ad7771703bb extends Twig_Template
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
<h1> Cv Du Freelancer</h1>

<table class=\"table table-striped\">
    <thead>
       
         <th> Experience </th>
          <th> Langue </th>
            <th> Certification </th>
              <th> Formation </th>
               <th> Dernier mis ajour </th>
               
     </thead>

";
        // line 17
        $context['_parent'] = (array) $context;
        $context['_seq'] = twig_ensure_traversable($this->getContext($context, "cv"));
        foreach ($context['_seq'] as $context["_key"] => $context["c"]) {
            // line 18
            echo "    <tr>

<td>";
            // line 20
            echo twig_escape_filter($this->env, $this->getAttribute($context["c"], "experience_cv", array()), "html", null, true);
            echo "</td>
<td>";
            // line 21
            echo twig_escape_filter($this->env, $this->getAttribute($context["c"], "langueCv", array()), "html", null, true);
            echo "</td>
<td>";
            // line 22
            echo twig_escape_filter($this->env, $this->getAttribute($context["c"], "certificationCv", array()), "html", null, true);
            echo "</td>
<td>";
            // line 23
            echo twig_escape_filter($this->env, $this->getAttribute($context["c"], "formationCv", array()), "html", null, true);
            echo "</td>
<td>";
            // line 24
            echo twig_escape_filter($this->env, twig_date_format_filter($this->env, $this->getAttribute($context["c"], "dernierMajCv", array()), "Y-m-d"), "html", null, true);
            echo "</td>


";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['c'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 28
        echo "</table>

 ";
    }

    public function getTemplateName()
    {
        return "FreelanceFrontOfficeBundle:FrontOffice:AfficherCvFreelancerJobowner.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  88 => 28,  78 => 24,  74 => 23,  70 => 22,  66 => 21,  62 => 20,  58 => 18,  54 => 17,  36 => 3,  11 => 1,);
    }
}
