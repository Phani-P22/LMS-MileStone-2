<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.LibraryManagemet.model.PurchaseHistory, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="Keywords" content="html, css, html tables, table">
<meta name="Description" content="html table">
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
	ArrayList<PurchaseHistory> allPurchasesHistory = PurchaseHistory.getAllPurchasesHistory();
	if (allPurchasesHistory == null) {
		return;
	}
	%>


	<div class="container">

		<br> <br>
		<%
		if (allPurchasesHistory.size() == 0) {
		%>
		<h1 align="center">No Purchases Made Yet!</h1>
		<%
		return;
		}
		%>

		<h1 align="center">Purchase History</h1>
		<br>
		<table>
			<tr>
				<th>Purchase ID</th>
				<th>Book ID</th>
				<th>Book Name</th>
				<th>UID</th>
				<th>Amount</th>
				<th>Invoice Number</th>
			</tr>

			<%
			for (PurchaseHistory curPur : allPurchasesHistory) {
			%>
			<tr>
				<td><%=curPur.getPid()%></td>
				<td><%=curPur.getBook_id()%></td>
				<td><%=curPur.getBname()%></td>
				<td><%=curPur.getUid()%></td>
				<td><%=curPur.getAmount()%></td>
				<td><%=curPur.getInvoice_no()%></td>
			</tr>
			<%
			}
			%>
		</table>

		<br> <br> <a href="admin.html">Back</a>
	</div>

</body>
</html>
