package ecomstore;

import java.util.Scanner;

public class SearchProduct implements  IOOperation{
    @Override
    public void oper(Database database, User user) {
//        System.out.println("\nEnter the book name");
//        Scanner s = new Scanner(System.in);
//        String name = s.next();
//        int i = database.getBook(name);
//        if(i>-i){
//
//            System.out.println("\n"+database.getBook(i).toString()+"\n");
//        }else {
//            System.out.println("Book doesn't exist\n");
//        }
        user.menu(database,user);

    }
}
