package zus.model.utility;

import zus.App;
import zus.model.*;
import zus.model.base.Server;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
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
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zus3", properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Person> selectAllFromPerson() {
        List<Person> list = new ArrayList<>();
        String query = "select * from persons";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int personId = resultSet.getInt(1);
                int orbId = resultSet.getInt(2);
                int housingUnitId = resultSet.getInt(3);
                String firstName = resultSet.getString(4);
                String lastName = resultSet.getString(5);
                LocalDate dateOfBirth = resultSet.getDate(6).toLocalDate();
                LocalDate dateOfDeath = resultSet.getDate(7).toLocalDate();
                Person person = new Person(personId, firstName, lastName, dateOfBirth, dateOfDeath, housingUnitId, orbId);
                list.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void insertIntoPerson(int orbID, int housingUnitID,String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        String query = "insert into persons (orb_id, housing_unit_id,first_name, last_name, date_of_birth, date_of_death)" +
                "values (?,?,?, ?, str_to_date(?, '%m/%d/%Y'), str_to_date(?, '%m/%d/%Y'))";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            connection.setAutoCommit(false);
            statement.setInt(1,orbID);
            statement.setInt(2,housingUnitID);
            statement.setString(3, firstName);
            statement.setString(4, lastName);
            statement.setString(5,
                    dateOfBirth.getMonthValue() + "/" +
                    dateOfBirth.getDayOfMonth() + "/" + dateOfBirth.getYear());
            if(dateOfDeath !=null) {
                statement.setString(6, dateOfDeath.getMonthValue() + "/" +
                        dateOfDeath.getDayOfMonth() + "/" + dateOfDeath.getYear());
            }
            else
                statement.setString(6,null);
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
        String query = "select * from users where username like ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, kIme);
        ResultSet resultSet = statement.executeQuery();
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
        String query = "select * from users where username like ? and password like ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, kIme);
        statement.setString(2, lozinka);
        ResultSet resultSet = statement.executeQuery();
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

    public static List<HousingUnit> selectFromHousingUnits(String kIme) throws SQLException {
        List<HousingUnit> list = new ArrayList<>();
        String query = "select * from housingunits where username like ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, kIme);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next())
        {
            int orbId = resultSet.getInt(1);
            int housingUnitId = resultSet.getInt(2);
            String username = resultSet.getString(3);
            String name = resultSet.getString(4);

            HousingUnit housingUnit = new HousingUnit(housingUnitId, orbId, username, name);
            list.add(housingUnit);
        }
        return list;
    }

    public static List<Voyage> selectAllFromVoyages() throws SQLException {
        List<Voyage> list = new ArrayList<>();
        String query = "select v.* from voyages v left join ticket t on v.voyage_id = t.voyage_id and t.username = ? where t.voyage_id is null and v.capacity > 0";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, App.current.getUsername());
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next())
        {
            int voyageId = resultSet.getInt(1);
            int orbId = resultSet.getInt(2);
            LocalDate dod = resultSet.getDate(3).toLocalDate();
            LocalTime tod = resultSet.getTime(4).toLocalTime();
            String name = resultSet.getString(5);
            int capacity = resultSet.getInt(6);

            Voyage voyage = new Voyage(voyageId, orbId, dod, tod, name, capacity);
            list.add(voyage);
        }
        return list;
    }

    public static void insertIntoTicket(String kIme, int idVoyage, int noOfPassengers) throws SQLException {
        String query = "insert into ticket (username, voyage_id, number_of_passangers)" + "values(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        connection.setAutoCommit(false);
        statement.setString(1, kIme);
        statement.setInt(2,idVoyage);
        statement.setInt(3,noOfPassengers);
        statement.executeUpdate();
        connection.commit();
    }
    public static List<Ticket> selectFromTickets(String kIme) throws SQLException {
        List<Ticket> list = new ArrayList<>();
        String query = "select * from ticket where username like ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, kIme);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next())
        {
            String username = resultSet.getString(1);
            int voyageId = resultSet.getInt(2);
            int numberOfPassengers = resultSet.getInt(3);

            Ticket ticket = new Ticket(username, voyageId, numberOfPassengers);
            list.add(ticket);
        }
        return list;
    }

    public static List<Orb> selectFromOrbs() throws SQLException {
        List<Orb> list = new ArrayList<>();
        String query = "select * from orbs o left join (select orb_id from persons where date_of_death is not null and timestampdiff(year, date_of_birth, date_of_death) < 40 group by orb_id having count(person_id) > 20) p on o.orb_id = p.orb_id where p.orb_id is null and dist_to_star between 99 and 201 and lowest_temp between 149 and 251 and highest_temp between 249 and 351 and highest_temp-lowest_temp < 121 and o2_percentage between 14 and 26 and max_gravity > 999 and orbit_velocity between 24 and 36 and (o2_percentage + other_gasses) between 89 and 100";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while(resultSet.next())
        {
            int orbId= resultSet.getInt(1);
            String type = resultSet.getString(2);
            int distToStar = resultSet.getInt(3);
            int lowestTemp = resultSet.getInt(4);
            int highestTemp = resultSet.getInt(5);
            int o2Percentage = resultSet.getInt(6);
            int maxGravity = resultSet.getInt(7);
            int orbitVelocity = resultSet.getInt(8);
            String name = resultSet.getString(9);
            int otherGasses = resultSet.getInt(10);

            Orb orb = new Orb(orbId, type, distToStar, lowestTemp, highestTemp, o2Percentage, maxGravity, orbitVelocity, name, otherGasses);

            list.add(orb);
        }
        return list;
    }

    public static List<HousingUnit> selectHousingUnitsForOrb(int orbID) throws SQLException {
        List<HousingUnit> list = new ArrayList<>();
        String query = "select * from housingunits where orb_id = ? and username is null";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, orbID);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next())
        {
            int orbId = resultSet.getInt(1);
            int housingUnitId = resultSet.getInt(2);
            String username = resultSet.getString(3);
            String name = resultSet.getString(4);

            HousingUnit housingUnit = new HousingUnit(housingUnitId, orbId,username, name);
            list.add(housingUnit);
        }
        return list;
    }

    public static List<Person> selectFromPersonsUsingHousingUnits(int housingUnitID)
    {
        List<Person> list = new ArrayList<>();
        String query = "select * from persons where housing_unit_id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, housingUnitID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int personId = resultSet.getInt(1);
                int orbId = resultSet.getInt(2);
                int housingUnitId = resultSet.getInt(3);
                String firstName = resultSet.getString(4);
                String lastName = resultSet.getString(5);
                LocalDate dateOfBirth = resultSet.getDate(6).toLocalDate();
                LocalDate dateOfDeath = null;
                if(resultSet.getDate(7) != null)
                {
                    dateOfDeath = resultSet.getDate(7).toLocalDate();
                }
                Person person = new Person(personId, firstName, lastName, dateOfBirth, dateOfDeath, housingUnitId, orbId);
                list.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void insertUserIntoHousingUnit(String userName, int housingID) throws SQLException {
        String query = "update housingunits set username = ? where housing_unit_id = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, userName);
        statement.setInt(2, housingID);
        connection.setAutoCommit(false);
        statement.executeUpdate();
        connection.commit();
    }

    public static void updateVoyageCapacity(int voyageID, int noOfPassengers) throws SQLException {
        String query = "update voyages set capacity = (capacity - ?) where voyage_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        connection.setAutoCommit(false);
        statement.setInt(1, noOfPassengers);
        statement.setInt(2, voyageID);
        statement.executeUpdate();
        connection.commit();
    }

    public static Voyage selectVoyage(int voyageID) throws SQLException {
        String query = "select * from voyages where voyage_id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,voyageID);
        ResultSet resultSet = statement.executeQuery();
        Voyage voyage = null;
        if(resultSet.next())
        {
            int voyageId = resultSet.getInt(1);
            int orbId = resultSet.getInt(2);
            LocalDate dod = resultSet.getDate(3).toLocalDate();
            LocalTime tod = resultSet.getTime(4).toLocalTime();
            String name = resultSet.getString(5);
            int capacity = resultSet.getInt(6);

            voyage = new Voyage(voyageId, orbId, dod, tod, name, capacity);
        }
        return voyage;
    }

    private JDBCUtils() {

    }

}
