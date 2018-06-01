package main;

import java.io.Serializable;
import java.util.*;
public class Course implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6814529614863696151L;
	private int credit;
    private String faculty;
    private String courseName;
    private int year;
    public enum Season{
    	Spring,Autumn;
    }
    public Course(){
    	courseName="";
    }
    public Course(String courseName, String faculty, int credits, int year) {
    	this.courseName=courseName;
    	this.credit = credits;
    	this.faculty = faculty;
    	this.year = year;
    }
    public String getName(){
    	return courseName;
    }
    public String getFaculty(){
    	return faculty;
    }
    public int getYear() {
    	return year;
    }
    public int getCredit() {
    	return credit;
    }
    public void setCredit(int credit) {
    	this.credit=credit;
    }


    	public boolean equals(Object o) {
        	if(o==this) return true;
    		if(!(o instanceof Course)) {
    			return false;
    		}
    		Course c =(Course) o;
    		return c.courseName.equals(this.courseName) && c.credit==this.credit && c.faculty.equals(this.faculty);
    	}
    
    public int hashCode() {
        return Objects.hash(courseName, credit, faculty);
    }

    public String toString() {
        return courseName+" "+credit+" " +faculty;
    }
}

