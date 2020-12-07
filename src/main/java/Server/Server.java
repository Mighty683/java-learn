package Server;

public class Server  {
    private static final Server instance = new Server();
    public static Server getInstance() {
        return instance;
    }

    public void close() throws Exception {
        // close connection
    }
}
