package com.codegnan.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.codegnan.beans.Employee;
import com.codegnan.service.EmployeeService;

@WebServlet("/edit")
public class ShowEmployeeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ShowEmployeeEditServlet.class);

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
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existingEmployee = null;

		existingEmployee = employeeService.selectEmployee(id);

		RequestDispatcher dispatcher = request.getRequestDispatcher("updateemployeeform.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);

	}

}