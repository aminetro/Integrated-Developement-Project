 <?php
require_once('../connect.php');
mysql_select_db($database_localhost,$con);
$id=$_GET['id'];
mysql_query("delete from projet where id='$id'");
echo "OK";
?>