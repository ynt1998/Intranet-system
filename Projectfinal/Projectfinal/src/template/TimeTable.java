package template;
import java.io.*;
public class TimeTable {
	class StaffMember {
		
		        String name;
		
		        String desi;
		
		        String sub[] = new String[2];
		
		        String lab;
		
		    }
		
		    StaffMember staff[];
		
		     
		
		    private StaffMember getStaffMember(BufferedReader br, boolean promptForInput) throws IOException {
		
		        StaffMember sf = new StaffMember();
		
		        if (promptForInput) { System.out.println("\n Enter the staff name"); }
		
		        sf.name=br.readLine();
		
		        if (promptForInput) { System.out.println("\n Enter the staff Designation"); }
		
		        sf.desi=br.readLine();
		
		        for(int i=0; i<sf.sub.length; i++) {
		
		            if (promptForInput) { System.out.println("\n Enter the subject" + (i+1)); }
		
		            sf.sub[i]=br.readLine();
		
		        }
		
		        if (promptForInput) { System.out.println("\n Enter the lab"); }
		
		        sf.lab=br.readLine();
		
		        return sf;
		
		    }
		
		     
		
		 
		
		    private void getStaff(BufferedReader br, boolean promptForInput) throws IOException {
		
		        if (promptForInput) { System.out.println("\t Enter the total number of staff "); }
		
		        int totalStaff=Integer.parseInt(br.readLine());
		
		        this.staff = new StaffMember[totalStaff];
		
		        for(int i=0; i<totalStaff; i++) {
		
		            if (promptForInput) { System.out.println("\n \tEnter the staff" + (i+1) +" details"); }
		
		            this.staff[i] = getStaffMember(br, promptForInput);
		
		        }
		
		    }
		
		     
		
		  public void getDataFromUser() throws IOException {
		
		        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		        getStaff(br, true);
		
		        //getDeparments(br, true);
		
		        br.close();
		
		    }
		
		 
		
		    public void getDataFromFile(String fileName) throws IOException {
		
		        BufferedReader br =new BufferedReader(new FileReader(fileName));
		
		        getStaff(br, false);
		
		        //getDeparments(br, false);
		
		        br.close();
		
		    }
		
		 
		
		    public void writeData(PrintStream writer) throws IOException {
		
		      int totalStaff=this.staff.length;
		
		        writer.println(totalStaff);
		
		        for(int i=0; i<totalStaff; i++) {
		
		            StaffMember sf = this.staff[i];
		
		           writer.println(sf.name);
		
		            writer.println(sf.desi);
		
		            for(int j=0; j<sf.sub.length; j++) {
		
		                writer.println(sf.sub[j]);
		
		            }
		
		            writer.println(sf.lab);
		
		        }
		
		    }
		
		     
		
		    public void writeData(String fileName) throws IOException {
		
		        PrintStream writer =new PrintStream(new FileOutputStream(fileName));
		
		        writeData(writer);
		
		        //getDeparments(br, false);
		
		        writer.close();
		
		    }
		
		 
		
		    public static void main(String[] args) {
		
		        TimeTable tt = new TimeTable();
		
		        try {
		
		            tt.getDataFromUser();
		
		            tt.writeData(System.out);
		
		            tt.writeData("dump.txt");
		
		        } catch (IOException ex) {
		
		            ex.printStackTrace();
		
		        }
		
		    }
}
