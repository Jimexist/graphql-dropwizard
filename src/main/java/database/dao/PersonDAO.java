package database.dao;

import database.entity.Person;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

/**
 * Created by Shanshan Jiang on 4/10/2016.
 */
public class PersonDAO extends AbstractDAO<Person> {

    public PersonDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<Person> findById(int id) {
        return Optional.ofNullable(get(id));
    }

    public List<Person> findTop10() {
        Query query = currentSession().createQuery("from database.entity.Person");
        query.setMaxResults(10);
        return query.list();
    }
}
