package Engine.Events;

import Engine.Entities.InterfaceMovableEntity;
import Engine.Utils.Location;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final MoveEntityEvent that = (MoveEntityEvent) o;
        return Objects.equals(location, that.location) && Objects.equals(entity, that.entity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, entity);
    }
}
