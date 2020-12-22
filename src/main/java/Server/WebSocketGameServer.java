package Server;

import Server.Command.Command;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public abstract class WebSocketGameServer extends org.java_websocket.server.WebSocketServer {
    private final Map<WebSocket, IPlayerSocket> playerSockets;

    public WebSocketGameServer(final InetSocketAddress address) {
        super(address);
        this.playerSockets = new HashMap<>();
    }

    @Override
    public void onOpen(final WebSocket webSocket, final ClientHandshake clientHandshake) {
        this.playerSockets.put(webSocket, new PlayerSocket(webSocket));
    }

    @Override
    public void onClose(final WebSocket webSocket, final int i, final String s, final boolean b) {
        this.playerSockets.remove(webSocket);
    }

    @Override
    public void onMessage(final WebSocket webSocket, final String message) {
        final IPlayerSocket playerSocket = this.playerSockets.get(webSocket);
        if (playerSocket != null) {
            try {
                this.onCommand(playerSocket, Command.fromJSONString(message));
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onError(final WebSocket webSocket, final Exception e) {

    }

    @Override
    public void onStart() {
        System.out.println("Server started");
    }

    public abstract void onCommand(IPlayerSocket playerSocket, Command command);
}
