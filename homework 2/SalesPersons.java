//DANISH SAFIN BIN ZULKARNAIN 24000149

import java.util.*;
public class SalesPersons {

    private ArrayList<SalesPerson> meow;

    public SalesPersons() {
        this.meow = new ArrayList<>();
    }

    public SalesPersons(ArrayList<SalesPerson> meow) {
        this.meow = meow;
    }

    public void setSp(ArrayList<SalesPerson> meow) {
        this.meow = meow;
    }

    public ArrayList<SalesPerson> getSp() {
        return meow;
    }

    public void addsp(SalesPerson sp) {
        meow.add(sp);
    }

    public void removesp(SalesPerson sp) {
        meow.remove(sp);
    }

    public void printsp() {
        for (SalesPerson sp : meow) {
            System.out.println(sp);
        }
    }
    public void printsp(SalesPerson sp) {
        System.out.println(sp);
    }

    public SalesPerson findsp(String phoneNumber) {
        for (SalesPerson sp : meow) {
            if (sp.getPhoneNumber() == phoneNumber) {
                return sp;
            }
        }
        System.out.println("salesperson not found");
        return null;
    }
}

