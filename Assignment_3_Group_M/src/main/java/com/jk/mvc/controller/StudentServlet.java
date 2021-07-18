package com.jk.mvc.controller;

import java.io.IOException;
import com.jk.mvc.dao.StudentDao;
import com.jk.mvc.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * @author - Group M (Mary Joyce Rillon, Jasmeen Kaur, Tatiana Klimova, Gagandeep Kaur)

 * @date - 30-/06/2021
 * @desc - In StudentServlet,firstly object is created and initialised. Through the object created we can 
 *         fetch the values from the form and set the fields. get.Parameter method is used to fetch the
 *          values.
 */

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// creating object.
	private StudentDao studentDao;

	/**
	 * Default constructor.
	 */
	public StudentServlet() {
		// TODO Auto-generated constructor stub
	}

	// initialising object.
	public void init() {
		studentDao = new StudentDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// fetching values from the form.
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String btnVal = request.getParameter("formSubType");

		// creating a object.
		Student student = new Student();

		// calling setters methods using objects for the setting values.
		student.setId(id);
		student.setName(name);
		student.setAge(age);
		student.setGender(gender);

		// calling register student method.
		try {
			if (btnVal.equalsIgnoreCase("Insert")) {
				studentDao.registerStudent(student);
			} else {
				studentDao.updateStudent(student);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("StudentInfo.jsp");
	}

}
