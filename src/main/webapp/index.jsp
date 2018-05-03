<html>
<head>
<style>
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
     content="353866938870-qkhciehc1250flvu0r91pi2kr2o3ckbs.apps.googleusercontent.com">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></head>
<body>
<b>${result}</b>
<center><b>Trichrome technologies employees </b></center>
<form name="employ_form" method="post" onsubmit="return form_validate()" action="addEmployee">
 <center><table style="width:30%">
<tr><td><b>Name:</b></td><td><input type="text" name="name" required/></td>
</tr>
<tr><td><b>Age :</b></td><td><input type="text" name="age" required/></td>
</tr>
<tr><td><b>Mobile Number :</b></td><td><input type="text" name="mnum" required/></td>
</tr>
<tr><td><b>Department:</b></td><td><input type="text" name="Department" required/></td>
</tr>
<tr><td><b>Address :</b></td><td><input type="text" name="address" required/></td>
</tr>
<tr><td><b>salary :</b></td><td><input type="text" name="salary" required/></td>
</tr>
<tr><td><b>admin:</b></td>
<td><input type="text" name="admin" ></td></tr>
<tr><td><b>Email</b></td>
<<td><input type="text" name="email" ></td></tr>
<tr><td><b>Password</b></td>
<td><input type="password" name="password"></td></tr>
</table></center>
<center><input type="submit" class="button" value="Add Employee">
<a href="./viewemployee" class="button"><b>View Employee</b></a></center>
</form>
<a href="#" onclick="signOut();">Sign out</a>
<script>
  function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
    });
  }
</script>
</body>
</html>
