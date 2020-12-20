package Server;

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
            GameRoom testRoom = new GameRoom();
            IPlayerSocket mockPlayer = mock(IPlayerSocket.class);
            testRoom.addPlayer(mockPlayer);
            assertThat(testRoom.getPlayersSet()).contains(mockPlayer);
        }
        @Test
        void removingPlayer() {
            GameRoom testRoom = new GameRoom();
            IPlayerSocket mockPlayer = mock(IPlayerSocket.class);
            testRoom.addPlayer(mockPlayer);
            testRoom.removePlayer(mockPlayer);
            assertThat(testRoom.getPlayersSet()).doesNotContain(mockPlayer);
        }
        @Test
        void avoidDuplicates() {
            GameRoom testRoom = new GameRoom();
            IPlayerSocket mockPlayer = mock(IPlayerSocket.class);
            testRoom.addPlayer(mockPlayer);
            testRoom.addPlayer(mockPlayer);
            assertThat(testRoom.getPlayersSet()).contains(mockPlayer);
            assertThat(testRoom.getPlayersSet().size()).isEqualTo(1);
        }
    }
}
