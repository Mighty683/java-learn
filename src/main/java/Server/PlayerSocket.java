package Server;

import org.java_websocket.WebSocket;

public class PlayerSocket implements IPlayerSocket {
    private final WebSocket socket;

    public PlayerSocket(final WebSocket socket) {
        this.socket = socket;
    }

    @Override
    public void sendMessage(final String message) {
        this.socket.send(message);
    }
}
