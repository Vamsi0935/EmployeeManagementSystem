<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/ccms.css">

</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #1E2C76">
			<div>
				<img src="<c:url value='images/2.png'/>" alt="Logo">
			</div>
			<div class="navbar-brand">Employee Management System</div>
			<div class="ml-auto">
				<a href="<c:url value='/new' />" class="btn btn-success">Add New
					Employee</a>
			</div>
			<div>
				<form class="form-inline mx-3 my-lg-0" method="post"
					action="search">
					<input class="form-control mr-sm-2" placeholder="Search role"
						type="text" name="search" required />
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
						value="search">Search</button>
				</form>
			</div>
			<div class="ml-auto">
				<a href="<c:url value='/logout' />" class="btn btn-danger">Logout</a>
			</div>
		</nav>
	</header>
	<br>
	<div class="containertab">
		<h3 class="text-center">Employees List</h3>
		<%-- <hr>
        <div class="container text-left">
            <a href="<c:url value='/new' />" class="btn btn-success">Add New Candidate</a>
        </div> --%>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr class="text-center">
					<th>ID</th>
					<th>Full Name</th>
					<th>Gender</th>
					<th>Email</th>
					<th>Salary</th>
					<th>Skills</th>
					<th>Role</th>
					<th>Qualification</th>
					<th>State</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${listEmployees}">
					<tr>
						<td><c:out value="${employee.id}" /></td>
						<td><c:out value="${employee.fullname}" /></td>
						<td><c:out value="${employee.gender}" /></td>
						<td><c:out value="${employee.email}" /></td>
						<td><c:out value="${employee.salary}"/></td>
						<td><c:out value="${employee.skills}" /></td>
						<td><c:out value="${employee.role}" /></td>
						<td><c:out value="${employee.qualification}" /></td>
						<td><c:out value="${employee.state}" /></td>
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
