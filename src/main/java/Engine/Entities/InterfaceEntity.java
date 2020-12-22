package Engine.Entities;

import Engine.Utils.Location;

public interface InterfaceEntity {
    boolean canMoveHere();

    void setLocation(Location location);

    Location getLocation();
}
