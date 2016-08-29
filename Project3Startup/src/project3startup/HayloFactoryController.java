package project3startup;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class HayloFactoryController {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String firstName = "";
        String lastName = "";
        String phone = "";
        int nbrVehicles = 0;
        int nbrTanks = 0;
        double total = 0;
        //create variables to hold information collected from the user

        do {

            //collect the data entered by the user in 
            //variables
            String customerMsg = "Please enter the following separated by spaces"
                    + "\n\n"
                    + "- Customer First Name\n"
                    + "- Customer Last Name\n"
                    + "- Customer Phone\n"
                    + "- Number of Vehicles\n"
                    + "- Number of Tanks"
                    + "\n\n"
                    + "Example: Homer Simpson 9094559384 5 8\n\n";

            StringTokenizer tkCustomer = new StringTokenizer(
                    JOptionPane.showInputDialog(customerMsg));

            //store each token in the corresponding variable
            //Make sure we format integers
            //variablename = tkCustomer.nextToken();
            firstName = tkCustomer.nextToken();
            lastName = tkCustomer.nextToken();
            phone = tkCustomer.nextToken();
            nbrVehicles = Integer.parseInt(tkCustomer.nextToken());
            nbrTanks = Integer.parseInt(tkCustomer.nextToken());

            //validate each data entered here
            firstName = HayloValidate.getValidFirstName(firstName);
            lastName = HayloValidate.getValidLastName(lastName);
            phone = HayloValidate.getValidPhone(phone);
            nbrVehicles = HayloValidate.getValidNbrVehicles(nbrVehicles);
            nbrTanks = HayloValidate.getValidNbrTanks(nbrTanks);
            //Create a customer Object
            HayloCustomer customer = new HayloCustomer(firstName, lastName, phone, nbrVehicles, nbrTanks, total);

            //Present the customer with a choice of vehicles
            String[] choices = {"EV-EX 4", "EV-EX 6", "EV-DX 9", "EV-DX 12", "EV-SX 13"};

            int response = JOptionPane.showOptionDialog(
                    null // center over parent
                    , "Select a Vehicle type and Number of Fuel Cells" // message
                    , "Vehicle & Fuel Cell Selection" // title in titlebar
                    , JOptionPane.YES_NO_OPTION // Option type
                    , JOptionPane.PLAIN_MESSAGE // messageType
                    , null // icon
                    , choices // Options
                    , "APS 24" // initial value
            );
            //get the selection from the customer
            StringTokenizer tkVehicle = new StringTokenizer(choices[response]);

            //String[]vehicle = choices[response].split(" ");
            //int vehicleCells = Integer.parseInt(vehicle[1]);
            // String vehicleType = vehicle[0];
            //populate the vehicle variables
            String vehicleType;
            int vehicleCells;
            int vehicleCost;
            int tankCost;

            vehicleType = tkVehicle.nextToken();
            vehicleCells = Integer.parseInt(tkVehicle.nextToken());
            vehicleCost = Integer.parseInt(tkVehicle.nextToken());
            tankCost = Integer.parseInt(tkVehicle.nextToken());

            //??????????????????????
            //Create our vehicle object
            HayloVehicle vehicle = new HayloVehicle(vehicleType, vehicleCells, vehicleCost, tankCost);
            //Create our factory object
            HayloFactory factory = new HayloFactory(customer, vehicle);
            //ask the object to process the order
            factory.process();
            //write code below to display the result for each order
            //??????????????????????????????????????
        } while (JOptionPane.showConfirmDialog(null, "Enter More Orders?") == JOptionPane.YES_OPTION);

        //write code below to display the summary for all the orders
    }

}
