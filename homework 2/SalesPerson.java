//MUHAMMAD FAIQ HAKEEM BIN FARID 24000054

import java.util.ArrayList;
import java.util.List;

class SalesPerson {
    private Name name;
    private String phoneNumber;
    private List<SaleTransactions> salesTransactions;
    private List<Clients> clients;

    // constructor
    public SalesPerson() {
        this.name = new Name();  // Default Name object
        this.phoneNumber = "";
        this.salesTransactions = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public SalesPerson(Name name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salesTransactions = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    // setter
    public void setName(Name name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalesTransactions(List<SaleTransactions> salesTransactions) {
        this.salesTransactions = salesTransactions;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }

    // getter
    public Name getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<SaleTransactions> getSalesTransactions() {
        return salesTransactions;
    }

    public List<Clients> getClients() {
        return clients;
    }

    public String toString() {
        return "SalesPerson name='" + name.toString() + "', phone Number='" + phoneNumber + "'";
    }
}