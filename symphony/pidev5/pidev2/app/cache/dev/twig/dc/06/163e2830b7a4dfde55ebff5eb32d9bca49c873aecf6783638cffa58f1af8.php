<?php

/* FreelanceGrapheBundle:Graphe:Histogramme.html.twig */
class __TwigTemplate_dc06163e2830b7a4dfde55ebff5eb32d9bca49c873aecf6783638cffa58f1af8 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        // line 1
        echo "

<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\"
type=\"text/javascript\"></script>

<script src=\"//code.highcharts.com/4.0.1/highcharts.js\"></script>
<script src=\"//code.highcharts.com/4.0.1/modules/exporting.js\"></script>
<script type=\"text/javascript\">
    ";
        // line 9
        echo $this->env->getExtension('highcharts_extension')->chart($this->getContext($context, "chart"));
        echo "
</script>

<div id=\"container\" style=\"min-width: 400px; height: 400px; margin: 0 auto\"></div>";
        // line 14
        echo "
";
    }

    public function getTemplateName()
    {
        return "FreelanceGrapheBundle:Graphe:Histogramme.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  35 => 14,  29 => 9,  19 => 1,);
    }
}
