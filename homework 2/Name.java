//DANISH SAFIN BIN ZULKARNAIN 24000149

public class Name
{
    private String firstName;
    private String midName;
    private String lastName;

    public Name(){
        this.firstName = "";
        this.midName = "";
        this.lastName = "";
    }

    public Name(String firstName, String midName, String lastName) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
    }


    //setter
    public void setFirst (String firstName){
        this.firstName=firstName;
    }

    public void setMid (String midName){
        this.midName=midName;
    }

    public void setLast (String lastName){
        this.lastName=lastName;
    }

    //getter
    public String getFirst (){
        return firstName;
    }

    public String getMid (){
        return midName;
    }

    public String getLast (){
        return lastName;
    }

    public void printData() {
        System.out.println("First Name :'" + firstName + "', Middle Name :'" + midName + "', Last Name :'" + lastName );
        System.out.println("");
    }

    public String toString() {
        return firstName + midName + lastName;
    }
}