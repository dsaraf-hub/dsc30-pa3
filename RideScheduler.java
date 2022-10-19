import java.util.ArrayList;

/**
 * Interface for the Ride Scheduler
 */
public interface RideScheduler {
    ArrayList<Vehicle> getVehicles();
    ArrayList<Passenger> getPassengers();
    boolean addPassenger(Passenger p) throws OperationDeniedException;
    boolean addVehicle(Vehicle v);
    void assignPassengerToVehicle() throws OperationDeniedException;
    ArrayList<String> getRecords();
}
