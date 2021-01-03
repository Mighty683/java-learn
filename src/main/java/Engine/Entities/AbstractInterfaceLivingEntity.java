package Engine.Entities;

import Engine.Utils.Location;

/**
 * Skeleton implementation of interface
 */
public abstract class AbstractInterfaceLivingEntity extends AbstractInterfaceEntity implements InterfaceLivingEntity {
    private int hp;
    private boolean alive;

    protected AbstractInterfaceLivingEntity(final Location location, final String name, final int hp) {
        super(location, name);
        this.hp = hp;
    }

    @Override
    public void applyDamage(final int damage) {
        this.hp = this.hp - damage;
        this.alive = this.hp > 0;
    }

    @Override
    public void move(final Location location) {
        this.setLocation(location);
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public boolean isAlive() {
        return this.alive;
    }
}
