package Engine.Entities;

import Engine.Utils.Location;

public abstract class Entity implements IEntity {
    private Location location;
    private String name;
    protected Entity(Location location, String name) {
        this.location = location;
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }
}
