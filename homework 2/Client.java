//ABDULLAH SHAHIR BIN ZULMAJDI 24000112

public class Client {
    //DATA
    private Name name;
    private Address address;
    private String phoneNumber;
    private String salesperson;

    //Constructors are fundamental in Java for initializing objects and ensuring they are in a valid state when they are created.

    //DEFAULT CONSTRUCTOR
    public Client(){
        this.name = new Name();
        this.phoneNumber = "";
        this.salesperson = "";
        this.address = new Address();
    }

    //PARAMATERIZED CONSTRUCTOR
    public Client(Name name, String phoneNumber, String salesperson, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salesperson = salesperson;
        this.address = address;
    }

    //SETTER
    public void setName (Name name){
        this.name=name;
    }

    public void setNumber (String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public void setSales (String salesperson){
        this.salesperson=salesperson;
    }

    public void setAddress (Address address){
        this.address=address;
    }

    //GETTER
    public Name getName (){
        return name;
    }

    public String getNumber (){
        return phoneNumber;
    }

    public String getSales (){
        return salesperson;
    }

    public Address getAddress (){
        return address;
    }

    //METHODS
    public void printData() {
        System.out.println("Client{name='" + name + "', phoneNumber='" + phoneNumber + "', salesperson='" + salesperson + "', address='" + address + "'}");
    }
}