package Engine;

import Engine.Entities.EntityFactory;
import Engine.Entities.Player;
import Engine.Events.DamageLocationEvent;
import Engine.Events.MoveEntityEvent;
import Engine.Utils.Location;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class EngineTest {
    @Mock
    Location location;
    @Test
    public void addingEntities() {
        //given
        Engine testedEngine = new Engine();
        Player player = EntityFactory.createPlayer(new Location(0, 0), 100, "Tomek");

        //when
        testedEngine.addEntity(player);

        //then
        assertThat(testedEngine.entities).contains(player);
    }
    @Test
    public void tickApplyEffects() {
        //given
        Engine testedEngine = new Engine();
        Player playerMock = mock(Player.class);
        DamageLocationEvent eventMock = mock(DamageLocationEvent.class);
        testedEngine.addEntity(playerMock);
        testedEngine.addLocationEvent(eventMock);

        //when
        testedEngine.tick();

        //then
        verify(eventMock, times(1)).applyEffect(playerMock);
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
