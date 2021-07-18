package com.jk.mvc.controller;

import java.io.IOException;

import com.jk.mvc.dao.StudentGradeDao;
import com.jk.mvc.model.StudentGrade;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentGradeServlet
 */
@WebServlet("/StudentGradeServlet")
public class StudentGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// creating object
	private StudentGradeDao studentgradeDao;

	/**
	 * Default constructor.
	 */

	public StudentGradeServlet() {
		// TODO Auto-generated constructor stub
	}

	// initialising object.
	public void init() {
		studentgradeDao = new StudentGradeDao();
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

		// fetching values from the user form.
		int courseid = Integer.parseInt(request.getParameter("courseid"));
		String coursename = request.getParameter("coursename");
		float coursescore = Float.parseFloat(request.getParameter("coursescore"));
		String btnVal = request.getParameter("formSubType");

		// creating a object.
		StudentGrade studentgrade = new StudentGrade();

		// calling setters methods using objects for the setting values.
		studentgrade.setCourseId(courseid);
		studentgrade.setCourseName(coursename);
		studentgrade.setCourseScore(coursescore);

		// calling register studentgrade method.

		try {
			if (btnVal.equalsIgnoreCase("Insert")) {
				studentgradeDao.registerStudentGrade(studentgrade);
			} else {
				studentgradeDao.updateStudentGrade(studentgrade);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect("StudentGrade.jsp");
	}
}
