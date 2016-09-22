<?php

namespace Freelance\FrontOfficeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Freelancer
 *
 * @ORM\Table(name="freelancer")
 * @ORM\Entity
 */
class Freelancer
{
    /**
     * @var string
     *
     * @ORM\Column(name="disponibilite_f", type="string", length=50, nullable=false)
     */
    private $disponibiliteF = '';

    /**
     * @var \Membre
     *
     * @ORM\Id
     * @var integer
     * @ORM\Column(name="id_f", type="integer")
     * @ORM\GeneratedValue(strategy="NONE")
     * @ORM\OneToOne(targetEntity="Membre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_f", referencedColumnName="id")
     * })
     */
    private $id_f;



    /**
     * Set disponibiliteF
     *
     * @param string $disponibiliteF
     * @return Freelancer
     */
    public function setDisponibiliteF($disponibiliteF)
    {
        $this->disponibiliteF = $disponibiliteF;

        return $this;
    }

    /**
     * Get disponibiliteF
     *
     * @return string 
     */
    public function getDisponibiliteF()
    {
        return $this->disponibiliteF;
    }

    /**
     * Set idF
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Membre $idF
     * @return Freelancer
     */
    public function setIdF( $idF)
    {
        $this->id_f = $idF;

        return $this;
    }

    /**
     * Get idF
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Membre 
     */
    public function getIdF()
    {
        return $this->id_f;
    }
    
    public function __toString() {
        return $this->id_f;
    }

}
