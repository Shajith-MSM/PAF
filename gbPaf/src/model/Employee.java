package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employee {
	
	private Connection connect()
	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.cj.jdbc.Driver");

	 //Provide the correct details: DBServer/DBName, username, password
	 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/gb_db?serverTimezone=UTC","root","");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 }
	public String insertEmployee(String eid, String ename, String salary, String dep,String proj,String skill)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for inserting."; }
	 // create a prepared statement
	 String query = " insert into employees(`ID`,`empId`,`empName`,`empSalary`,`department`,`project`,`skill`)"
	 + " values (?, ?, ?, ?, ?,?,?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, eid);
	 preparedStmt.setString(3, ename);
	 preparedStmt.setDouble(4, Double.parseDouble(salary));
	 preparedStmt.setString(5, dep);
	 preparedStmt.setString(6, proj);
	 preparedStmt.setString(7, skill);
	// execute the statement

	 preparedStmt.execute();
	 con.close();
	 output = "Inserted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while inserting the employee.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	public String readEmployees()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	 // Prepare the html table to be displayed
	 output = "<table border='1'><tr><th>Employee ID</th><th>Employee Name</th>" +
	 "<th>Employee Salary</th>" +
	 "<th>Working Department</th>" +"<th>Working Project</th>" +"<th>Employee Skills</th>" +
	 "<th>Update</th><th>Remove</th></tr>";

	 String query = "select * from employees";
	 Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
	 String ID = Integer.toString(rs.getInt("ID"));
	 String empId = rs.getString("empId");
	 String empName = rs.getString("empName");
	 String empSalary = Double.toString(rs.getDouble("empSalary"));
	 String department = rs.getString("department");
	 String project = rs.getString("project");
	 String skill = rs.getString("skill");
	 // Add into the html table
	 output += "<tr><td>" + empId + "</td>";
	 output += "<td>" + empName + "</td>";
	 output += "<td>" + empSalary + "</td>";
	 output += "<td>" + department + "</td>";
	 output += "<td>" + project + "</td>";
	 output += "<td>" + skill + "</td>";
	 // buttons
	 output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
	 + "<td><form method='post' action='employees.jsp'>"
	 + "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
	 + "<input name='ID' type='hidden' value='" + ID
	 + "'>" + "</form></td></tr>";
	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	 catch (Exception e)
	 {
	 output = "Error while reading the employees.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	public String updateEmployee(String ID, String eid, String ename, String salary, String dep,String proj,String skill)

	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for updating."; }
	 // create a prepared statement
	 String query = "UPDATE employees SET empId=?,empName=?,empSalary=?,department=?,project=?,skill=?   WHERE ID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setString(1, eid);
	 preparedStmt.setString(2, ename);
	 preparedStmt.setDouble(3, Double.parseDouble(salary));
	 preparedStmt.setString(4, dep);
	 preparedStmt.setString(5, proj);
	 preparedStmt.setString(6, skill);
	 preparedStmt.setInt(7, Integer.parseInt(ID));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Updated successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while updating the employee.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	public String deleteEmployee(String ID)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for deleting."; }
	 // create a prepared statement
	 String query = "delete from employees where ID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(ID));
	 // execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Deleted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while deleting the employee.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }

}
