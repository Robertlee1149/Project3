package project3startup;

public class HayloCustomer {

    private String firstName;
    private String lastName;
    private String phone;
    private int nbrVehicles;
    private int nbrTanks;
    private double total;

    public HayloCustomer(String aFirstName, String aLastName, String aPhone, int aNbrVehicles, int aNbrTanks, double aTotal) {
        firstName = aFirstName;
        lastName = aLastName;
        phone = aPhone;
        nbrVehicles = aNbrVehicles;
        nbrTanks = aNbrTanks;
        total = aTotal;

    }

    //Uncomment these methods and create the code for them
    public String getFirstName() {
        return firstName;

    }

    public String getLastName() {
        return lastName;

    }

    public String getPhone() {
        return phone;

    }

    public int getNbrVehicles() {
        return nbrVehicles;

    }

    public int getNbrTanks() {
        return nbrTanks;

    }
    
    public double getTotal(){
        return total;
    }

    public String toString() {
        String result = "-----------------\n";
        result += "Customer First Name: " + firstName + "\n";
        result += "Customer Last Name: " + lastName + "\n";
        result += "Customer Phone: " + phone;

        return result;
    }
}
