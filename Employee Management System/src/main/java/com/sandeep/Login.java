package com.sandeep;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sandeep.beans.Employee;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Service is called IN home");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println("user name : " + email);
		System.out.println("password : " + password);
		request.getSession().setAttribute("username", email);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
				PreparedStatement ps = con.prepareStatement("select * from employee")) {

			ResultSet rs = ps.executeQuery();
			List<Employee> list = new ArrayList<Employee>();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setEmail(rs.getString("email"));
				e.setName(rs.getString("name"));
				e.setSalary(rs.getFloat("salary"));
				list.add(e);
			}
			System.out.println("emp list: " + list);
			request.getSession().setAttribute("empList", list);
		} catch (Exception e) {
			System.out.println("execption  : " + e);
			request.getSession().setAttribute("error", e.getMessage());
		}
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
				PreparedStatement pst = con.prepareStatement("select * from employee where email=? and password=?")) {
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet loginRs = pst.executeQuery();
			if (loginRs.next()) {
				Employee e = new Employee();
				e.setId(loginRs.getInt("id"));
				e.setEmail(loginRs.getString("email"));
				e.setName(loginRs.getString("name"));
				e.setSalary(loginRs.getFloat("salary"));
				e.setPassword(loginRs.getString("password"));
				e.setPermission(loginRs.getString("permission"));
				System.out.println("login user  : " + e);
				request.getSession().setAttribute("emp", e);
			} else {
				request.getSession().setAttribute("error", "Email or Password is not Matching");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
				return;
			}
			getAllEmp(request, con);
		} catch (Exception e) {
			System.out.println("execption  : " + e);
			request.getSession().setAttribute("error", e.getMessage());
		}
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

	public static void getAllEmp(HttpServletRequest request, Connection con) {
		try (PreparedStatement ps = con.prepareStatement("select * from employee")) {

			ResultSet rs = ps.executeQuery();
			List<Employee> list = new ArrayList<Employee>();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt("id"));
				e.setEmail(rs.getString("email"));
				e.setName(rs.getString("name"));
				e.setSalary(rs.getFloat("salary"));
				e.setPassword(rs.getString("password"));
				list.add(e);
			}
			System.out.println("emp list: " + list);
			request.getSession().setAttribute("empList", list);
		} catch (Exception e) {
			System.out.println("execption  : " + e);
			request.getSession().setAttribute("error", e.getMessage());
		}

	}

}