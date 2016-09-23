<?php  
 $hostname_localhost ="localhost";  
 $database_localhost ="pidev";  
 $username_localhost ="root";  
 $password_localhost ="";  
 $con = mysql_connect($hostname_localhost,$username_localhost,$password_localhost)  
 or  
 trigger_error(mysql_error(),E_USER_ERROR);  
 ?>