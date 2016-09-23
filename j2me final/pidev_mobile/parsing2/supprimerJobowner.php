 <?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);

$id_j=$_GET['id_j'];
if(mysql_query("DELETE FROM `pidev-11`.`jobowner` WHERE `jobowner`.`id_j` =$id_j ")){
mysql_query("DELETE FROM `pidev-11`.`membre` WHERE `membre`.`id` = $id_j")	;
}

echo "OK";
?>