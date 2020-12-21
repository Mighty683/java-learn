package Server;

import Server.GameRoom.IGameRoom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class ServerTest {
    private final InetSocketAddress inetSocketAddressMock = mock(InetSocketAddress.class);

    @Nested
    @DisplayName("Testing Server Commands")
    public class CommandsTest {
        @Test
        void createGame() {
            //given
            Server testServer = new Server(inetSocketAddressMock);
            IPlayerSocket playerSocketMock = mock(IPlayerSocket.class);
            //when
            testServer.onCommand(
                    playerSocketMock,
                    new Command(
                            CommandsEnum.CREATE_GAME.toString(),
                            new HashMap<>()
                    )
            );
            //then
            assertThat(testServer.getGameRoomMap().values().iterator().next().getPlayersSet()).contains(playerSocketMock);
        }
        @Test
        void joinGame() {
            //given
            Server testServer = new Server(inetSocketAddressMock);
            IPlayerSocket playerSocketMock = mock(IPlayerSocket.class);
            IPlayerSocket playerJoiningSocketMock = mock(IPlayerSocket.class);
            testServer.onCommand(playerSocketMock, new Command(CommandsEnum.CREATE_GAME.toString(), new HashMap<>()));
            IGameRoom gameRoom = testServer.getGameRoomMap().values().iterator().next();
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("id", gameRoom.getId().toString());
            //when
            testServer.onCommand(
                    playerJoiningSocketMock,
                    new Command(
                            CommandsEnum.JOIN_GAME.toString(),
                            dataMap
                    )
            );
            //then
            assertThat(gameRoom.getPlayersSet()).contains(playerJoiningSocketMock);
        }
    }
}
