package gui.abdullah;

public class Saletransaction {

    private int salespersonID;
    private String product;
    private double price;
    private int quantity;
    private String date;

    public Saletransaction(int salespersonID, String product, double price, int quantity, String date) {
        this.salespersonID = salespersonID;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
    }

    public int getSalespersonID() {
        return salespersonID;
    }

    public void setSalespersonID(int salespersonID) {
        this.salespersonID = salespersonID;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Saletransaction{" +
                "salespersonID=" + salespersonID +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
