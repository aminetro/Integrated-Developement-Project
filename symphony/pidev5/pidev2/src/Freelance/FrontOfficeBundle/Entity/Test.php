<?php

namespace Freelance\FrontOfficeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Test
 *
 * @ORM\Table(name="test", indexes={@ORM\Index(name="nom", columns={"nom"})})
 * @ORM\Entity
 */
class Test
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
     * @ORM\Column(name="nom", type="string", length=20, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="question1", type="string", length=100, nullable=false)
     */
    private $question1;

    /**
     * @var string
     *
     * @ORM\Column(name="reponse1", type="string", length=3, nullable=false)
     */
    private $reponse1;

    /**
     * @var string
     *
     * @ORM\Column(name="question2", type="string", length=100, nullable=false)
     */
    private $question2;

    /**
     * @var string
     *
     * @ORM\Column(name="reponse2", type="string", length=3, nullable=false)
     */
    private $reponse2;

    /**
     * @var string
     *
     * @ORM\Column(name="question3", type="string", length=100, nullable=false)
     */
    private $question3;

    /**
     * @var string
     *
     * @ORM\Column(name="reponse3", type="string", length=3, nullable=false)
     */
    private $reponse3;

    /**
     * @var string
     *
     * @ORM\Column(name="question4", type="string", length=100, nullable=false)
     */
    private $question4;

    /**
     * @var string
     *
     * @ORM\Column(name="reponse4", type="string", length=3, nullable=false)
     */
    private $reponse4;

    /**
     * @var string
     *
     * @ORM\Column(name="question5", type="string", length=100, nullable=false)
     */
    private $question5;

    /**
     * @var string
     *
     * @ORM\Column(name="reponse5", type="string", length=3, nullable=false)
     */
    private $reponse5;

    /**
     * @var string
     *
     * @ORM\Column(name="question6", type="string", length=100, nullable=false)
     */
    private $question6;

    /**
     * @var string
     *
     * @ORM\Column(name="reponse6", type="string", length=3, nullable=false)
     */
    private $reponse6;



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
     * Set nom
     *
     * @param string $nom
     * @return Test
     */
    public function setNom($nom)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return string 
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * Set question1
     *
     * @param string $question1
     * @return Test
     */
    public function setQuestion1($question1)
    {
        $this->question1 = $question1;

        return $this;
    }

    /**
     * Get question1
     *
     * @return string 
     */
    public function getQuestion1()
    {
        return $this->question1;
    }

    /**
     * Set reponse1
     *
     * @param string $reponse1
     * @return Test
     */
    public function setReponse1($reponse1)
    {
        $this->reponse1 = $reponse1;

        return $this;
    }

    /**
     * Get reponse1
     *
     * @return string 
     */
    public function getReponse1()
    {
        return $this->reponse1;
    }

    /**
     * Set question2
     *
     * @param string $question2
     * @return Test
     */
    public function setQuestion2($question2)
    {
        $this->question2 = $question2;

        return $this;
    }

    /**
     * Get question2
     *
     * @return string 
     */
    public function getQuestion2()
    {
        return $this->question2;
    }

    /**
     * Set reponse2
     *
     * @param string $reponse2
     * @return Test
     */
    public function setReponse2($reponse2)
    {
        $this->reponse2 = $reponse2;

        return $this;
    }

    /**
     * Get reponse2
     *
     * @return string 
     */
    public function getReponse2()
    {
        return $this->reponse2;
    }

    /**
     * Set question3
     *
     * @param string $question3
     * @return Test
     */
    public function setQuestion3($question3)
    {
        $this->question3 = $question3;

        return $this;
    }

    /**
     * Get question3
     *
     * @return string 
     */
    public function getQuestion3()
    {
        return $this->question3;
    }

    /**
     * Set reponse3
     *
     * @param string $reponse3
     * @return Test
     */
    public function setReponse3($reponse3)
    {
        $this->reponse3 = $reponse3;

        return $this;
    }

    /**
     * Get reponse3
     *
     * @return string 
     */
    public function getReponse3()
    {
        return $this->reponse3;
    }

    /**
     * Set question4
     *
     * @param string $question4
     * @return Test
     */
    public function setQuestion4($question4)
    {
        $this->question4 = $question4;

        return $this;
    }

    /**
     * Get question4
     *
     * @return string 
     */
    public function getQuestion4()
    {
        return $this->question4;
    }

    /**
     * Set reponse4
     *
     * @param string $reponse4
     * @return Test
     */
    public function setReponse4($reponse4)
    {
        $this->reponse4 = $reponse4;

        return $this;
    }

    /**
     * Get reponse4
     *
     * @return string 
     */
    public function getReponse4()
    {
        return $this->reponse4;
    }

    /**
     * Set question5
     *
     * @param string $question5
     * @return Test
     */
    public function setQuestion5($question5)
    {
        $this->question5 = $question5;

        return $this;
    }

    /**
     * Get question5
     *
     * @return string 
     */
    public function getQuestion5()
    {
        return $this->question5;
    }

    /**
     * Set reponse5
     *
     * @param string $reponse5
     * @return Test
     */
    public function setReponse5($reponse5)
    {
        $this->reponse5 = $reponse5;

        return $this;
    }

    /**
     * Get reponse5
     *
     * @return string 
     */
    public function getReponse5()
    {
        return $this->reponse5;
    }

    /**
     * Set question6
     *
     * @param string $question6
     * @return Test
     */
    public function setQuestion6($question6)
    {
        $this->question6 = $question6;

        return $this;
    }

    /**
     * Get question6
     *
     * @return string 
     */
    public function getQuestion6()
    {
        return $this->question6;
    }

    /**
     * Set reponse6
     *
     * @param string $reponse6
     * @return Test
     */
    public function setReponse6($reponse6)
    {
        $this->reponse6 = $reponse6;

        return $this;
    }

    /**
     * Get reponse6
     *
     * @return string 
     */
    public function getReponse6()
    {
        return $this->reponse6;
    }
    
    public function __toString() {
        return $this->nom;
    }

    
}
