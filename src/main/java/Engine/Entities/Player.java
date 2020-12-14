package Engine.Entities;

import Engine.Utils.Location;

public class Player extends LivingEntity {
    public String playerName;

    @Override
    public boolean canMoveHere() {
        return false;
    }

    public Player(Location location, int hp, String playerName) {
        super(location, "player", hp);
        this.playerName = playerName;
    }
}
