package Server;

import Server.Command.Command;
import Server.Command.CommandFactory;
import Server.Command.PlayerCommandsEnum;
import Server.GameRoom.GameRoom;
import Server.GameRoom.IGameRoom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Server extends AbstractWebSocketGameServer implements AutoCloseable {
    private static final Logger LOGGER = Logger.getLogger(Server.class.getName());
    Map<UUID, IGameRoom> gameRoomMap;

    public Server(final InetSocketAddress address, final CommandFactory commandFactory) {
        super(address, commandFactory);
        this.gameRoomMap = new HashMap<>();
    }

    public Map<UUID, IGameRoom> getGameRoomMap() {
        return gameRoomMap;
    }

    @Override
    public void close() throws IOException, InterruptedException {
        this.stop();
    }

    @Override
    public void onCommand(final IPlayerSocket playerSocket, final Command command) {
        if (command.getCommand().equals(PlayerCommandsEnum.CREATE_GAME.toString())) {
            createGame(playerSocket);
        }
        if (command.getCommand().equals(PlayerCommandsEnum.JOIN_GAME.toString())) {
            joinGame(command.getData().get("id"), playerSocket);
        }
        logCommand(command);
    }

    private void joinGame(final String id, final IPlayerSocket player) {
        final IGameRoom gameRoom = gameRoomMap.get(UUID.fromString(id));
        if (gameRoom != null) {
            gameRoom.addPlayer(player);
        }
    }

    private void createGame(final IPlayerSocket creator) {
        final GameRoom newGame = new GameRoom();
        newGame.addPlayer(creator);
        gameRoomMap.put(newGame.getId(), newGame);
    }

    private void logCommand(final Command cmd) {
        LOGGER.log(Level.INFO, "Received command: " + cmd);
    }
}
