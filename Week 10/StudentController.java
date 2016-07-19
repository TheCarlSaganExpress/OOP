public class StudentController {
   private Student model;
   private StudentView view;

   public StudentController(Student model, StudentView view){
      this.model = model;
      this.view = view;
   }

   public void setName(String name){
      model.setName(name);		
   }

   public String getName(){
      return model.getName();		
   }

   public void setID(int ID){
      model.setID(ID);		
   }

   public int getID(){
      return model.getID();		
   }

   public void updateView(){				
       view.printStudent(model.getName(), model.getID(), model.getDOB());
   }	
}
