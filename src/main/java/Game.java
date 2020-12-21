import Server.Server;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Game {
    public static void main(String[] args) {
        try (Server server = new Server(new InetSocketAddress("localhost", 8080))) {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}