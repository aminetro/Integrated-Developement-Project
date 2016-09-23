 <?php
require_once('../connect.php');
mysql_select_db($database_localhost,$con);
$id=$_GET['id'];
mysql_query("delete from cvfreelancer where id_cv='$id'");
echo "OK";
?>