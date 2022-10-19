import java.util.ArrayList;

public class StandardRide implements RideScheduler{

    private final String MISMATCH_MSG =
            "Each passenger should have one vehicle matched.";
    private final String INVALID_ACTION =
            "Not able to perform proper assignment.";
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Passenger> passengers;
    private ArrayList<String> assignments;

    public StandardRide(){
        this.vehicles = new ArrayList<Vehicle>();
        this.passengers = new ArrayList<Passenger>();
        this.assignments = new ArrayList<String>();
    }


    public ArrayList<Vehicle> getVehicles() {
        return this.vehicles;
    }


    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }


    public boolean addPassenger(Passenger p) {
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
        if (passengers.size() != vehicles.size()){
            throw new OperationDeniedException(MISMATCH_MSG);
        }

        ArrayList<Passenger> standard_passengers = new ArrayList<Passenger>();
        ArrayList<Passenger> premium_passengers = new ArrayList<Passenger>();
        ArrayList<Vehicle> standard_vehicles = new ArrayList<Vehicle>();
        ArrayList<Vehicle> premium_vehicles = new ArrayList<Vehicle>();

        int number_of_sv = 0;
        int number_of_pv = 0;
        int number_of_sp = 0;
        int number_of_pp = 0;

        for (Passenger p : passengers) {
            if (p.passengerID == 0) {
                number_of_sp++;
                standard_passengers.add(p);
            } else {
                number_of_pp++;
                premium_passengers.add(p);
            }
        }

        for (Vehicle vehicle : vehicles) {
            if (vehicle.vehicleID == 0) {
                number_of_sv++;
                standard_vehicles.add(vehicle);
            } else {
                premium_vehicles.add(vehicle);
                number_of_pv++;
            }
        }

//        System.out.println(number_of_sv);
//        System.out.println(number_of_pv);
//
//        System.out.println(number_of_sp);
//        System.out.println(number_of_pv);

        if (number_of_sv < number_of_sp){
            throw new OperationDeniedException(INVALID_ACTION);
        }

        int ctr = 0;
        for (int i = 0; i < standard_passengers.size(); i++){
            standard_vehicles.get(i).addPassengerToVehicle(standard_passengers.get(i));
            String s = standard_vehicles.get(i).getVehicleInfo();
            assignments.add(s);
            ctr++;
        }

        int special = 0;
        for (int i = 0; i < premium_passengers.size(); i++) {
            if (ctr < number_of_sv) {
                standard_vehicles.get(ctr).addPassengerToVehicle(premium_passengers.get(i));
                String s = standard_vehicles.get(ctr).getVehicleInfo();
                assignments.add(s);
                ctr++;
            } else {
                premium_vehicles.get(special).addPassengerToVehicle(premium_passengers.get(i));
                String s = premium_vehicles.get(special).getVehicleInfo();
                assignments.add(s);
                special++;
            }
        }


    }

    public ArrayList<String> getRecords() {
        return assignments;
    }
}
