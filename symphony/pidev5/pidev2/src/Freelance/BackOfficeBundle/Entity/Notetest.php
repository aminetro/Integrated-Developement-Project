<?php

namespace Freelance\BackOfficeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Notetest
 *
 * @ORM\Table(name="notetest", indexes={@ORM\Index(name="id_f", columns={"id_f", "nom_test"}), @ORM\Index(name="nom_test", columns={"nom_test"}), @ORM\Index(name="IDX_E5E74716B146819F", columns={"id_f"})})
 * @ORM\Entity
 */
class Notetest
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
     * @ORM\Column(name="note_test", type="integer", nullable=false)
     */
    private $noteTest;

    /**
     * @var \Test
     *
     * @ORM\ManyToOne(targetEntity="Test")
     * @ORM\Column(name="nom_test", type="string", length=30, nullable=false)
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="nom_test", referencedColumnName="nom")
     * })
     */
    private $nomTest;

    /**
     * @ORM\Column(name="id_f", type="integer")
     * @ORM\ManyToOne(targetEntity="Freelancer")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_f", referencedColumnName="id_f")
     * })
     */
    private $id_f;



    /**
     * Get id
     *
     * 
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set noteTest
     *
     * @param integer $noteTest
     * @return Notetest
     */
    public function setNoteTest($noteTest)
    {
        $this->noteTest = $noteTest;

        return $this;
    }

    /**
     * Get noteTest
     *
     * @return integer 
     */
    public function getNoteTest()
    {
        return $this->noteTest;
    }

    /**
     * Set nomTest
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Test $nomTest
     * @return Notetest
     */
    public function setNomTest($nomTest )
    {
        $this->nomTest = $nomTest;

        return $this;
    }

    /**
     * Get nomTest
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Test 
     */
    public function getNomTest()
    {
        return $this->nomTest;
    }

    /**
     * Set idF
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Freelancer $idF
     * @return Notetest
     */
    public function setIdF($idF)
    {
        $this->id_f = $idF;

        return $this;
    }

    /**
     * Get idF
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Freelancer 
     */
    public function getIdF()
    {
        return $this->id_f;
    }
}
