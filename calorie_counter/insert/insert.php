<?php

  $bFoodAdd = $_POST["bFoodAdd"];
  $bCalAdd = $_POST["bCalAdd"];

  $servername = "127.0.0.1:3306";
  // $username = "muchen";
  // $password = "0zXLUTjMC2wUz88P";
  // $dbname = "Calories";
  $username = 'root';
  $password = '';
  $host = 'localhost';       // e.g., 'cs4750:us-east4:db-demo'; 
  $dbname = 'calories';           // e.g., 'guestbook';
  $dsn = "mysql:host=127.0.0.1:3306;dbname=calories"; 

  // $conn = new PDO($dsn, $username, $password);
  $conn = new mysqli($servername, $username, $password, $dbname);
  if ($conn->connect_error){
    die("Connection failed: ". $conn->connect_error);
  }

  $sql = "INSERT INTO breakfastFood (food, calories) VALUES ('$bFoodAdd', '$bCalAdd')";
  if(!mysqli_query($conn, $sql)){
    echo "Not inserted";
  }
  else{
    echo "Successfully inserted";
  }

  header("refresh:1; url=../index.php");

?>
