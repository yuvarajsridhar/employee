<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></head>
</head>
<div class="alert alert-info">
    <strong>Info!</strong> ${result}
  </div>
<body>
<%= request.getParameter("name")  %>
<form name="employ_form1" method="post" onsubmit="return form_validate()" action="editemployee">
<center><table style="width:30%">
<tr><td><b>Name:</b></td><td><input type="text" name="name" value="<%= request.getParameter("name") %>"  /></td>
</tr>
<tr><td><b><input type="hidden" name="id" value="<%= request.getParameter("id")%>"/></b>
<tr><td><b>Age :</b></td><td><input type="text" name="age" value="<%= request.getParameter("age")%>"/></td>
</tr>
<tr><td><b>Mobile Number :</b></td><td><input type="text" name="mnum" /></td>
</tr>
<tr><td><b>Department :</b></td><td><input type="text" name="department" /></td>
</tr>
<tr><td><b>Address :</b></td><td><input type="text" name="address" value="<%= request.getParameter("address")%>" /></td>
</tr>
<tr><td><b>salary :</b></td><td><input type="text" name="salary" /></td>
</tr>
</table></center>
<center><input type="submit" class="button" value="Update Employee"></center>
</form>
</body>
</html>





