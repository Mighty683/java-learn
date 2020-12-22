package Engine.Entities;

import Engine.Utils.Location;

public class Player extends AbstractInterfaceLivingEntity implements InterfacePlayer {
    private final String playerName;

    public Player(final Location location, final int hp, final String playerName) {
        super(location, "player", hp);
        this.playerName = playerName;
    }

    @Override
    public boolean canMoveHere() {
        return false;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }
}
