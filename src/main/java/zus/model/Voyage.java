package zus.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Voyage {

    private final int voyageId;
    private final int orbId;
    private LocalDate dateOfDeparture;
    private LocalTime timeOfDeparture;
    private String name;
    private int capacity;
    public Voyage(int voyageId, int orbId, LocalDate dateOfDeparture, LocalTime timeOfDeparture, String name, int capacity) {
        this.voyageId = voyageId;
        this.orbId = orbId;
        this.dateOfDeparture = dateOfDeparture;
        this.timeOfDeparture = timeOfDeparture;
        this.name = name;
        this.capacity=capacity;
    }

    public int getVoyageId() {
        return voyageId;
    }

    public int getOrbId() {
        return orbId;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public LocalTime getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(LocalTime timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }
}

