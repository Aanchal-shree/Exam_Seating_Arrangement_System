<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Seat Allotment</title>
</head>
<body>
	<form action="/displayAllotment1Page">
		<table>
			<tr>
				<td>Enter class:</td>
				<td><input type="text" name="class"></td>
			</tr>
			<tr>
			<%	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","springuser","ThePassword");

		Statement st=con.createStatement();
		String query="select distinct date from class_details";
		
		
		ResultSet rs=st.executeQuery(query);
		
		
		%>
				<td>Date</td>
				<td><select name="date">
						<option>------</option>
						<%
				if(rs!=null){
					while(rs.next()){
						%>
						<option>
							<%out.println(rs.getString("date")); %>
						</option>
						<%
							
								}

								}
						}catch(

							Exception e)
							{

							}
						%>
				</select>
			
			<tr>
				<td colspan="2"><input type="submit" value="View allotment"></td>
			</tr>
		</table>
	</form>
</body>
</html>