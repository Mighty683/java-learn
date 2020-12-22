package Engine;

import Engine.Entities.InterfaceEntity;
import Engine.Events.InterfaceDamageLocationEvent;
import Engine.Events.InterfaceMoveEvent;

public interface InterfaceEngine {
    void tick();

    void addEntity(InterfaceEntity entity);

    void removeEntity(InterfaceEntity entity);

    void addDamageLocationEvent(InterfaceDamageLocationEvent locationEvent);

    void addMoveEvent(InterfaceMoveEvent moveEvent);
}
