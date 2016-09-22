<?php

namespace Freelance\FrontOfficeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Administrateur
 *
 * @ORM\Table(name="administrateur")
 * @ORM\Entity
 */
class Administrateur
{
    /**
     * @var \Membre
     *
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     * @ORM\Column(name="id_a", type="integer", nullable=false)
     * @ORM\OneToOne(targetEntity="Membre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_a", referencedColumnName="id")
     * })
     */
    private $id_a;



    /**
     * Set idA
     * @param \Freelance\FrontOfficeBundle\Entity\Membre $idA
     * @return Administrateur
     */
    public function setIdA($idA)
    {
        $this->id_a = $idA;

        return $this;
    }

    /**
     * Get idA
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Membre 
     */
    public function getIdA()
    {
        return $this->id_a;
    }
}
