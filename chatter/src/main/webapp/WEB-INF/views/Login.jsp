<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chatter</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function () {
   $('#exist').show();
    $('#new').hide();
   $("#hideshow").click(function(){
       $("#exist").show();
      $("#new").hide();
});
     $("#newhideshow").click(function(){
      $("#exist").hide();
      $("#new").show();
});
});
</script>
</head>

<body>
<div id='container'>
<h1>Chatter</h1>

<b><input type='button' id='hideshow' value='Existing User Login'></b><br>
<div id="exist">
<form action="Authorization" method="post">
<table>
<tr><td>Username:</td><td><input type="text" name="username"></td></tr>
<tr><td>Password:</td><td><input type="password" name="password"></td></tr>
</table>
<input type="submit" value="Login">
</form>
</div>

<p><b><input type='button' id='newhideshow' value='New User Registration'></b><br>
<div id="new">
	<form action="Registration" method="post">
<table>
	<tr>
		<td>First Name:</td>
		<td> <input type="text" name="firstName"></td>
	</tr>
	<tr>
		<td>Last Name:</td>
		<td> <input type="text" name="lastName"></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td> <input type="text" name="emailAddress"></td>
	</tr>
	<tr>
		<td>Username:</td>
		<td> <input type="text" name="username"></td>
	</tr>
	<tr>
		<td>Password:</td>
		<td> <input type="password" name="password"></td>
	</tr>
	<tr>
		<td>Confirm Password:</td>
		<td> <input type="password" name="NCpasssword"></td>
	</tr>
	
	</table>
<input type="submit" value="Register">
</form>
</div>


</div>
</body>
</html>