package zus.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Voyage {

    private final int voyageId;
    private final int orbId;
    private LocalDate dateOfDeparture;
    private LocalTime timeOfDeparture;
    private String name;

    public Voyage(int voyageId, int orbId, LocalDate dateOfDeparture, LocalTime timeOfDeparture, String name) {
        this.voyageId = voyageId;
        this.orbId = orbId;
        this.dateOfDeparture = dateOfDeparture;
        this.timeOfDeparture = timeOfDeparture;
        this.name = name;
    }
}
