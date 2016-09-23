 <?php
require_once('../connect.php');

mysql_select_db($database_localhost,$con);

$pseudo=$_GET['pseudo'];


$sujet=$_GET['sujet'];
$message=$_GET['message'];

mysql_query("INSERT INTO reclamation VALUES (NULL,'$pseudo',now(),'$sujet','$message') ")or die("Error: ".mysql_error());
echo "OK";
?>