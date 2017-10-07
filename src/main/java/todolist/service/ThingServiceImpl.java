package todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todolist.dao.ThingDao;
import todolist.dao.ThingDaoImpl;
import todolist.model.Thing;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ThingServiceImpl implements ThingService {

    private ThingDao thingDao;

    public void setThingDao(ThingDao thingDao) {
        this.thingDao = thingDao;
    }

    @Override
    @Transactional
    public void addThing(Thing thing) {
        thingDao.addThing(thing);
    }

    @Override
    @Transactional
    public void updateThing(Thing thing) {
        thingDao.updateThing(thing);
    }

    @Override
    @Transactional
    public void removeThing(int id) {
        thingDao.removeThing(id);
    }

    @Override
    @Transactional
    public Thing getThingById(int id) {
        return thingDao.getThingById(id);
    }

    @Override
    @Transactional
    public List<Thing> getToDoList() {
        return thingDao.getToDoList();
    }
}
