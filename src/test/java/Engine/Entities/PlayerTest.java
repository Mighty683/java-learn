package Engine.Entities;

import Engine.Utils.Location;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class PlayerTest {
    @Test
    void canMoveHere() {
        final Player testPlayer = new Player(mock(Location.class), 100, "player-test");
        assertThat(testPlayer.canMoveHere()).isEqualTo(false);
    }

    @Test
    void getPlayerName() {
        final String name = "player-test";
        final Player testPlayer = new Player(mock(Location.class), 100, name);
        assertThat(testPlayer.getPlayerName()).isEqualTo(name);
    }
}