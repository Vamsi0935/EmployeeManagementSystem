package com.codegnan.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.codegnan.beans.Employee;
import com.codegnan.service.EmployeeService;

@WebServlet("/insert")
public class InsertEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(InsertEmployeeServlet.class);
	private EmployeeService employeeService;

	public void init() {
		employeeService = new EmployeeService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.debug("contextPath:::::::::getContextPath:::::::::" + request.getContextPath());

		String action = request.getServletPath();

		logger.debug("action:::::::::getServletPath:::::::::" + action);

		logger.debug("FullName " + request.getParameter("fullname"));
		
		String fullname = request.getParameter("fullname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		Double salary = Double.parseDouble("salary");
		String skills = request.getParameter("skills");
		String role = request.getParameter("role");
		String qualification = request.getParameter("qualification");
		String state = request.getParameter("state");
		Employee employee = new Employee(fullname, gender, email, salary, skills, role, qualification, state);
		employeeService.insertEmployee(employee);

		// response.sendRedirect("/crud");
		response.sendRedirect(request.getContextPath() + "/list");
	}

}