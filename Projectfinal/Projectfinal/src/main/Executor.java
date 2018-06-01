package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;

public class Executor extends Employee implements Serializable {

	public Executor(String name, int salary, int id, int yearOfWork) {
		super(name, salary, id, yearOfWork);
		// TODO Auto-generated constructor stub
	}

	public Executor() {
		// TODO Auto-generated constructor stub
	}


	public void viewOrders() throws IOException, ClassNotFoundException { 
		int cnt=1; 
		FileInputStream fis = new FileInputStream("orders.txt"); 
		ObjectInputStream oin = new ObjectInputStream(fis); 
		HashMap o = (HashMap) oin.readObject(); 
		Iterator it = o.entrySet().iterator(); 
		while (it.hasNext()) { 
		Map.Entry pair = (Map.Entry) it.next(); 

		System.out.println(pair.getKey() + " /"+cnt + pair.getValue()); 
		System.out.println(o); 
		cnt++; 

		} 
		} 

		public void viewAcceptedorders() throws IOException, ClassNotFoundException { 
		int cnt=1; 

		FileInputStream fis = new FileInputStream("acceptedorders.txt"); 
		ObjectInputStream oin = new ObjectInputStream(fis); 
		HashMap ao = (HashMap) oin.readObject(); 
		Iterator it = ao.entrySet().iterator(); 
		while (it.hasNext()) { 
		Map.Entry pair = (Map.Entry) it.next(); 

		System.out.println(pair.getKey() + " /"+cnt + pair.getValue()); 
		System.out.println(ao); 
		cnt++; 

		} 
		} 

		public void viewRejectedorders() throws IOException, ClassNotFoundException { 
		int cnt=1; 

		FileInputStream fis = new FileInputStream("rejectedorders.txt"); 
		ObjectInputStream oin = new ObjectInputStream(fis); 
		HashMap ao = (HashMap) oin.readObject(); 
		Iterator it = ao.entrySet().iterator(); 
		while (it.hasNext()) { 
		Map.Entry pair = (Map.Entry) it.next(); 

		System.out.println(pair.getKey() + " /"+cnt + pair.getValue()); 
		System.out.println(ao); 
		cnt++; 

		} 
		}
	public String toString() {
		return super.toString();
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int Salary) {
		this.salary = salary;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
