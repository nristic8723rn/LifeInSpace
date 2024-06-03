package zus.model;

public class HousingUnit {
    private final int housingUnitId;

    private final int orbId;

    private String username;

    private String name;

    public HousingUnit(int housingUnitId, int orbId, String username, String name) {
        this.housingUnitId = housingUnitId;
        this.orbId = orbId;
        this.username = username;
        this.name = name;
    }
}
