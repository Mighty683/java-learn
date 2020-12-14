package Engine;

import Engine.Entities.Entity;
import Engine.Events.IMoveEvent;
import Engine.Events.LocationEvent;

import java.util.List;

public interface IEngine {
    void tick();
    void addEntity(Entity entity);
    void addLocationEvent(LocationEvent locationEvent);
    void addMoveEvent(IMoveEvent moveEvent);
}
