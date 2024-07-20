package com.codegnan.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.codegnan.beans.Employee;
import com.codegnan.service.EmployeeService;

@WebServlet("/list")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;
    private static final Logger logger = Logger.getLogger(EmployeeServlet.class);

	public void init() {
			employeeService = new EmployeeService();	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			logger.debug("contextPath:::::::::getContextPath:::::::::" + request.getContextPath());
			String action = request.getServletPath();
			logger.debug("action:::::::::getServletPath:::::::::" + action);
			List<Employee> listEmployees = employeeService.selectAllEmployee();
			request.setAttribute("listEmployees", listEmployees);
			RequestDispatcher dispatcher = request.getRequestDispatcher("employeeslist.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "An error occurred while processing your request.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
