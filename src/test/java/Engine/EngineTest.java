package Engine;

import Engine.Entities.Player;
import Engine.Events.DamageLocationEvent;
import Engine.Events.MoveEntityEvent;
import Engine.Utils.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class EngineTest {
    private Location location;
    private Player playerMock;
    @BeforeEach
    public void setUp() {
        location = new Location(0,0);
        Player player = new Player(location, 100, "player-name");
        playerMock = spy(player);
    }
    @Test
    public void addingEntities() {
        //given
        Engine testedEngine = new Engine();

        //when
        testedEngine.addEntity(playerMock);

        //then
        assertThat(testedEngine.entities).contains(playerMock);
    }
    @Test
    public void tickApplyEffects() {
        //given
        Engine testedEngine = new Engine();
        Player secondPlayer = new Player(
                new Location(0,1),
                100,
                "player-event"
        );
        DamageLocationEvent damageEvent = new DamageLocationEvent(
                20,
                location
        );
        DamageLocationEvent damageEventSpy = spy(damageEvent);

        testedEngine.addLocationEvent(damageEventSpy);
        testedEngine.addEntity(playerMock);
        testedEngine.addEntity(secondPlayer);
        //when
        testedEngine.tick();

        //then
        verify(damageEventSpy, times(1)).applyEffect(playerMock);
        verify(damageEventSpy, never()).applyEffect(secondPlayer);
    }
    @Test
    public void tickMoveEffects() {
        //given
        Engine testedEngine = new Engine();
        MoveEntityEvent eventMock = mock(MoveEntityEvent.class);
        testedEngine.addMoveEvent(eventMock);
        //when
        testedEngine.tick();
        //then
        verify(eventMock, times(1)).applyMoveEffect();
    }
}
