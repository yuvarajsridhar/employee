<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Employee details</title>
<style>
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 3px 6px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 2px 1px;
    cursor: pointer;
}
</style>
</head>
<body>
<b>${result }</b>

<center><b>Employee details:</b></center>
<center><table class="table">
<tr>
<td>Name</td>
<td>Age</td>
<td>Mobile Number</td>
<td>Department</td>
<td>Address</td>
<td>salary</td>
</tr>
<c:forEach items="${list}" var="temp">
<tr>
<td>${temp.name}</td>
<td>${temp.age}</td>
<td>${temp.mnum }</td>
<td>${temp.department }</td>
<td>${temp.address }</td>
<td>${temp.salary }</td> 
 
<td><a href="editemployee.jsp?id=${temp.id }&amp;name=${temp.name }&amp;age=${temp.age}&amp;address=${temp.address}" class="button"><b>Edit </b></a></td>
<td><a href="./deleteemployee?id=${temp.id }" class="button"><b>Delete </b></a></td>

</tr>
 </c:forEach>
</table></center>
</body>
</html>