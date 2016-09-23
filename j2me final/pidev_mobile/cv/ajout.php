 <?php
require_once('../connect.php');

mysql_select_db($database_localhost,$con);

$pseudo=$_GET['pseudo'];
$exp=$_GET['exp'];
$langue=$_GET['langue'];
$certif=$_GET['certif'];
$formation=$_GET['formation'];
$idd=0;
$requete = "select id from membre where username='$pseudo'";
$resultat=mysql_query ($requete);
while ($ligne=mysql_fetch_array($resultat)) { 
	$idd=$ligne['id'];
}
mysql_query("INSERT INTO cvfreelancer VALUES ('$idd',now(),'$exp','$langue','$certif','$formation',NULL) ")or die("Error: ".mysql_error());
echo "OK";
?>