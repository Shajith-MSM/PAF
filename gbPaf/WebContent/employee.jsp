<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Employee"%>
<%
//Save---------------------------------
if (request.getParameter("empId") != null)
{
Employee empObj = new Employee();
String stsMsg = "";
//Insert--------------------------
if (request.getParameter("hidIDSave") == "")
{
stsMsg = empObj.insertEmployee(request.getParameter("empId"),
request.getParameter("empName"),
request.getParameter("empSalary"),
request.getParameter("department"),
request.getParameter("project"),
request.getParameter("skill"));
}
else//Update----------------------
{
stsMsg = empObj.updateEmployee(request.getParameter("hidIDSave"),
request.getParameter("empId"),
request.getParameter("empName"),
request.getParameter("empSalary"),
request.getParameter("department"),
request.getParameter("project"),
request.getParameter("skill"));
}
session.setAttribute("statusMsg", stsMsg);
}
//Delete-----------------------------
if (request.getParameter("hidIDDelete") != null)
{
Employee empObj = new Employee();
String stsMsg =
empObj.deleteEmployee(request.getParameter("hidIDDelete"));
session.setAttribute("statusMsg", stsMsg);
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Views/bootstrap.min.css">

<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/employee.js"></script>
<title>Employee Management</title>
</head>
<body>
<h1>Employee Management</h1>

<form id="formEmployee" name="formEmployee" method="post" action="employee.jsp">
 Employee ID:
<input id="empId" name="empId" type="text"
 class="form-control form-control-sm">
<br> Employee name:
<input id="empName" name="empName" type="text"
 class="form-control form-control-sm">
<br> Employee Salary:
<input id="empSalary" name="empSalary" type="text"
 class="form-control form-control-sm">
<br> Employee department:
<input id="department" name="department" type="text"
 class="form-control form-control-sm">
<br>
<br> Working project:
<input id="project" name="project" type="text"
 class="form-control form-control-sm">
<br>
<br> Employee Skill:
<input id="skill" name="skill" type="text"
 class="form-control form-control-sm">
<br>
<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
<input type="hidden" id="hidIDSave" name="hidIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>

<%
 out.print(session.getAttribute("statusMsg"));
%>
<br>
<div id="divEmployeeGrid">
<%

Employee empObj = new Employee();
out.print(empObj.readEmployees());
%>
</div>
</body>
</html>