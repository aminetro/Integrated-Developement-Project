 <?php
require_once('../connect.php');

mysql_select_db($database_localhost,$con);

$nom=$_GET['nom'];
$question1=$_GET['question1'];
$reponse1=$_GET['reponse1'];
$question2=$_GET['question2'];
$reponse2=$_GET['reponse2'];
$question3=$_GET['question3'];
$reponse3=$_GET['reponse3'];
$question4=$_GET['question4'];
$reponse4=$_GET['reponse4'];
$question5=$_GET['question5'];
$reponse5=$_GET['reponse5'];
$question6=$_GET['question6'];
$reponse6=$_GET['reponse6'];
mysql_query("INSERT INTO test VALUES ('','$nom','$question1','$reponse1','$question2','$reponse2','$question3','$reponse3',
					'$question4','$reponse4','$question5','$reponse5','$question6','$reponse6') ");
echo "OK";
?>