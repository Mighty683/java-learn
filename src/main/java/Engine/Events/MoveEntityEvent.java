package Engine.Events;

import Engine.Entities.InterfaceMovableEntity;
import Engine.Utils.Location;

public class MoveEntityEvent implements InterfaceMoveEvent {
    Location location;
    InterfaceMovableEntity entity;

    public MoveEntityEvent(final Location location, final InterfaceMovableEntity entity) {
        this.location = location;
        this.entity = entity;
    }

    @Override
    public void applyMoveEffect() {
        entity.move(location);
    }

    @Override
    public Location getLocation() {
        return this.location;
    }
}
