package Engine.Entities;

import Engine.Utils.Location;

public abstract class AbstractInterfaceEntity implements InterfaceEntity {
    private final String name;
    private Location location;

    protected AbstractInterfaceEntity(final Location location, final String name) {
        this.location = location;
        this.name = name;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(final Location location) {
        this.location = location;
    }
}
