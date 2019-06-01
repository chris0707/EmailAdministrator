package chris.albarillo.com;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Email {

    private String firstName = "";
    private String lastName = "";
    private String emailAddress;
    private String passwordMod = "";
    private String department = "";
    private int mailboxCapacity;
    private String alternateEmail = "";


    private LinkedList<String> linkedList = new LinkedList<String>();

    public Email(String firstName, String lastName){

        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println("Email created for: " + this.firstName + " " + this.lastName);

        this.department = setDepartment();
        System.out.println("Department: " + this.department);

        this.emailAddress = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department.toLowerCase() + "@IBM.com";
        System.out.println("Email address: " + this.emailAddress);

        this.passwordMod = PasswordGenerator();
        System.out.println("Password: " + this.passwordMod);

    }

    public Email(){

    }

    public String PasswordGenerator(){

        String passChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$&";
        String newPassword;




        StringBuilder sb1 = new StringBuilder(8);


        for(int i = 0; i<10; i++){
            int passWordPointer = (int)(Math.random() * passChars.length());
            newPassword = String.valueOf(passChars.charAt(passWordPointer));
            sb1.append(newPassword);

        }

        return ""+sb1;


    }

    public String getFirstName(){return firstName;}

    public String getLastName(){return lastName;}

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPasswordMod() {
        return passwordMod;
    }

    public String getDepartment(){
        return department;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getInfo(LinkedList linkedList){

        //add to the linked list with delimiters
        String newHireInfo = getDepartment() + "," + getEmailAddress() + "," +  getPasswordMod() + "," +  getAlternateEmail();
        linkedList.add(newHireInfo);
        ListLinkedList(linkedList);
        return "Department: " + getDepartment() + "\n" + "Company Email Address: " + getEmailAddress() + "\n" + "Temporary Password: " +  getPasswordMod() + "\n" + "Alternat Email Address: " +  getAlternateEmail() +  "\n" + newHireInfo;

    }

    public void setPassword(String password_1){

        this.passwordMod = password_1;

    }

    public void setAlternateEmail(String emailAddress) {
        this.alternateEmail = emailAddress;
    }

    public String setDepartment() {
        int x;

        System.out.println("Select New Hire's department code: ");
        System.out.println("1 Sales\n2 Development\n3 Accounting\n4 None");
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();

        if(x==1){return "Sales";}
        else if (x==2){return "Development";}
        else if(x==3){return "Accounting";}
        else {return "";}
    }

    Scanner scanFirst = new Scanner(System.in);
    Scanner scanLast = new Scanner(System.in);
    Scanner scanEmail = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    String first;
    String last;

    /**
     * This method is only an example on how to save informations.
     * I do recommend database or for indie projects, use File
     * to store all new hire info
     */
    public void ListLinkedList(LinkedList linkedList){

        String employeeList = "";

        for(int  i = 0; i<linkedList.size(); i++){

            employeeList += linkedList.get(i).toString();

        }

        System.out.println("List of new Hires: " + employeeList);
    }



    public void RegisterNewEmployee(){
        Email email;
        System.out.println("Please press any key to proceed. x to exit");
        while(!input.nextLine().equals("x")) {
            System.out.println("Please enter a new hire: ");
            first = scanFirst.nextLine();
            if(first.equals("x")){
                break;
            }
            last = scanLast.nextLine();
            if(last.equals("x")){
                break;
            }

            email = new Email(first, last);

            System.out.println("Enter alternate Email for " + email.getFirstName() + " " + email.getLastName());
            String alternateEmail = scanEmail.nextLine();


            email.setAlternateEmail(alternateEmail);

            System.out.println(email.getInfo(linkedList));
            System.out.println("Please press any key to proceed. x to exit");

            break;
        }

    }

    public String AccountDetails(){

        return passwordMod;

    }



}
