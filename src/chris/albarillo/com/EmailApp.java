package chris.albarillo.com;

import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {
        Email email = new Email();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String newPass = "";

        System.out.println("Hello world. Please enter any key or x to exit");
        while (!scanner.nextLine().equals("x")){

            System.out.println("Selection: \n1. Register Employee \n2. Change Password");
            input = scanner.nextLine();

            switch (input){

                case "1":

                    email.RegisterNewEmployee();
                    break;

                case "2":
                    System.out.println("Please enter new password");
                    newPass = scanner.nextLine();

                    email.setPassword(newPass);

                    System.out.println("Account details: \n" + email.AccountDetails());

                    break;

                case "3":
                    //email.getInfo;
                    default:
                        break;



            }

            if(input.equals("x")){
                break;
            }

            System.out.println("Press any key to continue or enter x to exit");

        }


    }
}
