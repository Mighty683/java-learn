package Engine.Events;

import Engine.Utils.Location;

public interface IMoveEvent {
    void applyMoveEffect();
    Location getLocation();
}
