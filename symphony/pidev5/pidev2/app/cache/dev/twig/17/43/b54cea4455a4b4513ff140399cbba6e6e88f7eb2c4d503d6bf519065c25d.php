<?php

/* FreelanceFrontOfficeBundle:FrontOffice:AffichageFreelancer.html.twig */
class __TwigTemplate_1743b54cea4455a4b4513ff140399cbba6e6e88f7eb2c4d503d6bf519065c25d extends Twig_Template
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
            'header' => array($this, 'block_header'),
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

    // line 5
    public function block_content($context, array $blocks = array())
    {
        echo " 
<h1><strong> Mon Profil </strong>Freelancer</h1>



<table class=\"table table-striped\">
    <thead>
   
    <th> nom </th>
    <th> Prenom </th>
    <th> Pays </th>
    <th> Ville </th>
    <th> Pseudo </th>
    
    <th> Mail </th>
    <th>Photo</th>




<thead>

    <td>";
        // line 27
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "nom", array()), "html", null, true);
        echo "</td>
    <td>";
        // line 28
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "prenom", array()), "html", null, true);
        echo "</td>
    <td>";
        // line 29
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "pays", array()), "html", null, true);
        echo "</td>
    <td>";
        // line 30
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "ville", array()), "html", null, true);
        echo "</td>
    <td>";
        // line 31
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "pseudo", array()), "html", null, true);
        echo "</td>
    <td>";
        // line 32
        echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "email", array()), "html", null, true);
        echo "</td>
    <td> <img  class=\"img-circle\" data-src=\"";
        // line 33
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("holder.js/140x140"), "html", null, true);
        echo "\" alt=\"100x100\" style=\"width: 100px; height: 100px;\" src=\"";
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl($this->env->getExtension('routing')->getPath("freelance_front_office_AfficherPhotoFreelancer", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "pseudo", array())))), "html", null, true);
        echo "\"/> 
</td>
  
  <td>
\t\t\t\t\t\t\t</td>

                                                        
   </thead>


  
   </table>
 ";
    }

    // line 47
    public function block_header($context, array $blocks = array())
    {
        echo " 
    <div class=\"container\">
\t\t\t\t\t<h1 class=\"logo\">
\t\t\t\t\t\t<a href=\"";
        // line 50
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("index.html"), "html", null, true);
        echo "\">
\t\t\t\t\t\t\t<img alt=\"Porto\" src=\"";
        // line 51
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("img/logo.png"), "html", null, true);
        echo "\">
\t\t\t\t\t\t</a>
\t\t\t\t\t</h1>
\t\t\t\t\t<div class=\"search\">
\t\t\t\t\t\t<form class=\"form-search\" id=\"searchForm\" action=\"page-search-results.html\" method=\"get\">
\t\t\t\t\t\t\t<div class=\"control-group\">
\t\t\t\t\t\t\t\t<input type=\"text\" class=\"input-medium search-query\" name=\"q\" id=\"q\" placeholder=\"Search...\">
\t\t\t\t\t\t\t\t<button class=\"search\" type=\"submit\"><i class=\"icon-search\"></i></button>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</form>
\t\t\t\t\t</div>
\t\t\t\t\t<nav>
\t\t\t\t\t\t<ul class=\"nav nav-pills nav-top\">
\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t<a href=\"about-us.html\"><i class=\"icon-angle-right\"></i>About Us</a>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t<a href=\"contact-us.html\"><i class=\"icon-angle-right\"></i>Contact Us</a>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t<li class=\"phone\">
\t\t\t\t\t\t\t\t<span><i class=\"icon-phone\"></i>(123) 456-7890</span>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t</ul>
\t\t\t\t\t</nav>
\t\t\t\t\t<div class=\"social-icons\">
\t\t\t\t\t\t<ul class=\"social-icons\">
\t\t\t\t\t\t\t<li class=\"facebook\"><a href=\"http://www.facebook.com/\" target=\"_blank\" title=\"Facebook\">Facebook</a></li>
\t\t\t\t\t\t\t<li class=\"twitter\"><a href=\"http://www.twitter.com/\" target=\"_blank\" title=\"Twitter\">Twitter</a></li>
\t\t\t\t\t\t\t<li class=\"linkedin\"><a href=\"http://www.linkedin.com/\" target=\"_blank\" title=\"Linkedin\">Linkedin</a></li>
\t\t\t\t\t\t</ul>
\t\t\t\t\t</div>
\t\t\t\t\t<nav>
\t\t\t\t\t\t<ul class=\"nav nav-pills nav-main\" id=\"mainMenu\">
\t\t\t\t\t\t\t<li class=\"dropdown\">
\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" href=\"index.html\">
\t\t\t\t\t\t\t\t\tHome
\t\t\t\t\t\t\t\t\t<i class=\"icon-angle-down\"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">
\t\t\t\t\t\t\t\t\t<li><a href=\"index.html\">Revolution Slider</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"index-2.html\">Nivo Slider</a></li>
\t\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t<a href=\"about-us.html\">About Us</a>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t<li class=\"dropdown\">
\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" href=\"#\">
\t\t\t\t\t\t\t\t\tMon Cv
\t\t\t\t\t\t\t\t\t<i class=\"icon-angle-down\"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">
\t\t\t\t\t\t\t\t\t";
        // line 103
        $context['_parent'] = (array) $context;
        $context['_seq'] = twig_ensure_traversable($this->getContext($context, "membre"));
        foreach ($context['_seq'] as $context["_key"] => $context["m"]) {
            // line 104
            echo "                                                                    <li><a href=\"";
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_AfficherCvFreelancer", array("pseudo" => $this->getAttribute($context["m"], "pseudo", array()))), "html", null, true);
            echo "\"> </a></li>
\t\t\t\t\t\t\t\t";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['_key'], $context['m'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 105
        echo "\t
                                                                    <li><a href=\"feature-pricing-tables.html\">Pricing Tables</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"feature-icons.html\">Icons</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"feature-elements.html\">Elements</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"feature-typograpy.html\">Typograpy</a></li>
\t\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t<li class=\"dropdown\">
\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" href=\"#\">
\t\t\t\t\t\t\t\t\tPortfolio
\t\t\t\t\t\t\t\t\t<i class=\"icon-angle-down\"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">
\t\t\t\t\t\t\t\t\t<li><a href=\"portfolio-2-columns.html\">2 Columns</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"portfolio-3-columns.html\">3 Columns</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"portfolio-4-columns.html\">4 Columns</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"portfolio-single-project.html\">Single Project</a></li>
\t\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t<li class=\"dropdown active\">
\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" href=\"#\">
\t\t\t\t\t\t\t\t\tPages
\t\t\t\t\t\t\t\t\t<i class=\"icon-angle-down\"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">
\t\t\t\t\t\t\t\t\t<li><a href=\"page-full-width.html\">Full width</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"page-left-sidebar.html\">Left sidebar</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"page-right-sidebar.html\">Right sidebar</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"page-custom-header.html\">Custom Header</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"page-404.html\">404 Error</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"page-team.html\">Team</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"page-services.html\">Services</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"page-careers.html\">Careers</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"page-faq.html\">FAQ</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"sitemap.html\">Sitemap</a></li>
\t\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t<a href=\"contact-us.html\">Contact Us</a>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t</ul>
\t\t\t\t\t</nav>
\t\t\t\t</div>

  ";
    }

    public function getTemplateName()
    {
        return "FreelanceFrontOfficeBundle:FrontOffice:AffichageFreelancer.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  185 => 105,  176 => 104,  172 => 103,  117 => 51,  113 => 50,  106 => 47,  87 => 33,  83 => 32,  79 => 31,  75 => 30,  71 => 29,  67 => 28,  63 => 27,  37 => 5,  11 => 1,);
    }
}
