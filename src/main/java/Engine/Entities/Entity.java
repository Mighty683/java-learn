package Engine.Entities;

import Utils.Location;

public abstract class Entity implements IEntity {
    public Location location;
    public String name;
    public Entity(Location location, String name) {
        this.location = location;
        this.name = name;
    }
}
