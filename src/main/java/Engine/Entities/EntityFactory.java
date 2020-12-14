package Engine.Entities;

import Utils.Location;

public class EntityFactory {
    public static Player createPlayer(Location location, int hp, String playerName) {
        return new Player(location, hp, playerName);
    }

    /**
     * Block instance creation by creating private constructor.
     */
    private EntityFactory() {
        throw new AssertionError();
    }
}
