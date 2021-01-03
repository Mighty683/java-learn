package Engine.Entities;

import Engine.Utils.Location;

public class EntityFactory {
    /**
     * Block instance creation by creating private constructor.
     */
    private EntityFactory() {
        throw new AssertionError();
    }

    public static Player createPlayer(final Location location, final int hp, final String playerName) {
        return new Player(location, hp, playerName);
    }
}
