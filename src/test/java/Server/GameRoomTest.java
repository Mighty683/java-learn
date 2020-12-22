package Server;

import Server.GameRoom.GameRoom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class GameRoomTest {

    @Nested
    @DisplayName("Test player management")
    public class PlayerManagement {
        @Test
        void addingPlayer() {
            final GameRoom testRoom = new GameRoom();
            final IPlayerSocket mockPlayer = mock(IPlayerSocket.class);
            testRoom.addPlayer(mockPlayer);
            assertThat(testRoom.getPlayerSocketCollection()).contains(mockPlayer);
        }

        @Test
        void removingPlayer() {
            final GameRoom testRoom = new GameRoom();
            final IPlayerSocket mockPlayer = mock(IPlayerSocket.class);
            testRoom.addPlayer(mockPlayer);
            testRoom.removePlayer(mockPlayer);
            assertThat(testRoom.getPlayerSocketCollection()).doesNotContain(mockPlayer);
        }

        @Test
        void avoidDuplicates() {
            final GameRoom testRoom = new GameRoom();
            final IPlayerSocket mockPlayer = mock(IPlayerSocket.class);
            testRoom.addPlayer(mockPlayer);
            testRoom.addPlayer(mockPlayer);
            assertThat(testRoom.getPlayerSocketCollection()).contains(mockPlayer);
            assertThat(testRoom.getPlayerSocketCollection().size()).isEqualTo(1);
        }
    }
}
