/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package question1;

import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class StudentTest {
    
    public StudentTest() {
    }
        Scanner cons = new Scanner(System.in);
        String [] StudentID={"2144"};
        String [] Studentname={"NA.Ramudzuli"};
        String [] Studentemail ={"NyitoRamudzuli50@gmail.com"};
        int [] Student ={16};
        String []StudentCourse={"DISD1"};
        int num=0;

    /**
     * Test of viewOption method, of class Student.
     */
    @Test
    public void testVSavestudent() {
        
             assertEquals("2144", StudentID[num]);
             assertEquals("NA.Ramudzuli",  Studentname[num]);
             assertEquals("NyitoRamudzuli50@gmail.com", Studentemail[num]);
             assertEquals(16, Student[num]);
             assertEquals("DISD1", StudentCourse[num]);
        
        System.out.println("viewOption");
        Student instance = new Student();
        instance.viewOption();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
   public void TestSearchStudent() {
        String checking="2144";
        boolean varify = false;
        for(int x =0 ; x<num;x++){
          if(checking == StudentID[x]){
             assertEquals("2144", StudentID[x]);
             assertEquals("NA.Ramudzuli",  Studentname[x]);
             assertEquals("NyitoRamudzuli50@gmail.com", Studentemail[x]);
             assertEquals(16, Student[x]);
             assertEquals("DISD1", StudentCourse[x]);
             varify=true;
          }else{
               System.out.println("This student with  id 6788 is not found");
          }
        }
        assertTrue(varify);
    }
    public void TestSearchStudentNOTFOUND() {
        String checking="6788";
        boolean varify = false;
        for(int x =0 ; x<num;x++){
          if(checking == StudentID[x]){
             assertEquals("2144", StudentID[x]);
             assertEquals("NA.Ramudzuli",  Studentname[x]);
             assertEquals("NyitoRamudzuli50@gmail.com", Studentemail[x]);
             assertEquals(16, Student[x]);
             assertEquals("DISD1", StudentCourse[x]);
             varify=false;
          }else{
              System.out.println("This student with  id 6788 is not found");
          }
        }
        assertTrue(varify);
    }
    @Test
     public void TestDeleteStudent() {
        String id = "2144";
        boolean deleteStud = false;
       for(int x =0 ; x<num;x++){
         if(id ==StudentID[x]){
            
            System.out.print("Do you want to delete the student with ID: " + deleteStud + "? (yes/no): ");
                String areYOUsure = cons.nextLine();
           if(areYOUsure=="yes"){
            
               for (int j = x; j < num - 1; j++) {
                        StudentID[j] = StudentID[j + 1];
                        Studentname[j] = Studentname[j + 1];
                        Student[j] = Student[j + 1];
                        Studentemail[j] = Studentemail[j + 1];
                        StudentCourse[j] = StudentCourse[j + 1];
                    }
                    // Clear the last entry
                    StudentID[num - 1] = null;
                    Studentname[num - 1] = null;
                    Student[num - 1] = 0;
                     Studentemail[num - 1] = null;
                    StudentCourse[num - 1] = null;

                    num --; // Decrement student count
                    
                    deleteStud = true;
           }         
          assertEquals("Create Reports Successfully deleted",deleteStud );
        }    
    }
     }
     public void TestDeleteStudent_NOTFOUND() {
        String id = "6788";
        boolean deleteStud = false;
       for(int x =0 ; x<num;x++){
         if(id ==StudentID[x]){
            
            System.out.print("Do you want to delete the student with ID: " + deleteStud + "? (yes/no): ");
                String areYOUsure = cons.nextLine();
           if(areYOUsure=="yes"){
            
               for (int j = x; j < num - 1; j++) {
                        StudentID[j] = StudentID[j + 1];
                        Studentname[j] = Studentname[j + 1];
                        Student[j] = Student[j + 1];
                        Studentemail[j] = Studentemail[j + 1];
                        StudentCourse[j] = StudentCourse[j + 1];
                    }
                    // Clear the last entry
                    StudentID[num - 1] = null;
                    Studentname[num - 1] = null;
                    Student[num - 1] = 0;
                     Studentemail[num - 1] = null;
                    StudentCourse[num - 1] = null;

                    num --; // Decrement student count
                    
                    deleteStud = false;
           }
        
          
          assertEquals("No student was found",deleteStud );
        }
         
    }
     }

    /**
     * Test of SEARCHSTUDENT method, of class Student.
     */
    @Test
    public void testSTUDENT_ageVALID() {
        boolean check=false;    
        int age =16;
        if(age==Student[num]){
            check=true;
        }
         assertEquals("age successfully capture",check );
       
    }
    public void testSTUDENT_ageNOTVALID() {
        boolean check=false;    
        int age =14;
        if(age==Student[num]){
            check=true;
        }
         assertEquals("age is not successfully captured, please ensure that age is greater or equal to 16",check );
       
    }

    /**
     * Test of DisplayReport method, of class Student.
     */
    @Test
    public void testDisplayReport() {
        System.out.println("DisplayReport");
        Student instance = new Student();
        instance.DisplayReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
  
    
    
    
    
}

