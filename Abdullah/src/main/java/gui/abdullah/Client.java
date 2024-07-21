package gui.abdullah;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {

    private final IntegerProperty salespersonId;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty address;
    private final StringProperty phoneNo;

    public Client(int salespersonId, String firstName, String lastName, String address, String phoneNo) {
        this.salespersonId = new SimpleIntegerProperty(salespersonId);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.address = new SimpleStringProperty(address);
        this.phoneNo = new SimpleStringProperty(phoneNo);
    }

    public IntegerProperty salespersonIdProperty() {
        return salespersonId;
    }

    public int getSalespersonId() {
        return salespersonId.get();
    }

    public void setSalespersonId(int salespersonId) {
        this.salespersonId.set(salespersonId);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty addressProperty() {
        return address;
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public StringProperty phoneNoProperty() {
        return phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo.get();
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo.set(phoneNo);
    }
}
