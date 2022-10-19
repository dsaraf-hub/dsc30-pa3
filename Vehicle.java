/*
  Name: Dakshh Saraf
  PID:  A15978430
 */
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * PA03
 * @author Dakshh Saraf
 * @since  10/16/2022
 */

/**
 * Abstract Class to implement abstract class Vehicle
 */
public abstract class Vehicle {

    private LocalDate date;
    private final String vehicle;
    protected final ArrayList<Passenger> currentPassengers;
    protected final ArrayList<String> passengerNames;
    protected int vehicleID;

    public Vehicle(String VehicleName) {
        if (VehicleName ==  null){
            throw new IllegalArgumentException();
        } else {
            this.date = LocalDate.now();
            this.vehicle = VehicleName;
            this.currentPassengers = new ArrayList<Passenger>();
            this.passengerNames = new ArrayList<String>();
        }
    }

    public LocalDate getDate(){
        return this.date;
    }

    public String getVehicleName(){
        return this.vehicle;
    }

    public ArrayList<Passenger> getCurrentPassengers(){
        return this.currentPassengers;
    }

    public Integer getVehicleID() {
        return this.vehicleID;
    }

    public abstract boolean addPassengerToVehicle(Passenger p)
            throws OperationDeniedException;

    public abstract String getVehicleInfo();
}
