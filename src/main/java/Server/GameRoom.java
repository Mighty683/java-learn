package Server;

import java.util.LinkedHashSet;
import java.util.Set;

public class GameRoom implements IGameRoom {
    private final Set<IPlayerSocket> playerSocketSet;
    public GameRoom () {
        this.playerSocketSet = new LinkedHashSet<>();
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
}
