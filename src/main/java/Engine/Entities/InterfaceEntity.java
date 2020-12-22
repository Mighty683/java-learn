package Engine.Entities;

import Engine.Utils.Location;

public interface InterfaceEntity {
    boolean canMoveHere();

    Location getLocation();

    void setLocation(Location location);
}
