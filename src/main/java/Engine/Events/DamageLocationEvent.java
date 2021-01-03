package Engine.Events;

import Engine.Entities.InterfaceDamageableEntity;
import Engine.Utils.Location;

public class DamageLocationEvent implements InterfaceDamageLocationEvent {
    private final int damage;
    private final Location location;

    public DamageLocationEvent(final int damage, final Location location) {
        this.location = location;
        this.damage = damage;
    }

    @Override
    public void applyEffect(final InterfaceDamageableEntity entity) {
        entity.applyDamage(damage);
    }

    @Override
    public Location getLocation() {
        return this.location;
    }
}
