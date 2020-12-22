package Engine;

import Engine.Entities.AbstractInterfaceEntity;
import Engine.Events.InterfaceDamageLocationEvent;
import Engine.Events.InterfaceMoveEvent;

public interface InterfaceEngine {
    void tick();

    void addEntity(AbstractInterfaceEntity entity);

    void addDamageLocationEvent(InterfaceDamageLocationEvent locationEvent);

    void addMoveEvent(InterfaceMoveEvent moveEvent);
}
