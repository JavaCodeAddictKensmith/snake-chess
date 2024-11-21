package ecomstore;

import java.util.Scanner;

public class NormalUser extends  User{

    public  NormalUser(String name){
        super(name);
        this.operations = new IOOperation[]{
                new LikeProduct(),
                new UnlikeProduct(),
                new ViewProducts(),
                new ViewProductById(),
                new ViewProductsByCategory(),
                new AddProductToCart(),
                new RemoveProductFromCart(),

                new Exit()


        };
    }
    public NormalUser(int id,String name, String email, String phoneNumber,String type
    ) {
        super( name,email, phoneNumber, id,type);
        this.operations = new IOOperation[]{
                new LikeProduct(),
                new UnlikeProduct(),
                new ViewProducts(),
                new ViewProductById(),
                new ViewProductsByCategory(),
                new AddProductToCart(),
                new RemoveProductFromCart(),

                new Exit()



        };
    }
    @Override
    public  void menu(Database database, User user){


        System.out.println("1. Like Product");
        System.out.println("2. Add Product To Cart");
        System.out.println("3. Remove Product To Cart");
        System.out.println("4. Unlike product");
        System.out.println("5. View  sole Product");
        System.out.println("6. View product by Category");
        System.out.println("7. Exit");

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper(database, user);
        s.close();
    }


    public String toString() {
        return name+"<N/>" +email+"<N/>"+phoneNumber+"<N/>"+"Normal";
    }

}
