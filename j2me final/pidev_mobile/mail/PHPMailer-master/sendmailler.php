<?php
require 'PHPMailerAutoload.php';

$mail = new PHPMailer;

//$mail->SMTPDebug = 3;                               // Enable verbose debug output

$mail->isSMTP();                                      // Set mailer to use SMTP
$mail->Host = 'smtp.gmail.com;smtp2.example.com';  // Specify main and backup SMTP servers
$mail->SMTPAuth = true;                               // Enable SMTP authentication
$mail->Username = 'medamine.yahiaoui@esprit.tn';                 // SMTP username
$mail->Password = 'chbikmama123456789';                           // SMTP password
$mail->SMTPSecure = 'tls';                            // Enable TLS encryption, `ssl` also accepted
$mail->Port = 587;                                    // TCP port to connect to

$mail->From = 'medamine.yahiaoui@esprit.tn';
$mail->FromName = 'Mailer';
$mail->addAddress('mohamed.sta@esprit.tn');     // Add a recipient
$mail->addAddress('mohamed.sta@esprit.tn');               // Name is optional
$mail->addReplyTo('mohamed.sta@esprit.tn');
/*$mail->addCC('medamine.yahiaoui@esprit.tn');
$mail->addBCC('medamine.yahiaoui@esprit.tn');*/

/*$mail->addAttachment('/var/tmp/file.tar.gz');         // Add attachments
$mail->addAttachment('/tmp/image.jpg', 'new.jpg');    // Optional name
$mail->isHTML(true);       */                           // Set email format to HTML

$mail->Subject = 'Here is the subject';
$mail->Body    = 'This is the HTML message body <b>in bold!</b>';
$mail->AltBody = 'This is the body in plain text for non-HTML mail clients';

if(!$mail->send()) {
    echo 'Message could not be sent.';
    echo 'Mailer Error: ' . $mail->ErrorInfo;
} else {
    echo 'Message has been sent';
}