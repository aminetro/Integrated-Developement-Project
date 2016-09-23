 <?php
require_once('connect.php');
mysql_select_db($database_localhost,$con);
$id=$_GET['id'];
mysql_query("delete from membre where id='$id'");
mysql_query("delete from administrateur where id='$id'");

echo "OK";
?>