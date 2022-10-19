/**
 * PA03
 * @author Dakshh Saraf
 * @since  10/16/2022
 */

/**
 * EconomyVehicle class that implements the abstract Vehicle Class
 */
public class EconomyVehicle extends Vehicle{

    /**
     * Constructor that initialises Vehicle name and Id
     * @param VehicleName the name to be given to the vehicle
     */
    public EconomyVehicle(String VehicleName) {
        super(VehicleName);
        this.vehicleID = 0;
    }

    /**
     * Adds the passenger to the vehicle
     * @param p Passenger to be added to the vehicle
     * @returns true if passenger added else false
     */
    public boolean addPassengerToVehicle(Passenger p){
        if(this.currentPassengers.contains(p)){
            return false;
        }
        else{
            this.currentPassengers.add(p);
            return true;
        }
    }

    /**
     * Returns the Vehicle Information as an elaborate string
     * @returns the vehicle information as string
     */
    public String getVehicleInfo() {
        String out =  this.getVehicleName() + " [" + this.getDate() + "]: [";
        for (int i = 0; i < this.currentPassengers.size();i++) {
            out = out + currentPassengers.get(i).displayName();
        }
        out = out + "]";
        return out;
    }
}
