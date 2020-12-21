package Server.GameRoom;


import Server.IPlayerSocket;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

public class GameRoom implements IGameRoom {
    private final Set<IPlayerSocket> playerSocketSet;
    private final UUID id;

    public GameRoom() {
        this.playerSocketSet = new LinkedHashSet<>();
        this.id = UUID.randomUUID();
    }

    @Override
    public void addPlayer(IPlayerSocket socket) {
        this.playerSocketSet.add(socket);
    }

    @Override
    public void removePlayer(IPlayerSocket socket) {
        this.playerSocketSet.remove(socket);
    }

    @Override
    public Set<IPlayerSocket> getPlayersSet() {
        return this.playerSocketSet;
    }

    @Override
    public UUID getId() {
        return this.id;
    }
}
