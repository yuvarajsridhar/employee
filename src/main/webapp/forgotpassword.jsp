<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Forgot Password</title>
<style>
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 6px 12px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
</style><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="alert alert-info">
    <strong></strong> ${result}
  </div>
    <form  name="forgot_password_form" method=post action="forgotpassword">
    <center><table>
    <tr>
    <td></td>
    <td></td>
    </tr>
    <tr>
<td><b>Registered EmailId</b></td>
<td><input type="text" class="form-control" id= "ex3" name="username" ></td>
</tr>
<tr>
<td></td>
</tr>
<tr>
<td><b>code</b></td>
<td><input type="text" class="form_control" id="ex3" name="code"></td>
</tr>
<tr>
<td><b>New Password</b></td>
<td><input type="password" class="form_control" id="ex3" name="password"></td>
</tr>
</table></center>
<center><input type="submit" value="Reset password" class="button"></center>
</form>
</body>
</html>