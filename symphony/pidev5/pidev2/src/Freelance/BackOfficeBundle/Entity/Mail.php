<?php
namespace Freelance\BackOfficeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of MailType
 *
 * @author hp
 */
class MailType {

    
    private $nom;
    private $prenom;
    private $tel;
    private $from;
    private $text;
    public function getNom() {
        return $this->nom;
    }

    public function getPrenom() {
        return $this->prenom;
    }

    public function getTel() {
        return $this->tel;
    }

    public function getFrom() {
        return $this->from;
    }

    public function getText() {
        return $this->text;
    }

    public function setNom($nom) {
        $this->nom = $nom;
    }

    public function setPrenom($prenom) {
        $this->prenom = $prenom;
    }

    public function setTel($tel) {
        $this->tel = $tel;
    }

    public function setFrom($from) {
        $this->from = $from;
    }

    public function setText($text) {
        $this->text = $text;
    }


}
