<?php

namespace Freelance\BackOfficeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Messagerie
 *
 * @ORM\Table(name="messagerie", indexes={@ORM\Index(name="expediteur", columns={"expediteur"}), @ORM\Index(name="recepteur", columns={"recepteur"})})
 * @ORM\Entity
 */
class Messagerie
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
     * @var \DateTime
     *
     * @ORM\Column(name="date", type="date", nullable=false)
     */
    private $date;

    /**
     * @var string
     *
     * @ORM\Column(name="sujet", type="string", length=100, nullable=false)
     */
    private $sujet;

    /**
     * @var string
     *
     * @ORM\Column(name="message", type="string", length=600, nullable=false)
     */
    private $message;

    /**
     * @var \Membre
     *
     * @ORM\Column(name="expediteur", type="string")
     * @ORM\ManyToOne(targetEntity="Membre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="expediteur", referencedColumnName="pseudo")
     * })
     */
    private $expediteur;

    /**
     * @var \Membre
     *
     * @ORM\Column(name="recepteur", type="string")
     * @ORM\ManyToOne(targetEntity="Membre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="recepteur", referencedColumnName="pseudo")
     * })
     */
    private $recepteur;



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
     * Set date
     *
     * @param \DateTime $date
     * @return Messagerie
     */
    public function setDate($date)
    {
        $this->date = $date;

        return $this;
    }

    /**
     * Get date
     *
     * @return \DateTime 
     */
    public function getDate()
    {
        return $this->date;
    }

    /**
     * Set sujet
     *
     * @param string $sujet
     * @return Messagerie
     */
    public function setSujet($sujet)
    {
        $this->sujet = $sujet;

        return $this;
    }

    /**
     * Get sujet
     *
     * @return string 
     */
    public function getSujet()
    {
        return $this->sujet;
    }

    /**
     * Set message
     *
     * @param string $message
     * @return Messagerie
     */
    public function setMessage($message)
    {
        $this->message = $message;

        return $this;
    }

    /**
     * Get message
     *
     * @return string 
     */
    public function getMessage()
    {
        return $this->message;
    }

    /**
     * Set expediteur
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Membre $expediteur
     * @return Messagerie
     */
    public function setExpediteur($expediteur)
    {
        $this->expediteur = $expediteur;

        return $this;
    }

    /**
     * Get expediteur
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Membre 
     */
    public function getExpediteur()
    {
        return $this->expediteur;
    }

    /**
     * Set recepteur
     *
     * @param string $recepteur
     * @param \Freelance\FrontOfficeBundle\Entity\Membre $recepteur
     * @return Messagerie
     */
    public function setRecepteur($recepteur)
    {
        $this->recepteur = $recepteur;

        return $this;
    }

    /**
     * Get recepteur
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Membre 
     */
    public function getRecepteur()
    {
        return $this->recepteur;
    }
}
