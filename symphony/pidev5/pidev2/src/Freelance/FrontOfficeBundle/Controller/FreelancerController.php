<?php

namespace Freelance\FrontOfficeBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Freelance\FrontOfficeBundle\Entity\Membre AS Membre;
use Freelance\FrontOfficeBundle\Entity\Freelancer AS freelancer;
use Freelance\FrontOfficeBundle\Entity\Cvfreelancer AS Cvfreelancer;
//use Freelance\FrontOfficeBundle\Form\freelanceForm AS freelancerForm;
use Freelance\FrontOfficeBundle\Form\membreForm AS MembreForm;
use Freelance\FrontOfficeBundle\Form\MembreModifierForm AS MembreModifierForm;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\HttpFoundation\StreamedResponse;
use Freelance\FrontOfficeBundle\Form\ImageForm AS ImageForm;
use FOS\UserBundle\FOSUserEvents;
use FOS\UserBundle\Event\FormEvent;
use FOS\UserBundle\Event\GetResponseUserEvent;
use FOS\UserBundle\Event\FilterUserResponseEvent;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\RedirectResponse;
use Symfony\Component\HttpKernel\Exception\NotFoundHttpException;
use Symfony\Component\Security\Core\Exception\AccessDeniedException;
use FOS\UserBundle\Model\UserInterface;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of FreelancerController
 *
 * @author hp
 */
class FreelancerController extends Controller {

    public function AjouterPhotoFreelancerAction($pseudo) {
        $em = $this->getDoctrine()->getManager();
        $Membre = new Membre();
        $Membre = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);


        $Imageform = $this->createForm(new ImageForm(), $Membre);

        $request = $this->get('request');

        $Imageform->handleRequest($request);

        if ($Imageform->isValid()) {
            
            $stream = fopen($Membre->getUpload(), 'rb');
            
            $Membre->setPhoto(stream_get_contents($stream));
            $em->persist($Membre);
            $em->flush();
            return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AffichageFreelancer.html.twig', array('membre' => $Membre));
        }

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AjouterPhotoFreelancer.html.twig', array('Form' => $Imageform->createView()));
    }

    //put your code here
    public function AjouterFreelancerAction(Request $request) {
/** @var $formFactory \FOS\UserBundle\Form\Factory\FactoryInterface */
        $formFactory = $this->get('fos_user.registration.form.factory');
        /** @var $userManager \FOS\UserBundle\Model\UserManagerInterface */
        $userManager = $this->get('fos_user.user_manager');
        /** @var $dispatcher \Symfony\Component\EventDispatcher\EventDispatcherInterface */
        $dispatcher = $this->get('event_dispatcher');

        $user = $userManager->createUser();
        
        $user->setEnabled(true);
        
        $event = new GetResponseUserEvent($user, $request);
        $dispatcher->dispatch(FOSUserEvents::REGISTRATION_INITIALIZE, $event);

        if (null !== $event->getResponse()) {
            return $event->getResponse();
        }

        $form = $formFactory->createForm();
        $form->setData($user);

        $form->handleRequest($request);

        if ($form->isValid()) {
            $event = new FormEvent($form, $request);
            $dispatcher->dispatch(FOSUserEvents::REGISTRATION_SUCCESS, $event);
            $user->addRole("ROLE_FREELANCER");
            $userManager->updateUser($user);
            $freelancer = new freelancer();
        $em = $this->getDoctrine()->getManager();

                $freelancer->setIdF($user->getId());
                $freelancer->setDisponibiliteF("indisponible");
                $user->setPhoto("0xffd8ffe000104a46494600010100000100010000fffe003b43524541544f523a2067642d6a7065672076312e3020287573696e6720494a47204a50454720763632292c207175616c697479203d2039300affdb0043000302020302020303030304030304050805050404050a070706080c0a0c0c0b0a0b0b0d0e12100d0e110e0b0b1016101113141515150c0f171816141812141514ffdb00430103040405040509050509140d0b0d1414141414141414141414141414141414141414141414141414141414141414141414141414141414141414141414141414ffc000110800a400a403012200021101031101ffc4001f0000010501010101010100000000000000000102030405060708090a0bffc400b5100002010303020403050504040000017d01020300041105122131410613516107227114328191a1082342b1c11552d1f02433627282090a161718191a25262728292a3435363738393a434445464748494a535455565758595a636465666768696a737475767778797a838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae1e2e3e4e5e6e7e8e9eaf1f2f3f4f5f6f7f8f9faffc4001f0100030101010101010101010000000000000102030405060708090a0bffc400b51100020102040403040705040400010277000102031104052131061241510761711322328108144291a1b1c109233352f0156272d10a162434e125f11718191a262728292a35363738393a434445464748494a535455565758595a636465666768696a737475767778797a82838485868788898a92939495969798999aa2a3a4a5a6a7a8a9aab2b3b4b5b6b7b8b9bac2c3c4c5c6c7c8c9cad2d3d4d5d6d7d8d9dae2e3e4e5e6e7e8e9eaf2f3f4f5f6f7f8f9faffda000c03010002110311003f00fb968a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a2afe8fa2dceb775e4dbaf039773f7507bd0050ad1b5f0eea57aa1a1b39597b330da0fe26bd1746f0bd8e8caac91f9b38eb348327f0f4ad8a00f2a93c1dac4609364c47fb2ea4fe86b32e2d27b39364f0c90bfa3a906bda2a2b8b68aea268e68d658dbaab8c8a00f16a2bb3f11f81bc846b9d343328e5a027247bafafd2b8ca0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a0092de07ba9e38625dd23b0551ea4d7ade8ba4c5a2d8476f1805babbf766ee6b87f00590b8d65a66191046587fbc781fa66bd1e800a28a2800a28a2800af3df1de82b6570b7d02ed8a638900e8afebf8d7a15677882c86a1a35dc2464942cbfef0e47ea2803c8a8a28a0028a28a0028a28a0028a28a0028a28a0028a28a0028a28a00edbe1ae376a1eb88f1ff8f57715e71e00bd16dacb42c70278ca8ff78723f4cd7a3d00145145001451450014d7c6c6cf4c734eacef105e8d3f46bb989c108557fde3c0fd4d007915145140051451400514514005145140051451400514514005145140125bcf25acf1cd1b6d92360ca7d08af5bd17568b5ab08ee232037474eeaddc579056868dad5c68775e74072a7878cfdd61fe7bd007af5158fa3f89ec7590ab1c9e54e7ac32707f0f5ad8a0028a2a2b8b98ad62696691628d7ab39c0a0096bcf7c77af2dedc2d8c0dba284e6423a33fa7e1563c47e391346f6da692aa7869c8c1ff0080ff008d7174005145140051451400514514005145140051451400514514005145140051452852c401924f40280101c5695b788b53b350b15eca14740c7701f9e6ac58f83f54be0196dfc943fc531dbfa75fd2b5a1f87172c3f7b79121f4452dfe140191278c35891706f580ff0065147f215997579717afbee269266f57626baf6f86cc07cba803f5871ffb3552b9f87da8c20989e19c7a062a4fe631fad0072f455abdd32eb4d7db736ef09ec58707e87a1aab40051451400514514005145140051451400514514005145140051456ff00857c34dae5c1925cad9c67e623ab1fee8feb4010e83e18bad75f72fee6d81c34cc3f403b9af41d27c3b63a320f222065c7333f2c7f1edf8568430c76f12c71a08e351855518005494005145140051451400c9618ee2368e545911b82ac320d721af780a39434da6feee4ea6063f29fa1edfe7a5765450078a4d0496d2b452a18e44386561822995ea1e27f0cc7ae40648c2a5e20f95ffbdfec9af32962786568e4528ea76b29ea0d00328a28a0028a28a0028a28a0028a28a0028a28a00b1a758c9a95ec36d17df91b00fa7a9fc2bd774fb18b4db38ada15c24631f53dc9fad71ff0eb4e0cd717cc3a7ee90fbf53fd2bb9a0028a28a0028a28a0028a28a0028a28a002b88f1fe8602aea512e0f09301dfd1bfa7e55dbd41796a97d6b2dbc832922953f8d0078c5152dcc0d69732c2e30f1b146fa838a8a800a28a2800a28a2800a28a2800a28a2803d4fc1b6e2dbc3b6bc60b82e7f127fa62b6ea868202e89a781ff003ef19ffc7455fa0028a28a0028a28a0028a28a0028a28a0028a28a00f2ef1adb0b7f115c60604815c7e239fd41ac2aea3e22281ae447d6dd4ffe3cd5cbd00145145001451450014514500145145007b0e89c68d61ff5ef1ffe822aed53d1f8d22c7feb827fe822ae500145145001451450014514500145145001451450079dfc45ff0090d41ff5eebffa13572b5d57c45ff90d41ff005ee3ff00426ae56800a28a2800a28a2800a28a2800a28a2803d8b47ff904d97fd704ff00d0455ca28a0028a28a0028a28a0028a28a0028a28a0028a28a00f3bf88bff21a83febdd7ff00426ae568a2800a28a2800a28a2803fffd9");
                 $em->persist($freelancer);

            $em->flush();
            if (null === $response = $event->getResponse()) {
                $url = $this->generateUrl('freelance_front_office_AfficherFreelancer');
                $response = new RedirectResponse($url);
            }

            $dispatcher->dispatch(FOSUserEvents::REGISTRATION_COMPLETED, new FilterUserResponseEvent($user, $request, $response));

            return $response;
        }

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AjouterFreelancer.html.twig', array(
            'form' => $form->createView(),
        ));

}

    public function AfficherListFreelancerAction() {
        
       /* $connection = $this->get('database_connection');
 $user = $this->getUser();
          $dql = "SELECT * FROM membre where pseudo=?";
        $stmt = $connection->prepare($dql);
        $stmt->bindValue(1, $user);
        $stmt->execute();
       */
             /*   $em = $this->getDoctrine()->getManager();
$Membre = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);*/
 return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AffichageFreelancer.html.twig');
    }

    public function AfficherProfilFreelancerAction($pseudo) {

        $connection = $this->get('database_connection');

        // $result=$connection->fetchAll("SELECT * FROM membre ");
        $dql = "SELECT * FROM membre where pseudo=?";
        $stmt = $connection->prepare($dql);
        $stmt->bindValue(1, $pseudo);
        $stmt->execute();

        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:AffichageProfilFreelancer.html.twig', array('membre' => $stmt, 'profil' => $stmt));
    }

    public function ModifierFreelancerAction($pseudo) {
        $em = $this->getDoctrine()->getManager();
        $Membre = new Membre();
        $Photo = new Membre();
        $Membre = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);
        $ff = new MembreModifierForm();
        $form = $this->createForm($ff, $Membre);
        $request = $this->get('request');
             if ($request->getMethod() == "POST") {
            $form->bind($request);
            if ($form->isValid()) {

             $em->persist($Membre);

            $em->flush();

                return $this->redirect($this->generateUrl('freelance_front_office_AfficherFreelancer'));

                }
        }
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:ModifierFreelancer.html.twig', array('formMembre' => $form->createView(), 'm' => $Membre));
    }

    public function FreelancerRechercherFreelancerAction() {
        $connection = $this->get('database_connection');
        $dql = "SELECT id,nom, prenom, pays, ville, pseudo, email, disponibilite_f FROM membre m, freelancer f WHERE m.id = f.id_f";
        $stmt = $connection->prepare($dql);

        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
            $search = $Request->get('search');
            $dql = "SELECT id, nom, prenom, pays, ville, pseudo, email,disponibilite_f FROM freelancer f, membre m WHERE f.id_f = m.id AND m.pseudo like  ?";
            $stmt = $connection->prepare($dql);
            $stmt->bindValue(1, '%'.$search.'%');
            $stmt->execute();
        }
        $stmt->execute();
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:FreelancerRechercherFreelancer.html.twig', array('membre' => $stmt));
    }
    public function JobownerRechercherFreelancerAction() {
        $connection = $this->get('database_connection');
        $dql = "SELECT id,nom, prenom, pays, ville, pseudo, email, disponibilite_f FROM membre m, freelancer f WHERE m.id = f.id_f";
        $stmt = $connection->prepare($dql);

        $Request = $this->get('request');
        if ($Request->getMethod() == "POST") {
            $search = $Request->get('search');
            $dql = "SELECT id, nom, prenom, pays, ville, pseudo, email,disponibilite_f FROM freelancer f, membre m WHERE f.id_f = m.id AND m.pseudo like  ?";
            $stmt = $connection->prepare($dql);
            $stmt->bindValue(1, '%'.$search.'%');
            $stmt->execute();
        }
        $stmt->execute();
        return $this->render('FreelanceFrontOfficeBundle:FrontOffice:JobownerRechercherFreelancer.html.twig', array('membre' => $stmt));
    }

    public function AfficherPhotoFreelancerAction($pseudo) {
        $image_obj = new Membre();
        $em = $this->getDoctrine()->getManager();
        $image_obj = $em->getRepository('FreelanceFrontOfficeBundle:Membre')->findOneByPseudo($pseudo);

        $photo = $image_obj->getPhoto();
        if( $photo  !=null){
        $response = new StreamedResponse(function () use ($photo) {
            echo stream_get_contents($photo);
        });
        $response->headers->set('Content-Type', 'image/jpeg');
        return $response;
        }else{
            $response = new StreamedResponse(function ()  {

            echo file_get_contents('c:/profileDefault.jpg');
            });
        $response->headers->set('Content-Type', 'image/jpeg');
        return $response;
        }
    }
   
    
 public function CantactUsAction()
    {
       // return $this->render('FreelanceFrontOfficeBundle:Default:index.html.twig', array('name' => $name));
            return $this->render('FreelanceFrontOfficeBundle:FrontOffice:CantactUs.html.twig');

        
    }
}
