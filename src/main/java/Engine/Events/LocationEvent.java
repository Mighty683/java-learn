package Engine.Events;

import Utils.Location;

public abstract class LocationEvent implements IDamageEvent {
    public Location location;
    public LocationEvent (Location location) {
        this.location = location;
    }
}
