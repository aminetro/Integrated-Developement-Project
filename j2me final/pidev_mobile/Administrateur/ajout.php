 <?php
require_once('connect.php');

mysql_select_db($database_localhost,$con);


$username=$_GET['pseudo'];
$email=$_GET['email'];
$password=$_GET['password'];
$nom=$_GET['nom'];
$prenom=$_GET['prenom'];
$pays=$_GET['pays'];
$ville=$_GET['ville'];
$role='a:1:{i:0;s:10:"ROLE_ADMIN";}';

mysql_query("INSERT INTO `membre`(`nom`, `prenom`,`pays`, `ville`, `pseudo`,`username`,`username_canonical`, `password`, `email`,`email_canonical`,`enabled`,`locked`,`expired`,`credentials_expired`,`roles`) VALUES
               ('$nom','$prenom','$pays','$ville','$username','$username','$username','$password','$email','$email',1,0,0,0,'$role') ");
			   

mysql_query("insert into administrateur (id_a) select id from membre where username='$username'");
			   				
				
echo "OK";
?>
