 <?php
require_once('connect.php');
mysql_select_db($database_localhost,$con);
$id=$_GET['id'];
mysql_query("DELETE FROM `pidev`.`membre` WHERE `membre`.`id` = '$id'");
mysql_query("DELETE FROM `pidev`.`jobowner` WHERE `jobowner`.`id_j` = '$id'");

echo "OK";
?>