<?php   
      require_once('../connect.php'); 
	$pseu=$_GET['pseu'];
      mysql_select_db($database_localhost,$con);  
      $query_search = "SELECT id,titre_p,categorie_p,duree_p,description_p,owner_p,pseudo_f FROM projet where owner_p='$pseu'";  
      $query_exec = mysql_query($query_search) or die(mysql_error());  
      
if($query_exec!=null){  
      $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
      $root_element = "people"; 
      $xml .= "<$root_element>";
	while($result_array = mysql_fetch_assoc($query_exec))
     {
      $xml .= "<person ";
 
      foreach($result_array as $key => $value)
      {
         //$key holds the table column name
         $xml .= " $key=\"$value\"";
 
         //embed the SQL data in a CDATA element to avoid XML entity issues
         $xml .= ""; 
      }
 
      $xml.="></person>";
   }
//close the root element
$xml .= "</$root_element>";
 
//send the xml header to the browser
header ("Content-Type:text/xml"); 
 
//output the XML data
echo $xml;
 }  
 ?>  