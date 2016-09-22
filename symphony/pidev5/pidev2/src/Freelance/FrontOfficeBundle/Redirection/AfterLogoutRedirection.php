<?php

namespace Freelance\FrontOfficeBundle\Redirection;
 
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\RouterInterface;
use Symfony\Component\Security\Core\SecurityContextInterface;
use Symfony\Component\Security\Http\Logout\LogoutSuccessHandlerInterface;
 
class AfterLogoutRedirection implements LogoutSuccessHandlerInterface
{
    /**
     * @var \Symfony\Component\Routing\RouterInterface
     */
    private $router;
 
    /**
     * @var \Symfony\Component\Security\Core\SecurityContextInterface
     */
    private $security;
 
    /**
     * @param SecurityContextInterface $security
     */
    public function __construct(RouterInterface $router, SecurityContextInterface $security)
    {
        $this->router = $router;
        $this->security = $security;
    }
 
    /**
     * @param Request $request
     * @return RedirectResponse
     */
    public function onLogoutSuccess(Request $request)
    {
        // On récupère la liste des rôles d'un utilisateur
        $roles = $this->security->getToken()->getRoles();
        // On transforme le tableau d'instance en tableau simple
        $rolesTab = array_map(function($role){ 
            return $role->getRole(); 
        }, $roles);
        
            $response = new RedirectResponse($this->router->generate('freelance_front_office_AcceuilFreelance'));
 
        return $response;
    }
}