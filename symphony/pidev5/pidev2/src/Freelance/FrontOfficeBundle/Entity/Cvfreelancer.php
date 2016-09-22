<?php

namespace Freelance\FrontOfficeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Cvfreelancer
 *
 * @ORM\Table(name="cvfreelancer")
 * @ORM\Entity
 */
class Cvfreelancer
{
    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dernier_maj_cv", type="date", nullable=true)
     */
    private $dernierMajCv;

    /**
     * @var string
     *
     * @ORM\Column(name="experience_cv", type="string", length=500, nullable=true)
     */
    private $experience_cv ;

    /**
     * @var string
     *
     * @ORM\Column(name="langue_cv", type="string", length=100, nullable=true)
     */
    private $langueCv = '';

    /**
     * @var string
     *
     * @ORM\Column(name="certification_cv", type="string", length=200, nullable=true)
     */
    private $certificationCv = '';

    /**
     * @var string
     *
     * @ORM\Column(name="formation_cv", type="string", length=200, nullable=true)
     */
    private $formationCv;

    /**
     * @var string
     *
     * @ORM\Column(name="photo_cv", type="blob", nullable=true)
     */
    private $photo_cv;

    /**
     * @var \Freelancer
     *
     * @ORM\Id
     * @ORM\Column(name="id_cv", type="integer", nullable=false)
     * @ORM\GeneratedValue(strategy="NONE")
     * @ORM\OneToOne(targetEntity="Freelancer")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_cv", referencedColumnName="id_f")
     * })
     */
    private $idCv;

private $upload;
public function getUpload() {
    return $this->upload;
}

public function setUpload($upload) {
    $this->upload = $upload;
}

    /**
     * Set dernierMajCv
     *
     * @param \DateTime $dernierMajCv
     * @return Cvfreelancer
     */
    public function setDernierMajCv($dernierMajCv)
    {
        $this->dernierMajCv = $dernierMajCv;

        return $this;
    }

    /**
     * Get dernierMajCv
     *
     * @return \DateTime 
     */
    public function getDernierMajCv()
    {
        return $this->dernierMajCv;
    }

    /**
     * Set experienceCv
     *
     * @param string $experienceCv
     * @return Cvfreelancer
     */
    public function setExperienceCv($experienceCv)
    {
        $this->experience_cv = $experienceCv;

        return $this;
    }

    /**
     * Get experienceCv
     *
     * @return string 
     */
    public function getExperienceCv()
    {
        return $this->experience_cv;
    }

    /**
     * Set langueCv
     *
     * @param string $langueCv
     * @return Cvfreelancer
     */
    public function setLangueCv($langueCv)
    {
        $this->langueCv = $langueCv;

        return $this;
    }

    /**
     * Get langueCv
     *
     * @return string 
     */
    public function getLangueCv()
    {
        return $this->langueCv;
    }

    /**
     * Set certificationCv
     *
     * @param string $certificationCv
     * @return Cvfreelancer
     */
    public function setCertificationCv($certificationCv)
    {
        $this->certificationCv = $certificationCv;

        return $this;
    }

    /**
     * Get certificationCv
     *
     * @return string 
     */
    public function getCertificationCv()
    {
        return $this->certificationCv;
    }

    /**
     * Set formationCv
     *
     * @param string $formationCv
     * @return Cvfreelancer
     */
    public function setFormationCv($formationCv)
    {
        $this->formationCv = $formationCv;

        return $this;
    }

    /**
     * Get formationCv
     *
     * @return string 
     */
    public function getFormationCv()
    {
        return $this->formationCv;
    }

    /**
     * Set photoCv
     *
     * @param string $photoCv
     * @return Cvfreelancer
     */
    public function setPhotoCv($photoCv)
    {
        $this->photo_cv = $photoCv;

        return $this;
    }

    /**
     * Get photoCv
     *
     * @return string 
     */
    public function getPhotoCv()
    {
        return $this->photo_cv;
    }

    /**
     * Set idCv
     *
     * @param \Freelance\FrontOfficeBundle\Entity\Freelancer $idCv
     * @return Cvfreelancer
     */
    public function setIdCv($idCv)
    {
        $this->idCv = $idCv;

        return $this;
    }

    /**
     * Get idCv
     *
     * @return \Freelance\FrontOfficeBundle\Entity\Freelancer 
     */
    public function getIdCv()
    {
        return $this->idCv;
    }
}
