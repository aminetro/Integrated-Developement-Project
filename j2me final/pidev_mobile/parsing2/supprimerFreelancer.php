 <?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);

$id_f=$_GET['id_f'];
if(mysql_query("DELETE FROM `pidev-11`.`freelancer` WHERE `freelancer`.`id_f` =$id_f ")){
mysql_query("DELETE FROM `pidev-11`.`membre` WHERE `membre`.`id` = $id_f")	;

}

echo "OK";
?>