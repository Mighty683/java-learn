import Engine.EntityFactory;
import Engine.Player;

public class Game {
    public static void main(String[] args) {
        Player player = EntityFactory.createPlayer(0, 0, "Tomek");
        System.out.println(player.playerName + " " + player.name);
    }
}