package Server;

public class Server implements AutoCloseable {
    private static final Server instance = new Server();
    public static Server getInstance() {
        return instance;
    }

    @Override
    public void close() throws Exception {
        // close connection
    }
}
