package Server;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public abstract class WebSocketGameServer extends org.java_websocket.server.WebSocketServer {
    private Map<WebSocket, IPlayerSocket> playerSockets;

    public WebSocketGameServer(InetSocketAddress address) {
        super(address);
        this.playerSockets = new HashMap<>();
    }

    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        this.playerSockets.put(webSocket, new PlayerSocket(webSocket));
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        this.playerSockets.remove(webSocket);
    }

    @Override
    public void onMessage(WebSocket webSocket, String message) {
        IPlayerSocket playerSocket = this.playerSockets.get(webSocket);
        if (playerSocket != null) {
            try {
                this.onCommand(playerSocket, Command.fromJSONString(message));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {

    }

    @Override
    public void onStart() {
        System.out.println("Server started");
    }

    public abstract void onCommand(IPlayerSocket playerSocket, Command command);
}
