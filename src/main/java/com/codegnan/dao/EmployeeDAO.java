package com.codegnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.codegnan.beans.Employee;
import com.codegnan.helper.ConnectionManager;
import com.mysql.cj.xdevapi.Statement;

public class EmployeeDAO {
	private static final Logger logger = Logger.getLogger(EmployeeDAO.class);

	private static final String INSERT_EMPLOYEES_SQL = "INSERT INTO employee (fullname, gender, email, salary, skills, role, qualification, state) VALUES (?, ?, ?, ?, ?, ?, ?);";
	private static final String SELECT_EMPLOYEE_BY_ID = "SELECT id, fullname, gender, email, salary, skills, role, qualification, state FROM employee WHERE id = ?";
	private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM employee";
	private static final String DELETE_EMPLOYEES_SQL = "DELETE FROM employee WHERE id = ?;";
	private static final String UPDATE_EMPLOYEES_SQL = "UPDATE employee SET fullname = ?, gender = ?, email = ?,salary = ?, skills = ?, role = ?, qualification = ?, state = ? WHERE id = ?;";
	private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ? AND password = ?;";
	private static final String SELECT_SEARCH_EMPLOYEES = "SELECT id, fullname, email, salary, skills, role FROM employee WHERE role = ?";

	public void insertEmployee(Employee employee) {
		try (Connection con = ConnectionManager.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(INSERT_EMPLOYEES_SQL)) {
			ps.setString(1, employee.getFullname());
			ps.setString(2, employee.getGender());
			ps.setString(3, employee.getEmail());
			ps.setDouble(4, employee.getSalary());
			ps.setString(5, employee.getSkills());
			ps.setString(6, employee.getRole());
			ps.setString(7, employee.getQualification());
			ps.setString(8, employee.getState());
			ps.executeUpdate();
			con.commit();
			logger.info("Inserted employee: " + employee);
		} catch (SQLException e) {
			logger.error("Error inserting employee: " + employee, e);
		}
	}

	public boolean isValidUser(String username, String password) {
		boolean isValidUser = false;
		try (Connection con = ConnectionManager.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(SELECT_USER_BY_USERNAME)) {
			ps.setString(1, username);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				isValidUser = rs.next();
			}
			logger.info("User validation for username: " + username + " - " + isValidUser);
		} catch (SQLException e) {
			logger.error("Error validating user: " + username, e);
		}
		return isValidUser;
	}

	public Employee selectEmployee(int id) {
		Employee employee = null;
		try (Connection con = ConnectionManager.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					employee = new Employee(rs.getInt("id"), rs.getString("fullname"), rs.getString("gender"),
							rs.getString("email"), rs.getDouble("salary"), rs.getString("skills"), rs.getString("role"),
							rs.getString("qualification"), rs.getString("state"));
				}
			}
			logger.info("Selected employee by ID: " + id);
		} catch (SQLException e) {
			logger.error("Error selecting employee by ID: " + id, e);
		}
		return employee;
	}

	public List<Employee> selectAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		try (Connection con = ConnectionManager.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(SELECT_ALL_EMPLOYEES);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				employees.add(new Employee(rs.getInt("id"), rs.getString("fullname"), rs.getString("gender"),
						rs.getString("email"), rs.getDouble("salary"), rs.getString("skills"), rs.getString("role"),
						rs.getString("qualification"), rs.getString("state")));
			}
			logger.info("Selected all employees");
		} catch (SQLException e) {
			logger.error("Error selecting all employees", e);
		}
		return employees;
	}

	public boolean deleteEmployee(int id) {
		boolean rowDeleted = false;
		try (Connection con = ConnectionManager.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(DELETE_EMPLOYEES_SQL)) {
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
			con.commit();
			logger.info("Deleted employee with ID: " + id);
		} catch (SQLException e) {
			logger.error("Error deleting employee with ID: " + id, e);
		}
		return rowDeleted;
	}

	public boolean updateEmployee(Employee employee) {
		boolean rowUpdated = false;
		try (Connection con = ConnectionManager.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(UPDATE_EMPLOYEES_SQL)) {
			ps.setString(1, employee.getFullname());
			ps.setString(2, employee.getGender());
			ps.setString(3, employee.getEmail());
			ps.setDouble(4, employee.getSalary());
			ps.setString(5, employee.getSkills());
			ps.setString(6, employee.getRole());
			ps.setString(7, employee.getQualification());
			ps.setString(8, employee.getState());
			ps.setInt(9, employee.getId());
			rowUpdated = ps.executeUpdate() > 0;
			con.commit();
			logger.info("Updated employee: " + employee);
		} catch (SQLException e) {
			logger.error("Error updating employee: " + employee, e);
		}
		return rowUpdated;
	}

	public List<Employee> searchEmployee(String role) {
		List<Employee> employees = new ArrayList<>();
		try (Connection con = ConnectionManager.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(SELECT_SEARCH_EMPLOYEES)) {
			ps.setString(1, role);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employees.add(new Employee(rs.getInt("id"), rs.getString("fullname"), rs.getString("email"),
						rs.getDouble("salary"), rs.getString("skills"), rs.getString("role")));
				logger.info("Selected employees with role: " + role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Error searching employees with role: " + role, e);
		}
		return employees;
	}

	public Employee getEmployeeById(int id) {
		List<Employee> employees = new ArrayList<>();
		try (Connection con = ConnectionManager.getInstance().getConnection();
				PreparedStatement ps = con.prepareStatement(SELECT_SEARCH_EMPLOYEES)) {
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employees.add(new Employee(rs.getInt("id"), rs.getString("fullname"), rs.getString("email"),
						rs.getDouble("salary"), rs.getString("skills"), rs.getString("role")));
				logger.info("Selected employees with role: ");
			}
		} catch (SQLException e) {
			logger.error("Error searching employees with role: " + e);
			e.printStackTrace();
		}
		return null;
	}

}
