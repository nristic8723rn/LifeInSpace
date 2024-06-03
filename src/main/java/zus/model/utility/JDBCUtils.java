package zus.model.utility;

import zus.model.Person;
import zus.model.User;
import zus.model.base.Server;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {

    public static Connection connection = null;

    public static void connect() {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zhus", properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Person> selectAllFromPerson() {
        List<Person> people = new ArrayList<>();
        String query = "select * from persons";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int personId = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                LocalDate dateOfBirth = resultSet.getDate(4).toLocalDate();
                Person person = new Person(personId, firstName, lastName, dateOfBirth);
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    public static void insertIntoPerson(String firstName, String lastName, LocalDate dateOfBirth) {
        String query = "insert into persons (first_name, last_name, date_of_birth)" +
                "values (?, ?, str_to_date(?, '%m/%d/%Y'))";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3,
                    dateOfBirth.getMonthValue() + "/" +
                    dateOfBirth.getDayOfMonth() + "/" + dateOfBirth.getYear());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertIntoUsers(String username, String password, String name, String familyName) throws SQLException {
        String query = "insert into users (username, password, name, family_name)" + "values(?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query);
        connection.setAutoCommit(false);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(3, name);
        statement.setString(4, familyName);
        statement.executeUpdate();
        connection.commit();
    }

    public static User checkUsers(String kIme) throws SQLException {
        String query = "select * from users where username like '" + kIme + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        User user = null;
        if(resultSet.next())
        {
            String userName = resultSet.getString(1);
            String password = resultSet.getString(2);
            String name = resultSet.getString(3);
            String familyName = resultSet.getString(4);

            user = new User(userName, password, name, familyName);
        }
        return user;
    }

    public static User checkPassword(String kIme, String lozinka) throws SQLException {
        String query = "select * from users where username like '" + kIme + "' and password like '" + lozinka + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        User user = null;
        if(resultSet.next()) {
            String userName = resultSet.getString(1);
            String password = resultSet.getString(2);
            String name = resultSet.getString(3);
            String familyName = resultSet.getString(4);

            user = new User(userName, password, name, familyName);
        }
        return user;
    }

    private JDBCUtils() {

    }

}
