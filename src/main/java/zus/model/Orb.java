package zus.model;

public class Orb {
    private int orbId;
    private String type;
    private int distToStar;
    private int lowestTemp;
    private int highestTemp;
    private int o2Percentage;
    private int maxGravity;
    private int orbitVelocity;
    private String name;

    public Orb(int orbId, String type, int distToStar, int lowestTemp, int highestTemp, int o2Percentage, int maxGravity, int orbitVelocity, String name) {
        this.orbId = orbId;
        this.type = type;
        this.distToStar = distToStar;
        this.lowestTemp = lowestTemp;
        this.highestTemp = highestTemp;
        this.o2Percentage = o2Percentage;
        this.maxGravity = maxGravity;
        this.orbitVelocity = orbitVelocity;
        this.name = name;
    }

    public int getOrbId() {
        return orbId;
    }

    public String getType() {
        return type;
    }

    public int getDistToStar() {
        return distToStar;
    }

    public int getLowestTemp() {
        return lowestTemp;
    }

    public int getHighestTemp() {
        return highestTemp;
    }

    public int getO2Percentage() {
        return o2Percentage;
    }

    public int getMaxGravity() {
        return maxGravity;
    }

    public int getOrbitVelocity() {
        return orbitVelocity;
    }

    public String getName() {
        return name;
    }
}
