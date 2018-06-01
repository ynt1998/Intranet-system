package main;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.*;

import main.TeacherTitles;

public class Teacher extends Employee implements Serializable {
	private static final long serialVersionUID = 7474689238507427420L;
	static Map<Student, String> marks = new HashMap<Student, String>();
	static Map<Date,String> orders = new HashMap<Date,String>();
	private String courses;
	
	public enum Attendance {
		late, present, absent;
	}
	public Teacher(String name, int salary, int id, int yearOfWork, String course) {
		super(name, salary, id, yearOfWork);
		this.courses = "No courses yet";
	}

	public Teacher() {
		super();
	}

	public TeacherTitles titles;
		

	public void putMark(String courseName, String studentName, int first ,int second, int finale) throws IOException, ClassNotFoundException {
		Transcript t = new Transcript(first,second , finale);
		BufferedWriter bw = new BufferedWriter(new FileWriter(studentName + "mark.txt"));
		
		String line = "";
				line = courseName+ " "+studentName+" " + first+" " +second+ " "+finale+" "+t.getGrade()+"\n";
				bw.append(line);
				bw.close();
	}

	public void putAttendance(String teacherName, String studentName, String subject, String s) throws IOException, ParseException {
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(teacherName + "attendance.txt"));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(studentName + "attendance.txt"));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		java.util.Date d = sdf.parse("21/12/2012 17:02:00");
		if (s.equals("+")) {
			studentName = subject + " " + studentName + " " + Attendance.present+ sdf.format(d);
			bw1.append(studentName);
			bw2.append(studentName);
		}
		if (s.equals("-")) {
			studentName = subject + " " + studentName + " " + Attendance.absent + sdf.format(d);
			bw1.append(studentName);
			bw2.append(studentName);
		}
		if (s == "+-" || s == "-+") {
			studentName = subject + " " + studentName + " " + Attendance.late + sdf.format(d);
			bw1.append(studentName);
			bw2.append(studentName);
		}
		bw1.close();
		bw2.close();
	}

	public void showCourseFile(String name) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(name + ".txt");
		ObjectInputStream oin = new ObjectInputStream(fis);
		Teacher t = (Teacher) oin.readObject();
		System.out.println(t);
	}
	public void sendOrder(String order) throws IOException { 
		FileOutputStream fos = new FileOutputStream("orders.txt"); 
		ObjectOutputStream oos = new ObjectOutputStream(fos); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
		Calendar cal = Calendar.getInstance(); 
		java.util.Date date = new java.util.Date(); 
		java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
		orders.put(sqlDate, order); 
		oos.writeObject(orders); 
		oos.flush(); 
		oos.close(); 



		}
	

	public String toString() {
		return "Teacher is:"+super.toString();
	}


    public boolean equals(Object o) {
    	if(o==this) return true;
		if(!(o instanceof Teacher)) {
			return false;
		}
		Teacher teacher =(Teacher) o;
		return super.equals(teacher);} 
    public int hashCode() {
		return Objects.hash(name,salary,courses); 
	}
    
	public int getSalary() {
		return salary;
	}
	public String getCourses() {
		return courses;
	}
	public void setSalary(int Salary) {
		this.salary=salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}
}
