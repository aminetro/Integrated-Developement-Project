 <?php
require_once('../connect.php');
mysql_select_db($database_localhost,$con);

$exp=$_GET['exp'];
$cert=$_GET['cert'];
$form=$_GET['form'];
$Lang=$_GET['Lang'];
$id=$_GET['id'];

mysql_query("UPDATE `cvfreelancer` SET `experience_cv` ='$exp',`certification_cv` = '$cert',`formation_cv` ='$form', `langue_cv` = '$Lang' WHERE  `id_cv` ='$id'");
		
echo "OK";		
?> 