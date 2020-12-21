package Server;

import Engine.Entities.LivingEntity;
import org.java_websocket.WebSocket;

import java.util.Objects;

public class PlayerSocket implements IPlayerSocket {
    private final WebSocket socket;

    public PlayerSocket(WebSocket socket) {
        this.socket = socket;
    }

    @Override
    public void sendMessage(String message) {
        this.socket.send(message);
    }
}
