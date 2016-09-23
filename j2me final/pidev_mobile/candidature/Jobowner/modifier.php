 <?php
require_once('../../connect.php');
mysql_select_db($database_localhost,$con);
$id=$_GET['id'];
$estimation=$_GET['estimation'];
$lettre=$_GET['lettre'];
$question=$_GET['question'];


mysql_query("UPDATE `candidature` SET `estimation` ='$estimation',`lettre_mot` = '$lettre',`question` ='$question' WHERE  `id` ='$id'");
		
echo "OK";		
?> 