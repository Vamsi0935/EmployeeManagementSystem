<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Search Results</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/ccms.css">
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	padding: 5px;
}
</style>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #1E2C76">
			<div>
				<img src="<c:url value='images/2.png'/>" alt="Logo">
			</div>
			<h2 class="navbar-brand">Employee Search Results</h2>
			<div class="ml-auto">
				<a href="<%=request.getContextPath()%>/list" class="nav-link"
					style="color: #fff; font-weight: bold; background-color: green; padding: 10px 20px; border-radius: 5px;">Back
					to Employee List</a>
			</div>
			
			<div class="ml-auto">
				<a href="<c:url value='/logout' />" class="btn btn-danger">Logout</a>
			</div>
		</nav>
	</header>
	<br>
	<div class="containertab">
		<h3 class="text-center">Employees Search List</h3>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr class="text-center">
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Salary</th>
					<th>Skills</th>
					<th>Role</th>
				</tr>
			</thead>
			<%-- <% 
            List<Employee> employees = (List<Employee>) request.getAttribute("employees");
            for (Employee emp : employees) {
        %>
        <tr>
            <td><%= emp.getId() %></td>
            <td><%= emp.getName() %></td>
            <td><%= emp.getSkills() %></td>
        </tr>
        <% } %> --%>
			<tbody>
				<c:forEach var="employee" items="${listEmployees}">
					<tr>
						<td><c:out value="${employee.id}" /></td>
						<td><c:out value="${employee.fullname}" /></td>
						<td><c:out value="${employee.email}"/></td>
						<td><c:out value="${employee.salary}"/></td>
						<td><c:out value="${employee.skills}" /></td>
						<td><c:out value="${employee.role}" /></td>
						<td><a href="<c:url value='/edit?id=${employee.id}' />"
							class="btn btn-primary">Edit</a> <a
							href="<c:url value='/delete?id=${employee.id}' />"
							class="btn btn-danger">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
