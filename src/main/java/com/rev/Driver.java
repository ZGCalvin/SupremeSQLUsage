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
        start.AddClasses(AppUsers.class);

        //Create Session Manager
        SessionManager sessionManager = start.createSessionManager();

        //Create Session
        Session session = sessionManager.getSession();

        //Print Method
        PrintSelect printSelect = new PrintSelect();

        //Create Loop Variables
        String loop = null;
        int switchex;

        //User Info
        String firstname;
        String lastname;
        String username;
        String password;
        String newpassword;
        int id;


        do{
            Scanner Switchscanner = new Scanner(System.in);
            System.out.println("Enter 1 to Register");
            System.out.println("Enter 2 for All Currently Active Users");
            System.out.println("Enter 3 for All Currently Active Users with id, username and password");
            System.out.println("Enter 4 to Update Password");
            System.out.println("Enter 5 to Delete an User");
            System.out.println("Enter 6 to Exit");
            System.out.print("--->> ");
            switchex = Switchscanner.nextInt();
            System.out.println("\n------------------------------\n");
            switch(switchex){

                case 1:
                    Scanner Userscanner = new Scanner(System.in);
                    System.out.println("Sign up for a new account!");
                    System.out.print("First Name: ");
                    firstname = Userscanner.nextLine();
                    firstname = firstname.trim();
                    System.out.print("Last Name: ");
                    lastname = Userscanner.nextLine();
                    lastname = lastname.trim();
                    System.out.println("\nUse MAX of 25 characters with a mix of letters, numbers & symbols");
                    System.out.print("Username: ");
                    username = Userscanner.nextLine();
                    username = username.trim();
                    System.out.print("Password: ");
                    password = Userscanner.nextLine();
                    password = password.trim();

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
                    firstname = firstname.trim();
                    System.out.print("Last Name: ");
                    lastname = newPassscanner.nextLine();
                    lastname = lastname.trim();
                    System.out.print("Username: ");
                    username = newPassscanner.nextLine();
                    username = username.trim();
                    System.out.print("Password: ");
                    password = newPassscanner.nextLine();
                    password = password.trim();
                    System.out.print("New Password: ");
                    newpassword = newPassscanner.nextLine();
                    newpassword = newpassword.trim();


                    AppUsers olduser = new AppUsers(firstname,lastname,username,password);
                    AppUsers newuser = new AppUsers(firstname,lastname,username,newpassword);
                    session.Update(olduser,newuser);
                    break;
                case 5:
                    Scanner Deletescanner = new Scanner(System.in);
                    System.out.print("First Name: ");
                    firstname = Deletescanner.nextLine();
                    firstname = firstname.trim();
                    System.out.print("Last Name: ");
                    lastname = Deletescanner.nextLine();
                    lastname = lastname.trim();
                    System.out.print("Username: ");
                    username = Deletescanner.nextLine();
                    username = username.trim();
                    System.out.print("Password: ");
                    password = Deletescanner.nextLine();
                    password = password.trim();
                    AppUsers deleteuser = new AppUsers(firstname,lastname,username,password);
                    session.Delete(deleteuser);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Not A Valid Selection!");
            }

            //loop Scanner
            Scanner loopscanner = new Scanner(System.in);
            System.out.println("\n\nLoop? Yes to loop or No to exit");
            System.out.print("--->> ");
            loop = loopscanner.nextLine();
            loop = loop.trim();

        }while(loop.equals("Yes") || loop.equals("yes"));

    }

}



