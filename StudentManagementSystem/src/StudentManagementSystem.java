import java.util.*;
import java.sql.*;

public class StudentManagementSystem {
    
    // add a new student
    public void addNewStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter student's name = ");
        String name = sc.nextLine();
        System.out.print("Enter student's roll = ");   
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter student's email = ");
        String email = sc.nextLine();
        System.out.print("Enter student's gender = ");
        String gender = sc.nextLine();
        System.out.print("Enter student's Department = ");
        String dept = sc.nextLine();
        System.out.print("Enter student's Academic Year = ");
        int year = sc.nextInt();
        try{
            Conn c = new Conn();
            c.ps = c.con.prepareStatement("insert into student_details values ('"+name+"' , '"+roll+"' , '"+email+"' , '"+gender+"' , '"+dept+"' , '"+year+"')");
            int i = c.ps.executeUpdate();
            if(i>0){
                System.out.println("student is added successfully");
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
    
    // update a student
    public void updateStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the student's roll number = ");
        int roll = sc.nextInt();
        try{
            Conn c = new Conn();
            c.ps = c.con.prepareStatement("select * from student_details where Roll = '"+roll+"'");
            ResultSet rs = c.ps.executeQuery();           
            if(rs.next()){
                System.out.println("student is found..... ");
                System.out.println("----------------------------------");
                while(true){
                    System.out.println("what you want to update \n--> 1. Name \n--> 2. Roll no \n--> 3. Email \n--> 4. Gender \n--> 5. Department \n--> 6. Academic Year");
                    System.out.println("-----------------------------------");
                    int i = sc.nextInt();
                
                    switch(i){
                        case 1 -> {
                                    System.out.print("Enter your new Name = ");
                                    String newName = sc.next();
                                    c.ps = c.con.prepareStatement("update student_details set Name = '"+newName+"' where Roll = '"+roll+"'");
                                    c.ps.executeUpdate();

                        }
                        case 2 -> {
                                    System.out.print("Enter your new Roll No = ");
                                    int rollNo = sc.nextInt();
                                    c.ps = c.con.prepareStatement("update student_details set Roll = '"+rollNo+"' where Roll = '"+roll+"'");
                                    c.ps.executeUpdate();
                        }
                        case 3 -> {
                                    System.out.print("Enter your new Email = ");
                                    String newEmail = sc.next();
                                    c.ps = c.con.prepareStatement("update student_details set Email = '"+newEmail+"' where Roll = '"+roll+"'");
                                    c.ps.executeUpdate();
                        }
                        case 4 -> {
                                    System.out.print("Enter your new Gender = ");
                                    String newGender = sc.next();
                                    c.ps = c.con.prepareStatement("update student_details set Gender = '"+newGender+"' where Roll = '"+roll+"'");
                                    c.ps.executeUpdate();
                        }
                        case 5 -> {
                                    System.out.print("Enter your new Department = ");
                                    String newDept = sc.next();
                                    c.ps = c.con.prepareStatement("update student_details set Department = '"+newDept+"' where Roll = '"+roll+"'");
                                    c.ps.executeUpdate();
                        }
                        case 6 -> { 
                                    System.out.print("Enter your new Academic Year = ");
                                    int newYear = sc.nextInt();
                                    c.ps = c.con.prepareStatement("update student_details set Academic_Year = '"+newYear+"' where Roll = '"+roll+"'");
                                    c.ps.executeUpdate();
                        }
                        default -> {
                                    System.out.println("invalid input");
                                    continue;
                        } 
                    }
                    System.out.print("Do You want to update anything (yes/no) = ");
                    String update = sc.next();
                    if(update.equalsIgnoreCase("no")){
                        System.out.println("student is updated successfully");
                        break;
                    }
                }
                
                
                
            }else{
                System.out.println("Student is not found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }      
    }

    // remove a student
    public void removeStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter student's roll no = ");
        int roll = sc.nextInt();
        try{
            Conn c = new Conn();
            c.ps = c.con.prepareStatement("select * from student_details where Roll = '"+roll+"'");
            ResultSet rs = c.ps.executeQuery();
            if(rs.next()){
                c.ps = c.con.prepareStatement("delete from student_details where Roll = '"+roll+"'");
                int i = c.ps.executeUpdate();
                if(i>0){
                    System.out.println("student is removed successfully");
                    
                }
            }else{
                System.out.println("student is not found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }    

    // search a student
    public void searchStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("enter student's roll no = ");
        int roll = sc.nextInt();
        try{
            Conn c = new Conn();
            c.ps = c.con.prepareStatement("select * from student_details where Roll = '"+roll+"'");
            ResultSet rs = c.ps.executeQuery();
            if(rs.next()){
                System.out.println("Student is found.....");
                System.out.println("Here are the student's details");
                System.out.println("-------------------------------------");
                System.out.println("Name = "+rs.getString("Name")+"\nRoll No = "+rs.getString("Roll")+"\nEmail = "+rs.getString("Email")+"\nGender = "+rs.getString("Gender")+"\nDepartment = "+rs.getString("Department")+"\nAcademic Year = "+rs.getString("Academic_Year"));
            }else{
                System.out.println("student is not found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sc.close();
        }    
    }

    // display all students
    public void displayAllStudent(){
        try{
            Conn c = new Conn();
            c.ps = c.con.prepareStatement("select * from student_details");
            ResultSet rs = c.ps.executeQuery();
            while(rs.next()){
                System.out.println("Name = "+rs.getString("Name")+"\nRoll No = "+rs.getString("Roll")+"\nEmail = "+rs.getString("Email")+"\nGender = "+rs.getString("Gender")+"\nDepartment = "+rs.getString("Department")+"\nAcademic Year = "+rs.getString("Academic_Year"));
                System.out.println("-------------------------------------------");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // exit
    public void exit(){
        System.exit(0);
    }
}
