package Engine.Events;

import Engine.Entities.Player;
import Engine.Utils.Location;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class MoveEntityEventTest {
    @Test
    public void applyMoveEffect() {
        //given
        final Player playerMock = mock(Player.class);
        final Location newLocation = mock(Location.class);
        final MoveEntityEvent event = new MoveEntityEvent(newLocation, playerMock);
        //when
        event.applyMoveEffect();
        //then
        verify(playerMock, times(1)).move(newLocation);
    }
}
