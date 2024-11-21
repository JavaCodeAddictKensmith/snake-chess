package ecomstore;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner s;
    static Database database;
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        database = new Database();
        System.out.println(" Welcome to Library Management System!");

        int num;
        System.out.println(
                "0. Exit\n"
                        +"1. Login\n2. New User");
        s = new Scanner(System.in);
        num = s.nextInt();
        switch (num){
            case 1: login();break;
            case 2: newUser();break;


        }
    }
    private static void login(){
        System.out.println("Enter phone number");
        String phoneNumber= s.next();
        System.out.println("Enter email");
        String email = s.next();
        int n =database.login(phoneNumber,email);
        if(n != -1){
            System.out.println("-------------LOGGED IN SUCCESSFULLY-------------------------------");
            User user = database.getUser(n);
//            System.out.println("Welcome " + user.getName());
            user.menu(database,user);

        }else{
            System.out.println("User doesn't exist");
        }
    }
    private  static  void newUser(){
//        String name, String email, Double phoneNumber,String type
        System.out.println("Enter ID: ");
        int id = s.nextInt();
        System.out.println("Enter name");
        String name= s.next();
        if(database.userExists(name)){
            System.out.println("User exists!");
            newUser();
        }
        System.out.println("Enter phone number");
        String phoneNumber= s.next();
        System.out.println(" Enter email");
        String email = s.next();


        System.out.println("1. Admin\n2. Normal User");
        int n2 = s.nextInt();
        User user;
        if(n2==1){
            user = new Admin(id,name, email,phoneNumber,"Admin");


        }else{
            user = new NormalUser(id,name, email,phoneNumber,"Normal User");


        }
        database.AddUser(user);
        user.menu(database,user);


    }
}