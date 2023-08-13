<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="com.digit.javaTraining.LibraryManagemet.model.Book, java.util.ArrayList"%>
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
	ArrayList<Book> allBooks = Book.getAllBooks();
	if (allBooks == null) {
		return;
	}
	%>

	<div class="container" align="center">

		<br> <br>
		<%
		if (allBooks.size() == 0) {
		%>
		<h1 align="center">No Books are Available!</h1>
		<%
		return;
		}
		%>

		<h1 align="center">All Books</h1>
		<br>
		<table>
			<tr>
				<th>Book ID</th>
				<th>Book Name</th>
				<th>Book Author</th>
				<th>Book Category</th>
				<th>Cost</th>
			<tr>
				<%
				for (Book curbook : allBooks) {
				%>
			
			<tr>
				<th><%=curbook.getBid()%></th>
				<th><%=curbook.getBname()%>
				<th><%=curbook.getAuthor()%></th>
				<th><%=curbook.getCategory()%></th>
				<th><%=curbook.getCost()%></th>
			</tr>
			<%
			}
			%>
		</table>

		<br>

		<form action="purchaseBook" method="post">

			<label>Enter All Book ID's you want to Purchase (Comma
				Separated): </label><br><br> <input type="text" name="booksList" required>
			<br><br>
			<input type="submit">

		</form>

		<br> <br> <a href="admin.html">Back</a>
	</div>

</body>
</html>