<?php

namespace Freelance\BackOfficeBundle\Entity;

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
     * @ORM\Column(type="integer")
     * @ORM\GeneratedValue(strategy="NONE")
     * @ORM\OneToOne(targetEntity="Membre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_f", referencedColumnName="id")
     * })
     */
    private $id_f;

    /**
     * @var \Doctrine\Common\Collections\Collection
     *
     * @ORM\ManyToMany(targetEntity="Projet", inversedBy="idF")
     * @ORM\JoinTable(name="favoris",
     *   joinColumns={
     *     @ORM\JoinColumn(name="id_f", referencedColumnName="id_f")
     *   },
     *   inverseJoinColumns={
     *     @ORM\JoinColumn(name="id_p", referencedColumnName="id")
     *   }
     * )
     */
    private $idP;

    /**
     * @var \Doctrine\Common\Collections\Collection
     *
     * @ORM\ManyToMany(targetEntity="Test", inversedBy="idF")
     * @ORM\JoinTable(name="notetest",
     *   joinColumns={
     *     @ORM\JoinColumn(name="id_f", referencedColumnName="id_f")
     *   },
     *   inverseJoinColumns={
     *     @ORM\JoinColumn(name="nom_test", referencedColumnName="nom")
     *   }
     * )
     */
    private $nomTest;

    /**
     * Constructor
     */
    public function __construct()
    {
        $this->idP = new \Doctrine\Common\Collections\ArrayCollection();
        $this->nomTest = new \Doctrine\Common\Collections\ArrayCollection();
    }


    /**
     * Set disponibiliteF
     *
     * @param string $disponibiliteF
     * @return Freelancer
     */
    public function setDisponibilite($disponibiliteF)
    {
        $this->disponibiliteF = $disponibiliteF;

        return $this;
    }

    /**
     * Get disponibiliteF
     *
     * @return string 
     */
    public function getDisponibilite()
    {
        return $this->disponibiliteF;
    }

    /**
     * Set idF
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Membre $idF
     * @return Freelancer
     */
    public function setIdF($idF)
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

    /**
     * Add idP
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Projet $idP
     * @return Freelancer
     */
    public function addIdP(\Freelance\FrontOfficeBundle\Entity\Projet $idP)
    {
        $this->idP[] = $idP;

        return $this;
    }

    /**
     * Remove idP
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Projet $idP
     */
    public function removeIdP(\Freelance\FrontOfficeBundle\Entity\Projet $idP)
    {
        $this->idP->removeElement($idP);
    }

    /**
     * Get idP
     *
     * @return \Doctrine\Common\Collections\Collection 
     */
    public function getIdP()
    {
        return $this->idP;
    }

    /**
     * Add nomTest
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Test $nomTest
     * @return Freelancer
     */
    public function addNomTest(\Freelance\FrontOfficeBundle\Entity\Test $nomTest)
    {
        $this->nomTest[] = $nomTest;

        return $this;
    }

    /**
     * Remove nomTest
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Test $nomTest
     */
    public function removeNomTest(\Freelance\FrontOfficeBundle\Entity\Test $nomTest)
    {
        $this->nomTest->removeElement($nomTest);
    }

    /**
     * Get nomTest
     *
     * @return \Doctrine\Common\Collections\Collection 
     */
    public function getNomTest()
    {
        return $this->nomTest;
    }
    public function setIdP(\Doctrine\Common\Collections\Collection $idP) {
        $this->idP = $idP;
    }

    public function setNomTest(\Doctrine\Common\Collections\Collection $nomTest) {
        $this->nomTest = $nomTest;
    }


}
