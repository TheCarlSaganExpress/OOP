
import java.util.*;
import java.text.SimpleDateFormat;
import java.io.*;
public class Student implements Comparable<Student>{
    int ID;
    String Name;
    Date DOB;
    public Student(int ID, String Name, Date DOB){
	this.ID=ID;
	this.Name=Name;
	this.DOB=DOB;
    }
    public int compareTo(Student s){
	return this.ID - s.ID;
    }
    public boolean equals(Student s){
	return this.ID==s.ID && this.Name==s.Name && this.DOB==s.DOB;
    }

    public String toString(){
    	SimpleDateFormat df=new SimpleDateFormat("MM/dd/yyyy");
		return "Student ID = "+ID+", Name = "+Name+", DOB = "+df.format(DOB);
    }
}



class Students{

    /* List to hold Students */
    ArrayList<Student> StudentList=new  ArrayList<Student>();

   /** Print this List **/
    public static void printList(List L){
		Iterator it=L.iterator();
		while(it.hasNext()){
	    	System.out.println(it.next());
		}
    }	

    /* Read file and populate Student List */
    private void getStudents(File finput) throws Exception{
	FileInputStream fis = new FileInputStream(finput);
	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	String line = null;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	while ((line = br.readLine()) != null) {
	    String delims = "[,]";
	    String[] tokens = line.split(delims);
	    int id = Integer.parseInt(tokens[2].trim());
            String n = tokens[1];
	    Date dt = sdf.parse(tokens[0]);
	    StudentList.add(new Student(id,n,dt));
	}
	br.close();
    }
    

    public static void writeFile(File F, ArrayList<Student> AL) throws IOException{
    	Iterator it=AL.iterator();
    	FileWriter fw = new FileWriter(F);
    	while (it.hasNext()){
    		Student st=(Student)it.next();
    		fw.write(st.toString()+System.getProperty("line.separator"));
    	}
    	fw.close();
    }




    public static void main(String[] s) throws Exception{
	Students m=new Students();
	File f=new File("textfile.txt");
	m.getStudents(f);

	File f_dob = new File("students_by_dob.txt");
	File f_name = new File("students_by_name.txt");
	File f_id = new File("students_by_id.txt");
	Collections.sort(m.StudentList);
	writeFile(f_id,m.StudentList);
	System.out.println("_______________SORTED BY ID_________________________________________");
	printList(m.StudentList);
	Collections.sort(m.StudentList, new cmp_DOB());
	System.out.println("_______________SORTED BY DOB_________________________________________");
	printList(m.StudentList);
	writeFile(f_dob, m.StudentList);
	System.out.println("_______________SORTED BY Name_________________________________________");	
	Collections.sort(m.StudentList, new cmp_Name());
	writeFile(f_name,m.StudentList);
	printList(m.StudentList);
    }
}

class cmp_Name implements Comparator<Student> {
     public int compare(Student s1, Student s2){
     	return s1.Name.compareTo(s2.Name);
     }
}
class cmp_DOB implements Comparator<Student> {
     public int compare(Student s1, Student s2){
     	return s1.DOB.compareTo(s2.DOB);
     }
}



