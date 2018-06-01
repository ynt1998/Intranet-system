package main;

import java.io.Serializable;
import java.util.*;

public abstract class Person implements Serializable{
    public String name;

    
    public Person(String name) {
    	this.name=name;
    }
    public Person(){
    	
    }
    public abstract String getName();
    public abstract void setName(String name);
    
    public String toString() {
    	return name;
    };
    public boolean equals(Object o) {
    	if(o==this) return true;
		if(!(o instanceof Person)) {
			return false;
		}
		Person person =(Person) o;
		return person.name.equals(name);
	}
    public int hashcode() {
    	return Objects.hash(name);
    }
   
}

