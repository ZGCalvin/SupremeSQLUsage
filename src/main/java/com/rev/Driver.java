package com.rev;

import com.rev.models.Account;
import com.rev.models.AppUsers;
import com.rev.models.Transactions;


import session.Session;
import session.SessionManager;
import session.SessionStartup;
import util.PrintSelect;

import java.util.*;

public class Driver {

    public static void main(String[] args) {
        new Driver().Console();
    }

    private void Console(){
        //Create SessionStartup Object
        SessionStartup start = new SessionStartup();

        //Add Classes into SessionStartup
        start.AddClasses(AppUsers.class).AddClasses(Account.class).AddClasses(Transactions.class);

        //Create Session Manager
        SessionManager sessionManager = start.createSessionManager();

        //Create Session
        Session session = sessionManager.getSession();

        //Print Method
        PrintSelect printSelect = new PrintSelect();
        //Create Loop Variables
        String loop = null;
        int switchex;

        //New User Info
        String firstname;
        String lastname;
        String username;
        String password;
        String newpassword;


        do{
            Scanner Switchscanner = new Scanner(System.in);
            System.out.println("Press 1 for Register");
            System.out.println("Press 2 for All Currently Active Users");
            System.out.println("Press 3 for All Currently Active Users with id, username and password");
            System.out.println("Press 4 for Update Password");
            System.out.println("Press 5 for Delete an User");
            System.out.print("--->> ");
            switchex = Switchscanner.nextInt();
            System.out.println("\n------------------------------\n");
            switch(switchex){

                case 1:
                    Scanner Userscanner = new Scanner(System.in);
                    System.out.println("Sign up for a new account!");
                    System.out.print("First Name: ");
                    firstname = Userscanner.nextLine();
                    System.out.print("Last Name: ");
                    lastname = Userscanner.nextLine();
                    System.out.println("\nUse MAX of 25 characters with a mix of letters, numbers & symbols");
                    System.out.print("Username: ");
                    username = Userscanner.nextLine();
                    System.out.print("Password: ");
                    password = Userscanner.nextLine();

                    AppUsers newUsers = new AppUsers(firstname,lastname,username,password);
                    session.Insert(newUsers);
                    System.out.println("Registered!");
                    break;
                case 2:
                    printSelect.printRow(session.SelectFrom(new AppUsers(), "firstname","lastname","username"));
                    break;
                case 3:
                    printSelect.printRow(session.SelectAll(new AppUsers()));
                    break;
                case 4:
                    Scanner newPassscanner = new Scanner(System.in);
                    System.out.print("First Name: ");
                    firstname = newPassscanner.nextLine();
                    System.out.print("Last Name: ");
                    lastname = newPassscanner.nextLine();
                    System.out.print("Username: ");
                    username = newPassscanner.nextLine();
                    System.out.print("Password: ");
                    password = newPassscanner.nextLine();
                    System.out.print("New Password: ");
                    newpassword = newPassscanner.nextLine();

                    AppUsers olduser = new AppUsers(firstname,lastname,username,password);
                    AppUsers newuser = new AppUsers(firstname,lastname,username,newpassword);
                    session.Update(olduser,newuser);
                    break;
                case 5:
                    Scanner Deletescanner = new Scanner(System.in);
                    System.out.print("First Name: ");
                    firstname = Deletescanner.nextLine();
                    System.out.print("Last Name: ");
                    lastname = Deletescanner.nextLine();
                    System.out.print("Username: ");
                    username = Deletescanner.nextLine();
                    System.out.print("Password: ");
                    password = Deletescanner.nextLine();
                    AppUsers deleteuser = new AppUsers(firstname,lastname,username,password);
                    session.Delete(deleteuser);
                    break;
                default:
                    System.out.println("Not A Valid Selection!");
            }

            //loop Scanner
            Scanner loopscanner = new Scanner(System.in);
            System.out.println("\n\nLoop? Yes or No");
            System.out.print("--->> ");
            loop = loopscanner.nextLine();

        }while(loop.equals("yes") || loop.equals("Yes"));

    }

}



