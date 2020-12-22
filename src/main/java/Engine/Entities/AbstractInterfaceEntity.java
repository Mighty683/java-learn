package Engine.Entities;

import Engine.Utils.Location;

public abstract class AbstractInterfaceEntity implements InterfaceEntity {
    private Location location;
    private final String name;

    protected AbstractInterfaceEntity(final Location location, final String name) {
        this.location = location;
        this.name = name;
    }

    @Override
    public void setLocation(final Location location) {
        this.location = location;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }
}
