

import java.util.Scanner;

public class StudentDemo {
    public static void main(String... arg) throws StudentDoesntExist {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);
        int n;
        long rollNo=0;


        do {
            System.out.println(" If You want to add Student------------> 1");
            System.out.println(" If You want to deleteStudent----------> 2");
            System.out.println("If you want  to StudentDetails---------> 3");
            System.out.println("If you want to update a StudentList----> 4");
            System.out.println("If you want to Find the TopperStudent--> 5");
            System.out.println("If you want a Exit --------------------> 6");
            System.out.println("Kindly enter your option");
            n=sc.nextInt();
            if(n==1)
            {   int[] marks = new int[6];
                System.out.println("Enter  the  Name :");
                String name = sc.next();
                System.out.println("Enter  the Address :");
                String address = sc.next();
                System.out.println("Enter  the Subject :");
                String subject = sc.next();
                System.out.println("Enter your Marks");
                for (int i = 0; i < 6; i++)
                    marks[i] = sc.nextInt();
                if( sms.addStudent(new Student(rollNo, name, address, subject, marks))) {
                    System.out.println("Student details are successfully added ");
                    System.out.println("Your RollNo :" + (rollNo++));
                    System.out.println("ThankYou :)");
                    System.out.println();
                }
                else System.out.println("Invalid ");
            }
            else if(n==2) {
                try {
                    System.out.println("Enter the rollno you want to delete");
                    long rollNo1 = sc.nextLong();
                    System.out.println("Successfully  deleted " + sms.deleteStudent(rollNo1));
                } catch (StudentDoesntExist sde) {
                    System.out.println(sde.getMessage());
                }
            } else if (n==3) {
                System.out.println("Students details are shown below");
                sms.listStudents();
                System.out.println(" ************  ThankYou   **********");
            } else if (n==4)
            { try {
                int[] marks = new int[6];
                System.out.println("Enter the RollNumber");
                long rollNo2=sc.nextInt();
                System.out.println("Enter  the  Name :");
                String name = sc.next();
                System.out.println("Enter  the Address :");
                String address = sc.next();
                System.out.println("Enter  the Subject :");
                String subject = sc.next();
                System.out.println("Enter your Marks");
                for (int i = 0; i < 6; i++)
                    marks[i] = sc.nextInt();
                sms.updateStudent(rollNo2, (new Student(rollNo2, name, address, subject, marks)));
                System.out.println("Student details are successfully updated");
            }
            catch (StudentDoesntExist sde){
                System.out.println(sde.getMessage());
            }
            }
            else {
                System.out.println("Topper Student is------->" + sms.findTopper().getName());
            }
            System.out.println("********************THANK YOU  :) PROGRAM FINISHED ****************************** ");

        }while(n != 6);

    }
}


