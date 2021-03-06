package Server;

import Server.Command.Command;
import Server.Command.CommandFactory;
import Server.Command.PlayerCommandsEnum;
import Server.GameRoom.IGameRoom;
import org.junit.jupiter.api.BeforeEach;
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
    private Server testServer;

    @BeforeEach
    void setup() {
        testServer = new Server(inetSocketAddressMock, mock(CommandFactory.class));
    }

    @Nested
    @DisplayName("Testing Server Commands")
    public class CommandsTest {
        @Test
        void createGame() {
            //given
            final IPlayerSocket playerSocketMock = mock(IPlayerSocket.class);
            //when
            testServer.onCommand(
                    playerSocketMock,
                    new Command(
                            PlayerCommandsEnum.CREATE_GAME.toString(),
                            new HashMap<>()
                    )
            );
            //then
            assertThat(testServer.getGameRoomMap().values().iterator().next().getPlayerSocketCollection()).contains(playerSocketMock);
        }

        @Test
        void joinGame() {
            //given
            final IPlayerSocket playerSocketMock = mock(IPlayerSocket.class);
            final IPlayerSocket playerJoiningSocketMock = mock(IPlayerSocket.class);
            testServer.onCommand(playerSocketMock, new Command(PlayerCommandsEnum.CREATE_GAME.toString(), new HashMap<>()));
            final IGameRoom gameRoom = testServer.getGameRoomMap().values().iterator().next();
            final Map<String, String> dataMap = new HashMap<>();
            dataMap.put("id", gameRoom.getId().toString());
            //when
            testServer.onCommand(
                    playerJoiningSocketMock,
                    new Command(
                            PlayerCommandsEnum.JOIN_GAME.toString(),
                            dataMap
                    )
            );
            //then
            assertThat(gameRoom.getPlayerSocketCollection()).contains(playerJoiningSocketMock);
        }
    }
}
