package Server;

import java.util.Set;

public interface IGameRoom {
    void addPlayer(IPlayerSocket socket);
    void removePlayer(IPlayerSocket socket);
    Set<IPlayerSocket> getPlayersSet();
}
