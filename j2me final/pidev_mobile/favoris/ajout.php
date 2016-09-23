 <?php
require_once('../connect.php');

mysql_select_db($database_localhost,$con);

$pseudo=$_GET['pseudo'];


$idp=$_GET['idp'];
$idd=0;
$requete = "select id from membre where username='$pseudo'";
$resultat=mysql_query ($requete);
while ($ligne=mysql_fetch_array($resultat)) { 
	$idd=$ligne['id'];
}
mysql_query("INSERT INTO favoris VALUES (NULL,'$idp','$idd') ")or die("Error: ".mysql_error());
echo "OK";
?>