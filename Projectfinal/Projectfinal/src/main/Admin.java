package main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Vector;
public class Admin {
	cdck
	
    public Student addStudents(String name,int id, int yearOfStudy, String faculty) {
    			Student s = new Student(name,id,yearOfStudy,faculty);
    			return s;
    }
    public Teacher addTeachers(String name, int salary, int id, int yearOfWork, String course){
    	Teacher t = new Teacher(name,salary,id,yearOfWork,course);
    	return t;
    }
    public Course addCourse(String courseName,String faculty, int credits, int year){
    	Course c = new Course(courseName,faculty,credits,year);
    	return c;
    }
    
    
    public News addNews(String title, String content, String from){
		News n = new News(title,content,from);
		return n;
	}
    public boolean equals(Object o) {
    	if (o == this)
			return true;
		if (!(o instanceof Admin)) {
			return false;
		}
		Admin admin = (Admin)o;
		return super.equals(admin);
    }
    public int hashCode() {
        return super.hashCode();
    }
    public String toString() {
    	return super.toString();
    }
}
