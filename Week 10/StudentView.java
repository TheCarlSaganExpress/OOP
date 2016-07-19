import java.text.SimpleDateFormat;
import java.util.*;
public class StudentView {
    public void printStudent(String Name, int ID, Date DOB){
	SimpleDateFormat df=new SimpleDateFormat("MM/dd/yyyy");
	System.out.println("Student Name: " + Name);
	System.out.println("Student ID: " + ID);
	System.out.println("Student DOB: " + df.format(DOB));
    }
}
