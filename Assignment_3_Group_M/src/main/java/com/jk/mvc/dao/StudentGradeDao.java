package com.jk.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jk.mvc.model.StudentGrade;

public class StudentGradeDao {
	public int registerStudentGrade(StudentGrade studentgrade) throws ClassNotFoundException {

		// Step 1 : Create a SQL Statement
		String INSERT_USERS_SQL = "INSERT INTO studentgrade" + "  (courseId, courseName, courseScore) VALUES "
				+ " (?, ?, ?);";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3", "root",
				"Anter123?");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

			preparedStatement.setInt(1, studentgrade.getCourseId());

			preparedStatement.setString(2, studentgrade.getCourseName());
			preparedStatement.setFloat(3, studentgrade.getCourseScore());

			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return result;
	}

	public int updateStudentGrade(StudentGrade studentgrade) throws ClassNotFoundException {

		// Step 1 : Create a SQL Statement
		String UPDATE_STUD_SQL = "UPDATE studentgrade SET  courseName = ?, courseScore = ? WHERE courseId = ?;";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3", "root",
				"Anter123?");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUD_SQL)) {

			preparedStatement.setString(1, studentgrade.getCourseName());
			preparedStatement.setFloat(2, studentgrade.getCourseScore());

			preparedStatement.setInt(3, studentgrade.getCourseId());

			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);

		}
		return result;
	}

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub

	}

	public class SelectPStatementExample {
		private static final String QUERY = "select courseName,courseScore from studentgrade where courseId =?";

		public void main(String[] args) {

			// using try-with-resources to avoid closing resources (boiler plate code)

			// Step 1: Establishing a Connection
			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3", "root",
					"Anter123?");

					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
				preparedStatement.setInt(1, 1);

				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int CourseId = rs.getInt("CourseId");
					String CourseName = rs.getString("CourseName");
					Float CourseScore = rs.getFloat("CourseScore");

					System.out.println(CourseId + "," + CourseName + "," + CourseScore);
				}
			} catch (SQLException e) {

				printSQLException(e);
			}
		}

		private void printSQLException(SQLException ex) {
			for (Throwable e : ex) {
				if (e instanceof SQLException) {
					e.printStackTrace(System.err);
					System.err.println("SQLState: " + ((SQLException) e).getSQLState());
					System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
					System.err.println("Message: " + e.getMessage());
					Throwable t = ex.getCause();
					while (t != null) {
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}
	}
}
