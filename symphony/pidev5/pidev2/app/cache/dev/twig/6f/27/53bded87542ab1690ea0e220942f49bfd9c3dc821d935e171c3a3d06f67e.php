<?php

/* FreelanceGrapheBundle:Graphe:StatistiqueProjet.html.twig */
class __TwigTemplate_6f2753bded87542ab1690ea0e220942f49bfd9c3dc821d935e171c3a3d06f67e extends Twig_Template
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
            'StatPays' => array($this, 'block_StatPays'),
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
    public function block_StatPays($context, array $blocks = array())
    {
        // line 4
        echo "<div class=\"row\">
    <div class=\"span6\">

        <div class=\"flexslider flexslider-center-mobile flexslider-simple\" data-plugin-options='{\"animation\":\"slide\", \"animationLoop\": true, \"maxVisibleItems\": 1}'>
            <ul class=\"slides\">
                <li>
\t\t\t\t\t\t\t\t\t\t";
        // line 10
        echo $this->env->getExtension('http_kernel')->renderFragment($this->env->getExtension('http_kernel')->controller("FreelanceGrapheBundle:Graphe:chartPieProjet"));
        echo "

                </li>

            </ul>
        </div>



    </div>
    <div class=\"span6\">

        <div class=\"flexslider flexslider-center-mobile flexslider-simple\" data-plugin-options='{\"animation\":\"slide\", \"animationLoop\": true, \"maxVisibleItems\": 1}'>
            <ul class=\"slides\">
                <li>
\t\t\t\t\t\t\t\t\t\t";
        // line 25
        echo $this->env->getExtension('http_kernel')->renderFragment($this->env->getExtension('http_kernel')->controller("FreelanceGrapheBundle:Graphe:ChartHistogrammeProjet"));
        echo "</li>

            </ul>
        </div>



    </div>


</div>
";
    }

    public function getTemplateName()
    {
        return "FreelanceGrapheBundle:Graphe:StatistiqueProjet.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  65 => 25,  47 => 10,  39 => 4,  36 => 3,  11 => 1,);
    }
}
