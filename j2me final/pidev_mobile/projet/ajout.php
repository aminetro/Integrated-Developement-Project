 <?php
require_once('../connect.php');

mysql_select_db($database_localhost,$con);

$pseudo=$_GET['pseudo'];
$titre=$_GET['titre'];
$categ=$_GET['categ'];
$duree=$_GET['duree'];
$desc=$_GET['desc'];

mysql_query("INSERT INTO projet VALUES (NULL,'$pseudo',NULL,'$titre','$categ','$duree','$desc',NULL) ")or die("Error: ".mysql_error());
echo "OK";
?>