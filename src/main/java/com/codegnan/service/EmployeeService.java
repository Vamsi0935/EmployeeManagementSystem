package com.codegnan.service;

import java.util.List;
import com.codegnan.beans.Employee;
import com.codegnan.dao.EmployeeDAO;

public class EmployeeService {
	private EmployeeDAO employeeDAO;

	public EmployeeService() {
		this.employeeDAO = new EmployeeDAO();
	}

	public void insertEmployee(Employee employee) {
		employeeDAO.insertEmployee(employee);
	}

	public Employee selectEmployee(int id) {
		return employeeDAO.selectEmployee(id);
	}

	public List<Employee> selectAllEmployee() {
		return employeeDAO.selectAllEmployees();
	}

	public boolean deleteEmployee(int id) {
		return employeeDAO.deleteEmployee(id);
	}

	public boolean isValidUser(String username, String password) {
		return employeeDAO.isValidUser(username, password);
	}

	public boolean updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	public List<Employee> searchEmployee(String role) {
		return employeeDAO.searchEmployee(role);
	}
}
