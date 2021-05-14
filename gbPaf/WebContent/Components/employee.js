/**
 * 
 */

$(document).ready(function()
{
if ($("#alertSuccess").text().trim() == "")
 {
 $("#alertSuccess").hide();
 }
 $("#alertError").hide();
});
// SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
// Clear alerts---------------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();
// Form validation-------------------
var status = validateEmployeeForm();
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }
// If valid------------------------
var type = ($("#hidIDSave").val() == "") ? "POST" : "PUT";
 $.ajax(
 {
 url : "EmployeeAPI",
 type : type,
 data : $("#formEmployee").serialize(),
 dataType : "text",
 complete : function(response, status)
 {
  location.reload(true);
 onItemSaveComplete(response.responseText, status);

 }
 }); 
});
// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
$("#hidIDSave").val($(this).data("itemid"));
 $("#empId").val($(this).closest("tr").find('td:eq(0)').text());
 $("#empName").val($(this).closest("tr").find('td:eq(1)').text());
 $("#empSalary").val($(this).closest("tr").find('td:eq(2)').text());
 $("#department").val($(this).closest("tr").find('td:eq(3)').text());
 $("#project").val($(this).closest("tr").find('td:eq(4)').text());
 $("#skill").val($(this).closest("tr").find('td:eq(5)').text());
});

$(document).on("click", ".btnRemove", function(event)
{
 $.ajax(
 {
 url : "EmployeeAPI",
 type : "DELETE",
 data : "ID=" + $(this).data("id"),
 dataType : "text",
 complete : function(response, status)
 {

  location.reload(true);
 onItemDeleteComplete(response.responseText, status);

 }
 });
});

// CLIENT-MODEL================================================================
function validateEmployeeForm()
{
// ID
if ($("#empId").val().trim() == "")
 {
 return "Insert Employee ID.";
 }
// NAME
if ($("#empName").val().trim() == "")
 {
 return "Insert Employee Name.";
 } 

// Salary-------------------------------
if ($("#empSalary").val().trim() == "")
 {
 return "Insert Employee Salary.";
 }
// is numerical value
var tmpSalary = $("#empSalary").val().trim();
if (!$.isNumeric(tmpSalary))
 {
 return "Insert a numerical value for Employee salary.";
 }
// convert to decimal price
 $("#empSalary").val(parseFloat(tmpSalary).toFixed(2));
// DEPARTMENT------------------------
if ($("#department").val().trim() == "")
 {
 return "Insert Employee's Department.";
 }
 // project------------------------
if ($("#project").val().trim() == "")
 {
 return "Insert Employee's working project.";
 }
 // skill------------------------
if ($("#skill").val().trim() == "")
 {
 return "Insert Employee's skills.";
 }
return true;
}

function onEmployeeSaveComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully saved.");
 $("#alertSuccess").show();
 $("#divItemsGrid").html(resultSet.data);

 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while saving.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while saving..");
 $("#alertError").show();
 } 

 $("#hidItemSave").val("");
 $("#formEmployee")[0].reset();
}

function onEmployeeDeleteComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully deleted.");
 $("#alertSuccess").show();
 $("#divItemsGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while deleting.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while deleting..");
 $("#alertError").show();
 }
}   
 