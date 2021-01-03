import Server.Server;

public class Game {
    public static void main(String[] args) {
        try (Server gameServer = new Server()) {
            // TODO ?
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}