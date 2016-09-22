<?php

namespace Freelance\FrontOfficeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Favoris
 *
 * @ORM\Table(name="favoris", indexes={@ORM\Index(name="id_f", columns={"id_f"}), @ORM\Index(name="id_p", columns={"id_p"})})
 * @ORM\Entity
 */
class Favoris
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
     * @var \Projet
     * @ORM\Column(name="id_p", type="integer", nullable=false)
     * @ORM\ManyToOne(targetEntity="Projet")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_p", referencedColumnName="id")
     * })
     */
    private $idP;

    /**
     * @var \Freelancer
     * @ORM\Column(name="id_f", type="integer", nullable=false)
     * @ORM\ManyToOne(targetEntity="Freelancer")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_f", referencedColumnName="id_f")
     * })
     */
    private $idF;



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
     * Set idP
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Projet $idP
     * @return Favoris
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

    /**
     * Set idF
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Freelancer $idF
     * @return Favoris
     */
    public function setIdF( $idF)
    {
        $this->idF = $idF;

        return $this;
    }

    /**
     * Get idF
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Freelancer 
     */
    public function getIdF()
    {
        return $this->idF;
    }
}
