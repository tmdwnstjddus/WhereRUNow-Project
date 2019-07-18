<?php
$con=mysqli_connect("127.0.0.1","root","wldud123","android_test");

mysqli_set_charset($con,"utf8");

if (mysqli_connect_errno($con))
{
   echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
$userid = $_POST['Id'];
$userpw = $_POST['Pw'];
$userid = $_POST['Pwchk'];
$userpw = $_POST['Name'];
$userpw = $_POST['Age'];

$result = mysqli_query($con,"insert into custom_info (id,pw,pwchk,name,age) values ('$userid','$userpw','$userpwchk','$username','$userage')");

  if($result){
    echo 'success';
  }
  else{
    echo 'failure';
  }

mysqli_close($con);
?>
