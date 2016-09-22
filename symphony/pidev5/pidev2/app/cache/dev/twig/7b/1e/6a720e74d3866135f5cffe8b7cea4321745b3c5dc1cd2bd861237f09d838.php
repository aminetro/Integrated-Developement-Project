<?php

/* FreelanceFrontOfficeBundle::layout.html.twig */
class __TwigTemplate_7b1e6a720e74d3866135f5cffe8b7cea4321745b3c5dc1cd2bd861237f09d838 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        $this->parent = false;

        $this->blocks = array(
            'fos_user_content' => array($this, 'block_fos_user_content'),
            'content' => array($this, 'block_content'),
            'StatPays' => array($this, 'block_StatPays'),
        );
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        // line 1
        echo "<!DOCTYPE html>
<!--[if IE 8]>\t\t\t<html class=\"ie ie8\"> <![endif]-->
<!--[if IE 9]>\t\t\t<html class=\"ie ie9\"> <![endif]-->
<!--[if gt IE 9]><!-->\t<html> <!--<![endif]-->
\t<head>

\t\t<!-- Basic -->
\t\t<meta charset=\"utf-8\">
\t\t<title>Elusive - Freelance</title>
\t\t<meta name=\"keywords\" content=\"HTML5 Template\" />
\t\t<meta name=\"description\" content=\"Porto - Responsive HTML5 Template\">
\t\t<meta name=\"author\" content=\"Crivos.com\">

\t\t<!-- Mobile Metas -->
\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">

\t\t<!-- Web Fonts  -->
\t\t<link href=\"http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800|Shadows+Into+Light\" rel=\"stylesheet\" type=\"text/css\">

\t\t<!-- Libs CSS -->
\t\t<link rel=\"stylesheet\" href=\"";
        // line 21
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("css/bootstrap.css"), "html", null, true);
        echo "\">
\t\t<link rel=\"stylesheet\" href=\"";
        // line 22
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("css/fonts/font-awesome/css/font-awesome.css"), "html", null, true);
        echo "\">
\t\t<link rel=\"stylesheet\" href=\"";
        // line 23
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("vendor/flexslider/flexslider.css"), "html", null, true);
        echo "\" media=\"screen\" />
\t\t<link rel=\"stylesheet\" href=\"";
        // line 24
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("vendor/fancybox/jquery.fancybox.css"), "html", null, true);
        echo "\" media=\"screen\" />

\t\t<!-- Theme CSS -->
\t\t<link rel=\"stylesheet\" href=\"";
        // line 27
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("css/theme.css"), "html", null, true);
        echo "\">
\t\t<link rel=\"stylesheet\" href=\"";
        // line 28
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("css/theme-elements.css"), "html", null, true);
        echo "\">

\t\t<!-- Custom CSS -->
\t\t<link rel=\"stylesheet\" href=\"";
        // line 31
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("css/custom.css"), "html", null, true);
        echo "\">

\t\t<!-- Skin -->
\t\t<link rel=\"stylesheet\" href=\"";
        // line 34
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("css/skins/blue.css"), "html", null, true);
        echo "\">

\t\t<!-- Responsive CSS -->
\t\t<link rel=\"stylesheet\" href=\"";
        // line 37
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("css/bootstrap-responsive.css"), "html", null, true);
        echo "\" />
\t\t<link rel=\"stylesheet\" href=\"";
        // line 38
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("css/theme-responsive.css"), "html", null, true);
        echo "\" />

\t\t<!-- Favicons -->
\t\t<link rel=\"shortcut icon\" href=\"";
        // line 41
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("img/favicon.ico"), "html", null, true);
        echo "\">
\t\t<link rel=\"apple-touch-icon\" href=\"";
        // line 42
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("img/apple-touch-icon.png"), "html", null, true);
        echo "\">
\t\t<link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"";
        // line 43
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("img/apple-touch-icon-72x72.png"), "html", null, true);
        echo "\">
\t\t<link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"";
        // line 44
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("img/apple-touch-icon-114x114.png"), "html", null, true);
        echo "\">
\t\t<link rel=\"apple-touch-icon\" sizes=\"144x144\" href=\"";
        // line 45
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("img/apple-touch-icon-144x144.png"), "html", null, true);
        echo "\">

\t\t<!-- Head Libs -->
\t\t<script src=\"";
        // line 48
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("vendor/modernizr.js"), "html", null, true);
        echo "\"></script>

\t\t<!--[if IE]>
\t\t\t<link rel=\"stylesheet\" href=\"css/ie.css\">
\t\t<![endif]-->

\t\t<!--[if lte IE 8]>
\t\t\t<script src=\"vendor/respond.js\"></script>
\t\t<![endif]-->

\t\t<!-- Facebook OpenGraph Tags - Go to http://developers.facebook.com/ for more information.
\t\t<meta property=\"og:title\" content=\"Porto Website Template.\"/>
\t\t<meta property=\"og:type\" content=\"website\"/>
\t\t<meta property=\"og:url\" content=\"http://www.crivos.com/themes/porto\"/>
\t\t<meta property=\"og:image\" content=\"http://www.crivos.com/themes/porto/\"/>
\t\t<meta property=\"og:site_name\" content=\"Porto\"/>
\t\t<meta property=\"fb:app_id\" content=\"\"/>
\t\t<meta property=\"og:description\" content=\"Porto - Responsive HTML5 Template\"/>
\t\t-->

\t</head>
\t<body>

\t\t
\t\t\t<header>
                            <div class=\"body\">
                                ";
        // line 75
        echo "                     <div>
            ";
        // line 76
        if ($this->env->getExtension('security')->isGranted("IS_AUTHENTICATED_REMEMBERED")) {
            // line 77
            echo "               ";
            echo twig_escape_filter($this->env, $this->env->getExtension('translator')->trans("vous êtes connecté en tant que ", array(), "FOSUserBundle"), "html", null, true);
            echo ": ";
            echo twig_escape_filter($this->env, $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()), "html", null, true);
            echo "
                <a href=\"";
            // line 78
            echo $this->env->getExtension('routing')->getPath("fos_user_security_logout");
            echo "\" class=\"btn btn-large disabled\">
                    ";
            // line 79
            echo twig_escape_filter($this->env, $this->env->getExtension('translator')->trans("Se Deconnecter", array(), "FOSUserBundle"), "html", null, true);
            echo "
                </a>
            ";
        } else {
            // line 82
            echo "                <a href=\"";
            echo $this->env->getExtension('routing')->getPath("fos_user_security_login");
            echo "\" class=\"btn btn-large disabled\">";
            echo twig_escape_filter($this->env, $this->env->getExtension('translator')->trans("Se Connecter", array(), "FOSUserBundle"), "html", null, true);
            echo "</a>
            ";
        }
        // line 84
        echo "        </div>

        ";
        // line 86
        $context['_parent'] = (array) $context;
        $context['_seq'] = twig_ensure_traversable($this->getAttribute($this->getAttribute($this->getAttribute($this->getContext($context, "app"), "session", array()), "flashbag", array()), "all", array(), "method"));
        foreach ($context['_seq'] as $context["type"] => $context["messages"]) {
            // line 87
            echo "            ";
            $context['_parent'] = (array) $context;
            $context['_seq'] = twig_ensure_traversable($context["messages"]);
            foreach ($context['_seq'] as $context["_key"] => $context["message"]) {
                // line 88
                echo "                <div class=\"flash-";
                echo twig_escape_filter($this->env, $context["type"], "html", null, true);
                echo "\">
                    ";
                // line 89
                echo twig_escape_filter($this->env, $context["message"], "html", null, true);
                echo "
                </div>
            ";
            }
            $_parent = $context['_parent'];
            unset($context['_seq'], $context['_iterated'], $context['_key'], $context['message'], $context['_parent'], $context['loop']);
            $context = array_intersect_key($context, $_parent) + $_parent;
            // line 92
            echo "        ";
        }
        $_parent = $context['_parent'];
        unset($context['_seq'], $context['_iterated'], $context['type'], $context['messages'], $context['_parent'], $context['loop']);
        $context = array_intersect_key($context, $_parent) + $_parent;
        // line 93
        echo "
        <div>
            ";
        // line 95
        $this->displayBlock('fos_user_content', $context, $blocks);
        // line 97
        echo "        </div>
\t\t";
        // line 98
        if ($this->env->getExtension('security')->isGranted("ROLE_FREELANCER")) {
            // line 99
            echo "                <div class=\"container\">
\t\t\t\t\t<h1 class=\"logo\">
\t\t\t\t\t\t<a href=\"";
            // line 101
            echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("index.html"), "html", null, true);
            echo "\">
\t\t\t\t\t\t\t<img alt=\"Porto\" src=\"";
            // line 102
            echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("img/logo.png"), "html", null, true);
            echo "\">
\t\t\t\t\t\t</a>
\t\t\t\t\t</h1>
\t\t\t\t\t
\t\t\t\t\t
\t\t\t\t\t<div class=\"social-icons\">
\t\t\t\t\t\t<ul class=\"social-icons\">
\t\t\t\t\t\t\t<li class=\"facebook\"><a href=\"http://www.facebook.com/\" target=\"_blank\" title=\"Facebook\">Facebook</a></li>
\t\t\t\t\t\t\t<li class=\"twitter\"><a href=\"http://www.twitter.com/\" target=\"_blank\" title=\"Twitter\">Twitter</a></li>
\t\t\t\t\t\t\t<li class=\"linkedin\"><a href=\"http://www.linkedin.com/\" target=\"_blank\" title=\"Linkedin\">Linkedin</a></li>
\t\t\t\t\t\t</ul>
\t\t\t\t\t</div>
\t\t\t\t\t<nav>
\t\t\t\t\t\t<ul class=\"nav nav-pills nav-main\" id=\"mainMenu\">
                                                                     <li>
                                <a href=\"";
            // line 117
            echo $this->env->getExtension('routing')->getPath("freelance_front_office_AcceuilFreelance");
            echo "\">Home</a>
                            </li>
\t\t\t\t\t\t\t<li class=\"dropdown\">
\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" href=\"index.html\">
\t\t\t\t\t\t\t\t\tProjet
\t\t\t\t\t\t\t\t\t<i class=\"icon-angle-down\"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">
                                                                    
\t\t\t\t\t\t\t\t\t<li><a href=\"";
            // line 126
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_AfficherListFavoris", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()))), "html", null, true);
            echo "\">Liste Des Favoris</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"";
            // line 127
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_RechercherProjetFreelancer", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()))), "html", null, true);
            echo "\"><td>Liste Des Projets</a></li>
                                                                        <li><a href=\"";
            // line 128
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_AfficherMesCandidature", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()))), "html", null, true);
            echo "\">Mes Candidatures</a></li>
                                                                        <li><a href=\"";
            // line 129
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_AfficherFreelancerProjet", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()))), "html", null, true);
            echo "\">Mes Projets</a></li>
                                                                </ul>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t
                                                        <li class=\"dropdown\">
\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" href=\"index.html\">
\t\t\t\t\t\t\t\t\tMon Cv
\t\t\t\t\t\t\t\t\t<i class=\"icon-angle-down\"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">
                                                                    
\t\t\t\t\t\t\t\t\t<li><a href=\"";
            // line 140
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_AfficherCvFreelancer", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()))), "html", null, true);
            echo "\">afficher CV</a></li>
\t\t\t\t\t\t\t\t\t<li><td><a href=\"";
            // line 141
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_AjouterCvFreelancer", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()))), "html", null, true);
            echo "\">Ajouter CV</a></td></li>
                                                                        <li><a href=\"";
            // line 142
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_ModifierCvFreelancer", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()))), "html", null, true);
            echo "\">Modifier CV</a></li>
                                                                        
                                                                </ul>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t<li class=\"dropdown\">
\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" href=\"#\">
\t\t\t\t\t\t\t\t\tStatistique
\t\t\t\t\t\t\t\t\t<i class=\"icon-angle-down\"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">
\t\t\t\t\t\t\t\t\t
\t\t\t\t\t\t\t\t\t<li><a href=\"";
            // line 153
            echo $this->env->getExtension('routing')->getPath("freelance_graphe_StatistiquePays");
            echo "\">Statistique par pays </a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"";
            // line 154
            echo $this->env->getExtension('routing')->getPath("freelance_graphe_StatistiqueProjet");
            echo "\">Statistique par projet </a></li>
\t\t\t\t\t\t\t\t\t
\t\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t</li>
                                                        <li class=\"dropdown\">
\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" href=\"#\">
\t\t\t\t\t\t\t\t\tProfil
\t\t\t\t\t\t\t\t\t<i class=\"icon-angle-down\"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">
                                                                       <li><a href=\"";
            // line 164
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_ModifierFreelancer", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()))), "html", null, true);
            echo "\">Modifier Profil</a></li>
                                                                     <li><a href=\"";
            // line 165
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_AjouterPhotoFreelancer", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()))), "html", null, true);
            echo "\">Ajouter Photo</a></li>
                                                                        
\t\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t<li class=\"dropdown\">
\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" href=\"#\">
\t\t\t\t\t\t\t\t\tRechercher Membre
\t\t\t\t\t\t\t\t\t<i class=\"icon-angle-down\"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">
                                                                        <li><a href=\"";
            // line 175
            echo $this->env->getExtension('routing')->getPath("freelance_front_FreelancerRechercherJobowner");
            echo "\">Rechercher Jobowner </a></li>
\t\t\t\t\t\t\t\t       <li><a href=\"";
            // line 176
            echo $this->env->getExtension('routing')->getPath("freelance_front_FreelancerRechercherFreelancer");
            echo "\">Rechercher Freelancer</a></li>
\t\t\t\t\t\t\t\t
\t\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t
                                                         
                                                         <li>
\t\t\t\t\t\t\t\t<a href=\"";
            // line 183
            echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl($this->env->getExtension('routing')->getPath("freelance_front_FreelancerMessagerieRechercher", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "pseudo", array())))), "html", null, true);
            echo "\">Mes Messages</a>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t<a href=\"";
            // line 186
            echo $this->env->getExtension('routing')->getPath("freelance_front_CantactUs");
            echo "\">Contact Us</a>
\t\t\t\t\t\t\t</li>
                                                        <li>
\t\t\t\t\t\t\t\t<a href=\"";
            // line 189
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_ReclamationAjouter", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()), "type" => "free")), "html", null, true);
            echo "\">Envoyer Reclamation</a>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t</ul>   
\t\t\t\t\t</nav>
\t\t\t\t</div>
                ";
        } elseif ($this->env->getExtension('security')->isGranted("ROLE_JOBOWNER")) {
            // line 195
            echo "                <div class=\"container\">
\t\t\t\t\t<h1 class=\"logo\">
\t\t\t\t\t\t<a href=\"";
            // line 197
            echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("index.html"), "html", null, true);
            echo "\">
\t\t\t\t\t\t\t<img alt=\"Porto\" src=\"";
            // line 198
            echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("img/logo.png"), "html", null, true);
            echo "\">
\t\t\t\t\t\t</a>
\t\t\t\t\t</h1>
\t\t\t\t\t
\t\t\t\t\t
\t\t\t\t\t<div class=\"social-icons\">
\t\t\t\t\t\t<ul class=\"social-icons\">
\t\t\t\t\t\t\t<li class=\"facebook\"><a href=\"http://www.facebook.com/\" target=\"_blank\" title=\"Facebook\">Facebook</a></li>
\t\t\t\t\t\t\t<li class=\"twitter\"><a href=\"http://www.twitter.com/\" target=\"_blank\" title=\"Twitter\">Twitter</a></li>
\t\t\t\t\t\t\t<li class=\"linkedin\"><a href=\"http://www.linkedin.com/\" target=\"_blank\" title=\"Linkedin\">Linkedin</a></li>
\t\t\t\t\t\t</ul>
\t\t\t\t\t</div>
\t\t\t\t\t<nav>
\t\t\t\t\t\t<ul class=\"nav nav-pills nav-main\" id=\"mainMenu\">
                                                                <li>
                                <a href=\"";
            // line 213
            echo $this->env->getExtension('routing')->getPath("freelance_front_office_AcceuilFreelance");
            echo "\">Home</a>
                            </li>
\t\t\t\t\t\t\t<li class=\"dropdown\">
\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" href=\"index.html\">
\t\t\t\t\t\t\t\t\tProjet
\t\t\t\t\t\t\t\t\t<i class=\"icon-angle-down\"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">
                                                                    
\t\t\t\t\t\t\t\t\t<li><a href=\"";
            // line 222
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_AjouterProjet", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()))), "html", null, true);
            echo "\">Ajouter Projet</a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"";
            // line 223
            echo $this->env->getExtension('routing')->getPath("freelance_front_RechercherProjetJobowner");
            echo "\"><td>Liste Des Projets</a></li>
                                                                        <li><a href=\"";
            // line 224
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_AfficherJobownerProjet", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()))), "html", null, true);
            echo "\">Mes Projet</a></li>
                                                                         </ul>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t <li><a href=\"";
            // line 227
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_AfficherListCandidature", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()))), "html", null, true);
            echo "\">Candidatures</a></li>
                                                         
                                                      
\t\t\t\t\t\t\t<li class=\"dropdown\">
\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" href=\"#\">
\t\t\t\t\t\t\t\t\tStatistique
\t\t\t\t\t\t\t\t\t<i class=\"icon-angle-down\"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">
\t\t\t\t\t\t\t\t\t
\t\t\t\t\t\t\t\t\t<li><a href=\"";
            // line 237
            echo $this->env->getExtension('routing')->getPath("freelance_graphe_StatistiquePays");
            echo "\">Statistique par pays </a></li>
\t\t\t\t\t\t\t\t\t<li><a href=\"";
            // line 238
            echo $this->env->getExtension('routing')->getPath("freelance_graphe_StatistiqueProjet");
            echo "\">Statistique par projet </a></li>
\t\t\t\t\t\t\t\t\t
\t\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t<li class=\"dropdown\">
\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" href=\"#\">
\t\t\t\t\t\t\t\t\tRechercher Membre
\t\t\t\t\t\t\t\t\t<i class=\"icon-angle-down\"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">
                                                                      <li><a href=\"";
            // line 248
            echo $this->env->getExtension('routing')->getPath("freelance_front_JobownerRechercherJobowner");
            echo "\">Rechercher Jobowner </a></li>
\t\t\t\t\t\t\t\t       <li><a href=\"";
            // line 249
            echo $this->env->getExtension('routing')->getPath("freelance_front_JobownerRechercherFreelancer");
            echo "\">Rechercher Freelancer</a></li>
\t\t\t\t\t\t\t\t
\t\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t</li>
                                                        
                                                        <li class=\"dropdown\">
\t\t\t\t\t\t\t\t<a class=\"dropdown-toggle\" href=\"#\">
\t\t\t\t\t\t\t\t\tProfil
\t\t\t\t\t\t\t\t\t<i class=\"icon-angle-down\"></i>
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">
                                                                       <li><a href=\"";
            // line 260
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_JobownerModifier", array("id" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "id", array()))), "html", null, true);
            echo "\">Modifier Profil</a></li>
                                                                     <li><a href=\"";
            // line 261
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_office_AjouterPhotoJobowner", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()))), "html", null, true);
            echo "\">Ajouter Photo</a></li>
                                                                        
\t\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t <li>
\t\t\t\t\t\t\t\t<a href=\"";
            // line 266
            echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl($this->env->getExtension('routing')->getPath("freelance_front_JobownerMessagerieRechercher", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "pseudo", array())))), "html", null, true);
            echo "\">Mes Messages</a>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t\t<li>
\t\t\t\t\t\t\t\t<a href=\"";
            // line 269
            echo $this->env->getExtension('routing')->getPath("freelance_front_CantactUs");
            echo "\">Contact Us</a>
\t\t\t\t\t\t\t</li>
                                                        <li>
\t\t\t\t\t\t\t\t<a href=\"";
            // line 272
            echo twig_escape_filter($this->env, $this->env->getExtension('routing')->getPath("freelance_front_ReclamationAjouter", array("pseudo" => $this->getAttribute($this->getAttribute($this->getContext($context, "app"), "user", array()), "username", array()), "type" => "job")), "html", null, true);
            echo "\">Envoyer Reclamation</a>
\t\t\t\t\t\t\t</li>
\t\t\t\t\t\t</ul>
\t\t\t\t\t</nav>
\t\t\t\t</div>               
                ";
        } else {
            // line 278
            echo "                <div class=\"container\">
                    <h1 class=\"logo\">
                        <a href=\"index.html\">
                            <img alt=\"Porto\" src=\"";
            // line 281
            echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("img/logo.png"), "html", null, true);
            echo "\">
                        </a>
                    </h1>
                    
                    <nav>
              
                    </nav>
                    <div class=\"social-icons\">
                        <ul class=\"social-icons\">
                            <li class=\"facebook\"><a href=\" https://www.facebook.com/pages/Freelance/1579791178965084?ref=hl\" target=\"_blank\" title=\"Facebook\">Facebook</a></li>
                            <li class=\"twitter\"><a href=\"https://twitter.com/free_elusive \" target=\"_blank\" title=\"Twitter\">Twitter</a></li>
                            <li class=\"linkedin\"><a href=\"https://www.linkedin.com/profile/view?id=410900259&trk=nav_responsive_tab_profile_pic\" target=\"_blank\" title=\"Linkedin\">Linkedin</a></li>
                        </ul>
                    </div>
                    <nav>
                        <ul class=\"nav nav-pills nav-main\" id=\"mainMenu\">
                            <li>
                                <a href=\"";
            // line 298
            echo $this->env->getExtension('routing')->getPath("freelance_front_office_AcceuilFreelance");
            echo "\">Home</a>
                            </li>
                            <li>
                                <a href=\"";
            // line 301
            echo $this->env->getExtension('routing')->getPath("freelance_front_office_AboutUs");
            echo "\">About Us</a>
                            </li>
                            
                            <li>
                                <a href=\"";
            // line 305
            echo $this->env->getExtension('routing')->getPath("freelance_front_CantactUs");
            echo "\">Contact Us</a>
                            </li>
                        </ul>
                    </nav>
                </div>
                ";
        }
        // line 311
        echo "\t\t\t</header>
\t\t\t
                                                    ";
        // line 313
        $this->displayBlock('content', $context, $blocks);
        // line 315
        echo "            \t
";
        // line 316
        $this->displayBlock('StatPays', $context, $blocks);
        // line 317
        echo "\t\t\t\t\t

\t\t\t

                         <footer>
\t\t\t\t<div class=\"container\">
\t\t\t\t\t<div class=\"row\">
\t\t\t\t\t\t<div class=\"footer-ribon\">
\t\t\t\t\t\t\t<span>Get in Touch</span>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"span3\">
\t\t\t\t\t\t\t<h4>Newsletter</h4>
\t\t\t\t\t\t\t<p>Keep up on our always evolving product features and technology. Enter your e-mail and subscribe to our newsletter.</p>

\t\t\t\t\t\t\t<div class=\"alert alert-success hidden\" id=\"newsletterSuccess\">
\t\t\t\t\t\t\t\t<strong>Success!</strong> You've been added to our email list.
\t\t\t\t\t\t\t</div>

\t\t\t\t\t\t\t<div class=\"alert alert-error hidden\" id=\"newsletterError\"></div>

\t\t\t\t\t\t\t<form class=\"form-inline\" id=\"newsletterForm\" action=\"php/newsletter-subscribe.php\" method=\"POST\">
\t\t\t\t\t\t\t\t<div class=\"control-group\">
\t\t\t\t\t\t\t\t\t<div class=\"input-append\">
\t\t\t\t\t\t\t\t\t\t<input class=\"span2\" placeholder=\"Email Address\" name=\"email\" id=\"email\" type=\"text\">
\t\t\t\t\t\t\t\t\t\t<button class=\"btn\" type=\"submit\">Go!</button>
\t\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t</form>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"span3\">
\t\t\t\t\t\t\t<h4>Latest Tweet</h4>
\t\t\t\t\t\t\t<div id=\"tweet\" class=\"twitter\">
\t\t\t\t\t\t\t\t<p>Please wait...</p>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"span4\">
\t\t\t\t\t\t\t<div class=\"contact-details\">
\t\t\t\t\t\t\t\t<h4>Get in touch</h4>
\t\t\t\t\t\t\t\t<ul class=\"contact\">
\t\t\t\t\t\t\t\t\t<li><p><i class=\"icon-map-marker\"></i> <strong>Address:</strong> 1234 Street Name, City Name, United States</p></li>
\t\t\t\t\t\t\t\t\t<li><p><i class=\"icon-phone\"></i> <strong>Phone:</strong> (123) 456-7890</p></li>
\t\t\t\t\t\t\t\t\t<li><p><i class=\"icon-envelope\"></i> <strong>Email:</strong> <a href=\"";
        // line 358
        echo $this->env->getExtension('routing')->getPath("freelance_front_CantactUs");
        echo "\">elusive.di.elusive@gmail.com</a></p></li>
\t\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t\t<div class=\"span2\">
\t\t\t\t\t\t\t<h4>Follow Us</h4>
\t\t\t\t\t\t\t<div class=\"social-icons\">
\t\t\t\t\t\t\t\t<ul class=\"social-icons\">
                            <li class=\"facebook\"><a href=\" https://www.facebook.com/pages/Freelance/1579791178965084?ref=hl\" target=\"_blank\" title=\"Facebook\">Facebook</a></li>
                            <li class=\"twitter\"><a href=\"https://twitter.com/free_elusive \" target=\"_blank\" title=\"Twitter\">Twitter</a></li>
                            <li class=\"linkedin\"><a href=\"https://www.linkedin.com/profile/view?id=410900259&trk=nav_responsive_tab_profile_pic\" target=\"_blank\" title=\"Linkedin\">Linkedin</a></li>
                        </ul>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t\t<div class=\"footer-copyright\">
\t\t\t\t\t<div class=\"container\">
\t\t\t\t\t\t<div class=\"row\">
\t\t\t\t\t\t\t<div class=\"span1\">
\t\t\t\t\t\t\t\t<a href=\"index.html\" class=\"logo\">
\t\t\t\t\t\t\t\t\t<img alt=\"Porto Website Template\" src=\"";
        // line 379
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("img/logo-footer.png"), "html", null, true);
        echo "\">
\t\t\t\t\t\t\t\t</a>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<div class=\"span7\">
\t\t\t\t\t\t\t\t<p>© Copyright 2013 by Crivos. All Rights Reserved.</p>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t\t<div class=\"span4\">
\t\t\t\t\t\t\t\t<nav id=\"sub-menu\">
\t\t\t\t\t\t\t\t\t<ul>
\t\t\t\t\t\t\t\t\t\t<li><a href=\"page-faq.html\">FAQ's</a></li>
\t\t\t\t\t\t\t\t\t\t<li><a href=\"sitemap.html\">Sitemap</a></li>
\t\t\t\t\t\t\t\t\t\t<li><a href=\"";
        // line 390
        echo $this->env->getExtension('routing')->getPath("freelance_front_CantactUs");
        echo "\">Contact</a></li>
\t\t\t\t\t\t\t\t\t</ul>
\t\t\t\t\t\t\t\t</nav>
\t\t\t\t\t\t\t</div>
\t\t\t\t\t\t</div>
\t\t\t\t\t</div>
\t\t\t\t</div>
\t\t\t</footer>
\t\t</div>

\t\t<!-- Libs -->
\t\t<script type=\"text/javascript\" src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js\"></script>
\t\t<script>window.jQuery || document.write('<script src=\"";
        // line 402
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("vendor/jquery.js"), "html", null, true);
        echo "\"><\\/script>')</script>
\t\t<script src=\"";
        // line 403
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("vendor/jquery.easing.js"), "html", null, true);
        echo "\"></script>
\t\t<script src=\"";
        // line 404
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("vendor/jquery.cookie.js"), "html", null, true);
        echo "\"></script>
\t\t<!-- <script src=\"master/style-switcher/style.switcher.js\"></script> -->
\t\t<script src=\"";
        // line 406
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("vendor/bootstrap.js"), "html", null, true);
        echo "\"></script>
\t\t<script src=\"";
        // line 407
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("vendor/selectnav.js"), "html", null, true);
        echo "\"></script>
\t\t<script src=\"";
        // line 408
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("vendor/twitterjs/twitter.js"), "html", null, true);
        echo "\"></script>
\t\t<script src=\"";
        // line 409
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("vendor/flexslider/jquery.flexslider.js"), "html", null, true);
        echo "\"></script>
\t\t<script src=\"";
        // line 410
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("vendor/jflickrfeed/jflickrfeed.js"), "html", null, true);
        echo "\"></script>
\t\t<script src=\"";
        // line 411
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("vendor/fancybox/jquery.fancybox.js"), "html", null, true);
        echo "\"></script>
\t\t<script src=\"";
        // line 412
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("vendor/jquery.validate.js"), "html", null, true);
        echo "\"></script>

\t\t<script src=\"";
        // line 414
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("js/plugins.js"), "html", null, true);
        echo "\"></script>

\t\t<!-- Page Scripts -->

\t\t<!-- Theme Initializer -->
\t\t<script src=\"";
        // line 419
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("js/theme.js"), "html", null, true);
        echo "\"></script>

\t\t<!-- Custom JS -->
\t\t<script src=\"";
        // line 422
        echo twig_escape_filter($this->env, $this->env->getExtension('assets')->getAssetUrl("js/custom.js"), "html", null, true);
        echo "\"></script>

\t\t<!-- Google Analytics: Change UA-XXXXX-X to be your site's ID. Go to http://www.google.com/analytics/ for more information. -->
\t\t<!--
\t\t<script>
\t\t\tvar _gaq = _gaq || [];
\t\t\t_gaq.push(['_setAccount', 'UA-XXXXX-X']);
\t\t\t_gaq.push(['_trackPageview']);

\t\t\t(function() {
\t\t\t\tvar ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
\t\t\t\tga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
\t\t\t\tvar s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
\t\t\t})();
\t\t</script>
\t\t-->
\t</body>
</html>
";
    }

    // line 95
    public function block_fos_user_content($context, array $blocks = array())
    {
        // line 96
        echo "            ";
    }

    // line 313
    public function block_content($context, array $blocks = array())
    {
        echo "\t
                                                    ";
    }

    // line 316
    public function block_StatPays($context, array $blocks = array())
    {
    }

    public function getTemplateName()
    {
        return "FreelanceFrontOfficeBundle::layout.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  754 => 316,  747 => 313,  743 => 96,  740 => 95,  717 => 422,  711 => 419,  703 => 414,  698 => 412,  694 => 411,  690 => 410,  686 => 409,  682 => 408,  678 => 407,  674 => 406,  669 => 404,  665 => 403,  661 => 402,  646 => 390,  632 => 379,  608 => 358,  565 => 317,  563 => 316,  560 => 315,  558 => 313,  554 => 311,  545 => 305,  538 => 301,  532 => 298,  512 => 281,  507 => 278,  498 => 272,  492 => 269,  486 => 266,  478 => 261,  474 => 260,  460 => 249,  456 => 248,  443 => 238,  439 => 237,  426 => 227,  420 => 224,  416 => 223,  412 => 222,  400 => 213,  382 => 198,  378 => 197,  374 => 195,  365 => 189,  359 => 186,  353 => 183,  343 => 176,  339 => 175,  326 => 165,  322 => 164,  309 => 154,  305 => 153,  291 => 142,  287 => 141,  283 => 140,  269 => 129,  265 => 128,  261 => 127,  257 => 126,  245 => 117,  227 => 102,  223 => 101,  219 => 99,  217 => 98,  214 => 97,  212 => 95,  208 => 93,  202 => 92,  193 => 89,  188 => 88,  183 => 87,  179 => 86,  175 => 84,  167 => 82,  161 => 79,  157 => 78,  150 => 77,  148 => 76,  145 => 75,  116 => 48,  110 => 45,  106 => 44,  102 => 43,  98 => 42,  94 => 41,  88 => 38,  84 => 37,  78 => 34,  72 => 31,  66 => 28,  62 => 27,  56 => 24,  52 => 23,  48 => 22,  44 => 21,  22 => 1,);
    }
}
