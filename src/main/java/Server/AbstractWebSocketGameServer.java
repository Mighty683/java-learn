package Server;

import Server.Command.Command;
import Server.Command.CommandFactory;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWebSocketGameServer extends org.java_websocket.server.WebSocketServer {
    private final Map<WebSocket, IPlayerSocket> playerSockets;
    private final CommandFactory commandFactory;

    public AbstractWebSocketGameServer(final InetSocketAddress address, final CommandFactory commandFactory) {
        super(address);
        this.playerSockets = new HashMap<>();
        this.commandFactory = commandFactory;
    }

    public Map<WebSocket, IPlayerSocket> getPlayerSockets() {
        return playerSockets;
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
                this.onCommand(playerSocket, commandFactory.fromJSONString(message));
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onError(final WebSocket webSocket, final Exception e) {
        // TODO: What can I do on error?
    }

    @Override
    public void onStart() {
        System.out.println("Server started");
    }

    public abstract void onCommand(IPlayerSocket playerSocket, Command command);
}
