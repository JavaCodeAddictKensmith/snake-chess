package ecomstore;

import java.util.ArrayList;

public class ViewProducts implements IOOperation {
    @Override
    public void oper(Database database, User user) {
//        ArrayList<Product> books = database.getAllBooks();
//        System.out.println("Name\t\tAuthor\t\tPublisher\tCLA\tQty\tPrice"+"\tBrw cps");
//        for(Product b:books){
//            System.out.println(b.getName()+"\t\t"+b.getAuthor() +"\t\t"+b.getPublisher()+"\t\t"+b.getAdress()+"\t"+b.getQty()+"\t"+b.getPrice()+"\t"+b.getBrwcopies());
//        }
//        System.out.println();
        user.menu(database,user);

    }
}
