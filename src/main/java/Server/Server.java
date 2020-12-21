package Server;

import Server.GameRoom.GameRoom;
import Server.GameRoom.IGameRoom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.*;

public final class Server extends WebSocketGameServer implements AutoCloseable {
    Map<UUID, IGameRoom> gameRoomMap;

    public Map<UUID, IGameRoom> getGameRoomMap() {
        return gameRoomMap;
    }

    public Server(InetSocketAddress address) {
        super(address);
        this.gameRoomMap = new HashMap<>();
    }

    @Override
    public void close() throws IOException, InterruptedException {
        this.stop();
    }

    @Override
    public void onCommand(IPlayerSocket playerSocket, Command command) {
        if (command.command.equals(CommandsEnum.CREATE_GAME.toString())) {
            createGame(playerSocket);
        }
        if (command.command.equals(CommandsEnum.JOIN_GAME.toString())) {
            joinGame(command.data.get("id"), playerSocket);
        }
    }

    private void joinGame(String id, IPlayerSocket player) {
        IGameRoom gameRoom = gameRoomMap.get(UUID.fromString(id));
        if (gameRoom != null) {
            gameRoom.addPlayer(player);
        }
    }

    private void createGame(IPlayerSocket creator) {
        GameRoom newGame = new GameRoom();
        newGame.addPlayer(creator);
        gameRoomMap.put(newGame.getId(), newGame);
    }
}
