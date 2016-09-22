<?php

namespace Freelance\FrontOfficeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Jobowner
 *
 * @ORM\Table(name="jobowner")
 * @ORM\Entity
 */
class Jobowner
{
    /**
     * @var string
     *
     * @ORM\Column(name="societe_j", type="string", length=100, nullable=false)
     */
    private $societeJ = '';

    /**
     * @var \Membre
     *
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     * @ORM\Column(name="id_j", type="integer")
     * @ORM\OneToOne(targetEntity="Membre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_j", referencedColumnName="id")
     * })
     */
    private $id_j;



    /**
     * Set societeJ
     *
     * @param string $societeJ
     * @return Jobowner
     */
    public function setSocieteJ($societeJ)
    {
        $this->societeJ = $societeJ;

        return $this;
    }

    /**
     * Get societeJ
     *
     * @return string 
     */
    public function getSocieteJ()
    {
        return $this->societeJ;
    }

    /**
     * Set idJ
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Membre $idJ
     * @return Jobowner
     */
    public function setIdJ( $idJ)
    {
        $this->id_j = $idJ;

        return $this;
    }

    /**
     * Get idJ
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Membre 
     */
    public function getIdJ()
    {
        return $this->id_j;
    }
}
