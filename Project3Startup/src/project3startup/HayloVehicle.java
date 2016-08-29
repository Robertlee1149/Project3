package project3startup;

public class HayloVehicle {

    private String type;
    private int nbrCells;
    private double vehicleCost;
    private double costPerTank;

    public HayloVehicle(String aType, int aNbrCells, double aVehicleCost, double aCostPerTank) {

        type = aType;
        nbrCells = aNbrCells;
        vehicleCost = aVehicleCost;
        costPerTank = aCostPerTank;

    }

    //uncomment these methods and write code for them
    public String getVehicleType() {
        return type;

    }

    public int getVehicleCells() {
        return nbrCells;

    }
    
    public double getVehicleCost(){
        return vehicleCost;
    }
    
    public double getCostPerTank(){
        return costPerTank;
    }
    

    public String toString() {
        String summary = "-------------\n";

        summary += "Vehicle Type: " + type + "\n";
        summary += "Vehicle Number of Cells: " + nbrCells + "\n";

        return summary;
    }
}
