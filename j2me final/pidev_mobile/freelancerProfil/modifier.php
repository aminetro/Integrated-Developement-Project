 <?php
require_once('../connect.php');
mysql_select_db($database_localhost,$con);

$nom=$_GET['nom'];
$prenom=$_GET['prenom'];
$pseudo=$_GET['pseudo'];
$pays=$_GET['pays'];
$ville=$_GET['ville'];
$email=$_GET['email'];
$disponibilite=$_GET['disponibilite'];
$id=$_GET['id'];

mysql_query("UPDATE freelancer, membre SET freelancer.disponibilite_f='$disponibilite' WHERE freelancer.id_f=membre.id and id='$id'");
mysql_query("UPDATE membre SET username='$pseudo',username_canonical='$pseudo',nom ='$nom',prenom ='$prenom',pays ='$pays',ville ='$ville',pseudo ='$pseudo',email ='$email',email_canonical='$email'WHERE id ='$id'");		
echo "OK";		
?> 