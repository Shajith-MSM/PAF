package com;



import model.Employee;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;



@Path("/Employees")
public class EmployeeService {

	Employee empObj = new Employee();
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readEmployees()
	 {
	 return empObj.readEmployees();
	 }


	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertEmployee(@FormParam("empId") String empId,
	 @FormParam("empName") String empName,
	 @FormParam("empSalary") String empSalary,
	 @FormParam("department") String department,
	 @FormParam("project") String project,
	 @FormParam("skill") String skill)
	{
	 String output = empObj.insertEmployee(empId, empName, empSalary, department,project,skill);
	return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateEmployee(String empData)
	{
	//Convert the input string to a JSON object
	 JsonObject empObject = new JsonParser().parse(empData).getAsJsonObject();
	//Read the values from the JSON object
	 String ID = empObject.get("ID").getAsString();
	 String empId = empObject.get("empId").getAsString();
	 String empName = empObject.get("empName").getAsString();
	 String empSalary = empObject.get("empSalary").getAsString();
	 String department = empObject.get("department").getAsString();
	 String project = empObject.get("project").getAsString();
	 String skill = empObject.get("skill").getAsString();
	 String output = empObj.updateEmployee(ID,empId, empName, empSalary, department,project,skill);
	return output;
	}


	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployee(String empData)
	{
	//Convert the input string to an XML document
	 Document doc = Jsoup.parse(empData, "", Parser.xmlParser());

	//Read the value from the element <itemID>
	 String ID = doc.select("ID").text();
	 String output = empObj.deleteEmployee(ID);
	return output;
	}

	
}
