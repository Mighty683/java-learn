package Server.GameRoom;


import Engine.Engine;
import Engine.Entities.Player;
import Engine.InterfaceEngine;
import Engine.Utils.Location;
import Server.IPlayerSocket;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GameRoom implements IGameRoom {
    private final Map<IPlayerSocket, Player> playersMap;
    private final UUID id;
    private final InterfaceEngine gameEngine;

    public GameRoom() {
        this.gameEngine = new Engine();
        this.playersMap = new HashMap<>();
        this.id = UUID.randomUUID();
    }

    @Override
    public void addPlayer(final IPlayerSocket socket) {
        final Player playerGameEntity = new Player(new Location(0, 0), 100, socket.getName());
        this.gameEngine.addEntity(playerGameEntity);
        this.playersMap.put(socket, playerGameEntity);
    }

    @Override
    public void removePlayer(final IPlayerSocket socket) {
        this.gameEngine.removeEntity(this.playersMap.get(socket));
        this.playersMap.remove(socket);
    }

    @Override
    public Collection<IPlayerSocket> getPlayerSocketCollection() {
        return this.playersMap.keySet();
    }

    @Override
    public Collection<Player> getPlayerEntityCollection() {
        return this.playersMap.values();
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public void start() {
        // TODO: Threads work
        this.gameEngine.tick();
    }
}
