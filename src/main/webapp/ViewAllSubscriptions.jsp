<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.LibraryManagemet.model.Subscription, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
	background-image: url("images/image.jpg");
	background-size: cover;
	background-repeat: no-repeat;
	position: relative;
}

body::before {
	content: "";
	background-image: inherit;
	background-size: cover;
	background-repeat: no-repeat;
	filter: blur(2px);
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: -1;
}

.container {
	max-width: 900px;
	padding: 30px;
	background-color: rgba(255, 255, 255, 0.7);
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	padding: 15px;
	text-align: center;
	border: 1px solid #ccc;
}

th {
	background-color: #3366cc;
	color: #fff;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

a {
	display: block;
	margin-top: 20px;
	text-align: center;
	color: #3366cc;
	text-decoration: none;
	font-weight: bold;
	transition: color 0.3s;
}

a:hover {
	color: #005580;
}
</style>
</head>
<body>

	<%
	ArrayList<Subscription> allSubscriptions = Subscription.getAllSubscriptions();
	if (allSubscriptions == null) {
		return;
	}
	%>

	<div class="container">

		<br> <br>
		<%
		if (allSubscriptions.size() == 0) {
		%>
		<h1 align="center">No Subscriptions Made Yet!</h1>
		<%
		return;
		}
		%>

		<h1 align="center">Subscription History</h1>
		<br>
		<table>
			<tr>
				<th>Subscription ID</th>
				<th>User ID</th>
				<th>Amount</th>
				<th>Invoice Number</th>
				<th>Date</th>
			</tr>

			<%
			for (Subscription curSub : allSubscriptions) {
			%>
			<tr>
				<td><%=curSub.getSub_id()%></td>
				<td><%=curSub.getUser_id()%></td>
				<td><%=curSub.getAmount()%></td>
				<td><%=curSub.getInvoice_no()%></td>
				<td><%=curSub.getDate()%></td>
			</tr>
			<%
			}
			%>
		</table>

		<br> <br> <a href="admin.html">Back</a>
	</div>


</body>
</html>