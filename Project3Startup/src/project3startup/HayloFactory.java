package project3startup;

import java.text.NumberFormat;
import java.util.StringTokenizer;

public class HayloFactory {
    //Create our object variables (attributes)
    //variables to hold the user input

    private HayloCustomer customer;
    private HayloVehicle vehicle;

    //static field will apply to all objects
    //holds info about each vehicle
    //the pricing for vehicle and for fuel cells
    //will come from here
    private static String[] pricingSheet = {"EV-EX 4 500 10",
        "EV-EX 6 1000 13",
        "EV-DX 9 2000 8",
        "EV-DX 12 6000 12",
        "EV-SX 13 7000 18"};

    //private String owner;
    private int nbrVehicles;
    private int nbrTanks;
    private int nbrCell;
    private String vehicleType;
    private String firstName;
    private String lastName;
    private String phone;
    private double costPerTank;

    //constants to hold our pricing properties
    private double vehiclePrice;
    private double fuelCellPrice;

    //variables to hold the cost of
    //each process
    private double manufactureCost;
    private double tanksCost;
    private double vehicleCost;

    //variables to hold the results
    //of the calculations
    private double subtotal;
    private double tax;
    private double total;

    //Create constants for
    //items that are fixed and are not
    //going to change
    private final static double TAX_RATE = 0.0725;

    //hold our STATIC variables
    private static int totalOrders = 0;
    private static int totalVehicles = 0;
    private static int totalTanks = 0;
    private static double totalSales = 0;

    //Constructor
    public HayloFactory(HayloCustomer aCustomer, HayloVehicle aVehicle) {

        //initialize our local object variables
        //with the variables passed by the user
        //owner = anOwner;
        
        firstName = aCustomer.getFirstName();
        lastName = aCustomer.getLastName();
        phone = aCustomer.getPhone();
        vehicleType = aVehicle.getVehicleType();
        nbrCell = aVehicle.getVehicleCells();
        vehicleCost = aVehicle.getVehicleCost();
        costPerTank = aVehicle.getCostPerTank();
        nbrVehicles = aCustomer.getNbrVehicles();
        nbrTanks = aCustomer.getNbrTanks();
        total = aCustomer.getTotal();

        //Add code here to increment STATIC variables
        
        process();
        
        totalOrders++;
        totalVehicles += aCustomer.getNbrVehicles();
        totalTanks += aCustomer.getNbrTanks();
        totalSales += aCustomer.getTotal();

    }

    //Create methods to do
    //each calculation separately
    //this way we can follow the 
    //flow of execution
    //these methods are private and are
    //only accessible to the object itself
    //the controller class cannot execute them
    private void calcManufactureCost() {
        manufactureCost = nbrVehicles * vehicleCost;

    }

    private void calcTanksCost() {
        tanksCost = nbrVehicles * nbrTanks * nbrCell * costPerTank;

    }

    private void calcSubtotal() {
        subtotal = tanksCost + manufactureCost;

    }

    private void calcTax() {
        tax = subtotal * TAX_RATE;

    }

    private void calcTotal() {
        total = subtotal + tax;
    }

    //create method to get the pricing from pricingsheet
    //and assign it to vehicle price and fuelcell price
    private void getPricing() {

        StringTokenizer hf = null;
        for (int i = 0; i < pricingSheet.length; i++) {
            hf = new StringTokenizer(pricingSheet[i]);

            for (int j = 1; hf.hasMoreTokens(); j++) {
                if (j == 3) {
                    vehicleCost = Double.parseDouble(hf.nextToken());

                } else if (j == 4) {
                    costPerTank = Double.parseDouble(hf.nextToken());
                } else {
                    hf.nextToken();
                }
            }
        }

    }

    //create a public method 
    //to have the object process the order
    //this method is accessible 
    //from the controller class
    //The order is processed by 
    //executing the calculations
    //one at a time
    public void process() {
        calcManufactureCost();
        calcTanksCost();
        calcSubtotal();
        calcTax();
        calcTotal();
        getPricing();

    }

    //this public method is used to return 
    //a summary of this order this method 
    //is accessible from the controller class
    //we use the currency format to format
    //the results and display them as currency
    public String getSummary() {

        NumberFormat cf = NumberFormat.getCurrencyInstance();

        String summary = "Welcome to HAYLO Manufacturing\n\n Customer Information\n\n -------------------\n\n";
        summary += "Customer First Name: " + firstName + "\n";
        summary += "Customer Last Name: " + lastName + "\n";
        summary += "Customer Phone: " + phone + "\n";
        summary += "Number of Vehicles:" + nbrVehicles + "\n";
        summary += "Number of Tanks: " + nbrTanks + "\n\n";
        summary += "Vehicle Info\n";
        summary += "--------------\n";
        summary += "Vehicle Type: " + vehicleType + "\n";
        summary += "Vehicle Number of Cells: " + nbrCell + "\n\n\n";
        summary += "Vehicle Cost: (" + cf.format(vehicleCost) + "/Vehicle): " + cf.format(manufactureCost) + "\n";
        summary += "Tank Cost: (" + cf.format(costPerTank) + "/fuel cell): " + cf.format(tanksCost) + "\n";
        summary += "Subtotal: (" + cf.format(subtotal) + "\n";
        summary += "Tax(7.25%): " + cf.format(tax) + "\n";
        summary += "Total: " + cf.format(total);

        return summary;
    }

    //this public method is used to return
    //a summary of all the sales made int the store
    //it is a STATIC CLASS method
    public static String salesSummary() {

        //our number formatting
        NumberFormat cf = NumberFormat.getCurrencyInstance();

        String result = "+++==================+++  Sales Summary  +++==================+++\n\n\n\n";
        result += "Total Orders Processed: " + totalOrders + "\n";
        result += "Total Vehicles Purchased: " + totalVehicles + "\n";
        result += "Total Tanks Purchased: " + totalTanks + "\n\n";
        result += "Total Sales: " + cf.format(totalSales);

        return result;

    }
}
