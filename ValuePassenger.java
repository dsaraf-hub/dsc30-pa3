/*
  Name: Dakshh Saraf
  PID:  A15978430
 */

/**
 * PA03
 * @author Dakshh Saraf
 * @since 10/16/2022
 */
public class ValuePassenger extends Passenger{

    // instance variable
    private String customTitle;

    public ValuePassenger(String username, String bio){
        super(username, bio);
        this.customTitle = "Value Passenger";
        this.passengerID = 1;
    }

    public String displayName() {
        return "<" + this.customTitle + "> " + this.username;
    }

    public void setCustomTitle(String newTitle) {
        this.customTitle = newTitle;
    }
}
