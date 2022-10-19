/*
  Name: Dakshh Saraf
  PID:  A15978430
 */

/**
 * PA03
 * @author Dakshh Saraf
 * @since  10/16/2022
 */
public class StandardPassenger extends Passenger{

    public StandardPassenger(String username, String bio){
        super(username, bio);
        this.passengerID = 0;
    }

    public String displayName() {
        return this.username;
    }
}
