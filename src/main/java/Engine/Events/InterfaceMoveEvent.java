package Engine.Events;

import Engine.Utils.Location;

public interface InterfaceMoveEvent {
    void applyMoveEffect();

    Location getLocation();
}
