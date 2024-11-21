package ecomstore;

import java.util.Arrays;

public abstract class User {

    protected  int id;
    protected  String name;
    protected  String email;
    protected  String phoneNumber;



    protected  String type;
    protected  IOOperation operations[];

    public  User(){}
    public  User(String name){
        this.name =name;
    }

    public User(String name, String email, String phoneNumber,int id,String type) {
        this.id= id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.type = type;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getPhoneNumber() {
        return phoneNumber;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    abstract  public  void menu(Database database, User user);
    abstract public String toString() ;



}
