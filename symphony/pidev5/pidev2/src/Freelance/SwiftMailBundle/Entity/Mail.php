<?php
namespace  Freelance\SwiftMailBundle\Entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of Mail
 *
 * @author hp
 */
class Mail {
   
private $Subject;
private $nom;
 private $to;

 private $text;
 public function getTo() {
     return $this->to;
 }

 public function setTo($to) {
     $this->to = $to;
 }

 
 public function getSubject() {
     return $this->Subject;
 }

 public function getNom() {
     return $this->nom;
 }



 public function getText() {
     return $this->text;
 }

 public function setSubject($Subject) {
     $this->Subject = $Subject;
 }

 public function setNom($nom) {
     $this->nom = $nom;
 }



 public function setText($text) {
     $this->text = $text;
 }





}