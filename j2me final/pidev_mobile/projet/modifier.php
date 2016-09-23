 <?php
require_once('../connect.php');
mysql_select_db($database_localhost,$con);

$titre=$_GET['titre'];
$desc=$_GET['desc'];
$duree=$_GET['duree'];
$cat=$_GET['cat'];
$id=$_GET['id'];

mysql_query("UPDATE `projet` SET `titre_p` ='$titre',`categorie_p` = '$cat',`duree_p` ='$duree', `description_p` = '$desc' WHERE  `id` ='$id'");
		
echo "OK";		
?> 