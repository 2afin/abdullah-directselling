//MUHAMMAD FAIQ HAKEEM BIN FARID 24000054

public class Address {

    //use string data type on house number to accomodate someone who lives in appartment
    private String housenumber;
    private String street;
    private String park;
    private String city;
    private String state;
    private String zip;

    public Address(){
        housenumber = "";
        street = "";
        park = "";
        city = "";
        state = "";
        zip = "";
    }

    public Address(String housenumber, String street, String park, String city, String state, String zip) {
        this.housenumber = housenumber;
        this.street = street;
        this.park = park;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getHousenumber() {
        return housenumber;
    }
    public String getPark() {
        return park;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZip() {
        return zip;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setPark(String park) {
        this.park = park;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String toString(){
        return housenumber + ", " + street +", " + park + ", " + city + ", " + state + ", " + zip;
    }

}