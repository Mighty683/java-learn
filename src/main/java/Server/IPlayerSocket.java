package Server;

import Engine.Entities.LivingEntity;
import org.java_websocket.WebSocket;

public interface IPlayerSocket {
    void sendMessage(String message);
}
