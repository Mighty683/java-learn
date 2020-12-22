package Engine;

import Engine.Entities.InterfaceEntity;
import Engine.Events.InterfaceDamageLocationEvent;
import Engine.Events.InterfaceMoveEvent;
import Engine.Utils.DirectionEnum;

public interface InterfaceEngine {
    void tick();

    void addEntity(InterfaceEntity entity);

    void removeEntity(InterfaceEntity entity);

    void addDamageLocationEvent(InterfaceDamageLocationEvent locationEvent);

    void addMoveEvent(InterfaceMoveEvent moveEvent);

    void moveEntityInDirection(InterfaceEntity entity, DirectionEnum direction);
}
