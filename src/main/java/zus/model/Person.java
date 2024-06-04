package zus.model;

import java.time.LocalDate;

public class Person {

    private final int personId;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private int housingID;
    private int orbID;

    public Person(int personId, String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateOfDeath, int housingID, int orbID) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.housingID = housingID;
        this.orbID = orbID;
    }

    public int getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
