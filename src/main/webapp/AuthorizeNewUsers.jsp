<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.LibraryManagemet.model.User, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
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
	session = request.getSession();
	int curIndex = (session.getAttribute("curIndex") != null) ? (int) session.getAttribute("curIndex") : 0;

	if (session.getAttribute("allUnAuthorizedUsers") == null) {
		ArrayList<User> allUnAuthorizedUsers = User.getAllUnAuthorizedUsers();
		if (allUnAuthorizedUsers.size() == 0) {
			response.sendRedirect("/LMS/admin.html");
			return;
		}
		session.setAttribute("allUnAuthorizedUsers", allUnAuthorizedUsers);
	}

	ArrayList<User> allUnAuthorizedUsers = (ArrayList<User>) session.getAttribute("allUnAuthorizedUsers");

	if (curIndex >= allUnAuthorizedUsers.size()) {
		session.removeAttribute("curIndex");
		session.removeAttribute("allUnAuthorizedUsers");
		response.sendRedirect("/LMS/admin.html");
		return;
	}

	User curUser = allUnAuthorizedUsers.get(curIndex);
	curIndex++;
	session.setAttribute("curIndex", curIndex);
	%>


	<div class="container">
		<h2 align="center">Current User</h2>
		<br> <br>
		<p>
			User ID:
			<%=curUser.getUid()%></p>
		<p>
			User Name:
			<%=curUser.getUname()%></p>
		<p>
			User Address:
			<%=curUser.getAddr()%></p>
		<p>
			User Phone:
			<%=curUser.getPhone()%></p>
		<p>
			User Email:
			<%=curUser.getEmail()%></p>
		<br>

		<h3>Manage Request</h3>
		<form action="authorizeNewUser" method="post">

			<select id="operation" name="operation">
				<option value="Approve">Approve Request</option>
				<option value="Skip">Skip Request</option>
			</select> <input type="submit">

		</form>
		<br> <br> <a href="admin.html">Back To Menu</a>
	</div>

</body>
</html>