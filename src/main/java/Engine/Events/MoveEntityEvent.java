package Engine.Events;

import Engine.Entities.IMovableEntity;
import Engine.Utils.Location;

public class MoveEntityEvent implements IMoveEvent {
    Location location;
    IMovableEntity entity;
    public MoveEntityEvent(Location location, IMovableEntity entity) {
        this.location = location;
        this.entity = entity;
    }

    @Override
    public void applyMoveEffect() {
        entity.move(location);
    }
}
