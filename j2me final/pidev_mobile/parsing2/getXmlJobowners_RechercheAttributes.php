<?php   
      require_once('connect.php'); 
  
      mysql_select_db($database_localhost,$con);  
	  $tfrecherche=$_GET['tfrecherche'];
	
      $query_search = "SELECT id_j,nom,prenom,email,pays,ville,pseudo,societe_j FROM membre m ,jobowner j where j.id_j=m.id and pseudo LIKE '%$tfrecherche%'  ";  
      $query_exec = mysql_query($query_search) or die(mysql_error());  
      
if($query_exec!=null){  
      $xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
      $root_element = "jobowners"; 
      $xml .= "<$root_element>";
	while($result_array = mysql_fetch_assoc($query_exec))
     {
      $xml .= "<jobowner ";
 
      foreach($result_array as $key => $value)
      {
         //$key holds the table column name
         $xml .= " $key=\"$value\"";
 
         //embed the SQL data in a CDATA element to avoid XML entity issues
         $xml .= ""; 
      }
 
      $xml.="></jobowner>";
   }
//close the root element
$xml .= "</$root_element>";
 
//send the xml header to the browser
header ("Content-Type:text/xml"); 
 
//output the XML data
echo $xml;
 }  
 ?>  