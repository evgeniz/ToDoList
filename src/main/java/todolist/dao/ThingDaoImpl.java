package todolist.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import todolist.model.Thing;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public class ThingDaoImpl implements ThingDao {

    private static final Logger logger = LoggerFactory.getLogger(ThingDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addThing(Thing thing) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(thing);
        logger.info(thing + " added successfully");
    }

    @Override
    public void updateThing(Thing thing) {
        Session session = sessionFactory.getCurrentSession();
        session.update(thing);
        logger.info(thing + " was updated");
    }

    @Override
    public void removeThing(int id) {
        Session session = sessionFactory.getCurrentSession();
        Thing thing = (Thing) session.load(Thing.class, id);

        if (thing != null)
            session.delete(thing);

        logger.info(thing + " successfully removed");
    }

    @Override
    public Thing getThingById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Thing thing = (Thing) session.load(Thing.class, id);
        logger.info(thing + " was loaded");

        return thing;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Thing> getToDoList() {
        Session session = sessionFactory.getCurrentSession();
        List<Thing> toDoList = session.createQuery("from Thing").list();
        logger.info(toDoList.toString());

        return toDoList;
    }
}
