package abdul;
import java.util.ArrayList;
import java.util.List;

class SalesPerson {
    private String name;
    private String phoneNumber;
    private List<Object> salesTransactions;
    private List<Object> clients;

    public SalesPerson(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.salesTransactions = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public void addTransaction(Object transaction) {
    }

    public void removeTransaction(Object transaction) {
    }

    public void printTransactions() {
    }

    public Object findTransaction(Object criteria) {
        return null;
    }

    public void addClient(Object client) {
    }

    public void removeClient(Object client) {
    }

    public void printClients() {
    }

    public Object findClient(Object criteria) {
        return null;
    }

    public String toString() {
        return "SalesPerson name='" + name + "', phone Number='" + phoneNumber;
    }
}

//MUHAMMAD FAIQ HAKEEM BIN FARID 24000054
