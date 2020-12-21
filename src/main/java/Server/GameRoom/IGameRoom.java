package Server.GameRoom;

import Server.Server;

import Server.IPlayerSocket;

import java.util.Set;
import java.util.UUID;

public interface IGameRoom {
    void addPlayer(IPlayerSocket socket);

    void removePlayer(IPlayerSocket socket);

    Set<IPlayerSocket> getPlayersSet();

    UUID getId();
}
