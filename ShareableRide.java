import java.util.ArrayList;

public class ShareableRide implements RideScheduler{

    private static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";
    private final String INVALID_ACTION =
            "Not able to perform proper assignment.";
    private final int CARPOOL_LIMIT = 5;

    private ArrayList<Vehicle> vehicles;
    private ArrayList<Passenger> passengers;
    private ArrayList<String> assignments;

    public ShareableRide(){
        this.vehicles = new ArrayList<Vehicle>();
        this.passengers = new ArrayList<Passenger>();
        this.assignments = new ArrayList<String>();
    }


    public ArrayList<Vehicle> getVehicles() {
        return this.vehicles;
    }


    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }


    public boolean addPassenger(Passenger p) throws OperationDeniedException {
        if (p.getClass().getName() == "ValuePassenger") {
            throw new OperationDeniedException(DENIED_PASSENGER_GROUP);
        }
        if(this.passengers.contains(p)){
            return false;
        }
        else{
            this.passengers.add(p);
            return true;
        }
    }


    public boolean addVehicle(Vehicle v) {
        if(this.vehicles.contains(v)){
            return false;
        }
        else{
            this.vehicles.add(v);
            return true;
        }
    }


    public void assignPassengerToVehicle() throws OperationDeniedException {
        /*TODO*/
    }


    public ArrayList<String> getRecords() {
        return this.assignments;
    }
}
