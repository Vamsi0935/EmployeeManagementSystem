package com.codegnan.servlet;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.codegnan.beans.Employee;
import com.codegnan.dao.EmployeeDAO;
import com.codegnan.service.EmployeeService;

@WebServlet("/search")
public class SearchEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SearchEmployeeServlet.class);

	private EmployeeService employeeService;

	public void init() {
		employeeService = new EmployeeService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		logger.debug("contextPath:::::::::getContextPath:::::::::" + request.getContextPath());
		String action = request.getServletPath();
		logger.debug("action:::::::::getServletPath:::::::::" + action);

		/*
		 * String fullname = request.getParameter("fullname"); String skills =
		 * request.getParameter("skills"); String role = request.getParameter("role");
		 */
		String role = request.getParameter("search");

		List<Employee> employees = employeeService.searchEmployee(role);

		request.setAttribute("listEmployees", employees);

		request.getRequestDispatcher("/searchemployee.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/showresults.jsp");

	}
}
