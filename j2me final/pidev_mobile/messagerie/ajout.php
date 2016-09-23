 <?php
require_once('../connect.php');

mysql_select_db($database_localhost,$con);

$expediteur=$_GET['expediteur'];
$recepteur=$_GET['recepteur'];
$sujet=$_GET['sujet'];
$message=$_GET['message'];
mysql_query("INSERT INTO `messagerie`VALUES (NULL,'$expediteur','$recepteur',now(),'$sujet','$message')");
"INSERT INTO `messagerie`VALUES"
                + " (NULL,?,?,?,?,?)";
echo "OK";
?>