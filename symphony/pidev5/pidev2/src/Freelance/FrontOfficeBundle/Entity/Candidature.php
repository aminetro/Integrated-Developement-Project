<?php

namespace Freelance\FrontOfficeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Candidature
 *
 * @ORM\Table(name="candidature", indexes={@ORM\Index(name="pseufreelancer", columns={"pseufreelancer"}), @ORM\Index(name="id_p", columns={"id_p"})})
 * @ORM\Entity
 */
class Candidature
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="estimation", type="string", length=50, nullable=false)
     */
    private $estimation;

    /**
     * @var string
     *
     * @ORM\Column(name="lettre_mot", type="string", length=500, nullable=false)
     */
    private $lettreMot;

    /**
     * @var string
     *
     * @ORM\Column(name="question", type="string", length=500, nullable=false)
     */
    private $question;

    /**
     * @var \Membre
     * @ORM\Column(name="pseufreelancer", type="string", length=50, nullable=false)
     * @ORM\ManyToOne(targetEntity="Membre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="pseufreelancer", referencedColumnName="pseudo")
     * })
     */
    private $pseufreelancer;

    /**
     * @var \Projet
     * @ORM\Column(name="id_p", type="integer", nullable=false)
     * @ORM\ManyToOne(targetEntity="Projet")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_p", referencedColumnName="id")
     * })
     */
    private $idP;



    /**
     * Get id
     * 
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set estimation
     *
     * @param string $estimation
     * @return Candidature
     */
    public function setEstimation($estimation)
    {
        $this->estimation = $estimation;

        return $this;
    }

    /**
     * Get estimation
     *
     * @return string 
     */
    public function getEstimation()
    {
        return $this->estimation;
    }

    /**
     * Set lettreMot
     *
     * @param string $lettreMot
     * @return Candidature
     */
    public function setLettreMot($lettreMot)
    {
        $this->lettreMot = $lettreMot;

        return $this;
    }

    /**
     * Get lettreMot
     *
     * @return string 
     */
    public function getLettreMot()
    {
        return $this->lettreMot;
    }

    /**
     * Set question
     *
     * @param string $question
     * @return Candidature
     */
    public function setQuestion($question)
    {
        $this->question = $question;

        return $this;
    }

    /**
     * Get question
     *
     * @return string 
     */
    public function getQuestion()
    {
        return $this->question;
    }

    /**
     * Set pseufreelancer
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Membre $pseufreelancer
     * @return Candidature
     */
    public function setPseufreelancer($pseufreelancer)
    {
        $this->pseufreelancer = $pseufreelancer;

        return $this;
    }

    /**
     * Get pseufreelancer
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Membre 
     */
    public function getPseufreelancer()
    {
        return $this->pseufreelancer;
    }

    /**
     * Set idP
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Projet $idP
     * @return Candidature
     */
    public function setIdP($idP)
    {
        $this->idP = $idP;

        return $this;
    }

    /**
     * Get idP
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Projet 
     */
    public function getIdP()
    {
        return $this->idP;
    }
}
