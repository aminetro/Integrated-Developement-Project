<?php

namespace Freelance\BackOfficeBundle\Entity;

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
     * @ORM\Column(type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     * @ORM\OneToOne(targetEntity="Membre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_a", referencedColumnName="id")
     * })
     */
    private $id_a;



    public function getId_a() {
        return $this->id_a;
    }

    public function setId_a( $id_a) {
        $this->id_a = $id_a;
    }


     
}
