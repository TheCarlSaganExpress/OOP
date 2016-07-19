/**
   Suppose you are given a plain text file, "countries.txt" that has names of countries(String), their areas(Double, square miles) and populations(integers). The file has over 200 lines, each of the form
   "Afghanistan" ,  250000, 31108077
   "Bahamas, The", 5382, 313312
   Write a Java program to read in this file, and write three separate files each of which has the countries sorted according to Name, Area and Population respectively. Call the files  countries_by_name.txt, countries_by_area.txt and countries_by_population.txt. Use a Country class to encapsulate the properties of countries.
   Use anonymous Comparator classes to do all sorting. You need not define a default comparison for countries.
*/
import java.util.*;
import java.io.*;

public class Country {
    String Name;
    Double Area;
    int Population;

    public  Country(String Name, Double Area, int Population)  {
	this.Name=Name;
	this.Area=Area;
	this.Population=Population;
    }
    public String toString(){
	return "Name = "+Name+", Area = "+Area+", Population = "+Population;
    }	
}

class Countries {
    /* List to hold Countries */
    ArrayList<Country> CountriesList=new  ArrayList<Country>();

    /* Read file and populate CountriesList  */
    private void getCountries(File finput) throws Exception{
	FileInputStream fis = new FileInputStream(finput);
	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
	String line = null;
	br.readLine(); /* Read the first line and ignore it */
	while ((line = br.readLine()) != null) {
	    /*** modified from http://stackoverflow.com/questions/632475/regex-to-pick-commas-outside-of-quotes */
	    String delims = "(,)(?=(?:[^\"]|\"[^\"]*\")*$)"; 
	    String[] tokens = line.split(delims);	    
	    //System.out.println(tokens[0]+", "+tokens[1]);
	    String Name = tokens[0];
	    Double Area  = Double.parseDouble(tokens[1]);
	    int Population = Integer.parseInt(tokens[2]);
	    CountriesList.add(new Country(Name,Area,Population));
	}
	br.close();
    }
    
    public static void writeFile(File F, ArrayList<Country> AL) throws IOException{
	Iterator it=AL.iterator();
	FileWriter fw = new FileWriter(F);
	while (it.hasNext()){
	    Country cntry=(Country)it.next();
	    fw.write(cntry.toString()+System.getProperty("line.separator"));
	}
	fw.close();
    }

    public static void main(String[] args) throws Exception{
	Countries cntries=new Countries();
	File f=new File("countries.csv");
	cntries.getCountries(f);

	File f_name = new File("countries_by_name.txt");
	File f_area = new File("countries_by_area.txt");
	File f_pop = new File("countries_by_population.txt");
	Collections.sort(cntries.CountriesList, new Comparator<Country>(){
		public int compare(Country c1, Country c2){
		    return c1.Name.compareTo(c2.Name);
		}
	    });

	writeFile(f_name, cntries.CountriesList);

	Collections.sort(cntries.CountriesList, new Comparator<Country>(){
		public int compare(Country c1, Country c2){
		    //return (int)(c1.Area-c2.Area); /*this should work too */
		    return c1.Area.compareTo(c2.Area);
		}
	    });
	writeFile(f_area,cntries.CountriesList);

	Collections.sort(cntries.CountriesList, new Comparator<Country>(){
		public int compare(Country c1, Country c2){
		    //return (int)(c1.Population-c2.Population);
		    return c1.Population- c2.Population;
		}
	    });

	writeFile(f_pop, cntries.CountriesList);

    }

}
