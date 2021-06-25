<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>HealthCare</title>
<link rel="stylesheet" href="mainmenu.css">
<link
	href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@400;600&display=swap"
	rel="stylesheet">
<link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
</head>

<body>
	<div class="wrapper">
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

		<!-- LANDING PAGE -->
		<!DOCTYPE html>
		<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Add icon library -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
#table {
	margin-left: auto;
	margin-right: auto;
	font-family: Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 75%;
	box-shadow: 5px 7px 20px 0px #c5c0c0;
}

#table td, tr, th {
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

body {
	font-family: Arial, Helvetica, sans-serif;
}

* {
	box-sizing: border-box;
}

.input-container {
	display: -ms-flexbox;
	/* IE10 */
	display: flex;
	width: 100%;
	margin-bottom: 15px;
}

.icon {
	padding: 10px;
	background: rgb(26, 58, 90);
	color: rgb(233, 119, 119);
	min-width: 50px;
	text-align: center;
}

.input-field {
	width: 100%;
	padding: 10px;
	outline: none;
}

.input-field:focus {
	border: 2px solid rgb(46, 8, 47);
}

/* Set a style for the submit button */
.btn {
	background-color: rgb(39, 107, 45);
	color: rgb(223, 232, 236);
	padding: 15px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.btn:hover {
	opacity: 1;
}
</style>
</head>

<body>
	<%
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MYDB", "admin");
		if (con == null)
			out.println("connect not created");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select count(*) from LABTEST");
		while (rs.next()) {
	%>
	<h2 style="color: red; text-align: center;">
		You have Pending Lab Test Booking:
		<%=rs.getString(1)%></h2>

	<%
		}

	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
	<hr />

	<table id="table">
		<tbody>
			<tr style="height: 25px;">
				<th style="width: 107.547px; height: 25px;">Patient Name:</th>
				<th style="width: 107.547px; height: 25px;">Contact No.:</th>
				<th style="width: 107.547px; height: 40.4844px;">Reffered by:</th>
				<th style="width: 107.547px; height: 25px;">Date:</th>
				<th style="width: 107.547px; height: 25px;">Lab:</th>
				<th style="width: 107.547px; height: 25px;">Test:</th>
			</tr>
			<%
				try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "MYDB", "admin");
				if (con == null)
					out.println("connect not created");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from LABTEST");
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


	<form name="myForm" method="post" action="Labtestservlet"
		style="max-width: 500px; margin: auto">
		<h2 style="text-align: center;">Lab Test Booking Form</h2>

		<div class="input-container">
			<i class="fa fa-user icon"></i> <input class="input-field"
				type="text" required placeholder="Pateint Name" name="nm">
		</div>
		<div class="input-container">
			<i class="fa fa-mobile-phone icon"></i> <input class="input-field"
				type="number" required placeholder="Contact No." name="phn">
		</div>

		<div class="input-container">
			<i class="fa fa-user icon"></i> <input class="input-field"
				type="text" required placeholder="Reffered by Dr." name="dr">
		</div>
		<div class="input-container">
			<i class="fa fa-calendar icon"></i> <input class="input-field"
				type="date" name="date">
		</div>
		<div class="input-container">
			<i class="fa fa-hospital-o icon"></i> <select name="lab"
				class="text-name" id="bed" required onchange="getAvail()"
				style="width: 100%">
				<option disabled selected>------ Select a Lab ------</option>
				<option value="Thyrocare Kolkata">1. Thyrocare Kolkata</option>
				<option value="Doyen">2. Doyen</option>
				<option value="Dr. Lalpathlabs">3. Dr. Lalpathlabs</option>
				<option value="Drs. Tribedi & Roy">4. Drs. Tribedi & Roy</option>
				<option value="Serum">5. Serum</option>
				<option value="SRL">6. SRL</option>
			</select>
		</div>
		<div class="input-container">
			<i class="fa fa-eyedropper icon"></i> <input class="input-field"
				type="text" required placeholder="Test1" name="tst1">
		</div>
		<div class="input-container">
			<i class="fa fa-eyedropper icon"></i> <input class="input-field"
				type="text" placeholder="Test2" name="tst2">
		</div>
		<div class="input-container">
			<i class="fa fa-eyedropper icon"></i> <input class="input-field"
				type="text" placeholder="Test3" name="tst3">
		</div>



		<button type="submit" onclick="book()" class="btn">Book Now</button>
	</form>



</body>

		</html>

		<!-- BANNER AND FOOTER -->

		<br> <br> <br> <br> <br> <br>

		<div class="footer">
			<h2>Phoenix HealthCare</h2>
			<div class="footerlinks">
				<a href="#" class="mainlink">Covid-19 Updates</a> <a href="#">Help</a>
				<a href="#">About</a> <a href="#">Contact Us</a> <a
					href="index.html">Log Out</a>
			</div>
		</div>

<script>
   function book() {
    	  var x = document.forms["myForm"]["nm"].value;
    	  if (x == "") 
    	    alert("Fill Up the form");
    	  else
        	alert("Booking Confirmed!!");
      }
 </script>

		<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
		<script>
      AOS.init();
    </script>
</body>

</html>