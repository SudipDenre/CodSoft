import java.util.*;
public class Launch {
    public static void main(String[] args) {
        StudentManagementSystem sys = new StudentManagementSystem();
        System.out.println("Student management system is created successfully");
        System.out.println("--------------------------------------");
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("--------------------------------------");
            System.out.println("1. Add a new Student \n2. Update a Student \n3. Remove a Student \n4. Search for a Student \n5. Display all Students \n6. Exit");
            System.out.println("--------------------------------------");    
            System.out.print("Enter your choice : ");
            int val =sc.nextInt();
            switch(val){
                case 1 -> sys.addNewStudent();  
                case 2 -> sys.updateStudent();
                case 3 -> sys.removeStudent();
                case 4 -> sys.searchStudent();
                case 5 -> sys.displayAllStudent();
                case 6 -> {
                          sc.close();
                          System.exit(0);
                }               
            }
        }

        

        
        
        


        
    }
            
}
