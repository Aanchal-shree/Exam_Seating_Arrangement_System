<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exam Details</title>
</head>
<body>
	<form action="/viewExamDetails2Page">
		<table>
			<%
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","springuser","ThePassword");

				Statement st=con.createStatement();
				String query="select distinct branch from subject_details";

				ResultSet rs=st.executeQuery(query);
				%>
				
			<tr><td>Branch:</td>
				<td>
		
				
				<select name="branch">
					<option>------</option>
					<%
						if(rs!=null){
							while(rs.next()){
								%>
									<option><%out.println(rs.getString("branch")); %></option>
								<% 
							}
						}
					%>
					
				</select></td>
				<%
				}catch(Exception e){
					
				}
				
			%>
		</tr>
		<%
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","springuser","ThePassword");

				Statement st=con.createStatement();
				String query="select distinct sem from subject_details";

				ResultSet rs=st.executeQuery(query);
				%>
				
			<tr><td>Sem:</td>
				<td>
		
				
				<select name="sem">
					<option>------</option>
					<%
						if(rs!=null){
							while(rs.next()){
								%>
									<option><%out.println(rs.getString("sem")); %></option>
								<% 
							}
						}
					%>
					
				</select></td>
				<%
				}catch(Exception e){
					
				}
				
			%>
		</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
 

		</table>
	</form>
</body>
</html>