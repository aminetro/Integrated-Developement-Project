<?php



$username=$_GET['from'];
$password=$_GET['pass'];
$address=$_GET['to'];
$sujet=$_GET['sujet'];
$message=$_GET['message'];

require 'PHPMailerAutoload.php';
$mail = new PHPMailer(); // create a new object
$mail->IsSMTP(); // enable SMTP
//$mail->SMTPDebug = 1; // debugging: 1 = errors and messages, 2 = messages only
$mail->SMTPAuth = true; // authentication enabled
$mail->SMTPSecure = 'tls'; // secure transfer enabled REQUIRED for GMail
$mail->Host = "smtp.gmail.com";
$mail->Port = 587; // or 587
$mail->IsHTML(true);
$mail->Username = $username;
$mail->Password = $password;
$mail->SetFrom($username);
$mail->Subject = $sujet;
$mail->Body = $message;
$mail->AddAddress($address);
 if($mail->Send())
   
    {
    echo "OK";
    }

?>