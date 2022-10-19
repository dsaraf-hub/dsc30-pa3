/*
  Name: Dakshh Saraf
  PID:  A15978430
 */

/**
 * PA03
 * @author Dakshh Saraf
 * @since  10/16/2022
 */

/**
 * Abstract Passenger class to create a Passenger object
 */
public abstract class Passenger {

    // instance variables
    protected String username;
    protected String bio;
    protected int passengerID;

    /**
     * Constructor that initialises the username and bio
     * @param username the username of the passenger
     * @param bio the bio of the passenger
     */
    public Passenger(String username, String bio) {
        if (username == null || bio == null){
            throw new IllegalArgumentException();
        }
        this.username = username;
        this.bio = bio;
    }

    /**
     * Updates the bio to the new bio
     * @param newBio the new bio for the passenger
     */
    public void setBio(String newBio) {
        if (newBio == null){
            throw new IllegalArgumentException();
        } else {
            this.bio = newBio;
        }
    }

    /**
     * Used to display the bio of the passenger
     * @returns the bio in string format
     */
    public String displayBio() {
        return this.bio;
    }

    public Integer getPassengerID() {
        return this.passengerID;
    }

    public abstract String displayName();
}
