 <?php
require_once('../../connect.php');

mysql_select_db($database_localhost,$con);

$id=$_GET['id'];
$pseu=$_GET['pseu'];

mysql_query("UPDATE `projet` SET `pseudo_f` = '$pseu' WHERE  `id` = '$id'");

echo "OK";

?>