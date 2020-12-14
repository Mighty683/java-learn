package Engine.Events;

import Engine.Entities.Player;
import Engine.Utils.Location;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class DamageLocationEventTest {
    @Test
    public void applyDamageTest () {
        //given
        int damage = 20;
        Player playerMock = mock(Player.class);
        DamageLocationEvent event = new DamageLocationEvent(
                damage,
                mock(Location.class)
        );
        //when
        event.applyEffect(playerMock);
        //then
        verify(playerMock, times(1)).applyDamage(damage);
    }
}
