//DANISH SAFIN BIN ZULKARNAIN 24000149
//ABDULLAH SHAHIR BIN ZULMAJDI 24000112
//MUHAMMAD FAIQ HAKEEM BIN FARID 24000054
//DZURIYAT ILHAN BIN MOHD RIDZUAN 24000061
//AHMAD AQIL FAHMI BIN AHMAD NOR 24000235

public class Main
{
    public static void main(String[] args)
    {
        //Name CLASS
        Name name1 = new Name("Muhammad", " Faiq", " Hakeem");
        Name name2 = new Name();

        name2.setFirst("Aqil");
        name2.setMid(" Busuk");
        name2.setLast(" Sangat");

        //Address CLASS
        Address address1 = new Address("1234", "Jalan Ismail", "Taman Hijau", "Shah Alam", "Selangor", "15002");
        Address address2 = new Address();

        address2.setHousenumber("546");
        address2.setStreet("Jalan Jaguh");
        address2.setPark("Taman Ungku");
        address2.setCity("Skudai");
        address2.setState("Johor");
        address2.setZip("16300");

        //Client CLASS
        Client Client1 = new Client(name1, "012-345 6789", "Safin", address1);//PARAMATERIZE CONSTUCTOR
        Client Client2 = new Client();//DEFAULT CONSTRUCTOR

        Client2.printData();

        Client2.setName(name2);
        Client2.setNumber("011-345 8653");
        Client2.setSales("Dzuriat");
        Client2.setAddress(address2);

        Client1.printData();
        Client2.printData();

        System.out.println("");
        System.out.println("NAME OF CLIENT 1:"+Client1.getName());
        System.out.println("PHONE NUMBER OF CLIENT 1:"+Client1.getNumber());
        System.out.println("SALES PERSON OF CLIENT 1:"+Client1.getSales());
        System.out.println("ADDRESS OF CLIENT 1:"+Client1.getAddress());

        //Clients CLASS
        Clients ClientList = new Clients();//DEFAULT CONSTRUCTOR

        System.out.println("");
        System.out.println("Client 1 and Client 2 is added into list");
        ClientList.addClient(Client1);
        ClientList.addClient(Client2);
        ClientList.printClients();

        System.out.println("");
        System.out.println("Client 1 is remove from the list");
        ClientList.removeClient(Client1);
        ClientList.printClients();

        //---------------------------------------------------------------------------------------------

        SaleTransaction transaction1 = new SaleTransaction("Product1", 2, 10.0, "2024-05-01");
        SaleTransaction transaction2 = new SaleTransaction("Product2", 1, 20.0, "2024-05-02");
        SaleTransaction transaction3 = new SaleTransaction("Product3", 5, 5.0, "2024-05-03");

        // Create a SaleTransactions object
        SaleTransactions sales = new SaleTransactions();

        // Add transactions to the list
        System.out.println("");
        sales.add(transaction1);
        sales.add(transaction2);
        sales.add(transaction3);

        // Remove a transaction from the list
        sales.remove(transaction2);

        // Print all transactions
        sales.printTransactions();

        // Find a transaction by product name
        SaleTransaction foundTransaction = sales.find("Product1");
        if (foundTransaction != null) {
            System.out.println("Found Transaction: " +
                    "Product: " + foundTransaction.getProduct() +
                    ", Quantity: " + foundTransaction.getQuantity() +
                    ", Price: " + foundTransaction.getPrice() +
                    ", Date: " + foundTransaction.getDate());
        } else {
            System.out.println("Transaction not found");
        }

        //---------------------------------------------------------------------------------------------

        System.out.println("");
        Name name3 = new Name("Muhammad", " Danish", " Safin");
        SalesPerson sp1 = new SalesPerson(name3, "019876543");

        SalesPerson sp2 = new SalesPerson();
        Name name4 = new Name("Muhammad", "Lebron", "James");
        sp2.setName(name4);
        sp2.setPhoneNumber("0123456789");


        System.out.println("Name: " + sp1.getName().getFirst() + " " + sp1.getName().getMid() + " " + sp1.getName().getLast());
        System.out.println("Phone Number: " + sp1.getPhoneNumber());
        System.out.println("Name: " + sp2.getName().getFirst() + " " + sp2.getName().getMid() + " " + sp2.getName().getLast());
        System.out.println("Phone Number: " + sp2.getPhoneNumber());

        System.out.println(sp1);
        System.out.println(sp2);

        //---------------------------------------------------------------------------------------------

        System.out.println("");
        SalesPersons macai = new SalesPersons();

        macai.addsp(sp1);
        macai.addsp(sp2);
        macai.printsp();
        macai.removesp(sp1);
        macai.printsp();
        macai.printsp(macai.findsp("0123456789"));

    }
}
