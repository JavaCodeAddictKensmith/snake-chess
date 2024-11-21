package ecomstore;

public class Product {

    private  int id;
    private String name;
    private int qty;
    private double price;
   	//Copies for borrowing

    public Product() {};

    public Product(int id,String name,
                  int qty, double price) {
        this.id=id;
        this.name = name;

        this.qty = qty;
        this.price = price;

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +

                ", qty=" + qty +
                ", price=" + price +
                '}';
    }
public int getId() {
    return id;
}

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



//    public String toString2() {
//        String text = name+"<N/>"+author+"<N/>"+publisher+"<N/>"+adress+"<N/>"+String.valueOf(qty)+
//                "<N/>"+String.valueOf(price)+"<N/>"+String.valueOf(brwcopies);
//        return text;
//    }

}
