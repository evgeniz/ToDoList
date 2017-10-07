package todolist.service;

import todolist.model.Thing;
import java.util.List;


public interface ThingService {

    void addThing(Thing thing);

    void updateThing(Thing thing);

    void removeThing(int id);

    Thing getThingById(int id);

    List<Thing> getToDoList();

}
