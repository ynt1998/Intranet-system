package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
public class Manager extends Employee implements Serializable {

	public Manager(String name, int salary, int id, int yearOfWork) {
		super(name, salary, id, yearOfWork);
		// TODO Auto-generated constructor stub
	}

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	private ManagerTypes managerType;
	Map<Date, String> news = new HashMap<Date, String>();
	Map<String, String> reports = new HashMap<String, String>();
	Vector<String> courses = new Vector<String>();

	

	public void createReport(String t, String s) throws IOException, ClassNotFoundException {
		FileInputStream fit = new FileInputStream("teachers.txt");
		ObjectInputStream oit = new ObjectInputStream(fit);
		ArrayList<Teacher> teachers = new ArrayList<Teacher>();
		teachers = (ArrayList<Teacher>) oit.readObject();
		FileOutputStream fos = new FileOutputStream("reports.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Iterator it = teachers.iterator();
		boolean d=false;
		while (it.hasNext()) {
			Teacher st = (Teacher) it.next();
			if (t.equals(st.name)) {
				d=true;
				reports.put(t, s);
				oos.writeObject(reports);
				oos.flush();
				oos.close();
			}
			
		}
		if(d) { 
			System.out.println("Successfully, created report"); 
			} 
		else { 
			System.out.println("Wrong entered teacher name"); 
			} 
	

	}



	public String toString() {
		return super.toString();
	}

	public int getSalary() {
		return super.salary;
	}

	public void setSalary(int Salary) {
		super.salary = Salary;
	}

	public String getName() {
		return super.name;
	}

	public void setName(String name) {
		super.name = name;
	}
}
