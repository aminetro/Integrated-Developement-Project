 <?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);

$id=$_GET['id'];
$username=$_GET['pseudo'];
$email=$_GET['email'];
$nom=$_GET['nom'];
$prenom=$_GET['prenom'];
$pays=$_GET['pays'];
$ville=$_GET['ville'];


mysql_query ("UPDATE  membre SET `username` =$nom,`username_canonical` =$nom,`email` =$email,`email_canonical` =$email,`nom` =$nom,`prenom` =$prenom,`pays` =$pays,`ville` =$ville,`pseudo` =$pseudo  WHERE`id` =$id") ;

echo "OK";
?>
