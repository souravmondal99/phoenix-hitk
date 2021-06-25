<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation Page</title>

<link rel="stylesheet" href="mainmenu.css">

<style>
#table {
	margin-left: auto;
	margin-right: auto;
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 75%;
}

#table td, tr,th {
	text-align: center;
	border: 1px solid #ddd;
	padding: 8px;
}

#table tr {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #04AA6D;
	color: white;
}
button {
	background-color: yellow;
  margin:auto;
  display:block;
  margin-bottom:20px
}
</style>
</head>
<body>



	<div class="nav">
		<div class="logo">
			<h4>Phoenix HealthCare</h4>
		</div>
		<div class="links">
			<a href="#" class="mainlink">Covid-19 Updates</a> <a href="#">Help</a>
			<a href="#">About</a> <a href="#">Contact Us</a> <a class="btn"
				href="MainMenu.html">Back to Dashboard</a> <a class="btn"
				href="index.html">Log Out</a>
		</div>
	</div>
	<p>&nbsp;</p>
	<h2 style="text-align: center;">Nurse / HealthCare Worker Hiring
		Confirmation&nbsp;</h2>
	<hr />

	<table id="table">
		<tbody>
			<tr style="height: 25px;">
				<th style="width: 107.547px; height: 25px;">Patient Name</th>
				<th style="width: 107.547px; height: 25px;">Contact No.</th>
				<th style="width: 107.547px; height: 40.4844px;">Address:</th>
				<th style="width: 107.547px; height: 25px;">Nurses / Healthcare</th>
				<th style="width: 107.547px; height: 25px;">Patient's Disease</th>
				<th style="width: 107.547px; height: 25px;">Working Hours</th>
			</tr>
								<%
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MYDB", "admin");
		if (con == null)
			out.println("connect not created");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from NURSEBOOK");
		while (rs.next()) {
	%>
			<tr style="height: 25px;">

				<td style="width: 96.4531px; height: 25px;"><%=rs.getString(1)%></td>
				<td style="width: 96.4531px; height: 25px;"><%=rs.getString(2)%></td>
				<td style="width: 96.4531px; height: 40.4844px;"><%=rs.getString(3)%></td>
				<td style="width: 96.4531px; height: 25px;"><%=rs.getString(4)%></td>
				<td style="width: 96.4531px; height: 25px;"><%=rs.getString(5)%></td>
				<td style="width: 96.4531px; height: 25px;"><%=rs.getString(6)%></td>
			</tr>
				<%
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
			
			
		</tbody>
	</table>
	<br>
	<br>
	<h2 style="text-align: center;">
		<strong>You've Successfully booked!</strong>
	</h2>
	<br>
	<h4 style="text-align: center;">
		Thank you for using<strong> Phoenix HealthCare</strong>
	</h4>
	<div class="links">
		<button  onclick="window.print()">Print this page</button>
	</div>

</body>
</html>