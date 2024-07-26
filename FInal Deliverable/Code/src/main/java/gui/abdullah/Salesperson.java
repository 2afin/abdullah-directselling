//DANISH SAFIN BIN ZULKARNAIN 24000149

package gui.abdullah;

public class Salesperson {

    private int salespersonID;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNo;

    public Salesperson(int salespersonID, String firstName, String lastName, String address, String phoneNo) {
        this.salespersonID = salespersonID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public int getSalespersonID() {
        return salespersonID;
    }
    public void setSalespersonID(int salespersonID) {
        this.salespersonID = salespersonID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "Salesperson{" +
                "salespersonID=" + salespersonID +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName +
                ", address=" + address +
                ", phoneNumber=" + phoneNo +
                '}';
    }
}
