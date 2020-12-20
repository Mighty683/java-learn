package Server;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;

public class Server extends WebSocketGameServer implements AutoCloseable {
    Set<IGameRoom> gameRoomSet;
    public Server(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void close() {
        // close connection
    }

    @Override
    public void onCommand(IPlayerSocket playerSocket, Command command) {
        if(command.command.equals("create_game")) {
            createGame(playerSocket);
        }
    }

    private void createGame(IPlayerSocket creatorPlayer) {
        GameRoom newGame = new GameRoom();
        newGame.addPlayer(creatorPlayer);
    }
}
