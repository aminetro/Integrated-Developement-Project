<?php

namespace Freelance\FrontOfficeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Projet
 *
 * @ORM\Table(name="projet", indexes={@ORM\Index(name="owner_p", columns={"owner_p", "pseudo_f"}), @ORM\Index(name="pseudo_f", columns={"pseudo_f"}), @ORM\Index(name="IDX_50159CA9E61C9C8F", columns={"owner_p"})})
 * @ORM\Entity
 */
class Projet
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
     * @ORM\Column(name="titre_p", type="string", length=100, nullable=false)
     */
    private $titreP;

    /**
     * @var string
     *
     * @ORM\Column(name="categorie_p", type="string", length=200, nullable=false)
     */
    private $categorie_p;

    /**
     * @var string
     *
     * @ORM\Column(name="duree_p", type="string", length=60, nullable=false)
     */
    private $dureeP;

    /**
     * @var string
     *
     * @ORM\Column(name="description_p", type="string", length=500, nullable=false)
     */
    private $descriptionP;

    /**
     * @var string
     *
     * @ORM\Column(name="photo_p", type="blob", nullable=true)
     */
    private $photoP;

    /**
     * @var \Membre
     * @ORM\Column(name="owner_p", type="string", length=50, nullable=false)
     * @ORM\ManyToOne(targetEntity="Membre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="owner_p", referencedColumnName="pseudo")
     * })
     */
    private $ownerP;

    /**
     * @var \Membre
     * @ORM\Column(name="pseudo_f", type="string", length=50, nullable=false)
     * @ORM\ManyToOne(targetEntity="Membre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="pseudo_f", referencedColumnName="pseudo")
     * })
     */
    private $pseudoF;



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
     * Set titreP
     *
     * @param string $titreP
     * @return Projet
     */
    public function setTitreP($titreP)
    {
        $this->titreP = $titreP;

        return $this;
    }

    /**
     * Get titreP
     *
     * @return string 
     */
    public function getTitreP()
    {
        return $this->titreP;
    }

    /**
     * Set categorieP
     *
     * @param string $categorieP
     * @return Projet
     */
    public function setCategorieP($categorieP)
    {
        $this->categorie_p = $categorieP;

        return $this;
    }

    /**
     * Get categorieP
     *
     * @return string 
     */
    public function getCategorieP()
    {
        return $this->categorie_p;
    }

    /**
     * Set dureeP
     *
     * @param string $dureeP
     * @return Projet
     */
    public function setDureeP($dureeP)
    {
        $this->dureeP = $dureeP;

        return $this;
    }

    /**
     * Get dureeP
     *
     * @return string 
     */
    public function getDureeP()
    {
        return $this->dureeP;
    }

    /**
     * Set descriptionP
     *
     * @param string $descriptionP
     * @return Projet
     */
    public function setDescriptionP($descriptionP)
    {
        $this->descriptionP = $descriptionP;

        return $this;
    }

    /**
     * Get descriptionP
     *
     * @return string 
     */
    public function getDescriptionP()
    {
        return $this->descriptionP;
    }

    /**
     * Set photoP
     *
     * @param string $photoP
     * @return Projet
     */
    public function setPhotoP($photoP)
    {
        $this->photoP = $photoP;

        return $this;
    }

    /**
     * Get photoP
     *
     * @return string 
     */
    public function getPhotoP()
    {
        return $this->photoP;
    }

    /**
     * Set ownerP
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Membre $ownerP
     * @return Projet
     */
    public function setOwnerP($ownerP)
    {
        $this->ownerP = $ownerP;

        return $this;
    }

    /**
     * Get ownerP
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Membre 
     */
    public function getOwnerP()
    {
        return $this->ownerP;
    }

    /**
     * Set pseudoF
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Membre $pseudoF
     * @return Projet
     */
    public function setPseudoF($pseudoF)
    {
        $this->pseudoF = $pseudoF;

        return $this;
    }

    /**
     * Get pseudoF
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Membre 
     */
    public function getPseudoF()
    {
        return $this->pseudoF;
    }
}
