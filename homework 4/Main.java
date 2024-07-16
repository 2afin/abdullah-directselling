//DANISH SAFIN BIN ZULKARNAIN 24000149


public class Main {
    public static void main(String[] args) {
        SalesPersons meow = new SalesPersons();
        Clients woof = new Clients();
        SaleTransactions rawr = new SaleTransactions();

        meow.addSalesperson(2004, "aqil", "01122334854");
        meow.removeSalesperson(2004);

        woof.addClient("shahir", "0123883722", "Jalan kuciau", 1024);
        woof.removeClient("shahir");

        rawr.addSalesTransaction(12,"Cat",1,200.00, "2024-07-16",1024);
        rawr.removeSalesTransaction(12);

    }
}
