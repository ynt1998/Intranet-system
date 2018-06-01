package main;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CourseFiles implements Serializable {
   
    String date;

    private String name;

    public List<CourseFiles>cfiles=new ArrayList<>();

    public CourseFiles(String cfile) {
    	this.name=cfile;
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    	Date date = new Date();
    	this.date=dateFormat.format(date);
    	
    }
 

}

