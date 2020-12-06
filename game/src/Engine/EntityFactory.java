package Engine;

public class EntityFactory {
    public static Player createPlayer(int x, int y, String playerName) {
        return new Player.Builder(x, y)
                .setPlayerName(playerName)
                .build();
    }
}
