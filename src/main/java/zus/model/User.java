package zus.model;

public class User {
    private String username;
    private String password;
    private String name;
    private String familyName;

    public User(String username, String password, String name, String familyName) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.familyName = familyName;
    }
}
