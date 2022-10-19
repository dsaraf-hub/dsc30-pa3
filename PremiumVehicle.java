/**
 * PA03
 * @author Dakshh Saraf
 * @since  10/16/2022
 */


/**
 * PremiumVehicle class that implements the abstract Vehicle Class
 */
public class PremiumVehicle extends Vehicle{


    // Error message to use in OperationDeniedException
    private static final String INVALID_INPUT =
            "The input vehicle is not a premium vehicle.";
    private static final String [] PREMIUM_VEHICLE_BRAND =
            new String[] {"lamborghini", "ferrari", "bmw", "mercedes","audi"};
    private static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";

    /**
     * Constructor that initialises Vehicle name and Id
     * @param VehicleName the name to be given to the vehicle
     */
    public PremiumVehicle(String VehicleName) throws OperationDeniedException {
        super(VehicleName);
        this.vehicleID = 1;
        int ctr = 0;
        for (int i = 0; i < PREMIUM_VEHICLE_BRAND.length; i++){
            if (VehicleName.toLowerCase().contains(PREMIUM_VEHICLE_BRAND[i])){
                ctr = 1;
            }
        }
        if (ctr != 1) throw new OperationDeniedException();
    }

    /**
     * Adds the passenger to the vehicle
     * @param p Passenger to be added to the vehicle
     * @returns true if passenger added else false
     */
    public boolean addPassengerToVehicle(Passenger p) throws OperationDeniedException {
        if (p.getPassengerID() == 0) {
            throw new OperationDeniedException(DENIED_PASSENGER_GROUP);
        }
        if(currentPassengers.contains(p)){
            return false;
        }
        else{
            currentPassengers.add(p);
            return true;
        }
    }

    /**
     * Returns the Vehicle Information as an elaborate string
     * @returns the vehicle information as string
     */
    public String getVehicleInfo() {
        String out = this.getVehicleName() + " (Premium) [" + this.getDate() + "]: [";
        for (int i = 0; i < this.currentPassengers.size();i++) {
            out = out + currentPassengers.get(i).displayName();;
        }
        out = out + "]";
        return out;
    }
}
