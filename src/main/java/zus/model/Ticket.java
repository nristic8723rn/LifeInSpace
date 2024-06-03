package zus.model;

public class Ticket {

    private String username;
    private int voyageId;
    private int numberOfPassengers;

    public Ticket(String username, int voyageId, int numberOfPassengers) {
        this.username = username;
        this.voyageId = voyageId;
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getUsername() {
        return username;
    }

    public int getVoyageId() {
        return voyageId;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
}
