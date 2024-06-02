package abdul;
import java.util.ArrayList;
import java.util.List;

class SaleTransaction {
    private String product;
    private int quantity;
    private double price;
    private String date;

    public SaleTransaction(String product, int quantity, double price, String date) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }

    // Getters and setters (if needed)
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
}

//DZURIYAT ILHAN BIN MOHD RIDZUAN 24000061