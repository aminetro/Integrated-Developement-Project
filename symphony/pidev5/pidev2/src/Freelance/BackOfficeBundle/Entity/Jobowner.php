<?php

namespace Freelance\BackOfficeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity
 */
class Jobowner 
{
    
   

   /** 
     * @ORM\Id
     * @ORM\Column(type="integer")
     * @ORM\OneToOne(targetEntity="Membre")
     * @ORM\JoinColumns({
     * @ORM\JoinColumn(name="id_j", referencedColumnName="id")
     * })
     */
   
    private $id_j;

     /**
     * @ORM\Column(type="string",length=100)
     */
    private $societe_j;
 
   

    public function getSocieteJ() {
        return $this->societe_j;
    }

    public function setSocieteJ($societe_j) {
        $this->societe_j = $societe_j;
    }
   
    
    public function setIdJ( $id_j)
    {
        $this->id_j = $id_j;

        return $this;
    }

    
    public function getIdJ()
    {
        return $this->id_j;
    }
     



  
    
}