 <?php
require_once('../../connect.php');

mysql_select_db($database_localhost,$con);

$requete="SELECT count(*) as compteur FROM  `projet` WHERE categorie_p = 'c#'";
$resultat=mysql_query ($requete);
$ligne=mysql_fetch_array($resultat);

	echo $ligne['compteur'];

?>