import java.util.*;
public class Student {
    private int ID;
    private String Name;
    private Date DOB;
   
    public int getID() {
	return ID;
    }
   
    public void setID(int ID) {
	this.ID=ID;
    }

    public Date getDOB(){
	return DOB;
    }
    public void setDOB(Date DOB){
	this.DOB=DOB;
    }
    public String getName() {
	return Name;
    }
   
    public void setName(String Name) {
	this.Name = Name;
    }
}

