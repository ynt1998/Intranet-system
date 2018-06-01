package main;

import java.io.Serializable;
import java.util.*;

public abstract class Employee extends Person implements Serializable{
	public int salary;
	private int id;
	private int yearOfWork;
	protected String password;
	protected String username;
	
	public Employee(String name, int salary, int id, int yearOfWork) {
		super(name);
		this.salary = salary;
		this.id = id;
		this.yearOfWork = yearOfWork;
		this.password = "12345";
		username = name;
		
	}
	public Employee(){
		super();
	}

	public int compareTo(Object o) {
		Employee e = (Employee) o;
		if (salary > e.salary)
			return 1;
		if (salary < e.salary)
			return -1;
		return 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String toString() {
		return "The name is: " + super.toString() + ". " + "The salary is: " + salary + ". " + " time   working" + ": "
				+ yearOfWork;
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Employee)) {
			return false;
		}
		Employee employee = (Employee) o;
		return super.equals(employee) && salary == employee.salary && id == employee.id
				&& yearOfWork == employee.yearOfWork && employee.username.equals(username)
				&& employee.password.equals(password);
	}

	public int hashCode() {
		return Objects.hash(name, salary, id, username, password, yearOfWork);
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.name;
	}
	@Override
	public void setName(String name) {
		super.name=name;
		// TODO Auto-generated method stub
		
	}
}
