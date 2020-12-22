package Server.GameRoom;

import Engine.Entities.Player;
import Server.IPlayerSocket;

import java.util.Collection;
import java.util.UUID;

public interface IGameRoom {
    void addPlayer(IPlayerSocket socket);

    void removePlayer(IPlayerSocket socket);

    Collection<IPlayerSocket> getPlayerSocketCollection();

    Collection<Player> getPlayerEntityCollection();

    UUID getId();

    void start();
}
