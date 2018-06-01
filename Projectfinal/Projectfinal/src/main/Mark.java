package main;

import java.io.Serializable;

public class Mark implements Serializable{
    
	 private char Grade;
	 private int points;
	public Mark(int points){
		this.points = points;
	}
	public Mark(){
		
	}

    public char getGrade(int points) {
    	if(points>=90){
    		return 'A';
    	}else if(points>=80){
    		return 'B';
    	}else if(points>=70){
    		return 'C';
    	}else if(points>=60){
    		return 'D';
    	}else{
    		return 'F';
    	}
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
    	this.points = points;
    }
}

