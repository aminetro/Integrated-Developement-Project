 <?php
require_once('../connect.php');

mysql_select_db($database_localhost,$con);


$username=$_GET['username'];
$email=$_GET['email'];
$password=$_GET['password'];
$nom=$_GET['nom'];
$prenom=$_GET['prenom'];
$pays=$_GET['pays'];
$ville=$_GET['ville'];
$societe=$_GET['societe'];
$role='a:1:{i:0;s:13:"ROLE_JOBOWNER";}';

mysql_query("INSERT INTO `membre`(`nom`, `prenom`,`pays`, `ville`, `pseudo`,`username`,`username_canonical`, `password`, `email`,`email_canonical`,`enabled`,`locked`,`expired`,`credentials_expired`,`roles`) VALUES
               ('$nom','$prenom','$pays','$ville','$username','$username','$username','$password','$email','$email',1,0,0,0,'$role') ");
			   

mysql_query("insert into jobowner (id_j) select id from membre where username='$username'");

mysql_query("UPDATE jobowner, membre SET jobowner.societe_j='$societe' WHERE jobowner.id_j=membre.id and membre.pseudo='$username'");
			   				
				
echo "OK";
?>
