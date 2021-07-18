package com.jk.mvc.model;

//Declaring fields for student
public class StudentGrade {
	private int courseId;
	private String courseName;
	private float courseScore;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int studentId) {
		this.courseId = studentId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public float getCourseScore() {
		return courseScore;
	}

	public void setCourseScore(float courseScore) {
		this.courseScore = courseScore;
	}

}
