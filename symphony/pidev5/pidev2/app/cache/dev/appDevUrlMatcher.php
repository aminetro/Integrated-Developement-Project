<?php

use Symfony\Component\Routing\Exception\MethodNotAllowedException;
use Symfony\Component\Routing\Exception\ResourceNotFoundException;
use Symfony\Component\Routing\RequestContext;

/**
 * appDevUrlMatcher
 *
 * This class has been auto-generated
 * by the Symfony Routing Component.
 */
class appDevUrlMatcher extends Symfony\Bundle\FrameworkBundle\Routing\RedirectableUrlMatcher
{
    /**
     * Constructor.
     */
    public function __construct(RequestContext $context)
    {
        $this->context = $context;
    }

    public function match($pathinfo)
    {
        $allow = array();
        $pathinfo = rawurldecode($pathinfo);
        $context = $this->context;
        $request = $this->request;

        if (0 === strpos($pathinfo, '/_')) {
            // _wdt
            if (0 === strpos($pathinfo, '/_wdt') && preg_match('#^/_wdt/(?P<token>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => '_wdt')), array (  '_controller' => 'web_profiler.controller.profiler:toolbarAction',));
            }

            if (0 === strpos($pathinfo, '/_profiler')) {
                // _profiler_home
                if (rtrim($pathinfo, '/') === '/_profiler') {
                    if (substr($pathinfo, -1) !== '/') {
                        return $this->redirect($pathinfo.'/', '_profiler_home');
                    }

                    return array (  '_controller' => 'web_profiler.controller.profiler:homeAction',  '_route' => '_profiler_home',);
                }

                if (0 === strpos($pathinfo, '/_profiler/search')) {
                    // _profiler_search
                    if ($pathinfo === '/_profiler/search') {
                        return array (  '_controller' => 'web_profiler.controller.profiler:searchAction',  '_route' => '_profiler_search',);
                    }

                    // _profiler_search_bar
                    if ($pathinfo === '/_profiler/search_bar') {
                        return array (  '_controller' => 'web_profiler.controller.profiler:searchBarAction',  '_route' => '_profiler_search_bar',);
                    }

                }

                // _profiler_purge
                if ($pathinfo === '/_profiler/purge') {
                    return array (  '_controller' => 'web_profiler.controller.profiler:purgeAction',  '_route' => '_profiler_purge',);
                }

                // _profiler_info
                if (0 === strpos($pathinfo, '/_profiler/info') && preg_match('#^/_profiler/info/(?P<about>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_profiler_info')), array (  '_controller' => 'web_profiler.controller.profiler:infoAction',));
                }

                // _profiler_phpinfo
                if ($pathinfo === '/_profiler/phpinfo') {
                    return array (  '_controller' => 'web_profiler.controller.profiler:phpinfoAction',  '_route' => '_profiler_phpinfo',);
                }

                // _profiler_search_results
                if (preg_match('#^/_profiler/(?P<token>[^/]++)/search/results$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_profiler_search_results')), array (  '_controller' => 'web_profiler.controller.profiler:searchResultsAction',));
                }

                // _profiler
                if (preg_match('#^/_profiler/(?P<token>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_profiler')), array (  '_controller' => 'web_profiler.controller.profiler:panelAction',));
                }

                // _profiler_router
                if (preg_match('#^/_profiler/(?P<token>[^/]++)/router$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_profiler_router')), array (  '_controller' => 'web_profiler.controller.router:panelAction',));
                }

                // _profiler_exception
                if (preg_match('#^/_profiler/(?P<token>[^/]++)/exception$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_profiler_exception')), array (  '_controller' => 'web_profiler.controller.exception:showAction',));
                }

                // _profiler_exception_css
                if (preg_match('#^/_profiler/(?P<token>[^/]++)/exception\\.css$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_profiler_exception_css')), array (  '_controller' => 'web_profiler.controller.exception:cssAction',));
                }

            }

            if (0 === strpos($pathinfo, '/_configurator')) {
                // _configurator_home
                if (rtrim($pathinfo, '/') === '/_configurator') {
                    if (substr($pathinfo, -1) !== '/') {
                        return $this->redirect($pathinfo.'/', '_configurator_home');
                    }

                    return array (  '_controller' => 'Sensio\\Bundle\\DistributionBundle\\Controller\\ConfiguratorController::checkAction',  '_route' => '_configurator_home',);
                }

                // _configurator_step
                if (0 === strpos($pathinfo, '/_configurator/step') && preg_match('#^/_configurator/step/(?P<index>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => '_configurator_step')), array (  '_controller' => 'Sensio\\Bundle\\DistributionBundle\\Controller\\ConfiguratorController::stepAction',));
                }

                // _configurator_final
                if ($pathinfo === '/_configurator/final') {
                    return array (  '_controller' => 'Sensio\\Bundle\\DistributionBundle\\Controller\\ConfiguratorController::finalAction',  '_route' => '_configurator_final',);
                }

            }

            // _twig_error_test
            if (0 === strpos($pathinfo, '/_error') && preg_match('#^/_error/(?P<code>\\d+)(?:\\.(?P<_format>[^/]++))?$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => '_twig_error_test')), array (  '_controller' => 'twig.controller.preview_error:previewErrorPageAction',  '_format' => 'html',));
            }

        }

        if (0 === strpos($pathinfo, '/Freelance')) {
            // freelance_swift_mail_homepage
            if (0 === strpos($pathinfo, '/Freelance/helloo') && preg_match('#^/Freelance/helloo/(?P<name>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_swift_mail_homepage')), array (  '_controller' => 'Freelance\\SwiftMailBundle\\Controller\\DefaultController::indexAction',));
            }

            // freelance_swift_mail_form
            if ($pathinfo === '/Freelance/mail') {
                return array (  '_controller' => 'Freelance\\SwiftMailBundle\\Controller\\DefaultController::newAction',  '_route' => 'freelance_swift_mail_form',);
            }

            // freelance_swift_mail_sendMail
            if ($pathinfo === '/Freelance/sendmail') {
                return array (  '_controller' => 'Freelance\\SwiftMailBundle\\Controller\\DefaultController::sendMailAction',  '_route' => 'freelance_swift_mail_sendMail',);
            }

            // freelance_front_CantactUs
            if ($pathinfo === '/Freelance/CantactUs') {
                return array (  '_controller' => 'Freelance\\SwiftMailBundle\\Controller\\DefaultController::CantactUsAction',  '_route' => 'freelance_front_CantactUs',);
            }

            // freelance_google_map_homepage
            if ($pathinfo === '/Freelance/map') {
                return array (  '_controller' => 'Freelance\\GoogleMapBundle\\Controller\\DefaultController::indexAction',  '_route' => 'freelance_google_map_homepage',);
            }

            // freelance_graphe_homepage
            if (0 === strpos($pathinfo, '/Freelance/hello') && preg_match('#^/Freelance/hello/(?P<name>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_graphe_homepage')), array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\DefaultController::indexAction',));
            }

            // freelance_graphe_grapheChartLinePays
            if ($pathinfo === '/Freelance/chartLinePays') {
                return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::chartLinePaysAction',  '_route' => 'freelance_graphe_grapheChartLinePays',);
            }

            // freelance_graphe_grapheHistogrammePays
            if ($pathinfo === '/Freelance/ChartHistogrammePays') {
                return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::ChartHistogrammePaysAction',  '_route' => 'freelance_graphe_grapheHistogrammePays',);
            }

            if (0 === strpos($pathinfo, '/Freelance/chart')) {
                // freelance_graphe_chartPiePays
                if ($pathinfo === '/Freelance/chartPiePays') {
                    return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::chartPiePaysAction',  '_route' => 'freelance_graphe_chartPiePays',);
                }

                // freelance_graphe_grapheChartLineProjet
                if ($pathinfo === '/Freelance/chartLineProjet') {
                    return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::chartLineProjetAction',  '_route' => 'freelance_graphe_grapheChartLineProjet',);
                }

            }

            // freelance_graphe_grapheHistogrammeProjet
            if ($pathinfo === '/Freelance/ChartHistogrammeProjet') {
                return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::ChartHistogrammeProjetAction',  '_route' => 'freelance_graphe_grapheHistogrammeProjet',);
            }

            // freelance_graphe_chartPieProjet
            if ($pathinfo === '/Freelance/chartPieProjet') {
                return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::chartPieProjetAction',  '_route' => 'freelance_graphe_chartPieProjet',);
            }

            if (0 === strpos($pathinfo, '/Freelance/StatistiqueP')) {
                // freelance_graphe_StatistiquePays
                if ($pathinfo === '/Freelance/StatistiquePays') {
                    return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::StatistiquePaysAction',  '_route' => 'freelance_graphe_StatistiquePays',);
                }

                // freelance_graphe_StatistiqueProjet
                if ($pathinfo === '/Freelance/StatistiqueProjet') {
                    return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::StatistiqueProjetAction',  '_route' => 'freelance_graphe_StatistiqueProjet',);
                }

            }

        }

        if (0 === strpos($pathinfo, '/log')) {
            if (0 === strpos($pathinfo, '/login')) {
                // fos_user_security_login
                if ($pathinfo === '/login') {
                    return array (  '_controller' => 'FOS\\UserBundle\\Controller\\SecurityController::loginAction',  '_route' => 'fos_user_security_login',);
                }

                // fos_user_security_check
                if ($pathinfo === '/login_check') {
                    if ($this->context->getMethod() != 'POST') {
                        $allow[] = 'POST';
                        goto not_fos_user_security_check;
                    }

                    return array (  '_controller' => 'FOS\\UserBundle\\Controller\\SecurityController::checkAction',  '_route' => 'fos_user_security_check',);
                }
                not_fos_user_security_check:

            }

            // fos_user_security_logout
            if ($pathinfo === '/logout') {
                return array (  '_controller' => 'FOS\\UserBundle\\Controller\\SecurityController::logoutAction',  '_route' => 'fos_user_security_logout',);
            }

        }

        if (0 === strpos($pathinfo, '/profile')) {
            // fos_user_profile_show
            if (rtrim($pathinfo, '/') === '/profile') {
                if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                    $allow = array_merge($allow, array('GET', 'HEAD'));
                    goto not_fos_user_profile_show;
                }

                if (substr($pathinfo, -1) !== '/') {
                    return $this->redirect($pathinfo.'/', 'fos_user_profile_show');
                }

                return array (  '_controller' => 'FOS\\UserBundle\\Controller\\ProfileController::showAction',  '_route' => 'fos_user_profile_show',);
            }
            not_fos_user_profile_show:

            // fos_user_profile_edit
            if ($pathinfo === '/profile/edit') {
                return array (  '_controller' => 'FOS\\UserBundle\\Controller\\ProfileController::editAction',  '_route' => 'fos_user_profile_edit',);
            }

        }

        if (0 === strpos($pathinfo, '/re')) {
            if (0 === strpos($pathinfo, '/register')) {
                // fos_user_registration_register
                if (rtrim($pathinfo, '/') === '/register') {
                    if (substr($pathinfo, -1) !== '/') {
                        return $this->redirect($pathinfo.'/', 'fos_user_registration_register');
                    }

                    return array (  '_controller' => 'FOS\\UserBundle\\Controller\\RegistrationController::registerAction',  '_route' => 'fos_user_registration_register',);
                }

                if (0 === strpos($pathinfo, '/register/c')) {
                    // fos_user_registration_check_email
                    if ($pathinfo === '/register/check-email') {
                        if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                            $allow = array_merge($allow, array('GET', 'HEAD'));
                            goto not_fos_user_registration_check_email;
                        }

                        return array (  '_controller' => 'FOS\\UserBundle\\Controller\\RegistrationController::checkEmailAction',  '_route' => 'fos_user_registration_check_email',);
                    }
                    not_fos_user_registration_check_email:

                    if (0 === strpos($pathinfo, '/register/confirm')) {
                        // fos_user_registration_confirm
                        if (preg_match('#^/register/confirm/(?P<token>[^/]++)$#s', $pathinfo, $matches)) {
                            if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                                $allow = array_merge($allow, array('GET', 'HEAD'));
                                goto not_fos_user_registration_confirm;
                            }

                            return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_user_registration_confirm')), array (  '_controller' => 'FOS\\UserBundle\\Controller\\RegistrationController::confirmAction',));
                        }
                        not_fos_user_registration_confirm:

                        // fos_user_registration_confirmed
                        if ($pathinfo === '/register/confirmed') {
                            if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                                $allow = array_merge($allow, array('GET', 'HEAD'));
                                goto not_fos_user_registration_confirmed;
                            }

                            return array (  '_controller' => 'FOS\\UserBundle\\Controller\\RegistrationController::confirmedAction',  '_route' => 'fos_user_registration_confirmed',);
                        }
                        not_fos_user_registration_confirmed:

                    }

                }

            }

            if (0 === strpos($pathinfo, '/resetting')) {
                // fos_user_resetting_request
                if ($pathinfo === '/resetting/request') {
                    if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                        $allow = array_merge($allow, array('GET', 'HEAD'));
                        goto not_fos_user_resetting_request;
                    }

                    return array (  '_controller' => 'FOS\\UserBundle\\Controller\\ResettingController::requestAction',  '_route' => 'fos_user_resetting_request',);
                }
                not_fos_user_resetting_request:

                // fos_user_resetting_send_email
                if ($pathinfo === '/resetting/send-email') {
                    if ($this->context->getMethod() != 'POST') {
                        $allow[] = 'POST';
                        goto not_fos_user_resetting_send_email;
                    }

                    return array (  '_controller' => 'FOS\\UserBundle\\Controller\\ResettingController::sendEmailAction',  '_route' => 'fos_user_resetting_send_email',);
                }
                not_fos_user_resetting_send_email:

                // fos_user_resetting_check_email
                if ($pathinfo === '/resetting/check-email') {
                    if (!in_array($this->context->getMethod(), array('GET', 'HEAD'))) {
                        $allow = array_merge($allow, array('GET', 'HEAD'));
                        goto not_fos_user_resetting_check_email;
                    }

                    return array (  '_controller' => 'FOS\\UserBundle\\Controller\\ResettingController::checkEmailAction',  '_route' => 'fos_user_resetting_check_email',);
                }
                not_fos_user_resetting_check_email:

                // fos_user_resetting_reset
                if (0 === strpos($pathinfo, '/resetting/reset') && preg_match('#^/resetting/reset/(?P<token>[^/]++)$#s', $pathinfo, $matches)) {
                    if (!in_array($this->context->getMethod(), array('GET', 'POST', 'HEAD'))) {
                        $allow = array_merge($allow, array('GET', 'POST', 'HEAD'));
                        goto not_fos_user_resetting_reset;
                    }

                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'fos_user_resetting_reset')), array (  '_controller' => 'FOS\\UserBundle\\Controller\\ResettingController::resetAction',));
                }
                not_fos_user_resetting_reset:

            }

        }

        // fos_user_change_password
        if ($pathinfo === '/profile/change-password') {
            if (!in_array($this->context->getMethod(), array('GET', 'POST', 'HEAD'))) {
                $allow = array_merge($allow, array('GET', 'POST', 'HEAD'));
                goto not_fos_user_change_password;
            }

            return array (  '_controller' => 'FOS\\UserBundle\\Controller\\ChangePasswordController::changePasswordAction',  '_route' => 'fos_user_change_password',);
        }
        not_fos_user_change_password:

        // freelance_front_office_AfficherFreelancer
        if ($pathinfo === '/Freelancer/AfficherFreelancer') {
            return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\FreelancerController::AfficherListFreelancerAction',  '_route' => 'freelance_front_office_AfficherFreelancer',);
        }

        // freelance_front_office_AfficherJobowner
        if ($pathinfo === '/Jobowner/AfficherJobowner') {
            return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\JobownerController::AfficherListJobownerAction',  '_route' => 'freelance_front_office_AfficherJobowner',);
        }

        if (0 === strpos($pathinfo, '/Freelance')) {
            // freelance_front_office_AjouterFreelancer
            if ($pathinfo === '/Freelance/AjouterFreelancer') {
                return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\FreelancerController::AjouterFreelancerAction',  '_route' => 'freelance_front_office_AjouterFreelancer',);
            }

            if (0 === strpos($pathinfo, '/Freelancer')) {
                // freelance_front_office_ModifierFreelancer
                if (0 === strpos($pathinfo, '/Freelancer/ModifierFreelancer') && preg_match('#^/Freelancer/ModifierFreelancer/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_ModifierFreelancer')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\FreelancerController::ModifierFreelancerAction',));
                }

                if (0 === strpos($pathinfo, '/Freelancer/A')) {
                    // freelance_front_office_AfficherProfilFreelancer
                    if (0 === strpos($pathinfo, '/Freelancer/AfficherProfilFreelancer') && preg_match('#^/Freelancer/AfficherProfilFreelancer/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AfficherProfilFreelancer')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\FreelancerController::AfficherProfilFreelancerAction',));
                    }

                    // freelance_front_office_AjouterCvFreelancer
                    if (0 === strpos($pathinfo, '/Freelancer/AjouterCvFreelancer') && preg_match('#^/Freelancer/AjouterCvFreelancer/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AjouterCvFreelancer')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\CvfreelancerController::AjouterCvFreelancerAction',));
                    }

                    // freelance_front_office_AfficherCvFreelancer
                    if (0 === strpos($pathinfo, '/Freelancer/AfficherCvFreelancer') && preg_match('#^/Freelancer/AfficherCvFreelancer/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AfficherCvFreelancer')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\CvfreelancerController::AfficherCvFreelancerAction',));
                    }

                }

                // freelance_front_office_ModifierCvFreelancer
                if (0 === strpos($pathinfo, '/Freelancer/ModifierCvFreelancer') && preg_match('#^/Freelancer/ModifierCvFreelancer/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_ModifierCvFreelancer')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\CvfreelancerController::ModifierCvFreelancerAction',));
                }

            }

        }

        // freelance_front_office_AjouterProjet
        if (0 === strpos($pathinfo, '/Jobowner/AjouterProjet') && preg_match('#^/Jobowner/AjouterProjet/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AjouterProjet')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\ProjetController::AjouterProjetAction',));
        }

        // freelance_front_office_AfficherFreelancerProjet
        if (0 === strpos($pathinfo, '/Freelancer/AfficherFreelancerProjet') && preg_match('#^/Freelancer/AfficherFreelancerProjet/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AfficherFreelancerProjet')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\ProjetController::AfficherFreelancerProjetAction',));
        }

        // freelance_front_office_AfficherJobownerProjet
        if (0 === strpos($pathinfo, '/Jobowner/AfficherJobownerProjet') && preg_match('#^/Jobowner/AfficherJobownerProjet/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AfficherJobownerProjet')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\ProjetController::AfficherJobownerProjetAction',));
        }

        // freelance_front_office_AfficherListFavoris
        if (0 === strpos($pathinfo, '/Freelancer/AfficherListFavoris') && preg_match('#^/Freelancer/AfficherListFavoris/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AfficherListFavoris')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\FavorisController::AfficherListFavorisAction',));
        }

        // freelance_front_office_ModifierProjet
        if (0 === strpos($pathinfo, '/Jobowner/ModifierProjet') && preg_match('#^/Jobowner/ModifierProjet/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_ModifierProjet')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\ProjetController::ModifierProjetAction',));
        }

        if (0 === strpos($pathinfo, '/Freelance')) {
            // freelance_front_office_AjouterJobowner
            if ($pathinfo === '/Freelance/AjouterJobowner') {
                return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\JobownerController::AjouterJobownerAction',  '_route' => 'freelance_front_office_AjouterJobowner',);
            }

            // freelance_front_office_AjouterCandidature
            if (0 === strpos($pathinfo, '/Freelancer/AjouterCandidature') && preg_match('#^/Freelancer/AjouterCandidature/(?P<pseudo>[^/]++)/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AjouterCandidature')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\CandidatureController::AjouterCandidatureAction',));
            }

        }

        // freelance_front_office_AfficherListCandidature
        if (0 === strpos($pathinfo, '/Jobowner/AfficherListCandidature') && preg_match('#^/Jobowner/AfficherListCandidature/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AfficherListCandidature')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\CandidatureController::AfficherListCandidatureAction',));
        }

        // freelance_front_office_AfficherMesCandidature
        if (0 === strpos($pathinfo, '/Freelancer/AfficherMesCandidature') && preg_match('#^/Freelancer/AfficherMesCandidature/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AfficherMesCandidature')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\CandidatureController::AfficherMesCandidatureAction',));
        }

        // freelance_front_office_AffecterCandidature
        if (0 === strpos($pathinfo, '/Jobowner/AffecterCandidature') && preg_match('#^/Jobowner/AffecterCandidature/(?P<pseudo>[^/]++)/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AffecterCandidature')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\CandidatureController::AffecterCandidatureAction',));
        }

        // freelance_front_office_ModifierCandidature
        if (0 === strpos($pathinfo, '/Freelancer/ModifierCandidature') && preg_match('#^/Freelancer/ModifierCandidature/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_ModifierCandidature')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\CandidatureController::ModifierCandidatureAction',));
        }

        // freelance_front_office_AfficherImage
        if (0 === strpos($pathinfo, '/images') && preg_match('#^/images/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AfficherImage')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\CandidatureController::AfficherImageAction',));
        }

        if (0 === strpos($pathinfo, '/Freelance')) {
            // freelance_front_office_AcceuilFreelance
            if ($pathinfo === '/Freelance/AcceuilFreelance') {
                return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\DefaultController::AcceuilFreelanceAction',  '_route' => 'freelance_front_office_AcceuilFreelance',);
            }

            if (0 === strpos($pathinfo, '/Freelance/FreelancerRechercher')) {
                // freelance_front_FreelancerRechercherJobowner
                if ($pathinfo === '/Freelance/FreelancerRechercherJobowner') {
                    return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\JobownerController::FreelancerRechercherJobownerAction',  '_route' => 'freelance_front_FreelancerRechercherJobowner',);
                }

                // freelance_front_FreelancerRechercherFreelancer
                if ($pathinfo === '/Freelance/FreelancerRechercherFreelancer') {
                    return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\FreelancerController::FreelancerRechercherFreelancerAction',  '_route' => 'freelance_front_FreelancerRechercherFreelancer',);
                }

            }

            if (0 === strpos($pathinfo, '/Freelance/JobownerRechercher')) {
                // freelance_front_JobownerRechercherFreelancer
                if ($pathinfo === '/Freelance/JobownerRechercherFreelancer') {
                    return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\FreelancerController::JobownerRechercherFreelancerAction',  '_route' => 'freelance_front_JobownerRechercherFreelancer',);
                }

                // freelance_front_JobownerRechercherJobowner
                if ($pathinfo === '/Freelance/JobownerRechercherJobowner') {
                    return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\JobownerController::JobownerRechercherJobownerAction',  '_route' => 'freelance_front_JobownerRechercherJobowner',);
                }

            }

        }

        // freelance_front_RechercherProjetJobowner
        if (rtrim($pathinfo, '/') === '/Jobowner/RechercherProjetJobowner') {
            if (substr($pathinfo, -1) !== '/') {
                return $this->redirect($pathinfo.'/', 'freelance_front_RechercherProjetJobowner');
            }

            return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\ProjetController::RechercherProjetJobownerAction',  '_route' => 'freelance_front_RechercherProjetJobowner',);
        }

        if (0 === strpos($pathinfo, '/Freelancer')) {
            // freelance_front_RechercherProjetFreelancer
            if (rtrim($pathinfo, '/') === '/Freelancer/RechercherProjetFreelancer') {
                if (substr($pathinfo, -1) !== '/') {
                    return $this->redirect($pathinfo.'/', 'freelance_front_RechercherProjetFreelancer');
                }

                return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\ProjetController::RechercherProjetFreelancerAction',  '_route' => 'freelance_front_RechercherProjetFreelancer',);
            }

            // freelance_front_office_AjouterPhotoFreelancer
            if (0 === strpos($pathinfo, '/Freelancer/AjouterPhotoFreelancer') && preg_match('#^/Freelancer/AjouterPhotoFreelancer/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AjouterPhotoFreelancer')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\FreelancerController::AjouterPhotoFreelancerAction',));
            }

        }

        // freelance_front_office_AjouterPhotoJobowner
        if (0 === strpos($pathinfo, '/Jobowner/AjouterPhotoJobowner') && preg_match('#^/Jobowner/AjouterPhotoJobowner/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AjouterPhotoJobowner')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\JobownerController::AjouterPhotoJobownerAction',));
        }

        if (0 === strpos($pathinfo, '/Freelance')) {
            if (0 === strpos($pathinfo, '/Freelancer')) {
                // freelance_front_AjouterFavoris
                if (0 === strpos($pathinfo, '/Freelancer/AjouterFavoris') && preg_match('#^/Freelancer/AjouterFavoris/(?P<pseudo>[^/]++)/(?P<idp>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_AjouterFavoris')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\FavorisController::AjouterFavorisAction',));
                }

                // freelance_front_SupprimerFavoris
                if (0 === strpos($pathinfo, '/Freelancer/SupprimerFavoris') && preg_match('#^/Freelancer/SupprimerFavoris/(?P<idf>[^/]++)/(?P<idp>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_SupprimerFavoris')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\FavorisController::SupprimerFavorisAction',));
                }

            }

            if (0 === strpos($pathinfo, '/Freelance/AfficherPhoto')) {
                // freelance_front_office_AfficherPhotoFreelancer
                if (0 === strpos($pathinfo, '/Freelance/AfficherPhotoFreelancer') && preg_match('#^/Freelance/AfficherPhotoFreelancer/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AfficherPhotoFreelancer')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\FreelancerController::AfficherPhotoFreelancerAction',));
                }

                // freelance_front_office_AfficherPhotoJobowner
                if (0 === strpos($pathinfo, '/Freelance/AfficherPhotoJobowner') && preg_match('#^/Freelance/AfficherPhotoJobowner/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AfficherPhotoJobowner')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\JobownerController::AfficherPhotoJobownerAction',));
                }

            }

        }

        // freelance_front_office_JobownerModifier
        if (0 === strpos($pathinfo, '/Jobowner/JobownerModifier') && preg_match('#^/Jobowner/JobownerModifier/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_JobownerModifier')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\JobownerController::JobownerModifierAction',));
        }

        if (0 === strpos($pathinfo, '/Freelancer/FreelancerMessagerie')) {
            if (0 === strpos($pathinfo, '/Freelancer/FreelancerMessagerieA')) {
                // freelance_front_FreelancerMessagerieAjouter
                if (0 === strpos($pathinfo, '/Freelancer/FreelancerMessagerieAjouter') && preg_match('#^/Freelancer/FreelancerMessagerieAjouter/(?P<pseudo>[^/]++)/(?P<pseudo1>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_FreelancerMessagerieAjouter')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\MessagerieController::FreelancerMessagerieAjouterAction',));
                }

                // freelance_front_FreelancerMessagerieAfficher
                if (0 === strpos($pathinfo, '/Freelancer/FreelancerMessagerieAfficher') && preg_match('#^/Freelancer/FreelancerMessagerieAfficher/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_FreelancerMessagerieAfficher')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\MessagerieController::FreelancerMessagerieAfficherAction',));
                }

            }

            // freelance_front_FreelancerMessagerieSupprimer
            if (0 === strpos($pathinfo, '/Freelancer/FreelancerMessagerieSupprimer') && preg_match('#^/Freelancer/FreelancerMessagerieSupprimer/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_FreelancerMessagerieSupprimer')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\MessagerieController::FreelancerMessagerieSupprimerAction',));
            }

            // freelance_front_FreelancerMessagerieRechercher
            if (0 === strpos($pathinfo, '/Freelancer/FreelancerMessagerieRechercher') && preg_match('#^/Freelancer/FreelancerMessagerieRechercher/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_FreelancerMessagerieRechercher')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\MessagerieController::FreelancerMessagerieRechercherAction',));
            }

        }

        if (0 === strpos($pathinfo, '/Jobowner/JobownerMessagerie')) {
            if (0 === strpos($pathinfo, '/Jobowner/JobownerMessagerieA')) {
                // freelance_front_JobownerMessagerieAjouter
                if (0 === strpos($pathinfo, '/Jobowner/JobownerMessagerieAjouter') && preg_match('#^/Jobowner/JobownerMessagerieAjouter/(?P<pseudo>[^/]++)/(?P<pseudo1>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_JobownerMessagerieAjouter')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\MessagerieController::JobownerMessagerieAjouterAction',));
                }

                // freelance_front_JobownerMessagerieAfficher
                if (0 === strpos($pathinfo, '/Jobowner/JobownerMessagerieAfficher') && preg_match('#^/Jobowner/JobownerMessagerieAfficher/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_JobownerMessagerieAfficher')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\MessagerieController::JobownerMessagerieAfficherAction',));
                }

            }

            // freelance_front_JobownerMessagerieSupprimer
            if (0 === strpos($pathinfo, '/Jobowner/JobownerMessagerieSupprimer') && preg_match('#^/Jobowner/JobownerMessagerieSupprimer/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_JobownerMessagerieSupprimer')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\MessagerieController::JobownerMessagerieSupprimerAction',));
            }

            // freelance_front_JobownerMessagerieRechercher
            if (0 === strpos($pathinfo, '/Jobowner/JobownerMessagerieRechercher') && preg_match('#^/Jobowner/JobownerMessagerieRechercher/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_JobownerMessagerieRechercher')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\MessagerieController::JobownerMessagerieRechercherAction',));
            }

        }

        // freelance_front_ReclamationAjouter
        if (0 === strpos($pathinfo, '/Freelance/ReclamationAjouter') && preg_match('#^/Freelance/ReclamationAjouter/(?P<pseudo>[^/]++)/(?P<type>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_ReclamationAjouter')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\ReclamationController::ReclamationAjouterAction',));
        }

        // freelance_front_AfficherCvFreelancerJobowner
        if (0 === strpos($pathinfo, '/Jobowner/AfficherCvFreelancerJobowner') && preg_match('#^/Jobowner/AfficherCvFreelancerJobowner/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_AfficherCvFreelancerJobowner')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\CvfreelancerController::AfficherCvFreelancerJobownerAction',));
        }

        if (0 === strpos($pathinfo, '/Freelancer')) {
            if (0 === strpos($pathinfo, '/Freelancer/A')) {
                // freelance_front_office_AjouterTest
                if (rtrim($pathinfo, '/') === '/Freelancer/AjouterTest') {
                    if (substr($pathinfo, -1) !== '/') {
                        return $this->redirect($pathinfo.'/', 'freelance_front_office_AjouterTest');
                    }

                    return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\TestController::AjouterTestAction',  '_route' => 'freelance_front_office_AjouterTest',);
                }

                if (0 === strpos($pathinfo, '/Freelancer/Afficher')) {
                    // freelance_front_office_AfficherTest
                    if (0 === strpos($pathinfo, '/Freelancer/AfficherTest') && preg_match('#^/Freelancer/AfficherTest/(?P<nom>[^/]++)$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AfficherTest')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\TestController::AfficherTestAction',));
                    }

                    // freelance_front_office_AffichertoutTest
                    if (rtrim($pathinfo, '/') === '/Freelancer/AffichertoutTest') {
                        if (substr($pathinfo, -1) !== '/') {
                            return $this->redirect($pathinfo.'/', 'freelance_front_office_AffichertoutTest');
                        }

                        return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\TestController::AffichertoutTestAction',  '_route' => 'freelance_front_office_AffichertoutTest',);
                    }

                }

            }

            // freelance_front_office_ModifierTest
            if (0 === strpos($pathinfo, '/Freelancer/ModifierTest') && preg_match('#^/Freelancer/ModifierTest/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_ModifierTest')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\TestController::ModifierTestAction',));
            }

            // freelance_front_office_SuprimerTest
            if (0 === strpos($pathinfo, '/Freelancer/SuprimerTest') && preg_match('#^/Freelancer/SuprimerTest/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_SuprimerTest')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\TestController::SuprimerTestAction',));
            }

            // freelance_front_office_PassageTest
            if (0 === strpos($pathinfo, '/Freelancer/PassageTest') && preg_match('#^/Freelancer/PassageTest/(?P<id>[^/]++)/(?P<idf>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_PassageTest')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\TestController::PassageTestAction',));
            }

            // freelance_front_office_AfficherNotetest
            if (0 === strpos($pathinfo, '/Freelancer/AfficherNotetest') && preg_match('#^/Freelancer/AfficherNotetest/(?P<idf>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_AfficherNotetest')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\NotetestController::AfficherNotetestAction',));
            }

            if (0 === strpos($pathinfo, '/Freelancer/SuprimerC')) {
                // freelance_front_office_SuprimerCandidature
                if (0 === strpos($pathinfo, '/Freelancer/SuprimerCandidature') && preg_match('#^/Freelancer/SuprimerCandidature/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_SuprimerCandidature')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\CandidatureController::SuprimerCandidatureAction',));
                }

                // freelance_front_office_SuprimerCvfreelancer
                if (0 === strpos($pathinfo, '/Freelancer/SuprimerCvfreelancer') && preg_match('#^/Freelancer/SuprimerCvfreelancer/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                    return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_SuprimerCvfreelancer')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\CvfreelancerController::SuprimerCvfreelancerAction',));
                }

            }

        }

        // freelance_front_office_SuprimerProjet
        if (0 === strpos($pathinfo, '/Jobowner/SuprimerProjet') && preg_match('#^/Jobowner/SuprimerProjet/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
            return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_SuprimerProjet')), array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\ProjetController::SuprimerProjetAction',));
        }

        // freelance_front_office_AccessDenied
        if ($pathinfo === '/403') {
            return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\DefaultController::AccessDeniedAction',  '_route' => 'freelance_front_office_AccessDenied',);
        }

        // freelance_front_office_AboutUs
        if ($pathinfo === '/Freelance/AboutUs') {
            return array (  '_controller' => 'Freelance\\FrontOfficeBundle\\Controller\\DefaultController::AboutUsAction',  '_route' => 'freelance_front_office_AboutUs',);
        }

        if (0 === strpos($pathinfo, '/Admin')) {
            // freelance_front_office_homepage
            if (0 === strpos($pathinfo, '/Admin/hello') && preg_match('#^/Admin/hello/(?P<name>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_front_office_homepage')), array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\DefaultController::indexAction',));
            }

            // freelance_Back_ModifierProfil
            if (0 === strpos($pathinfo, '/Admin/ModifierProfil') && preg_match('#^/Admin/ModifierProfil/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_Back_ModifierProfil')), array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::ModifierProfilAction',));
            }

            if (0 === strpos($pathinfo, '/Admin/index')) {
                // freelance_Back_indexSuperAdmin
                if ($pathinfo === '/Admin/indexSuper') {
                    return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\SuperAdminController::indexAction',  '_route' => 'freelance_Back_indexSuperAdmin',);
                }

                // freelance_Back_indexAdmin
                if ($pathinfo === '/Admin/indexAdmin') {
                    return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::indexAction',  '_route' => 'freelance_Back_indexAdmin',);
                }

            }

            if (0 === strpos($pathinfo, '/Admin/Table')) {
                // freelance_Back_TableAdmin
                if ($pathinfo === '/Admin/Table') {
                    return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::TableAction',  '_route' => 'freelance_Back_TableAdmin',);
                }

                // freelance_Back_RecAdmin
                if ($pathinfo === '/Admin/TableRec') {
                    return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::TableRecAction',  '_route' => 'freelance_Back_RecAdmin',);
                }

            }

            if (0 === strpos($pathinfo, '/Admin/StatP')) {
                // freelance_Back_StatAdmin
                if ($pathinfo === '/Admin/StatPays') {
                    return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::StatPaysAction',  '_route' => 'freelance_Back_StatAdmin',);
                }

                // freelance_Back_StatProjetAdmin
                if ($pathinfo === '/Admin/StatProjet') {
                    return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::StatProjetAction',  '_route' => 'freelance_Back_StatProjetAdmin',);
                }

            }

            // freelance_Back_GestionMessage
            if ($pathinfo === '/Admin/GestionMessage') {
                return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::GestionMessageAction',  '_route' => 'freelance_Back_GestionMessage',);
            }

            // freelance_Back_EnvoyerMessage
            if ($pathinfo === '/Admin/EnvoyerMessage') {
                return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\MessagerieController::ajoutAction',  '_route' => 'freelance_Back_EnvoyerMessage',);
            }

            // freelance_Back_AfficherMessage
            if (0 === strpos($pathinfo, '/Admin/AfficherMessage') && preg_match('#^/Admin/AfficherMessage/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_Back_AfficherMessage')), array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\MessagerieController::AfficherMessagerieAction',));
            }

            // freelance_Back_RechercherMessage
            if (0 === strpos($pathinfo, '/Admin/RechercherMessage') && preg_match('#^/Admin/RechercherMessage/(?P<pseudo>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_Back_RechercherMessage')), array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\MessagerieController::rechercherAction',));
            }

            if (0 === strpos($pathinfo, '/Admin/a')) {
                // freelance_Back_ajouterAdmin
                if ($pathinfo === '/Admin/ajouterAdmin') {
                    return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\SuperAdminController::ajoutAdminAction',  '_route' => 'freelance_Back_ajouterAdmin',);
                }

                // freelance_Back_AfficherAdmin
                if ($pathinfo === '/Admin/afficherAdmin') {
                    return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\SuperAdminController::AfficherAction',  '_route' => 'freelance_Back_AfficherAdmin',);
                }

            }

            // freelance_Back_modifierAdmin
            if (0 === strpos($pathinfo, '/Admin/modifierAdmin') && preg_match('#^/Admin/modifierAdmin/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_Back_modifierAdmin')), array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\SuperAdminController::modifierAction',));
            }

            // freelance_Back_deleteAdmin
            if (0 === strpos($pathinfo, '/Admin/deleteAdmin') && preg_match('#^/Admin/deleteAdmin/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_Back_deleteAdmin')), array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\SuperAdminController::deleteAction',));
            }

            // freelance_Back_chercherAdmin
            if ($pathinfo === '/Admin/chercherAdmin') {
                return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\SuperAdminController::RechercherAction',  '_route' => 'freelance_Back_chercherAdmin',);
            }

            // freelance_Back_afficherJobowner
            if ($pathinfo === '/Admin/afficherJobowner') {
                return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::AfficherJobownerAction',  '_route' => 'freelance_Back_afficherJobowner',);
            }

            // freelance_Back_deleteJobowner
            if (0 === strpos($pathinfo, '/Admin/deleteJobowner') && preg_match('#^/Admin/deleteJobowner/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_Back_deleteJobowner')), array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::supprimerJobownerAction',));
            }

            // freelance_Back_chercherJobowner
            if ($pathinfo === '/Admin/chercherJobowner') {
                return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::rechercherJobownerAction',  '_route' => 'freelance_Back_chercherJobowner',);
            }

            // freelance_Back_afficherfreelancer
            if ($pathinfo === '/Admin/afficherfreelancer') {
                return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::AfficherFreelancerAction',  '_route' => 'freelance_Back_afficherfreelancer',);
            }

            // freelance_Back_deletefreelancer
            if (0 === strpos($pathinfo, '/Admin/deletefreelancer') && preg_match('#^/Admin/deletefreelancer/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_Back_deletefreelancer')), array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::supprimerfreelancerAction',));
            }

            // freelance_Back_chercherfreelancer
            if ($pathinfo === '/Admin/chercherfreelancer') {
                return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::rechercherFreelancerAction',  '_route' => 'freelance_Back_chercherfreelancer',);
            }

            // freelance_Back_afficherReclamation
            if ($pathinfo === '/Admin/afficherReclamation') {
                return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::AfficherReclamationAction',  '_route' => 'freelance_Back_afficherReclamation',);
            }

            // freelance_Back_deleteReclamation
            if (0 === strpos($pathinfo, '/Admin/deleteReclamation') && preg_match('#^/Admin/deleteReclamation/(?P<id>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => 'freelance_Back_deleteReclamation')), array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::supprimerReclamationAction',));
            }

            // freelance_Back_RepondreRecAdmin
            if ($pathinfo === '/Admin/RepondreRec') {
                return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\AdministrateurController::RepondreRecAction',  '_route' => 'freelance_Back_RepondreRecAdmin',);
            }

            // freelance_Back_HistogrammePays
            if ($pathinfo === '/Admin/HistogrammePays') {
                return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::ChartHistogrammePaysAction',  '_route' => 'freelance_Back_HistogrammePays',);
            }

            // freelance_Back_chart
            if ($pathinfo === '/Admin/chart') {
                return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::chartLinePaysAction',  '_route' => 'freelance_Back_chart',);
            }

            // freelance_Back_Pie
            if ($pathinfo === '/Admin/Pie') {
                return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::chartPiePaysAction',  '_route' => 'freelance_Back_Pie',);
            }

            if (0 === strpos($pathinfo, '/Admin/chart')) {
                // freelance_Back_chartlineProjet
                if ($pathinfo === '/Admin/chartlineProjet') {
                    return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::chartLineProjetAction',  '_route' => 'freelance_Back_chartlineProjet',);
                }

                // freelance_Back_chartProjet
                if ($pathinfo === '/Admin/chartProjet') {
                    return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::ChartHistogrammeProjetAction',  '_route' => 'freelance_Back_chartProjet',);
                }

            }

            // freelance_Back_PieProjet
            if ($pathinfo === '/Admin/PieProjet') {
                return array (  '_controller' => 'Freelance\\GrapheBundle\\Controller\\GrapheController::chartPieProjetAction',  '_route' => 'freelance_Back_PieProjet',);
            }

            // freelance_Back_ViewAdmin
            if ($pathinfo === '/Admin/ViewAdmin') {
                return array (  '_controller' => 'Freelance\\BackOfficeBundle\\Controller\\SuperAdminController::ViewAction',  '_route' => 'freelance_Back_ViewAdmin',);
            }

        }

        // homepage
        if (rtrim($pathinfo, '/') === '') {
            if (substr($pathinfo, -1) !== '/') {
                return $this->redirect($pathinfo.'/', 'homepage');
            }

            return array (  '_controller' => 'AppBundle\\Controller\\DefaultController::indexAction',  '_route' => 'homepage',);
        }

        // _welcome
        if (rtrim($pathinfo, '/') === '') {
            if (substr($pathinfo, -1) !== '/') {
                return $this->redirect($pathinfo.'/', '_welcome');
            }

            return array (  '_controller' => 'Acme\\DemoBundle\\Controller\\WelcomeController::indexAction',  '_route' => '_welcome',);
        }

        if (0 === strpos($pathinfo, '/demo')) {
            if (0 === strpos($pathinfo, '/demo/secured')) {
                if (0 === strpos($pathinfo, '/demo/secured/log')) {
                    if (0 === strpos($pathinfo, '/demo/secured/login')) {
                        // _demo_login
                        if ($pathinfo === '/demo/secured/login') {
                            return array (  '_controller' => 'Acme\\DemoBundle\\Controller\\SecuredController::loginAction',  '_route' => '_demo_login',);
                        }

                        // _demo_security_check
                        if ($pathinfo === '/demo/secured/login_check') {
                            return array (  '_controller' => 'Acme\\DemoBundle\\Controller\\SecuredController::securityCheckAction',  '_route' => '_demo_security_check',);
                        }

                    }

                    // _demo_logout
                    if ($pathinfo === '/demo/secured/logout') {
                        return array (  '_controller' => 'Acme\\DemoBundle\\Controller\\SecuredController::logoutAction',  '_route' => '_demo_logout',);
                    }

                }

                if (0 === strpos($pathinfo, '/demo/secured/hello')) {
                    // acme_demo_secured_hello
                    if ($pathinfo === '/demo/secured/hello') {
                        return array (  'name' => 'World',  '_controller' => 'Acme\\DemoBundle\\Controller\\SecuredController::helloAction',  '_route' => 'acme_demo_secured_hello',);
                    }

                    // _demo_secured_hello
                    if (preg_match('#^/demo/secured/hello/(?P<name>[^/]++)$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => '_demo_secured_hello')), array (  '_controller' => 'Acme\\DemoBundle\\Controller\\SecuredController::helloAction',));
                    }

                    // _demo_secured_hello_admin
                    if (0 === strpos($pathinfo, '/demo/secured/hello/admin') && preg_match('#^/demo/secured/hello/admin/(?P<name>[^/]++)$#s', $pathinfo, $matches)) {
                        return $this->mergeDefaults(array_replace($matches, array('_route' => '_demo_secured_hello_admin')), array (  '_controller' => 'Acme\\DemoBundle\\Controller\\SecuredController::helloadminAction',));
                    }

                }

            }

            // _demo
            if (rtrim($pathinfo, '/') === '/demo') {
                if (substr($pathinfo, -1) !== '/') {
                    return $this->redirect($pathinfo.'/', '_demo');
                }

                return array (  '_controller' => 'Acme\\DemoBundle\\Controller\\DemoController::indexAction',  '_route' => '_demo',);
            }

            // _demo_hello
            if (0 === strpos($pathinfo, '/demo/hello') && preg_match('#^/demo/hello/(?P<name>[^/]++)$#s', $pathinfo, $matches)) {
                return $this->mergeDefaults(array_replace($matches, array('_route' => '_demo_hello')), array (  '_controller' => 'Acme\\DemoBundle\\Controller\\DemoController::helloAction',));
            }

            // _demo_contact
            if ($pathinfo === '/demo/contact') {
                return array (  '_controller' => 'Acme\\DemoBundle\\Controller\\DemoController::contactAction',  '_route' => '_demo_contact',);
            }

        }

        throw 0 < count($allow) ? new MethodNotAllowedException(array_unique($allow)) : new ResourceNotFoundException();
    }
}
