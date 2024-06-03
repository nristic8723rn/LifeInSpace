package zus.model.base;

import zus.model.Person;
import zus.model.utility.JDBCUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Server {

    public static final Server SERVER = new Server();

    private final List<Person> people = new ArrayList<>();

    private Server() {
        this.setPeople(JDBCUtils.selectAllFromPerson());
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(Collection<Person> people) {
        this.people.clear();
        this.people.addAll(people);
    }

}
