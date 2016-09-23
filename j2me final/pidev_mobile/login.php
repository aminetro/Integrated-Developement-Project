 <?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);

$login=$_GET['login'];
$pass=$_GET['pass'];

$requete="SELECT *  FROM  `membre` WHERE username =  '$login' AND PASSWORD LIKE  '$pass%'";
$resultat=mysql_query ($requete);
$ligne=mysql_fetch_array($resultat);
if (strpos($ligne['roles'], "FREELANCER")!=false)
	echo"free";
elseif (strpos($ligne['roles'], "JOBOWNER")!=false)
	echo"job";
elseif (strpos($ligne['roles'], "ADMIN")!=false)
	echo"admin";
elseif ($ligne['username']=="")
	 echo "error"; 

?>