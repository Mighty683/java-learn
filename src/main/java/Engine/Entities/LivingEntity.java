package Engine.Entities;

import Engine.Utils.Location;

public abstract class LivingEntity extends Entity implements IDamageableEntity, IMovableEntity {
    private int hp;
    private boolean alive;

    public LivingEntity(Location location, String name, int hp) {
        super(location, name);
        this.hp = hp;
    }

    @Override
    public void applyDamage(int damage) {
        this.hp = this.hp - damage;
        this.alive = this.hp > 0;
    }

    @Override
    public void move(Location location) {
        this.setLocation(location);
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return this.alive;
    }
}
