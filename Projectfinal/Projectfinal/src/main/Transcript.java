package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Transcript implements Serializable {

	int attestation1 ;
	int attestation2 ;
	int finale ;
	char grade ;
	public Transcript(int attestation1,int attestation2, int finale ){
		this.attestation1 = attestation1;
		this.attestation2 = attestation2;
		this.finale = finale; 
		}
	public char getGrade(){
		Mark m = new Mark();
		return m.getGrade(attestation1+attestation2+finale);
	}
	 public boolean equals(Object o) {
	    	if(o==this) return true;
			if(!(o instanceof Transcript)) {
				return false;
			}
			Transcript transcript =(Transcript) o;
			return attestation1==transcript.attestation1 && attestation2==transcript.attestation2 && finale==transcript.finale && grade==transcript.grade;
			} 

	public String toString() {
		return "Attestation1: "+attestation1 +" "+"Attestation2: "+attestation2+" "+"Finale: "+finale+" "+"Grade: "+grade;
	}

	
}
