package Server;

import Server.Command.CommandFactory;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.InetSocketAddress;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class AbstractWebSocketGameServerTest {
    AbstractWebSocketGameServer testServer;
    final WebSocket webSocketMock = mock(WebSocket.class);

    @BeforeEach
    void setup() {
        testServer = mock(
                AbstractWebSocketGameServer.class,
                Mockito.withSettings()
                        .useConstructor(mock(InetSocketAddress.class), mock(CommandFactory.class))
                        .defaultAnswer(CALLS_REAL_METHODS)
        );
        reset(webSocketMock);
    }

    @Test
    void onOpen() {
        //given
        //when
        testServer.onOpen(webSocketMock, mock(ClientHandshake.class));
        //then
        assertThat(testServer.getPlayerSockets().get(webSocketMock)).isNotNull();
    }

    @Test
    void onClose() {
        //given
        testServer.onOpen(webSocketMock, mock(ClientHandshake.class));
        //when
        testServer.onClose(webSocketMock, 1, "s", true);
        //then
        assertThat(testServer.getPlayerSockets().get(webSocketMock)).isNull();
    }

    @Nested
    class OnMessage {
        @Test
        void withOpenedSocket() {
            //given
            testServer.onOpen(webSocketMock, mock(ClientHandshake.class));
            //when
            testServer.onMessage(webSocketMock, "{}");
            //then
            verify(testServer, times(1)).onCommand(any(), any());
        }

        @Test
        void withNotOpenedSocket() {
            //when
            testServer.onMessage(webSocketMock, "{}");
            //then
            verify(testServer, never()).onCommand(any(), any());

        }
    }

    @Test
    void onError() {
    }

    @Test
    void onStart() {
    }
}