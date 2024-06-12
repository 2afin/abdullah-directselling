//DZURIYAT ILHAN BIN MOHD RIDZUAN 24000061

import java.util.ArrayList;
import java.util.List;

class SaleTransaction {
    private String product;
    private int quantity;
    private double price;
    private String date;

    // No-argument constructor
    public SaleTransaction() {
        product = "";
        quantity = 0;
        price = 0;
        date = "";
    }

    // Parameterized constructor
    public SaleTransaction(String product, int quantity, double price, String date) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    // Getters
    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    // Setters
    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

