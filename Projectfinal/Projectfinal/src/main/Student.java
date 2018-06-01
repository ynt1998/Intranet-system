package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.*;

public class Student extends Person implements  Serializable {
	private static final long serialVersionUID = 1573698750203538673L;

	public Map<Course, Mark> mark;
	private int gpa;
	private int yearOfStudy;
	private int id;
	private String password;
	private String username;
	private String faculty;
	private String courses;
	public Student(String name, int id, int yearOfStudy,String faculty) {
		super(name);
		this.id = id;
		this.yearOfStudy = yearOfStudy;
		this.gpa = 0;
		password = "1234";
		username = name;
		this.faculty = faculty;
		courses="no course";
		
	}
	public Student(String password) {
		this.password=password;
	}
	public String getFaculty(){
		return faculty;
	}
	public void setCourse(String courses){
		this.courses = courses;
	}
	public String getCourse(){
		return courses;
	}
	public String getName() {

		return name;
	}

	public void setName(String name) {
		super.name = name;

	}

	public int getGpa() {
		return gpa;
	}

	public void setGpa(int gpa) {
		this.gpa = gpa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void viewAttendance(String name) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(name + "attendance.txt"));
		String line = br.readLine();
		try{while (!line.isEmpty()) {
			System.out.println(line);
			line = br.readLine();
		}}catch(NullPointerException e){
		}

	}
	public void viewMark(String name) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(name + "mark.txt"));
		String line = br.readLine();
		try{while (!line.isEmpty()) {
			System.out.println(line);
			line = br.readLine();
		}}catch(NullPointerException e){
		}
	}


	public void viewCourseFiles(String teacher) throws ClassNotFoundException, IOException {
		Teacher t = new Teacher();
		t.showCourseFile(teacher);

	}

	public static void downloadUsingNIO(String urlStr, String file) throws IOException {
		
			URL url = new URL(urlStr);
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(file);
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		rbc.close();
		
	}

	

	public String toString() {
		return "Student is:" + super.toString() + "with id:" + id + "whise gpa is:" + gpa + "and who is at"
				+ yearOfStudy + "course";
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Student)) {
			return false;
		}
		Student student = (Student) o;
		return super.equals(student) && id == student.id && gpa == student.gpa && yearOfStudy == student.yearOfStudy
				&& student.username.equals(username) && student.password.equals(password) && student.faculty.equals(faculty)&& student.courses.equals(courses);
	}

	public int hashCode() {
		return Objects.hash(name, gpa, id, username, password, yearOfStudy,faculty,courses);
	}

	
}
