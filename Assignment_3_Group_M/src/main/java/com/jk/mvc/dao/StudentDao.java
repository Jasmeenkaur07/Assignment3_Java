package com.jk.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jk.mvc.model.Student;

public class StudentDao {
	public int registerStudent(Student student) throws ClassNotFoundException {

		// Step 1 : Create a SQL Statement
		String INSERT_USERS_SQL = "INSERT INTO studentinfo" + "  (id, name, age, gender) VALUES " + "(?, ?, ?, ?);";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3", "root",
				"Anter123?");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

			preparedStatement.setInt(1, student.getId());

			preparedStatement.setString(2, student.getName());
			preparedStatement.setInt(3, student.getAge());

			preparedStatement.setString(4, student.getGender());

			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return result;
	}

	public int updateStudent(Student student) throws ClassNotFoundException {
		// Step 1 : Create a SQL Statement
		String UPDATE_STUD_SQL = "UPDATE studentinfo SET name = ?, age = ?, gender = ? WHERE id = ?;";
		int result = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment3", "root",
				"Anter123?");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUD_SQL)) {

			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());

			preparedStatement.setString(3, student.getGender());
			preparedStatement.setInt(4, student.getId());

			System.out.println(preparedStatement);

			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return result;
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
