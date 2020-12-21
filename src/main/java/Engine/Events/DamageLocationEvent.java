package Engine.Events;

import Engine.Entities.IDamageableEntity;
import Engine.Utils.Location;

public class DamageLocationEvent extends LocationEvent {
    private final int damage;

    public DamageLocationEvent(int damage, Location location) {
        super(location);
        this.damage = damage;
    }

    @Override
    public void applyEffect(IDamageableEntity entity) {
        entity.applyDamage(damage);
    }

    @Override
    public Location getLocation() {
        return this.location;
    }
}
