<%@include file="header.html"%>
<%@page import="java.util.ArrayList" %>
<%@ page import="assign.dbaccess.EMailAddressVOO" %>
<!DOCTYPE html>
<html>
<head>
<title>View All Contacts</title>
</head>
<body>

<table  cellpadding="1" cellspacing="5" width="50%"">

<thread>

<tr>
		<th>Email ID</th>
		<th>First Name</th>
		<th>Middle Name</th>
		<th>Last Name </th>
		<th>Home Phone</th>
		<th>Work Phone</th>
		<th> Mobile Phone</th>
		<th>Group</th>
</tr>
</thread>
		<tbody>
		<%
		ArrayList<EMailAddressVOO> list = (ArrayList<EMailAddressVOO>) request.getSession().getAttribute("emaillist");
		if(list != null && !list.isEmpty()) {
			for(EMailAddressVOO email:list){
				
				String groupName = "";
				switch(email.getgroupID()){
				
				case "7":
					groupName="Friends";
				break;	
				
				case "8":
					groupName="Personal";
					break;
				
				case "9":
					groupName="Relatives";
					break;
			}
				%>
				
				<tr>
			<td><%= email.geteMailID() %></td>
			<td><%= email.getfName() %></td>	
			<td><%= email.getmName() %></td>	
			<td><%= email.getlName() %></td>	
			<td><%= email.gethPhone() %></td>	
			<td><%= email.getmPhone() %></td>	
			<td><%= email.getwPhone() %></td>
			<td><%= email.getgroupName() %></td>	
				
			
			</tr>
			<%
			}
			} else {
				%>
				<tr>
				<td colspan="8"> No Contacts Found..</td>
				</tr>
				<%
			}
				%>
			
		
		</tbody>




<center>
<h2>View All Contacts</h2>
</center>
<!--Body: view all information-->
<center>
<form method="post" action="/mysite/servlet/viewall">
	<table  cellpadding="0" cellspacing="0" width="50%"">
		<tr>
			<td bgcolor="#FAFAF9" style="padding-left: 10px;">E-mail</td>
			<td><input type="text" name="emailid" maxlength="50" value="" /></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			<br>
			<table  width="50%">
				<tr>
					<td><input type="submit" name="save" value="View All"/></td>
					<td width="201"><input type="reset" name="clear" value="Clear" />&nbsp;</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
</form>
</center>
</body>

	

</html>
<%@include file="footer.html"%>

</body>
