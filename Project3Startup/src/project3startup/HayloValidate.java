package project3startup;

import javax.swing.JOptionPane;

public class HayloValidate {

    //Add your validation methods here
    public static String getValidFirstName(String aFirstName) {

        while (isValidFirstName(aFirstName) == false) {
            aFirstName = JOptionPane.showInputDialog("Please Enter Valid First Name");
        }
        return aFirstName;

    }

    private static boolean isValidFirstName(String aFirstName) {
        boolean firstName = true;

        for (int i = 0; i < aFirstName.length(); i++) {
            if (Character.isLetter(aFirstName.charAt(i)) == false) {

                firstName = false;
            }

        }
        return firstName;

    }

    public static String getValidLastName(String aLastName) {

        while (isValidLastName(aLastName) == false) {
            aLastName = JOptionPane.showInputDialog("Please Enter Valid Last Name");
        }
        return aLastName;

    }

    private static boolean isValidLastName(String aLastName) {

        boolean lastName = true;

        for (int i = 0; i < aLastName.length(); i++) {
            if (Character.isLetter(aLastName.charAt(i)) == false) {

                lastName = false;
            }

        }
        return lastName;

    }

    public static String getValidPhone(String aPhone) {
        while (isValidPhone(aPhone) == false) {
            aPhone = JOptionPane.showInputDialog("Please Enter Valid Phone Number");
        }
        return aPhone;
    }

    public static boolean isValidPhone(String aPhone) {
        boolean result = false;

        try {
            if (aPhone.length() == 10) {
                result= true;
            }

        } catch (Exception ex) {
            result = false;
        }
        
        return  result;

    }

    public static int getValidNbrVehicles(int aNbrVehicles) {
        
        
        
        while (isValidNbrVehicles(aNbrVehicles)==false){
            String nbrVehicles;
            nbrVehicles = JOptionPane.showInputDialog("Please Enter Valid Number of Vehicles.");
            aNbrVehicles = Integer.parseInt(nbrVehicles);
        
        }
        return aNbrVehicles;
    }
    
    public static boolean isValidNbrVehicles(int aNbrVehicles){
        boolean result = false;
        
        try{
            if(aNbrVehicles >=2 && aNbrVehicles <=10 ){
                result = true;
            }
        }catch(Exception ex){
            result = false;
        }
        return result;
    }

    public boolean isValidNbrTanks(int aNbrTanks) {
        boolean nbrTanks = false;
        while (nbrTanks = false) {
            if (aNbrTanks == 2 || aNbrTanks == 4 || aNbrTanks == 8 || aNbrTanks == 8 || aNbrTanks == 10 || aNbrTanks == 15 || aNbrTanks == 20) {
                nbrTanks = true;
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter Valid Number of Tanks.");
            }

        }
        return nbrTanks;

    }

}
