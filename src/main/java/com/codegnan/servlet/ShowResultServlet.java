package com.codegnan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.codegnan.beans.Employee;
import com.codegnan.dao.EmployeeDAO;

@WebServlet("/showresults")
public class ShowResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(EmployeeServlet.class);

	private EmployeeDAO employeeDAO;

	public void init() {
		employeeDAO = new EmployeeDAO();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.debug("contextPath:::::::::getContextPath:::::::::" + request.getContextPath());
		String action = request.getServletPath();
		logger.debug("action:::::::::getServletPath:::::::::" + action);

		String role = request.getParameter("role");
		List<Employee> employees = employeeDAO.searchEmployee(role);

//		List<Employee> employees = employeeDAO.selectAllEmployees();
//
		request.setAttribute("employees", employees);

		request.getRequestDispatcher("/showresults.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("showresults.jsp").forward(request, response);
	}
}
