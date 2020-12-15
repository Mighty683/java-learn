package Engine.Events;

import Engine.Entities.IDamageableEntity;
import Engine.Entities.IMovableEntity;
import Engine.Utils.Location;

public interface IMoveEvent {
    void applyMoveEffect();
    Location getLocation();
}
