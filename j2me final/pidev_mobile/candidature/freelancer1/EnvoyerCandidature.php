 <?php
require_once('../connect.php');

mysql_select_db($database_localhost,$con);

$pseudo=$_GET['pseudo'];


$estimation=$_GET['estimation'];
$lettre_mot=$_GET['lettre_mot'];
$question=$_GET['question'];
$idprojet=$_GET['idprojet'];

mysql_query("INSERT INTO `candidature`(`id`,`pseufreelancer`,`id_p`,`estimation`, `lettre_mot`, `question`) VALUES (NULL,'$pseudo','$idprojet','$estimation','$lettre_mot','$question')")or die("Error: ".mysql_error());
echo "OK";

?>