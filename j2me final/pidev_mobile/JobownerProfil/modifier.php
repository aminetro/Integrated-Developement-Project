 <?php
require_once('../connect.php');
mysql_select_db($database_localhost,$con);

$nom=$_GET['nom'];
$prenom=$_GET['prenom'];
$pseudo=$_GET['pseudo'];
$pays=$_GET['pays'];
$ville=$_GET['ville'];
$email=$_GET['email'];
$societe=$_GET['societe'];
$id=$_GET['id'];

mysql_query( "UPDATE jobowner, membre SET jobowner.societe_j='$societe' WHERE jobowner.id_j=membre.id and id='$id'");
mysql_query("UPDATE membre SET username='$pseudo',username_canonical='$pseudo',nom ='$nom',prenom ='$prenom',pays ='$pays',ville ='$ville',pseudo ='$pseudo',email ='$email',email_canonical='$email'WHERE id ='$id'");		
echo "OK";		
?> 