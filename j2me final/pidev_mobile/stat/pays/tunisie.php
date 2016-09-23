 <?php
require_once('../../connect.php');

mysql_select_db($database_localhost,$con);

$requete="SELECT COUNT(pays) as pays FROM membre where pays='tunisie'";
$resultat=mysql_query ($requete);
$ligne=mysql_fetch_array($resultat);

	echo $ligne['pays'];

?>