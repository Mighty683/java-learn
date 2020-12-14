package Engine.Entities;

import Utils.Location;

public class LivingEntity extends Entity implements IDamageableEntity {
    private int hp;
    private boolean alive;

    public LivingEntity(Location location, String name, int hp) {
        super(location, name);
        this.hp = hp;
    }

    @Override
    public boolean canMoveHere() {
        return false;
    }

    @Override
    public void applyDamage(int damage) {
        this.hp = this.hp - damage;
        this.alive = this.hp > 0;
    }

    public boolean isAlive() {
        return this.alive;
    }
}
