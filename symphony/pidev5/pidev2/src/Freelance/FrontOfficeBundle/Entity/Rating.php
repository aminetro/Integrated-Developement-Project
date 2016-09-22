<?php

namespace Freelance\FrontOfficeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Rating
 *
 * @ORM\Table(name="rating", indexes={@ORM\Index(name="pseudo_vote", columns={"pseudo_vote"}), @ORM\Index(name="pseudo_voteur", columns={"pseudo_voteur"})})
 * @ORM\Entity
 */
class Rating
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
     * @var integer
     *
     * @ORM\Column(name="rate", type="integer", nullable=false)
     */
    private $rate;

    /**
     * @var \Membre
     *
     * @ORM\ManyToOne(targetEntity="Membre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="pseudo_voteur", referencedColumnName="pseudo")
     * })
     */
    private $pseudoVoteur;

    /**
     * @var \Membre
     *
     * @ORM\ManyToOne(targetEntity="Membre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="pseudo_vote", referencedColumnName="pseudo")
     * })
     */
    private $pseudoVote;



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
     * Set rate
     *
     * @param integer $rate
     * @return Rating
     */
    public function setRate($rate)
    {
        $this->rate = $rate;

        return $this;
    }

    /**
     * Get rate
     *
     * @return integer 
     */
    public function getRate()
    {
        return $this->rate;
    }

    /**
     * Set pseudoVoteur
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Membre $pseudoVoteur
     * @return Rating
     */
    public function setPseudoVoteur(\Freelance\FrontOfficeBundle\Entity\Membre $pseudoVoteur = null)
    {
        $this->pseudoVoteur = $pseudoVoteur;

        return $this;
    }

    /**
     * Get pseudoVoteur
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Membre 
     */
    public function getPseudoVoteur()
    {
        return $this->pseudoVoteur;
    }

    /**
     * Set pseudoVote
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Membre $pseudoVote
     * @return Rating
     */
    public function setPseudoVote(\Freelance\FrontOfficeBundle\Entity\Membre $pseudoVote = null)
    {
        $this->pseudoVote = $pseudoVote;

        return $this;
    }

    /**
     * Get pseudoVote
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Membre 
     */
    public function getPseudoVote()
    {
        return $this->pseudoVote;
    }
}
