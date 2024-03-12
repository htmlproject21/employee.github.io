<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ page import="  java.util.* , java.util.List ,com.tap.EmployeeBoImpl , com.tap.Employee" %>  
    
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
body{

background-image :url(Images/myimg1.png);
background-size : cover;
}
div{
background-color :yellow;
margin:100px 500px;
padding:50px
}
footer a{
	text-decoration: none;
	font-size: 30px;
	padding: 5px;
	background-color: cyan;
	border-radius: 10px;
	
}

</style>
<title>Insert title here</title>
</head>

<body>


<center>
<div>
<h1>Database Data</h1>

<table border="5px">
<tr> 
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Department</th>
<th>Salary</th>
</tr>
<%
EmployeeBoImpl a = new EmployeeBoImpl();
List<Employee> dataList = a.getAll();

for(Employee item : dataList){
%>

<tr>
<td><%= item.getId() %></td>
<td><%= item.getName() %></td>
<td><%= item.getEmail() %></td>
<td><%= item.getDepartment() %></td>
<td><%= item.getSalary() %></td>

</tr>
<%
}
%>

</table>
</div>
</center>

</body>

<center>
	<footer><a href="index.html">Home</a></footer>
</center>
</html>