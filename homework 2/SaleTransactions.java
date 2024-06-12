//AHMAD AQIL FAHMI BIN AHMAD NOR 24000235

import java.util.ArrayList;
import java.util.List;

class SaleTransactions {
    private List<SaleTransaction> transactions;

    public SaleTransactions() {
        this.transactions = new ArrayList<>();
    }

    public void add(SaleTransaction saleTransaction) {
        this.transactions.add(saleTransaction);
    }

    public void remove(SaleTransaction saleTransaction) {
        this.transactions.remove(saleTransaction);
    }

    public void printTransactions() {
        for (SaleTransaction transaction : transactions) {
            System.out.println("Product: " + transaction.getProduct() +
                    ", Quantity: " + transaction.getQuantity() +
                    ", Price: " + transaction.getPrice() +
                    ", Date: " + transaction.getDate());
        }
    }

    public SaleTransaction find(String productName) {
        for (SaleTransaction transaction : transactions) {
            if (transaction.getProduct().equalsIgnoreCase(productName)) {
                return transaction;
            }
        }
        return null;
    }
}