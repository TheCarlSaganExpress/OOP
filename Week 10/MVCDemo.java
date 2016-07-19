import java.text.SimpleDateFormat;
public class MVCDemo {
   public static void main(String[] args) throws Exception {

       //Get Student data
      Student model  = getStudentFromDatabase();

      //Create a view 
      StudentView view = new StudentView();

      //get hold of a controller
      StudentController controller = new StudentController(model, view);

      // Show current view
      controller.updateView();

      //update model data
      controller.setName("Emily");

      //show current view
      controller.updateView();
   }

   private static Student getStudentFromDatabase() throws Exception {
      SimpleDateFormat df=new SimpleDateFormat("MM/dd/yyyy");
      Student student = new Student();
      student.setName("Denise");
      student.setID(10);
      student.setDOB(df.parse("10/12/1990"));
      return student;
   }
}
