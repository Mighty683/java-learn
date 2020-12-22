import Server.Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;

public class Game {
    public static void main(final String[] args) {
        try (final Server server = new Server(new InetSocketAddress("localhost", 8080))) {
            server.start();
            final BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                final String in = sysin.readLine();
                if (in.equals("exit")) {
                    server.stop(1000);
                    break;
                }
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}